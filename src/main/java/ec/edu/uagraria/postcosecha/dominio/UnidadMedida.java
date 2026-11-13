package ec.edu.uagraria.postcosecha.dominio;

/** Taller 2: enumeracion con datos y comportamiento. */
public enum UnidadMedida {
    KILOGRAMO(1.0), QUINTAL(45.3592), TONELADA(1000.0), LITRO(1.0), UNIDAD(1.0);

    private final double factorAKilogramos;

    UnidadMedida(double factorAKilogramos) { this.factorAKilogramos = factorAKilogramos; }

    public double aKilogramos(double cantidad) { return cantidad * factorAKilogramos; }
}
