package code;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;
public class Searches {
    public Stream<String> findUserFamilyNameInitialBySomeProperFraction() {
        return new UsersDatabase().findAll()
                .filter(user -> user.getFractions().stream()
                        .anyMatch(fraction -> Math.abs(fraction.getNumerator()) < fraction.getDenominator()))  // Verificar si tiene fracción propia
                .map(user -> user.getFamilyName().substring(0, 1));  // Obtener la inicial del apellido
    }

    public Stream<Double> findDecimalImproperFractionByUserName(String name) {
        return new UsersDatabase().findAll()
                .filter(user -> user.getName().equalsIgnoreCase(name))  // Filtrar por nombre
                .flatMap(user -> user.getFractions().stream())  // Extraer las fracciones del usuario
                .filter(Fraction::isImproper)  // Filtrar las fracciones impropias
                .map(Fraction::decimal);  // Convertir a decimal
    }
}
