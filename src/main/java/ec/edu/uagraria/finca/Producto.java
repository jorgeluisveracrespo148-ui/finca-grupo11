
package ec.edu.uagraria.finca;

public record Producto(
        String codigo,
        String nombre,
        double precioUnitario,
        int unidades
) implements Activo {

    public Producto {
        if (precioUnitario < 0 || unidades < 0) {
            throw new IllegalArgumentException("Valores negativos");
        }
    }
}
