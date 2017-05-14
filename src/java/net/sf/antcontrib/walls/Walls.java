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
package net.sf.antcontrib.walls;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created on Aug 24, 2003
 *
 * @author Dean Hiller (dean@xsoftware.biz)
 */
public class Walls {

    private final List<Package> packages = new LinkedList<Package>();
    private final Map<String, Package> nameToPackage = new HashMap<String, Package>();

    public Package getPackage(String name) {
        return nameToPackage.get(name);
    }

    public void addConfiguredPackage(Package p) {

        String pack = p.getPackage();
        if (!pack.endsWith(".*") && !pack.endsWith(".**"))
            p.setFaultReason("The package='" + pack + "' must end with "
                        + ".* or .** such as biz.xsoftware.* or "
                        + "biz.xsoftware.**");

        String[] depends = p.getDepends();
        if (depends == null) {
            nameToPackage.put(p.getName(), p);
            packages.add(p);
            return;
        }

        //make sure all depends are in Map first
        //circular references then are not a problem because they must
        //put the stuff in order
        for (String depend : depends) {
            Package dependsPackage = nameToPackage.get(depend);

            if (dependsPackage == null) {
                p.setFaultReason("package name=" + p.getName() + " did not have "
                        + depend + " listed before it and cannot compile without it");
            }
        }

        nameToPackage.put(p.getName(), p);
        packages.add(p);
    }

    public Iterator<Package> getPackagesToCompile() {
        //must return the list, as we need to process in order, so unfortunately
        //we cannot pass back an iterator from the hashtable because that would
        //be unordered and would break.
        return packages.iterator();
    }
}
