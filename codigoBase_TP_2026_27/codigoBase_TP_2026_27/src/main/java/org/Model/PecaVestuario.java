package org.Model;

import java.util.ArrayList;
import java.util.List;

public class PecaVestuario {
    private static int contador = 0;

    private int idPeca;
    private String nome;
    private String descricao;
    private Vestuario tipo;
    private final List<Ocasiao> ocasioes = new ArrayList<>();

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

    public Vestuario getTipo()
    {
        return tipo;
    }

    public void setTipo(Vestuario tipo)
    {
        this.tipo = tipo;
    }

    public void addOcasiao(Ocasiao ocasiao)
    {
        if (!ocasioes.contains(ocasiao))
        {
            ocasioes.add(ocasiao);
        }
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
        return nome != null && !nome.isBlank() && descricao != null && !descricao.isBlank() && tipo != null;
    }

    public String toString()
    {
        String siglaTipo = (tipo == null) ? "sem tipo" : tipo.getSigla();
        StringBuilder sbOcasioes = new StringBuilder();
        for (Ocasiao o : ocasioes)
        {
            if (sbOcasioes.length() > 0)
            {
                sbOcasioes.append(", ");
            }
            sbOcasioes.append(o.getSigla());
        }
        String textoOcasioes = (ocasioes.isEmpty()) ? "nenhuma" : sbOcasioes.toString();
        return "Id: " + idPeca + " - Nome: " + nome + " - Descrição: " + descricao + " - Tipo: " + siglaTipo + " - Ocasiões: " + textoOcasioes + "\n";
    }
}