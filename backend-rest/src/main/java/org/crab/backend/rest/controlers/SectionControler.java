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
package org.crab.backend.rest.controlers;

import org.crab.backend.rest.entities.SectionEntity;
import org.crab.backend.rest.entities.builders.SectionBuilder;
import org.crab.backend.rest.services.sections.SectionsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.Arrays;
import java.util.List;

@RestController
public class SectionControler {

    // =========================================================================
    // ATTRIBUTES
    // =========================================================================
    @Autowired
    private SectionsServices sectionsServices;


    // =========================================================================
    // CREATE
    // =========================================================================
    @RequestMapping(path = "/admin/sections", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<SectionEntity> createSections(@RequestBody  final List<SectionEntity> sections) throws Exception {
        return  sectionsServices.create(sections);
    }

    @RequestMapping(path = "/admin/sections/{id}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<SectionEntity> createSections(@RequestBody  final List<SectionEntity> sections, @PathVariable("id") Long id) throws Exception {
        return  sectionsServices.createChildren(Long.valueOf(id),sections);
    }

    // =========================================================================
    // API
    // =========================================================================



    @RequestMapping(path = "/admin/sections", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<SectionEntity> getSections() throws Exception {
        return Arrays.asList(
                new SectionBuilder().setTitle("foobar")
                                    .setDescription("lorem ipsum")
                                    .setMain(true)
                                    .build(),

                new SectionBuilder().setTitle("joe")
                                    .setDescription("lorem ipsum")
                                    .setMain(true)
                                    .build()
                );
    }

}
