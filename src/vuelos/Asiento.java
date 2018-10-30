/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vuelos;

/**
 *
 * @author Grupo 28
 */
public class Asiento {
    private int id_asiento = -1;
    private Vuelo id_vuelo;
    private double precio;
    private String ubicacion;
    private int disponibilidad;

    public Asiento(int id_asiento, Vuelo id_vuelo, double precio, String ubicacion, int disponibilidad) {
        this.id_asiento = id_asiento;
        this.id_vuelo = id_vuelo;
        this.precio = precio;
        this.ubicacion = ubicacion;
        this.disponibilidad = disponibilidad;
    }

    public Asiento(Vuelo id_vuelo, double precio, String ubicacion, int disponibilidad) {
        this.id_vuelo = id_vuelo;
        this.precio = precio;
        this.ubicacion = ubicacion;
        this.disponibilidad = disponibilidad;
    }

    public Asiento() {
    }

    public int getId_asiento() {
        return id_asiento;
    }

    public void setId_asiento(int id_asiento) {
        this.id_asiento = id_asiento;
    }

    public Vuelo getId_vuelo() {
        return id_vuelo;
    }

    public void setId_vuelo(Vuelo id_vuelo) {
        this.id_vuelo = id_vuelo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(int disponibilidad) {
        this.disponibilidad = disponibilidad;
    }
    
    
    
}
