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
    private int id_Huesped;
    private String nombre;
    private String domicilio;
    private int dni;
    private int celular;
    private String correo;

    public Huesped() {
    }

    public Huesped(String nombre, String domicilio, int dni, int celular, String correo) {
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.dni = dni;
        this.celular = celular;
        this.correo = correo;
    }

    public Huesped(int id_Huesped, String nombre, String domicilio, int dni, int celular, String correo) {
        this.id_Huesped = id_Huesped;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.dni = dni;
        this.celular = celular;
        this.correo = correo;
    }

    public int getId_Huesped() {
        return id_Huesped;
    }

    public void setId_Huesped(int id_Huesped) {
        this.id_Huesped = id_Huesped;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

   
    
}
