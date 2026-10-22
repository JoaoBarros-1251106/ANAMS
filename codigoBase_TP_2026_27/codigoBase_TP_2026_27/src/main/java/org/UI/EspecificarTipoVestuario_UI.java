/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.UI;

import org.Utils.*;
import org.Model.AssistenteDigital;
import org.Controller.EspecificarTipoVestuario_Controller;

/**
 *
 * @author Dulce Mota <mdm@isep.ipp.pt>
 */
public class EspecificarTipoVestuario_UI
{
    private AssistenteDigital assistente;
    private EspecificarTipoVestuario_Controller controller;

    public EspecificarTipoVestuario_UI(AssistenteDigital assistenteDigital)
    {
        this.assistente = assistenteDigital;
        controller = new EspecificarTipoVestuario_Controller(assistenteDigital);
    }

    public void run()
    {
        System.out.println("\nNovo Tipo de Vestuário:");
        controller.novoTipoVestuario();

        introduzDados();

        apresentaDados();

        if (Utils.confirma("Confirma os dados? (S/N)")) 
        {
            if (controller.especificarTipoVesturaio()) {
                System.out.println("Dados do tipo de vestuário guardados com sucesso.");
            } else {
                System.out.println("Não foi possível guardar os dados do tipo de vestuário.");
            }
        }
    }
    
    private void introduzDados() {
        String sigla = Utils.readLineFromConsole("Introduza a sigla: ");
        String descricao = Utils.readLineFromConsole("Introduza uma descrição: ");
        controller.setDados(sigla, descricao);
    }
 
    private void apresentaDados() 
    {
        System.out.println("\nTipo de vestuário:\n" + controller.getTipoVesturaioAsString());
    }
}
