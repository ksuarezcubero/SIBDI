/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author kevin
 */
public class Estudiante {
    
    private String nombre;
    private String carnet;

    public Estudiante(String nombre, String carnet) {
        this.nombre = nombre;
        this.carnet = carnet;
    }

    public Estudiante() {
        this.nombre = "";
        this.carnet = "";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    @Override
    public String toString() {
        return "Estudiante{" + "nombre=" + nombre + ", carnet=" + carnet + '}';
    }
    
       
}
