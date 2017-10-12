public class TicTacToe {
    private Character[][] board = {{'\0', '\0', '\0'}, {'\0', '\0', '\0'}, {'\0', '\0', '\0'}};
    private char lastPlayer = '\0';

    public String play(int x, int y) {
        checkAxis(x);
        checkAxis(y);
        lastPlayer = nextPlayer();
        setBox(x, y, lastPlayer);
        for (int index = 0; index < 3; index++) {
            if (board[0][index] == lastPlayer &&
                board[1][index] == lastPlayer &&
                board[2][index] == lastPlayer) {
                return "Wygrał " + lastPlayer;
            }
        }
        return "Brak zwycięzcy";
    }

    private void checkAxis(int axis) {
        if (axis < 1 || axis > 3) {
            throw new RuntimeException("Pawn is outside the board");
        }
    }

    private void setBox(int x, int y, char lastPlayer) {
        if (board[x - 1][y - 1] != '\0') { //table fields are starting numeration from 0, so x,y coordinates must be decreased by 1
            throw new RuntimeException("Field is occupied");
        } else {
            board[x - 1][y - 1] = lastPlayer;
        }
    }

    public char nextPlayer() {
        if (lastPlayer == 'X') {
            return 'O';
        }
        return 'X';
    }
}
