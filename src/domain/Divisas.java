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
    private String Nombre;
    private Sucursal sucursal;

    public Divisas(float cantidad, float valor, String nombre, Sucursal sucursal) {
        Cantidad = cantidad;
        Valor = valor;
        Nombre = nombre;
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

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }
}
