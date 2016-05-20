package businessLogic;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.db4o.ObjectSet;
import configuration.ConfigXML;
import dataAccess.DataAccess;

//import domain.Booking;
import domain.*;
import exceptions.BadDates;
import exceptions.OverlappingOfferExists;

//Service Implementation
@WebService(endpointInterface = "businessLogic.ApplicationFacadeInterfaceWS")
public class FacadeImplementationWS  implements ApplicationFacadeInterfaceWS {
	//private DataAccess dB4oManager=new DataAccess();
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */

	//Vector<Owner> owners;
	//Vector<RuralHouse> ruralHouses;
	//DataAccessInterface dB4oManager;
	DataAccess dB4oManager;
 

	public FacadeImplementationWS()  {
		
		System.out.println("Executing FacadeImplementationWS");
		ConfigXML c=ConfigXML.getInstance();
		try {
			dB4oManager = DataAccess.getInstance();
		}catch (com.db4o.ext.DatabaseFileLockedException e) {
			System.out.println("Error in FacadeImplementation: " + e.toString());
			throw e;
		} catch (Exception e) {
			System.out.println("Error in FacadeImplementation: " + e.toString());
		}

		/*
		if (c.getDataBaseOpenMode().equals("initialize") && (c.isDatabaseLocal())) {

			System.out.println("File deleted");
			new File(c.getDb4oFilename()).delete();
		}
		DataAccess dB4oManager=new DataAccess();
		if (c.getDataBaseOpenMode().equals("initialize")) {
			dB4oManager.initializeDB();
			//dB4oManager.openDB();
			}
		else {// check if it is opened
			 //Vector<Owner> owns=dataAccess.getOwners();
		}
		dB4oManager.close();


		*/
	}
	

	/**
	 * This method creates an offer with a house number, first day, last day and price
	 * 
	 * @param
	 *            , start day, last day and price
	 * @return the created offer, or null, or an exception
	 */
	/*public Offer createOffer(RuralHouse ruralHouse, Date firstDay, Date lastDay,
			float price) throws OverlappingOfferExists, BadDates {
		System.out.println("Executing createOffer");
		System.out.println(firstDay);
		System.out.println(lastDay);

		
		DataAccess dB4oManager=new DataAccess();
		Offer o=null;
		if (firstDay.compareTo(lastDay)>=0) throw new BadDates();
		
		boolean b = dB4oManager.existsOverlappingOffer(ruralHouse,firstDay,lastDay); // The ruralHouse object in the client may not be updated
		if (!b) o=dB4oManager.createOffer(ruralHouse,firstDay,lastDay,price);		

		dB4oManager.close();
		
		return o;
	}
 

	
		
	public Vector<RuralHouse> getAllRuralHouses()  {
		System.out.println("Start: getAllRuralHouses");

		DataAccess dB4oManager=new DataAccess();

		Vector<RuralHouse>  ruralHouses=dB4oManager.getAllRuralHouses();
		dB4oManager.close();
		System.out.println("End: getAllRuralHouses");

		return ruralHouses;

	}
	
	/**
	 * This method obtains the  offers of a ruralHouse in the provided dates 
	 * 
	 * @param ruralHouse, the ruralHouse to inspect 
	 * @param firstDay, first day in a period range 
	 * @param lastDay, last day in a period range
	 * @return the first offer that overlaps with those dates, or null if there is no overlapping offer
	 */

	/*@WebMethod public Vector<Offer> getOffers( RuralHouse rh, Date firstDay,  Date lastDay) {
		
		DataAccess dB4oManager=new DataAccess();
		Vector<Offer>  offers=new Vector<Offer>();
		  offers=dB4oManager.getOffers(rh,firstDay,lastDay);
		dB4oManager.close();

		return offers;
	}	*/
		
		
	
	public void close() {
		//DataAccess dB4oManager=new DataAccess();

		dB4oManager.close();

	}


	 public void initializeBD(){
		
		//DataAccess dB4oManager=new DataAccess();
		dB4oManager.initializeDB();
		dB4oManager.close();

	}
	/*
	public Sucursal GetSucursal(String direccion, Divisas divisa){
			System.out.println("Start: GetSucursal");

			DataAccess dB4oManager=new DataAccess();

			Sucursal s=dB4oManager.GetSucursal(direccion);
			dB4oManager.close();
			System.out.println("End: GetSucursal");

			return s;

		}

	public Cuenta GetCuenta(Cuenta bankAccount){
		System.out.println("Start: GetCuenta");

		DataAccess dB4oManager=new DataAccess();

		Cuenta c=dB4oManager.GetCuenta(numero);
		dB4oManager.close();
		System.out.println("End: GetCuenta");

		return c;

	}
	public Divisa GetDivisa(String divisa, Sucursal su){
		System.out.println("Start: GetCuenta");

		DataAccess dB4oManager=new DataAccess();

		Divisa c=dB4oManager.GetDivisa(divisa,su);
		dB4oManager.close();
		System.out.println("End: GetCuenta");

		return c;

	}
	public o CreateOperacion(){
		System.out.println("Start: GetCuenta");

		DataAccess dB4oManager=new DataAccess();

		Cuenta c=dB4oManager.GetCuenta(numero);
		dB4oManager.close();
		System.out.println("End: GetCuenta");

		return c;

	}
*/
	public void comprarDivisa(int N, String D, float cant) {
		//DataAccess dB4oManager = new DataAccess();
		Divisas div = dB4oManager.conseguirDivisa(D, null);
		if (div != null) {// falta sucursal----importante puede ser variable
			// global
			float auxD = div.getCantidad();

			if (auxD >= cant) {
				float cambio = div.getValor();
				String s = div.getSucursal();
				Sucursal su = dB4oManager.conseguirSucursal(s);

				float comision = su.getComision();

				float newCant = (cant * comision + cant) * cambio;

				Cuenta c = dB4oManager.conseguirCuenta(N);
				if (c != null) {
					float aux = c.getSaldo();

					if (aux >= newCant) {
						float saldo = aux - newCant;
						float newDivisas = auxD - cant;

						c.setSaldo(saldo);
						dB4oManager.ActualizarCuenta(c);

						div.setCantidad(newDivisas);
						dB4oManager.ActualizarSucursal(div);

						Date f = new Date();
						SimpleDateFormat faux = new SimpleDateFormat("dd-MM-yyyy");
						String fecha = faux.format(f);						Operacion op =dB4oManager.crearOp(fecha, "Compra", div.getMoneda(), cant, c.getNumero(), su.getDireccion());


						c.addOperacion(op);
						dB4oManager.ActualizarCuenta(c);
					}
				} else {
					System.out.print("error no cuenta");
				}
			} else {
				System.out.print("error no divisa con esas caracteristicas");
			}
		}
	//	dB4oManager.close();
	}


	public void hacerTransferencia(int c1, int cuentadestino, float cant) {
	//	DataAccess dB4oManager = new DataAccess();

				Cuenta c = dB4oManager.conseguirCuenta(cuentadestino);
				Cuenta cuentaorigen = dB4oManager.conseguirCuenta(c1);
				if (c != null) {
					float aux = cuentaorigen.getSaldo();
					float aux2 = c.getSaldo();

					if (aux >= cant) {

						float saldo = aux - cant;
						c.setSaldo(aux+cant);
						cuentaorigen.setSaldo(saldo);
						dB4oManager.ActualizarCuenta(c);
						dB4oManager.ActualizarCuenta(cuentaorigen);
;
						Date f = new Date();
						SimpleDateFormat faux = new SimpleDateFormat("dd-MM-yyyy");
						String fecha = faux.format(f);
						Transferencia trans =dB4oManager.crearTrans(fecha,cuentaorigen.getNumero(),c.getNumero(),cant);

						c.addTransferencia(trans);
						cuentaorigen.addTransferencia(trans);
						cuentaorigen.addTransferencia(trans);
						dB4oManager.ActualizarCuenta(c);
						dB4oManager.ActualizarCuenta(cuentaorigen);
					}
				} else {
					System.out.print("error no cuenta");
				}
	//	dB4oManager.close();
			}

	public Vector<Cuenta> GetCuentas(String DNI) {
		System.out.println("Start: GetCuenta");

	//	DataAccess dB4oManager = new DataAccess();
		Vector<Cuenta>  cuentas=new Vector<Cuenta>();
		cuentas = dB4oManager.GetCuenta(DNI);
	//	dB4oManager.close();
		System.out.println("End: GetCuenta");

		return cuentas;
	}
	//public void ObtenerListado (Date fecha){}
	public Vector<Transferencia> GetTransferencias(String fecha){
	//	DataAccess dB4oManager = new DataAccess();
		Vector<Transferencia>transferencias = new Vector<Transferencia>();
		transferencias= dB4oManager.GetTransferencias(fecha);
	//	dB4oManager.close();

		return transferencias;
	}

	public Vector<String> GetOperaciones(String su){

			//	DataAccess dB4oManager = new DataAccess();
		Sucursal s= dB4oManager.conseguirSucursal(su);
		Cuenta[]cuenta = s.getC();
		Vector<String> v = new Vector<String>();
		Date f = new Date();
		SimpleDateFormat faux = new SimpleDateFormat("dd-MM-yyyy");
		String fecha = faux.format(f);
		
		String[] f2 = fecha.split("-");
		f2[1] = "01";
		
		
		String m = f2[0]+ "-"+ f2[1] +"-"+ f2[2];
		
		for(int i=0; i < cuenta.length; i++) {
			for(Operacion op : cuenta[i].getOperacion()) {
				int a = m.compareTo(op.getFecha());
				int b = fecha.compareTo(op.getFecha());
				if(a <= 0 && b >= 0)
					v.addElement(op.toString());
			}
		}		
		dB4oManager.close();
		return v;
	  }
		

	}

