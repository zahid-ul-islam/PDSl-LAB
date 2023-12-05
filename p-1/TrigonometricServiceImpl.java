import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class TrigonometricServiceImpl extends UnicastRemoteObject implements TrigonometricService {
    public TrigonometricServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public double sin(double angle) throws RemoteException {
        return Math.sin(angle);
    }

    @Override
    public double cos(double angle) throws RemoteException {
        return Math.cos(angle);
    }

    @Override
    public double tan(double angle) throws RemoteException {
        return Math.tan(angle);
    }
}

