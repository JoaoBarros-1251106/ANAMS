package org.UI;

import java.io.IOException;

import org.Model.AssistenteDigital;
import org.Utils.*;

/**
 *
 * @author Dulce Mota <mdm@isep.ipp.pt>
 */
public class MenuUTF_UI
{
    private AssistenteDigital assistente;
    private String opcao;

    public MenuUTF_UI(AssistenteDigital assistente)
    {
        this.assistente = assistente;
    }
    public void run() throws IOException
    {
        do
        {  // Completar/Adaptar
            System.out.println("###### MENU #####\n\n");
            System.out.println("1. Introduzir/registar peça de vestuário");
            System.out.println("2. Editar dados da conta");
            System.out.println("3. Eliminar vestuário");
            System.out.println("4. Consultar AssistenteDigital");
            System.out.println("5. Consultar vestuário");

            System.out.println("0. Voltar");

            opcao = Utils.readLineFromConsole("Escolha uma opção: ");

            if( opcao.equals("1") )
            {
                //
                System.out.println("Selecionou a opção 1");
                RegistarVestuario_UI ui = new RegistarVestuario_UI(assistente);
                ui.run();
            }
            else
            if( opcao.equals("2") )
            {
                EditarDadosConta_UI ui = new EditarDadosConta_UI(assistente);
                ui.run();
            }
            else
            if( opcao.equals("3") )
            {
                //
                System.out.println("Selecionou a opção 3");
                EliminarVestuario_UI ui = new EliminarVestuario_UI(assistente);
                ui.run();
            }
            else
            if( opcao.equals("4") )
            {
                //
                System.out.println("Selecionou a opção 4");
                ConsultarAssistenteDigital_UI ui = new ConsultarAssistenteDigital_UI(assistente);
                ui.run();
            }
            else
            if( opcao.equals("5") )
            {
                //
                System.out.println("Selecionou a opção 5");
                ConsultarVestuario_UI ui = new ConsultarVestuario_UI(assistente);
                ui.run();
            }

        }
        while (!opcao.equals("0") );
    }
}