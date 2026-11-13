package ec.edu.uagraria.postcosecha.dominio;

/** Taller 2: pattern matching exhaustivo en switch, sin default. */
public final class Inventario {
    private Inventario() { }

    public static String describir(Producto p) {
        return switch (p) {
            case LoteFruta c when c.cantidad() > 100 -> "LoteFruta grande: " + c.nombre();
            case LoteFruta c                        -> "LoteFruta: " + c.nombre();
            case LoteRechazado a when a.estado().esNormal() -> "LoteRechazado en estado normal: " + a.nombre();
            case LoteRechazado a                        -> "LoteRechazado requiere atencion: " + a.nombre();
            case InsumoAcopio i                        -> "InsumoAcopio: " + i.nombre() + " (" + i.pesoEnKilogramos() + " kg)";
        };
    }
}
