/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.query.data;

/**
 *
 * @author James
 */

public class DataReturnDetailsBaseType {
    private DataReturnDetailType detail = DataReturnDetailType.FULL;

    /**
     * @return the detail
     */
    public DataReturnDetailType getDetail() {
        return detail;
    }

    /**
     * @param detail the detail to set
     */
    public void setDetail(DataReturnDetailType detail) {
        this.detail = detail;
    }
}
