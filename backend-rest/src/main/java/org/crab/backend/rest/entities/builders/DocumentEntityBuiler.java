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
package org.crab.backend.rest.entities.builders;

import org.crab.backend.rest.entities.*;

import java.util.ArrayList;
import java.util.List;

public abstract class DocumentEntityBuiler<E extends DocumentEntity, B extends DocumentEntityBuiler> implements EntityBuilder {

    // =========================================================================
    // ATTRIBUTES
    // =========================================================================
    private Long                 id;
    private String               type;
    private String               title;
    private String               description;
    private List<TagEntity>      tags;
    private List<DocumentEntity> children;
    private List<VersionEntity>  versions;
    private String               image;
    private List<AuthorEntity>   authors;
    private List<MetadataEntity> metadata;

    // =========================================================================
    // ABSTRACT
    // =========================================================================
    public abstract E build();

    public abstract B createBuild();

    public abstract void cloneSpecificsEntityElements(final E entity, final B builder);

    protected abstract B getBuilder();


    public B clone(E entity) {
        final B builder = createBuild();

        builder.setId(entity.getId());
        builder.setTitle(entity.getTitle());
        builder.setType(entity.getType());
        builder.setDescription(entity.getDescription());
        builder.setTags(cloneEntities(entity.getTags()));
        builder.setChildren(cloneEntities(entity.getChildren()));
        builder.setVersions(cloneEntities(entity.getVersions()));
        builder.setImage(entity.getImage());
        builder.setAuthors(cloneEntities(entity.getAuthors()));
        builder.setMetadata(cloneEntities(entity.getMetadata()));

        cloneSpecificsEntityElements(entity, builder);

        return builder;
    }

    // =========================================================================
    // GETTERS & SETTERS
    // =========================================================================
    public Long getId() {
        return id;
    }

    public B setId(Long id) {
        this.id = id;
        return getBuilder();
    }

    public String getType() {
        return type;
    }

    public B setType(String type) {
        this.type = type;
        return getBuilder();
    }

    public String getTitle() {
        return title;
    }

    public B setTitle(String title) {
        this.title = title;
        return getBuilder();
    }

    public String getDescription() {
        return description;
    }

    public B setDescription(String description) {
        this.description = description;
        return getBuilder();
    }

    public List<TagEntity> getTags() {
        return tags;
    }

    public B setTags(List<TagEntity> tags) {
        this.tags = tags;
        return getBuilder();
    }

    public B addTag(final TagEntity tag) {
        if (this.tags == null) {
            this.tags = new ArrayList<>();
        }
        if (tag != null) {
            this.tags.add(tag);
        }
        return getBuilder();
    }

    public List<DocumentEntity> getChildren() {
        return children;
    }

    public B setChildren(List<DocumentEntity> children) {
        this.children = children;
        return getBuilder();
    }

    public B addChild(final DocumentEntity child) {
        if (this.children == null) {
            this.children = new ArrayList<>();
        }
        if (child != null) {
            this.children.add(child);
        }
        return getBuilder();
    }

    public List<VersionEntity> getVersions() {
        return versions;
    }

    public B setVersions(List<VersionEntity> versions) {
        this.versions = versions;
        return getBuilder();
    }

    public String getImage() {
        return image;
    }

    public B setImage(String image) {
        this.image = image;
        return getBuilder();
    }

    public List<AuthorEntity> getAuthors() {
        return authors;
    }

    public B setAuthors(List<AuthorEntity> authors) {
        this.authors = authors;
        return getBuilder();
    }

    public B addAuthor(final AuthorEntity author) {
        if (this.authors == null) {
            this.authors = new ArrayList<>();
        }
        if (author != null) {
            this.authors.add(author);
        }
        return getBuilder();
    }

    public List<MetadataEntity> getMetadata() {
        return metadata;
    }

    public B setMetadata(List<MetadataEntity> metadata) {
        this.metadata = metadata;
        return getBuilder();
    }
}
