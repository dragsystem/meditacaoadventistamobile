/*
 * Main.java
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

import javax.microedition.lcdui.Command;
import org.calango.Controller;
import org.calango.Help;
import org.calango.WorkFlow;
import org.calango.WorkFlowAction;

/**
 * @author eduveks
 */
public class Main extends Controller {
    private Principal principal;
    private Text text;

    public Main() {
        super();
        text = new Text();
        principal = new Principal(this, "Medita\u00E7\u00E3o Adventista");
        org.calango.Help help = new Help(this, "Medita\u00E7\u00E3o Adventista", principal);
        principal.setHelp(help);
        help.addContent("Medita\u00E7\u00E3o Adventista Mobile\n", "Vers\u00E3o 2.0\nCopyright \u00a9 2009\n");
        help.addContent("Website Oficial\n", "http://meditacaoadventistamobile.googlecode.com");
        help.addContent("Dia, M\u00EAs e Ano:", "\nAutomaticamente ser\u00E1 preenchido a data atual, mas pode escolher a medita\u00E7\u00E3o de outro dia colocando a data pretendida e depois clique em \"Ok\" para ver o texto da medita\u00E7\u00E3o.");
        help.addContent("Edi\u00E7\u00E3o:\n", "Escolha qual a edi\u00E7\u00E3o da medita\u00E7\u00E3o que deseja ler: Adulto, Mulher ou Juvenil.");
        help.addContent("Navegar no texto:\n", "Use o n\u00FAmero 6 para avan\u00e7ar e o n\u00FAmero 4 para voltar atr\u00e1s.");
        help.addContent("Cr\u00E9ditos\n", "Coordenador:\n   Miguel Sabino\nConte\u00FAdo:\n   Rui Coutinho\n   Joel Alegria\nDesenvolvedor:\n   Eduardo Velasques");
        help.addContent("Licen\u00E7a\n", "GNU General Public License v3\nhttp://www.gnu.org/licenses/\n");
        help.addContent("Nota\n", "O Medita\u00E7\u00E3o Adventista Mobile \u00E9 um projeto sem fins lucrativos, que tem por \u00FAnico objetivo facilitar o acesso a Medita\u00E7\u00E3o Adventista de uma forma alternativa e simples.\n\nN\u00E3o \u00E9 nosso interesse lesar ningu\u00E9m nos seus direitos de autor e se algu\u00E9m se sentir lesado agradecemos que nos contate de imediato atrav\u00E9s do endere\u00E7o meditacaomobile@gmail.com.\n\nObrigado,\n\nA equipe do Medita\u00E7\u00E3o Adventista Mobile");
        addWorkFlowCommand("OK!", Command.SCREEN, principal, text);
        principal.loadBasicCommands("Ajuda", "Sair");
        addWorkFlowBack(text, principal);
        setStarter(principal);
        setWorkFlowAction(new WorkFlowAction() {
            public boolean action(final WorkFlow workFlow) {
                if (workFlow.getCommand().getLabel().equals("OK!")) {
                    principal.load(workFlow);
                    return false;
                }
                return true;
            }
        });
    }

    public Text getText() {
        return text;
    }

    public Principal getPrincipal() {
        return principal;
    }
}
