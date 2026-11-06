public sealed interface Cultivo permits Banano, Cacao, Arroz {
    String nombreComun();
}

<<<<<<< HEAD
@FunctionalInterface
public interface EstrategiaCosto {
    double calcular(Lote lote);
}
=======
public record Banano(String variedad) implements Cultivo {
    @Override public String nombreComun() { return "Banano " + variedad; }
}

public record Cacao(String variedad, boolean organico) implements Cultivo {
    @Override public String nombreComun() { return "Cacao " + variedad; }
}

public record Arroz(int ciclosPorAnio) implements Cultivo {
    @Override public String nombreComun() {
        return "Arroz (" + ciclosPorAnio + " ciclos/año)";
    }
}
>>>>>>> e1756378376ea4fd45761e7af06a18343291e621
