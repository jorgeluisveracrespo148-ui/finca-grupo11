package ec.uagraria.costos;



// Interfaz sellada: solo Banano, Cacao y Arroz pueden implementarla

public sealed interface Cultivo permits Banano, Cacao, Arroz {

    String nombreComun();

}
