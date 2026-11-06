package ec.uagraria.costos;



public record Cacao(String variedad, boolean organico) implements Cultivo {

    @Override public String nombreComun() { return "Cacao " + variedad; }
<<<<<<< HEAD

=======
}
>>>>>>> e1756378376ea4fd45761e7af06a18343291e621
}
