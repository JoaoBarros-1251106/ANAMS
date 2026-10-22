/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.Controller;

import org.Model.AssistenteDigital;
import org.Model.Vestuario;

/**
 *
 * @author Dulce Mota <mdm@isep.ipp.pt>
 */
public class EspecificarTipoVestuario_Controller
{
    private final AssistenteDigital assistente;
    private Vestuario vestuario;
    
    public EspecificarTipoVestuario_Controller(AssistenteDigital assistenteDigital)
    {
        this.assistente = assistenteDigital;
    }
    public void novoTipoVestuario()
    {
        this.vestuario = assistente.novoTipoVestuario();
    }
    public void setDados(String sigla, String descricao){
        this.vestuario.setSigla(sigla);
        this.vestuario.setDescricao(descricao);
    }
    
    public String getSigla()
    {
        return this.vestuario.getSigla();
    }
    
    public boolean especificarTipoVesturaio()
    {
        return this.assistente.especificarTipoVesturaio(this.vestuario);
    }

    public String getTipoVesturaioAsString()
    {
        return this.vestuario.toString();
    }
}
