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
package org.crab.backend.rest.services;

import org.crab.backend.rest.entities.builders.EntityBuilder;
import org.inugami.api.exceptions.TechnicalException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public interface CrudServices<T>  {
    List<T> create(List<T> entities) throws TechnicalException;


    default <E> List<E> convertToList(final Iterable<E> resultSet){
        final  List<E> result = new ArrayList<>();
        if(resultSet != null) {
            resultSet.forEach(result::add);
        }
        return result;
    }
}
