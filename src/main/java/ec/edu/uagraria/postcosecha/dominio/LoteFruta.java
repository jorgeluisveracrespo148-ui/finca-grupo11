package ec.edu.uagraria.postcosecha.dominio;

import java.util.Objects;

/** Taller 2: record con constructor compacto. Frutas y hortalizas recibidas por lote: proveedor, kilogramos y fecha de recepción. Agreguen los campos propios de su tema. */
public record LoteFruta(String codigo, String nombre, double cantidad, UnidadMedida unidad) implements Producto {
    public LoteFruta {
        Objects.requireNonNull(codigo, "El codigo es obligatorio");
        Objects.requireNonNull(nombre, "El nombre es obligatorio");
        Objects.requireNonNull(unidad, "La unidad es obligatoria");
        if (cantidad <= 0) throw new IllegalArgumentException("La cantidad debe ser mayor que cero");
    }
}
