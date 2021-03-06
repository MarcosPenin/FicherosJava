
package com.mycompany.ficherosej5;

import java.io.Serializable;

public class Vehiculo implements Serializable {
    
    private String matricula;
    private String marca;
    private transient Double deposito;
    private String modelo;

    public Vehiculo(String matricula, String marca, Double deposito, String modelo){
        this.matricula=matricula;
        this.marca=marca;
        this.deposito=deposito;
        this.modelo=modelo;
    }
    
    
    
    /**
     * @return the matricula
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * @param matricula the matricula to set
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    /**
     * @return the marca
     */
    public String getMarca() {
        return marca;
    }

    /**
     * @param marca the marca to set
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * @return the deposito
     */
    public Double getDeposito() {
        return deposito;
    }

    /**
     * @param deposito the deposito to set
     */
    public void setDeposito(Double deposito) {
        this.deposito = deposito;
    }

    /**
     * @return the modelo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    
}
