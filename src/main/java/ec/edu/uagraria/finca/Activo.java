package ec.edu.uagraria.finca;

public sealed interface Activo permits Producto, Cultivo, Animal {
    String codigo();
}


