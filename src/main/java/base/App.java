  
/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solution
 *  Copyright 2021 Alice Yu
 */
package base;
import java.util.Scanner;

/*
Exercise 20 - Multistate Sales Tax Calculator
More complex programs may have decisions nested in other decisions, so that when one decision is made, additional decisions must be made.

Create a tax calculator that handles multiple states and multiple counties within each state. The program prompts the user for the order amount and the state where the order will be shipped.

Wisconsin residents must be changed 5% sales tax with an additional county-level charge. For Wisconsin residents, prompt for the county of residence.
For Eau Claire county residents, add an additional 0.005 tax.
For Dunn county residents, add an additional 0.004 tax.
Illinois residents must be charged 8% sales tax with no additional county-level charge.
All other states are not charged tax.
The program then displays the tax and the total for Wisconsin and Illinois residents but just the total for everyone else.

Example Output
What is the order amount? 10
What state do you live in? Wisconsin
What county do you live in? Dane
The tax is $0.50.
The total is $10.50.
Constraints
Ensure that all money is rounded up to the nearest cent.
Use a single output statement at the end of the program to display the program results.
Challenges
Add support for your state and county.
Allow the user to enter a state abbreviation and county name in upper, lower, or mixed case.
Allow the user to also enter the state’s full name in upper, lower, or mixed case.
Implement the program using data structures to avoid nested if statements.

 */

public class App {
    Scanner in = new Scanner(System.in);

    public static void main(String[] args)
    {
        App myApp = new App();

        double order = myApp.readInputDouble("What is the order amount? ");
        String state = myApp.readInputString("What is the state? ");
        String county = myApp.readInputString("What is the county? ");

        if (!state.equals("Wisconsin") && !state.equals("Illinois"))
        {
            String outputString = ("The total is $" + String.format("%.2f", order) + ".");
            myApp.printOutput(outputString);
        }

        if (state.equals("Wisconsin"))
        {
            double tax = order * 0.05;

            if (county.equals("Eau Claire"))
            {
                double additional = order * 0.005;
                tax += additional;
            }

            if (county.equals("Dunn"))
            {
                double additional = order * 0.004;
                tax += additional;
            }
            double total = tax + order;
            String outputString = ("The tax is $" + String.format("%.2f", tax) +
                    ".\nThe total is $" + String.format("%.2f", total) + ".");
            myApp.printOutput(outputString);
        }

        if (state.equals("Illinois"))
        {
            double tax = order * 0.08;
            double total = tax + order;
            String outputString = ("The tax is $" + String.format("%.2f", tax) +
                    ".\nThe total is $" + String.format("%.2f", total) + ".");
            myApp.printOutput(outputString);
        }
    }

    public double readInputDouble(String input)
    {
        System.out.print(input);
        String num = in.next();
        return Double.parseDouble(num);
    }

    public String readInputString(String input)
    {
        System.out.print(input);
        String string = in.next();
        return string;
    }

    public void printOutput(String input)
    {
        System.out.println(input);
    }
}