/*
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
package com.facebook.presto.hdfs;

import com.facebook.presto.hdfs.metaserver.MetaServer;
import com.google.inject.Inject;
//import io.airlift.log.Logger;

import static java.util.Objects.requireNonNull;

/**
 * @author jelly.guodong.jin@gmail.com
 */
public class HDFSMetadataFactory
{
    private final HDFSConnectorId connectorId;
    private final MetaServer metaServer;

    @Inject
    public HDFSMetadataFactory(HDFSConnectorId connectorId, MetaServer metaServer)
    {
        this.connectorId = requireNonNull(connectorId, "connectorId is null");
        this.metaServer = requireNonNull(metaServer, "metaServer is null");
    }

    public HDFSMetadata create()
    {
        return new HDFSMetadata(metaServer, connectorId);
    }

    public void shutdown()
    {
        metaServer.shutdown();
    }
}
