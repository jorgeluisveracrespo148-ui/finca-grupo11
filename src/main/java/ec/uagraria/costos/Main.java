package ec.uagraria.costos;



public class Main {

    public static void main(String[] args) {

        // Control del Paso 1: costo de un insumo

        Insumo urea = new Insumo("Urea 50 kg", 12, "saco", 32.50);

        System.out.println("Costo de la urea: " + urea.costo());



        // Control de la validación: debe rechazar una cantidad negativa

        try {

            new Insumo("Fungicida", -1, "litro", 21.75);

        } catch (IllegalArgumentException e) {

            System.out.println("Validación correcta: " + e.getMessage());

        }

    }

}