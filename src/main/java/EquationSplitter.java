import java.util.Stack;

class EquationSplitter {

    static String operators = "+-/*";

    /**
     * This function finds and calculates the multiplications and divisions in the equation
     *
     * @param equation the equation to be calculated
     * @return the answer of the input equation as float
     */
    static double splitMultDiv(String equation) {
        String firstPart = "";
        double secondPart = 0;
        for (int i = 1; i < equation.length(); i++) {
            char c = equation.charAt(i);
            if (c == '*' || c == '/') {
                firstPart = equation.substring(0, i);
                secondPart = splitMultDiv(equation.substring(i + 1));
                return Operations.prepOperation(firstPart, c, secondPart);
            }
        }
        return Float.parseFloat(equation);
    }

    /**
     * This function splits the input equation by + and - signs. From the split it gets smaller equations, and signs.
     * The smaller equations are delegated to splitMultDiv, returned floats(calculations) are then added up or
     * subtracted based on the signs remaining from original split.
     *
     * @param equation the equation to be calculated
     * @return the answer of the input equation as float
     */
    static double splitPlusMinus(String equation) {
        double firstPart = 0;
        double secondPart = 0;
        char c;
        for (int i = 1; i < equation.length(); i++) {
            c = equation.charAt(i);
            if (c == '+' || (c == '-' && operators.indexOf(equation.charAt(i - 1)) == -1)) {
                firstPart = splitMultDiv(equation.substring(0, i));
                secondPart = splitPlusMinus(equation.substring(i + 1));
                return Operations.prepOperation(firstPart, c, secondPart);
            }
        }
        return splitMultDiv(equation);
    }


    /**
     * This function splits the input equation by parenthesis. Keeps a stack to check the syntax validity
     * of parentheses
     *
     * @param equation the equation to be calculated
     * @return the answer of the input equation as float
     */
    static double splitAndCalculateParenthesis(String equation) throws Exception {
        Stack<Integer> stack = new Stack<>();

        char c;

        for (int i = 0; i < equation.length(); i++) {
            c = equation.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    throw new Exception("Syntax Error");
                } else {
                    int index = stack.peek();
                    stack.pop();
                    String firstPart = equation.substring(0,index);
                    double middle = splitPlusMinus(equation.substring(index+1, i));
                    String end = equation.substring(i+1);
                    equation = firstPart+middle+end;
                    i = index+1;
                }
            }

        }
        if (!stack.isEmpty()) {
            throw new Exception("Syntax Error");
        }
        return splitPlusMinus(equation);
    }
}

