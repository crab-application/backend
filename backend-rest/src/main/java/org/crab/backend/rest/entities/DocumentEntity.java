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
import java.util.List;
import java.util.Objects;

@NodeEntity
public class DocumentEntity implements Serializable, ClonableEntity<DocumentEntity> {
    // =========================================================================
    // ATTRIBUTES
    // =========================================================================
    private static final long                 serialVersionUID = 5088357164086232014L;

    @Id
    @GeneratedValue
    private              Long   id;
    @Property
    private              String type;
    @Property
    private              String title;
    @Property
    private              String description;

    @Relationship(type = "HAS_TAGS")
    private              List<TagEntity>      tags;

    @Relationship(type = "HAS_CHILDREN")
    private              List<DocumentEntity> children;

    @Relationship(type = "HAS_VERSIONS")
    private              List<VersionEntity>  versions;

    @Property
    private              String               image;

    @Relationship(type = "HAS_AUTHORS")
    private              List<AuthorEntity>   authors;

    @Relationship(type = "HAS_METADATA")
    private              List<MetadataEntity> metadata;

    // =========================================================================
    // CONSTRUCTORS
    // =========================================================================
    public DocumentEntity(){
    }

    public DocumentEntity(final Long id,
                          final String type,
                          final String title,
                          final String description,
                          final List<TagEntity> tags,
                          final List<DocumentEntity> children,
                          final List<VersionEntity> versions,
                          final String image,
                          final List<AuthorEntity> authors,
                          final List<MetadataEntity> metadata) {
        this.id = id;
        this.type = type;
        this.title = title;
        this.description = description;
        this.tags = tags;
        this.children = children;
        this.versions = versions;
        this.image = image;
        this.authors = authors;
        this.metadata = metadata;
    }

    @Override
    public DocumentEntity clone() {

        return new DocumentEntity(id,
                type,
                title,
                description,
                cloneEntities(tags),
                cloneEntities(children),
                cloneEntities(versions),
                image,
                cloneEntities(authors),
                cloneEntities(metadata));
    }

    // =========================================================================
    // OVERRIDES
    // =========================================================================
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final DocumentEntity that = (DocumentEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(type, that.type) &&
                Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, title);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("DocumentEntity{");
        sb.append("uid='")
          .append(id)
          .append('\'');
        sb.append(", type='")
          .append(type)
          .append('\'');
        sb.append(", title='")
          .append(title)
          .append('\'');
        sb.append(", description='")
          .append(description)
          .append('\'');
        sb.append(", tags=")
          .append(tags);
        sb.append(", children=")
          .append(children);
        sb.append(", versions=")
          .append(versions);
        sb.append(", image='")
          .append(image)
          .append('\'');
        sb.append(", authors=")
          .append(authors);
        sb.append(", metadata=")
          .append(metadata);
        sb.append('}');
        return sb.toString();
    }

    protected void childrenToString(final StringBuilder builder) {

    }

    // =========================================================================
    // GETTERS & SETTERS
    // =========================================================================
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<TagEntity> getTags() {
        return tags;
    }

    public void setTags(List<TagEntity> tags) {
        this.tags = tags;
    }

    public List<DocumentEntity> getChildren() {
        return children;
    }

    public void setChildren(List<DocumentEntity> children) {
        this.children = children;
    }

    public List<VersionEntity> getVersions() {
        return versions;
    }

    public void setVersions(List<VersionEntity> versions) {
        this.versions = versions;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<AuthorEntity> getAuthors() {
        return authors;
    }

    public void setAuthors(List<AuthorEntity> authors) {
        this.authors = authors;
    }

    public List<MetadataEntity> getMetadata() {
        return metadata;
    }

    public void setMetadata(List<MetadataEntity> metadata) {
        this.metadata = metadata;
    }


}
