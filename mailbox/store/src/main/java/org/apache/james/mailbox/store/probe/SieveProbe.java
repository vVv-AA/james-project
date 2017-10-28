/****************************************************************
 * Licensed to the Apache Software Foundation (ASF) under one   *
 * or more contributor license agreements.  See the NOTICE file *
 * distributed with this work for additional information        *
 * regarding copyright ownership.  The ASF licenses this file   *
 * to you under the Apache License, Version 2.0 (the            *
 * "License"); you may not use this file except in compliance   *
 * with the License.  You may obtain a copy of the License at   *
 *                                                              *
 *   http://www.apache.org/licenses/LICENSE-2.0                 *
 *                                                              *
 * Unless required by applicable law or agreed to in writing,   *
 * software distributed under the License is distributed on an  *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY       *
 * KIND, either express or implied.  See the License for the    *
 * specific language governing permissions and limitations      *
 * under the License.                                           *
 ****************************************************************/

package org.apache.james.mailbox.store.probe;

import java.io.InputStream;

public interface SieveProbe {

    String EXTENSION_SIV = ".siv";
    String EXTENSION_SIEVE = ".sieve";

    long getSieveQuota() throws Exception;

    void setSieveQuota(long quota) throws Exception;

    void removeSieveQuota() throws Exception;

    long getSieveQuota(String user) throws Exception;

    void setSieveQuota(String user, long quota) throws Exception;

    void removeSieveQuota(String user) throws Exception;

    void addActiveSieveScript(String user, String toFileName, String content) throws Exception;

    InputStream getActive(String user) throws Exception;

    static String sanitizeScriptName(String fileName) {
        if (fileName.endsWith(EXTENSION_SIV) || fileName.endsWith(EXTENSION_SIEVE)) {
            return fileName;
        } else {
            return fileName + EXTENSION_SIEVE;
        }
    }

}