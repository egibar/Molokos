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
    private int Comision; //COMPROBAR SI LA COMISION IRIA AQUI
    private String Direccion;
    private String Nombre;

    public Sucursal(int Comision, String Direccion, String Nombre) {
        this.Comision=Comision;
        this.Direccion=Direccion;
        this.Nombre=Nombre;

    }

    public void setComision(int comision) {
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

    public int getComision() {
        return Comision;
    }


    public String toString() {
        return this.Nombre + ": " + this.Direccion;
    }


}
