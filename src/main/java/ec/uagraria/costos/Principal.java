package ec.uagraria.costos;

import java.util.List;

public class Principal {
    public static void main(String[] args) {
        Insumo urea = new Insumo("Urea 46%", 5.0, "sacos", 24.50);
        Insumo mup = new Insumo("Fungicida", 2.0, "litros", 18.00);
        Insumo semillaArroz = new Insumo("Semilla Certificada", 4.0, "quintales", 35.00);

        Lote lote1 = new Lote("L-01", new Banano("Cavendish"), 2.5, List.of(urea, mup));
        Lote lote2 = new Lote("L-02", new Cacao("Nacional", true), 4.0, List.of(urea));
        Lote lote3 = new Lote("L-03", new Arroz(2), 3.0, List.of(semillaArroz));

        List<Lote> lotes = List.of(lote1, lote2, lote3);

        EstrategiaCosto costoOperativo = (lote, costoJornal) ->
                lote.hectareas() * lote.jornalesPorHectarea() * costoJornal;

        EstrategiaCosto costoTotal = (lote, costoJornal) ->
                lote.costoInsumos() + costoOperativo.calcular(lote, costoJornal);

        double jornalBase = 25.0;

        System.out.println("=== REPORTE DE COSTOS DE LA FINCA (GRUPO 11) ===");
        for (Lote l : lotes) {
            System.out.println("--------------------------------------------------");
            System.out.println("Lote: " + l.codigo() + " | Cultivo: " + l.cultivo().nombreComun());
            System.out.println("Área: " + l.hectareas() + " ha | Jornales/ha: " + l.jornalesPorHectarea());
            System.out.println("Costo Insumos: $" + l.costoInsumos());
            System.out.println("Costo Operativo (Labores): $" + costoOperativo.calcular(l, jornalBase));
            System.out.println("Costo Total del Lote: $" + costoTotal.calcular(l, jornalBase));
        }
        System.out.println("--------------------------------------------------");
    }
}