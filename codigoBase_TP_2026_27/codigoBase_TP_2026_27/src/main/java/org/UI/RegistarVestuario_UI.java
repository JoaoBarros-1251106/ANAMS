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

        System.out.println("\n" + controller.obterTiposVestuarioAsString());
        String sigla = Utils.readLineFromConsole("Introduza a sigla do tipo de vestuário: ");

        if (!controller.setTipo(sigla))
        {
            System.out.println("Esse tipo de vestuário não existe. O Administrador tem de o criar primeiro.");
            return;
        }

        System.out.println("\n" + controller.obterOcasioesAsString());
        String siglaOcasiao = Utils.readLineFromConsole("Introduza a sigla de uma ocasião (Enter para terminar): ");
        while (!siglaOcasiao.trim().isEmpty())
        {
            if (controller.adicionaOcasiao(siglaOcasiao))
            {
                System.out.println("Ocasião adicionada.");
            }
            else
            {
                System.out.println("Essa ocasião não existe.");
            }
            siglaOcasiao = Utils.readLineFromConsole("Introduza outra sigla de ocasião (Enter para terminar): ");
        }

        System.out.println("\n" + controller.getVestuarioAsString());

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