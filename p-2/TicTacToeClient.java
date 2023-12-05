import java.rmi.Naming;
import java.util.Scanner;

public class TicTacToeClient {
    public static void main(String[] args) {
        try {
            // Lookup the remote TicTacToe object
            TicTacToe ticTacToe = (TicTacToe) Naming.lookup("rmi://localhost/TicTacToeService");

            // Create a simple console-based client
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println(ticTacToe.displayBoard());

                try {
                    System.out.print("Player " + ticTacToe.getCurrentPlayer() + ", enter your move (1-9): ");
                    int position = scanner.nextInt() - 1;
                    String result = ticTacToe.makeMove(position);
                    System.out.println(result);

                    if (result.contains("wins") || result.contains("draw")) {
                        break;
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input. Please enter a number between 1 and 9.");
                    scanner.nextLine(); // Consume the invalid input
                }
            }

            scanner.close();
        } catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
