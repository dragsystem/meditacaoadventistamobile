/*
 * Principal.java
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

import java.util.Calendar;
import java.util.Vector;
import javax.microedition.lcdui.Choice;
import javax.microedition.lcdui.ChoiceGroup;
import javax.microedition.lcdui.StringItem;
import javax.microedition.lcdui.TextField;
import javax.microedition.rms.RecordStore;
import org.calango.WorkFlow;

/**
 * @author eduveks
 */
public class Principal extends org.calango.Home {
    public static String URL = "http://meditacaoadventistamobile.googlecode.com/svn/trunk/fs/";
    public static String URL_ADULTO = "adulto/";
    public static String URL_MULHER = "mulher/";
    public static String URL_JUVENIL = "juvenil/";
    private final String RECORDSTORE_NAME = "MEDITACAOADVENTISTAMOBILE2";
    private final int RECORDSTORE_ID_MEDITACAOTIPO = 1;
    private StringItem txtAlert;
    private TextField txtFieldDay;
    private TextField txtFieldMonth;
    private TextField txtFieldYear;
    private ChoiceGroup choiceGroupMeditacaoTipo;
    private String meditacaoData = "";
    private String meditacaoTitulo = "";
    private String meditacaoVerso = "";
    private Vector meditacaoLines = new Vector();
    private Main main;
    public Principal(Main main, String title) {
        super(main, title);
        this.main = main;
        txtAlert = new StringItem("", "");
        txtFieldDay = new TextField("\nDia\n", null, 2, TextField.NUMERIC);
        txtFieldDay.setString("" + Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
        txtFieldMonth = new TextField("\nM\u00EAs\n", null, 2, TextField.NUMERIC);
        txtFieldMonth.setString("" + (Calendar.getInstance().get(Calendar.MONTH) + 1));
        txtFieldYear = new TextField("\nAno\n", null, 4, TextField.NUMERIC);
        txtFieldYear.setString("" + Calendar.getInstance().get(Calendar.YEAR));
        choiceGroupMeditacaoTipo = new ChoiceGroup("", Choice.EXCLUSIVE);
        choiceGroupMeditacaoTipo.append("Adulto", null);
        choiceGroupMeditacaoTipo.append("Mulher", null);
        choiceGroupMeditacaoTipo.append("Juvenil", null);
        choiceGroupMeditacaoTipo.setSelectedFlags(new boolean[] { false, false, false });
        this.append(getLogo());
        java.io.InputStream is = null;
        try {
            is = javax.microedition.io.Connector.openDataInputStream(Principal.URL + "alert.txt");
            StringBuffer sbuffer = new StringBuffer();
            int b;
            while ((b = is.read()) != -1) {
                sbuffer.append((char)b);
            }
            String buffer = sbuffer.toString().trim();
            if (buffer.indexOf("<2.0>") > -1 && buffer.indexOf("</2.0>") > -1) {
                txtAlert.setText(buffer.substring(buffer.indexOf("<2.0>") + 5, buffer.indexOf("</2.0>")));
                this.append(txtAlert);
            }
        } catch (Exception e) {

        } finally {
            try {
                if (is != null) {
                    is.close();
                }
            } catch (Exception ex) { }
        }
        this.append(txtFieldDay);
        this.append(txtFieldMonth);
        this.append(txtFieldYear);
        this.append(new StringItem("\nEdi\u00E7\u00E3o\n", ""));
        RecordStore recordStore = null;
        try {
            recordStore = RecordStore.openRecordStore(RECORDSTORE_NAME, true);
            byte[] bTextConfig =  recordStore.getRecord(RECORDSTORE_ID_MEDITACAOTIPO);
            if (bTextConfig == null || bTextConfig.length < 1) {
                choiceGroupMeditacaoTipo.setSelectedIndex(0, true);
            } else {
                char textConfig = (char)bTextConfig[0];
                if (textConfig == '0') {
                    choiceGroupMeditacaoTipo.setSelectedIndex(0, true);
                } else if (textConfig == '1') {
                    choiceGroupMeditacaoTipo.setSelectedIndex(1, true);
                } else if (textConfig == '2') {
                    choiceGroupMeditacaoTipo.setSelectedIndex(2, true);
                }
            }
        } catch (Exception e) {

        } finally {
            try {
                recordStore.closeRecordStore();
            } catch (Exception ex) {
            }
        }
        this.append(choiceGroupMeditacaoTipo);
        this.append(new StringItem("\n ", "\n "));
    }

    public void loadMeditacao() {
        RecordStore recordStore = null;
        try {
            recordStore = RecordStore.openRecordStore(RECORDSTORE_NAME, true);
            if (choiceGroupMeditacaoTipo.getSelectedIndex() == 2) {
                try {
                    recordStore.setRecord(RECORDSTORE_ID_MEDITACAOTIPO, new byte[] {'2'}, 0, 1);
                } catch (Exception e) {
                    recordStore.addRecord(new byte[] {'2'}, 0, 1);
                }
            } else if (choiceGroupMeditacaoTipo.getSelectedIndex() == 1) {
                try {
                    recordStore.setRecord(RECORDSTORE_ID_MEDITACAOTIPO, new byte[] {'1'}, 0, 1);
                } catch (Exception e) {
                    recordStore.addRecord(new byte[] {'1'}, 0, 1);
                }
            } else {
                try {
                    recordStore.setRecord(RECORDSTORE_ID_MEDITACAOTIPO, new byte[] {'0'}, 0, 1);
                } catch (Exception e) {
                    recordStore.addRecord(new byte[] {'0'}, 0, 1);
                }
            }
        } catch (Exception e) {

        } finally {
            try {
                recordStore.closeRecordStore();
            } catch (Exception ex) {
            }
        }
        meditacaoLines = new Vector();
        meditacaoData = "";
        meditacaoTitulo = "";
        meditacaoVerso = "";
        String fileName = txtFieldYear.getString();
        if (txtFieldMonth.getString().length() < 2) {
            fileName += "0" + txtFieldMonth.getString();
        } else {
            fileName += txtFieldMonth.getString();
        }
        if (txtFieldDay.getString().length() < 2) {
            fileName += "0" + txtFieldDay.getString();
        } else {
            fileName += txtFieldDay.getString();
        }
        fileName += ".txt";
        java.io.InputStream is = null;
        try {
            String url = "";
            switch (choiceGroupMeditacaoTipo.getSelectedIndex()) {
                case 1:
                    url = URL_MULHER;
                    break;
                case 2:
                    url = URL_JUVENIL;
                    break;
                default:
                    url = URL_ADULTO;
                    break;
            }
            is = javax.microedition.io.Connector.openDataInputStream(Principal.URL + url + txtFieldYear.getString() +"/"+ fileName);
            int b;
            StringBuffer sbuffer = new StringBuffer();
            boolean isOk = false;
            while ((b = is.read()) != -1) {
                switch (b) {
                    case 147:
                        sbuffer.append("\"");
                        break;
                    case 148:
                        sbuffer.append("\"");
                        break;
                    default:
                        sbuffer.append((char) b);
                        break;
                }
                String buffer = sbuffer.toString().trim();
                if (buffer.startsWith("<d>") && buffer.endsWith("</d>")) {
                    meditacaoData = buffer.substring(3, buffer.length() - 4);
                    sbuffer = new StringBuffer();
                } else if (buffer.startsWith("<t>") && buffer.endsWith("</t>")) {
                    meditacaoTitulo = buffer.substring(3, buffer.length() - 4);
                    sbuffer = new StringBuffer();
                } else if (buffer.startsWith("<v>") && buffer.endsWith("</v>")) {
                    meditacaoVerso = buffer.substring(3, buffer.length() - 4);
                    sbuffer = new StringBuffer();
                } else if (buffer.startsWith("<c>") && buffer.endsWith("</c>")) {
                    loadMeditacaoLines("[#V]"+ meditacaoVerso +"\n[#C]"+ buffer.substring(3, buffer.length() - 4));
                    sbuffer = new StringBuffer();
                    isOk = true;
                }
            }
            if (!isOk || meditacaoData.equals("") || meditacaoTitulo.equals("") || meditacaoVerso.equals("") ) {
                throw new Exception();
            }
        } catch (Exception e) {
            e.printStackTrace();
            meditacaoData = "";
            meditacaoTitulo = "N\u00E3o foi poss\u00EDvel carregar o conte\u00FAdo...";
            meditacaoVerso = "";
            meditacaoLines.removeAllElements();
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
            } catch (Exception ex) { }
        }
        main.getText().load(meditacaoData, meditacaoTitulo, meditacaoLines);
    }

    private void loadMeditacaoLines(String text) {
        while (true) {
            int i = text.indexOf('\n');
            if (i > 0) {
                meditacaoLines.addElement(text.substring(0, i));
                text = text.substring(i + 1);
            } else if (i == -1) {
                meditacaoLines.addElement(text);
                break;
            } else {
                meditacaoLines.addElement("");
                text = text.substring(i + 1);
            }
            if (text.equals("")) {
                break;
            }
        }
    }

    public int load(final WorkFlow workFlow) {
        try {
            int day = Integer.parseInt(txtFieldDay.getString());
            int month = Integer.parseInt(txtFieldMonth.getString());
            if (day > 0 && day < 31 && month > 0 && month < 12 && txtFieldYear.getString().length() == 4) {
                new Thread() {
                    public void run() {
                        loadMeditacao();
                        main.show(main.getText());
                    }
                }.start();
                return 1;
            }
        } catch (Exception e) {

        }
        return 0;
    }
}
