package ec.edu.uagraria.postcosecha;

import ec.edu.uagraria.postcosecha.alertas.*;
import ec.edu.uagraria.postcosecha.dominio.Producto;
import ec.edu.uagraria.postcosecha.fabrica.FabricaProductos;
import ec.edu.uagraria.postcosecha.fabrica.TipoProducto;
import java.util.ArrayList;
import java.util.List;



public class DemoTaller4 {

    public static void main(String[] args) {

        // 1. La fabrica crea los productos; nadie usa new sobre los records 

        Producto p = FabricaProductos.crear(

                TipoProducto.LOTE_FRUTA, "Frutas y hortalizas recibidas por lote", 120);

        System.out.println("Creado por la fabrica: " + p);

        System.out.println("Etiqueta: " + p.etiquetaTrazabilidad());



        // 2. El motor con las tres reglas del tema 

        MotorAlertas motor = new MotorAlertas();

        motor.agregarRegla(Reglas.mermaAlta());

        motor.agregarRegla(Reglas.proveedorReincidente());

        motor.agregarRegla(Reglas.camaraFueraTemperatura());



        // 3. Dos observadores: consola y bitacora 

        List<Alerta> bitacora = new ArrayList<>();

        motor.suscribir(a -> System.out.println(

                "[CONSOLA] " + a.tipo() + " en " + a.codigoOrigen() + ": " + a.detalle()));

        motor.suscribir(bitacora::add);



        // 4. Lecturas 

        // dispara MERMA_ALTA 

        motor.procesar(new Lectura(Magnitud.MERMA_DEL_LOTE, "LOT-0031", 13.2));

        // dispara PROVEEDOR_REINCIDENTE 

        motor.procesar(new Lectura(Magnitud.LOTES_RECHAZADOS_DEL_PROVEEDOR_EN_EL_MES, "PRV-0008", 3.0));

        // dispara CAMARA_FUERA_TEMPERATURA 

        motor.procesar(new Lectura(Magnitud.TEMPERATURA_DE_LA_CAMARA, "CAM-0001", 10.5));

        // en el umbral exacto: NO dispara 

        motor.procesar(new Lectura(Magnitud.MERMA_DEL_LOTE, "LOT-0031", 10.0));



        System.out.println("Alertas en bitacora: " + bitacora.size());

    }

} 