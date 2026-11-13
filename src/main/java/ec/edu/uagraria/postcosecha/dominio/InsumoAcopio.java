package ec.edu.uagraria.postcosecha.dominio;

import java.util.Objects;

/** Taller 2: record con constructor compacto. Gavetas, empaques y horas de cámara de refrigeración, con costo unitario. Agreguen los campos propios de su tema. */
public record InsumoAcopio(String codigo, String nombre, double cantidad, UnidadMedida unidad) implements Producto {
    public InsumoAcopio {
        Objects.requireNonNull(codigo, "El codigo es obligatorio");
        Objects.requireNonNull(nombre, "El nombre es obligatorio");
        Objects.requireNonNull(unidad, "La unidad es obligatoria");
        if (cantidad <= 0) throw new IllegalArgumentException("La cantidad debe ser mayor que cero");
    }
}
