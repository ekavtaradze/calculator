public class Operations {

    static float prepOperation(float firstPart, String operator, String second) {
        float secondPart = Float.parseFloat(second);
        return doOperation(firstPart, operator, secondPart);
    }

    static float prepOperation(float firstPart, String operator, Float secondPart) {
        return doOperation(firstPart, operator, secondPart);
    }

    /**
     * This function calculates input operation on two input numbers
     * @param firstPart the first/left part of the operation
     * @param operator the operatand for the two input numbers
     * @param secondPart the second/right part of the operation
     * @return the answer of the operation as a float
     * */
    private static float doOperation(float firstPart, String operator, Float secondPart) {
        float answer= 0;

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
