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
package com.facebook.presto.sql.tree;

import com.google.common.collect.ImmutableList;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static com.google.common.base.MoreObjects.toStringHelper;
import static java.util.Objects.requireNonNull;

/**
 * presto-root
 *
 * @author guodong
 */
public class CreateTableWithFiber
    extends DataDefinitionStatement
{
    private final QualifiedName name;
    private final List<TableElement> elements;
    private final String fibK;
    private final QualifiedName function;
    private final String timeK;

    public CreateTableWithFiber(
            QualifiedName name,
            List<TableElement> elements,
            String fibK,
            QualifiedName function,
            String timeK)
    {
        this(Optional.empty(), name, elements, fibK, function, timeK);
    }

    public CreateTableWithFiber(
            NodeLocation location,
            QualifiedName name,
            List<TableElement> elements,
            String fibK,
            QualifiedName function,
            String timeK)
    {
        this(Optional.of(location), name, elements, fibK, function, timeK);
    }

    private CreateTableWithFiber(
            Optional<NodeLocation> location,
            QualifiedName name,
            List<TableElement> elements,
            String fibK,
            QualifiedName function,
            String timeK)
    {
        super(location);
        this.name = requireNonNull(name, "table name is null");
        this.elements = ImmutableList.copyOf(requireNonNull(elements, "elements is null"));
        this.fibK = requireNonNull(fibK, "fiber key is null");
        this.function = requireNonNull(function, "function is null");
        this.timeK = requireNonNull(timeK, "timestamp key is null");
    }

    public QualifiedName getName()
    {
        return name;
    }

    public List<TableElement> getElements()
    {
        return elements;
    }

    public String getFibK()
    {
        return fibK;
    }

    public QualifiedName getFunction()
    {
        return function;
    }

    public String getTimeK()
    {
        return timeK;
    }

    @Override
    public <R, C> R accept(AstVisitor<R, C> visitor, C context)
    {
        return visitor.visitCreateTableWithFiber(this, context);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(name, elements, fibK, function, timeK);
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) {
            return true;
        }
        if ((obj == null) || (getClass() != obj.getClass())) {
            return false;
        }
        CreateTableWithFiber other = (CreateTableWithFiber) obj;
        return Objects.equals(name, other.name) &&
                Objects.equals(elements, other.elements) &&
                Objects.equals(fibK, other.fibK) &&
                Objects.equals(function, other.function) &&
                Objects.equals(timeK, other.timeK);
    }

    @Override
    public String toString()
    {
        return toStringHelper(this)
                .add("name", name)
                .add("elements", elements)
                .add("fiber key", fibK)
                .add("function", function)
                .add("timestamp key", timeK)
                .toString();
    }
}
