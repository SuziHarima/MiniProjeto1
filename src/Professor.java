public class Professor {
    private String nome;
    private int idade;
    private int tempoTrabalho = 0;

    public Professor(String nome, int idade, int tempoTrabalho) {
        this.nome = nome;
        this.idade = idade;
        this.tempoTrabalho = tempoTrabalho;
    }

    public Professor(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public Professor() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getTempoTrabalho() {
        return tempoTrabalho;
    }

    public void setTempoTrabalho(int tempoTrabalho) {
        this.tempoTrabalho = tempoTrabalho;
    }

    @Override
    public String toString() {
        return "Professor: " + nome + ", " + idade + " anos - Tempo de trabalho: " + tempoTrabalho + " anos.";
    }
}
