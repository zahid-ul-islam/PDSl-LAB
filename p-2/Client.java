import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws Exception {
        Registry registry = LocateRegistry.getRegistry("localhost", 1099);
        
        TicTacToeService gamService = (TicTacToeService) registry.lookup("gameService");
        
        System.out.println("Client is running:");

        Scanner sc = new Scanner(System.in);
        

        try {
            int move_count=0;
            System.out.println("Play with O and X");
            System.out.println("Introduce with row and col");
            for(int i=1; i<=3; i++){
                System.out.println("("+i+",1) ("+i+",2) ("+i+",3)");
            }
            while (move_count<9) {
                if(move_count%2==0){
                    System.out.println("First player turn (row col move): ");
                }
                else{
                    System.out.println("Second player turn (row col move): ");
                }
                int row = sc.nextInt();
                int col = sc.nextInt();
                char ch = sc.next().charAt(0);
                if(gamService.makeMove(row-1, col-1, ch)){
                    char board[][] = gamService.getBoard();
                    System.out.println("move done");
                    for(int i=0; i<3; i++){
                        for(int j=0; j<3; j++){
                            System.out.print(board[i][j]+"  ");
                        }
                        System.out.println();
                    }
                    move_count++;
                }
                else{
                    System.out.println("Invalid move");
                }
            }
            System.out.println(gamService.isGameOver());


        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Exception: "+e.getMessage());
        }

        sc.close();

    }
}
