class SplitterHelper {
    private static int indexSub = -1;
    private static int indexAdd = -1;
    private static int indexMult = -1;
    private static int indexDiv = -1;
    private static int indexOpenPar = -1;
    private static int indexClosePar = -1;

    private static int findMinus(String equation) {
        int indexSub = equation.indexOf('-', 1);
        if (indexSub != -1 && !Character.isDigit(equation.charAt(indexSub - 1))) {
            indexSub = equation.substring(indexSub).indexOf('-', 1);
        }
        return indexSub;
    }

    static int findFirstPlusMinus() {
        if (indexAdd == -1 || indexSub == -1) {
            return Math.max(indexAdd, indexSub);
        } else return Math.min(indexAdd, indexSub);
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

    static int findFirstParenth() {
        if (indexOpenPar == -1 || indexClosePar == -1) {
            return Math.max(indexOpenPar, indexClosePar);
        } else return Math.min(indexOpenPar, indexClosePar);
    }

    static boolean includesParenth(String equation, int i) {
        indexOpenPar = equation.indexOf('(', i);
        indexClosePar = equation.indexOf(')', i);
        return indexOpenPar != -1 || indexClosePar != -1;
    }
}
