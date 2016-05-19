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
    private int cuenta;
    private String sucursal;// CAMBIO

    public Operacion(Date fecha, String operacion, String divisa, float cantidad, int cuenta, String sucursal) {
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

    public int getCuenta() {
        return cuenta;
    }

    public void setCuenta(int cuenta) {
        this.cuenta = cuenta;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    @Override
    public String toString() {
        String nl = System.getProperty("line.separator");
        return
                "fecha=" + fecha +nl+
                ", Operacion='" + Operacion +nl+ '\'' +
                ", Divisa='" + Divisa +nl+ '\'' +
                ", Cantidad=" + Cantidad +nl+
                ", cuenta=" + cuenta +nl+
                ", sucursal=" + sucursal + nl
                ;
    }
}
