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
package net.sf.antcontrib.antclipse;

import net.sf.antcontrib.BuildFileTestBase;

import org.junit.Before;
import org.junit.Test;

/**
 * Basic test for "antclipse" task. For the moment it just launches the test xml script.
 * @author Adrian Spinei aspinei@myrealbox.com
 * @version $Revision: 1.2 $
 */
public class AntclipseTest extends BuildFileTestBase
{

	/* (non-Javadoc)
	 * @see org.junit.Before
	 */
	@Before
	public void setUp()
	{
		configureProject("antclipse/antclipsetest.xml");
	}

	/**
	 * Launches the "everything" task. Should not throw errors.
	 */
	@Test
	public void testExecuteDefaultBuild()
	{
		executeTarget("everything");
	}

}
