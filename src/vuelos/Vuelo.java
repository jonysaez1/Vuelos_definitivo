
package vuelos;

import java.time.LocalDate;

public class Vuelo {
    private int id=-1;
    private String aerolinea;
    private String aeronave;
    private LocalDate fecha_llegada;
    private LocalDate fecha_partida;
    private Ciudad id_ciudad;
    private Ciudad id_ciudad_origen;

    public Vuelo(int id, String aerolinea, String aeronave, LocalDate fecha_llegada, LocalDate fecha_partida, Ciudad id_ciudad, Ciudad id_ciudad_origen) {
        this.id = id;
        this.aerolinea = aerolinea;
        this.aeronave = aeronave;
        this.fecha_llegada = fecha_llegada;
        this.fecha_partida = fecha_partida;
        this.id_ciudad = id_ciudad;
        this.id_ciudad_origen = id_ciudad_origen;
    }

    public Vuelo(String aerolinea, String aeronave, LocalDate fecha_llegada, LocalDate fecha_partida, Ciudad id_ciudad, Ciudad id_ciudad_origen) {
        this.aerolinea = aerolinea;
        this.aeronave = aeronave;
        this.fecha_llegada = fecha_llegada;
        this.fecha_partida = fecha_partida;
        this.id_ciudad = id_ciudad;
        this.id_ciudad_origen = id_ciudad_origen;
    }

    public Vuelo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAerolinea() {
        return aerolinea;
    }

    public void setAerolinea(String aerolinea) {
        this.aerolinea = aerolinea;
    }

    public String getAeronave() {
        return aeronave;
    }

    public void setAeronave(String aeronave) {
        this.aeronave = aeronave;
    }

    public LocalDate getFecha_llegada() {
        return fecha_llegada;
    }

    public void setFecha_llegada(LocalDate fecha_llegada) {
        this.fecha_llegada = fecha_llegada;
    }

    public LocalDate getFecha_partida() {
        return fecha_partida;
    }

    public void setFecha_partida(LocalDate fecha_partida) {
        this.fecha_partida = fecha_partida;
    }

    public Ciudad getId_ciudad() {
        return id_ciudad;
    }

    public void setId_ciudad(Ciudad id_ciudad) {
        this.id_ciudad = id_ciudad;
    }

    public Ciudad getId_ciudad_origen() {
        return id_ciudad_origen;
    }

    public void setId_ciudad_origen(Ciudad id_ciudad_origen) {
        this.id_ciudad_origen = id_ciudad_origen;
    }
    
    
    
    
    
    

    
    
}
