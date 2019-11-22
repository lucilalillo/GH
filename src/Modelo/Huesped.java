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
public class Huesped {
    private int id_Huesped, dni, celular;
    private String nombre, domicilio, correo;

    public Huesped(int id_Huesped, int dni, int celular, String nombre, String domicilio, String correo) {
        this.id_Huesped = id_Huesped;
        this.dni = dni;
        this.celular = celular;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.correo = correo;
    }

    public Huesped(int dni, int celular, String nombre, String domicilio, String correo) {
        this.dni = dni;
        this.celular = celular;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.correo = correo;
    }

    public int getId_Huesped() {
        return id_Huesped;
    }

    public void setId_Huesped(int id_Huesped) {
        this.id_Huesped = id_Huesped;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    
}
