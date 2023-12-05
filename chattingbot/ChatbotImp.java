import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ChatbotImp extends UnicastRemoteObject implements Chatbot {
    protected ChatbotImp() throws RemoteException {
        super();
    }

    public String getResponse(String message) throws RemoteException {
        message = message.toLowerCase();
        if (message.equals("hello")) {
            return "hi";
        } 
        else if(message.equals("how are you")){
            return "As i'm bot , i'm always good";
        }
        else if(message.equals("whats my name?")){
            return "You are my boss, Fahim";
        }
        else {
            return "Sorry, I don't understand";
        }

    }
}
