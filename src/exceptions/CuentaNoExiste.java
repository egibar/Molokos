package exceptions;

/**
 * Created by Asier on 14/05/2016.
 */
public class CuentaNoExiste extends Exception {

    public CuentaNoExiste(){super();}

    /**
     * La excepción salta si la cuenta no está en la base de datos
     * @param s
     */
    public CuentaNoExiste(String s){
        super(s);
    }
}