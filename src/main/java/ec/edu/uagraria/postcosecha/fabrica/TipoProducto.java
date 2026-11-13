package ec.edu.uagraria.postcosecha.fabrica;

/** Los tres tipos de producto del tema, con el prefijo de su codigo. */

public enum TipoProducto {

    LOTE_FRUTA("CUL"),

    LOTE_RECHAZADO("ANI"),

    INSUMO_ACOPIO("INS");



    private final String prefijo;



    TipoProducto(String prefijo) { this.prefijo = prefijo; }



    public String prefijo() { return prefijo; }

}
