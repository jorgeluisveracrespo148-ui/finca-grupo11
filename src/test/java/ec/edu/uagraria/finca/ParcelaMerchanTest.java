package ec.edu.uagraria.finca;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class ParcelaMerchanTest {

    @Test
    void probarAreaConNuevaHectarea() {
        // Probamos con 1.5 hectáreas (15,000 metros cuadrados)
        Parcela parcela = new Parcela("P-15", 1.5);

        assertEquals(15_000.0, parcela.areaEnMetrosCuadrados(), 0.001);
    }
}
