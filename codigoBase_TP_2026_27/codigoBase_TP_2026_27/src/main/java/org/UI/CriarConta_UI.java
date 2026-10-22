package org.UI;

import org.Controller.CriarConta_Controller;
import org.Model.AssistenteDigital;
import org.Utils.*;

/**
 * Interface com o utilizador para criar uma conta.
 *
 * @author (nome do aluno)
 */
public class CriarConta_UI
{
    private AssistenteDigital assistente;
    private CriarConta_Controller controller;

    /**
     * Constrói a UI e o respetivo controller.
     *
     * @param assistenteDigital a classe principal do domínio
     */
    public CriarConta_UI(AssistenteDigital assistenteDigital)
    {
        this.assistente = assistenteDigital;
        controller = new CriarConta_Controller(assistenteDigital);
    }

    /**
     * Executa o caso de uso. Se os dados forem inválidos ou o email já
     * existir, permite corrigir os dados ou terminar.
     */
    public void run()
    {
        System.out.println("\nNova Conta:");
        controller.novoUtilizadorFinal();

        boolean terminado = false;
        do
        {
            introduzDados();

            apresentaDados();

            if (!Utils.confirma("Confirma os dados? (S/N)"))
            {
                System.out.println("Operação cancelada.");
                terminado = true;
            }
            else if (controller.criarConta())
            {
                System.out.println("Conta criada com sucesso.");
                terminado = true;
            }
            else
            {
                System.out.println("Não foi possível criar a conta. Verifique se os dados são válidos e se o email ainda não está registado.");
                terminado = !Utils.confirma("Pretende corrigir os dados? (S/N)");
            }
        }
        while (!terminado);
    }

    private void introduzDados()
    {
        String nome = Utils.readLineFromConsole("Introduza o nome: ");
        String email = Utils.readLineFromConsole("Introduza o email: ");
        String password = Utils.readLineFromConsole("Introduza a palavra-passe: ");
        controller.setDados(nome, email, password);
    }

    private void apresentaDados()
    {
        System.out.println("\nConta:\n" + controller.getUtilizadorFinalAsString());
    }
}