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
    // Completar/Adaptar
    private final List<Vestuario> lstTiposVestuario;

    /**
     * Lista dos utilizadores finais (UtF) com conta criada.
     */
    private final List<UtilizadorFinal> lstUtilizadoresFinais;

    public AssistenteDigital()
    {
        this.lstTiposVestuario = new ArrayList<>();
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

    private void adicionarTipoVestuario(Vestuario vestuario){
        lstTiposVestuario.add(vestuario);
    }
    // Validação global
    public boolean valida(Vestuario vestuario)
    {
        boolean resp = false;
        if (vestuario.valida())
        {
            // Completar
            //
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
}
    
