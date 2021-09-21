import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class InputValidationTests {

    @Test
    public void checkInputValidity() {
        assertEquals(true, Validator.checkValidity("4/4"));
        assertEquals(true, Validator.checkValidity("-4*-.3248/4"));
        assertEquals(false, Validator.checkValidity("-4*-.3248/4+c"));
        assertEquals(false, Validator.checkValidity("19 + cinnamon"));

    }

    @Test
    public void checkInputSyntax() {
        assertEquals(true, Validator.checkSyntax("-4/4"));
        assertEquals(true, Validator.checkSyntax("--4/4"));
        assertEquals(false, Validator.checkSyntax("++4/4"));
        assertEquals(true, Validator.checkSyntax("4+-4"));
        assertEquals(false, Validator.checkSyntax("4+-+4"));
        assertEquals(false, Validator.checkSyntax("4*//4"));
        assertEquals(false, Validator.checkSyntax("0.457**4"));
        assertEquals(false, Validator.checkSyntax("2+-+-4"));
        assertEquals(false, Validator.checkSyntax("2/-+4"));
        assertEquals(true, Validator.checkSyntax("-5+-8--11*2"));
        assertEquals(false, Validator.checkSyntax("-5++-8--11*2"));
    }

}