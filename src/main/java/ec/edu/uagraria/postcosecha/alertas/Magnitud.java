package ec.edu.uagraria.postcosecha.alertas;

/** Las magnitudes que vigila el motor de PostCosecha. */

public enum Magnitud {

    MERMA_DEL_LOTE("merma del lote", "%"),

    LOTES_RECHAZADOS_DEL_PROVEEDOR_EN_EL_MES("lotes rechazados del proveedor en el mes", "lotes"),

    TEMPERATURA_DE_LA_CAMARA("temperatura de la cámara", "°C");



    private final String nombre;

    private final String unidad;



    Magnitud(String nombre, String unidad) { this.nombre = nombre; this.unidad = unidad; }



    public String nombre() { return nombre; }



    public String unidad() { return unidad; }

}
