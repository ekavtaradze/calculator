import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Calculator {

    /**
     * This function formats the output float of the calculator.
     * If input float has no decimals, returns no decimals;
     * If input float has decimals, returns decimals;
     *
     * @param output the output float of the calculator
     * @return output formatted as String
     */
    // O N?
    static String formatOutput(double output) {
        DecimalFormat format = new DecimalFormat("#.#####");
        format.setRoundingMode(RoundingMode.CEILING);
        return format.format(output);
    }

    /**
     * Entry-point function for Calculator. This function takes the initial equation, trims spaces,
     * checks validity of the input, delegates the evaluation of the equation, and returns
     * the answer.
     *
     * @param equation the initial equation
     * @return the answer of the specified equation
     */
    static String calculate(String equation) {
        equation = equation.replace(" ", "");
        if (Validator.checkValidity(equation)) {
            if (Validator.checkSyntax(equation)) {
                try {
                    double ans = EquationSplitter.splitAndCalculateParenthesis(equation);
                    return formatOutput(ans);
                } catch (Exception e) {
                    return e.getMessage();
                }
            } else return "Syntax Error";
        } else return "Invalid Input";
    }
}
