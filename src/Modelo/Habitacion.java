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
public class Habitacion {
    private int numero, piso, id_tipoHabitacion;
    private String estado, tipoHabitacion;

    public Habitacion(int numero, int piso, int id_tipoHabitacion, String estado, String tipoHabitacion) {
        this.numero = numero;
        this.piso = piso;
        this.id_tipoHabitacion = id_tipoHabitacion;
        this.estado = estado;
        this.tipoHabitacion = tipoHabitacion;
    }

    public Habitacion(int piso, int id_tipoHabitacion, String estado, String tipoHabitacion) {
        this.piso = piso;
        this.id_tipoHabitacion = id_tipoHabitacion;
        this.estado = estado;
        this.tipoHabitacion = tipoHabitacion;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public int getId_tipoHabitacion() {
        return id_tipoHabitacion;
    }

    public void setId_tipoHabitacion(int id_tipoHabitacion) {
        this.id_tipoHabitacion = id_tipoHabitacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(String tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }
    
    
}
