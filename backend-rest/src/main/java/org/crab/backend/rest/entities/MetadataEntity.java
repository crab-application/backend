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
public class MetadataEntity implements Serializable, ClonableEntity<MetadataEntity> {


    // =========================================================================
    // ATTRIBUTES
    // =========================================================================
    private static final long serialVersionUID = -1650257946353299519L;
    @Id
    private String name;
    @Property
    private String value;

    // =========================================================================
    // CONSTRUCTORS
    // =========================================================================
    public MetadataEntity() {
    }

    public MetadataEntity( final String name, final String value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public MetadataEntity clone() {
        return new MetadataEntity(name, value);
    }

    // =========================================================================
    // OVERRIDES
    // =========================================================================
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MetadataEntity that = (MetadataEntity) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash( name);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("MetadataEntity{");
        sb.append(", name='")
          .append(name)
          .append('\'');
        sb.append(", value='")
          .append(value)
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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }


}
