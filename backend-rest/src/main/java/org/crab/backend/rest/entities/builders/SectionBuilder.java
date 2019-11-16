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

import org.crab.backend.rest.entities.FiltersEntity;
import org.crab.backend.rest.entities.SectionEntity;

public class SectionBuilder extends DocumentEntityBuiler<SectionEntity, SectionBuilder> {


    // =========================================================================
    // ATTRIBUTES
    // =========================================================================
    private boolean       main;
    private FiltersEntity filters;


    // =========================================================================
    // CONSTRUCTORS
    // =========================================================================
    @Override
    public SectionEntity build() {
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

    @Override
    public SectionBuilder createBuild() {
        return new SectionBuilder();
    }

    @Override
    public void cloneSpecificsEntityElements(final SectionEntity entity,
                                             final SectionBuilder builder) {

        builder.setMain(entity.isMain());
        builder.setFilters(cloneEntity(entity.getFilters()));
    }

    @Override
    protected SectionBuilder getBuilder() {
        return this;
    }


    // =========================================================================
    // GETTERS & SETTERS
    // =========================================================================
    public boolean isMain() {
        return main;
    }

    public SectionBuilder setMain(boolean main) {
        this.main = main;
        return this;
    }

    public FiltersEntity getFilters() {
        return filters;
    }

    public SectionBuilder setFilters(FiltersEntity filters) {
        this.filters = filters;
        return this;
    }
}
