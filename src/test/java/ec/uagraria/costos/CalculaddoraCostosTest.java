package ec.uagraria.costos;



import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;



class CalculadoraCostosTest {



    private Lote loteBanano() {

        return new Lote("L-01", new Banano("Cavendish"), 4.0, List.of(

                new Insumo("Urea 50 kg", 12, "saco", 32.50),

                new Insumo("Fungicida", 8, "litro", 21.75),

                new Insumo("Semilla certificada", 1, "lote", 180.00)));

    }



    @Test void sinEstrategiaDevuelveOptionalVacio() {

        assertTrue(new CalculadoraCostos().calcular(loteBanano()).isEmpty());

    }



    @Test void costoDirectoSumaLosInsumos() {

        var calc = new CalculadoraCostos(Estrategias.costoDirecto());

        assertEquals(744.00, calc.calcular(loteBanano()).orElseThrow(), 0.01);

    }



    @Test void costoConManoDeObra() {

        var calc = new CalculadoraCostos(Estrategias.costoConManoDeObra());

        assertEquals(2076.00, calc.calcular(loteBanano()).orElseThrow(), 0.01);

    }



    @Test void costoPorHectarea() {

        var calc = new CalculadoraCostos(Estrategias.costoPorHectarea());

        assertEquals(519.00, calc.calcular(loteBanano()).orElseThrow(), 0.01);

    }



    @Test void costoConSubsidioDel20PorCiento() {

        var calc = new CalculadoraCostos(Estrategias.costoConSubsidioFertilizante(0.20));

        assertEquals(1998.00, calc.calcular(loteBanano()).orElseThrow(), 0.01);

    }



    @Test void costoConIva() {

        var calc = new CalculadoraCostos(Estrategias.conIva(Estrategias.costoConManoDeObra()));

        assertEquals(2387.40, calc.calcular(loteBanano()).orElseThrow(), 0.01);

    }



    @Test void cacaoOrganicoUsa25Jornales() {

        Lote cacao = new Lote("L-02", new Cacao("Nacional", true), 2.5, List.of(

                new Insumo("Urea 50 kg", 5, "saco", 32.50),

                new Insumo("Abono orgánico", 30, "saco", 9.80)));

        assertEquals(25, cacao.jornalesPorHectarea());

        var calc = new CalculadoraCostos(Estrategias.costoConManoDeObra());

        assertEquals(1612.75, calc.calcular(cacao).orElseThrow(), 0.01);

    }

}
