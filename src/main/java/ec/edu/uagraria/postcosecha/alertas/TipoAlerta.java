package ec.edu.uagraria.postcosecha.alertas;

public enum TipoAlerta {

    MERMA_ALTA("Lote con merma por encima del umbral"),

    PROVEEDOR_REINCIDENTE("Proveedor con varios lotes rechazados"),

    CAMARA_FUERA_TEMPERATURA("Cámara de almacenamiento fuera de rango");



    private final String descripcion;



    TipoAlerta(String descripcion) { this.descripcion = descripcion; }



    public String descripcion() { return descripcion; }

}
