/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

/**
 *
 * @author 50688
 */
public class CompileFile {

    public void compileFile(BufferedReader reader, String fileName) throws IOException {       
        
        createAdbFile(reader,fileName);
        enumerateLines(reader, fileName);
        reader.close();
        //Add posible errors
        if(addErrors()){
            //If there's no errors, call GNAT
            //compileGnat(in, copied);
        }
    }
    
    public void createAdbFile(BufferedReader reader, String fileName)throws IOException{
        PrintWriter writer = new PrintWriter(fileName + ".adb", "UTF-8");
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
        
        writer.close();
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
        
    }
    
    public boolean addErrors(){
        
        return true;
    }
    
    public void compileGnat(InputStream reader, File copied){
        /*try {
            //C:\GNAT\2021\bin
            
        } catch (IOException ioe) {
            System.out.println (ioe);
        }*/
    }
}
