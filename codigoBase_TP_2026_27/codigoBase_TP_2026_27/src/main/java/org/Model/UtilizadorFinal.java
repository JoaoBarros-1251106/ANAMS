package org.Model;

/**
 * Representa um utilizador final (UtF) da aplicação, i.e., a pessoa que
 * possui uma conta e a quem são propostas sugestões de vestuário.
 *
 * @author (nome do aluno)
 */
public class UtilizadorFinal
{
    /**
     * Nome do utilizador final.
     */
    private String nome;

    /**
     * Email do utilizador final (identifica a conta).
     */
    private String email;

    /**
     * Palavra-passe do utilizador final.
     */
    private String password;

    /**
     * Valor usado por omissão nos atributos de texto.
     */
    private static final String STRING_POR_OMISSAO = "a definir";

    /**
     * Texto apresentado no lugar da palavra-passe.
     */
    private static final String PASSWORD_OCULTA = "********";

    /**
     * Expressão regular com o formato mínimo aceite para um email.
     */
    private static final String REGEX_EMAIL = "^[\\w.+-]+@[\\w-]+(\\.[\\w-]+)+$";

    /**
     * Constrói uma instância de UtilizadorFinal com os valores por omissão.
     */
    public UtilizadorFinal()
    {
        this.setNome(STRING_POR_OMISSAO);
        this.setEmail(STRING_POR_OMISSAO);
        this.setPassword(STRING_POR_OMISSAO);
    }

    /**
     * Constrói uma instância de UtilizadorFinal recebendo o nome, o email e a
     * palavra-passe.
     *
     * @param nome     o nome do utilizador final
     * @param email    o email do utilizador final
     * @param password a palavra-passe do utilizador final
     */
    public UtilizadorFinal(String nome, String email, String password)
    {
        this.setNome(nome);
        this.setEmail(email);
        this.setPassword(password);
    }

    /**
     * Devolve o nome do utilizador final.
     *
     * @return nome do utilizador final
     */
    public String getNome()
    {
        return nome;
    }

    /**
     * Devolve o email do utilizador final.
     *
     * @return email do utilizador final
     */
    public String getEmail()
    {
        return email;
    }

    /**
     * Devolve a palavra-passe do utilizador final.
     *
     * @return palavra-passe do utilizador final
     */
    public String getPassword()
    {
        return password;
    }

    /**
     * Modifica o nome do utilizador final (remove espaços no início e no fim).
     *
     * @param nome o novo nome
     */
    public void setNome(String nome)
    {
        this.nome = (nome == null) ? null : nome.trim();
    }

    /**
     * Modifica o email do utilizador final (remove espaços no início e no fim).
     *
     * @param email o novo email
     */
    public void setEmail(String email)
    {
        this.email = (email == null) ? null : email.trim();
    }

    /**
     * Modifica a palavra-passe do utilizador final.
     *
     * @param password a nova palavra-passe
     */
    public void setPassword(String password)
    {
        this.password = password;
    }

    /**
     * Validação local: o nome e a palavra-passe não podem ser vazios e o email
     * tem de ter um formato válido. As regras são mínimas e devem ser
     * confirmadas com o cliente.
     *
     * @return true se os dados forem válidos, caso contrário devolve false
     */
    public boolean valida()
    {
        boolean nomeValido = nome != null && !nome.isEmpty();
        boolean emailValido = email != null && email.matches(REGEX_EMAIL);
        boolean passwordValida = password != null && !password.isEmpty();
        return nomeValido && emailValido && passwordValida;
    }

    /**
     * Devolve a descrição textual do utilizador final. A palavra-passe nunca é
     * apresentada.
     *
     * @return características do utilizador final
     */
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("Nome: " + nome + " - ");
        sb.append("Email: " + email + " - ");
        sb.append("Palavra-passe: " + PASSWORD_OCULTA + "\n");
        return sb.toString();
    }
}