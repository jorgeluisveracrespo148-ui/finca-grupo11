package ec.edu.uagraria.postcosecha.alertas;


import java.util.Optional;

/** Las tres reglas del tema, escritas como lambdas. */
public final class Reglas {

    private Reglas() { }

    /** MERMA_ALTA: merma del lote > mermaMaxima. */
    public static ReglaAlerta mermaAlta() {
        return l -> {
            double umbral = Configuracion.INSTANCIA.mermaMaxima();
            boolean aplica = l.magnitud() == Magnitud.MERMA_DEL_LOTE;

            if (aplica && l.valor() > umbral) {
                String detalle = l.magnitud().nombre() + " = " + l.valor()
                        + " " + l.magnitud().unidad() + " (umbral " + umbral + ")";

                return Optional.of(
                        new Alerta(TipoAlerta.MERMA_ALTA, l.codigoOrigen(), detalle)
                );
            }

            return Optional.empty();
        };
    }

    /** PROVEEDOR_REINCIDENTE: lotes rechazados del proveedor en el mes > rechazosTolerados. */
    public static ReglaAlerta proveedorReincidente() {
        return l -> {
            double umbral = Configuracion.INSTANCIA.rechazosTolerados();
            boolean aplica = l.magnitud() == Magnitud.LOTES_RECHAZADOS_DEL_PROVEEDOR_EN_EL_MES;

            if (aplica && l.valor() > umbral) {
                String detalle = l.magnitud().nombre() + " = " + l.valor()
                        + " " + l.magnitud().unidad() + " (umbral " + umbral + ")";

                return Optional.of(
                        new Alerta(TipoAlerta.PROVEEDOR_REINCIDENTE, l.codigoOrigen(), detalle)
                );
            }

            return Optional.empty();
        };
    }

    /** CAMARA_FUERA_TEMPERATURA: temperatura de la cámara > temperaturaMaxima. */
    public static ReglaAlerta camaraFueraTemperatura() {
        return l -> {
            double umbral = Configuracion.INSTANCIA.temperaturaMaxima();
            boolean aplica = l.magnitud() == Magnitud.TEMPERATURA_DE_LA_CAMARA;

            if (aplica && l.valor() > umbral) {
                String detalle = l.magnitud().nombre() + " = " + l.valor()
                        + " " + l.magnitud().unidad() + " (umbral " + umbral + ")";

                return Optional.of(
                        new Alerta(TipoAlerta.CAMARA_FUERA_TEMPERATURA, l.codigoOrigen(), detalle)
                );
            }

            return Optional.empty();
        };
    }
}

