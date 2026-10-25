package org.Model;

public class PecaVestuario {
    private static int contador = 0;

    private int idPeca;
    private String nome;
    private String descricao;

    private static final String STRING_POR_OMISSAO = "a definir";

    public PecaVestuario()
    {
        contador++;
        this.idPeca = contador;
        this.nome = STRING_POR_OMISSAO;
        this.descricao = STRING_POR_OMISSAO;
    }

    public int getIdPeca()
    {
        return idPeca;
    }

    public String getNome()
    {
        return nome;
    }

    public String getDescricao()
    {
        return descricao;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public void setDescricao(String descricao)
    {
        this.descricao = descricao;
    }

    public void setDados(String nome, String descricao)
    {
        this.nome = nome;
        this.descricao = descricao;
    }

    // Validação local
    public boolean valida()
    {
        return nome != null && !nome.isBlank() && descricao != null && !descricao.isBlank();
    }

    public String toString()
    {
        return "Id: " + idPeca + " - Nome: " + nome + " - Descrição: " + descricao + "\n";
    }
}
