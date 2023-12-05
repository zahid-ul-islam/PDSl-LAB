import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    public static void main(String[] args) throws Exception {
        Chatbot chatbot = new ChatbotImp();
        
        Registry registry = LocateRegistry.createRegistry(1099);
        registry.bind("chatbotService", chatbot);
        
        System.out.println("Server running...");
    }
}
