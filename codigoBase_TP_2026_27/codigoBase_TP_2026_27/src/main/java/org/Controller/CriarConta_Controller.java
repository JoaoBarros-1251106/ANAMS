package org.Controller;

import org.Model.AssistenteDigital;
import org.Model.UtilizadorFinal;

/**
 * Controller da criação de conta. Coordena as ações da UI com o domínio.
 *
 * @author (nome do aluno)
 */
public class CriarConta_Controller
{
    private final AssistenteDigital assistente;
    private UtilizadorFinal utf;

    /**
     * Constrói o controller.
     *
     * @param assistenteDigital a classe principal do domínio
     */
    public CriarConta_Controller(AssistenteDigital assistenteDigital)
    {
        this.assistente = assistenteDigital;
    }

    /**
     * Cria um novo utilizador final (ainda não guardado).
     */
    public void novoUtilizadorFinal()
    {
        this.utf = assistente.novoUtilizadorFinal();
    }

    /**
     * Atribui os dados ao utilizador final em criação.
     *
     * @param nome     o nome
     * @param email    o email
     * @param password a palavra-passe
     */
    public void setDados(String nome, String email, String password)
    {
        this.utf.setNome(nome);
        this.utf.setEmail(email);
        this.utf.setPassword(password);
    }

    /**
     * Devolve a descrição textual do utilizador final em criação.
     *
     * @return descrição do utilizador final
     */
    public String getUtilizadorFinalAsString()
    {
        return this.utf.toString();
    }

    /**
     * Cria a conta do utilizador final.
     *
     * @return true se a conta foi criada, caso contrário devolve false
     */
    public boolean criarConta()
    {
        return this.assistente.criarConta(this.utf);
    }
}