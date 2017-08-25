package testing;

public class TicTacToe {

    private static final int SIZE = 3;
    private char lastPlayer = '\0';
    private Character[][] board = {{'\0', '\0', '\0'}, {'\0', '\0', '\0'}, {'\0', '\0', '\0'}};

    public String play(int x, int y) {
        checkAxes(x);
        checkAxes(y);
        setBoardCell(x, y);

        if (isWin(x, y)) {
            return lastPlayer + " is the winner";
        } else if (isDraw()) {
            return "The result is draw";
        }

        return "No winner";
    }

    private void setBoardCell(int x, int y) {
        if (board[x-1][y-1] != '\0'){
            throw new RuntimeException("Board cell is occupied.");
        } else {
            lastPlayer = nextPlayer();
            board[x-1][y-1] = lastPlayer;
        }
    }

    private void checkAxes(int axe) {
        if (axe < 1 || axe > 3) {
            throw new RuntimeException("Axe is outside the board.");
        }
    }

    public char nextPlayer() {
        if (lastPlayer == 'X') {
            return 'O';
        }
        return 'X';
    }

    private boolean isWin(int x, int y) {
        int playerTotal = lastPlayer * 3;
        char horizontal, vertical, diagonal1, diagonal2;
        horizontal = vertical = diagonal1 = diagonal2 = '\0';

        for (int i = 0; i < SIZE; i++) {
            horizontal += board[i][y-1];
            vertical += board[x-1][i];
            diagonal1 += board[i][i];
            diagonal2 += board[i][SIZE - i -1];

            if (horizontal == playerTotal ||
                vertical == playerTotal ||
                diagonal1 == playerTotal ||
                diagonal2 == playerTotal) {

                return true;
            }
        }
        return false;
    }

    private boolean isDraw() {
        for (int x = 0; x < SIZE; x++) {
            for (int y = 0; y < SIZE; y++) {
                if (board[x][y] == '\0') {
                    return false;
                }
            }
        }
        return true;
    }
}
