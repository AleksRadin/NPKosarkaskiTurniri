package abst.operation;

import repository.db.DbRepository;
import repository.db.impl.RepositoryDBGeneric;
import repository.inter.Repository;

/**
 * Predstavlja opštu operaciju u aplikaciji koja obezbeđuje strukturu za rad sa transakcijama i bazom podataka.
 * Sve specifične operacije treba da nasleđuju ovu klasu i implementiraju neophodne metode.
 * 
 * @author Radin
 */
public abstract class GenericOperation {
    
	/**
     * Repozitorijum koji se koristi za interakciju sa bazom podataka.
     * Inicijalizuje se kao instanca klase RepositoryDBGeneric.
     */
    protected final Repository repository;

    /**
     * Inicijalizuje polje repository na novu instancu klase RepositoryDBGeneric.
     */
    public GenericOperation() {
        this.repository = new RepositoryDBGeneric();
    }
    
    /**
     * Izvršava operaciju. Ova metoda prati sledeći tok:
     * proverava preduslove, započinje transakciju, izvršava operaciju, 
     * potvrđuje transakciju, ili vraća transakciju u slučaju greške, 
     * i na kraju zatvara vezu sa bazom.
     * 
     * @param param - Objekat od značaja za izvršenje operacije.
     * @throws Exception - U slučaju greške tokom izvršavanja operacije ili provere preduslova.
     */
    public final void execute(Object param) throws Exception {
        try {
            preconditions(param);
            startTransaction();
            executeOperation(param);
            commitTransaction();
        } catch (Exception ex) {
            ex.printStackTrace();
            rollbackTransaction();
            throw ex;
        } finally {
            disconnect();
        }
    }

    /**
     * Proverava preduslove za izvršavanje operacije.
     * Ovu metodu treba da implementiraju sve specifične operacije.
     * 
     * @param param - Objekat od značaja za proveru preduslova.
     * @throws Exception - U slučaju greške tokom provere preduslova.
     */
    protected abstract void preconditions(Object param) throws Exception;

    /**
     * Pokreće transakciju pozivanjem metode connect() iz repozitorijuma.
     * 
     * @throws Exception - U slučaju greške prilikom uspostavljanja konekcije sa bazom.
     */
    private void startTransaction() throws Exception {
        ((DbRepository) repository).connect();
    }

    /**
     * Izvršava specifičnu operaciju. Ovu metodu treba da implementiraju sve specifične operacije.
     * 
     * @param param - Objekat od značaja za izvršenje operacije.
     * @throws Exception - U slučaju greške tokom izvršavanja operacije.
     */
    protected abstract void executeOperation(Object param) throws Exception;

    /**
     * Potvrđuje transakciju pozivanjem metode commit() iz repozitorijuma.
     * 
     * @throws Exception - U slučaju greške tokom commit-ovanja transakcije.
     */
    private void commitTransaction() throws Exception {
        ((DbRepository) repository).commit();
    }

    /**
     * Vraća transakciju pozivanjem metode rollback() iz repozitorijuma.
     * 
     * @throws Exception - U slučaju greške tokom vraćanja transakcije.
     */
    private void rollbackTransaction() throws Exception {
        ((DbRepository) repository).rollback();
    }

    /**
     * Zatvara vezu sa bazom podataka pozivanjem metode disconnect() iz repozitorijuma.
     * 
     * @throws Exception - U slučaju greške tokom prekidanja veze sa bazom.
     */
    private void disconnect() throws Exception {
        ((DbRepository) repository).disconnect();
    }
    
    
}
