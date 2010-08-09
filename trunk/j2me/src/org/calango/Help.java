/*
 * Help.java
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

import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.StringItem;

/**
 * @author eduveks
 */
public class Help extends Form {
    public Help(Controller controller, String title, Displayable home) {
        super(title);
        controller.addWorkFlowBack(this, home);
    }

    public void addContent(String title, String text) {
        this.append(new StringItem("\n"+ title +"\n", text));
    }
}
