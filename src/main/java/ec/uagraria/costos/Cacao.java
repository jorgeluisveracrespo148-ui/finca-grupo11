public sealed interface Cultivo permits Banano, Cacao, Arroz {
    String nombreComun();
}

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
