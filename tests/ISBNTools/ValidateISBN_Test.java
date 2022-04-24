package ISBNTools;

import org.junit.Test;
import static org.junit.Assert.*;

public class ValidateISBN_Test {

    @Test
    public void testValidISBN10(){
        ValidateISBN validator = new ValidateISBN();
        boolean returnValue = validator.checkISBN("0806512717");
        assertTrue("First Value", returnValue);
        returnValue = validator.checkISBN("0385348118");
        assertTrue("Second Value", returnValue);
    }

    @Test
    public void testInvalidISBN10(){
        ValidateISBN validator = new ValidateISBN();
        boolean returnValue = validator.checkISBN("0806512727");
        assertFalse(returnValue);
    }

    @Test(expected = NumberFormatException.class)
    public void testWrongLengthISBN(){
        ValidateISBN validator = new ValidateISBN();
        validator.checkISBN("123456789");
    }

    @Test(expected = NumberFormatException.class)
    public void testCharTypeISBN(){
        ValidateISBN validator = new ValidateISBN();
        validator.checkISBN("abcdefghij");
    }
//012000030X

    @Test()
    public void testFinalXISBN(){
        ValidateISBN validator = new ValidateISBN();
        validator.checkISBN("012000030X");
    }

    @Test
    public void testValidISBN13(){
        ValidateISBN validator = new ValidateISBN();
        boolean returnValue = validator.checkISBN("9780806512716");
        assertTrue("First 13 value: ", returnValue);
        //978-0385348119
        returnValue = validator.checkISBN("9780385348119");
        assertTrue("Second 13 value: ", returnValue);
    }

    @Test
    public void testInvalidISBN13(){
        ValidateISBN validator = new ValidateISBN();
        boolean returnValue = validator.checkISBN("9780385308119");
        assertFalse(returnValue);
    }


}
