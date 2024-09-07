package communication;

import java.io.Serializable;

/**
 * Predstavlja odgovor kao rezultat izvršavanja određene operacije u aplikaciji.
 * 
 * Može sadržati podatke o rezultatu operacije i eventualnom izuzetku koji se desio tokom izvršavanja operacije.
 * 
 * @author Radin
 */
public class Response implements Serializable{
	/**
     * Izuzetak koji se dogodio tokom izvršavanja operacije.
     */
    Exception exception;
    /**
     * Objekat koji predstavlja rezultat izvršavanja operacije.
     */
    Object result;

    /**
     * Prazan konstruktor za kreiranje instance odgovora sa podrazumevanim vrednostima.
     */
    public Response() {
    }

    /**
     * Parametrizovani konstruktor za kreiranje instance odgovora sa definisanim izuzetkom i rezultatom operacije.
     * 
     * @param exception - Izuzetak koji se dogodio prilikom izvršavanja operacije.
     * @param result - Rezultat izvršavanja operacije.
     */
    public Response(Exception exception, Object result) {
        this.exception = exception;
        this.result = result;
    }

    /**
     * Vraća izuzetak koji se dogodio prilikom izvršavanja operacije.
     * 
     * @return exception - Izuzetak sadržan u odgovoru.
     */
    public Exception getException() {
        return exception;
    }

    /**
     * Postavlja novu vrednost za atribut exception.
     * 
     * @param exception - Novi izuzetak koji se postavlja u odgovoru.
     */
    public void setException(Exception exception) {
        this.exception = exception;
    }

    /**
     * Vraća rezultat izvršavanja operacije.
     * 
     * @return result - Rezultat operacije sadržan u odgovoru.
     */
    public Object getResult() {
        return result;
    }

    /**
     * Postavlja novu vrednost za rezultat operacije.
     * 
     * @param result - Novi rezultat koji se postavlja u odgovoru.
     */
    public void setResult(Object result) {
        this.result = result;
    }
}