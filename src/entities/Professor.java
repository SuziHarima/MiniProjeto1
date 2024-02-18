package entities;
public class Professor extends Funcionario {
    private int tempoTrabalho = 0;

    public Professor(String nome, int idade, int tempoTrabalho) {
        this.setNome(nome);
        this.setIdade(idade);
        this.tempoTrabalho = tempoTrabalho;
    }

    public Professor(String nome, int idade) {
        this.setNome(nome);
        this.setIdade(idade);
    }

    public int getTempoTrabalho() {
        return tempoTrabalho;
    }

    public void setTempoTrabalho(int tempoTrabalho) {
        this.tempoTrabalho = tempoTrabalho;
    }

    @Override
    public String toString() {
        return "Prof.: " + getNome() + ", " + getIdade() + " anos - Tempo de trabalho: " + tempoTrabalho + " anos.";
    }

}