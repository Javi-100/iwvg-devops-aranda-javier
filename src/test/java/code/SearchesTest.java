package code;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.List;
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

}
