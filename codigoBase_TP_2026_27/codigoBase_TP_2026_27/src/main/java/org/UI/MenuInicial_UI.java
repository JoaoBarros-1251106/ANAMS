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
                String utilizador = Utils.readLineFromConsole("Utilizador: ");
                String password = Utils.readLineFromConsole("Palavra-passe: ");

                if (assistente.autenticarAdmin(utilizador, password))
                {
                    MenuAdm_UI ui = new MenuAdm_UI(assistente);
                    ui.run();
                }
                else
                {
                    System.out.println("Credenciais de administrador incorretas.");
                }
            }
            else
            if( opcao.equals("3") )
            {
                String email = Utils.readLineFromConsole("Email: ");
                String password = Utils.readLineFromConsole("Palavra-passe: ");

                if (assistente.autenticar(email, password))
                {
                    MenuUTF_UI ui = new MenuUTF_UI(assistente);
                    ui.run();
                }
                else
                {
                    System.out.println("Email ou palavra-passe incorretos. Se ainda não tem conta, escolha a opção 1 (Utilizador não registado) e faça o registo.");
                }
            }
        }
        while (!opcao.equals("0") );
    }
}
