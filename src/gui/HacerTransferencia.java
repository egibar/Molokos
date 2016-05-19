package gui;

import businessLogic.FacadeImplementationWS;
import domain.Cuenta;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.*;
import java.awt.geom.Arc2D;
import java.util.Collection;
import java.util.Date;

public class HacerTransferencia extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldDni;
	private JTextField textFieldDestino;
	private JTextField textFieldCantidad;
	private JButton btnContinuar;
	private JComboBox cuentas = null;
	private String DNI;
	private Cuenta cuentaorigen;
	private int cuentadestino;
	private float cantidad;
	private int cuentaOrigen;
	protected Component frame;
	private DefaultComboBoxModel c = new DefaultComboBoxModel();
	private Collection coleccion;
		FacadeImplementationWS facade = new FacadeImplementationWS();

	/**
	 * Launch the application.
	 */
	/*
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
	
	public HacerTransferencia() {
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
		getcuentas();
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

	private void hacertransferencia() {
		try {
			if (!checkEmptyFields()) {
				FacadeImplementationWS facade = new FacadeImplementationWS();
				cuentaOrigen = cuentas.getSelectedIndex();
				cuentadestino = Integer.parseInt(textFieldDestino.getText());
				cantidad = Float.parseFloat(textFieldCantidad.getText());

				if (showConfirmDialog()) {
					java.util.Date fecha = new Date();
					facade.hacerTransferencia(cuentaOrigen, cuentadestino, cantidad);
					dispose();
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void keyHandler(Component c){
		c.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {			}

			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == 10)//Intro
					hacertransferencia();
			}

			@Override
			public void keyReleased(KeyEvent e) {

			}
		});
	}

	private JButton getJButton() {
		if (btnContinuar == null) {
			btnContinuar = new JButton("Hacer Transferencia");
			btnContinuar.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 50));
			btnContinuar.setForeground(Colors.FONTCOLOR);
			btnContinuar.setBackground(Colors.FOREGROUNDCOLOR);
			btnContinuar.setBounds(271, 965, 512, 137);
			contentPane.add(btnContinuar);
			btnContinuar.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
				hacertransferencia();
			}
			});
		}
		return btnContinuar;
	}

	private void setFields(){
		textFieldDni = new JTextField();
		textFieldDni.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 40));
		textFieldDni.setBounds(561, 249, 331, 85);
		contentPane.add(textFieldDni);
		textFieldDni.setColumns(10);
		textFieldDni.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {			}

			@Override
			public void focusLost(FocusEvent e) {
				DNI=textFieldDni.getText();
				coleccion = facade.GetCuentas(DNI);
				for (Object v : coleccion)  c.addElement(v);
			}
		});

		textFieldDestino = new JTextField();
		textFieldDestino.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 40));
		textFieldDestino.setBounds(568, 655, 331, 85);
		contentPane.add(textFieldDestino);
		textFieldDestino.setColumns(10);
		textFieldDestino.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {			}

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
		textFieldCantidad.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 40));
		textFieldCantidad.setBounds(561, 818, 338, 80);
		contentPane.add(textFieldCantidad);
		textFieldCantidad.setColumns(10);
		textFieldCantidad.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {			}

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
		lblHacerTransferencia.setFont(new Font("Courier New", Font.BOLD, 60));
		lblHacerTransferencia.setBounds(206, 12, 719, 161);
		contentPane.add(lblHacerTransferencia);

		JLabel lblDni = new JLabel("Introduce el DNI");
		lblDni.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 40));
		lblDni.setBounds(36, 264, 435, 101);
		contentPane.add(lblDni);

		JLabel lblEligeLaCuenta = new JLabel("Elige la Cuenta de origen");
		lblEligeLaCuenta.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 40));
		lblEligeLaCuenta.setBounds(26, 438, 445, 101);
		contentPane.add(lblEligeLaCuenta);

		JLabel lblCuentaDestino = new JLabel("Introduce Cuenta de destino");
		lblCuentaDestino.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 40));
		lblCuentaDestino.setBounds(26, 655, 505, 123);
		contentPane.add(lblCuentaDestino);

		JLabel lblCantidad = new JLabel("Introduce Cantidad");
		lblCantidad.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 40));
		lblCantidad.setBounds(36, 818, 365, 85);
		contentPane.add(lblCantidad);
	}
	private JComboBox getcuentas() {
		if (cuentas == null) {
			cuentas = new JComboBox();
			cuentas.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 40));
			cuentas.setBounds(568, 438, 331, 159);
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
	private boolean checkEmptyFields() {
		String message = "Please fill in all the fields";
		if (textFieldDni.getText().isEmpty()||textFieldDestino.getText().isEmpty()||textFieldCantidad.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, message, "Error",
					JOptionPane.WARNING_MESSAGE);
			return true;
		} else {
			return false;
		}
	}

	private boolean showConfirmDialog() {

		String nl = System.getProperty("line.separator");

		String message = "Please confirm the following data:" + nl + "DNI: "
				+ DNI + nl + "Cuenta Origen: " + cuentaorigen + nl + "Cuenta Destino: " + cuentadestino
				+ nl + "Cantidad: " + cantidad;

		int selection = JOptionPane.showConfirmDialog(null, message,
				"Confirmation", JOptionPane.YES_NO_OPTION);

		return selection == 0;
	}

	

	
}

