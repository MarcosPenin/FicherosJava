/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ficherosej5;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class NewMain {
    
    public static void main(String[] args) {
        
        String matricula = JOptionPane.showInputDialog("Introduce la matrícula");
        String marca = JOptionPane.showInputDialog("Introduce la marca");
        String deposito = JOptionPane.showInputDialog("Introduce el tamaño del deposito");
        double depositoDouble = Double.parseDouble(deposito);
        String modelo = JOptionPane.showInputDialog("Introduce el modelo");
        
        Vehiculo miVehiculo = new Vehiculo(matricula, marca, depositoDouble, modelo);
        
        File f = new File("Personas.txt");
        
        try {            
            guardarDatos(f, miVehiculo);
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(NewMain.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        
        try {
            FileInputStream fis = new FileInputStream("Personas.txt");
            
            ObjectInputStream ois = new ObjectInputStream(fis);
            
            leerDatos(fis, ois);
            
        } catch (IOException e) {
            e.getMessage();
        } catch (ClassNotFoundException e) {
            e.getMessage();
        }
    }
    
    public static void guardarDatos(File f, Vehiculo miVehiculo) throws IOException {
        if (!f.exists()) {
            f.createNewFile();
            ObjectOutputStream mos = new ObjectOutputStream(new FileOutputStream("Personas.txt", true));
            mos.writeObject(miVehiculo);
        } else {
            MiObjectOutputStream mios = new MiObjectOutputStream(new FileOutputStream("Personas.txt", true));
            mios.writeObject(miVehiculo);
        }
    }
    
    public static void leerDatos(FileInputStream fis, ObjectInputStream ois) throws IOException, ClassNotFoundException {
        
        while (fis.available() > 0) {
            Vehiculo vehiculoLeido = (Vehiculo) ois.readObject();
            JOptionPane.showMessageDialog(null, "La marca es " + vehiculoLeido.getMarca() + ", la matrícula " + vehiculoLeido.getMatricula()
                    + " y el modelo un " + vehiculoLeido.getModelo());
            
        }
        
    }
}
