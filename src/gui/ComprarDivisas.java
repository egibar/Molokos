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

public class ComprarDivisas extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldDivisa;
	private JTextField textFieldCantidad;
	private JTextField textFieldCuenta;

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
		
		textFieldDivisa = new JTextField();
		textFieldDivisa.setBounds(208, 71, 114, 19);
		contentPane.add(textFieldDivisa);
		textFieldDivisa.setColumns(10);
		
		textFieldCantidad = new JTextField();
		textFieldCantidad.setText("");
		textFieldCantidad.setBounds(208, 128, 114, 19);
		contentPane.add(textFieldCantidad);
		textFieldCantidad.setColumns(10);
		
		textFieldCuenta = new JTextField();
		textFieldCuenta.setText("");
		textFieldCuenta.setBounds(208, 186, 114, 19);
		contentPane.add(textFieldCuenta);
		textFieldCuenta.setColumns(10);
		
		JButton btnComprar = new JButton("Comprar");
		btnComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnComprar.setBounds(164, 246, 158, 47);
		contentPane.add(btnComprar);
	}
}
