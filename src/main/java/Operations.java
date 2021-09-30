public class Operations {

    /**
     * This function calculates input multiplication or division operation on two input numbers
     *
     * @param firstPart the first/left part of the operation
     * @param operator  the operatand for the two input numbers
     * @param second    the second/right part of the operation
     * @return the answer of the operation as a float
     */
    static double doMultDiv(double firstPart, char operator, String second) {
        double secondPart = Double.parseDouble(second);
        switch (operator) {
            case '*':
                return firstPart * secondPart;
            case '/':
                return firstPart / secondPart;
            default:
                return secondPart;
        }
    }

    /**
     * This function calculates input addition or subtraction operation on two input numbers
     *
     * @param firstPart  the first/left part of the operation
     * @param operator   the operatand for the two input numbers
     * @param secondPart the second/right part of the operation
     * @return the answer of the operation as a float
     */
    static double doAddSub(double firstPart, char operator, double secondPart) {
        switch (operator) {
            case '+':
                return firstPart + secondPart;
            case '-':
                return firstPart - secondPart;
            default:
                return secondPart;
        }
    }
}