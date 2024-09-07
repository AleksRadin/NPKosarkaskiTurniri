package communication;

import java.io.Serializable;

/**
 * Predstavlja zahtev koji se koristi za slanje određene operacije i odgovarajućeg argumenta.
 * 
 * Sadrži operaciju koju treba izvršiti i argument koji se prosleđuje pri izvršavanju te operacije.
 * Klasa implementira Serializable interfejs kako bi omogućila serijalizaciju objekata tipa Request.
 * 
 * @author Radin
 */
public class Request implements Serializable{
	/**
     * Operacija koju treba izvršiti.
     */
    Operation operation;
    /**
     * Argument nad kojim će se raditi u okviru operacije.
     */
    Object argument;

    /**
     * Parametrizovani konstruktor klase Request.
     * 
     * Kreira novi objekat klase Request sa prosleđenom operacijom i argumentom.
     * 
     * @param operation - Operacija koja se treba izvršiti.
     * @param argument - Argument koji se prosleđuje pri izvršavanju operacije.
     */
    public Request(Operation operation, Object argument) {
        this.operation = operation;
        this.argument = argument;
    }

    /**
     * Vraća operaciju specifičnu za ovaj zahtev.
     * 
     * @return operation - Operacija vezana za konkretan zahtev.
     */
    public Operation getOperation() {
        return operation;
    }

    /**
     * Postavlja novu vrednost za operaciju.
     * 
     * @param operation - Nova operacija koju treba izvršiti.
     */
    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    /**
     * Vraća argument koji se prosleđuje u okviru zahteva.
     * 
     * @return argument - Argument koji je prosleđen uz zahtev.
     */
    public Object getArgument() {
        return argument;
    }

    /**
     * Postavlja novu vrednost za argument zahteva.
     * 
     * @param argument - Novi argument koji će biti prosleđen uz zahtev.
     */
    public void setArgument(Object argument) {
        this.argument = argument;
    }
}