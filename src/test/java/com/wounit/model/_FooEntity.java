/**
 * Copyright (C) 2009 hprange <hprange@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

// $LastChangedRevision: 5773 $ DO NOT EDIT.  Make changes to FooEntity.java instead.
package com.wounit.model;

import com.webobjects.eoaccess.*;
import com.webobjects.eocontrol.*;
import com.webobjects.foundation.*;
import java.math.*;
import java.util.*;
import org.apache.log4j.Logger;

@SuppressWarnings("all")
public abstract class _FooEntity extends er.extensions.eof.ERXGenericRecord {
	public static final String ENTITY_NAME = "FooEntity";

	// Attributes
	public static final String BAR_KEY = "bar";
	public static final String TYPE_KEY = "type";

	// Relationships

  private static Logger LOG = Logger.getLogger(_FooEntity.class);

  public FooEntity localInstanceIn(EOEditingContext editingContext) {
    FooEntity localInstance = (FooEntity)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public String bar() {
    return (String) storedValueForKey("bar");
  }

  public void setBar(String value) {
    if (_FooEntity.LOG.isDebugEnabled()) {
    	_FooEntity.LOG.debug( "updating bar from " + bar() + " to " + value);
    }
    takeStoredValueForKey(value, "bar");
  }

  public Integer type() {
    return (Integer) storedValueForKey("type");
  }

  public void setType(Integer value) {
    if (_FooEntity.LOG.isDebugEnabled()) {
    	_FooEntity.LOG.debug( "updating type from " + type() + " to " + value);
    }
    takeStoredValueForKey(value, "type");
  }


  public static FooEntity createFooEntity(EOEditingContext editingContext) {
    FooEntity eo = (FooEntity) EOUtilities.createAndInsertInstance(editingContext, _FooEntity.ENTITY_NAME);    
    return eo;
  }

  public static NSArray<FooEntity> fetchAllFooEntities(EOEditingContext editingContext) {
    return _FooEntity.fetchAllFooEntities(editingContext, null);
  }

  public static NSArray<FooEntity> fetchAllFooEntities(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _FooEntity.fetchFooEntities(editingContext, null, sortOrderings);
  }

  public static NSArray<FooEntity> fetchFooEntities(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    EOFetchSpecification fetchSpec = new EOFetchSpecification(_FooEntity.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<FooEntity> eoObjects = (NSArray<FooEntity>)editingContext.objectsWithFetchSpecification(fetchSpec);
    return eoObjects;
  }

  public static FooEntity fetchFooEntity(EOEditingContext editingContext, String keyName, Object value) {
    return _FooEntity.fetchFooEntity(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static FooEntity fetchFooEntity(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<FooEntity> eoObjects = _FooEntity.fetchFooEntities(editingContext, qualifier, null);
    FooEntity eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = (FooEntity)eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one FooEntity that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static FooEntity fetchRequiredFooEntity(EOEditingContext editingContext, String keyName, Object value) {
    return _FooEntity.fetchRequiredFooEntity(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static FooEntity fetchRequiredFooEntity(EOEditingContext editingContext, EOQualifier qualifier) {
    FooEntity eoObject = _FooEntity.fetchFooEntity(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no FooEntity that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static FooEntity localInstanceIn(EOEditingContext editingContext, FooEntity eo) {
    FooEntity localInstance = (eo == null) ? null : (FooEntity)EOUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
