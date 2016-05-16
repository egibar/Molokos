package domain;

/**
 * Created by asien on 12/05/2016.
 */

import javax.xml.bind.annotation.XmlAccessorType;
import java.io.Serializable;


public class Sucursal implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    /**
     *
     */
    private double Comision; //COMPROBAR SI LA COMISION IRIA AQUI
    private String Direccion;
    private String Nombre;
    private Divisas[] d;
    private Cuenta[] c;

    public Sucursal(double comision, String direccion, String nombre, Divisas[] d, Cuenta[] c) {
        Comision = comision;
        Direccion = direccion;
        Nombre = nombre;
        this.d = d;
        this.c = c;
    }

    public double getComision() {
        return Comision;
    }

    public void setComision(double comision) {
        Comision = comision;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public Divisas[] getD() {
        return d;
    }

    public void setD(Divisas[] d) {
        this.d = d;
    }

    public Cuenta[] getC() {
        return c;
    }

    public void setC(Cuenta[] c) {
        this.c = c;
    }
}
