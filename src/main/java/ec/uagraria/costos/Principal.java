package ec.uagraria.costos;

import java.util.List;

public class Principal {
    public static void main(String[] args) {
        Lote lote1 = new Lote("L-01", new Arroz(2), 5.0, List.of());
        Lote lote2 = new Lote("L-02", new Banano("Cavendish"), 4.0, List.of());
        Lote lote3 = new Lote("L-03", new Cacao("Nacional", true), 3.0, List.of());

        List<Lote> lotes = List.of(lote1, lote2, lote3);

        // Definición correcta de las estrategias usando lambdas
        EstrategiaCosto costoOperativo = (lote) -> lote.hectareas() * 25.0;

        EstrategiaCosto costoTotal = (lote) -> lote.hectareas() * 30.0;

        System.out.println("=== REPORTE DE COSTOS DE LA FINCA ===");
        for (Lote l : lotes) {
            System.out.println("Lote: " + l.codigo());
        }
    }
}