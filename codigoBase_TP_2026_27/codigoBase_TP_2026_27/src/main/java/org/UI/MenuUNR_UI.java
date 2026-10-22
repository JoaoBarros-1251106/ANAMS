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
public class MenuUNR_UI
{
    private AssistenteDigital assistente;
    private String opcao;

    public MenuUNR_UI(AssistenteDigital assistente)
    {
        this.assistente = assistente;
    }
    public void run() throws IOException
    {
        do
        {
            System.out.println("###### MENU #####\n\n");
            System.out.println("1. Fazer registo");
            System.out.println("0. Voltar");

            opcao = Utils.readLineFromConsole("Escolha uma opção: ");

            if( opcao.equals("1") )
            {
                CriarConta_UI ui = new CriarConta_UI(assistente);
                ui.run();
                System.out.println("Selecionou a opção 1");
            }
        }
        while (!opcao.equals("0") );
    }
}
