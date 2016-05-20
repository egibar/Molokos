package gui;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import businessLogic.ApplicationFacadeInterfaceWS;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ResourceBundle;

public class StartWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	//private static JSeparator separator_1;
	//private static JSeparator separator_2;
	public static ResourceBundle strings;



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

		setJMenuBar(menuBar);
		setJMenuBar(getMenuBar_1());
		setTitle("MOLOKOS");
		setResizable(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 768, 730);
		this.setSize(1243, 1205);


		contentPane = new JPanel();
		contentPane.setBackground(Colors.FOREGROUNDCOLOR);
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(Colors.FOREGROUNDCOLOR);
		tabbedPane.setBounds(6, 6, 1231, 1087);
		contentPane.add(tabbedPane);

		JPanel panelMain = new JPanel();
		panelMain.setBackground(Colors.FOREGROUNDCOLOR);
		tabbedPane.addTab("Main", null, panelMain, null);
		panelMain.setLayout(null);
//------------------------------------------------------------//

		//JMenuBar menuBar = new JMenuBar();

		JSeparator separator = new JSeparator();
		mnComprar.add(separator);
//------------------------------------------------------------//
		JButton btnComprarDivisas = new JButton("Comprar Divisas");
		btnComprarDivisas.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 50));
		btnComprarDivisas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame a = new ComprarDivisas();
				a.setVisible(true);
			}
		});
		btnComprarDivisas.setForeground(Colors.FONTCOLOR);
		btnComprarDivisas.setBackground(Colors.FOREGROUNDCOLOR);
		//btnComprarDivisas.setBackground(UIManager.getColor("Button.background"));
		btnComprarDivisas.setBounds(62, 396, 425, 154);
		panelMain.add(btnComprarDivisas);
		
		JButton btnVenderDivisas = new JButton("Vender Divisas");
		btnVenderDivisas.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 50));
		btnVenderDivisas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//mntmVenderDivisas.doClick();
			}
		});
		btnVenderDivisas.setForeground(Colors.FONTCOLOR);
		btnVenderDivisas.setBackground(Colors.FOREGROUNDCOLOR);
		//btnVenderDivisas.setBackground(UIManager.getColor("Button.background"));
		btnVenderDivisas.setBounds(601, 396, 491, 154);
		panelMain.add(btnVenderDivisas);
			
		JButton btnHacerTransferencia = new JButton("Hacer Transferencia");
		btnHacerTransferencia.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 50));
		btnHacerTransferencia.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			JFrame b = new HacerTransferencia();
			b.setVisible(true);
			}
		});
		btnHacerTransferencia.setForeground(Colors.FONTCOLOR);
		btnHacerTransferencia.setBackground(Colors.FOREGROUNDCOLOR);
		//btnHacerTransferencia.setBackground(UIManager.getColor("Button.background"));
		btnHacerTransferencia.setBounds(62, 721, 425, 154);
		panelMain.add(btnHacerTransferencia);

		JButton btnListado = new JButton("Obtener Listado");
		btnListado.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 50));
		btnListado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame c = new ObtenerListado();
				c.setVisible(true);
			}
		});
		btnListado.setForeground(Colors.FONTCOLOR);
		btnListado.setBackground(Colors.FOREGROUNDCOLOR);
//		btnListado.setBackground(UIManager.getColor("Button.background"));
		btnListado.setBounds(594,  721, 498, 154);
		panelMain.add(btnListado);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setBounds(400, 28, 285, 288);
		lblLogo.setVisible(true);
		ImageIcon x = new ImageIcon("Logo.jpg");
		ImageIcon t = new ImageIcon(x.getImage().getScaledInstance(
				lblLogo.getWidth(), lblLogo.getHeight(),
				Image.SCALE_DEFAULT));
		lblLogo.setIcon(t);
		panelMain.add(lblLogo);
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
				JFrame a = new ObtenerListado();
				a.setVisible(true);
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

	public ResourceBundle getStrings() {
		return strings;
	}

	/*private JPanel setContainerPanel(){
		JPanel mainPane = new JPanel();
		mainPane.setLayout(new BoxLayout(mainPane, BoxLayout.PAGE_AXIS));
		mainPane.add(setLanguagesPane());
		mainPane.add(setContentPane());
		return mainPane;
	}
	private JPanel setLanguagesPane(){
		JPanel lanPane = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		String[] listaIdiomas = {"ingles", "castellano", "chino", "frances", "turco", "swahili", "euskera"};

		JComboBox combo = new JComboBox(listaIdiomas);;
		lanPane.add(combo);
		lanPane.setBackground(new Color(240, 240, 240));

		combo.addActionListener(e->{
			System.out.println(combo.getSelectedItem());
			strings = ResourceBundle.getBundle("languages/Idioma", idiomas.get((String) combo.getSelectedItem()));
			bus.reloadFields();
			edit.reloadFields();
			newRh.reloadFields();
			reserva.reloadFields();
			addOferta.reloadFields();
			reloadMain();
		});

		return lanPane;
	}
	private void languageSettings(){

		idiomas = new HashMap<>();

		idiomas.put("ingles", new Locale("en", "US"));
		idiomas.put("castellano", new Locale("es", "ES"));
		idiomas.put("euskera", new Locale("eu", "EU"));

		strings = ResourceBundle.getBundle("languages/Idioma", Locale.getDefault());
	}*/

}

