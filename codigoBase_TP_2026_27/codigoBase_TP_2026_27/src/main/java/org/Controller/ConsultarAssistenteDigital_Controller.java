package org.Controller;

import org.Model.AssistenteDigital;

public class ConsultarAssistenteDigital_Controller {
    private final AssistenteDigital assistente;

    public ConsultarAssistenteDigital_Controller(AssistenteDigital assistenteDigital)
    {
        this.assistente = assistenteDigital;
    }

    public String obterVestuariosAsString()
    {
        return assistente.obterVestuariosAsString();
    }
}
