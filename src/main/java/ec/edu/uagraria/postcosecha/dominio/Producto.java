package ec.edu.uagraria.postcosecha.dominio;

/** Taller 2: jerarquia sellada. Solo estos tres tipos pueden implementarla. */
public sealed interface Producto extends Trazable permits LoteFruta, LoteRechazado, InsumoAcopio {
    String nombre();
    double cantidad();
    UnidadMedida unidad();

    default double pesoEnKilogramos() { return unidad().aKilogramos(cantidad()); }
}
