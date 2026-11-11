
package ec.edu.uagraria.finca;

public record Animal(
        String codigo,
        String especie,
        double pesoKg,
        double precioPorKg
) implements Activo {

    public Animal {
        if (pesoKg <= 0 || precioPorKg < 0) {
            throw new IllegalArgumentException(
                    "El peso debe ser positivo y el precio no puede ser negativo"
            );
        }
    }
}

