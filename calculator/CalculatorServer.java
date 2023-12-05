import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class CalculatorServer {
    public static void main(String[] args) {
        try {
            // Create the calculator implementation
            Calculator calculator = new CalculatorImpl();

            // Start the RMI registry on port 1099
            LocateRegistry.createRegistry(1099);

            // Bind the calculator implementation to the registry
            Naming.rebind("CalculatorService", calculator);

            System.out.println("Calculator server is ready.");
        } catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
