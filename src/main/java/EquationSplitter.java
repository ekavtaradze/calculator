import java.util.Stack;

class EquationSplitter {


    /**
     * This function finds and calculates the multiplications and divisions in the equation
     *
     * @param equation the equation to be calculated
     * @return the answer of the input equation as float
     */
    static float splitMultDiv(String equation) {
        String firstPart = "";
        float secondPart = 0;
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
    static float splitPlusMinus(String equation) {
        float firstPart = 0;
        float secondPart = 0;
        char c;
        for (int i = 1; i < equation.length(); i++) {
            c = equation.charAt(i);
            if (c == '+' || c == '-') {
                firstPart = splitMultDiv(equation.substring(0, i));
                secondPart = splitPlusMinus(equation.substring(i + 1));
                return Operations.prepOperation(firstPart, c, secondPart);
            }
        }
        return splitMultDiv(equation);
    }


    static float splitAndCalculateParenthesis(String equation) {
        Stack<Parenthesis> stack = new Stack<>();
        char c;
        for (int i = 0; i < equation.length(); i++) {
            c = equation.charAt(i);
            if (c == '(') {
                Parenthesis p = new Parenthesis('(', i);
                stack.push(p);
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    //Syntax Error
                } else {
                    Parenthesis pop = stack.peek();
                    if (pop.value != '(') {
                        //error
                    } else {
                        // ( 3 + (4-3))
                        String firstPart = equation.substring(0, pop.index);
                        String middlePart = equation.substring(pop.index+1, i);
                        String lastPart = equation.substring(i+1);
                        equation =  firstPart+
                                splitPlusMinus(middlePart) + lastPart;
                        //ans += splitPlusMinus()
                    }
                }
            }

        }
        return splitPlusMinus(equation);
    }
}
