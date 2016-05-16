package domain;

import java.util.Date;

/**
 * Created by asien on 12/05/2016.
 */
public class Operacion {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    /**
     *
     */
    private Date fecha;
    private String Operacion;
    private Divisas Divisa;
    private int Cantidad;
    private Cuenta cuenta;
    private Sucursal sucursal;// CAMBIO

    public Operacion(Date fecha, String operacion, Divisas divisa, int cantidad, Cuenta cuenta, Sucursal sucursal) {
        this.fecha = fecha;
        Operacion = operacion;
        Divisa = divisa;
        Cantidad = cantidad;
        this.cuenta = cuenta;
        this.sucursal = sucursal;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getOperacion() {
        return Operacion;
    }

    public void setOperacion(String operacion) {
        Operacion = operacion;
    }

    public Divisas getDivisa() {
        return Divisa;
    }

    public void setDivisa(Divisas divisa) {
        Divisa = divisa;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int cantidad) {
        Cantidad = cantidad;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }
}
