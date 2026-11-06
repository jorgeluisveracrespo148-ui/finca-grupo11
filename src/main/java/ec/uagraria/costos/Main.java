package ec.uagraria.costos;



import java.util.List;



public class Main {

    public static void main(String[] args) {

        Lote lote = new Lote("L-01", new Banano("Cavendish"), 4.0, List.of(

                new Insumo("Urea 50 kg", 12, "saco", 32.50),

                new Insumo("Fungicida", 8, "litro", 21.75),

                new Insumo("Semilla certificada", 1, "lote", 180.00)));



        // Control de los Pasos 4 y 5: cada estrategia se usa directamente

        EstrategiaCosto directo = Estrategias.costoDirecto();

        System.out.println("Directo: " + directo.calcular(lote));

        System.out.println("Mano de obra: " + Estrategias.costoConManoDeObra().calcular(lote));

        System.out.println("Por hectárea: " + Estrategias.costoPorHectarea().calcular(lote));

        System.out.println("Subsidio 20 %: "

                + Estrategias.costoConSubsidioFertilizante(0.20).calcular(lote));



        // Una lambda escrita aquí mismo también es una EstrategiaCosto

        EstrategiaCosto propia = l -> l.hectareas() * 100;

        System.out.println("Lambda propia (100 USD/ha): " + propia.calcular(lote));

    }

}