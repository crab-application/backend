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

import org.neo4j.ogm.annotation.*;

import java.io.Serializable;
import java.util.Objects;
@NodeEntity
public class VersionEntity implements Serializable, ClonableEntity<VersionEntity> {

    // =========================================================================
    // ATTRIBUTES
    // =========================================================================
    private static final long serialVersionUID = 8729248822690352966L;

    @Id
    @GeneratedValue
    private Long id;

    @Property
    private long created;

    @Property
    private long version;

    @Property
    private String comment;

    @Property
    private boolean        published;

    @Relationship(type = "HAS_DOCUMENT")
    private DocumentEntity document;

    // =========================================================================
    // CONSTRUCTORS
    // =========================================================================
    public VersionEntity() {

    }

    public VersionEntity(final Long id,
                         final long created,
                         final long version,
                         final String comment,
                         final boolean published,
                         final DocumentEntity document) {
        this.id = id;
        this.created = created;
        this.version = version;
        this.comment = comment;
        this.published = published;
        this.document = document;
    }

    @Override
    public VersionEntity clone() {
        return new VersionEntity(id,
                created,
                version,
                comment,
                published,
                cloneEntity(document));
    }
    // =========================================================================
    // OVERRIDES
    // =========================================================================

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VersionEntity that = (VersionEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("VersionEntity{");
        sb.append("id='")
          .append(id)
          .append('\'');
        sb.append(", created=")
          .append(created);
        sb.append(", version=")
          .append(version);
        sb.append(", comment='")
          .append(comment)
          .append('\'');
        sb.append(", published=")
          .append(published);
        sb.append(", document=")
          .append(document);
        sb.append('}');
        return sb.toString();
    }

    // =========================================================================
    // GETTERS & SETTERS
    // =========================================================================s
    public Long getUid() {
        return id;
    }

    public void setUid(String uid) {
        this.id = id;
    }

    public long getCreated() {
        return created;
    }

    public void setCreated(long created) {
        this.created = created;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public boolean isPublished() {
        return published;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }

    public DocumentEntity getDocument() {
        return document;
    }

    public void setDocument(DocumentEntity document) {
        this.document = document;
    }


}
