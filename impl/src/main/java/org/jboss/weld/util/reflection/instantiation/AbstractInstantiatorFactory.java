/*
 * JBoss, Home of Professional Open Source
 * Copyright 2012, Red Hat, Inc., and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jboss.weld.util.reflection.instantiation;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstract instantiator factory.
 *
 * @author Ales Justin
 */
public abstract class AbstractInstantiatorFactory implements InstantiatorFactory {
    private static final List<Instantiator> instantiators = new ArrayList<Instantiator>() {
        {
            add(new UnsafeInstantiator());
            add(new ReflectionFactoryInstantiator());
        }
    };

    protected static final String MARKER = "META-INF/org.jboss.weld.enableUnsafeProxies";

    protected boolean checkInstantiator() {
        for (Instantiator i : instantiators) {
            if (i.isAvailable()) {
                instantiator = i;
                return true;
            }
        }
        return false;
    }

    private Instantiator instantiator;

    public Instantiator getInstantiator() {
        return instantiator;
    }
}
