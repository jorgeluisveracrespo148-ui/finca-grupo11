package ec.uagraria.costos;



import java.util.List;



public class Main {

    public static void main(String[] args) {

        // Control de los Pasos 2 y 3: lote de banano de 4 ha

        Lote lote = new Lote("L-01", new Banano("Cavendish"), 4.0, List.of(

                new Insumo("Urea 50 kg", 12, "saco", 32.50),

                new Insumo("Fungicida", 8, "litro", 21.75),

                new Insumo("Semilla certificada", 1, "lote", 180.00)));

        System.out.println("Costo de insumos: " + lote.costoInsumos());

        System.out.println("Jornales banano: " + lote.jornalesPorHectarea());



        // Cada rama del switch, con lotes sin insumos

        System.out.println("Jornales cacao orgánico: "

                + new Lote("L-02", new Cacao("Nacional", true), 1, List.of()).jornalesPorHectarea());

        System.out.println("Jornales cacao convencional: "

                + new Lote("L-03", new Cacao("CCN-51", false), 1, List.of()).jornalesPorHectarea());

        System.out.println("Jornales arroz 2 ciclos: "

                + new Lote("L-04", new Arroz(2), 1, List.of()).jornalesPorHectarea());

    }

}