public class GameBoard {
    int rows = 10;
    int cols = 10;
    char[][] board = new char[rows][cols];
    boolean[][] walls = new boolean[rows][cols];

    public GameBoard() {
        initializeBoard();
    }

    public void addWall(int x, int y) {
        if (x >= 0 && x < rows && y >= 0 && y < cols) {
            walls[x][y] = true;
        }
    }

    public void initializeBoard() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                board[i][j] = walls[i][j] ? '#' : '.';
            }
        }
    }

    public void updateCell(int x, int y, char value) {
        board[x][y] = value;
    }

    public void printBoard() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean isValid(int x, int y) {
        return x >= 0 && x < rows && y >= 0 && y < cols && !walls[x][y];
    }
}
