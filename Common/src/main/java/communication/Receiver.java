package communication;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.net.SocketException;

/**
 * Predstavlja primaoca u komunikaciji između klijent i server aplikacije.
 * 
 * Sadrži podatak o soketu i ulaznom toku podataka koji služi za prijem objekata sa suprotne strane.
 * 
 * @author Radin
 */
public class Receiver {
	/**
	 * Soket koji se koristi za povezivanje primaoca u komunikaciji.
	 */
    private Socket socket;
    /**
     * Ulazni tok podataka za prijem objekata.
     */
    private ObjectInputStream in;
    
    /**
     * Konstruktor koji postavlja soket na odgovarajuću vrednost prilikom kreiranja objekta klase Receiver.
     * 
     * @param socket - Soket koji se koristi za povezivanje sa klijentom ili serverom.
     */
    public Receiver(Socket socket) {
        this.socket = socket;
    }
    
    /**
     * Prihvata objekat koji je poslat od strane pošiljaoca (klijenta ili servera).
     * 
     * @return Objekat koji je primljen putem komunikacije.
     * @throws Exception - Ukoliko dođe do greške pri prijemu objekta ili radu sa ulaznim tokom podataka.
     */
    public Object receive() throws Exception{
        try {
            in = new ObjectInputStream(socket.getInputStream());
            return in.readObject();
        } catch (SocketException ex) {
            throw ex;
        }catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception("Error sending object!\n" + ex.getMessage());
        }
    }

    /**
     * Zatvara ulazni tok podataka koji je korišćen za prijem objekata.
     * 
     * @throws IOException - Ukoliko dođe do greške pri zatvaranju ObjectInputStream-a.
     */
    public void close() throws IOException {
        in.close();
    }
    
}