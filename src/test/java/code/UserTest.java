package code;
import code.Fraction;
import code.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
public class UserTest {

    private User user;
    private List<Fraction> fractions;

    @BeforeEach
    void setUp() {
        // Configuración inicial antes de cada prueba
        fractions = new ArrayList<>();
        fractions.add(new Fraction(1, 2)); // Supongo que tienes una clase Fraction
        fractions.add(new Fraction(3, 4));
        user = new User("1", "John", "Doe", fractions);
    }

    @Test
    void testUserConstructor() {
        assertNotNull(user);
        assertEquals("1", user.getId());
        assertEquals("John", user.getName());
        assertEquals("Doe", user.getFamilyName());
        assertEquals(fractions, user.getFractions());
    }

    @Test
    void testSetName() {
        user.setName("Jane");
        assertEquals("Jane", user.getName());
    }

    @Test
    void testSetFamilyName() {
        user.setFamilyName("Smith");
        assertEquals("Smith", user.getFamilyName());
    }

    @Test
    void testGetFractions() {
        assertEquals(2, user.getFractions().size());
        assertEquals(fractions, user.getFractions());
    }

    @Test
    void testAddFraction() {
        Fraction newFraction = new Fraction(5, 6);
        user.addFraction(newFraction);
        assertEquals(3, user.getFractions().size());
        assertTrue(user.getFractions().contains(newFraction));
    }

    @Test
    void testFullName() {
        assertEquals("John Doe", user.fullName());
    }

    @Test
    void testInitials() {
        assertEquals("J.", user.initials());
    }

    @Test
    void testToString() {
        String expectedString = "User{id='1', name='John', familyName='Doe', fractions=" + fractions + "}";
        assertEquals(expectedString, user.toString());
    }

    @Test
    void testEmptyConstructor() {
        User emptyUser = new User();
        assertNotNull(emptyUser.getFractions());
        assertTrue(emptyUser.getFractions().isEmpty());
    }
}
