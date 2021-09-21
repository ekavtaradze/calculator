import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    static String plusMinusPattern = "\\b[-+]";
    static String multDivPattern = "\\b[/*]";
    static String findFirstNumPattern = "[+-]?[.]?\\d+[.]?\\d*";
    static String operators = "+-*/";

    static boolean checkInput(String s) {
        //implement
        return true;
    }



    private static float doOperation(float firstPart, String operator, Float secondPart){
        System.out.println("DO OPERATION ON " + firstPart + "  "+operator +"  "+ secondPart);
        float ans = 0;

        System.out.println();
        if ("+".equals(operator)) {
            System.out.println("DOING ADDITION");
            ans = firstPart + secondPart;
        } else if ("-".equals(operator)) {
            System.out.println("DOING Negation");
            ans = firstPart - secondPart;
        } else if ("*".equals(operator)) {
            System.out.println("DOING MULTIPLICATION");
            ans = firstPart * secondPart;
        } else if ("/".equals(operator)) {
            System.out.println("DOING DIVISION "+ firstPart + "  /  "+secondPart);
            ans = firstPart / secondPart;
        }else {
            ans = secondPart;
        }
        return ans;
    }

    private static float prepOperation(float firstPart, String operator, String second){
        float secondPart = Float.parseFloat(second);
        return doOperation(firstPart, operator, secondPart);
    }
    private static float prepOperation(float firstPart, String operator, Float secondPart){
        return doOperation(firstPart, operator, secondPart);
    }

    /*
    https://stackoverflow.com/questions/60362725/java-regex-split-decimal-minus-and-math-operation
    * */
    static float splitMultDiv(String pattern, String s) {
//        System.out.println();
//        System.out.println("LENGTH " + s.length());
        Pattern regex = Pattern.compile(pattern);
        Matcher m = regex.matcher(s);
        ArrayList<String> ret = new ArrayList<>();
        int start = 0;
        boolean operation = false;
        String prevOp = "";
        String current = "";
        float ans =0;
        while (m.find()) {
            ret.add(s.substring(start, m.start()));
            current = s.substring(start, m.start());
            if(operation){
                ans = prepOperation(ans, prevOp, current );
            } else{
                operation= true;
                ans = Float.parseFloat(current);
            }
            ret.add(m.group());
            prevOp= m.group();

            start = m.end();
        }
        //System.out.println("start "+ start + "  len"+ s.length() );
        if (start <= s.length()) {
            ret.add(s.substring(start));
            current = s.substring(start);
            ans = prepOperation(ans, prevOp, current );
        }
//        for (String str : ret) {
//            System.out.println(str);
//        }
//        System.out.println(ans);
        return ans;
    }
    static float splitAddSub(String s){
//        System.out.println();
//        System.out.println("LENGTH " + s.length());
        Pattern regex = Pattern.compile(plusMinusPattern);
        Matcher m = regex.matcher(s);
        ArrayList<String> ret = new ArrayList<>();
        int start = 0;
        boolean operat = false;
        String prevOp = "";
        float current = 0;
        float ans =0;
        while (m.find()) {
            ret.add(s.substring(start, m.start()));
            current = splitMultDiv(multDivPattern, s.substring(start, m.start()));
            if(operat){
                ans = prepOperation(ans, prevOp, current );
            } else{
                operat= true;
                ans = current;
            }
            ret.add(m.group());
            prevOp= m.group();
            start = m.end();
        }
        //System.out.println("start "+ start + "  len"+ s.length() );
        if (start <= s.length()) {
            ret.add(s.substring(start));
            current = splitMultDiv(multDivPattern, s.substring(start));
            ans = prepOperation(ans, prevOp, current );
        }
//        for (String str : ret) {
//            System.out.println(str);
//        }
        return ans;
    }



    static float calculate(String s) {
        s = s.replace(" ", "");
        if (checkInput(s)) {
            return splitAddSub(s);
        }
        return -1;
    }
}
