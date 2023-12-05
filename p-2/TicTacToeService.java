import java.rmi.Remote;
import java.rmi.RemoteException;

public interface TicTacToeService extends Remote {
    boolean makeMove(int row, int col, char playerSymbol) throws RemoteException;
    char[][] getBoard() throws RemoteException;
    String isGameOver() throws RemoteException;
}
