import java.util.Random;

public class Ghost {
    int x, y;
    Random rand = new Random();

    public Ghost(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void move(GameBoard board) {
        int dir = rand.nextInt(4);

        int newX = x;
        int newY = y;

        if (dir == 0) newX++;
        if (dir == 1) newX--;
        if (dir == 2) newY++;
        if (dir == 3) newY--;

        if (board.isValid(newX, newY)) {
            x = newX;
            y = newY;
        }
    }
}