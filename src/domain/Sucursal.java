package domain;

/**
 * Created by asien on 12/05/2016.
 */

import javax.xml.bind.annotation.XmlAccessorType;
import java.io.Serializable;
import java.util.Vector;


public class Sucursal implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    /**
     *
     */
    private float Comision; //COMPROBAR SI LA COMISION IRIA AQUI
    private String Direccion;
    private Divisas[] d;
    private Cuenta[] c;
    //private Vector<Operacion> operacion;
    //private Vector<Transferencia> transferencias;

    public Sucursal(float comision, String direccion, Divisas[] d, Cuenta[] c) {
        Comision = comision;
        Direccion = direccion;
        this.d = d;
        this.c = c;
    }

    public float getComision() {
        return Comision;
    }

    public void setComision(float comision) {
        Comision = comision;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
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
