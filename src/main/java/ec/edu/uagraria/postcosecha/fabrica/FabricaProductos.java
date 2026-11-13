package ec.edu.uagraria.postcosecha.fabrica;

import ec.edu.uagraria.finca.Producto;


/** FACTORY: unico lugar donde se construyen los productos del dominio. */

public final class FabricaProductos {

    private static int secuencia = 0;



    private FabricaProductos() { }



    public static Producto crear(TipoProducto tipo, String nombre, double cantidad) {

        secuencia++;

        String codigo = Trazable.generarCodigo(tipo.prefijo(), secuencia);

        return switch (tipo) {                   // exhaustivo: sin default

            case LOTE_FRUTA -> new LoteFruta(codigo, nombre, cantidad);

            case LOTE_RECHAZADO -> new LoteRechazado(codigo, nombre, cantidad);

            case INSUMO_ACOPIO -> new InsumoAcopio(codigo, nombre, cantidad);

        };

    }

}
