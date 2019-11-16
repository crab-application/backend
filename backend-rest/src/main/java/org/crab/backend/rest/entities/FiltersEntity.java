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

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
@NodeEntity
public class FiltersEntity implements Serializable, ClonableEntity<FiltersEntity> {


    // =========================================================================
    // ATTRIBUTES
    // =========================================================================
    private static final long   serialVersionUID = -8414460933382806983L;
    @Id
    @GeneratedValue
    private              String uid;

    @Relationship(type = "HAS_FILTERS")
    private List<FilterEntity> filters;

    // =========================================================================
    // CONSTRUCTORS
    // =========================================================================
    public FiltersEntity() {
    }

    public FiltersEntity(String uid, List<FilterEntity> filters) {
        this.uid = uid;
        this.filters = filters;
    }

    @Override
    public FiltersEntity clone() {
        return new FiltersEntity(uid, cloneEntities(filters));
    }

    // =========================================================================
    // OVERRIDES
    // =========================================================================
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FiltersEntity that = (FiltersEntity) o;
        return Objects.equals(uid, that.uid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uid);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("FiltersEntity{");
        sb.append("uid='")
          .append(uid)
          .append('\'');
        sb.append(", filters=")
          .append(filters);
        sb.append('}');
        return sb.toString();
    }

    // =========================================================================
    // GETTERS & SETTERS
    // =========================================================================
    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public List<FilterEntity> getFilters() {
        return filters;
    }

    public void setFilters(List<FilterEntity> filters) {
        this.filters = filters;
    }


}
