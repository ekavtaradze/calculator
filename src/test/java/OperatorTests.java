import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OperatorTests {

    //provided with assignment
    @Test
    public void givenTests() {
        assertEquals("3", Calculator.calculate("1 + 2"));
        assertEquals("-1", Calculator.calculate("1 - 2"));
        assertEquals("10", Calculator.calculate("4*5/2"));
        assertEquals("-0.64", Calculator.calculate("-.32       /.5"));
        assertEquals("9", Calculator.calculate("-5+-8--11*2"));
        assertEquals("-0.58678", Calculator.calculate("-.58678"));
        assertEquals("Syntax Error", Calculator.calculate("2+-+-4"));
        assertEquals("Invalid Input", Calculator.calculate("19 + cinnamon"));
        //assertEquals("7", Calculator.calculate("(4-2)*3.5"));

    }

    @Test
    public void checkMultDiv() {
        assertEquals(1, EquationSplitter.calculateDivAndMult( "4/4"), 0.002);
        assertEquals(0.3248, EquationSplitter.calculateDivAndMult( "-4*-.3248/4"), 0.002);
        assertEquals(-0.3248, EquationSplitter.calculateDivAndMult( "-4*-.3248/-4"), 0.002);
        assertEquals(4,EquationSplitter.calculateDivAndMult( "4"), 0.002);

    }







}
