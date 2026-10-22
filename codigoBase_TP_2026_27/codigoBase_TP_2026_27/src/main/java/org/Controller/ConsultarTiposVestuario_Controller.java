package org.Controller;

import org.Model.AssistenteDigital;
/**
 *
 * @author Dulce Mota <mdm@isep.ipp.pt>
 */
public class ConsultarTiposVestuario_Controller
{
    private final AssistenteDigital assistente;

    public ConsultarTiposVestuario_Controller(AssistenteDigital assistenteDigital)
    {
        this.assistente = assistenteDigital;
    }
    public String obterTiposVestuarioAsString()
    {
        String ltv = assistente.obterTiposVestuarioAsString();
        return ltv;
    }
}