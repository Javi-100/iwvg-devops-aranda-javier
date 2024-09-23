package code;
import code.Fraction;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class FractionTest {
    @Test
    void testConstructorWithArguments() {
        Fraction fraction = new Fraction(3, 4);
        assertEquals(3, fraction.getNumerator());
        assertEquals(4, fraction.getDenominator());
    }

    @Test
    void testDefaultConstructor() {
        Fraction fraction = new Fraction();
        assertEquals(1, fraction.getNumerator());
        assertEquals(1, fraction.getDenominator());
    }

    @Test
    void testSetNumerator() {
        Fraction fraction = new Fraction();
        fraction.setNumerator(5);
        assertEquals(5, fraction.getNumerator());
    }

    @Test
    void testSetDenominator() {
        Fraction fraction = new Fraction();
        fraction.setDenominator(10);
        assertEquals(10, fraction.getDenominator());
    }

    @Test
    void testDecimal() {
        Fraction fraction = new Fraction(1, 2);
        assertEquals(0.5, fraction.decimal(), 0.0001);
    }

    @Test
    void testToString() {
        Fraction fraction = new Fraction(2, 3);
        assertEquals("Fraction{numerator=2, denominator=3}", fraction.toString());
    }

    @Test
    void testIsProperTrue() {
        Fraction fraction = new Fraction(2, 3);
        assertTrue(fraction.isProper());
    }

    @Test
    void testIsProperFalse() {
        Fraction fraction = new Fraction(4, 3);
        assertFalse(fraction.isProper());
    }

    @Test
    void testIsImproperTrue() {
        Fraction fraction = new Fraction(4, 3);
        assertTrue(fraction.isImproper());
    }

    @Test
    void testIsImproperFalse() {
        Fraction fraction = new Fraction(2, 3);
        assertFalse(fraction.isImproper());
    }

    @Test
    void testIsEquivalentTrue() {
        Fraction fraction1 = new Fraction(1, 2);
        Fraction fraction2 = new Fraction(2, 4);
        assertTrue(fraction1.isEquivalent(fraction2));
    }

    @Test
    void testIsEquivalentFalse() {
        Fraction fraction1 = new Fraction(1, 2);
        Fraction fraction2 = new Fraction(3, 4);
        assertFalse(fraction1.isEquivalent(fraction2));
    }

    @Test
    void testAdd() {
        Fraction fraction1 = new Fraction(1, 2);
        Fraction fraction2 = new Fraction(1, 3);
        Fraction result = fraction1.add(fraction2);
        assertEquals(5, result.getNumerator());
        assertEquals(6, result.getDenominator());
    }

    @Test
    void testMultiply() {
        Fraction fraction1 = new Fraction(1, 2);
        Fraction fraction2 = new Fraction(2, 3);
        Fraction result = fraction1.multiply(fraction2);
        assertEquals(2, result.getNumerator());
        assertEquals(6, result.getDenominator());
    }

    @Test
    void testDivide() {
        Fraction fraction1 = new Fraction(1, 2);
        Fraction fraction2 = new Fraction(2, 3);
        Fraction result = fraction1.divide(fraction2);
        assertEquals(3, result.getNumerator());
        assertEquals(4, result.getDenominator());
    }
}
