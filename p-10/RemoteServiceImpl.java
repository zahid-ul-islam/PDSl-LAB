import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RemoteServiceImpl extends UnicastRemoteObject implements RemoteService {
    public RemoteServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public String sayHello() throws RemoteException {
        return "Hello from the remote server!";
    }

    @Override
    public int add(int a, int b) throws RemoteException {
        return a + b;
    }
}
