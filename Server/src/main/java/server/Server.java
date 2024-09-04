package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;
import thread.ServerThread;

/**
 *
 * @author Radin
 */
public class Server extends Thread{
    private List<ServerThread> threads = new ArrayList<>();
    private ServerSocket serverSocket;
    
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
    
    
    public void stopServer() throws IOException{
        serverSocket.close();
        for(ServerThread thread:threads){
            thread.close();
        }
        interrupt();
    }
    
    
    
    
}

