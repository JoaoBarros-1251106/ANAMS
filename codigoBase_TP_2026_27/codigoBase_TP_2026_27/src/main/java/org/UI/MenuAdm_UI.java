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
public class MenuAdm_UI
{
    private AssistenteDigital assistente;
    private String opcao;

    public MenuAdm_UI(AssistenteDigital assistente)
    {
        this.assistente = assistente;
    }
    public void run() throws IOException
    {
        do
        {   // Completar/Adaptar
            System.out.println("###### MENU #####\n\n");
            System.out.println("1. Especificar tipo de vestuário");
            System.out.println("2. Registar tipo de ocasião");
            System.out.println("3. Consultar todos os tipos de vestuário");
            System.out.println("4. Consultar tipos de ocasião");
            System.out.println("0. Voltar");

            opcao = Utils.readLineFromConsole("Escolha uma opção: ");

            if( opcao.equals("1") )
            {
                EspecificarTipoVestuario_UI ui = new EspecificarTipoVestuario_UI(assistente);
                ui.run();
            }
            else

            if( opcao.equals("2") )
            {
                EspecificarOcasiao_UI ui = new EspecificarOcasiao_UI(assistente);
                ui.run();

            }
            else
            if( opcao.equals("3") )
            {
                ConsultarTiposVestuario_UI ui = new ConsultarTiposVestuario_UI(assistente);
                ui.run();
            }
            else
            if( opcao.equals("4") )
            {
                ConsultarOcasioes_UI ui = new ConsultarOcasioes_UI(assistente);
                ui.run();
            }
        }
        while (!opcao.equals("0") );
    }
}


