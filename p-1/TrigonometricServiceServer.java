import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class TrigonometricServiceServer {
    public static void main(String[] args) {
        try {
            TrigonometricService trigonometricService = new TrigonometricServiceImpl();

            // Change the port to 1098
            LocateRegistry.createRegistry(1098);

            // Bind the remote object to the registry
            String registryURL = "rmi://localhost:1098/TrigonometricService";
            Naming.rebind(registryURL, trigonometricService);

            System.out.println("TrigonometricServiceServer is ready to accept requests.");

            // Add a delay to allow the server to start before running the client
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

