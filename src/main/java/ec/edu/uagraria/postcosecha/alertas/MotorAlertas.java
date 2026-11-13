package ec.edu.uagraria.postcosecha.alertas;

import java.util.ArrayList;

import java.util.List;



/** Sujeto del Observer: compone reglas y observadores. */

public class MotorAlertas {

    private final List<ReglaAlerta> reglas = new ArrayList<>();

    private final List<ObservadorAlertas> observadores = new ArrayList<>();



    public void agregarRegla(ReglaAlerta regla) { reglas.add(regla); }



    public void suscribir(ObservadorAlertas observador) { observadores.add(observador); }



    /** Evalua todas las reglas; devuelve cuantas alertas se publicaron. */

    public int procesar(Lectura lectura) {

        int publicadas = 0;

        for (ReglaAlerta regla : reglas) {

            var alerta = regla.evaluar(lectura);

            if (alerta.isPresent()) {

                observadores.forEach(o -> o.notificar(alerta.get()));

                publicadas++;

            }

        }

        return publicadas;

    }

}