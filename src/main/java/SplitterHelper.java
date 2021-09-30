public class SplitterHelper {
    static int indexSub =-1;
    static int indexAdd =-1;
    static int indexMult = -1;
    static int indexDiv = -1;

    static int findMinus(String equation){
        int indexSub = equation.indexOf('-', 1);
        if(indexSub!=-1 && !Character.isDigit(equation.charAt(indexSub-1))){
            indexSub = equation.substring(indexSub).indexOf('-',1);
        }
        return indexSub;
    }
    static int findMin(){
        int min =0;
        if(indexAdd==-1){
            min = indexSub;
        } else if(indexSub==-1){
            min = indexAdd;
        } else min = Math.min(indexAdd, indexSub);
        return min;
    }
    static boolean includesPlusMinus(String equation){
        indexAdd = equation.indexOf('+');
        indexSub = findMinus(equation);
        if(indexAdd==-1 && indexSub==-1)
            return false;
        return true;
    }

    static int findMax(){
        return Math.max(indexMult, indexDiv);
    }
    static boolean includesMultDiv(String equation){
        indexMult = equation.lastIndexOf('*');
        indexDiv = equation.lastIndexOf('/');
        if(indexMult==-1 && indexDiv==-1)
            return false;
        return true;
    }
}
