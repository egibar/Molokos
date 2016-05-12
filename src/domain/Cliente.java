package domain;

/**
 * Created by asien on 12/05/2016.
 */
public class Cliente {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    /**
     *
     */
    private String Nombre;
    private String Apellido;
    private int DNI;

    public Cliente(String nombre, String apellido, int DNI) {
        Nombre = nombre;
        Apellido = apellido;
        this.DNI = DNI;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public int getDNI() {
        return DNI;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }
}
