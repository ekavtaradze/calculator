public class Operations {

    static double prepOperation(double firstPart, char operator, double secondPart) {
        String op = String.valueOf(operator);
        return doOperation(firstPart, op, secondPart);
    }
    static double prepOperation(String firstPart, char operator, double secondPart) {
       double first = Double.parseDouble(firstPart);
        String op = String.valueOf(operator);
        return doOperation(first, op, secondPart);
    }

    /**
     * This function calculates input operation on two input numbers
     * @param firstPart the first/left part of the operation
     * @param operator the operatand for the two input numbers
     * @param secondPart the second/right part of the operation
     * @return the answer of the operation as a float
     * */
    private static double doOperation(double firstPart, String operator, double secondPart) {
        double answer= 0;

        System.out.println();
        if ("+".equals(operator)) {
            answer = firstPart + secondPart;
        } else if ("-".equals(operator)) {
            answer = firstPart - secondPart;
        } else if ("*".equals(operator)) {
            answer = firstPart * secondPart;
        } else if ("/".equals(operator)) {
            answer = firstPart / secondPart;
        } else {
            answer = secondPart;
        }
        return answer;
    }
}
