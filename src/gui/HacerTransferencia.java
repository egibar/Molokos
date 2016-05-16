package gui;

import businessLogic.FacadeImplementationWS;
import domain.Cuenta;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.geom.Arc2D;
import java.util.Collection;
import java.util.Date;

public class HacerTransferencia extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldDni;
	private JTextField textFieldDestino;
	private JTextField textFieldCantidad;
	private JComboBox cuentas = null;
	private String DNI;
	private Cuenta cuentaorigen;
	private int cuentadestino;
	private float cantidad;
	protected Component frame;
	private DefaultComboBoxModel c = new DefaultComboBoxModel();
	private Collection coleccion;
		FacadeImplementationWS facade = new FacadeImplementationWS();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HacerTransferencia frame = new HacerTransferencia();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	private void setFields(){
		textFieldDni = new JTextField();
		textFieldDni.setBounds(269, 135, 114, 19);
		contentPane.add(textFieldDni);
		textFieldDni.setColumns(10);
		textFieldDni.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {

			}

			@Override
			public void focusLost(FocusEvent e) {
				DNI=textFieldDni.getText();
				coleccion = facade.GetCuentas(DNI);
				for (Object v : coleccion)  c.addElement(v);

			}
		});

		textFieldDestino = new JTextField();
		textFieldDestino.setBounds(269, 243, 114, 19);
		contentPane.add(textFieldDestino);
		textFieldDestino.setColumns(10);
		textFieldDestino.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {

			}

			@Override
			public void focusLost(FocusEvent e) {
				try {
					Integer.parseInt(textFieldDestino.getText());
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(frame,
							"Eso no es un número de cuenta, mete un número cuenta por favor",
							"Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		textFieldCantidad = new JTextField();
		textFieldCantidad.setBounds(269, 301, 114, 19);
		contentPane.add(textFieldCantidad);
		textFieldCantidad.setColumns(10);
		textFieldCantidad.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {

			}

			@Override
			public void focusLost(FocusEvent e) {
				try {
					Integer.parseInt(textFieldCantidad.getText());
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(frame,
							"Eso no es un número, mete un número",
							"Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}
	private void setLabels() {
		JLabel lblHacerTransferencia = new JLabel("HACER TRANSFERENCIA");
		lblHacerTransferencia.setFont(new Font("Courier 10 Pitch", Font.BOLD, 24));
		lblHacerTransferencia.setBounds(80, 12, 293, 47);
		contentPane.add(lblHacerTransferencia);

		JLabel lblDni = new JLabel("Introduce el DNI");
		lblDni.setBounds(36, 137, 113, 15);
		contentPane.add(lblDni);

		JLabel lblEligeLaCuenta = new JLabel("Elige la Cuenta de origen");
		lblEligeLaCuenta.setBounds(36, 189, 202, 15);
		contentPane.add(lblEligeLaCuenta);

		JLabel lblCuentaDestino = new JLabel("Introduce Cuenta de destino");
		lblCuentaDestino.setBounds(36, 245, 218, 15);
		contentPane.add(lblCuentaDestino);

		JLabel lblCantidad = new JLabel("Introduce Cantidad");
		lblCantidad.setBounds(36, 303, 146, 15);
		contentPane.add(lblCantidad);
	}
	private JComboBox getcuentas() {
		if (cuentas == null) {
			cuentas = new JComboBox();
			cuentas.setBounds(269, 184, 114, 24);
			contentPane.add(cuentas);
			cuentas.setModel(c);
			cuentas.addActionListener(new  ActionListener() {


				public void actionPerformed(ActionEvent e) {

					if (cuentas.getItemCount() !=0){
						cuentaorigen = (Cuenta) cuentas.getSelectedItem();


					}
				}
			});

		}
		return cuentas;
	}

	public HacerTransferencia() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 473, 452);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);


		this.setSize(671, 649);
		this.setResizable(false);
		this.setLocationRelativeTo(null);

		setLabels();
		setFields();
		getJButton();
	}


	private JButton getJButton() {
		JButton btnContinuar = new JButton("Hacer Transferencia");
		btnContinuar.setBounds(170, 359, 117, 53);
		contentPane.add(btnContinuar);
		btnContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//if (textCuenta.isEditValid()) {
				try {
					FacadeImplementationWS facade = new FacadeImplementationWS();
					int cuentaOrigen= cuentas.getSelectedIndex();
					cuentadestino= Integer.parseInt(textFieldDestino.getText());
					cantidad= Float.parseFloat(textFieldCantidad.getText());

					java.util.Date fecha = new Date();
					facade.hacerTransferencia(cuentaOrigen, cuentadestino, cantidad);
					//facade.comprarDivisa(123, "Libra", 1);
					dispose();


					//	ApplicationFacadeInterfaceWS facade = StartWindow.getBusinessLogic();

						/*
						if (!checkEmptyFields()) {if (showConfirmDialog()) {


									Sucursal s = facade.GetSucursal(nombreSucursal,divisa);
									Cuenta c = facade.GetCuenta(bankAccount);
									int cobro = c.getComision()*cantidad;
									if (cantidad>s.getCantidad)
										showErrorCantidad();
										//EXCEPCION
									else if (cobro> c.getSaldo())
										showErrorSaldo();
										//EXCEPCION
									else{
										Operacion op = facade.Operacion(bankAccount,divisa,cantidad,fecha);
										c.ActualizarSaldo(bankAccount,cobro);
										s.ActualizarCantidadDivisas(divisa,cantidad);
									}
								dispose();

							}
						}

					} catch (NoSuchCuantity nsc) {
						showErrorCantidad();
					} catch (NoBalanceEnough nbe) {
						showErrorSaldo();
						*/
				} catch (Exception ex) {
					ex.printStackTrace();
				}

			}/*else{
					JOptionPane.showMessageDialog(null, "Please insert the 20 digits of the bankaccount");				}*/


		});
		return btnContinuar;

	}
}

