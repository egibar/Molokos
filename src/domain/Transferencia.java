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
    private Date fecha;
    private int CuentaOrigen;
    private int CuentaDestino;
    private float Importe;
  //  private Sucursal sucursal;// CAMBIO

    public Transferencia(Date fecha, int cuentaOrigen, int cuentaDestino, float importe/*, Sucursal sucursal*/) {
        this.fecha = fecha;
        CuentaOrigen = cuentaOrigen;
        CuentaDestino = cuentaDestino;
        Importe = importe;
        //this.sucursal = sucursal;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getCuentaOrigen() {
        return CuentaOrigen;
    }

    public void setCuentaOrigen(int cuentaOrigen) {
        CuentaOrigen = cuentaOrigen;
    }

    public int getCuentaDestino() {
        return CuentaDestino;
    }

    public void setCuentaDestino(int cuentaDestino) {
        CuentaDestino = cuentaDestino;
    }

    public float getImporte() {
        return Importe;
    }

    public void setImporte(float importe) {
        Importe = importe;
    }

    @Override
    public String toString() {
        return "Transferencia{" +
                "fecha=" + fecha +
                ", CuentaOrigen=" + CuentaOrigen +
                ", CuentaDestino=" + CuentaDestino +
                ", Importe=" + Importe +
                '}';
    }
    /*
   public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }
    */
}