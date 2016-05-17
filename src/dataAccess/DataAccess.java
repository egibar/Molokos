package dataAccess;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ListIterator;
import java.util.Vector;

import javax.jws.WebMethod;
import javax.xml.crypto.Data;

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
import gui.ObtenerListado;

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
		Divisas d1=new Divisas(3, 100,"Dolar","Gros");
		Divisas d2=new Divisas(5, 300,"Libra","Gros");
		Divisas d3=new Divisas(1, 30000000,"Euro","Gros");
		Divisas[] daux = {d1, d2, d3};

		Date fecha = new Date();
		Operacion op1 = new Operacion(fecha,"Compra","Libra",1,1,"Gros");
		Vector<Operacion> v = new Vector<Operacion>();
		v.addElement(op1);

		Transferencia trans = new Transferencia(fecha,1,123,1);
		Vector<Transferencia> t = new Vector<Transferencia>();
		t.addElement(trans);

		Cuenta cuenta1= new Cuenta(1,9000,"72526101V",t,v);
		Cuenta cuenta2= new Cuenta(123,9000,"72526101V",t,v);
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


	public Vector<RuralHouse> getAllRuralHouses() {


		try {
			RuralHouse proto = new RuralHouse(null,null,null);
			ObjectSet<RuralHouse> result = db.queryByExample(proto);
			Vector<RuralHouse> ruralHouses=new Vector<RuralHouse>();
			while(result.hasNext())
				ruralHouses.add(result.next());
			return ruralHouses;
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

	////.--------------------------------------------------------------------------------------.///

	public Sucursal conseguirSucursal(String l) {
		Sucursal s = (Sucursal) db.queryByExample(new Sucursal(0,l, null, null)).next();
		return s;
	}

	public Divisas conseguirDivisa(String divisa, Sucursal s) {
		Divisas d = (Divisas) db.queryByExample(new Divisas(0, 0, divisa, "Gros")).next();
		if(d == null)
			System.out.print("La divisa no existe");
		return d;
	}

	public Divisas[] conseguirDivisaS(String d1, String d2, Sucursal s) {
		Divisas div = (Divisas) db.queryByExample(new Divisas(0, 0, d1,"Gros"));
		Divisas eur = (Divisas) db.queryByExample(new Divisas(0, 0, d2, "Gros"));
		Divisas[] result = {div, eur};
		if(result.length != 2)
			System.out.print("Alguna de las dos divisas no existe");

		return result;
	}

	public Cuenta conseguirCuenta(int numero) {
		Cuenta c = (Cuenta) db.queryByExample(new Cuenta(numero, 0, null, null, null)).next();
		if(c == null)
			System.out.print("No existe la cuenta");

		return c;
	}

	public void ActualizarSucursal(Divisas d) {
		db.store(d);
		db.commit();
	}

	public void ActualizarCuenta(Cuenta c) {
		db.store(c);
		db.commit();
	}

	public Operacion crearOp(Date f, String operacion, String moneda,float cant, int c,String su) {
//		Divisa d = new Divisa(moneda, 0, 0, s);
//		Divisa divisa = (Divisa) db.queryByExample(d);
		Operacion op = new Operacion(f, operacion, moneda, cant, c,su );

		db.store(op);
		db.commit();

		return op;
	}

	public Transferencia crearTrans(Date f,int cuentaorigen,int cuentadestino, float cant/*, Sucursal su*/) {
//		Divisa d = new Divisa(moneda, 0, 0, s);
//		Divisa divisa = (Divisa) db.queryByExample(d);
		Transferencia trans = new Transferencia(f,cuentaorigen, cuentadestino, cant/*, su*/);

		db.store(trans);
		db.commit();

		return trans;
	}

	public Vector<Cuenta> GetCuenta( String DNI) {
		try{
		Cuenta cuenta = new Cuenta(0,0,DNI,null,null);
		ObjectSet<Cuenta> result= db.queryByExample(cuenta);
		Vector<Cuenta> cuentas = new Vector<Cuenta>();
		while (result.hasNext())
			cuentas.add(result.next());

		return cuentas;
		}finally {

		}

	}

	public Vector<Cuenta> GetCuenta( Sucursal su) {
		try{
			Cuenta cuenta = new Cuenta(0,0,null,null,null);
			ObjectSet<Cuenta> result= db.queryByExample(cuenta);
			Vector<Cuenta> cuentas = new Vector<Cuenta>();
			while (result.hasNext())
				cuentas.add(result.next());

			return cuentas;
		}finally {

		}

	}


	public Vector<Transferencia> GetTransferencias(Date fecha){
		try{
			Transferencia transferencia = new Transferencia(fecha,0,0,0);
			ObjectSet<Transferencia> result = db.queryByExample(transferencia);
			Vector<Transferencia> transferencias = new Vector<Transferencia>();
			while (result.hasNext())
				transferencias.add(result.next());
			return transferencias;
		}
		finally {

		}
	}
	public Vector<Operacion> GetOperaciones(String su){
		try{
			Operacion operacion = new Operacion(null,null,null,0,0,null);
			ObjectSet<Operacion> result = db.queryByExample(operacion);
			Vector<Operacion> operaciones = new Vector<Operacion>();
			while (result.hasNext())
				operaciones.add(result.next());
			return operaciones;
		}
		finally {

		}
	}



}
