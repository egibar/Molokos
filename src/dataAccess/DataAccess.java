package dataAccess;


import java.security.acl.Owner;
import java.util.Date;
import java.util.ListIterator;
import java.util.Vector;

import javax.jws.WebMethod;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.config.EmbeddedConfiguration;
import com.db4o.cs.Db4oClientServer;
import com.db4o.cs.config.ClientConfiguration;

import configuration.ConfigXML;
//import domain.Booking;
import domain.*;
import exceptions.OverlappingOfferExists;

public class DataAccess  {
	protected static ObjectContainer  db;

	private static DB4oManagerAux theDB4oManagerAux;
	private static EmbeddedConfiguration configuration;
	private static ClientConfiguration configurationCS;


	ConfigXML c;

	public DataAccess()  {
		
		c=ConfigXML.getInstance();
		
		if (c.isDatabaseLocal()) {
			configuration = Db4oEmbedded.newConfiguration();
			configuration.common().activationDepth(c.getActivationDepth());
			configuration.common().updateDepth(c.getUpdateDepth());
			db=Db4oEmbedded.openFile(configuration, c.getDb4oFilename());
		} else {
			configurationCS = Db4oClientServer.newClientConfiguration();
			configurationCS.common().activationDepth(c.getActivationDepth());
			configurationCS.common().updateDepth(c.getUpdateDepth());
			configurationCS.common().objectClass(RuralHouse.class).cascadeOnDelete(true);
			db = Db4oClientServer.openClient(configurationCS,c.getDatabaseNode(), 
				 c.getDatabasePort(),c.getUser(),c.getPassword());
				
		}
		System.out.println("Creating DB4oManager instance => isDatabaseLocal: "+c.isDatabaseLocal()+" getDatabBaseOpenMode: "+c.getDataBaseOpenMode());
		}


	
	 class DB4oManagerAux {
		int offerNumber;
		DB4oManagerAux(int offerNumber){
			this.offerNumber=offerNumber;
		}
	}


	
	
	public void initializeDB(){
		
		System.out.println("Db initialized");
		Sucursal s1=new Sucursal(1.5, "Gros","Avenida Miracruz");
		Sucursal s2=new Sucursal(1.2, "Amara","Anoeta");
		Divisas d1=new Divisas(300, 1,"Dolar");
		Divisas d2=new Divisas(500, 3,"Libra");
		Cliente c1= new Cliente("Asier","Egibar","72526101V");
		Cliente c2= new Cliente("Asier","Blazkez","4586798C");
		Cuenta cuenta1= new Cuenta("72526101V",1111-1111-11-111111111, 300);
		Cuenta cuenta2= new Cuenta("72526101V",1234-5678-91-234567891, 1000);



		db.store(s1);
		db.store(s2);
		db.store(d1);
		db.store(d2);
		db.store(c1);
		db.store(c2);
		db.store(cuenta1);
		db.store(cuenta2);
		 
		theDB4oManagerAux=new DB4oManagerAux(1);
		 
		db.store(theDB4oManagerAux);

		 
		db.commit();
	}
	
	public Offer createOffer(RuralHouse ruralHouse, Date firstDay, Date lastDay, float price) {

	try {
		
		RuralHouse proto = new RuralHouse(ruralHouse.getHouseNumber(),null,null);
		ObjectSet<RuralHouse> result = db.queryByExample(proto);
		RuralHouse rh=result.next();
		
		ObjectSet<DB4oManagerAux> res =db.queryByExample(DB4oManagerAux.class);
		ListIterator<DB4oManagerAux> listIter = res.listIterator();
		if (listIter.hasNext()) theDB4oManagerAux =  res.next();    
		
		Offer o=rh.createOffer(theDB4oManagerAux.offerNumber++,firstDay, lastDay, price);
		//Offer o=rh.createOffer(1,firstDay, lastDay, price);

		db.store(theDB4oManagerAux); // To store the new value for offerNumber
		db.store(rh);
		db.commit(); 
		return o;
	}
	catch (com.db4o.ext.ObjectNotStorableException e){
		System.out.println("Error: com.db4o.ext.ObjectNotStorableException in createOffer");
		return null;
	}
	}
	
	
	public Vector<Cuenta> getAllCuentas(String DNI) {


		 try {
			 Cuenta proto = new Cuenta(DNI);
			 ObjectSet<Cuenta> result = db.queryByExample(proto);
			 Vector<Cuenta> cuenta=new Vector<Cuenta>();
			 while(result.hasNext()) 
				 cuenta.add(result.next());
			 return cuenta;
	     } finally {
	         //db.close();
	     }
	}
	 public Vector<Offer> getOffers( RuralHouse rh, Date firstDay,  Date lastDay) {
		 Vector<Offer> offers=new Vector<Offer>();
		 RuralHouse rhn = (RuralHouse) db.queryByExample(new RuralHouse(rh.getHouseNumber(),null,null)).next();	
		  offers=rhn.getOffers(firstDay, lastDay);
		  return offers;
	

	
	 }
	public boolean existsOverlappingOffer(RuralHouse rh,Date firstDay, Date lastDay) throws  OverlappingOfferExists{
		 try {

			RuralHouse rhn = (RuralHouse) db.queryByExample(new RuralHouse(rh.getHouseNumber(),null,null)).next();		
			if (rhn.overlapsWith(firstDay, lastDay)!=null) return true;
			else return false; 
	     } finally {
	         //db.close();
	     }
	}


	public void close(){
		db.close();
		System.out.println("DataBase closed");
	}
	public Vector<Sucursal> GetSucursal(String nombre){

			try {
				Sucursal proto = new Sucursal(null, null, nombre);
				ObjectSet<Object> result = db.queryByExample(proto);

				Vector<Sucursal> sucursal = new Vector<Sucursal>();
				while (result.hasNext())
					sucursal.add((Sucursal) result.next());
				return sucursal;
			} finally {
				// db.close();
			}
	}
	public Vector<Cuenta> GetCuenta(int numero) {
		try {
			Cuenta proto = new Cuenta(numero,);
			ObjectSet<Object> result = db.queryByExample(proto);
			/*
			 * proto = new Owner(null, null, null, false, null); result.addAll(db.queryByExample(proto));
			 */
			Vector<Cuenta> cuenta = new Vector<Cuenta>();
			while (result.hasNext())
				cuenta.add((Cuenta) result.next());
			return cuenta;
		} finally {
			// db.close();
		}

	}



}
