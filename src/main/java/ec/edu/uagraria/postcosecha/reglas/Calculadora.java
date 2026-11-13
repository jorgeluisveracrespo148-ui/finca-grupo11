package ec.edu.uagraria.postcosecha.reglas;

import ec.edu.uagraria.postcosecha.dominio.Producto;
import java.util.Optional;

/** Taller 3: contexto del Strategy; sin estrategia devuelve Optional vacio, nunca null. */
public class Calculadora {
    private EstrategiaCalculo estrategia;

    public void usar(EstrategiaCalculo e) { this.estrategia = e; }

    public Optional<Double> calcular(Producto p) {
        return estrategia == null ? Optional.empty() : Optional.of(estrategia.calcular(p));
    }
}

