package repository.inter;

import java.util.List;

/**
 * Interfejs koji definiše osnovne operacije za rad sa repozitorijumom podataka.
 * Ovaj interfejs pruža metode za osnovne CRUD (Create, Read, Update, Delete) operacije.
 * 
 * @param <T> Tip podataka koji se koristi za rad sa repozitorijumom. 
 * @author Radin
 */
public interface Repository<T> {
	/**
     * Dohvata sve entitete koji odgovaraju specificiranom parametru.
     * 
     * @param param Parametar koji se koristi za filtriranje ili specifičnu pretragu entiteta.
     * @return Lista svih entiteta koji odgovaraju parametru.
     * @throws Exception Ako dođe do greške prilikom izvršavanja upita ili obrade podataka.
     */
    List<T> getAll(T param) throws Exception;
    /**
     * Dodaje novi entitet u repozitorijum.
     * 
     * @param param Entitet koji se dodaje u repozitorijum.
     * @throws Exception Ako dođe do greške prilikom dodavanja entiteta.
     */
    void add(T param) throws Exception;
    /**
     * Ažurira postojeći entitet u repozitorijumu.
     * 
     * @param param Entitet sa ažuriranim vrednostima i eventualnim uslovom za izmenu.
     * @throws Exception Ako dođe do greške prilikom ažuriranja entiteta.
     */
    void edit(T param) throws Exception;
    /**
     * Briše entitet iz repozitorijuma.
     * 
     * @param param Entitet koji se briše i eventualni uslov za brisanje.
     * @throws Exception Ako dođe do greške prilikom brisanja entiteta.
     */
    void delete(T param)throws Exception;
}