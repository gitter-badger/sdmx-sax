/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.data.key;

import java.util.HashMap;

/**
 * Partial Key matches many observations
 * @author James
 */
public class PartialKey extends AbstractKey {
    public PartialKey() {
    }
    public PartialKey(HashMap<String,String> map) {
        super(map);
    }
}
