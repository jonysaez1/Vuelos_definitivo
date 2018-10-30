/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vuelos;

/**
 *
 * @author grupo 28
 */
public class Cliente {

    
    private int id;
    private String nombre;
    private String n_pasaporte;
    private String n_tarjeta;
    
    
    public Cliente(int id) {
        this.id = id;
    }
    
    public Cliente(int id, String nombre, String n_pasaporte, String n_tarjeta) {
        this.id = id;
        this.nombre = nombre;
        this.n_pasaporte = n_pasaporte;
        this.n_tarjeta = n_tarjeta;
    }
    
    
    public Cliente(String nombre) {
        this.nombre = nombre;
    }


    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getN_pasaporte() {
        return n_pasaporte;
    }

    public String getN_tarjeta() {
        return n_tarjeta;
    }
    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setN_pasaporte(String n_pasaporte) {
        this.n_pasaporte = n_pasaporte;
    }

    public void setN_tarjeta(String n_tarjeta) {
        this.n_tarjeta = n_tarjeta;
    }

    
}
