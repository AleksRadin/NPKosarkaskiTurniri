package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;
import thread.ServerThread;

/**
 * Predstavlja server koji prihvata dolazne veze od klijenata i pokreće niti za obradu svake veze.
 * Server sluša na portu 9000 i upravlja radnim nitima koje komuniciraju sa povezanim klijentima.
 * 
 * @author Radin
 */
public class Server extends Thread{
	/**
     * Lista radnih niti koje obrađuju klijentske veze.
     */
    private List<ServerThread> threads = new ArrayList<>();
    /**
     * ServerSocket objekat koji se koristi za prihvatanje dolaznih veza.
     */
    private ServerSocket serverSocket;
    
    /**
     * Pokreće server koji sluša na portu 9000 i prihvata dolazne veze.
     * Svaka prihvaćena veza se obrađuje u novoj radnoj niti.
     * Server nastavlja sa radom dok se ne prekine ili dođe do greške.
     */
    public void run() {
        while (!isInterrupted()) {
            try {
                serverSocket = new ServerSocket(9000);
                while (!isInterrupted()) {
                    System.out.println("Waiting for connection...");
                    Socket socket = serverSocket.accept();
                    System.out.println("Connected!");
                    ServerThread serverThread = new ServerThread(socket);
                    threads.add(serverThread);
                    serverThread.start();
                }
            } catch (SocketException ex) {
                System.out.println(ex.getMessage());
                System.out.println("Server has stopped");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    
    /**
     * Zaustavlja rad servera, zatvara ServerSocket i prekida sve radne niti.
     * 
     * @throws IOException Ako dođe do greške prilikom zatvaranja ServerSocket objekta.
     */
    public void stopServer() throws IOException{
        serverSocket.close();
        for(ServerThread thread:threads){
            thread.close();
        }
        interrupt();
    }
    
    
    
    
}

