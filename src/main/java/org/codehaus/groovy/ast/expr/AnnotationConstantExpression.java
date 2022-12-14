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
package org.codehaus.groovy.ast.expr;

import org.codehaus.groovy.ast.AnnotationNode;
import org.codehaus.groovy.ast.GroovyCodeVisitor;

import java.util.Map;

/**
 * Represents an annotation "constant" that may appear in annotation attributes
 * (mainly used as a marker).
 */
public class AnnotationConstantExpression extends ConstantExpression {

    public AnnotationConstantExpression(final AnnotationNode node) {
        super(node);
        setType(node.getClassNode());
    }

    @Override
    public void visit(final GroovyCodeVisitor visitor) {
        super.visit(visitor); // GROOVY-9980

        AnnotationNode node = (AnnotationNode) getValue();
        Map<String, Expression> attrs = node.getMembers();
        for (Expression expr : attrs.values()) {
            expr.visit(visitor);
        }
    }

    @Override
    public String toString() {
        return super.toString() + "[" + getValue() + "]";
    }
}
