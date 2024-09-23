package code;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class SearchesTest {
    @Test
    public void testFindUserFamilyNameInitialBySomeProperFraction() {
        Searches searches = new Searches();

        // Obtener la inicial del apellido de usuarios con fracciones propias
        List<String> initials = searches.findUserFamilyNameInitialBySomeProperFraction()
                .collect(Collectors.toList());

        // Verificar el tamaño de la lista (ejemplo: esperas 3 usuarios)
        assertEquals(4, initials.size());

        // Verificar que las iniciales esperadas están en la lista
        assertTrue(initials.contains("F"));  // Ejemplo: Oscar Fernandez
        assertTrue(initials.contains("L"));  // Ejemplo: Oscar López
        assertTrue(initials.contains("B"));  // Ejemplo: Ana Blanco
    }

    @Test
    public void testFindDecimalImproperFractionByUserName() {
        Searches searches = new Searches();

        // Obtener los valores decimales de las fracciones impropias del usuario "Oscar"
        List<Double> decimalValues = searches.findDecimalImproperFractionByUserName("Oscar")
                .collect(Collectors.toList());

        // Verificar que la lista no esté vacía
        assertFalse(decimalValues.isEmpty());

        // Verificar que los valores decimales esperados estén en la lista
        assertTrue(decimalValues.contains(1.0));  // Ejemplo de valor decimal esperado
        assertTrue(decimalValues.contains(2.0));  // Ejemplo de valor decimal esperado
    }

    @Test
    public void testFindFractionMultiplicationByUserFamilyName() {
        Searches searches = new Searches();

        // Buscar la multiplicación de todas las fracciones del usuario con apellido "Torres"
        Optional<Fraction> multiplicationResult = searches.findFractionMultiplicationByUserFamilyName("Torres");

        // Verificar que el resultado de la multiplicación esté presente
        assertTrue(multiplicationResult.isPresent());

        // Verificar los valores de la fracción resultante (esto depende de los datos de prueba)
        Fraction result = multiplicationResult.get();
        assertEquals(8, result.getNumerator());  // Ajusta según los valores esperados
        assertEquals(0, result.getDenominator()); // Ajusta según los valores esperados
    }

    @Test
    public void testFindHighestFraction() {
        Searches searches = new Searches();

        // Llamamos al método para encontrar la fracción más alta
        Optional<Fraction> highestFraction = searches.findHighestFraction();

        // Verificamos que la fracción se ha encontrado
        assertTrue(highestFraction.isPresent());

        // Verificamos que la fracción es la esperada (2/1 con valor 2.0 es la mayor fracción en esta base de datos)
        Fraction expected = new Fraction(2, 1);
        assertEquals(expected.getNumerator(), highestFraction.get().getNumerator());
        assertEquals(expected.getDenominator(), highestFraction.get().getDenominator());
    }

}
