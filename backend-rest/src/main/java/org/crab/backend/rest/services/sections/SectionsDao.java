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
package org.crab.backend.rest.services.sections;

import org.crab.backend.rest.entities.SectionEntity;
import org.crab.backend.rest.entities.repositories.SectionsRepository;
import org.crab.backend.rest.services.CrudServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class SectionsDao  implements CrudServices<SectionEntity> {

    // =========================================================================
    // ATTRIBUTES
    // =========================================================================
    @Autowired
    private SectionsRepository sectionsRepository;

    // =========================================================================
    // CONSTRUCTORS
    // =========================================================================


    // =========================================================================
    // API
    // =========================================================================
    @Transactional
    public List<SectionEntity> create(final List<SectionEntity> sections) {

        List<SectionEntity> result = new ArrayList<>();
        if (sections != null && !sections.isEmpty()) {
            final List<SectionEntity> sectionsClone = sections.stream()
                                                              .map(SectionEntity::clone)
                                                              .collect(Collectors.toList());
            final Iterable<SectionEntity> resultSet = sectionsRepository.saveAll(sectionsClone);
            result = convertToList(resultSet);
        }
        return result;
    }

    @Transactional
    public void createRelation(final Long parentId,final Long childId) {
        sectionsRepository.connectChildren(parentId,childId);
    }


    // =========================================================================
    // OVERRIDES
    // =========================================================================

    // =========================================================================
    // GETTERS & SETTERS
    // =========================================================================
}
