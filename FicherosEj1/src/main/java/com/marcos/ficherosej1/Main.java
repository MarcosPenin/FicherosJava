package com.marcos.ficherosej1;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author a20marcosgp
 */
public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        final String nomFichero = "prueba.txt";
        String mensaje = "";
        File fich = new File("prueba.txt");

        if (fich.exists()) {
            try {
                FileReader fr = new FileReader(nomFichero);
                int valor = fr.read();

                while (valor != -1) {
                    if (valor != 32) {

                        mensaje += ((char) valor);
                        System.out.print((char) valor);
                    }
                    valor = fr.read();
                }
                JOptionPane.showMessageDialog(null, mensaje);
            } catch (IOException e) {

            }
        } else {

        }

    }
}
