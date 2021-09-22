import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello, This is Calculator");

        while(true){
            System.out.println();
            System.out.println("Please Enter your Equation :");
            String equation = scanner.next();
            if(equation.equals("^c") || equation.equals("^C") ){
                System.out.println("Bye!");
                scanner.close();
                return;
            }
            System.out.println("Just a second. Calculating...");
            System.out.println(">> "+Calculator.calculate(equation));
        }

    }
}
