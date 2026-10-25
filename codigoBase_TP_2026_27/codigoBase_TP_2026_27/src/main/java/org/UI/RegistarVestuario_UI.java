package org.UI;

import org.Controller.RegistarVestuario_Controller;
import org.Model.AssistenteDigital;
import org.Utils.*;


public class RegistarVestuario_UI {
    private AssistenteDigital assistente;
    private RegistarVestuario_Controller controller;

    public RegistarVestuario_UI(AssistenteDigital assistenteDigital)
    {
        this.assistente = assistenteDigital;
        controller = new RegistarVestuario_Controller(assistenteDigital);
    }

    public void run()
    {
        System.out.println("\nNovo Vestuário:");
        controller.novoVestuario();

        String nome = Utils.readLineFromConsole("Introduza o nome: ");
        String descricao = Utils.readLineFromConsole("Introduza a descrição: ");
        controller.setDados(nome, descricao);

        System.out.println("\nNome: " + nome + " - Descrição: " + descricao);

        if (Utils.confirma("Confirma os dados? (S/N)"))
        {
            if (controller.registaVestuario())
            {
                System.out.println("Vestuário registado com sucesso.");
            }
            else
            {
                System.out.println("Não foi possível registar o vestuário.");
            }
        }
    }
}
