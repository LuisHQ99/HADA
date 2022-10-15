/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author 50688
 */
public class CompileFile {

    public void compileFile(BufferedReader reader, String fileName) throws IOException {

        enumerateLines(reader, fileName);

    }

    public void enumerateLines(BufferedReader reader, String fileName) throws IOException {

        PrintWriter writer = new PrintWriter(fileName + ".txt", "UTF-8");
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

        System.out.println(lines);


    }

}
