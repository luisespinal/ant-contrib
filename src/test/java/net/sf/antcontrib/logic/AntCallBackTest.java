/*
 * Copyright (c) 2001-2004 Ant-Contrib project.  All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.sf.antcontrib.logic;

import org.junit.Before;
import org.junit.Test;

import net.sf.antcontrib.BuildFileTestBase;

/**
 * Since AntCallBack is basically a copy and paste of antcall, the only testing
 * done here is on the extra features provided by antcallback. It is assumed
 * that changes to antcall will be propagated to antcallback and that antcall
 * has it's own unit tests (which turns out to have been a bad assumption,
 * I can't find any unit tests for antcall).
 *
 * @author <a href="mailto:danson@germane-software.com">Dale Anson</a>
 */
public class AntCallBackTest extends BuildFileTestBase {
    /**
     * The JUnit setup method.
     */
    @Before
    public void setUp() {
        configureProject("logic/antcallbacktest.xml");
    }

    /**
     * A unit test for JUnit.
     */
    @Test
    public void test1() {
        expectPropertySet("test1", "prop1", "prop1");
    }

    /**
     * A unit test for JUnit.
     */
    @Test
    public void test2() {
        expectPropertySet("test2", "prop1", "prop1");
        expectPropertySet("test2", "prop2", "prop2");
        expectPropertySet("test2", "prop3", "prop3");
    }

    /**
     * A unit test for JUnit.
     */
    @Test
    public void test3() {
        expectPropertySet("test3", "prop1", "prop1");
        expectPropertySet("test3", "prop2", "prop2");
        expectPropertySet("test3", "prop3", "prop3");
    }

    /**
     * A unit test for JUnit.
     */
    @Test
    public void test4() {
        expectPropertyUnset("test4", "prop1");
        expectPropertySet("test4", "prop2", "prop2");
        expectPropertySet("test4", "prop3", "prop3");
    }

    /**
     * A unit test for JUnit.
     */
    @Test
    public void test5() {
        expectPropertySet("test5", "prop1", "blah");
        expectPropertySet("test5", "prop2", "prop2");
        expectPropertySet("test5", "prop3", "prop3");
    }
}
