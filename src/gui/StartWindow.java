package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import businessLogic.ApplicationFacadeInterfaceWS;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;

public class StartWindow extends JFrame {

	private JPanel contentPane;
	private static JMenuBar menuBar;
	private static JMenu mnComprar;
	private static JMenu mnTransferencia;
	private static JMenu mnListado;
	private static JMenuItem mntmComprarDivisas;
	private static JMenuItem mntmVenderDivisas;
	private static JMenuItem mntmHacerTransferencia;
	private static JMenuItem mntmVerTransferencias;
	private static JMenuItem mntmVerTransferenciasCliente;
	private static JMenuItem mntmObtenerListado;
	private static JSeparator separator;
	private static JSeparator separator_1;
	private static JSeparator separator_2;



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartWindow frame = new StartWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public static ApplicationFacadeInterfaceWS facadeInterface;
	public static ApplicationFacadeInterfaceWS getBusinessLogic() {
		return facadeInterface;
	}


	/**
	 * Create the frame.
	 */
	public StartWindow() {
		
		setTitle("MOLOKOS");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 722, 512);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		setJMenuBar(getMenuBar_1());
		JSeparator separator = new JSeparator();
		mnComprar.add(separator);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(12, 0, 710, 463);
		contentPane.add(tabbedPane);
		
		JPanel panelMain = new JPanel();
		tabbedPane.addTab("New tab", null, panelMain, null);
		panelMain.setLayout(null);
		
		JButton btnComprarDivisas = new JButton("Comprar Divisas");
		btnComprarDivisas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame a = new ComprarDivisas();
				a.setVisible(true);
			}
		});
		btnComprarDivisas.setForeground(Color.BLACK);
		btnComprarDivisas.setBackground(UIManager.getColor("Button.background"));
		btnComprarDivisas.setBounds(57, 85, 228, 53);
		panelMain.add(btnComprarDivisas);
		
		JButton btnVenderDivisas = new JButton("Vender Divisas");
		btnVenderDivisas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnVenderDivisas.setForeground(Color.BLACK);
		btnVenderDivisas.setBackground(UIManager.getColor("Button.background"));
		btnVenderDivisas.setBounds(390, 85, 228, 53);
		panelMain.add(btnVenderDivisas);
		
		JButton btnHacerTransferencia = new JButton("Hacer Transferencia");
		btnHacerTransferencia.setForeground(Color.BLACK);
		btnHacerTransferencia.setBackground(UIManager.getColor("Button.background"));
		btnHacerTransferencia.setBounds(57, 212, 228, 53);
		panelMain.add(btnHacerTransferencia);
		btnHacerTransferencia.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		JFrame a = new HacerTransferencia();
		a.setVisible(true);
	}
});
	}

	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnComprar());
			menuBar.add(getMnTransferencia());
			menuBar.add(getMnListado());
		}
		return menuBar;
	}
	
	private JMenu getMnComprar() {
		if (mnComprar == null) {
			mnComprar = new JMenu("Comprar/Vender");
			mnComprar.add(getMntmComprarDivisas());
			mnComprar.add(getMntmVenderDivisas());
		}
		return mnComprar;
	}
	
	private JMenu getMnTransferencia() {
		if (mnTransferencia == null) {
			mnTransferencia = new JMenu("Transferencia");
			mnTransferencia.add(getMntmHacerTransferencia());
			mnTransferencia.add(getMntmVerTransferenciaCliente());
			mnTransferencia.add(getSeparator());
			mnTransferencia.add(getMntmVerTransferencia());
		}
		return mnTransferencia;
	}
	private JMenu getMnListado() {
		if (mnListado == null) {
			mnListado = new JMenu("Listado");
			//mnListado.add(getSeparator());
			mnListado.add(getMntmObtenerListado());
		}
		return mnListado;
	}


	
	private JMenuItem getMntmComprarDivisas() {
		if (mntmComprarDivisas == null) {
			mntmComprarDivisas = new JMenuItem("Comprar Divisas");
		}
		mntmComprarDivisas.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame a = new ComprarDivisas();
				a.setVisible(true);
			}
		});
		return mntmComprarDivisas;
	}
	
	private JMenuItem getMntmVenderDivisas() {
		if (mntmVenderDivisas == null) {
			mntmVenderDivisas = new JMenuItem("Vender Divisas");
		}
		mntmVenderDivisas.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				mntmVenderDivisas.doClick();
			}
		});
		return mntmVenderDivisas;
	}
	
	private JMenuItem getMntmHacerTransferencia() {
		if (mntmHacerTransferencia == null) {
			mntmHacerTransferencia = new JMenuItem("Hacer Transferencia");
		}
		mntmHacerTransferencia.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame a = new HacerTransferencia();
				a.setVisible(true);
			}
		});
		return mntmHacerTransferencia;
	}
	
	private JMenuItem getMntmVerTransferencia() {
		if (mntmVerTransferencias == null) {
			mntmVerTransferencias = new JMenuItem("Ver Transferencias");
		}
		mntmVerTransferencias.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				mntmVerTransferencias.doClick();
			}
		});
		return mntmVerTransferencias;
	}
	
	private JMenuItem getMntmVerTransferenciaCliente() {
		if (mntmVerTransferenciasCliente == null) {
			mntmVerTransferenciasCliente = new JMenuItem("Ver Transferencias Cliente");
		}
		mntmVerTransferenciasCliente.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				mntmVerTransferenciasCliente.doClick();
			}
		});
		return mntmVerTransferenciasCliente;
	}
	
	private JMenuItem getMntmObtenerListado() {
		if (mntmObtenerListado == null) {
			mntmObtenerListado = new JMenuItem("Ver Transferencias");
		}
		mntmObtenerListado.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				mntmObtenerListado.doClick();
			}
		});
		return mntmObtenerListado;
	}
	
	
	
	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
		}
		return separator;
	}
}

