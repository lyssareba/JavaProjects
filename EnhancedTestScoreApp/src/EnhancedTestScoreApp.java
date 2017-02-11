import java.text.NumberFormat;
import java.util.Scanner;

public class EnhancedTestScoreApp
{
    public static void main(String[] args)
    {
        // display operational messages
        System.out.println("Please enter test scores that range from 0 to 100.");
        System.out.println("To end the program enter 999.");
        System.out.println();  // print a blank line

        // initialize variables and create a Scanner object
        int scoreTotal = 0;
        int scoreCount = 0;
        int testScore = 0;
        int minScore = 100;
        int maxScore = 0;
        NumberFormat number=NumberFormat.getNumberInstance();
        number.setMaximumFractionDigits(1);
        Scanner sc = new Scanner(System.in);

        // get a series of test scores from the user
        while (testScore != 999)
        {
            // get the input from the user
            System.out.print("Enter score: ");
            testScore = sc.nextInt();

            // accumulate score count and score total
            if (testScore <= 100)
            {
                scoreCount += 1;
                scoreTotal += testScore;
                minScore = Math.min(minScore, testScore);
                maxScore = Math.max(maxScore, testScore);
                        
            }
            else if (testScore != 999)
                System.out.println("Invalid entry, not counted");
        }

        // display the score count, score total, and average score
        double averageScore = (double) scoreTotal / (double) scoreCount;
        String message = "\n" +
                         "Score count:   " + scoreCount + "\n"
                       + "Score total:   " + scoreTotal + "\n"
                       + "Average score: " + number.format(averageScore) + "\n"
                       + "Minimum score: " + minScore + "\n"
                       + "Maximum score: " + maxScore + "\n";
        System.out.println(message);
    }
}