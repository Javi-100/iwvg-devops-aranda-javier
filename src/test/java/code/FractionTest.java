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
}
