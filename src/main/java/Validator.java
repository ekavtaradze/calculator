import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Validator {
    private static String validityPattern = "[^0-9+\\-/*().]";
    private static String syntaxPattern = "[+*/]{2}|[-]{3}|[+\\-*/][+\\-*/][+\\-*/]";

    /**
     *Check the validity of the input equation. Checks that there are no symbols
     * in the equation besides  "0-9" "+" "-" "*" "(" ")" "."
     * @param equation the equations to be checked for validity
     * @return true if input equation is valid, false otherwise
     * */
    static boolean checkValidity(String equation) {
        Pattern regex = Pattern.compile(validityPattern);
        Matcher m = regex.matcher(equation);
        return !m.find();
    }
    /**
     *Check the syntax of the input equation. Checks that there are no consecutive
     * "-" signs more than 2 times, "+" "/" "
     * @param equation the equations to be checked for validity
     * @return true if input equation is valid, false otherwise
     * */
    static boolean checkSyntax(String equation) {
        Pattern regex = Pattern.compile(syntaxPattern);
        Matcher m = regex.matcher(equation);
        return !m.find();
    }
}
