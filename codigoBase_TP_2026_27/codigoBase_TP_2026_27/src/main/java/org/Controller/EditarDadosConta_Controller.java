package org.Controller;

import java.util.Objects;

import org.Model.AssistenteDigital;
import org.Model.UtilizadorFinal;

/**
 * Controller da edição dos dados da conta. A edição é feita
 * diretamente sobre o utilizador final guardado (não é criada nenhuma cópia).
 * Para permitir cancelar, o controller guarda apenas os três valores originais.
 *
 * @author (nome do aluno)
 */
public class EditarDadosConta_Controller
{
    private final AssistenteDigital assistente;
    private UtilizadorFinal utf;

    private String nomeOriginal;
    private String emailOriginal;
    private String passwordOriginal;

    /**
     * Constrói o controller.
     *
     * @param assistenteDigital a classe principal do domínio
     */
    public EditarDadosConta_Controller(AssistenteDigital assistenteDigital)
    {
        this.assistente = assistenteDigital;
    }

    /**
     * Obtém a conta a editar a partir do email.
     *
     * @param email o email da conta
     * @return true se a conta existe, caso contrário devolve false
     */
    public boolean obterConta(String email)
    {
        this.utf = assistente.obterUtilizadorFinalByEmail(email);
        if (this.utf == null)
        {
            return false;
        }
        this.nomeOriginal = utf.getNome();
        this.emailOriginal = utf.getEmail();
        this.passwordOriginal = utf.getPassword();
        return true;
    }

    /**
     * Devolve a descrição textual do utilizador final em edição.
     *
     * @return descrição do utilizador final
     */
    public String getUtilizadorFinalAsString()
    {
        return this.utf.toString();
    }

    /**
     * Atribui os novos dados ao utilizador final. Um valor nulo ou vazio
     * mantém o valor atual.
     *
     * @param nome     o novo nome
     * @param email    o novo email
     * @param password a nova palavra-passe
     */
    public void setDados(String nome, String email, String password)
    {
        if (nome != null && !nome.trim().isEmpty())
        {
            this.utf.setNome(nome);
        }
        if (email != null && !email.trim().isEmpty())
        {
            this.utf.setEmail(email);
        }
        if (password != null && !password.isEmpty())
        {
            this.utf.setPassword(password);
        }
    }

    /**
     * Indica se os dados atuais diferem dos dados originais da conta.
     *
     * @return true se existirem alterações, caso contrário devolve false
     */
    public boolean existemAlteracoes()
    {
        return !Objects.equals(nomeOriginal, utf.getNome())
                || !Objects.equals(emailOriginal, utf.getEmail())
                || !Objects.equals(passwordOriginal, utf.getPassword());
    }

    /**
     * Confirma a edição dos dados da conta.
     *
     * @return true se os dados editados são válidos, caso contrário devolve
     *         false
     */
    public boolean editarDadosConta()
    {
        return this.assistente.editarDadosConta(this.utf);
    }

    /**
     * Cancela a edição, repondo os dados originais da conta.
     */
    public void cancelarEdicao()
    {
        this.utf.setNome(nomeOriginal);
        this.utf.setEmail(emailOriginal);
        this.utf.setPassword(passwordOriginal);
    }
}