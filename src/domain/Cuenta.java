package domain;

import java.util.Vector;

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
    private int Numero;
    private float Saldo;
	private String Cliente;
    private Vector<Transferencia> Transferencia;
    private Vector<Operacion> Operacion;
    //private Sucursal su;
    //private Cliente cli;


	public Cuenta(int numero, float saldo, String cliente, Vector<domain.Transferencia> transferencia, Vector<domain.Operacion> operacion) {
		Numero = numero;
		Saldo = saldo;
		Cliente = cliente;
		Transferencia = transferencia;
		Operacion = operacion;
	}

	public int getNumero() {
		return Numero;
	}

	public void setNumero(int numero) {
		Numero = numero;
	}

	public float getSaldo() {
		return Saldo;
	}

	public void setSaldo(float saldo) {
		Saldo = saldo;
	}

	public String getCliente() {
		return Cliente;
	}

	public void setCliente(String cliente) {
		Cliente = cliente;
	}

	public Vector<domain.Transferencia> getTransferencia() {
		return Transferencia;
	}

	public void setTransferencia(Vector<domain.Transferencia> transferencia) {
		Transferencia = transferencia;
	}

	public Vector<domain.Operacion> getOperacion() {
		return Operacion;
	}

	public void setOperacion(Vector<domain.Operacion> operacion) {
		Operacion = operacion;
	}
	public void addOperacion(Operacion operacion){
		this.Operacion.addElement(operacion);
	}
	public void addTransferencia(Transferencia transferencia){
		this.Transferencia.addElement(transferencia);
	}
}
