package ec.uagraria.costos;



import ec.edu.uagraria.postcosecha.reglas.CalculadoraCostos;
import ec.edu.uagraria.postcosecha.reglas.Estrategias;

import java.util.List;



public class Main {

    public static void main(String[] args) {

        // Lote de prueba: 4 ha de banano Cavendish

        Lote lote = new Lote("L-01", new Banano("Cavendish"), 4.0, List.of(

                new Insumo("Urea 50 kg", 12, "saco", 32.50),

                new Insumo("Fungicida", 8, "litro", 21.75),

                new Insumo("Semilla certificada", 1, "lote", 180.00)));



        CalculadoraCostos calc = new CalculadoraCostos();

        System.out.println("Sin estrategia: " + calc.calcular(lote)); // Optional.empty



        calc.setEstrategia(Estrategias.costoDirecto());

        System.out.println("Costo directo: " + calc.calcular(lote).orElseThrow());



        calc.setEstrategia(Estrategias.costoConManoDeObra());

        System.out.println("Insumos + mano de obra: " + calc.calcular(lote).orElseThrow());



        calc.setEstrategia(Estrategias.costoPorHectarea());

        System.out.println("Costo por hectárea: " + calc.calcular(lote).orElseThrow());



        calc.setEstrategia(Estrategias.costoConSubsidioFertilizante(0.20));

        System.out.println("Con subsidio 20 % urea: "

                + CalculadoraCostos.redondear(calc.calcular(lote).orElseThrow()));



        calc.setEstrategia(Estrategias.conIva(Estrategias.costoConManoDeObra()));

        System.out.println("Con IVA 15 %: "

                + CalculadoraCostos.redondear(calc.calcular(lote).orElseThrow()));



        // Segundo lote: 2,5 ha de cacao Nacional orgánico

        Lote cacao = new Lote("L-02", new Cacao("Nacional", true), 2.5, List.of(

                new Insumo("Urea 50 kg", 5, "saco", 32.50),

                new Insumo("Abono orgánico", 30, "saco", 9.80)));

        System.out.println("Cacao orgánico - jornales/ha: " + cacao.jornalesPorHectarea());

        calc.setEstrategia(Estrategias.costoConManoDeObra());

        System.out.println("Cacao orgánico - insumos + mano de obra: "

                + CalculadoraCostos.redondear(calc.calcular(cacao).orElseThrow()));

    }

}