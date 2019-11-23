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
public class CantidadCamas {
    private TipoHabitacion tipoHabitacion;
    private TipoCama tipoCama;
    private int cant;

    public CantidadCamas() {
    }
    

    public CantidadCamas(TipoHabitacion tipoHabitacion, TipoCama tipoCama, int cant) {
        this.tipoHabitacion = tipoHabitacion;
        this.tipoCama = tipoCama;
        this.cant = cant;
    }

    public TipoHabitacion getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(TipoHabitacion tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    public TipoCama getTipoCama() {
        return tipoCama;
    }

    public void setTipoCama(TipoCama tipoCama) {
        this.tipoCama = tipoCama;
    }

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }
    
    
}
