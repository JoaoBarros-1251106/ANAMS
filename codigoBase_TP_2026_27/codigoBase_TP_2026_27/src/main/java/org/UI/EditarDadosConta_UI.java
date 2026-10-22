package org.UI;

import org.Controller.EditarDadosConta_Controller;
import org.Model.AssistenteDigital;
import org.Utils.*;

/**
 * Interface com o utilizador para editar os dados da conta.
 *
 * @author (nome do aluno)
 */
public class EditarDadosConta_UI
{
    private AssistenteDigital assistente;
    private EditarDadosConta_Controller controller;

    /**
     * Constrói a UI e o respetivo controller.
     *
     * @param assistenteDigital a classe principal do domínio
     */
    public EditarDadosConta_UI(AssistenteDigital assistenteDigital)
    {
        this.assistente = assistenteDigital;
        controller = new EditarDadosConta_Controller(assistenteDigital);
    }

    /**
     * Executa o caso de uso. Como ainda não existe autenticação, o email
     * identifica a conta a editar.
     */
    public void run()
    {
        System.out.println("\nEditar Dados da Conta:");
        String email = Utils.readLineFromConsole("Introduza o email da conta: ");

        if (!controller.obterConta(email))
        {
            System.out.println("Não existe nenhuma conta com esse email.");
            return;
        }

        boolean terminado = false;
        do
        {
            apresentaDados();

            introduzDados();

            if (!controller.existemAlteracoes())
            {
                System.out.println("Não existem alterações a guardar.");
                return;
            }

            apresentaDados();

            if (!Utils.confirma("Confirma os dados? (S/N)"))
            {
                controller.cancelarEdicao();
                System.out.println("Operação cancelada. Os dados mantêm-se inalterados.");
                terminado = true;
            }
            else if (controller.editarDadosConta())
            {
                System.out.println("Dados da conta alterados com sucesso.");
                terminado = true;
            }
            else
            {
                System.out.println("Não foi possível guardar as alterações. Verifique se os dados são válidos e se o email não pertence a outra conta.");
                if (!Utils.confirma("Pretende corrigir os dados? (S/N)"))
                {
                    controller.cancelarEdicao();
                    System.out.println("Os dados mantêm-se inalterados.");
                    terminado = true;
                }
            }
        }
        while (!terminado);
    }

    private void introduzDados()
    {
        System.out.println("Prima Enter para manter o valor atual.");
        String nome = Utils.readLineFromConsole("Novo nome: ");
        String email = Utils.readLineFromConsole("Novo email: ");
        String password = Utils.readLineFromConsole("Nova palavra-passe: ");
        controller.setDados(nome, email, password);
    }

    private void apresentaDados()
    {
        System.out.println("\nConta:\n" + controller.getUtilizadorFinalAsString());
    }
}