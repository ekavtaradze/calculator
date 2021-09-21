import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
https://stackoverflow.com/questions/60362725/java-regex-split-decimal-minus-and-math-operation
* */
class EquationSplitter {
    static String plusMinusPattern = "\\b[-+]";
    static String multDivPattern = "\\b[/*]";

    /**
     * This function finds and calculates the multiplications and divisions in the equation
     * @param equation the equation to be calculated
     * @return the answer of the input equation as float
     * */
    static float calculateDivAndMult(String equation) {
        Pattern regex = Pattern.compile(multDivPattern);
        Matcher m = regex.matcher(equation);
        int start = 0;
        boolean operation = false;
        String prevOp = "";
        String current = "";
        float answer = 0;
        while (m.find()) {
            current = equation.substring(start, m.start());
            if (operation) {
                answer = Operations.prepOperation(answer, prevOp, current);
            } else {
                operation = true;
                answer = Float.parseFloat(current);
            }
            prevOp = m.group();

            start = m.end();
        }

        if (start <= equation.length()) {
            current = equation.substring(start);
            answer = Operations.prepOperation(answer, prevOp, current);
        }
        return answer;
    }

    /**
     * This function splits the input equation by + and - signs. From the split it gets smaller equations, and signs.
     * The smaller equations are delegated to calculateDivAndMult, returned floats(calculations) are then added up or
     * subtracted based on the signs remaining from original split.
     * @param equation the equation to be calculated
     * @return the answer of the input equation as float
     * */
    static float splitAndCalculateAddSub(String equation) {
        Pattern regex = Pattern.compile(plusMinusPattern);
        Matcher matcher = regex.matcher(equation);
        ArrayList<String> ret = new ArrayList<>();

        boolean startDelegating = false;
        String prevOperator = "";
        int start = 0;
        float current = 0;
        float ans = 0;
        while (matcher.find()) {
            ret.add(equation.substring(start, matcher.start()));
            current = calculateDivAndMult(equation.substring(start, matcher.start()));
            if (startDelegating) {
                ans = Operations.prepOperation(ans, prevOperator, current);
            } else {
                startDelegating = true;
                ans = current;
            }
            ret.add(matcher.group());
            prevOperator = matcher.group();
            start = matcher.end();
        }
        if (start <= equation.length()) {
            ret.add(equation.substring(start));
            current = calculateDivAndMult(equation.substring(start));
            ans = Operations.prepOperation(ans, prevOperator, current);
        }

        return ans;
    }
}
