public class Calculator {

    /**
     * This function formats the output float of the calculator.
     * If input float has no decimals, returns no decimals;
     * If input float has decimals, returns decimals;
     *
     * @param output the output float of the calculator
     * @return output formatted as String
     */
    static String formatOutput(Float output) {
        if (output % 1 != 0)
            return String.format("%s", output);
        else
            return String.format("%.0f", output);
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
                float f = EquationSplitter.splitAndCalculateParenthesis(equation);
                return formatOutput(f);
            } else return "Syntax Error";
        } else return "Invalid Input";
    }
}
