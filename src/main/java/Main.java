import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
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
