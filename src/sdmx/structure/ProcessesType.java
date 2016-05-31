/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.structure;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author James
 */

public class ProcessesType {
    private List<Process> processes = new ArrayList<Process>();

    /**
     * @return the processes
     */
    public List<Process> getProcesses() {
        return processes;
    }

    /**
     * @param processes the processes to set
     */
    public void setProcesses(List<Process> processes) {
        this.processes = processes;
    }
}
