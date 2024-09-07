package repository.db;

import repository.inter.Repository;

/**
 * Predstavlja interfejs za repositorijum sa bazom podataka, koji omogućava upravljanje transakcijama.
 * Ovaj interfejs dodaje metode za povezivanje, prekid veze, commit i rollback operacije na bazu podataka,
 * koristeći instancu DbConnection za upravljanje konekcijama.
 * 
 * @param <T> Tip podataka sa kojim repositorijum radi.
 * @author Radin
 */
public interface DbRepository<T> extends Repository<T>{
	/**
     * Povezuje se sa bazom podataka koristeći trenutnu instancu DbConnection.
     * Ako konekcija ne postoji ili je zatvorena, kreira novu konekciju.
     * 
     * @throws Exception Ako dođe do greške prilikom povezivanja sa bazom podataka.
     */
    default public void connect() throws Exception{
        DbConnection.getInstance().getConnection();
    }
    
    /**
     * Prekida vezu sa bazom podataka zatvaranjem trenutne konekcije.
     * 
     * @throws Exception Ako dođe do greške prilikom prekida veze sa bazom podataka.
     */
    default public void disconnect() throws Exception{
        DbConnection.getInstance().getConnection().close();
    }
    
    /**
     * Izvršava commit transakcije, potvrđujući prethodne promene u bazi podataka.
     * 
     * @throws Exception Ako dođe do greške prilikom commit-ovanja transakcije.
     */
    default public void commit() throws Exception{
        DbConnection.getInstance().getConnection().commit();
    }
    
    /**
     * Izvršava rollback transakcije, poništavajući prethodne promene u bazi podataka.
     * 
     * @throws Exception Ako dođe do greške prilikom rollback-ovanja transakcije.
     */
    default public void rollback() throws Exception{
        DbConnection.getInstance().getConnection().rollback();
    }
}
