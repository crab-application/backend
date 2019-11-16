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

import org.crab.backend.rest.entities.ClonableEntity;

import java.util.List;
import java.util.stream.Collectors;

public interface EntityBuilder {
    default <E extends ClonableEntity<E>> List<E> cloneEntities(final List<E> entities) {
        List<E> result = null;
        if (entities != null) {
            result = entities.stream()
                             .map(ClonableEntity::clone)
                             .collect(Collectors.toList());
        }
        return result;
    }

    default <E extends ClonableEntity<E>> E cloneEntity(final E entity) {
        return entity == null ? null : entity.clone();
    }
}
