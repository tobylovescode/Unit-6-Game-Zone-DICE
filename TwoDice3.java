import java.util.Scanner;
public class TwoDice3
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int chosen;
        int rolls = 0;
        boolean won = false;
        System.out.println("Two Dice Game!");
        System.out.println("Pick a number, and if it appears in three rolls of two dice, YOU WIN!!");
        System.out.print("Enter a number from 2 to 12 >> ");
        chosen = input.nextInt();

        while(chosen < 2 || chosen > 12)
        {
            System.out.println("Invalid number. You cannot get this with two dice. ");
            System.out.print("Enter a number from 2 to 12 >> ");
            chosen = input.nextInt();
        }
        System.out.println();

        while(rolls < 3 && !won)
        {
            rolls = rolls + 1;
            Die die1 = new Die();
            Die die2 = new Die();
            int total = die1.getValue() + die2.getValue();

            System.out.println("Roll " + rolls + ": " + die1.getValue() + " + " + die2.getValue() + " = " + total);
            
            if(total == chosen)
            {
                won = true;
            }
        }
        System.out.println();
        if(won)
        {
            System.out.println("You win! :D");
        }
        else
        {
            System.out.println("The computer wins... D:");
        }
        input.close();
    }
}