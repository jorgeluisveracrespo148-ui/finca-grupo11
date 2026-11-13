package ec.edu.uagraria.postcosecha.alertas;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;



class MotorAlertasTest {



    @BeforeEach

    void umbralesPorDefecto() {                 // el Singleton conserva estado entre pruebas

        Configuracion.INSTANCIA.cambiarMermaMaxima(10);

    }



    @Test

    @DisplayName("MERMA_ALTA se dispara por encima del umbral")

    void mermaAltaDispara() {

        var r = Reglas.mermaAlta()

                .evaluar(new Lectura(Magnitud.MERMA_DEL_LOTE, "LOT-0031", 13.2));

        assertTrue(r.isPresent());

        assertEquals(TipoAlerta.MERMA_ALTA, r.get().tipo());

    }



    @Test

    @DisplayName("MERMA_ALTA no se dispara en el umbral exacto")

    void mermaAltaNoDisparaEnElUmbral() {

        var r = Reglas.mermaAlta()

                .evaluar(new Lectura(Magnitud.MERMA_DEL_LOTE, "LOT-0031", 10));

        assertTrue(r.isEmpty());

    }



    @Test

    @DisplayName("Una regla ignora las lecturas de otra magnitud")

    void reglaIgnoraOtraMagnitud() {

        var r = Reglas.mermaAlta()

                .evaluar(new Lectura(Magnitud.LOTES_RECHAZADOS_DEL_PROVEEDOR_EN_EL_MES, "LOT-0031", 13.2));

        assertTrue(r.isEmpty());

    }



    @Test

    @DisplayName("El motor notifica a todos los observadores suscritos")

    void motorNotificaATodos() {

        MotorAlertas motor = new MotorAlertas();

        motor.agregarRegla(Reglas.mermaAlta());

        List<Alerta> a = new ArrayList<>(), b = new ArrayList<>();

        motor.suscribir(a::add);

        motor.suscribir(b::add);

        int n = motor.procesar(new Lectura(Magnitud.MERMA_DEL_LOTE, "LOT-0031", 13.2));

        assertEquals(1, n);

        assertEquals(1, a.size());

        assertEquals(1, b.size());

    }



    // Repetir el par dispara / no dispara para PROVEEDOR_REINCIDENTE (3 sí · 2 no)

    // y para CAMARA_FUERA_TEMPERATURA (10.5 sí · 8 no)

}
