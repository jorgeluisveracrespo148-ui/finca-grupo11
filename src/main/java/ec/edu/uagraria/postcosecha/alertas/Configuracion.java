package ec.edu.uagraria.postcosecha.alertas;

/** SINGLETON: los umbrales del tema, en un solo lugar y configurables. */

public enum Configuracion {

    INSTANCIA;



    private double mermaMaxima = 10.0;

    private double rechazosTolerados = 2.0;

    private double temperaturaMaxima = 8.0;



    public double mermaMaxima() { return mermaMaxima; }



    public void cambiarMermaMaxima(double nuevo) { mermaMaxima = nuevo; }



    public double rechazosTolerados() { return rechazosTolerados; }



    public void cambiarRechazosTolerados(double nuevo) { rechazosTolerados = nuevo; }



    public double temperaturaMaxima() { return temperaturaMaxima; }



    public void cambiarTemperaturaMaxima(double nuevo) { temperaturaMaxima = nuevo; }

}