/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vuelos;

import java.time.LocalDate;

/**
 *
 * @author Jonathan Saez
 */
public class Compra {
    private int id_compra=-1;
    private Cliente id_cliente;
    private Asiento id_asiento;
    private LocalDate fecha;
    double precio;

    public Compra(int id_compra, Cliente id_cliente, Asiento id_asiento, LocalDate fecha, double precio) {
        this.id_compra = id_compra;
        this.id_cliente = id_cliente;
        this.id_asiento = id_asiento;
        this.fecha = fecha;
        this.precio = precio;
    }

    public Compra() {
    }

    public int getId_compra() {
        return id_compra;
    }

    public void setId_compra(int id_compra) {
        this.id_compra = id_compra;
    }

    public Cliente getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Cliente id_cliente) {
        this.id_cliente = id_cliente;
    }

    public Asiento getId_asiento() {
        return id_asiento;
    }

    public void setId_asiento(Asiento id_asiento) {
        this.id_asiento = id_asiento;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    
    
    
}
