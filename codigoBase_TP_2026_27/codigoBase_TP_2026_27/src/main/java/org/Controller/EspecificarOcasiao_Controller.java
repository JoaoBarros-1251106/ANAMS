package org.Controller;

import org.Model.AssistenteDigital;
import org.Model.Ocasiao;

public class EspecificarOcasiao_Controller
{
    private final AssistenteDigital assistente;
    private Ocasiao ocasiao;

    public EspecificarOcasiao_Controller(AssistenteDigital assistenteDigital)
    {
        this.assistente = assistenteDigital;
    }

    public void novaOcasiao()
    {
        this.ocasiao = assistente.novaOcasiao();
    }

    public void setDados(String sigla, String descricao)
    {
        this.ocasiao.setSigla(sigla);
        this.ocasiao.setDescricao(descricao);
    }

    public boolean especificarOcasiao()
    {
        return this.assistente.especificarOcasiao(this.ocasiao);
    }

    public String getOcasiaoAsString()
    {
        return this.ocasiao.toString();
    }
}