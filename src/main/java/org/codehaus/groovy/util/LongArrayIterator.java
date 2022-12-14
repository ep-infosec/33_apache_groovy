/*
 *  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */
package org.codehaus.groovy.util;

import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Allow a long array to be used where an Iterator is expected.
 *
 * @since 3.0.8
 */
public class LongArrayIterator implements Iterator<Long> {
    private final long[] array;
    private final int length;
    private int index;

    public LongArrayIterator(long[] array) {
        this.array = array;
        length = Array.getLength(array);
    }

    @Override
    public boolean hasNext() {
        return index < length;
    }

    @Override
    public Long next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return array[index++];
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Remove not supported for arrays");
    }
}
