import java.rmi.Naming;

public class CalculatorClient {
    public static void main(String[] args) {
        try {
            // Lookup the remote calculator object
            Calculator calculator = (Calculator) Naming.lookup("rmi://localhost/CalculatorService");

            // Use the calculator methods
            int resultAdd = calculator.add(5, 3);
            int resultSubtract = calculator.subtract(10, 4);
            int resultMultiply = calculator.multiply(6, 7);
            double resultDivide = calculator.divide(15.0, 3.0);

            // Display the results
            System.out.println("Addition: " + resultAdd);
            System.out.println("Subtraction: " + resultSubtract);
            System.out.println("Multiplication: " + resultMultiply);
            System.out.println("Division: " + resultDivide);

        } catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
