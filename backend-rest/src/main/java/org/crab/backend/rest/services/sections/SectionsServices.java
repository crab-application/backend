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

import org.crab.backend.rest.entities.ClonableEntity;
import org.crab.backend.rest.entities.DocumentEntity;
import org.crab.backend.rest.entities.SectionEntity;
import org.crab.backend.rest.entities.repositories.SectionsRepository;
import org.crab.backend.rest.services.CrudServices;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.transaction.Neo4jTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class SectionsServices implements CrudServices<SectionEntity> {


    // =========================================================================
    // ATTRIBUTES
    // =========================================================================
    @Autowired
    private  SectionsDao dao;

    @Autowired
    private SectionsRepository sectionsRepository;

    // =========================================================================
    // CREATE
    // =========================================================================
    @Transactional
    public List<SectionEntity> create(final List<SectionEntity> sections) {
        return dao.create(sections);
    }

    @Transactional
    public List<SectionEntity> createChildren(final Long parentId, final List<SectionEntity> sections) {
        for(SectionEntity entity : Optional.ofNullable(sections).orElse(new ArrayList<>())){
            entity.setMain(false);
        }
        final List<SectionEntity> children = sections == null || sections.isEmpty() ? null :dao.create(sections);
        if (parentId != null) {
            final List<Long> childrenIds = children.stream()
                                             .map(SectionEntity::getId)
                                             .collect(Collectors.toList());

            for(Long childId : childrenIds){
                dao.createRelation(parentId,childId);
            }

        }
        return children;
    }


    // =========================================================================
    // READ MAINS
    // =========================================================================
    public List<SectionEntity> readMains() {
        return convertToList(sectionsRepository.readMains());
    }


    // =========================================================================
    // TOOLS
    // =========================================================================


}
