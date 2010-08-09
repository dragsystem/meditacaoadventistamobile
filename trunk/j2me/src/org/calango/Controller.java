/*
 * Controller.java
 *
 * This file is part of Calango.
 *
 * CajuScript is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3, or (at your option)
 * any later version.
 *
 * CajuScript is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with CajuScript.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.calango;

import java.util.Enumeration;
import java.util.Vector;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.midlet.MIDlet;
import javax.microedition.midlet.MIDletStateChangeException;

/**
 * @author eduveks
 */
public class Controller extends MIDlet implements CommandListener {
    private Display display;
    private Displayable displayable;
    private Vector workFlows = new Vector();
    private String backLabel = "Back";
    private Displayable starter = null;
    private WorkFlowAction workFlowAction = null;

    public void addWorkFlow(WorkFlow workFlow) {
        workFlows.addElement(workFlow);
    }

    public void addWorkFlowCommand(String label, int type, Displayable from, Displayable to) {
        if (from != null) {
            from.setCommandListener(this);
        }
        Command command = new Command(label, type, 0);
        workFlows.addElement(new WorkFlow(command, from, to));
        from.addCommand(command);
    }

    public WorkFlowAction getWorkFlowAction() {
        return workFlowAction;
    }

    public void setWorkFlowAction(WorkFlowAction workFlowAction) {
        this.workFlowAction = workFlowAction;
    }

    protected String getBackLabel() {
        return backLabel;
    }

    protected void setBackLabel(String backLabel) {
        this.backLabel = backLabel;
    }

    public void addWorkFlowBack(Displayable from, Displayable to) {
        addWorkFlowCommand(getBackLabel(), Command.BACK, from, to);
    }

    protected Displayable getStarter() {
        return starter;
    }

    protected void setStarter(Displayable starter) {
        this.starter = starter;
    }

    protected void onStartApp() {

    }

    public void show(Displayable d) {
        this.display.setCurrent(d);
        this.displayable = d;
    }

    protected void startApp() throws MIDletStateChangeException {
        onStartApp();
        display = Display.getDisplay(this);
        if (displayable != null) {
            display.setCurrent(displayable);
        } else {
            display.setCurrent(getStarter());
            displayable = getStarter();
        }
    }

    protected void pauseApp() {
        
    }

    protected void destroyApp(boolean unconditional) throws MIDletStateChangeException {
        
    }

    public void commandAction(Command c, Displayable d) {
        Enumeration enumeration = workFlows.elements();
        while (enumeration.hasMoreElements()) {
            WorkFlow workFlow = (WorkFlow)enumeration.nextElement();
            if (workFlow.getCommand().equals(c)) {
                if (getWorkFlowAction().action(workFlow)) {
                    if (workFlow.getCommand().getCommandType() == Command.EXIT) {
                        notifyDestroyed();
                    } else if (workFlow.getTo() != null) {
                        show(workFlow.getTo());
                    }
                }
            }
        }
    }
}
