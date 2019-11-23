/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.time.LocalDate;

/**
 *
 * @author alumno
 */
public class Reserva {
    private Huesped huesped;
    private int cantPers, habitacion;
    private LocalDate fechaIng, fechaEg;
    private double importe;

    public Reserva(Huesped huesped, int cantPers, int habitacion, LocalDate fechaIng, LocalDate fechaEg, double importe) {
        this.huesped = huesped;
        this.cantPers = cantPers;
        this.habitacion = habitacion;
        this.fechaIng = fechaIng;
        this.fechaEg = fechaEg;
        this.importe = importe;
    }

    public Reserva() {
    }
    

    public Huesped getHuesped() {
        return huesped;
    }

    public void setHuesped(Huesped huesped) {
        this.huesped = huesped;
    }

    public int getCantPers() {
        return cantPers;
    }

    public void setCantPers(int cantPers) {
        this.cantPers = cantPers;
    }

    public int getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(int habitacion) {
        this.habitacion = habitacion;
    }

    public LocalDate getFechaIng() {
        return fechaIng;
    }

    public void setFechaIng(LocalDate fechaIng) {
        this.fechaIng = fechaIng;
    }

    public LocalDate getFechaEg() {
        return fechaEg;
    }

    public void setFechaEg(LocalDate fechaEg) {
        this.fechaEg = fechaEg;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }
    
    
}
