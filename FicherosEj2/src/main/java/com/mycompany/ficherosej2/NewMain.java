package com.mycompany.ficherosej2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author a20marcosgp
 */
public class NewMain {

    static Scanner sc = new Scanner(System.in);

    /*
  2)  Crea una aplicación que pida la ruta de dos ficheros de texto y de una ruta de destino (solo la ruta, sin fichero al final). Debes copiar el contenido de los dos ficheros en uno, este tendrá el nombre de los dos ficheros separados por un guion bajo, este se guardara en la ruta donde le hayamos indicado por teclado.

    Para unir los ficheros en uno, crea un método donde le pases como parámetro todas las rutas. En este método, aparte de copiar debe comprobar que si existe el fichero de destino, nos muestre un mensaje informándonos de si queremos sobrescribir el fichero. Te recomiendo usar la clase File y JOptionPane.

    Por ejemplo, si tengo un fichero A.txt con “ABC” como contenido, un fichero B.txt con “DEF” y una ruta de destino D:\, el resultado sera un fichero llamado A_B.txt en la ruta D:\ o la actual con el contenido “ABCDEF”.
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {

        System.out.println("Introduce la ruta del primer fichero con su nombre para crearlo");
        String ruta1 = ControlData.lerString(sc) + ".txt";

        System.out.println("Introduce la ruta del segundo fichero con su nombre para crearlo");
        String ruta2 = ControlData.lerString(sc) + ".txt";

        File fichero1 = new File(ruta1);
        File fichero2 = new File(ruta2);
        String nombreFichero1 = fichero1.getName().substring(0, fichero1.getName().length() - 4);
        String nombreFichero2 = fichero2.getName().substring(0, fichero2.getName().length() - 4);
        String nombreFichero3 = nombreFichero1 + "_" + nombreFichero2;

        System.out.println("Introduce la ruta de destino");
        String ruta3 = ControlData.lerString(sc) + nombreFichero3 + ".txt";

        File fichero3 = new File(ruta3);

        BufferedWriter bw1 = new BufferedWriter(new FileWriter(ruta1));
        BufferedWriter bw2 = new BufferedWriter(new FileWriter(ruta2));

        bw1.append("abc");
        bw1.flush();
        bw2.append("def");
        bw2.flush();

        BufferedReader br = new BufferedReader(new FileReader(ruta1));
        BufferedReader br2 = new BufferedReader(new FileReader(ruta2));
        BufferedWriter bw3 = new BufferedWriter(new FileWriter(ruta3));

        int caracter;

        while ((caracter = br.read()) != -1) {
            bw3.append((char) caracter);
        }
        while ((caracter = br2.read()) != -1) {
            bw3.append((char) caracter);
        }
        bw3.flush();
    }
}
