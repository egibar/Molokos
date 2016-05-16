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
    private Cuenta CuentaOrigen;
    private Cuenta CuentaDestino;
    private float Importe;
  //  private Sucursal sucursal;// CAMBIO

    public Transferencia(Date fecha, Cuenta cuentaOrigen, Cuenta cuentaDestino, float importe/*, Sucursal sucursal*/) {
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

    public Cuenta getCuentaOrigen() {
        return CuentaOrigen;
    }

    public void setCuentaOrigen(Cuenta cuentaOrigen) {
        CuentaOrigen = cuentaOrigen;
    }

    public Cuenta getCuentaDestino() {
        return CuentaDestino;
    }

    public void setCuentaDestino(Cuenta cuentaDestino) {
        CuentaDestino = cuentaDestino;
    }

    public float getImporte() {
        return Importe;
    }

    public void setImporte(float importe) {
        Importe = importe;
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