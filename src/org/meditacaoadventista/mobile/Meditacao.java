/*
* This file is part of the Meditação Adventista Mobile.
*
* Copyright (C) 2007 Eduardo Fonseca Velasques
*
* This program is free software; you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation; either version 2 of the License, or
* (at your option) any later version.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with this program; if not, write to the Free Software
* Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301 USA
*/
package org.meditacaoadventista.mobile;

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
import javax.microedition.rms.*;
import java.util.Calendar;

/**
 * Meditação Adventista Mobile
 * @author eduveks
 */
public class Meditacao extends MIDlet implements CommandListener {
    public static String URL = "http://meditacaoadventistamobile.googlecode.com/svn/trunk/fs/";
    private final String RECORDSTORE_NAME = "MEDITACAOADVENTISTAMOBILE";
    private final int RECORDSTORE_ID_TEXTCONFIG = 1;
    private boolean midletPaused = false;
    private String fixScrollContent = "";

    //<editor-fold defaultstate="collapsed" desc=" Generated Fields ">//GEN-BEGIN:|fields|0|
    private Form formPrincipal;
    private ImageItem imageItem;
    private TextField textFieldFormPrincipalYear;
    private ChoiceGroup choiceGroupFormPrincipalConfigText;
    private TextField textFieldFormPrincipalDay;
    private TextField textFieldFormPrincipalMonth;
    private StringItem stringItemFormPrincipalConfigText;
    private StringItem stringItemFormPrincipalSpace1;
    private StringItem stringItemFormPrincipalAlert;
    private Form formHelp;
    private StringItem stringItemFormHelp3;
    private StringItem stringItemFormHelp2;
    private StringItem stringItemFormHelp1;
    private StringItem stringItemFormHelp6;
    private StringItem stringItemFormHelp5;
    private StringItem stringItemFormHelp4;
    private StringItem stringItemFormHelp7;
    private Form formView;
    private StringItem stringItemFormViewContent;
    private StringItem stringItemFormViewVerse;
    private StringItem stringItemFormViewTitle;
    private StringItem stringItemFormViewDate;
    private Command commandFormPrincipalHelp;
    private Command commandFormPrincipalExit;
    private Command commandFormHelpBack;
    private Command commandFormHelpExit;
    private Command commandFormPrincipalOk;
    private Command commandFormViewBack;
    private Command commandFormViewExit;
    private Image image;
    //</editor-fold>//GEN-END:|fields|0|

    /**
     * The Meditacao constructor.
     */
    public Meditacao() {
        try {
            image = image.createImage("/logo.png");
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int x = 0; x < 500; x++) {
            fixScrollContent += " \n";
        }
        getFormView();
    }

    //<editor-fold defaultstate="collapsed" desc=" Generated Methods ">//GEN-BEGIN:|methods|0|
    //</editor-fold>//GEN-END:|methods|0|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: initialize ">//GEN-BEGIN:|0-initialize|0|0-preInitialize
    /**
     * Initilizes the application.
     * It is called only once when the MIDlet is started. The method is called before the <code>startMIDlet</code> method.
     */
    private void initialize() {//GEN-END:|0-initialize|0|0-preInitialize
        // write pre-initialize user code here
//GEN-LINE:|0-initialize|1|0-postInitialize
        // write post-initialize user code here
    }//GEN-BEGIN:|0-initialize|2|
    //</editor-fold>//GEN-END:|0-initialize|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: startMIDlet ">//GEN-BEGIN:|3-startMIDlet|0|3-preAction
    /**
     * Performs an action assigned to the Mobile Device - MIDlet Started point.
     */
    public void startMIDlet() {//GEN-END:|3-startMIDlet|0|3-preAction
        // write pre-action user code here
        switchDisplayable(null, getFormPrincipal());//GEN-LINE:|3-startMIDlet|1|3-postAction
        // write post-action user code here
    }//GEN-BEGIN:|3-startMIDlet|2|
    //</editor-fold>//GEN-END:|3-startMIDlet|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: resumeMIDlet ">//GEN-BEGIN:|4-resumeMIDlet|0|4-preAction
    /**
     * Performs an action assigned to the Mobile Device - MIDlet Resumed point.
     */
    public void resumeMIDlet() {//GEN-END:|4-resumeMIDlet|0|4-preAction
        // write pre-action user code here
//GEN-LINE:|4-resumeMIDlet|1|4-postAction
        // write post-action user code here
    }//GEN-BEGIN:|4-resumeMIDlet|2|
    //</editor-fold>//GEN-END:|4-resumeMIDlet|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: switchDisplayable ">//GEN-BEGIN:|5-switchDisplayable|0|5-preSwitch
    /**
     * Switches a current displayable in a display. The <code>display</code> instance is taken from <code>getDisplay</code> method. This method is used by all actions in the design for switching displayable.
     * @param alert the Alert which is temporarily set to the display; if <code>null</code>, then <code>nextDisplayable</code> is set immediately
     * @param nextDisplayable the Displayable to be set
     */
    public void switchDisplayable(Alert alert, Displayable nextDisplayable) {//GEN-END:|5-switchDisplayable|0|5-preSwitch
        // write pre-switch user code here
        Display display = getDisplay();//GEN-BEGIN:|5-switchDisplayable|1|5-postSwitch
        if (alert == null) {
            display.setCurrent(nextDisplayable);
        } else {
            display.setCurrent(alert, nextDisplayable);
        }//GEN-END:|5-switchDisplayable|1|5-postSwitch
        // write post-switch user code here
    }//GEN-BEGIN:|5-switchDisplayable|2|
    //</editor-fold>//GEN-END:|5-switchDisplayable|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: commandAction for Displayables ">//GEN-BEGIN:|7-commandAction|0|7-preCommandAction
    /**
     * Called by a system to indicated that a command has been invoked on a particular displayable.
     * @param command the Command that was invoked
     * @param displayable the Displayable where the command was invoked
     */
    public void commandAction(Command command, Displayable displayable) {//GEN-END:|7-commandAction|0|7-preCommandAction
        // write pre-action user code here
        if (displayable == formHelp) {//GEN-BEGIN:|7-commandAction|1|23-preAction
            if (command == commandFormHelpBack) {//GEN-END:|7-commandAction|1|23-preAction
                // write pre-action user code here
                switchDisplayable(null, getFormPrincipal());//GEN-LINE:|7-commandAction|2|23-postAction
                // write post-action user code here
            } else if (command == commandFormHelpExit) {//GEN-LINE:|7-commandAction|3|25-preAction
                exitMIDlet();
//GEN-LINE:|7-commandAction|4|25-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|5|21-preAction
        } else if (displayable == formPrincipal) {
            if (command == commandFormPrincipalExit) {//GEN-END:|7-commandAction|5|21-preAction
                exitMIDlet();
//GEN-LINE:|7-commandAction|6|21-postAction
                // write post-action user code here
            } else if (command == commandFormPrincipalHelp) {//GEN-LINE:|7-commandAction|7|19-preAction
                // write pre-action user code here
                switchDisplayable(null, getFormHelp());//GEN-LINE:|7-commandAction|8|19-postAction
                // write post-action user code here
            } else if (command == commandFormPrincipalOk) {//GEN-LINE:|7-commandAction|9|29-preAction
                // write pre-action user code here
                RecordStore recordStore = null;
                try {
                    recordStore = RecordStore.openRecordStore(RECORDSTORE_NAME, true);
                    if (choiceGroupFormPrincipalConfigText.getSelectedIndex() == 1) {
                        try {
                            recordStore.setRecord(RECORDSTORE_ID_TEXTCONFIG, new byte[] {'1'}, 0, 1);
                        } catch (Exception e) {
                            recordStore.addRecord(new byte[] {'1'}, 0, 1);
                        }
                    } else {
                        try {
                            recordStore.setRecord(RECORDSTORE_ID_TEXTCONFIG, new byte[] {'0'}, 0, 1);
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
                String fileName = textFieldFormPrincipalYear.getString();
                if (textFieldFormPrincipalMonth.getString().length() < 2) {
                    fileName += "0" + textFieldFormPrincipalMonth.getString();
                } else {
                    fileName += textFieldFormPrincipalMonth.getString();
                }
                if (textFieldFormPrincipalDay.getString().length() < 2) {
                    fileName += "0" + textFieldFormPrincipalDay.getString();
                } else {
                    fileName += textFieldFormPrincipalDay.getString();
                }
                fileName += ".txt";
                stringItemFormViewDate.setLabel("");
                stringItemFormViewDate.setText("");
                stringItemFormViewTitle.setLabel("");
                stringItemFormViewTitle.setText("");
                stringItemFormViewVerse.setLabel("");
                stringItemFormViewVerse.setText("");
                stringItemFormViewContent.setLabel("");
                stringItemFormViewContent.setText(fixScrollContent);
                boolean textSpecial = choiceGroupFormPrincipalConfigText.getSelectedIndex() == 1 ? true : false;
                java.io.InputStream is = null;
                try {
                    is = javax.microedition.io.Connector.openDataInputStream(Meditacao.URL + fileName);
                    int b;
                    StringBuffer sbuffer = new StringBuffer();
                    StringItem stringItem = null;
                    boolean stringItemIsLabel = false;
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
                            stringItem = stringItemFormViewDate;
                        } else if (buffer.startsWith("<t>") && buffer.endsWith("</t>")) {
                            stringItem = stringItemFormViewTitle;
                            stringItemIsLabel = true;
                        } else if (buffer.startsWith("<v>") && buffer.endsWith("</v>")) {
                            stringItem = stringItemFormViewVerse;
                        } else if (buffer.startsWith("<c>") && buffer.endsWith("</c>")) {
                            stringItem = stringItemFormViewContent;
                        }
                        if (stringItem != null) {
                            isOk = true;
                            String text = "\n"+ buffer.substring(3, buffer.length() - 4) +"\n\n";
                            if (stringItemIsLabel) {
                                if (textSpecial) {
                                    stringItem.setText(text);
                                } else {
                                    stringItem.setLabel(text);
                                }
                            } else {
                                if (textSpecial) {
                                    stringItem.setLabel(text);
                                } else {
                                    stringItem.setText(text);
                                }
                            }
                            sbuffer = new StringBuffer();
                            stringItem = null;
                            stringItemIsLabel = false;
                        }
                    }
                    if (!isOk) {
                        throw new Exception();
                    }
                } catch (Exception e) {
                    stringItemFormViewContent.setText("");
                    if (textSpecial) {
                        stringItemFormViewTitle.setText("N\u00E3o foi poss\u00EDvel carregar o conte\u00FAdo...");
                    } else {
                        stringItemFormViewTitle.setLabel("N\u00E3o foi poss\u00EDvel carregar o conte\u00FAdo...");
                    }
                } finally {
                    try {
                        if (is != null) {
                            is.close();
                        }
                    } catch (Exception ex) { }
                }
                this.
                switchDisplayable(null, getFormView());//GEN-LINE:|7-commandAction|10|29-postAction

            }//GEN-BEGIN:|7-commandAction|11|32-preAction
        } else if (displayable == formView) {
            if (command == commandFormViewBack) {//GEN-END:|7-commandAction|11|32-preAction
                // write pre-action user code here
                switchDisplayable(null, getFormPrincipal());//GEN-LINE:|7-commandAction|12|32-postAction
                // write post-action user code here
            } else if (command == commandFormViewExit) {//GEN-LINE:|7-commandAction|13|34-preAction
                exitMIDlet();
//GEN-LINE:|7-commandAction|14|34-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|15|7-postCommandAction
        }//GEN-END:|7-commandAction|15|7-postCommandAction
        // write post-action user code here
    }//GEN-BEGIN:|7-commandAction|16|
    //</editor-fold>//GEN-END:|7-commandAction|16|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: formPrincipal ">//GEN-BEGIN:|15-getter|0|15-preInit
    /**
     * Returns an initiliazed instance of formPrincipal component.
     * @return the initialized component instance
     */
    public Form getFormPrincipal() {
        if (formPrincipal == null) {//GEN-END:|15-getter|0|15-preInit
            // write pre-init user code here
            formPrincipal = new Form("Medita\u00E7\u00E3o Adventista Mobile", new Item[] { getImageItem(), getStringItemFormPrincipalAlert(), getTextFieldFormPrincipalDay(), getTextFieldFormPrincipalMonth(), getTextFieldFormPrincipalYear(), getStringItemFormPrincipalConfigText(), getChoiceGroupFormPrincipalConfigText(), getStringItemFormPrincipalSpace1() });//GEN-BEGIN:|15-getter|1|15-postInit
            formPrincipal.addCommand(getCommandFormPrincipalHelp());
            formPrincipal.addCommand(getCommandFormPrincipalExit());
            formPrincipal.addCommand(getCommandFormPrincipalOk());
            formPrincipal.setCommandListener(this);//GEN-END:|15-getter|1|15-postInit
            // write post-init user code here
            RecordStore recordStore = null;
            try {
                recordStore = RecordStore.openRecordStore(RECORDSTORE_NAME, true);
                byte[] bTextConfig =  recordStore.getRecord(RECORDSTORE_ID_TEXTCONFIG);
                if (bTextConfig == null || bTextConfig.length < 1) {
                    choiceGroupFormPrincipalConfigText.setSelectedIndex(0, true);
                } else {
                    char textConfig = (char)bTextConfig[0];
                    if (textConfig == '0') {
                        choiceGroupFormPrincipalConfigText.setSelectedIndex(0, true);
                    } else if (textConfig == '1') {
                        choiceGroupFormPrincipalConfigText.setSelectedIndex(1, true);
                    }
                }
            } catch (Exception e) {
                
            } finally {
                try {
                    recordStore.closeRecordStore();
                } catch (Exception ex) {
                }
            }
            java.io.InputStream is = null;
            try {
                is = javax.microedition.io.Connector.openDataInputStream(Meditacao.URL + "alert.txt");
                StringBuffer sbuffer = new StringBuffer();
                int b;
                while ((b = is.read()) != -1) {
                    sbuffer.append((char)b);
                }
                String buffer = sbuffer.toString().trim();
                if (buffer.indexOf("<1.0>") > -1 && buffer.indexOf("</1.0>") > -1) {
                    stringItemFormPrincipalAlert.setText(buffer.substring(buffer.indexOf("<1.0>") + 5, buffer.indexOf("</1.0>")));
                }
            } catch (Exception e) {

            } finally {
                try {
                    if (is != null) {
                        is.close();
                    }
                } catch (Exception ex) { }
            }
        }//GEN-BEGIN:|15-getter|2|
        return formPrincipal;
    }
    //</editor-fold>//GEN-END:|15-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: formHelp ">//GEN-BEGIN:|17-getter|0|17-preInit
    /**
     * Returns an initiliazed instance of formHelp component.
     * @return the initialized component instance
     */
    public Form getFormHelp() {
        if (formHelp == null) {//GEN-END:|17-getter|0|17-preInit
            // write pre-init user code here
            formHelp = new Form("Medita\u00E7\u00E3o Adventista Mobile", new Item[] { getStringItemFormHelp1(), getStringItemFormHelp2(), getStringItemFormHelp3(), getStringItemFormHelp4(), getStringItemFormHelp5(), getStringItemFormHelp6(), getStringItemFormHelp7() });//GEN-BEGIN:|17-getter|1|17-postInit
            formHelp.addCommand(getCommandFormHelpBack());
            formHelp.addCommand(getCommandFormHelpExit());
            formHelp.setCommandListener(this);//GEN-END:|17-getter|1|17-postInit
            // write post-init user code here
        }//GEN-BEGIN:|17-getter|2|
        return formHelp;
    }
    //</editor-fold>//GEN-END:|17-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: formView ">//GEN-BEGIN:|30-getter|0|30-preInit
    /**
     * Returns an initiliazed instance of formView component.
     * @return the initialized component instance
     */
    public Form getFormView() {
        if (formView == null) {//GEN-END:|30-getter|0|30-preInit
            // write pre-init user code here
            formView = new Form("Medita\u00E7\u00E3o Adventista Mobile", new Item[] { getStringItemFormViewDate(), getStringItemFormViewTitle(), getStringItemFormViewVerse(), getStringItemFormViewContent() });//GEN-BEGIN:|30-getter|1|30-postInit
            formView.addCommand(getCommandFormViewBack());
            formView.addCommand(getCommandFormViewExit());
            formView.setCommandListener(this);//GEN-END:|30-getter|1|30-postInit
            // write post-init user code here
        }//GEN-BEGIN:|30-getter|2|
        return formView;
    }
    //</editor-fold>//GEN-END:|30-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: commandFormPrincipalHelp ">//GEN-BEGIN:|18-getter|0|18-preInit
    /**
     * Returns an initiliazed instance of commandFormPrincipalHelp component.
     * @return the initialized component instance
     */
    public Command getCommandFormPrincipalHelp() {
        if (commandFormPrincipalHelp == null) {//GEN-END:|18-getter|0|18-preInit
            // write pre-init user code here
            commandFormPrincipalHelp = new Command("Help", Command.HELP, 0);//GEN-LINE:|18-getter|1|18-postInit
            // write post-init user code here
        }//GEN-BEGIN:|18-getter|2|
        return commandFormPrincipalHelp;
    }
    //</editor-fold>//GEN-END:|18-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: commandFormPrincipalExit ">//GEN-BEGIN:|20-getter|0|20-preInit
    /**
     * Returns an initiliazed instance of commandFormPrincipalExit component.
     * @return the initialized component instance
     */
    public Command getCommandFormPrincipalExit() {
        if (commandFormPrincipalExit == null) {//GEN-END:|20-getter|0|20-preInit
            // write pre-init user code here
            commandFormPrincipalExit = new Command("Exit", Command.EXIT, 0);//GEN-LINE:|20-getter|1|20-postInit
            // write post-init user code here
        }//GEN-BEGIN:|20-getter|2|
        return commandFormPrincipalExit;
    }
    //</editor-fold>//GEN-END:|20-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: commandFormHelpBack ">//GEN-BEGIN:|22-getter|0|22-preInit
    /**
     * Returns an initiliazed instance of commandFormHelpBack component.
     * @return the initialized component instance
     */
    public Command getCommandFormHelpBack() {
        if (commandFormHelpBack == null) {//GEN-END:|22-getter|0|22-preInit
            // write pre-init user code here
            commandFormHelpBack = new Command("Back", Command.BACK, 0);//GEN-LINE:|22-getter|1|22-postInit
            // write post-init user code here
        }//GEN-BEGIN:|22-getter|2|
        return commandFormHelpBack;
    }
    //</editor-fold>//GEN-END:|22-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: commandFormHelpExit ">//GEN-BEGIN:|24-getter|0|24-preInit
    /**
     * Returns an initiliazed instance of commandFormHelpExit component.
     * @return the initialized component instance
     */
    public Command getCommandFormHelpExit() {
        if (commandFormHelpExit == null) {//GEN-END:|24-getter|0|24-preInit
            // write pre-init user code here
            commandFormHelpExit = new Command("Exit", Command.EXIT, 0);//GEN-LINE:|24-getter|1|24-postInit
            // write post-init user code here
        }//GEN-BEGIN:|24-getter|2|
        return commandFormHelpExit;
    }
    //</editor-fold>//GEN-END:|24-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: commandFormPrincipalOk ">//GEN-BEGIN:|28-getter|0|28-preInit
    /**
     * Returns an initiliazed instance of commandFormPrincipalOk component.
     * @return the initialized component instance
     */
    public Command getCommandFormPrincipalOk() {
        if (commandFormPrincipalOk == null) {//GEN-END:|28-getter|0|28-preInit
            // write pre-init user code here
            commandFormPrincipalOk = new Command("Ok", Command.OK, 0);//GEN-LINE:|28-getter|1|28-postInit
            // write post-init user code here
        }//GEN-BEGIN:|28-getter|2|
        return commandFormPrincipalOk;
    }
    //</editor-fold>//GEN-END:|28-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: commandFormViewBack ">//GEN-BEGIN:|31-getter|0|31-preInit
    /**
     * Returns an initiliazed instance of commandFormViewBack component.
     * @return the initialized component instance
     */
    public Command getCommandFormViewBack() {
        if (commandFormViewBack == null) {//GEN-END:|31-getter|0|31-preInit
            // write pre-init user code here
            commandFormViewBack = new Command("Back", Command.BACK, 0);//GEN-LINE:|31-getter|1|31-postInit
            // write post-init user code here
        }//GEN-BEGIN:|31-getter|2|
        return commandFormViewBack;
    }
    //</editor-fold>//GEN-END:|31-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: commandFormViewExit ">//GEN-BEGIN:|33-getter|0|33-preInit
    /**
     * Returns an initiliazed instance of commandFormViewExit component.
     * @return the initialized component instance
     */
    public Command getCommandFormViewExit() {
        if (commandFormViewExit == null) {//GEN-END:|33-getter|0|33-preInit
            // write pre-init user code here
            commandFormViewExit = new Command("Exit", Command.EXIT, 0);//GEN-LINE:|33-getter|1|33-postInit
            // write post-init user code here
        }//GEN-BEGIN:|33-getter|2|
        return commandFormViewExit;
    }
    //</editor-fold>//GEN-END:|33-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: imageItem ">//GEN-BEGIN:|37-getter|0|37-preInit
    /**
     * Returns an initiliazed instance of imageItem component.
     * @return the initialized component instance
     */
    public ImageItem getImageItem() {
        if (imageItem == null) {//GEN-END:|37-getter|0|37-preInit
            imageItem = new ImageItem("\n", getImage(), ImageItem.LAYOUT_DEFAULT, "Medita\u00E7\u00E3o Adventista Mobile");
            /*
imageItem = new ImageItem ("\n", getImage (), ImageItem.LAYOUT_DEFAULT, "Medita\u00E7\u00E3o Adventista Mobile", Item.BUTTON);//GEN-LINE:|37-getter|1|37-postInit
            */
        }//GEN-BEGIN:|37-getter|2|
        return imageItem;
    }
    //</editor-fold>//GEN-END:|37-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: image ">//GEN-BEGIN:|38-getter|0|38-preInit
    /**
     * Returns an initiliazed instance of image component.
     * @return the initialized component instance
     */
    public Image getImage() {
        if (image == null) {//GEN-END:|38-getter|0|38-preInit
            // write pre-init user code here
            image = Image.createImage(1, 1);//GEN-LINE:|38-getter|1|38-postInit
            // write post-init user code here
        }//GEN-BEGIN:|38-getter|2|
        return image;
    }
    //</editor-fold>//GEN-END:|38-getter|2|



    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: textFieldFormPrincipalDay ">//GEN-BEGIN:|40-getter|0|40-preInit
    /**
     * Returns an initiliazed instance of textFieldFormPrincipalDay component.
     * @return the initialized component instance
     */
    public TextField getTextFieldFormPrincipalDay() {
        if (textFieldFormPrincipalDay == null) {//GEN-END:|40-getter|0|40-preInit
            // write pre-init user code here
            textFieldFormPrincipalDay = new TextField("\nDia\n", null, 2, TextField.NUMERIC);//GEN-LINE:|40-getter|1|40-postInit
            textFieldFormPrincipalDay.setString("" + Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
        }//GEN-BEGIN:|40-getter|2|
        return textFieldFormPrincipalDay;
    }
    //</editor-fold>//GEN-END:|40-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: textFieldFormPrincipalMonth ">//GEN-BEGIN:|41-getter|0|41-preInit
    /**
     * Returns an initiliazed instance of textFieldFormPrincipalMonth component.
     * @return the initialized component instance
     */
    public TextField getTextFieldFormPrincipalMonth() {
        if (textFieldFormPrincipalMonth == null) {//GEN-END:|41-getter|0|41-preInit
            // write pre-init user code here
            textFieldFormPrincipalMonth = new TextField("\nM\u00EAs\n", null, 2, TextField.NUMERIC);//GEN-LINE:|41-getter|1|41-postInit
            textFieldFormPrincipalMonth.setString("" + (Calendar.getInstance().get(Calendar.MONTH) + 1));
        }//GEN-BEGIN:|41-getter|2|
        return textFieldFormPrincipalMonth;
    }
    //</editor-fold>//GEN-END:|41-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: textFieldFormPrincipalYear ">//GEN-BEGIN:|42-getter|0|42-preInit
    /**
     * Returns an initiliazed instance of textFieldFormPrincipalYear component.
     * @return the initialized component instance
     */
    public TextField getTextFieldFormPrincipalYear() {
        if (textFieldFormPrincipalYear == null) {//GEN-END:|42-getter|0|42-preInit
            // write pre-init user code here
            textFieldFormPrincipalYear = new TextField("\nAno\n", null, 4, TextField.NUMERIC);//GEN-LINE:|42-getter|1|42-postInit
            textFieldFormPrincipalYear.setString("" + Calendar.getInstance().get(Calendar.YEAR));
        }//GEN-BEGIN:|42-getter|2|
        return textFieldFormPrincipalYear;
    }
    //</editor-fold>//GEN-END:|42-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: choiceGroupFormPrincipalConfigText ">//GEN-BEGIN:|43-getter|0|43-preInit
    /**
     * Returns an initiliazed instance of choiceGroupFormPrincipalConfigText component.
     * @return the initialized component instance
     */
    public ChoiceGroup getChoiceGroupFormPrincipalConfigText() {
        if (choiceGroupFormPrincipalConfigText == null) {//GEN-END:|43-getter|0|43-preInit
            // write pre-init user code here
            /*
choiceGroupFormPrincipalConfigText = new ChoiceGroup ("", Choice.EXCLUSIVE);//GEN-BEGIN:|43-getter|1|43-postInit
choiceGroupFormPrincipalConfigText.append ("Normal", null);
choiceGroupFormPrincipalConfigText.append ("Especial", null);
choiceGroupFormPrincipalConfigText.setSelectedFlags (new boolean[] { false, false });
choiceGroupFormPrincipalConfigText.setFont (0, null);
choiceGroupFormPrincipalConfigText.setFont (1, null);//GEN-END:|43-getter|1|43-postInit
            */
            choiceGroupFormPrincipalConfigText = new ChoiceGroup("", Choice.EXCLUSIVE);
            choiceGroupFormPrincipalConfigText.append("Normal", null);
            choiceGroupFormPrincipalConfigText.append("Especial", null);
            choiceGroupFormPrincipalConfigText.setSelectedFlags(new boolean[] { false, false });
            // write post-init user code here
        }//GEN-BEGIN:|43-getter|2|
        return choiceGroupFormPrincipalConfigText;
    }
    //</editor-fold>//GEN-END:|43-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItemFormPrincipalConfigText ">//GEN-BEGIN:|46-getter|0|46-preInit
    /**
     * Returns an initiliazed instance of stringItemFormPrincipalConfigText component.
     * @return the initialized component instance
     */
    public StringItem getStringItemFormPrincipalConfigText() {
        if (stringItemFormPrincipalConfigText == null) {//GEN-END:|46-getter|0|46-preInit
            // write pre-init user code here
            stringItemFormPrincipalConfigText = new StringItem("\nConfigura\u00E7\u00E3o do Texto", null);//GEN-LINE:|46-getter|1|46-postInit
            // write post-init user code here
        }//GEN-BEGIN:|46-getter|2|
        return stringItemFormPrincipalConfigText;
    }
    //</editor-fold>//GEN-END:|46-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItemFormPrincipalSpace1 ">//GEN-BEGIN:|47-getter|0|47-preInit
    /**
     * Returns an initiliazed instance of stringItemFormPrincipalSpace1 component.
     * @return the initialized component instance
     */
    public StringItem getStringItemFormPrincipalSpace1() {
        if (stringItemFormPrincipalSpace1 == null) {//GEN-END:|47-getter|0|47-preInit
            // write pre-init user code here
            stringItemFormPrincipalSpace1 = new StringItem("\n ", null);//GEN-LINE:|47-getter|1|47-postInit
            // write post-init user code here
        }//GEN-BEGIN:|47-getter|2|
        return stringItemFormPrincipalSpace1;
    }
    //</editor-fold>//GEN-END:|47-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItemFormViewDate ">//GEN-BEGIN:|48-getter|0|48-preInit
    /**
     * Returns an initiliazed instance of stringItemFormViewDate component.
     * @return the initialized component instance
     */
    public StringItem getStringItemFormViewDate() {
        if (stringItemFormViewDate == null) {//GEN-END:|48-getter|0|48-preInit
            // write pre-init user code here
            stringItemFormViewDate = new StringItem("", null);//GEN-LINE:|48-getter|1|48-postInit
            // write post-init user code here
        }//GEN-BEGIN:|48-getter|2|
        return stringItemFormViewDate;
    }
    //</editor-fold>//GEN-END:|48-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItemFormViewTitle ">//GEN-BEGIN:|49-getter|0|49-preInit
    /**
     * Returns an initiliazed instance of stringItemFormViewTitle component.
     * @return the initialized component instance
     */
    public StringItem getStringItemFormViewTitle() {
        if (stringItemFormViewTitle == null) {//GEN-END:|49-getter|0|49-preInit
            // write pre-init user code here
            stringItemFormViewTitle = new StringItem("", null);//GEN-LINE:|49-getter|1|49-postInit
            // write post-init user code here
        }//GEN-BEGIN:|49-getter|2|
        return stringItemFormViewTitle;
    }
    //</editor-fold>//GEN-END:|49-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItemFormViewVerse ">//GEN-BEGIN:|50-getter|0|50-preInit
    /**
     * Returns an initiliazed instance of stringItemFormViewVerse component.
     * @return the initialized component instance
     */
    public StringItem getStringItemFormViewVerse() {
        if (stringItemFormViewVerse == null) {//GEN-END:|50-getter|0|50-preInit
            // write pre-init user code here
            stringItemFormViewVerse = new StringItem("", null);//GEN-LINE:|50-getter|1|50-postInit
            // write post-init user code here
        }//GEN-BEGIN:|50-getter|2|
        return stringItemFormViewVerse;
    }
    //</editor-fold>//GEN-END:|50-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItemFormViewContent ">//GEN-BEGIN:|51-getter|0|51-preInit
    /**
     * Returns an initiliazed instance of stringItemFormViewContent component.
     * @return the initialized component instance
     */
    public StringItem getStringItemFormViewContent() {
        if (stringItemFormViewContent == null) {//GEN-END:|51-getter|0|51-preInit
            // write pre-init user code here
            stringItemFormViewContent = new StringItem("", null);//GEN-LINE:|51-getter|1|51-postInit
            // write post-init user code here
            stringItemFormViewContent.setText(fixScrollContent);
        }//GEN-BEGIN:|51-getter|2|
        return stringItemFormViewContent;
    }
    //</editor-fold>//GEN-END:|51-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItemFormHelp1 ">//GEN-BEGIN:|52-getter|0|52-preInit
    /**
     * Returns an initiliazed instance of stringItemFormHelp1 component.
     * @return the initialized component instance
     */
    public StringItem getStringItemFormHelp1() {
        if (stringItemFormHelp1 == null) {//GEN-END:|52-getter|0|52-preInit
            // write pre-init user code here
            stringItemFormHelp1 = new StringItem("\nMedita\u00E7\u00E3o Adventista Mobile", "\nVers\u00E3o 1.0");//GEN-LINE:|52-getter|1|52-postInit
            // write post-init user code here
        }//GEN-BEGIN:|52-getter|2|
        return stringItemFormHelp1;
    }
    //</editor-fold>//GEN-END:|52-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItemFormHelp2 ">//GEN-BEGIN:|53-getter|0|53-preInit
    /**
     * Returns an initiliazed instance of stringItemFormHelp2 component.
     * @return the initialized component instance
     */
    public StringItem getStringItemFormHelp2() {
        if (stringItemFormHelp2 == null) {//GEN-END:|53-getter|0|53-preInit
            // write pre-init user code here
            stringItemFormHelp2 = new StringItem("\nDia, M\u00EAs e Ano:", "\nAutomaticamente ser\u00E1 preenchido a data atual, mas pode escolher a medita\u00E7\u00E3o de outro dia colocando a data pretendida e depois clique em \"Ok\" para ver o texto da medita\u00E7\u00E3o.");//GEN-LINE:|53-getter|1|53-postInit
            // write post-init user code here
        }//GEN-BEGIN:|53-getter|2|
        return stringItemFormHelp2;
    }
    //</editor-fold>//GEN-END:|53-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItemFormHelp3 ">//GEN-BEGIN:|55-getter|0|55-preInit
    /**
     * Returns an initiliazed instance of stringItemFormHelp3 component.
     * @return the initialized component instance
     */
    public StringItem getStringItemFormHelp3() {
        if (stringItemFormHelp3 == null) {//GEN-END:|55-getter|0|55-preInit
            // write pre-init user code here
            stringItemFormHelp3 = new StringItem("Configura\u00E7\u00E3o do texto:", "\nSe o t\u00EDtulo n\u00E3o aparecer em negrito e sim o texto, ent\u00E3o abra com a op\u00E7\u00E3o \"Especial\" marcada.");//GEN-LINE:|55-getter|1|55-postInit
            // write post-init user code here
        }//GEN-BEGIN:|55-getter|2|
        return stringItemFormHelp3;
    }
    //</editor-fold>//GEN-END:|55-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItemFormHelp4 ">//GEN-BEGIN:|56-getter|0|56-preInit
    /**
     * Returns an initiliazed instance of stringItemFormHelp4 component.
     * @return the initialized component instance
     */
    public StringItem getStringItemFormHelp4() {
        if (stringItemFormHelp4 == null) {//GEN-END:|56-getter|0|56-preInit
            // write pre-init user code here
            stringItemFormHelp4 = new StringItem("\nWebsite Oficial:", "\nhttp://code.google.com/p/meditacaoadventistamobile");//GEN-LINE:|56-getter|1|56-postInit
            // write post-init user code here
        }//GEN-BEGIN:|56-getter|2|
        return stringItemFormHelp4;
    }
    //</editor-fold>//GEN-END:|56-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItemFormHelp5 ">//GEN-BEGIN:|57-getter|0|57-preInit
    /**
     * Returns an initiliazed instance of stringItemFormHelp5 component.
     * @return the initialized component instance
     */
    public StringItem getStringItemFormHelp5() {
        if (stringItemFormHelp5 == null) {//GEN-END:|57-getter|0|57-preInit
            // write pre-init user code here
            stringItemFormHelp5 = new StringItem("\nCr\u00E9ditos", "\nCoordenador:\n  Miguel Sabino\nConte\u00FAdo:\n  Rui Coutinho\n  Joel Alegria\nDesenvolvedor:\n  Eduardo Velasques");//GEN-LINE:|57-getter|1|57-postInit
            // write post-init user code here
        }//GEN-BEGIN:|57-getter|2|
        return stringItemFormHelp5;
    }
    //</editor-fold>//GEN-END:|57-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItemFormHelp6 ">//GEN-BEGIN:|58-getter|0|58-preInit
    /**
     * Returns an initiliazed instance of stringItemFormHelp6 component.
     * @return the initialized component instance
     */
    public StringItem getStringItemFormHelp6() {
        if (stringItemFormHelp6 == null) {//GEN-END:|58-getter|0|58-preInit
            // write pre-init user code here
            stringItemFormHelp6 = new StringItem("\nLicen\u00E7a:", "\nGNU General Public Licence v2\nhttp://www.gnu.org/licenses/gpl-2.0.html");//GEN-LINE:|58-getter|1|58-postInit
            // write post-init user code here
        }//GEN-BEGIN:|58-getter|2|
        return stringItemFormHelp6;
    }
    //</editor-fold>//GEN-END:|58-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItemFormHelp7 ">//GEN-BEGIN:|60-getter|0|60-preInit
    /**
     * Returns an initiliazed instance of stringItemFormHelp7 component.
     * @return the initialized component instance
     */
    public StringItem getStringItemFormHelp7() {
        if (stringItemFormHelp7 == null) {//GEN-END:|60-getter|0|60-preInit
            // write pre-init user code here
            stringItemFormHelp7 = new StringItem("\nNota:", "\nA Medita\u00E7\u00E3o Adventista Mobile \u00E9 um projeto sem fins lucrativos, que tem por \u00FAnico objetivo facilitar o acesso aos textos da Medita\u00E7\u00E3o Adventista de uma forma alternativa e simples.\n\nN\u00E3o \u00E9 nosso interesse lesar ningu\u00E9m nos seus direitos de autor e se algu\u00E9m se sentir lesado agradecemos que nos contate de imediato atrav\u00E9s do endere\u00E7o meditacaomobile@gmail.com.\n\nObrigado,\n\nA equipe da Medita\u00E7\u00E3o Adventista Mobile");//GEN-LINE:|60-getter|1|60-postInit
            // write post-init user code here
        }//GEN-BEGIN:|60-getter|2|
        return stringItemFormHelp7;
    }
    //</editor-fold>//GEN-END:|60-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItemFormPrincipalAlert ">//GEN-BEGIN:|61-getter|0|61-preInit
    /**
     * Returns an initiliazed instance of stringItemFormPrincipalAlert component.
     * @return the initialized component instance
     */
    public StringItem getStringItemFormPrincipalAlert() {
        if (stringItemFormPrincipalAlert == null) {//GEN-END:|61-getter|0|61-preInit
            // write pre-init user code here
            stringItemFormPrincipalAlert = new StringItem("", null);//GEN-LINE:|61-getter|1|61-postInit
            // write post-init user code here
        }//GEN-BEGIN:|61-getter|2|
        return stringItemFormPrincipalAlert;
    }
    //</editor-fold>//GEN-END:|61-getter|2|

    /**
     * Returns a display instance.
     * @return the display instance.
     */
    public Display getDisplay () {
        return Display.getDisplay(this);
    }

    /**
     * Exits MIDlet.
     */
    public void exitMIDlet() {
        switchDisplayable (null, null);
        destroyApp(true);
        notifyDestroyed();
    }

    /**
     * Called when MIDlet is started.
     * Checks whether the MIDlet have been already started and initialize/starts or resumes the MIDlet.
     */
    public void startApp() {
        if (midletPaused) {
            resumeMIDlet ();
        } else {
            initialize ();
            startMIDlet ();
        }
        midletPaused = false;
    }

    /**
     * Called when MIDlet is paused.
     */
    public void pauseApp() {
        midletPaused = true;
    }

    /**
     * Called to signal the MIDlet to terminate.
     * @param unconditional if true, then the MIDlet has to be unconditionally terminated and all resources has to be released.
     */
    public void destroyApp(boolean unconditional) {
    }
}
