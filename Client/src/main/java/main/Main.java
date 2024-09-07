package main;

import form.FrmLogin;

/**
 * Glavna klasa aplikacije koja sadrži metodu main.
 * Ova klasa označava početak izvršavanja aplikacije i prikazuje formu za prijavu korisnika.
 * 
 * @author Radin
 */
public class Main {
	/**
     * Glavna metoda koja se pokreće prva kada se aplikacija pokrene.
     * Ova metoda kreira instancu forme za prijavu i postavlja je kao vidljivu.
     * 
     * @param args Argumenti komandne linije (ne koriste se u ovoj aplikaciji)
     */
    public static void main(String[] args) {
        new FrmLogin().setVisible(true);
    }
}