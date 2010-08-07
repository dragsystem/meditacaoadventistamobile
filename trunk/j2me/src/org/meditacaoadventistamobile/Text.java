/*
 * Text.java
 *
 * This file is part of Meditacao Adventista Mobile.
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

package org.meditacaoadventistamobile;

import java.util.Enumeration;
import java.util.Vector;
import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Graphics;
import org.calango.draw.DrawText;

/**
 * @author eduveks
 */
public class Text extends Canvas {
    private String linePoints = "";
    private int line = 0;
    private int oldLinePosition = 0;
    private String meditacaoData = "";
    private String meditacaoTitulo = "";
    private Vector meditacaoLines = new Vector();
    private boolean showTitle = true;
    private DrawText drawText = new DrawText(getWidth() - 10);
    private Font fontNormal = Font.getFont(Font.FACE_PROPORTIONAL, Font.STYLE_PLAIN, Font.SIZE_MEDIUM);
    private Font fontBold = Font.getFont(Font.FACE_PROPORTIONAL, Font.STYLE_BOLD, Font.SIZE_MEDIUM);
    private String prevLabel = "<";
    private String nextLabel = ">";
    private int page = 0;

    public Text() {

    }

    public void load(String data, String titulo, Vector lines) {
        meditacaoLines = new Vector();
        showTitle = true;
        linePoints = "";
        line = 0;
        page = 0;
        meditacaoData = data;
        meditacaoTitulo = titulo;
        oldLinePosition = 0;
        Enumeration enumLines = lines.elements();
        drawText.setFont(fontNormal);
        while (enumLines.hasMoreElements()) {
            String lineText = enumLines.nextElement().toString();
            while (true) {
                if (lineText.length() > drawText.getMaxCharsInLine()) {
                    String t = lineText.substring(0, drawText.getMaxCharsInLine());
                    int lastSpace = t.lastIndexOf(' ');
                    if (lastSpace == -1) {
                        meditacaoLines.addElement(t.substring(0, drawText.getMaxCharsInLine() - 1) + "-");
                        lineText = lineText.substring(drawText.getMaxCharsInLine() - 1).trim();
                    } else {
                        meditacaoLines.addElement("" + t.substring(0, lastSpace));
                        lineText = lineText.substring(lastSpace).trim();
                    }
                } else {
                    meditacaoLines.addElement("" + lineText);
                    break;
                }
            }
        }
    }

    protected void keyPressed(int key) {
        if (showTitle == false && (key == KEY_NUM4 || key == LEFT || key == -3)) {
            if (linePoints.equals(",0")) {
                showTitle = true;
                linePoints = "";
                line = 0;
                repaint();
                return;
            }
            try {
                String _line = linePoints.substring(linePoints.lastIndexOf(',') + 1, linePoints.length());
                linePoints = linePoints.substring(0, linePoints.length() - _line.length() - 1);
                if (linePoints.lastIndexOf(',') > -1) {
                    _line = linePoints.substring(linePoints.lastIndexOf(',') + 1, linePoints.length());
                    linePoints = linePoints.substring(0, linePoints.length() - _line.length() - 1);
                }
                line = Integer.parseInt(_line);
            } catch (Exception e) {
                e.printStackTrace();
            }
            repaint();
        } else if (key == KEY_NUM6 || key == RIGHT || key == -4) {
            showTitle = false;
            repaint();
        } else if (key == KEY_NUM0) {
            showTitle = true;
            linePoints = "";
            line = 0;
            repaint();
        }
    }

    protected void paint(Graphics g) {
        int y = 0;
        g.setGrayScale(255);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setGrayScale(0);
        if (showTitle) {
            if (!meditacaoData.equals("")) {
                drawText.setFont(Font.getFont(Font.FACE_PROPORTIONAL, Font.STYLE_PLAIN, Font.SIZE_SMALL));
                y = drawText.drawAutoBreakLine(g, meditacaoData, (getWidth() / 2) + 5, y, DrawText.ALIGN_CENTER);
            }
            drawText.setFont(Font.getFont(Font.FACE_PROPORTIONAL, Font.STYLE_BOLD, Font.SIZE_MEDIUM));
            y = drawText.drawAutoBreakLine(g, meditacaoTitulo, (getWidth() / 2) + 5, y, DrawText.ALIGN_CENTER);
            drawText.setFont(fontBold);
            y = drawText.drawAutoBreakLine(g, nextLabel, getWidth() - 5, getHeight() - fontBold.getHeight(), DrawText.ALIGN_RIGHT);
            page = 1;
        } else {
            drawText.setFont(fontNormal);
            Enumeration lines = meditacaoLines.elements();
            int count = -1;
            if (!linePoints.endsWith("," + line)) {
                linePoints += "," + line;
            }
            if (oldLinePosition < line || (line == 0 && oldLinePosition == 0)) {
                page++;
            } else if (oldLinePosition > line) {
                page--;
            }
            oldLinePosition = line;
            boolean showNext = false;
            while (lines.hasMoreElements()) {
                count++;
                String lineText = lines.nextElement().toString();
                if (line > count) {
                    continue;
                }
                if (y + drawText.getHeight(lineText) > getHeight() - fontBold.getHeight()) {
                    line = count;
                    showNext = true;
                    break;
                } else {
                    if (lineText.startsWith("[#V]")) {
                        lineText = lineText.substring(4);
                        drawText.setFont(fontBold);
                    } else if (lineText.startsWith("[#C]")) {
                        lineText = lineText.substring(4);
                        drawText.setFont(fontNormal);
                    }
                    y = drawText.draw(g, lineText, 5, y, DrawText.ALIGN_LEFT);
                }
            }
            drawText.setFont(fontBold);
            drawText.draw(g, prevLabel, 5, getHeight() - fontBold.getHeight(), DrawText.ALIGN_LEFT);
            if (showNext) {
                drawText.draw(g, nextLabel, getWidth() - 5, getHeight() - fontBold.getHeight(), DrawText.ALIGN_RIGHT);
            }
        }
        drawText.setFont(Font.getFont(Font.FACE_PROPORTIONAL, Font.STYLE_PLAIN, Font.SIZE_SMALL));
        drawText.draw(g, Integer.toString(page), (getWidth() / 2) + 5, getHeight() - drawText.getFont().getHeight(), DrawText.ALIGN_CENTER);
    }
}
