package domain;

/**
 * Created by asien on 12/05/2016.
 */
public class Cuenta {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    /**
     *
     */
    private String DNI;
    private int Numero; //COMPROBAR SI LA COMISION IRIA AQUI
    private double Saldo;

    public Cuenta(String DNI, int numero, double saldo) {
        this.DNI = DNI;
        Numero = numero;
        Saldo = saldo;
    }

    public Cuenta() {
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public int getNumero() {
        return Numero;
    }

    public void setNumero(int numero) {
        Numero = numero;
    }

    public double getSaldo() {
        return Saldo;
    }

    public void setSaldo(double saldo) {
        Saldo = saldo;
    }

    @Override
    public String toString() {
        return "Cuenta{" +
                "DNI='" + DNI + '\'' +
                ", Numero=" + Numero +
                ", Saldo=" + Saldo +
                '}';
    }

}
