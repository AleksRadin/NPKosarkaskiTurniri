package communication;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.net.SocketException;

/**
 *
 * @author Radin
 */
public class Receiver {
    private Socket socket;
    private ObjectInputStream in;
    
    
    public Receiver(Socket socket) {
        this.socket = socket;
    }
    
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

    public void close() throws IOException {
        in.close();
    }
    
}