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
public class TipoCama {
    private int idTipoCama;
    private String tipo;

    public TipoCama() {
    }
    
    
    public TipoCama(int idTipoCama, String tipo) {
        this.idTipoCama = idTipoCama;
        this.tipo = tipo;
    }

    public int getIdTipoCama() {
        return idTipoCama;
    }

    public void setIdTipoCama(int idTipoCama) {
        this.idTipoCama = idTipoCama;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
}
