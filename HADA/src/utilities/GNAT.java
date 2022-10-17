/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.io.IOException;

import java.util.*;
import java.io.*;
/**
 *
 * @author 50688
 */
public class GNAT {

    public void executeGNAT(String fileName) {

        String command = " C:\\REVISION\\gnatmake" + fileName + ".adb";

        try {
            String cmd = "C:\\GNAT\\2021\\bin\\gnatmake Hola_Mundo"; //Comando de apagado en linux
            Runtime.getRuntime().exec(cmd);
            
            

 

       
        StringBuilder sb = new StringBuilder();
        StringBuilder eb = new StringBuilder();
        
        int exitVal = 10000;
        
        try
        {            
            Runtime rt = Runtime.getRuntime();
            Process proc = rt.exec("pwd");
            InputStream stdin = proc.getInputStream();
            InputStreamReader isr = new InputStreamReader(stdin);
            BufferedReader br = new BufferedReader(isr);
            
            InputStream stderr = proc.getErrorStream();
            InputStreamReader esr = new InputStreamReader(stderr);
            BufferedReader errorReader = new BufferedReader(esr);
            
            String line = null;
            while ( (line = br.readLine()) != null) {
                sb.append(line);
            }
            while ( (line = errorReader.readLine()) != null) {
                eb.append(line);
            }
            
            exitVal = proc.waitFor();            
        } catch (Throwable t)
        {
            System.out.println("");
        }


        } catch (IOException ioe) {
            System.out.println(ioe);
        }

    }

}
