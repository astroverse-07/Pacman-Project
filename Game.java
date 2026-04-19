import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {

        GameBoard board = new GameBoard();
        Pacman pacman = new Pacman(0, 0);
        Ghost ghost = new Ghost(5, 5);

        ArrayList<Food> foods = new ArrayList<>();

        //add food
        foods.add(new Food(2, 2));
        foods.add(new Food(3, 7));
        foods.add(new Food(8, 1));

        Scanner sc = new Scanner(System.in);
        int score = 0;

        while (true) {

            board.initializeBoard();

            // place food
            for (Food f : foods) {
                if (!f.eaten) {
                    board.updateCell(f.x, f.y, 'F');
                }
            }

            board.updateCell(pacman.x, pacman.y, 'P');
            board.updateCell(ghost.x, ghost.y, 'G');

            board.printBoard();

            //check collision ghost
            if (pacman.x == ghost.x && pacman.y == ghost.y) {
                System.out.println("Game Over! Ghost caught Pacman.");
                break;
            }

            //Check food
            for (Food f : foods) {
                if (!f.eaten && f.x == pacman.x && f.y == pacman.y) {
                    f.eaten = true;
                    score++;
                }
            }

            if (score == foods.size()) {
                System.out.println("You Win! All food collected.");
                break;
            }

            System.out.print("Move (WASD): ");
            char move = sc.next().charAt(0);

            pacman.move(move, board);
            ghost.move(board);

            System.out.println("Score: " + score);
            System.out.println("-------------------");
        }

        sc.close();
    }
}
