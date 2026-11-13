
# PostCosecha

Sistema de gestión de productos y control de mermas y calidad en centros de acopio.

## Taller 4 - Refactorización SOLID y patrones de diseño

**Grupo:** G11 - PostCosecha

**Asignatura:** Programación 3

## Diagnóstico Taller 4

## Diagnóstico Taller 4
~~~~
# finca-grupo11 — G11 PostCosecha

Control de mermas y calidad en centros de acopio.
**Taller 4:** refactorización SOLID + Factory/Observer (motor de alertas), con pruebas JUnit 5 y entrega por pull request.

## Diagnóstico Taller 4

Antes de refactorizar se revisó el código con *Edit → Find → Find in Files*.

| Pregunta | Respuesta |
|---|---|
| ¿Qué clase tiene más de un motivo para cambiar? | La calculadora del Taller 3 calculaba la merma y además imprimía el resultado por consola: cambiaba si cambiaba la fórmula y también si cambiaba el formato de salida. |
| ¿Dónde se usa `new` sobre los records del dominio? | `new LoteFruta(` aparece en `FabricaProductos.java` (1) y `DemoNivelacion.java` (1). `new LoteRechazado(` aparece en `FabricaProductos.java` (1), `DemoNivelacion.java` (1) y dentro del propio record, en `LoteRechazado.conEstado` (1, devuelve una copia inmutable). `new InsumoAcopio(` aparece en `FabricaProductos.java` (1) y `DemoNivelacion.java` (1). La creación quedó centralizada en `FabricaProductos`. |
| ¿Hay herencia que exista solo para reutilizar código? | No. La única coincidencia de `extends` es `public sealed interface Producto extends Trazable`, que es una interfaz que extiende otra interfaz para ampliar un contrato, no para reutilizar código. Los records implementan `Producto`. |

## Estructura de paquetes

`src/main/java/ec/edu/uagraria/postcosecha/`

- `dominio`: Trazable, Producto, LoteFruta, LoteRechazado, InsumoAcopio, UnidadMedida, Calidad, CentroDeAcopio, Inventario y demás clases del Taller 2
- `reglas`: EstrategiaCalculo, Estrategias, Calculadora (Taller 3)
- `fabrica`: TipoProducto, FabricaProductos
- `alertas`: Lectura, Alerta, ReglaAlerta, ObservadorAlertas, MotorAlertas, Magnitud, TipoAlerta, Configuracion, Reglas

## Tabla SOLID

| Principio | Clase real | Cómo se cumple |
|---|---|---|
| **S** — Responsabilidad única | `Reglas`, `MotorAlertas` | `Reglas` solo decide si una lectura genera alerta; `MotorAlertas` solo coordina reglas y observadores. Mostrar o guardar la alerta lo hacen los observadores, no el motor. |
| **O** — Abierto/cerrado | `ReglaAlerta` | Para una alerta nueva se agrega una regla nueva sin modificar `MotorAlertas`. |
| **L** — Sustitución de Liskov | `Producto` (sealed) y sus records | `LoteFruta`, `LoteRechazado` e `InsumoAcopio` se usan donde se espera un `Producto` sin romper el comportamiento. |
| **I** — Segregación de interfaces | `ReglaAlerta`, `ObservadorAlertas` | Son interfaces de un solo método; cada clase depende solo de lo que necesita. |
| **D** — Inversión de dependencias | `MotorAlertas` | Depende de las abstracciones `ReglaAlerta` y `ObservadorAlertas`, no de reglas ni observadores concretos. |

## Patrones aplicados

- **Singleton** — `Configuracion` (enum): los umbrales están en un solo lugar y son configurables.
- **Factory** — `FabricaProductos`: es el único lugar donde se hace `new` sobre los records del dominio; su `switch` es exhaustivo y no tiene `default`.
- **Strategy** — `ReglaAlerta`: cada regla es una lambda intercambiable.
- **Observer** — `MotorAlertas` / `ObservadorAlertas`: la consola y la bitácora se suscriben a las alertas.

## Umbrales elegidos

| Umbral | Valor | Magnitud | Alerta |
|---|---|---|---|
| `mermaMaxima` | 10 % | merma del lote | `MERMA_ALTA` |
| `rechazosTolerados` | 2 lotes por mes | lotes rechazados del proveedor en el mes | `PROVEEDOR_REINCIDENTE` |
| `temperaturaMaxima` | 8 °C | temperatura de la cámara | `CAMARA_FUERA_TEMPERATURA` |

**Justificación.** Se tomaron como valores de referencia del taller y se dejaron en `Configuracion` para poder ajustarlos sin tocar las reglas. Una merma de hasta 10 % se considera pérdida normal del manejo de fruta en un centro de acopio; por encima de ese valor el lote requiere revisión porque afecta el rendimiento y la calidad del producto. Se toleran hasta 2 lotes rechazados de un mismo proveedor en el mes, pues un rechazo aislado puede deberse a una causa puntual; a partir del tercero se trata de un patrón y el proveedor se marca como reincidente. La cámara se vigila hasta 8 °C porque por encima de esa temperatura la fruta y las hortalizas aceleran su deterioro y se acorta su vida útil. Las tres reglas comparan con `>` estricto: un valor exactamente igual al umbral no dispara la alerta.

## Prueba del Singleton

En `DemoTaller4`, antes de la última lectura (merma = 10.0 %), se agregó:

```java
Configuracion.INSTANCIA.cambiarMermaMaxima(8);
```

Resultado: la lectura de 10.0 %, que con el umbral de 10 no disparaba, ahora dispara `MERMA_ALTA` con umbral 8.0, y la bitácora termina en **4** alertas en lugar de 3. No se modificó ninguna regla: solo cambió el valor en `Configuracion`. Esto demuestra que el umbral vive en un único lugar compartido.

```
[CONSOLA] MERMA_ALTA en LOT-0031: merma del lote = 10.0 % (umbral 8.0)
Alertas en bitacora: 4
```

## Ejecución de la demo (`DemoTaller4`)

```
Creado por la fabrica: LoteFruta[codigo=CUL-0001, nombre=Frutas y hortalizas recibidas por lote, cantidad=120.0, unidad=KILOGRAMO]
Etiqueta: UAE-CUL-0001
[CONSOLA] MERMA_ALTA en LOT-0031: merma del lote = 13.2 % (umbral 10.0)
[CONSOLA] PROVEEDOR_REINCIDENTE en PRV-0008: lotes rechazados del proveedor en el mes = 3.0 lotes (umbral 2.0)
[CONSOLA] CAMARA_FUERA_TEMPERATURA en CAM-0001: temperatura de la cámara = 10.5 °C (umbral 8.0)
Alertas en bitacora: 3
```

## Pruebas

Tests run: 9, Failures: 0, Errors: 0, Skipped: 0, BUILD SUCCESS: 2.
