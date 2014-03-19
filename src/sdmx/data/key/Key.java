/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.data.key;

import sdmx.data.ColumnMapper;
import sdmx.data.flat.FlatObs;

/**
 *
 * @author James
 */
public interface Key {
    public Object getComponent(String dim);
    public void setComponent(String dim, Object o);
    public boolean equals(Key key);
    public int hashCode();
    public boolean matches(FlatObs obs,ColumnMapper mapper);
    public boolean notMatches(FlatObs obs,ColumnMapper mapper);
}
