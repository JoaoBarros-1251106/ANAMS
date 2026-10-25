package org.Model;

public class Ocasiao
{
    private String sigla;
    private String descricao;

    public Ocasiao()
    {
        this.sigla = "a definir";
        this.descricao = "a definir";
    }

    public String getSigla()
    {
        return sigla;
    }

    public void setSigla(String sigla)
    {
        this.sigla = sigla;
    }

    public String getDescricao()
    {
        return descricao;
    }

    public void setDescricao(String descricao)
    {
        this.descricao = descricao;
    }

    public boolean valida()
    {
        return sigla != null && !sigla.trim().isEmpty()
                && descricao != null && !descricao.trim().isEmpty();
    }

    @Override
    public String toString()
    {
        return "Ocasiao{sigla='" + sigla + "', descricao='" + descricao + "'}\n";
    }
}