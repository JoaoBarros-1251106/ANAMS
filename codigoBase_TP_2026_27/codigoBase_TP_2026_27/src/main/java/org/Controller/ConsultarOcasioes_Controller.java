package org.Controller;

import org.Model.AssistenteDigital;

public class ConsultarOcasioes_Controller
{
    private final AssistenteDigital assistente;

    public ConsultarOcasioes_Controller(AssistenteDigital assistenteDigital)
    {
        this.assistente = assistenteDigital;
    }

    public String obterOcasioesAsString()
    {
        return assistente.obterOcasioesAsString();
    }
}