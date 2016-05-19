package dataAccess;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.io.File;
import java.util.Date;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import configuration.ConfigXML;

import javax.swing.JTextArea;

import com.db4o.ObjectContainer;
import com.db4o.ObjectServer;
import com.db4o.cs.Db4oClientServer;
import com.db4o.cs.config.ClientConfiguration;
import com.db4o.cs.config.ServerConfiguration;

import domain.Cliente;
import domain.Cuenta;
import domain.Divisas;
import domain.Operacion;
import domain.Sucursal;
import domain.Transferencia;
import configuration.ConfigXML;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DB4oManagerServer extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	JTextArea textArea;
	ObjectServer server;
	private ServerConfiguration configurationCS;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DB4oManagerServer dialog = new DB4oManagerServer();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DB4oManagerServer() {
		setTitle("DB4oManagerServer: running the database server");
		setBounds(100, 100, 486, 180);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			textArea = new JTextArea();
			contentPanel.add(textArea);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						textArea.append("\n\n\nClosing the database... ");
					    try {
					    	System.out.println("Server close");
							server.close();
							System.exit(1);
							
						} catch (Exception e1) {
						}
						System.exit(1);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		ConfigXML c=ConfigXML.getInstance();
		
		if (c.isDatabaseLocal()) {
			textArea.append("\nERROR, the database is configured as local");
		}
		else {
		try{
			if (c.getDataBaseOpenMode().equals("initialize")) 
				new File(c.getDb4oFilename()).delete();
			configurationCS = Db4oClientServer.newServerConfiguration();
			configurationCS.common().activationDepth(c.getActivationDepth());
			configurationCS.common().updateDepth(c.getUpdateDepth());
			//configurationCS.common().objectClass(RuralHouse.class).cascadeOnDelete(true);

			server = Db4oClientServer.openServer(configurationCS,
									 			 c.getDb4oFilename(),c.getDatabasePort());
			
			textArea.append("\nConnection to the database '"+c.getDb4oFilename()+"' opened in port "+c.getDatabasePort());
	
		    server.grantAccess(c.getUser(),c.getPassword());

		    textArea.append("\nAccess granted to: "+c.getUser());
		    
			//if (c.getDataBaseOpenMode().equals("initialize")) 
				
			//initializeDB();
				
			
			



			textArea.append("\nPress button to exit this database server... ");
			
		} catch (Exception e) {
			textArea.append("Something has happened in DB4oManagerServer: "+e.toString());

		}
		
		}
	}
	public void initializeDB(){
		System.out.println("Database initialized");
		ConfigXML c;
		c=ConfigXML.getInstance();
		ClientConfiguration configurationCS;
		configurationCS = Db4oClientServer.newClientConfiguration();
		configurationCS.common().activationDepth(c.getActivationDepth());
		configurationCS.common().updateDepth(c.getUpdateDepth());
		//configurationCS.common().objectClass(RuralHouse.class).cascadeOnDelete(true);
		ObjectContainer db = Db4oClientServer.openClient(configurationCS,c.getDatabaseNode(), 
				 c.getDatabasePort(),c.getUser(),c.getPassword());
		 
	     
		Divisas d1=new Divisas(30000, 2,"Dolar","Gros");
		Divisas d2=new Divisas(50000, 3,"Libra","Gros");
		Divisas d3=new Divisas(1, 30000000,"Euro","Gros");
		Divisas[] daux = {d1, d2, d3};

		Date fecha = new Date();
		/*Operacion op1 = new Operacion(fecha,"Compra","Libra",1,1,"Gros");
		Vector<Operacion> v = new Vector<Operacion>();
		v.addElement(op1);*/
		Operacion op3 = new Operacion(fecha,"Venta","Dolar",1,123,"Gros");
		Vector<Operacion> v3 = new Vector<Operacion>();
		v3.addElement(op3);


		Operacion op2 = new Operacion(fecha,"Compra","Dolar",1,1,"Gros");
		Vector<Operacion> v2 = new Vector<Operacion>();
		v2.addElement(op2);

		Operacion op1 = new Operacion(fecha,"Compra","Libra",1,1,"Gros");
		Vector<Operacion> v = new Vector<Operacion>();
		v.addElement(op1);
		v.addElement(op2);

		Transferencia trans = new Transferencia(fecha,1,123,1);
		Vector<Transferencia> t = new Vector<Transferencia>();
		t.addElement(trans);

		Cuenta cuenta1= new Cuenta(1,9000,"72526101V",t,v);
		Cuenta cuenta2= new Cuenta(123,9000,"72526101V",t,v3);
		Cuenta[] caux = {cuenta1,cuenta2};

		Cliente c1= new Cliente("Asier","Egibar","72526101V",caux);
		Cliente c2= new Cliente("Asier","Blazkez","4586798C",null);



		Sucursal s1=new Sucursal(2, "Gros",daux, caux);
		Sucursal s2=new Sucursal(2, "Amara",daux,caux);

		db.store(s1);
		db.store(s2);
		db.store(d1);
		db.store(d2);
		db.store(c1);
		db.store(c2);
		db.store(cuenta1);
		db.store(cuenta2);

		 
		 db.commit();
		 //db.close();
	}
}
	
