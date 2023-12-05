import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws Exception {
        Registry registry = LocateRegistry.getRegistry("localhost", 1099);
        
        Chatbot chatbot = (Chatbot) registry.lookup("chatbotService");

        Scanner sc = new Scanner(System.in);
        while (true) {
            String userInput = sc.nextLine();
            String response = chatbot.getResponse(userInput);
            
            System.out.println("Server response: " + response);

            if(userInput=="break")
                break;
        }
        sc.close();
    }
}
