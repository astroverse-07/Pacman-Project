public class Pacman {
    int x, y;

    public Pacman(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void move(char direction, GameBoard board) {
        int newX = x, newY = y;
        if (direction == 'w') newX--;
        if (direction == 's') newX++;
        if (direction == 'a') newY--;
        if (direction == 'd') newY++;

        if (board.isValid(newX, newY)) {
            x = newX;
            y = newY;
        }
    }
}
