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
    private double Saldo;
    private Transferencia[] t;
    private Operacion[] op;
    //private Sucursal su;
    private Cliente cli;
    
	public Cuenta(int numero, double saldo, Transferencia[] t, Operacion[] op, Cliente cli) {
		super();
		Numero = numero;
		Saldo = saldo;
		this.t = t;
		this.op = op;
		this.cli = cli;
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

	public Transferencia[] getT() {
		return t;
	}

	public void setT(Transferencia[] t) {
		this.t = t;
	}

	public Operacion[] getOp() {
		return op;
	}

	public void setOp(Operacion[] op) {
		this.op = op;
	}

	public Cliente getCli() {
		return cli;
	}

	public void setCli(Cliente cli) {
		this.cli = cli;
	}
	
    
}
