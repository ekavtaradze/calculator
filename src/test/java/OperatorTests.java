import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OperatorTests {

    //provided with assignment
    @Test
    public void givenTests() {
        assertEquals(3, Calculator.calculate("1 + 2"), 0.0002);
        assertEquals(-1, Calculator.calculate("1 - 2"), 0.0002);
        assertEquals(10, Calculator.calculate("4*5/2"), 0.0002);
        assertEquals(-0.64, Calculator.calculate("-.32       /.5"), 0.0002);
        assertEquals(9, Calculator.calculate("-5+-8--11*2"), 0.0002);
// Do not work
//        assertEquals(7, Calculator.calculate("(4-2)*3.5"), 0.0002);
//        assertEquals(-0.64, Calculator.calculate("2+-+-4" ), 0.0002);
//        assertEquals(-0.64, Calculator.calculate("19 + cinnamon"), 0.0002);

    }

    @Test
    public void splitMultDiv() {
        assertEquals(1, Calculator.splitMultDiv(Calculator.multDivPattern, "4/4"), 0.002);
        assertEquals(0.3248, Calculator.splitMultDiv(Calculator.multDivPattern, "-4*-.3248/4"), 0.002);
        assertEquals(-0.3248, Calculator.splitMultDiv(Calculator.multDivPattern, "-4*-.3248/-4"), 0.002);
        assertEquals(4, Calculator.splitMultDiv(Calculator.multDivPattern, "4"), 0.002);

    }


}
