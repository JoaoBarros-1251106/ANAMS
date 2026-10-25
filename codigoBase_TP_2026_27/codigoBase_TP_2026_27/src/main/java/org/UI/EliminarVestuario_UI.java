package org.UI;

import org.Controller.EliminarVestuario_Controller;
import org.Model.AssistenteDigital;
import org.Utils.*;


public class EliminarVestuario_UI {
    private AssistenteDigital assistente;
    private EliminarVestuario_Controller controller;

    public EliminarVestuario_UI(AssistenteDigital assistenteDigital)
    {
        this.assistente = assistenteDigital;
        controller = new EliminarVestuario_Controller(assistenteDigital);
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

        if (Utils.confirma("Pretende remover este vestuário? (S/N)"))
        {
            if (Utils.confirma("Confirma a remoção? (S/N)"))
            {
                if (controller.eliminaVestuario())
                {
                    System.out.println("Vestuário eliminado com sucesso.");
                }
                else
                {
                    System.out.println("Não foi possível eliminar o vestuário.");
                }
            }
        }
    }
}
