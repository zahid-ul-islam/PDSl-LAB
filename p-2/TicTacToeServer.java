import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class TicTacToeServer {
    public static void main(String[] args) {
        try {
            // Create the TicTacToe implementation
            TicTacToe ticTacToe = new TicTacToeImpl() {
                @Override
                public String getCurrentPlayer() {
                    return null;
                }
            };

            // Start the RMI registry on port 1099
            LocateRegistry.createRegistry(1099);

            // Bind the TicTacToe implementation to the registry
            Naming.rebind("TicTacToeService", ticTacToe);

            System.out.println("Tic Tac Toe server is ready.");
        } catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
