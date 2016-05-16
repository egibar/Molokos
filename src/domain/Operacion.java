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
    private String Divisa;
    private float Cantidad;
    private Cuenta cuenta;
    private Sucursal sucursal;// CAMBIO

    public Operacion(Date fecha, String operacion, String divisa, float cantidad, Cuenta cuenta, Sucursal sucursal) {
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

    public String getDivisa() {
        return Divisa;
    }

    public void setDivisa(String divisa) {
        Divisa = divisa;
    }

    public float getCantidad() {
        return Cantidad;
    }

    public void setCantidad(float cantidad) {
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
