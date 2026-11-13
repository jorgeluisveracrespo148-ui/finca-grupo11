package ec.edu.uagraria.postcosecha.reglas;

/** Taller 3: las estrategias del tema como lambdas. */
public final class Estrategias {
    public static final double IVA = 0.15;

    private Estrategias() { }

    /** Kilogramos perdidos sobre kilogramos recibidos, en porcentaje. FORMULA PROVISIONAL: reemplacen por la de su tema. */
    public static EstrategiaCalculo porcentajeMerma() {
        return p -> p.pesoEnKilogramos() * 1.0;
    }

    /** Kilogramos perdidos por el precio de compra. FORMULA PROVISIONAL: reemplacen por la de su tema. */
    public static EstrategiaCalculo perdidaEconomica() {
        return p -> p.pesoEnKilogramos() * 1.25;
    }

    /** Kilogramos aprovechables entregados por un proveedor sobre lo recibido. FORMULA PROVISIONAL: reemplacen por la de su tema. */
    public static EstrategiaCalculo rendimientoProveedor() {
        return p -> p.pesoEnKilogramos() * 1.5;
    }

    /** Composicion: envuelve otra estrategia. */
    public static EstrategiaCalculo conIva(EstrategiaCalculo base) {
        return p -> base.calcular(p) * (1 + IVA);
    }
}
