/*
 * DrawText.java
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

package org.calango.draw;

import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Graphics;

/**
 * @author eduveks
 */
public class DrawText {
    public static final int ALIGN_LEFT = 1;
    public static final int ALIGN_CENTER = 2;
    public static final int ALIGN_RIGHT = 3;
    private int maxCharsInLine = 0;
    private Font font = null;
    private int width = 0;

    public DrawText(int width) {
        this.width = width;
    }
    public void setFont(Font font) {
        this.font = font;
        String text = "";
        while (true) {
            text += "n";
            if (font.stringWidth(text) > width) {
                maxCharsInLine = text.length() - 1;
                break;
            }
        }
    }
    public int getMaxCharsInLine() {
        return maxCharsInLine;
    }
    public Font getFont() {
        return font;
    }
    public int getHeight(String text) {
        int h = 0;
        while (true) {
            h += font.getHeight();
            if (text.length() > maxCharsInLine) {
                String t = text.substring(0, maxCharsInLine);
                if (t.lastIndexOf(' ') == -1) {
                    text = text.substring(maxCharsInLine - 1);
                } else {
                    text = text.substring(t.lastIndexOf(' '));
                }
            } else {
                return h;
            }
        }
    }
    public int drawAutoBreakLine(Graphics g, String text, int x, int y, int align) {
        int anchor = Graphics.TOP | Graphics.LEFT;
        switch (align) {
            case ALIGN_LEFT:
                anchor = Graphics.TOP | Graphics.LEFT;
                break;
            case ALIGN_CENTER:
                anchor = Graphics.TOP | Graphics.HCENTER;
                break;
            case ALIGN_RIGHT:
                anchor = Graphics.TOP | Graphics.RIGHT;
                break;
        }
        g.setFont(font);
        while (true) {
            if (text.equals("")) {
                text = " ";
            }
            if (text.length() > maxCharsInLine) {
                String t = text.substring(0, maxCharsInLine);
                int lastSpace = t.lastIndexOf(' ');
                if (lastSpace == -1) {
                    g.drawString(t.substring(0, maxCharsInLine - 1) + "-", x, y, anchor);
                    text = text.substring(maxCharsInLine - 1).trim();
                } else {
                    g.drawString(t.substring(0, lastSpace), x, y, anchor);
                    text = text.substring(lastSpace).trim();
                }
                y += font.getHeight();
            } else {
                g.drawString(text, x, y, anchor);
                return y + font.getHeight();
            }
        }
    }

    public int draw(Graphics g, String text, int x, int y, int align) {
        int anchor = Graphics.TOP | Graphics.LEFT;
        switch (align) {
            case ALIGN_LEFT:
                anchor = Graphics.TOP | Graphics.LEFT;
                break;
            case ALIGN_CENTER:
                anchor = Graphics.TOP | Graphics.HCENTER;
                break;
            case ALIGN_RIGHT:
                anchor = Graphics.TOP | Graphics.RIGHT;
                break;
        }
        if (!g.getFont().equals(font)) {
            g.setFont(font);
        }
        g.drawString(text, x, y, anchor);
        return y + font.getHeight();
    }
}