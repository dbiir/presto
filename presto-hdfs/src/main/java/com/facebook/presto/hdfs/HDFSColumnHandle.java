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

import com.facebook.presto.spi.ColumnHandle;
import com.facebook.presto.spi.type.Type;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import static java.util.Objects.requireNonNull;

/**
 * @author jelly.guodong.jin@gmail.com
 */
public class HDFSColumnHandle
implements ColumnHandle
{
    private final String name;
    private final Type type;
    private final String comment;
//    private final boolean isFiberCol;
//    private final boolean isTimeCol;

    @JsonCreator
    public HDFSColumnHandle(
            @JsonProperty("name") String name,
            @JsonProperty("type") Type type,
            @JsonProperty("comment") String comment)
//            @JsonProperty("isFiberCol") boolean isFiberCol,
//            @JsonProperty("isTimeCol") boolean isTimeCol)
    {
        this.name = requireNonNull(name, "name is null");
        this.type = requireNonNull(type, "type is null");
        this.comment = requireNonNull(comment, "comment is null");
//        this.isFiberCol = requireNonNull(isFiberCol, "isFiberCol is null");
//        this.isTimeCol = requireNonNull(isTimeCol, "isTimeCol is null");
    }

    @JsonProperty
    public String getName()
    {
        return name;
    }

    @JsonProperty
    public Type getType()
    {
        return type;
    }

    @JsonProperty
    public String getComment()
    {
        return comment;
    }

//    @JsonProperty
//    public boolean isFiberCol()
//    {
//        return isFiberCol;
//    }

//    @JsonProperty
//    public boolean isTimeCol()
//    {
//        return isTimeCol;
//    }
}
