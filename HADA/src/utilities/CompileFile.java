/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 *
 * @author 50688
 */
public class CompileFile {

    public void compileFile(BufferedReader reader, String fileName) throws IOException {       
        
        enumerateLines(reader, fileName);
        //Add posible errors
        if(addErrors()){
            //If there's no errors, call GNAT
            //compileGnat(in, copied);
        }else{
            createAdbFile(fileName);
        }
                
    }
    
    public void createAdbFile(String fileName)throws IOException{
        PrintWriter writer = new PrintWriter(fileName + ".adb", "UTF-8");
        
        String path = "./" + fileName + ".HADA";
        FileInputStream fis = new FileInputStream(path);
        BufferedReader in = new BufferedReader(new InputStreamReader(fis));
        
        int lines = 1;
        while (lines < 100000) {
            String line = in.readLine(); 
            if (line != null) {
                writer.println(line);
                lines++;
            }else{
                break;
            }
        }
        
        in.close();
        writer.close();
    
        compileGnat();
    }

    public void enumerateLines(BufferedReader reader, String fileName) throws IOException {

        PrintWriter writer = new PrintWriter(fileName + "-errores" + ".txt", "UTF-8");
        int lines = 1;
        while (lines < 100000) {
            String line = reader.readLine(); 
            if (line != null) {
                writer.println(String.format("%05d", lines) + "  " + line);
                lines++;
            }else{
                break;
            }

        }
        
        reader.close();
        writer.close();
        
    }
    
    public boolean addErrors(){
        
        return false;
    }
    
    public void compileGnat(){
        try {
            String cmd = "gnatmake" + " ci.adb"; 
            Runtime.getRuntime().exec(cmd);
            
        } catch (IOException ioe) {
            System.out.println (ioe);
        }
    }
}
