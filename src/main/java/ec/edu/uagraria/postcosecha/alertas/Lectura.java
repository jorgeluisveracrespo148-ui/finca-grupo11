package ec.edu.uagraria.postcosecha.alertas;

/** Una medición del dominio: que se midio, sobre que elemento y cuanto.*/
public record Lectura(Magnitud magnitud, String codigoOrigen, double valor){}



