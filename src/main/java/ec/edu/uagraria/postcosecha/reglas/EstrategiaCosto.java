package ec.edu.uagraria.postcosecha.reglas;


import ec.uagraria.costos.Lote;

@FunctionalInterface

public interface EstrategiaCosto {

    double calcular(Lote lote);



    default String descripcion() {

        return "Estrategia de costo";

    }

}
