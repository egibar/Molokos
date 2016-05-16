package domain;

/**
 * Created by asien on 12/05/2016.
 */
public class Divisas {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    /**
     *
     */
    private float Cantidad; //COMPROBAR SI LA COMISION IRIA AQUI
    private float Valor;
    private String Moneda;
    private String sucursal;

    public Divisas(float cantidad, float valor, String moneda, String sucursal) {
        Cantidad = cantidad;
        Valor = valor;
        Moneda = moneda;
        this.sucursal = sucursal;
    }

    public float getCantidad() {
        return Cantidad;
    }

    public void setCantidad(float cantidad) {
        Cantidad = cantidad;
    }

    public float getValor() {
        return Valor;
    }

    public void setValor(float valor) {
        Valor = valor;
    }

    public String getMoneda() {
        return Moneda;
    }

    public void setMoneda(String moneda) {
        Moneda = moneda;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }
}
