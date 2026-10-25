package org.Controller;

import org.Model.AssistenteDigital;
import org.Model.PecaVestuario;

public class RegistarVestuario_Controller {
    private final AssistenteDigital assistente;
    private PecaVestuario vestuario;

    public RegistarVestuario_Controller(AssistenteDigital assistenteDigital)
    {
        this.assistente = assistenteDigital;
    }

    public void novoVestuario()
    {
        this.vestuario = assistente.novoVestuario();
    }

    public void setDados(String nome, String descricao)
    {
        this.vestuario.setDados(nome, descricao);
    }

    public boolean registaVestuario()
    {
        return assistente.registaVestuario(this.vestuario);
    }
}
