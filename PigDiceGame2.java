import java.util.Random;
import java.util.Scanner;

public class PigDiceGame2
{
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        Random generator = new Random();
        int playerScore = 0;
        int computerScore = 0;
        System.out.println("Pig! Get to 100 point first!");
        System.out.println();

        while(playerScore < 100 && computerScore < 100)
        {
            playerScore = playerTurn(playerScore, input);
            if(playerScore < 100)
            {
                computerScore = computerTurn(computerScore, generator);
            }
            System.out.println();
            System.out.println("SCOREBOARD -> You: " + playerScore + "  Computer: " + computerScore);
            System.out.println();
        }
        if(playerScore >= 100)
        {
            System.out.println("You win!");
        }
        else
        {
            System.out.println("The computer wins...");
        }
        input.close();
    }
    public static int playerTurn(int score, Scanner input)
    {
        boolean turnOver = false;
        int turnPoints = 0;
        System.out.println("--- It's your turn! ---");
        while(!turnOver)
        {
            Die die1 = new Die();
            Die die2 = new Die();
            int value1 = die1.getValue();
            int value2 = die2.getValue();
            System.out.println("Rolled: " + value1 + " and " + value2 + ".");

            if(value1 == 1 && value2 == 1)
            {
                score = 0;
                System.out.println("Snake eyes! You are reset to 0.");
                turnOver = true;
            }
            else if(value1 == 1 || value2 == 1)
            {
                score = score - turnPoints;
                System.out.println("Rolled a 1. You lose the " + turnPoints + " points from this turn. Score: " + score + ".");
                turnOver = true;
            }
            else
            {
                turnPoints = turnPoints + value1 + value2;

                score = score + value1 + value2;
            
                System.out.println("New score: " + score + ".");
                if(score >= 100)
                {
                    turnOver = true;
                }
                else
                {
                    System.out.print("Roll again? (Yes/No) >> ");
                    String choice = input.next();
                    if(!choice.equalsIgnoreCase("Yes"))
                    {
                        turnOver = true;
                    }
                }
            }
        }
        return score;
    } 
    public static int computerTurn(int score, Random generator)
    {
        boolean turnOver = false;
        int turnPoints = 0;
        System.out.println("--- It's the computer's turn! ---");
        while(!turnOver)
        {
            Die die1 = new Die();
            Die die2 = new Die();
            int value1 = die1.getValue();
            int value2 = die2.getValue();
            System.out.println("Computer rolled: " + value1 + " and " + value2 + ".");

            if(value1 == 1 && value2 == 1)
            {
                score = 0;
                System.out.println("Snake eyes! Computer's score is reset to 0.");
                turnOver = true;
            }
            else if(value1 == 1 || value2 == 1)
            {
                score = score - turnPoints;
                System.out.println("Computer rolled a 1 and lost the " + turnPoints + " points from this turn. Computer's score: " + score + ".");
                turnOver = true;
            }
            else
            {
                turnPoints = turnPoints + value1 + value2;
            
                score = score + value1 + value2;
                System.out.println("Computer's New Score: " + score + ".");
                if(score >= 100)
                {
                    turnOver = true;
                }
                else
                {
                    double decision = generator.nextDouble();
                    if(decision >= 0.5)
                    {
                        System.out.println("Computer rolls again!");
                    }
                    else
                    {
                        System.out.println("Computer passes turn.");
                        turnOver = true;
                    }
                }
            }
        }
        return score;
}
}
