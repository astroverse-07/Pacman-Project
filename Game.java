import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {

        GameBoard board = new GameBoard();

        // add Walls
        board.addWall(3, 3);
        board.addWall(3, 4);
        board.addWall(3, 5);
        board.addWall(6, 1);
        board.addWall(6, 2);
        board.addWall(8,3);
        board.addWall(8,4);
        board.addWall(8,5);
        board.addWall(1,6);
        board.addWall(1,7);
        board.addWall(1,8);
        board.addWall(7,7);
        board.addWall(7,8);
        board.addWall(7,9);


        Pacman pacman = new Pacman(0, 0);
        Ghost ghost = new Ghost(5, 5);

        //add food
        ArrayList<Food> foods = new ArrayList<>();
        foods.add(new Food(2, 2));
        foods.add(new Food(4, 7));
        foods.add(new Food(8, 1));
        foods.add(new Food(9, 9));
        foods.add(new Food(6,5));
        foods.add(new Food(7,2));

        Scanner sc = new Scanner(System.in);
        int score = 0;

        System.out.println("--- PACMAN GAME START ---");

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
                System.out.println("GAME OVER! Ghost caught Pacman.");
                break;
            }

            //check food
            for (Food f : foods) {
                if (!f.eaten && f.x == pacman.x && f.y == pacman.y) {
                    f.eaten = true;
                    score++;
                    if (score == foods.size()) {
                        System.out.println("YOU WIN! All food collected.");
                        break;
                    }
                }
            }

            if (score == foods.size()) break;

            System.out.print("Move (W/A/S/D): ");
            char move = sc.next().toLowerCase().charAt(0);

            pacman.move(move, board);
            ghost.move(board, pacman.x, pacman.y);

            System.out.println("-------------------------");
        }

        System.out.println("Final Score: " + score);
        System.out.println("Thanks for playing!");
        sc.close();
    }
}
