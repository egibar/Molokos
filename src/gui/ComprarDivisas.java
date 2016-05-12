package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import businessLogic.ApplicationFacadeInterface;
import domain.User;
import exceptions.OverlappingUserExists;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Date;
import java.awt.event.ActionEvent;

public class ComprarDivisas extends JFrame {

	private JPanel contentPane;
	private JTextField textDivisa;
	private JTextField textCantidad;
	private JTextField textCuenta;
	private JButton btnComprar;
	
	private String divisa;
	private int cantidad;
	private String bankAccount;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ComprarDivisas frame = new ComprarDivisas();
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
	public ComprarDivisas() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 483, 333);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblComparDivisas = new JLabel("COMPAR DIVISAS");
		lblComparDivisas.setFont(new Font("Courier 10 Pitch", Font.BOLD, 24));
		lblComparDivisas.setBounds(140, 12, 247, 47);
		contentPane.add(lblComparDivisas);
		
		JLabel lblDivisa = new JLabel("Introduce Divisa");
		lblDivisa.setBounds(35, 74, 130, 15);
		contentPane.add(lblDivisa);
		
		JLabel lblCantidad = new JLabel("Introduce Cantidad");
		lblCantidad.setBounds(35, 130, 145, 15);
		contentPane.add(lblCantidad);
		
		JLabel lblCuenta = new JLabel("Introduce Cuenta");
		lblCuenta.setBounds(35, 188, 145, 15);
		contentPane.add(lblCuenta);
		
		textDivisa = new JTextField();
		textDivisa.setBounds(208, 71, 114, 19);
		contentPane.add(textDivisa);
		textDivisa.setColumns(10);
		
		textCantidad = new JTextField();
		textCantidad.setText("");
		textCantidad.setBounds(208, 128, 114, 19);
		contentPane.add(textCantidad);
		textCantidad.setColumns(10);
		
		MaskFormatter mascara;
		try {
			mascara = new MaskFormatter("####-####-##-##########");
			textCuenta = new JFormattedTextField(mascara);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		textCuenta = new JTextField();
		textCuenta.setText("");
		textCuenta.setBounds(208, 186, 114, 19);
		contentPane.add(textCuenta);
		textCuenta.setColumns(10);
		
		private JButton getJButton() {
			btnComprar = new JButton("Comprar");
			btnComprar.setBounds(164, 246, 158, 47);
			contentPane.add(btnComprar);
		btnComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textCuenta.isEditValid()) {
					try {

						ApplicationFacadeInterface facade = StartWindow.getBusinessLogic();

						divisa = textDivisa.getText();
						cantidad = textCantidad.getText();
						bankAccount = textCuenta.getText();
						java.util.Date fecha = new Date();
						if (!checkEmptyFields()) {
							if (showConfirmDialog()) {

									Sucursal s = facade.GetSucursal(bankAccount,divisa);
									Cuenta c = facade.getCuenta(bankAccount);
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
					} catch (Exception ex) {
						ex.printStackTrace();
					}

				}else{
					JOptionPane.showMessageDialog(null, "Please insert the 20 digits of the bankaccount");				}
			}
			
		});
		return btnComprar;
	}

	
	private boolean checkEmptyFields() {
		String message = "Please fill in all the fields";
		if (bankAccount.trim().equals("") || divisa.trim().equals("")
				|| cantidad.trim().equals("")) {
			JOptionPane.showMessageDialog(null, message, "Error",
					JOptionPane.WARNING_MESSAGE);
			return true;
		} else {
			return false;
		}

	}
}
