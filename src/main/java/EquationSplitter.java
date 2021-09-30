import java.util.Stack;

class EquationSplitter {
    /**
     * This function finds and calculates the multiplications and divisions in the equation
     *
     * @param equation the equation to be calculated
     * @return the answer of the input equation as float
     */
    static double splitMultDiv(String equation) {
        if (SplitterHelper.includesMultDiv(equation)) {
            int max = SplitterHelper.findMax();
            double firstPart = splitMultDiv(equation.substring(0, max));
            String secondPart = equation.substring(max + 1);
            return Operations.doMultDiv(firstPart, equation.charAt(max), secondPart);
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
    private static double splitPlusMinus(String equation) {
        if (SplitterHelper.includesPlusMinus(equation)) {
            int min = SplitterHelper.findMin();
            double firstPart = splitMultDiv(equation.substring(0, min));
            double secondPart = splitPlusMinus(equation.substring(min + 1));
            return Operations.doAddSub(firstPart, equation.charAt(min), secondPart);
        }
        //if no + or -
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
                    String firstPart = equation.substring(0, index);
                    double middle = splitPlusMinus(equation.substring(index + 1, i));
                    String end = equation.substring(i + 1);
                    equation = firstPart + middle + end;
                    i = index + 1;
                }
            }

        }
        if (!stack.isEmpty()) {
            throw new Exception("Syntax Error");
        }
        return splitPlusMinus(equation);
    }
}

