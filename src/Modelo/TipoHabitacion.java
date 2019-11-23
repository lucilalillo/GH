/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author alumno
 */
public class TipoHabitacion {
    private int idTipoHabitacion;
    private String descripcion;
    private double precio;
    private Habitacion numero; 

    public TipoHabitacion() {
    }

    public TipoHabitacion(String descripcion, double precio, Habitacion numero) {
        this.descripcion = descripcion;
        this.precio = precio;
        this.numero = numero;
    }

    public TipoHabitacion(int idTipoHabitacion, String descripcion, double precio, Habitacion numero) {
        this.idTipoHabitacion = idTipoHabitacion;
        this.descripcion = descripcion;
        this.precio = precio;
        this.numero = numero;
    }

    public int getIdTipoHabitacion() {
        return idTipoHabitacion;
    }

    public void setIdTipoHabitacion(int idTipoHabitacion) {
        this.idTipoHabitacion = idTipoHabitacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Habitacion getNumero() {
        return numero;
    }

    public void setNumero(Habitacion numero) {
        this.numero = numero;
    }

    
}
