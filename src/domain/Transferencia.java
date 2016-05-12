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
    private int Importe;

    public Transferencia(Cuenta cuentaDestino, Cuenta cuentaOrigen, Date fecha, int importe) {
        CuentaDestino = cuentaDestino;
        CuentaOrigen = cuentaOrigen;
        this.fecha = fecha;
        Importe = importe;
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

    public int getImporte() {
        return Importe;
    }

    public void setImporte(int importe) {
        Importe = importe;
    }

    @Override
    public String toString() {
        return "Transferencia{" +
                "CuentaDestino=" + CuentaDestino +
                ", CuentaOrigen=" + CuentaOrigen +
                ", fecha=" + fecha +
                ", Importe=" + Importe +
                '}';
    }
}
