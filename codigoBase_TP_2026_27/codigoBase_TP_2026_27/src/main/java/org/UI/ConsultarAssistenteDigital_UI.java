package org.UI;

import org.Controller.ConsultarAssistenteDigital_Controller;
import org.Model.AssistenteDigital;
import org.Utils.*;

public class ConsultarAssistenteDigital_UI {

    private AssistenteDigital assistente;
    private ConsultarAssistenteDigital_Controller controller;

    public ConsultarAssistenteDigital_UI(AssistenteDigital assistenteDigital)
    {
        this.assistente = assistenteDigital;
        controller = new ConsultarAssistenteDigital_Controller(assistenteDigital);
    }

    public void run()
    {
        System.out.println(controller.obterVestuariosAsString());

        Utils.readLineFromConsole("Prima Enter para sair.");
        System.out.println("Consulta concluída com sucesso.");
    }
}
