package ec.edu.uagraria.postcosecha.dominio;

import java.util.Objects;

/** Taller 2: record con constructor compacto. Se reinterpreta como lote rechazado en recepción: causal, kilogramos y destino. Agreguen los campos propios de su tema. */
public record LoteRechazado(String codigo, String nombre, double cantidad, UnidadMedida unidad, Calidad estado) implements Producto {
    public LoteRechazado {
        Objects.requireNonNull(codigo, "El codigo es obligatorio");
        Objects.requireNonNull(nombre, "El nombre es obligatorio");
        Objects.requireNonNull(unidad, "La unidad es obligatoria");
        if (cantidad <= 0) throw new IllegalArgumentException("La cantidad debe ser mayor que cero");
    }

    /** Inmutabilidad: no se muta, se devuelve una copia. */
    public LoteRechazado conEstado(Calidad nuevo) { return new LoteRechazado(codigo, nombre, cantidad, unidad, nuevo); }
}
