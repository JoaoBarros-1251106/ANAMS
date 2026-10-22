/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.UI;

import org.Model.AssistenteDigital;

/**
 *
 * @author Dulce Mota <mdm@isep.ipp.pt>
 * Classe de arranque da aplicação
 */
public class Main
{
    public static void main(String[] args)
    {
        try
        {   // Classe Principal -> Engloba todo o domínio
            AssistenteDigital assistenteDigital = new AssistenteDigital();

            MenuInicial_UI uiMenu = new MenuInicial_UI(assistenteDigital);

            uiMenu.run();
        }
        catch(Exception e )
        {
            e.printStackTrace();
        }
    }
}

