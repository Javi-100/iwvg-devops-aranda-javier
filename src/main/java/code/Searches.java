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

    public Optional<Fraction> findFractionMultiplicationByUserFamilyName(String familyName) {
        return new UsersDatabase().findAll()
                .filter(user -> user.getFamilyName().equalsIgnoreCase(familyName))  // Filtrar por apellido
                .flatMap(user -> user.getFractions().stream())  // Extraer las fracciones del usuario
                .filter(fraction -> fraction.getNumerator() != 0)  // Excluir fracciones con numerador 0
                .reduce((fraction1, fraction2) -> fraction1.multiply(fraction2));  // Multiplicar las fracciones
    }

    public Optional<Fraction> findHighestFraction() {
        return new UsersDatabase().findAll()  // Obtenemos todos los usuarios
                .flatMap(user -> user.getFractions().stream())  // Obtenemos las fracciones de todos los usuarios
                .filter(fraction -> fraction.getDenominator() != 0) // Filtramos fracciones con denominador 0
                .max(Comparator.comparingDouble(Fraction::decimal)); // Encontramos la fracción con mayor valor decimal
    }
}
