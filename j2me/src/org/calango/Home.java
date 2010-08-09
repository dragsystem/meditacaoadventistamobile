/*
 * Home.java
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
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.ImageItem;

/**
 * @author eduveks
 */
public class Home extends Form {
    protected Controller controller = null;
    protected Displayable help = null;

    protected Home(Controller controller, String title) {
        super(title);
        this.controller = controller;
    }

    public Displayable getHelp() {
        return help;
    }

    public void setHelp(Displayable help) {
        this.help = help;
    }

    protected ImageItem getLogo() {
        Image logo = null;
        try {
            logo = Image.createImage("/logo.png");
        } catch (java.io.IOException e) {

        }
        return new ImageItem("", logo, ImageItem.LAYOUT_DEFAULT, null);
    }

    public void loadBasicCommands(String helpLabel, String exitLabel) {
        controller.addWorkFlowCommand(helpLabel, Command.HELP, this, help);
        controller.addWorkFlowCommand(exitLabel, Command.EXIT, this, null);
    }
}
