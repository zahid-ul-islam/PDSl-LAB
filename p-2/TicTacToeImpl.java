import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public abstract class TicTacToeImpl extends UnicastRemoteObject implements TicTacToe {
    private char[] board;
    private char currentPlayer;

    public TicTacToeImpl() throws RemoteException {
        super();
        board = new char[9];
        currentPlayer = 'X';
    }

    @Override
    public String displayBoard() throws RemoteException {
        StringBuilder boardStr = new StringBuilder("\n");
        for (int i = 0; i < 9; i += 3) {
            boardStr.append(board[i]).append(" | ").append(board[i + 1]).append(" | ").append(board[i + 2]).append("\n");
            if (i < 6) {
                boardStr.append("---------\n");
            }
        }
        return boardStr.toString();
    }

    @Override
    public String makeMove(int position) throws RemoteException {
        if (board[position] == 0) {
            board[position] = currentPlayer;
            if (checkWinner()) {
                return "Player " + currentPlayer + " wins!\n";
            } else if (isBoardFull()) {
                return "It's a draw!\n";
            } else {
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                return displayBoard();
            }
        } else {
            return "Invalid move. Try again.\n";
        }
    }

    private boolean checkWinner() {
        // Check rows, columns, and diagonals for a win
        return checkLine(0, 1, 2) || checkLine(3, 4, 5) || checkLine(6, 7, 8) ||
                checkLine(0, 3, 6) || checkLine(1, 4, 7) || checkLine(2, 5, 8) ||
                checkLine(0, 4, 8) || checkLine(2, 4, 6);
    }

    private boolean checkLine(int a, int b, int c) {
        return board[a] != 0 && board[a] == board[b] && board[a] == board[c];
    }

    private boolean isBoardFull() {
        for (char cell : board) {
            if (cell == 0) {
                return false;
            }
        }
        return true;
    }
}
