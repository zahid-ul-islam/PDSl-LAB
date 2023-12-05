import java.rmi.Remote;
import java.rmi.RemoteException;

public interface TrigonometricService extends Remote {
    double sin(double angle) throws RemoteException;
    double cos(double angle) throws RemoteException;
    double tan(double angle) throws RemoteException;
}

