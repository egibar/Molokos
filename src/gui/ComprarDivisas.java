package gui;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import businessLogic.ApplicationFacadeInterfaceWS;
import businessLogic.FacadeImplementationWS;
import domain.Cuenta;
import domain.Operacion;
import domain.Sucursal;


import java.awt.event.*;
import java.awt.geom.Arc2D;
import java.text.ParseException;
import java.util.Date;

public class ComprarDivisas extends JFrame {

	private JPanel contentPane;
	private JTextField textDivisa;
	private JTextField textCantidad;
	private JTextField textCuenta;
	private JButton btnComprar;

	private String divisa;
	private float cantidad;
	private int bankAccount;
	protected Component frame1;
	protected Component frame2;
	protected Component frame3;


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
		setBounds(100, 100, 473, 452);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);


		this.setSize(1243, 1205);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		setResizable(false);

		this.setFocusable(true);

		setLabels();
		setFields();
		getJButton();
		keyHandler(this);

		this.addWindowListener(new WindowListener() {
			@Override
			public void windowOpened(WindowEvent e) {

			}

			@Override
			public void windowClosing(WindowEvent e) {

				if (true) {

					int res = JOptionPane.showConfirmDialog(null,
							"¿Estás seguro que quieres descartar los cambios?", null, JOptionPane.YES_NO_OPTION);
					if (res == JOptionPane.YES_OPTION)
						setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					else
						setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

				} else
					dispose();
			}

			@Override
			public void windowClosed(WindowEvent e) {

			}

			@Override
			public void windowIconified(WindowEvent e) {

			}

			@Override
			public void windowDeiconified(WindowEvent e) {

			}

			@Override
			public void windowActivated(WindowEvent e) {

			}

			@Override
			public void windowDeactivated(WindowEvent e) {

			}

		});
		setVisible(true);


	}




			//public void actionPerformed(ActionEvent e) {
				//if (textCuenta.isEditValid()) {
				private void comprardivisas() {
					try {

						FacadeImplementationWS facade = new FacadeImplementationWS();

						if (!checkEmptyFields()) {
							//if (showConfirmDialog()) {

							divisa = textDivisa.getText();
							cantidad = Float.parseFloat(textCantidad.getText());
							bankAccount = Integer.parseInt(textCuenta.getText());
							if(showConfirmDialog()){
							facade.comprarDivisa(bankAccount, divisa, cantidad);
							//facade.comprarDivisa(123, "Libra", 1);
							dispose();
							}
						}

						//	ApplicationFacadeInterfaceWS facade = StartWindow.getBusinessLogic();


						/*
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
				}
				//}
				/*else{
					JOptionPane.showMessageDialog(null, "Please insert the 20 digits of the bankaccount");				}*/



				private void keyHandler(Component c){
					c.addKeyListener(new KeyListener() {
						@Override
						public void keyTyped(KeyEvent e) {			}

						@Override
						public void keyPressed(KeyEvent e) {
							if(e.getKeyCode() == 10)//Intro
								comprardivisas();
						}

						@Override
						public void keyReleased(KeyEvent e) {

						}
					});
				}
	
				
				
private JButton getJButton() {
		if (btnComprar == null) {
		btnComprar = new JButton("Comprar");
		btnComprar.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 50));
		btnComprar.setForeground(Colors.FONTCOLOR);
		btnComprar.setBackground(Colors.FOREGROUNDCOLOR);
		btnComprar.setBounds(286, 899, 512, 137);
		contentPane.add(btnComprar);
		btnComprar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				comprardivisas();
			}
		});
		}
		return btnComprar;
		}

	private void setFields(){

		textDivisa = new JTextField();
		textDivisa.setBounds(707, 259, 346, 85);
		textDivisa.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 40));
		contentPane.add(textDivisa);
		textDivisa.setColumns(10);
		textDivisa.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {

			}

			@Override
			public void focusLost(FocusEvent e) {
				String divisa= textDivisa.getText();
				if ((!divisa.equals("Libra"))&&(!divisa.equals("Dolar")))
				{
					JOptionPane.showMessageDialog(frame1,
							"No es una moneda valida, por favor cambie de moneda",
							"Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});


		textCuenta = new JTextField();
		textCuenta.setText("");

		/*
		MaskFormatter mascara;
		try {
			mascara = new MaskFormatter("####-####-##-##########");
			textCuenta = new JFormattedTextField(mascara);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		textCuenta.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 40));
		textCuenta.setBounds(715, 656, 338, 85);
		contentPane.add(textCuenta);
		textCuenta.setColumns(10);

		textCantidad = new JTextField();
		textCantidad.setText("");
		textCantidad.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 40));
		textCantidad.setBounds(715, 455, 338, 80);
		contentPane.add(textCantidad);
		textCantidad.setColumns(10);
		textCantidad.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {

			}

			@Override
			public void focusLost(FocusEvent e) {
				try {
					Integer.parseInt(textCantidad.getText());
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(frame2,
							"Eso no es un número, mete un número",
							"Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

	}
	private void setLabels() {
		JLabel lblComparDivisas = new JLabel("COMPAR DIVISAS");
		lblComparDivisas.setFont(new Font("Courier New", Font.BOLD, 60));
		lblComparDivisas.setBounds(297, 41, 719, 161);
		contentPane.add(lblComparDivisas);

		JLabel lblDivisa = new JLabel("Introduce Divisa");
		lblDivisa.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 40));
		lblDivisa.setBounds(116, 251, 435, 101);
		contentPane.add(lblDivisa);

		JLabel lblCantidad = new JLabel("Introduce Cantidad");
		lblCantidad.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 40));
		lblCantidad.setBounds(116, 440, 445, 101);
		contentPane.add(lblCantidad);

		JLabel lblCuenta = new JLabel("Introduce Cuenta");
		lblCuenta.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 40));
		lblCuenta.setBounds(116, 637, 505, 123);
		contentPane.add(lblCuenta);
	}

	private boolean checkEmptyFields() {
		String message = "Please fill in all the fields";
		if (textCuenta.getText().isEmpty()||textDivisa.getText().isEmpty()||textCantidad.getText().isEmpty()
			/*bankAccount.trim().equals("") ||divivisa.trim().equals("")
				/*|| cantidad.trim().equals("")*/) {
			JOptionPane.showMessageDialog(null, message, "Error",
					JOptionPane.WARNING_MESSAGE);
			return true;
		} else {
			return false;
		}
	}

	private boolean showConfirmDialog() {

		String nl = System.getProperty("line.separator");

		String message = "Please confirm the following data:" + nl + "Divisa: "
				+ divisa + nl + "Cantidad: " + cantidad + nl + "Cuenta: " + bankAccount;

		int selection = JOptionPane.showConfirmDialog(null, message,
				"Confirmation", JOptionPane.YES_NO_OPTION);

		return selection == 0;
	}
}
