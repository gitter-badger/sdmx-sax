/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.data.key;

import java.util.Set;
import sdmx.data.ColumnMapper;
import sdmx.data.flat.FlatObs;

/**
 *
 * @author James
 */
/*
 SDMX-SAX an SDMX Parsing Library
Copyright (C) 2015  James Gardner

This library is free software; you can redistribute it and/or
modify it under the terms of the GNU Lesser General Public
License as published by the Free Software Foundation; either
version 2.1 of the License, or (at your option) any later version.

This library is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
Lesser General Public License for more details.

You should have received a copy of the GNU Lesser General Public
License along with this library; if not, write to the Free Software
Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
package sdmx;
 */
public interface Key {
    public Object getComponent(String dim);
    public void setComponent(String dim, Object o);
    public Object getAttribute(String dim);
    public void setAttribute(String dim, Object o);
    public Set<String> keySet();
    public Set<String> attributeKeySet();
    public void clearAttributes();
    public boolean equals(Key key);
    public int hashCode();
    public boolean matches(FlatObs obs,ColumnMapper mapper);
    public boolean notMatches(FlatObs obs,ColumnMapper mapper);
}
