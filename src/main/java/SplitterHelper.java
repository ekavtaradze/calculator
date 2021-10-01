public class SplitterHelper {
    static int indexSub = -1;
    static int indexAdd = -1;
    static int indexMult = -1;
    static int indexDiv = -1;

    static int findMinus(String equation) {
        int indexSub = equation.indexOf('-', 1);
        if (indexSub != -1 && !Character.isDigit(equation.charAt(indexSub - 1))) {
            indexSub = equation.substring(indexSub).indexOf('-', 1);
        }
        return indexSub;
    }

    static int findFirstPlusMinus() {
        int min;
        if (indexAdd == -1 || indexSub == -1) {
            min = Math.max(indexAdd, indexSub);
        } else min = Math.min(indexAdd, indexSub);
        return min;
    }

    static boolean includesPlusMinus(String equation) {
        indexAdd = equation.indexOf('+');
        indexSub = findMinus(equation);
        return indexAdd != -1 || indexSub != -1;
    }

    static int findLastMultDiv() {
        return Math.max(indexMult, indexDiv);
    }

    static boolean includesMultDiv(String equation) {
        indexMult = equation.lastIndexOf('*');
        indexDiv = equation.lastIndexOf('/');
        return indexMult != -1 || indexDiv != -1;
    }
}
