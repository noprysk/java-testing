package testing;

public class TicTacToe {

    private Integer[][] board = {{-1, -1, -1}, {-1, -1, -1}, {-1, -1, -1}};

    public void play(int x, int y) {
        if (x < 1 || x > 3) {
            throw new RuntimeException("X outside the board");
        }

        if (y < 1 || y > 3) {
            throw new RuntimeException("Y outside the board");
        }

        if (board[x-1][y-1] != -1){
            throw new RuntimeException("Y outside the board");
        } else {
            board[x-1][y-1] = 0;
        }
    }
}
