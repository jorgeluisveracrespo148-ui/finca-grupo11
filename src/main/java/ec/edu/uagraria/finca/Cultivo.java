
package ec.edu.uagraria.finca;

public record Cultivo(
        String codigo,
        String nombre,
        double hectareas,
        double costoPorHectarea
) implements Activo {

    public Cultivo {
        if (hectareas <= 0) {
            throw new IllegalArgumentException(
                    "Las hectáreas deben ser positivas"
            );
        }
    }
}

