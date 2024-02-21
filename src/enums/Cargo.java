package enums;

/**
 * Cargo do Funcionário
 */
public enum Cargo {
    INICIANTE(1,'I',"Iniciante"),
    EXPERIENTE(2,'E',"Experiente"),
    AVANCADO(3,'A',"Avançado");

    private final int valor;
    private final char sigla;
    private final String texto;

    Cargo(int valor, char sigla, String texto){
        this.valor = valor;
        this.sigla = sigla;
        this.texto = texto;
    }
    public static Cargo getByNome(String nome){
        return Cargo.valueOf(nome);
    }
    public static Cargo getBySigla(char sigla){
        for(Cargo c: Cargo.values()){
            if(c.sigla == sigla)
                return c;
        }
        return null;
    }

    public static void list() {
        System.out.println("Lista de Cargos: ");
        for (int i = 0; i < Cargo.values().length; i++) {
            Cargo cargo = Cargo.values()[i];
            System.out.println(cargo.texto + " ("+cargo.sigla+')');
        }
    }

    @Override
    public String toString() {
        return texto;
    }
}
