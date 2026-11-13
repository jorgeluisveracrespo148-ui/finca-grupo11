package ec.edu.uagraria.postcosecha.dominio;

/** Taller 2: enumeracion con comportamiento por constante. */
public enum Calidad {
    EXTRA     { @Override public boolean esNormal() { return true;  } },
    PRIMERA   { @Override public boolean esNormal() { return false; } },
    SEGUNDA   { @Override public boolean esNormal() { return false; } },
    RECHAZO   { @Override public boolean esNormal() { return false; } },
    NORMAL    { @Override public boolean esNormal() { return true;  } };

    public abstract boolean esNormal();
}
