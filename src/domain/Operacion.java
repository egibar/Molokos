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

    public Operacion(Date fecha, String operacion, Divisas divisa, int cantidad) {
        this.fecha = fecha;
        Operacion = operacion;
        Divisa = divisa;
        Cantidad = cantidad;
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

    @Override
    public String toString() {
        return "Operacion{" +
                "fecha=" + fecha +
                ", Operacion='" + Operacion + '\'' +
                ", Divisa=" + Divisa +
                ", Cantidad=" + Cantidad +
                '}';
    }
}
