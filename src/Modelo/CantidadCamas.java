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
    private TipoHabitacion idTipoHab;
    private TipoCama idTipoCama;
    private int cant;

    public CantidadCamas(TipoHabitacion idTipoHab, TipoCama idTipoCama, int cant) {
        this.idTipoHab = idTipoHab;
        this.idTipoCama = idTipoCama;
        this.cant = cant;
    }

    public TipoHabitacion getIdTipoHab() {
        return idTipoHab;
    }

    public void setIdTipoHab(TipoHabitacion idTipoHab) {
        this.idTipoHab = idTipoHab;
    }

    public TipoCama getIdTipoCama() {
        return idTipoCama;
    }

    public void setIdTipoCama(TipoCama idTipoCama) {
        this.idTipoCama = idTipoCama;
    }

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }
    
    
}
