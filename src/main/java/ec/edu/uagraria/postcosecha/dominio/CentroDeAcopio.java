package ec.edu.uagraria.postcosecha.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/** Taller 2: entidad mutable. Su identidad de negocio es RUC del centro de acopio: solo ese campo entra en equals/hashCode. */
public class CentroDeAcopio implements Trazable {
    private final String rucCentroAcopio;
    private String nombre;
    private final Ubicacion ubicacion;
    private final List<Recepcion> recepcions = new ArrayList<>();

    /** Clase anidada estatica: no necesita una instancia de CentroDeAcopio. */
    public static final class Ubicacion {
        private final String provincia;
        private final String canton;
        public Ubicacion(String provincia, String canton) {
            this.provincia = Objects.requireNonNull(provincia);
            this.canton = Objects.requireNonNull(canton);
        }
        @Override public String toString() { return canton + ", " + provincia; }
    }

    /** Clase interna: pertenece a UNA instancia y lee sus campos. */
    public final class Recepcion {
        private final String codigo;
        private Recepcion(String codigo) { this.codigo = Objects.requireNonNull(codigo); }
        public String descripcion() { return codigo + " - " + nombre + ", " + ubicacion; }
    }

    public CentroDeAcopio(String rucCentroAcopio, String nombre, Ubicacion ubicacion) {
        this.rucCentroAcopio = Objects.requireNonNull(rucCentroAcopio);
        this.nombre = Objects.requireNonNull(nombre);
        this.ubicacion = Objects.requireNonNull(ubicacion);
    }

    public Recepcion registrarRecepcion(String codigo) {
        Recepcion x = new Recepcion(codigo);
        recepcions.add(x);
        return x;
    }

    public List<Recepcion> recepcions() { return List.copyOf(recepcions); }   // copia defensiva

    public void renombrar(String nuevo) { this.nombre = Objects.requireNonNull(nuevo); }

    @Override public String codigo() { return rucCentroAcopio; }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CentroDeAcopio otra)) return false;
        return rucCentroAcopio.equals(otra.rucCentroAcopio);
    }

    @Override public int hashCode() { return Objects.hash(rucCentroAcopio); }

    @Override public String toString() {
        return "CentroDeAcopio[rucCentroAcopio=%s, nombre=%s, recepcions=%d]".formatted(rucCentroAcopio, nombre, recepcions.size());
    }
}
