package org.Controller;

import org.Model.AssistenteDigital;
import org.Model.PecaVestuario;

public class ConsultarVestuario_Controller {
    private final AssistenteDigital assistente;
    private PecaVestuario vestuario;

    public ConsultarVestuario_Controller(AssistenteDigital assistenteDigital)
    {
        this.assistente = assistenteDigital;
    }

    public String obterVestuariosAsString()
    {
        return assistente.obterVestuariosAsString();
    }

    public boolean selecionaVestuario(int id)
    {
        this.vestuario = assistente.getVestuario(id);
        return this.vestuario != null;
    }

    public String getVestuarioAsString()
    {
        return this.vestuario.toString();
    }
}
