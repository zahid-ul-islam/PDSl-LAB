import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class RMIServer {
    public static void main(String[] args) {
        try {
            // Create the remote service implementation
            RemoteService remoteService = new RemoteServiceImpl();

            // Start the RMI registry on port 1099
            LocateRegistry.createRegistry(1099);

            // Bind the remote service implementation to the registry
            Naming.rebind("RemoteService", remoteService);

            System.out.println("Remote service server is ready.");
        } catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
