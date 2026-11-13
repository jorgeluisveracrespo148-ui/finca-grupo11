package ec.edu.uagraria.postcosecha;

import ec.edu.uagraria.postcosecha.dominio.*;
import ec.edu.uagraria.postcosecha.reglas.*;

/** Comprueba que el kit compila y funciona. Ejecutar antes de empezar el Taller 4. */
public class DemoNivelacion {
    public static void main(String[] args) {
        Producto a = new LoteFruta(Trazable.generarCodigo("cul", 1), "LoteFruta de prueba", 120, UnidadMedida.KILOGRAMO);
        Producto b = new LoteRechazado(Trazable.generarCodigo("ani", 1), "LoteRechazado de prueba", 1, UnidadMedida.UNIDAD, Calidad.EXTRA);
        Producto c = new InsumoAcopio(Trazable.generarCodigo("ins", 1), "InsumoAcopio de prueba", 5, UnidadMedida.KILOGRAMO);
        for (Producto p : java.util.List.of(a, b, c)) {
            System.out.println(Inventario.describir(p) + " -> " + p.etiquetaTrazabilidad());
        }
        CentroDeAcopio e = new CentroDeAcopio("0992345678001", "CentroDeAcopio de prueba", new CentroDeAcopio.Ubicacion("Guayas", "Milagro"));
        System.out.println(e.registrarRecepcion("X-01").descripcion());
        Calculadora calc = new Calculadora();
        System.out.println("Sin estrategia: " + calc.calcular(a));
        calc.usar(Estrategias.conIva(Estrategias.porcentajeMerma()));
        System.out.println("porcentajeMerma con IVA: " + calc.calcular(a).orElse(0.0));
    }
}
