/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apliciclistav2;

import modelo.ServiciosCiclista;
import vista.GUIPrincipal;

/**
 *
 * @author William Duarte
 */
public class ApliCiclistaV2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ServiciosCiclista ser = new ServiciosCiclista();
        GUIPrincipal pr = new GUIPrincipal(ser);
        pr.setVisible(true);
    }
    
}
