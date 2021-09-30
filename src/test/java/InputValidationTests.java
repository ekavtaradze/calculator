import org.junit.Test;

import static org.junit.Assert.*;

public class InputValidationTests {

    @Test
    public void checkInputValidity() {
        assertTrue(Validator.checkValidity("4/4"));
        assertTrue(Validator.checkValidity("-4*-.3248/4"));
        assertFalse(Validator.checkValidity("-4*-.3248/4+c"));
        assertFalse(Validator.checkValidity("19 + cinnamon"));

    }

    @Test
    public void checkInputSyntax() {
        assertTrue(Validator.checkSyntax("-4/4"));
        assertTrue(Validator.checkSyntax("--4/4"));
        assertFalse(Validator.checkSyntax("++4/4"));
        assertTrue(Validator.checkSyntax("4+-4"));
        assertFalse(Validator.checkSyntax("4+-+4"));
        assertFalse(Validator.checkSyntax("4*//4"));
        assertFalse(Validator.checkSyntax("0.457**4"));
        assertFalse(Validator.checkSyntax("2+-+-4"));
        assertFalse(Validator.checkSyntax("2/-+4"));
        assertTrue(Validator.checkSyntax("-5+-8--11*2"));
        assertFalse(Validator.checkSyntax("-5++-8--11*2"));
    }

}