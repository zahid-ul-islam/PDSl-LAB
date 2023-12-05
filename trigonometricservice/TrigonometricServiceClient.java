import java.rmi.Naming;

public class TrigonometricServiceClient {
    public static void main(String[] args) {
        try {
            // Change the port to 1098
            TrigonometricService trigonometricService = (TrigonometricService) Naming.lookup("rmi://localhost:1098/TrigonometricService");

            // Example usage
            double angle = Math.toRadians(45);
            System.out.println("sin(" + angle + ") = " + trigonometricService.sin(angle));
            System.out.println("cos(" + angle + ") = " + trigonometricService.cos(angle));
            System.out.println("tan(" + angle + ") = " + trigonometricService.tan(angle));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

