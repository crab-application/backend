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

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.Relationship;

import java.util.List;
@NodeEntity
public class SectionEntity extends DocumentEntity  {


    // =========================================================================
    // ATTRIBUTES
    // =========================================================================
    private static final long serialVersionUID = 3280709182901047938L;

    @Property
    private boolean       main;

    @Relationship(type = "HAS_FILTER")
    private FiltersEntity filters;


    // =========================================================================
    // CONSTRUCTORS
    // =========================================================================
    public SectionEntity() {
    }

    public SectionEntity(Long id,
                         String type,
                         String title,
                         String description,
                         List<TagEntity> tags,
                         List<DocumentEntity> children,
                         List<VersionEntity> versions,
                         String image,
                         List<AuthorEntity> authors,
                         List<MetadataEntity> metadata,
                         boolean main,
                         FiltersEntity filters) {
        super(id,
                type,
                title,
                description,
                tags,
                children,
                versions,
                image,
                authors,
                metadata);
        this.main = main;
        this.filters = filters;
    }

    @Override
    public SectionEntity clone() {
        return new SectionEntity(getId(),
                getType(),
                getTitle(),
                getDescription(),
                cloneEntities(getTags()),
                cloneEntities(getChildren()),
                cloneEntities(getVersions()),
                getImage(),
                cloneEntities(getAuthors()),
                cloneEntities(getMetadata()),
                main,
                cloneEntity(filters));
    }

    // =========================================================================
    // OVERRIDES
    // =========================================================================

    @Override
    protected void childrenToString(final StringBuilder builder) {
        builder.append("main='")
               .append(main)
               .append("', ");
        builder.append("filters='")
               .append(filters)
               .append("', ");
    }

    // =========================================================================
    // GETTERS & SETTERS
    // =========================================================================
    public boolean isMain() {
        return main;
    }

    public void setMain(boolean main) {
        this.main = main;
    }

    public FiltersEntity getFilters() {
        return filters;
    }

    public void setFilters(FiltersEntity filters) {
        this.filters = filters;
    }
}
