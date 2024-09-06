package main;

import form.FrmMain;

/**
 * Glavna klasa aplikacije koja označava početak izvršavanja aplikacije.
 * Sadrži metodu main koja pokreće glavnu formu aplikacije.
 * 
 * @author Radin
 * @since 1.0
 */
public class Main {
	
	/**
     * Ulazna tačka aplikacije koja inicijalizuje i prikazuje glavnu formu.
     * Ova metoda se pokreće kao prva u okviru aplikacije.
     * 
     * @param args Argumenti komandne linije (nije korišćeno u ovoj aplikaciji)
     */
    public static void main(String[] args) {
        new FrmMain().setVisible(true);
    }
}
