/*
 * WorkFlow.java
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

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.Displayable;

/**
 * @author eduveks
 */
public class WorkFlow {
    private Command command = null;
    private Displayable from = null;
    private Displayable to = null;

    public WorkFlow(Command command, Displayable from, Displayable to) {
        this.command = command;
        this.from = from;
        this.to = to;
    }

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public Displayable getFrom() {
        return from;
    }

    public void setFrom(Displayable from) {
        this.from = from;
    }

    public Displayable getTo() {
        return to;
    }

    public void setTo(Displayable to) {
        this.to = to;
    }
}
