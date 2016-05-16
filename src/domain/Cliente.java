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
    private String DNI;
    private Cuenta[] cu;

    public Cliente(String nombre, String apellido, String DNI, Cuenta[] cu) {
        Nombre = nombre;
        Apellido = apellido;
        this.DNI = DNI;
        this.cu = cu;
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

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public Cuenta[] getCu() {
        return cu;
    }

    public void setCu(Cuenta[] cu) {
        this.cu = cu;
    }
}
