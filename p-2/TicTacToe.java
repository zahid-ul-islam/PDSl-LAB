import java.rmi.Remote;
import java.rmi.RemoteException;

public interface TicTacToe extends Remote {
    String displayBoard() throws RemoteException;
    String makeMove(int position) throws RemoteException;

    String getCurrentPlayer();
}
