import java.rmi.Naming;

public class RMIClient {
    public static void main(String[] args) {
        try {
            // Lookup the remote service object
            RemoteService remoteService = (RemoteService) Naming.lookup("rmi://localhost/RemoteService");

            // Invoke remote methods
            System.out.println("Server response: " + remoteService.sayHello());
            System.out.println("Result of addition: " + remoteService.add(5, 3));
        } catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
