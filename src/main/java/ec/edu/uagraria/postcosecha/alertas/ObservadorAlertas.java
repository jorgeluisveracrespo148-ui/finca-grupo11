package ec.edu.uagraria.postcosecha.alertas;

/** OBSERVER: quien quiera enterarse de una alerta. */

@FunctionalInterface

public interface ObservadorAlertas {

    void notificar(Alerta alerta);

}
