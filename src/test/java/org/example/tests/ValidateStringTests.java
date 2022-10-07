package org.example.tests;
import org.junit.Test;
import static org.junit.Assert.*;

import org.example.ValidateString;

class ValidateStringTests {


    @Test
    public void testConstructor()
    {
        new ValidateString();
    }

    @Test
    public void testEmptyString() {
        String c = "";
        assertFalse(ValidateString.isValid(c));
    }

    @Test
    public void testLetters() {
        String c = "77*d-33";
        assertFalse(ValidateString.isValid(c));
    }

    @Test
    public void testMultipleOperators() {
        String c = "1+2+3*4++5";
        assertFalse(ValidateString.isValid(c));
    }

    @Test
    public void testCorrectInput() {
        String c = "12435+34569-12345*10+50";
        assertTrue(ValidateString.isValid(c));
    }

    @Test
    public void testCorrectInput2() {
        String c = "2*670-534+1234";
        assertTrue(ValidateString.isValid(c));
    }


}
