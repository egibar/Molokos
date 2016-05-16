package domain;

import java.util.Date;

/**
 * Created by asien on 12/05/2016.
 */
public class Transferencia {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    /**
     *
     */
    private Cuenta CuentaDestino;
    private Cuenta CuentaOrigen;
    private Date fecha;
    private float Importe;
    private Sucursal sucursal;// CAMBIO

    public Transferencia(Cuenta cuentaDestino, Cuenta cuentaOrigen, Date fecha, float importe, Sucursal sucursal) {
        CuentaDestino = cuentaDestino;
        CuentaOrigen = cuentaOrigen;
        this.fecha = fecha;
        Importe = importe;
        this.sucursal = sucursal;
    }

    public Cuenta getCuentaDestino() {
        return CuentaDestino;
    }

    public void setCuentaDestino(Cuenta cuentaDestino) {
        CuentaDestino = cuentaDestino;
    }

    public Cuenta getCuentaOrigen() {
        return CuentaOrigen;
    }

    public void setCuentaOrigen(Cuenta cuentaOrigen) {
        CuentaOrigen = cuentaOrigen;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public float getImporte() {
        return Importe;
    }

    public void setImporte(float importe) {
        Importe = importe;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }
}
