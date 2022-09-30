/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author 50688
 */
public class FileHada {

    private String fileName;

    public void readFile(String _fileName) throws FileNotFoundException, IOException {

        this.fileName = _fileName;
        if (validateNameFile(this.fileName)) {

            String path = "./" + this.fileName + ".HADA";
            FileInputStream fis = new FileInputStream(path);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));

            System.out.println("path: " + path);
            System.out.println("Primera linea: " + in.readLine());
        }

    }

    public boolean validateNameFile(String fileName) {

        if (fileName != null) {
            if (fileName.contains(".HADA")) {
                this.fileName = fileName.replaceAll(".HADA", "");
            }
            if (fileName.contains(".txt")) {
                System.out.println("[ERROR]. No se aceptan archivos de texto");
                return false;
            }
            if (fileName.contains(" ")) {
                System.out.println("[ERROR]. El nombre del archivo no puede contener espacios en blanco");
                return false;
            }
            if (this.fileName.length() > 20) {
                System.out.println("[ERROR]. El nombre del archivo no puede ser mayor a 20 caracteres");
                return false;
            }
            if (this.fileName.charAt(0) == '_') {
                System.out.println("[ERROR]. El nombre del archivo no puede empezar con guion bajo");
                return false;
            }
            if (!Pattern.compile("^[A-Za-z]").matcher(this.fileName).find()) {
                System.out.println("[ERROR]. El nombre del archivo debe empezar con una letra");
                return false;
            }
            if (this.fileName.charAt(this.fileName.length() - 1) == '_') {
                System.out.println("[ERROR]. El nombre del archivo no puede terminar con guion bajo");
                return false;
            }

            Pattern special = Pattern.compile("[`!@#$%&*()+=|<>?{}\\[\\]~-]");
            Matcher hasSpecial = special.matcher(this.fileName);
            if (hasSpecial.find()) {
                System.out.println("[ERROR]. El nombre del archivo no puede tener caracteres especiales");
                return false;
            }

        } else {
            System.out.println("[ERROR]. Debe ingresar un archivo");
            return false;
        }

        return true;
    }
}
