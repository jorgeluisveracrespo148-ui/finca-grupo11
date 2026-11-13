package ec.edu.uagraria.postcosecha.dominio;

/** Taller 2: enumeracion propia del tema. GOLPE, PUDRICION, SOBREMADUREZ, PLAGA. */
public enum CausalMerma {
    GOLPE("Golpe"),
    PUDRICION("Pudricion"),
    SOBREMADUREZ("Sobremadurez"),
    PLAGA("Plaga");

    private final String descripcion;

    CausalMerma(String descripcion) { this.descripcion = descripcion; }

    public String descripcion() { return descripcion; }
}
