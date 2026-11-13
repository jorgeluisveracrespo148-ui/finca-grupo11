package ec.edu.uagraria.postcosecha.dominio;

/** Taller 2: interfaz con metodo default y metodo static. */
public interface Trazable {
    String codigo();

    default String etiquetaTrazabilidad() { return "UAE-" + codigo().toUpperCase(); }

    static String generarCodigo(String prefijo, int secuencia) {
        if (prefijo == null || prefijo.isBlank()) throw new IllegalArgumentException("Prefijo obligatorio");
        return "%s-%04d".formatted(prefijo.toUpperCase(), secuencia);
    }
}
