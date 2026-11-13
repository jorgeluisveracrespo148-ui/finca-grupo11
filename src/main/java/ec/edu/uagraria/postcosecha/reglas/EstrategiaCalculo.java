package ec.edu.uagraria.postcosecha.reglas;

import ec.edu.uagraria.postcosecha.dominio.Producto;

/** Taller 3: interfaz funcional. Una estrategia = una formula intercambiable. */
@FunctionalInterface
public interface EstrategiaCalculo {
    double calcular(Producto p);
}
