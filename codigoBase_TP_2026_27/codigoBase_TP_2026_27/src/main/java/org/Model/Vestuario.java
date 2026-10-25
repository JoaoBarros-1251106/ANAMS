/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.Model;

/**
 *
 * @author Dulce Mota <mdm@isep.ipp.pt>
 */
public class Vestuario
{
    private int idPeca;
    private String nome;
    private String sigla;
    private String descricao;

    private static final String STRING_POR_OMISSAO = "a definir";

    public Vestuario()
    {
        this.idPeca = 0;
        this.nome = STRING_POR_OMISSAO;
        this.sigla = STRING_POR_OMISSAO;
        this.descricao = STRING_POR_OMISSAO;
    }
    public Vestuario(int idPeca, String nome, String descricao)
    {
        this.idPeca = idPeca;
        this.nome = nome;
        this.descricao = descricao;
        this.sigla = STRING_POR_OMISSAO;
    }
    public Vestuario(String sigla, String descricao)
    {
        this.idPeca = 0;
        this.nome = STRING_POR_OMISSAO;
        this.sigla = sigla;
        this.descricao = descricao;
    }

    public int getIdPeca()
    {
        return idPeca;
    }

    public void setIdPeca(int idPeca)
    {
        this.idPeca = idPeca;
    }

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
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

    // Validação local
    public boolean valida()
    {
        if (nome != null && !nome.equalsIgnoreCase(STRING_POR_OMISSAO)) {
            return !nome.trim().isEmpty() && descricao != null && !descricao.trim().isEmpty();
        }
        if (sigla != null && !sigla.equalsIgnoreCase(STRING_POR_OMISSAO)) {
            return !sigla.trim().isEmpty() && descricao != null && !descricao.trim().isEmpty();
        }
        return false;
    }

    @Override
    public String toString() {
        return "Vestuario{" +
                "idPeca=" + idPeca +
                ", nome='" + nome + '\'' +
                ", sigla='" + sigla + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
