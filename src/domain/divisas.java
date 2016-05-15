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
    private int Cantidad; //COMPROBAR SI LA COMISION IRIA AQUI
    private float Valor;
    private String Nombre;

    public Divisas(int cantidad, float valor, String nombre) {
        Cantidad = cantidad;
        Valor = valor;
        Nombre = nombre;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int cantidad) {
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

    @Override
    public String toString() {
        return "Divisas{" +
                "Cantidad=" + Cantidad +
                ", Valor=" + Valor +
                ", Nombre='" + Nombre + '\'' +
                '}';
    }
}
