package ec.edu.uagraria.postcosecha.fabrica;

import ec.edu.uagraria.postcosecha.dominio.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;



class FabricaProductosTest {



    @Test

    void creaElTipoCorrectoConCodigoGenerado() {

        Producto p = FabricaProductos.crear(TipoProducto.LOTE_RECHAZADO, "Se reinterpreta como lote rechazado en recepción", 1);

        assertInstanceOf(LoteRechazado.class, p);

        assertTrue(p.codigo().startsWith("ANI-"));

    }

}