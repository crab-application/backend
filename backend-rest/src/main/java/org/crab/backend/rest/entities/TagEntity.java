/* --------------------------------------------------------------------
 *  CRAB APPLICATION
 * --------------------------------------------------------------------
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, version 3.
 *
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package org.crab.backend.rest.entities;

import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;

import java.io.Serializable;
import java.util.Objects;
@NodeEntity
public class TagEntity implements Serializable , ClonableEntity<TagEntity>{


    // =========================================================================
    // ATTRIBUTES
    // =========================================================================
    private static final long serialVersionUID = -1790998381283249944L;
    @Id
    private String name;

    @Property
    private String title;

    // =========================================================================
    // CONSTRUCTORS
    // =========================================================================
    public TagEntity() {
    }
    public TagEntity(String name, String title) {
        this.name = name;
        this.title = title;
    }

    @Override
    public TagEntity clone() {
        return new TagEntity(name,title);
    }

    // =========================================================================
    // OVERRIDES
    // =========================================================================
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TagEntity tagEntity = (TagEntity) o;
        return Objects.equals(name, tagEntity.name) &&
                Objects.equals(title, tagEntity.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, title);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TagEntity{");
        sb.append("uid='")
          .append(name)
          .append('\'');
        sb.append(", title='")
          .append(title)
          .append('\'');
        sb.append('}');
        return sb.toString();
    }

    // =========================================================================
    // GETTERS & SETTERS
    // =========================================================================
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


}
