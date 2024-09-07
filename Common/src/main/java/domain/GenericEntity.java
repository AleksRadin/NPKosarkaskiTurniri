package domain;

import java.io.Serializable;

/**
 * Predstavlja generički entitet koji omogućava rad sa podacima u bazi, uključujući operacije dodavanja, prikazivanja, izmene i brisanja.
 * Ovaj interfejs definiše metode koje omogućavaju povratak informacija o tabeli, kolonama, vrednostima i uslovima koji su potrebni za SQL upite.
 * 
 * @author Radin
 */
public interface GenericEntity extends Serializable{
	 /**
     * Vraća naziv tabele u bazi podataka koja odgovara ovom entitetu.
     * 
     * @return tableName - Naziv tabele kao String.
     */
    String getTableName();

    /**
     * Vraća nazive kolona koje će biti korišćene za dodavanje novog entiteta u bazu podataka.
     * 
     * @return columnNamesInsert - String koji sadrži nazive kolona odvojene zarezima, koji su potrebni za INSERT upit.
     */
    String getColumnNamesForInsert();
    
    /**
     * Vraća nazive kolona koje će biti korišćene za prikaz entiteta iz baze podataka.
     * 
     * @return columnNamesSelect - Niz String vrednosti koje predstavljaju nazive kolona za SELECT upit.
     */
    String[] getColumnNamesForSelect();

    /**
     * Vraća vrednosti atributa entiteta koje se koriste za INSERT upit u bazu podataka.
     * 
     * @return insertValues - String koji sadrži vrednosti atributa, koje su obuhvaćene navodnicima kada je to potrebno.
     */
    String getInsertValues();
    
    /**
     * Vraća nazive metoda koji se koriste za rad sa ResultSet-om prilikom dobijanja podataka iz baze.
     * 
     * @return resultSetMethods - Niz String vrednosti koje predstavljaju nazive metoda za rad sa ResultSet-om.
     */
    String[] getResultSetMethods();
    /**
     * Vraća vrednosti atributa entiteta koje se koriste za UPDATE upit u bazi podataka.
     * 
     * @return updateValues - String koji sadrži vrednosti atributa za UPDATE upit, obuhvaćene navodnicima gde je potrebno.
     */
    String getUpdateValues();
    /**
     * Vraća WHERE deo SQL upita koji se koristi za brisanje podataka iz baze.
     * 
     * @return whereCondition - String koji predstavlja WHERE uslov za DELETE upit.
     */
    String getWhereCondition();
    /**
     * Vraća WHERE deo SQL upita koji se koristi za izmenu podataka u bazi.
     * 
     * @return whereConditionEditOperation - String koji predstavlja WHERE uslov za UPDATE upit.
     */
    String getWhereConditionEditOperation();
    /**
     * Postavlja novu vrednost za ID atribut entiteta.
     * 
     * @param id - Nova ID vrednost kao Long, koja se postavlja za atribut ID.
     * 
     * @throws NullPointerException - Ako je uneta null vrednost za ID.
     * @throws IllegalArgumentException - Ako je ID vrednost manja od 1.
     */
    void setId(Long id);
}