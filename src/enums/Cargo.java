package enums;

/**
 * Cargo do Funcionário
 */
public enum Cargo {
    INICIANTE(1,"Iniciante"),
    EXPERIENTE(2,"Experiente"),
    AVANCADO(3,"Avançado");

    private final int valor;
    private final String texto;

    Cargo(int valor, String texto){
        this.valor = valor;
        this.texto = texto;
    }
}
