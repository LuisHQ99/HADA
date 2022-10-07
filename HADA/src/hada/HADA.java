/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hada;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilities.FileHada;

/**
 *
 * @author 50688
 */
public class HADA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
            
            FileHada fileHada = new FileHada();
            fileHada.readFile(args[0]);
            //fileHada.readFile("Calcular_Inflacion1.HADA");

        } catch (FileNotFoundException ex) {
            Logger.getLogger(HADA.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(HADA.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
