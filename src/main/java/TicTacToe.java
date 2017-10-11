public class TicTacToe {
    private Character[][] board = {{'\0', '\0', '\0'}, {'\0', '\0', '\0'}, {'\0', '\0', '\0'}};

    public void play(int x, int y) {
        checkAxis(x);
        checkAxis(y);
        setBox(x, y);
    }

    private void checkAxis(int axis) {
        if (axis < 1 || axis > 3) {
            throw new RuntimeException("Pawn is outside the board");
        }
    }

    private void setBox(int x, int y) {
        if (board[x - 1][y - 1] != '\0') { //table fields are starting numeration from 0, so x,y coordinates must be decreased by 1
            throw new RuntimeException("Field is occupied");
        } else {
            board[x - 1][y - 1] = 'X';
        }
    }
}
