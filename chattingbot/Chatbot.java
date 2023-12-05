import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Chatbot extends Remote {
    String getResponse(String message) throws RemoteException;
}
