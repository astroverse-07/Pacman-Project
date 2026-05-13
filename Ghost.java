import java.util.Random;

public class Ghost {
    int x, y;
    Random rand = new Random();

    public Ghost(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // distance formula
    public int distanceTo(int px, int py) {
        return Math.abs(this.x - px) + Math.abs(this.y - py);
    }

    public void move(GameBoard board, int pacmanX, int pacmanY) {
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        int bestX = x, bestY = y;
        int bestDist = distanceTo(pacmanX, pacmanY);

        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            if (board.isValid(newX, newY)) {
                int dist = Math.abs(newX - pacmanX) + Math.abs(newY - pacmanY);
                if (dist < bestDist || (dist == bestDist && rand.nextBoolean())) {
                    bestDist = dist;
                    bestX = newX;
                    bestY = newY;
                }
            }
        }

        x = bestX;
        y = bestY;
    }
}
