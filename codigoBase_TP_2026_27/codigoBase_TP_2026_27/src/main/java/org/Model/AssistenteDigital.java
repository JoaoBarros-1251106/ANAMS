/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe principal do domínio: engloba os tipos de vestuário e os
 * utilizadores finais da aplicação.
 *
 * @author Dulce Mota <mdm@isep.ipp.pt>
 */
public class AssistenteDigital
{

    private final List<Vestuario> lstTiposVestuario;
    private final List<Ocasiao> lstTiposOcasiao;
    private final List<PecaVestuario> lstVestuarios;
    private List<Vestuario> listaVestuarios;
    private Vestuario vestuarioEmCriacao;
    private int proximoIdPeca = 1;

    /**
     * Lista dos utilizadores finais (UtF) com conta criada.
     */
    private final List<UtilizadorFinal> lstUtilizadoresFinais;

    public AssistenteDigital()
    {
        this.lstTiposVestuario = new ArrayList<>();
        this.lstTiposOcasiao = new ArrayList<>();
        this.lstVestuarios = new ArrayList<>();
        this.lstUtilizadoresFinais = new ArrayList<>();
    }

    public Vestuario novoTipoVestuario()
    {
        return new Vestuario();
    }
    public boolean especificarTipoVesturaio(Vestuario vestuario)
    {
        if (this.valida(vestuario))
        {
            adicionarTipoVestuario(vestuario);
            return true;
        }
        return false;
    }

    private boolean existeSiglaVestuario(String sigla)
    {
        for (Vestuario v : lstTiposVestuario)
        {
            if (v.getSigla().equalsIgnoreCase(sigla.trim()))
            {
                return true;
            }
        }
        return false;
    }

    private void adicionarTipoVestuario(Vestuario vestuario){
        lstTiposVestuario.add(vestuario);
    }
    // Validação global
    public boolean valida(Vestuario vestuario)
    {
        boolean resp = false;
        if (vestuario.valida() && !existeSiglaVestuario(vestuario.getSigla()))
        {

            resp = true;
        }
        return resp;
    }

    // ------------------------------------------------------------------
    // Criar conta
    // ------------------------------------------------------------------

    /**
     * Cria uma nova instância de utilizador final (ainda não guardada).
     *
     * @return o novo utilizador final
     */
    public UtilizadorFinal novoUtilizadorFinal()
    {
        return new UtilizadorFinal();
    }

    /**
     * Cria a conta de um utilizador final: valida os dados e, se forem
     * válidos, guarda o utilizador.
     *
     * @param utf o utilizador final a guardar
     * @return true se a conta foi criada, caso contrário devolve false
     */
    public boolean criarConta(UtilizadorFinal utf)
    {
        if (this.valida(utf))
        {
            adicionarUtilizadorFinal(utf);
            return true;
        }
        return false;
    }

    /**
     * Guarda um utilizador final.
     *
     * @param utf o utilizador final a guardar
     */
    private void adicionarUtilizadorFinal(UtilizadorFinal utf)
    {
        lstUtilizadoresFinais.add(utf);
    }

    /**
     * Validação global de um utilizador final: valida localmente os dados e
     * verifica que o email não pertence a outra conta.
     *
     * @param utf o utilizador final a validar
     * @return true se o utilizador final for válido, caso contrário devolve
     *         false
     */
    public boolean valida(UtilizadorFinal utf)
    {
        boolean resp = false;
        if (utf != null && utf.valida())
        {
            resp = !existeEmail(utf);
        }
        return resp;
    }

    /**
     * Indica se o email do utilizador final já pertence a outra conta. O
     * próprio utilizador é ignorado, o que permite validar edições.
     *
     * @param utf o utilizador final cujo email é verificado
     * @return true se existir outra conta com o mesmo email, caso contrário
     *         devolve false
     */
    private boolean existeEmail(UtilizadorFinal utf)
    {
        for (UtilizadorFinal outro : lstUtilizadoresFinais)
        {
            if (outro != utf && outro.getEmail().equalsIgnoreCase(utf.getEmail()))
            {
                return true;
            }
        }
        return false;
    }

    // ------------------------------------------------------------------
    // Editar dados da conta
    // ------------------------------------------------------------------

    /**
     * Devolve o utilizador final que possui o email indicado.
     *
     * @param email o email da conta
     * @return o utilizador final ou null se não existir
     */
    public UtilizadorFinal obterUtilizadorFinalByEmail(String email)
    {
        if (email != null)
        {
            for (UtilizadorFinal utf : lstUtilizadoresFinais)
            {
                if (utf.getEmail().equalsIgnoreCase(email.trim()))
                {
                    return utf;
                }
            }
        }
        return null;
    }

    /**
     * Confirma a edição dos dados de uma conta. O utilizador final já foi
     * alterado diretamente, pelo que só é necessário voltar a validá-lo.
     *
     * @param utf o utilizador final editado
     * @return true se os dados editados forem válidos, caso contrário devolve
     *         false
     */
    public boolean editarDadosConta(UtilizadorFinal utf)
    {
        return lstUtilizadoresFinais.contains(utf) && this.valida(utf);
    }
    //-------------------------------
    // UC1 - Registar vestuário

    public PecaVestuario novoVestuario()
    {
        return new PecaVestuario();
    }
    public boolean registaVestuario(PecaVestuario v)
    {
        if (this.valida(v))
        {
            adicionaVestuario(v);
            return true;
        }
        return false;
    }
    private void adicionaVestuario(PecaVestuario v)
    {
        lstVestuarios.add(v);
    }
    // Validação global

    public Vestuario getTipoVestuario(String sigla)
    {
        for (Vestuario v : lstTiposVestuario)
        {
            if (v.getSigla().equalsIgnoreCase(sigla.trim()))
            {
                return v;
            }
        }
        return null;
    }

    public boolean valida(PecaVestuario v)
    {
        return v.valida();
    }

    // UC2, UC3 e UC4 - Listar, procurar e remover vestuários

    public String obterVestuariosAsString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("Listagem de vestuários\n");
        for (PecaVestuario v : lstVestuarios)
        {
            sb.append(v.toString());
        }
        return sb.toString();
    }
    public PecaVestuario getVestuario(int id)
    {
        for (PecaVestuario v : lstVestuarios)
        {
            if (v.getIdPeca() == id)
            {
                return v;
            }
        }
        return null;
    }
    public boolean removeVestuario(PecaVestuario v)
    {
        return lstVestuarios.remove(v);
    }

    //------------------------------------------------
    // Completar com outras funcionalidades

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("AssistenteDigital: \n");
        sb.append("Listagem de tipos de vestuário: "+ lstTiposVestuario.toString()+"\n");
        sb.append("Listagem de utilizadores finais: "+ lstUtilizadoresFinais.toString()+"\n");
        return sb.toString();
    }
    public String obterTiposVestuarioAsString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Listagem de tipos de vestuário\n");
        for(Vestuario v: lstTiposVestuario){
            sb.append(v.toString());
        }
        return sb.toString();
    }
    public Ocasiao novaOcasiao()
    {
        return new Ocasiao();
    }

    public boolean especificarOcasiao(Ocasiao ocasiao)
    {
        if (this.valida(ocasiao))
        {
            adicionarOcasiao(ocasiao);
            return true;
        }
        return false;
    }

    private void adicionarOcasiao(Ocasiao ocasiao)
    {
        lstTiposOcasiao.add(ocasiao);
    }

    public boolean valida(Ocasiao ocasiao)
    {
        return ocasiao.valida() && !existeSiglaOcasiao(ocasiao.getSigla());
    }

    private boolean existeSiglaOcasiao(String sigla)
    {
        for (Ocasiao o : lstTiposOcasiao)
        {
            if (o.getSigla().equalsIgnoreCase(sigla.trim()))
            {
                return true;
            }
        }
        return false;
    }

    public Ocasiao getOcasiao(String sigla)
    {
        for (Ocasiao o : lstTiposOcasiao)
        {
            if (o.getSigla().equalsIgnoreCase(sigla.trim()))
            {
                return o;
            }
        }
        return null;
    }

    public String obterOcasioesAsString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("Listagem de tipos de ocasião\n");
        for (Ocasiao o : lstTiposOcasiao)
        {
            sb.append(o.toString()).append("\n");
        }
        return sb.toString();
    }

}
    
