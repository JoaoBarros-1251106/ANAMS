package org.UI;

import org.Utils.*;
import org.Model.AssistenteDigital;
import org.Controller.EspecificarOcasiao_Controller;

public class EspecificarOcasiao_UI
{
    private AssistenteDigital assistente;
    private EspecificarOcasiao_Controller controller;

    public EspecificarOcasiao_UI(AssistenteDigital assistenteDigital)
    {
        this.assistente = assistenteDigital;
        controller = new EspecificarOcasiao_Controller(assistenteDigital);
    }

    public void run()
    {
        System.out.println("\nNovo Tipo de Ocasião:");
        controller.novaOcasiao();

        introduzDados();

        apresentaDados();

        if (Utils.confirma("Confirma os dados? (S/N)"))
        {
            if (controller.especificarOcasiao())
            {
                System.out.println("Dados do tipo de ocasião guardados com sucesso.");
            }
            else
            {
                System.out.println("Não foi possível guardar os dados do tipo de ocasião.");
            }
        }
    }

    private void introduzDados()
    {
        String sigla = Utils.readLineFromConsole("Introduza a sigla: ");
        String descricao = Utils.readLineFromConsole("Introduza uma descrição: ");
        controller.setDados(sigla, descricao);
    }

    private void apresentaDados()
    {
        System.out.println("\nTipo de ocasião:\n" + controller.getOcasiaoAsString());
    }
}