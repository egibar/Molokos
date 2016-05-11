package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class HacerTransferencia extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldDni;
	private JTextField textFieldDestino;
	private JTextField textFieldCantidad;

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
	public HacerTransferencia() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 473, 452);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
		
		textFieldDni = new JTextField();
		textFieldDni.setBounds(269, 135, 114, 19);
		contentPane.add(textFieldDni);
		textFieldDni.setColumns(10);
		
		textFieldDestino = new JTextField();
		textFieldDestino.setBounds(269, 243, 114, 19);
		contentPane.add(textFieldDestino);
		textFieldDestino.setColumns(10);
		
		textFieldCantidad = new JTextField();
		textFieldCantidad.setBounds(269, 301, 114, 19);
		contentPane.add(textFieldCantidad);
		textFieldCantidad.setColumns(10);
		
		JButton btnContinuar = new JButton("Continuar");
		btnContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnContinuar.setBounds(170, 359, 117, 53);
		contentPane.add(btnContinuar);
		
		JComboBox comboBoxOrigen = new JComboBox();
		comboBoxOrigen.setBounds(269, 184, 114, 24);
		contentPane.add(comboBoxOrigen);
	}
}
