package org.Controller;

import org.Model.AssistenteDigital;
import org.Model.Ocasiao;
import org.Model.PecaVestuario;
import org.Model.Vestuario;

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

    public String obterTiposVestuarioAsString()
    {
        return assistente.obterTiposVestuarioAsString();
    }

    public boolean setTipo(String sigla)
    {
        Vestuario tipo = assistente.getTipoVestuario(sigla);
        this.vestuario.setTipo(tipo);
        return tipo != null;
    }

    public String obterOcasioesAsString()
    {
        return assistente.obterOcasioesAsString();
    }

    public boolean adicionaOcasiao(String sigla)
    {
        Ocasiao ocasiao = assistente.getOcasiao(sigla);
        if (ocasiao == null)
        {
            return false;
        }
        this.vestuario.addOcasiao(ocasiao);
        return true;
    }

    public String getVestuarioAsString()
    {
        return this.vestuario.toString();
    }

    public boolean registaVestuario()
    {
        return assistente.registaVestuario(this.vestuario);
    }
}