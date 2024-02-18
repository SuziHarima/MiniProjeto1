public enum StatusMatricula {
    ATIVO(1), TRANCADO(2), FORMADO(3);

    private final int numero;

    StatusMatricula(int numero){
        this.numero = numero;
    }
}
