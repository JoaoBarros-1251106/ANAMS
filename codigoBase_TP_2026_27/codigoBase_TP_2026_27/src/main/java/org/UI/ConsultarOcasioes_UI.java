package org.UI;

import org.Controller.ConsultarOcasioes_Controller;
import org.Model.AssistenteDigital;

public class ConsultarOcasioes_UI
{
    private AssistenteDigital assistente;
    private ConsultarOcasioes_Controller controller;

    public ConsultarOcasioes_UI(AssistenteDigital assistenteDigital)
    {
        this.assistente = assistenteDigital;
        controller = new ConsultarOcasioes_Controller(assistenteDigital);
    }

    public void run()
    {
        String lto = controller.obterOcasioesAsString();
        System.out.println(lto);
    }
}