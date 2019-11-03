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

import java.io.Serializable;
import java.util.Objects;

public class MetadataEntity implements Serializable {


    // =========================================================================
    // ATTRIBUTES
    // =========================================================================
    private static final long serialVersionUID = -1650257946353299519L;
    private String uid;
    private String name;
    private String value;

    // =========================================================================
    // OVERRIDES
    // =========================================================================
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MetadataEntity that = (MetadataEntity) o;
        return Objects.equals(uid, that.uid) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uid, name);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("MetadataEntity{");
        sb.append("uid='")
          .append(uid)
          .append('\'');
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
    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

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
