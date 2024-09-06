package communication;

import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;

/**
 * Predstavlja pošiljaoca u komunikaciji između klijenta i servera.
 * 
 * Sadrži podatak o soketu i izlaznom toku podataka koji se koristi za slanje podataka ka suprotnoj strani.
 * 
 * @author Radin
 */
public class Sender {
	/**
     * Soket koji se koristi za slanje podataka.
     */
    private Socket socket;

    /**
     * Konstruktor klase Sender koji inicijalizuje soket koji se koristi za slanje podataka.
     * 
     * @param socket - Soket koji se koristi za komunikaciju sa suprotne strane.
     */
    public Sender(Socket socket) {
        this.socket = socket;
    }
    
    /**
     * Šalje objekat ka suprotnoj strani (može biti klijent ili server).
     * 
     * @param object - Objekat koji se šalje preko soketa.
     * @throws Exception - Ako dođe do greške prilikom rada sa ObjectOutputStream-om ili generalne greške prilikom slanja objekta.
     */
    public void send(Object object) throws Exception{
        try {
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            out.writeObject(object);
            out.flush();
        } catch (SocketException ex) {
            throw ex;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception("Error sending object!\n" + ex.getMessage());
        }
    }
}