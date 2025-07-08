import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rnd = new Random();
        boolean playAgain = true;

        while(playAgain){
            int die1 = rnd.nextInt(6) + 1;
            int die2 = rnd.nextInt(6) + 1;
            int sum = die1 + die2;
            System.out.println("\nYou rolled: " + die1 + " + " + die2 + " = " + sum);

            if (sum == 7 || sum == 11) {
                System.out.println("You rolled a natural. You win.");
            } else if (sum == 2 || sum == 3 || sum == 12) {
                System.out.println("Craps. You crapped out and lose.");
            } else {
                int point = sum;
                System.out.println("Your point is: " + point);
                boolean keepRolling = true;

                while (keepRolling) {
                    die1 = rnd.nextInt(6) + 1;
                    die2 = rnd.nextInt(6) + 1;
                    sum = die1 + die2;

                    System.out.println("Trying for point. You rolled: " + die1 + " + " + die2 + " = " + sum);

                    if (sum == point) {
                        System.out.println("You made the point. You win.");
                        keepRolling = false;
                    } else if (sum == 7) {
                        System.out.println("You rolled a 7. You lose.");
                        keepRolling = false;
                    }
                }
            }

            System.out.print("Do you want to play again? (y/n): ");
            String answer = input.nextLine().toLowerCase();
            if (!answer.equals("y")) {
                playAgain = false;
                System.out.println("Thanks for playing");
            }
        }
    }
}
