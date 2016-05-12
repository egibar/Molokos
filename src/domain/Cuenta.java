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
    private int Numero; //COMPROBAR SI LA COMISION IRIA AQUI
    private int Saldo;

    public Cuenta(int numero, int saldo) {

        Numero = numero;
        Saldo = saldo;
    }

    public int getNumero() {
        return Numero;
    }

    public void setNumero(int numero) {
        Numero = numero;
    }

    public int getSaldo() {
        return Saldo;
    }

    public void setSaldo(int saldo) {
        Saldo = saldo;
    }

    @Override
    public String toString() {
        return "Cuenta{" +
                "Numero=" + Numero +
                ", Saldo=" + Saldo +
                '}';
    }



}
