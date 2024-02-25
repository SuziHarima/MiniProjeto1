package entities;

public class Curso {

    private String nome;
    private final Professor professor;

    public Curso(String nome, Professor professor) {
        this.nome = nome;
        this.professor = professor;
    }

    public Curso(Professor professor) {
        this.professor = professor;
    }

    public String getNome() {
        return nome;
    }

    public Professor getProfessor() {
        return professor;
    }

    @Override
    public String toString() {
        return nome + " (" + professor + ")";
    }
}