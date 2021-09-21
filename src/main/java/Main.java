import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //System.out.println(Calc.dealwithMinus("-3+4--3-4"));
        // create a scanner so we can read the command-line input
        Scanner scanner = new Scanner(System.in);

        //  prompt for the user's name
        System.out.println("Hello, This is Calculator");

        while(true){
            System.out.println();
            System.out.println("Please Enter your Equation :");
            String equation = scanner.next();
            System.out.println("Just a second. Calculating...");
            System.out.println("The answer is >> "+Calculator.calculate(equation));
        }
    }
}
