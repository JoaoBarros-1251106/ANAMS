/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.UI;

import java.io.IOException;

import org.Model.AssistenteDigital;
import org.Utils.*;

/**
 *
 * @author Dulce Mota <mdm@isep.ipp.pt>
 */
public class MenuInicial_UI
{
    private AssistenteDigital assistente;
    private String opcao;

    public MenuInicial_UI(AssistenteDigital assistente)
    {
        this.assistente = assistente;
    }
    public void run() throws IOException
    {
        do
        {   // Completar/Adaptar
            System.out.println("###### MENU #####");
            System.out.println("1. Utilizador não registado (UNR)");
            System.out.println("2. Administrador (Adm)");
            System.out.println("3. Utilizador Final (UtF)");
            System.out.println("0. Sair");

            opcao = Utils.readLineFromConsole("Escolha uma opção: ");

            if( opcao.equals("1") )
            {
                MenuUNR_UI ui = new MenuUNR_UI(assistente);
                ui.run();
            }
            else
            if( opcao.equals("2") )
            {
                MenuAdm_UI ui = new MenuAdm_UI(assistente);
                ui.run();
            }
            else
            if( opcao.equals("3") )
            {
                MenuUTF_UI ui = new MenuUTF_UI(assistente);
                ui.run();
            }
        }
        while (!opcao.equals("0") );
    }
}
