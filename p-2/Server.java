import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    public static void main(String[] args) throws Exception {
        TicTacToeService gameService = new TicTacToeServiceImpl();
        
        Registry registry = LocateRegistry.createRegistry(1099);
        registry.bind("gameService", gameService);
        
        System.out.println("Server running...");
    }
}
