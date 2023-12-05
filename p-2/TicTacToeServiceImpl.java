import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class TicTacToeServiceImpl extends UnicastRemoteObject implements TicTacToeService {
    private char[][] board;
    private String gameOver;
    boolean turn;

    protected TicTacToeServiceImpl() throws RemoteException {
        super();
        gameOver="running";
        board = new char[3][3];
        turn = false;
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                board[i][j]='.';
            }
        }
    }

    public boolean makeMove(int row, int col, char ps) throws RemoteException {
        if(row>2 || row<0 || col>2 || col<0)
            return false;
        if (gameOver.equals("running")==false || board[row][col] != '.') {
            return false; // Move not valid
        }
        board[row][col] = ps;
        boolean d1=true,d2=true,r=false,c=false,dot=false;
        for(int i=0; i<3; i++){
            boolean r1=true,c1=true;
            for(int j=0; j<3; j++){
                r1&=(board[i][j]==ps);
                c1&=(board[j][i]==ps);
                dot|=(board[i][j]==ps);
            }
            r|=r1; c|=c1;
            d1&=(board[i][i]==ps);
            d2&=(board[i][2-i]==ps);
        }
        if(!dot){
            gameOver="Draw";
            return true;
        }
        if(d1 || d2 || r || c)
            gameOver=(turn==false?"Winner: First":"Winner: Second");
        turn=(turn==false?true:false);
        return true; // Move successful
    }

    public char[][] getBoard() throws RemoteException {
        return board;
    }

    public String isGameOver() throws RemoteException {
        return gameOver;
    }
}
