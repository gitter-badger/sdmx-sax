/*
    This file is part of sdmx-sax.

    sdmx-sax is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    sdmx-sax is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with sdmx-sax.  If not, see <http://www.gnu.org/licenses/>.
    Copyright (C) 2015 James Gardner
*/

package sdmx.data.key;

import java.util.Set;
import sdmx.data.ColumnMapper;
import sdmx.data.flat.FlatObs;

/**
 *
 * @author James
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
