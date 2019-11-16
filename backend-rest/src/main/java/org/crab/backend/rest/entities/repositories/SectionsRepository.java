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
package org.crab.backend.rest.entities.repositories;

import org.crab.backend.rest.entities.DocumentEntity;
import org.crab.backend.rest.entities.SectionEntity;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SectionsRepository extends Neo4jRepository<SectionEntity, String> {

    @Query("MATCH (section:Section) WHERE section.main == true RETURN user")
    List<SectionEntity> readMains();

    @Query("""
MATCH (parent),(child) where id(parent)={parentId} AND id(child)={childId}
CREATE (parent)-[:HAS_CHILDREN]->(child)
RETURN parent,child
""")
    void connectChildren(@Param("parentId") final Long parentId,@Param("childId")final Long childId);
}
