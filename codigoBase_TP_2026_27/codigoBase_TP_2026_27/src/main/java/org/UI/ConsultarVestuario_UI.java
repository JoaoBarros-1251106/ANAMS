package org.UI;

import org.Controller.ConsultarVestuario_Controller;
import org.Model.AssistenteDigital;
import org.Utils.*;


public class ConsultarVestuario_UI {
    private AssistenteDigital assistente;
    private ConsultarVestuario_Controller controller;

    public ConsultarVestuario_UI(AssistenteDigital assistenteDigital)
    {
        this.assistente = assistenteDigital;
        controller = new ConsultarVestuario_Controller(assistenteDigital);
    }

    public void run()
    {
        System.out.println(controller.obterVestuariosAsString());

        int id = Utils.IntFromConsole("Introduza o id do vestuário: ");

        if (!controller.selecionaVestuario(id))
        {
            System.out.println("Vestuário não encontrado.");
            return;
        }

        System.out.println("\nVestuário:\n" + controller.getVestuarioAsString());

        Utils.readLineFromConsole("Prima Enter para sair.");
        System.out.println("Consulta concluída com sucesso.");
    }
}
