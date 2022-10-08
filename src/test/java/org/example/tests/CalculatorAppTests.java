package org.example.tests;
import org.example.ValidateString;
import org.junit.Test;
import org.example.CalculatorApp;
import static org.junit.Assert.*;

public class CalculatorAppTests
{
    @Test
    public void testConstructor()
    {
        new CalculatorApp();
    }

    @Test
    public void testMultiplication(){ assertEquals(CalculatorApp.Multiplication(5,6), 30);}

    @Test
    public void testMultiplicationMinus(){ assertEquals(CalculatorApp.Multiplication(-1,6), -6);}

    @Test
    public void testAddition(){assertEquals(CalculatorApp.addition(12,5), 17);}

    @Test
    public void testAdditionMinus(){assertEquals(CalculatorApp.addition(-2,1), -1);}

    @Test
    public void testSubtraction(){assertEquals(CalculatorApp.subtraction(2,1), 1);}

    @Test
    public void testSubtractionMinus(){assertEquals(CalculatorApp.subtraction(2,5), -3);}

    @Test
    public void testCalculatorFunction(){assertEquals(CalculatorApp.CalculatorFunction("12435+34569-12345*10+50"), -76496);}

    @Test
    public void testCalculatorFunctionSimple(){assertEquals(CalculatorApp.CalculatorFunction("1+4+5*6*8-7-3"), 235);}
}
