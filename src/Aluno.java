import java.util.ArrayList;

public class Aluno {
    private String nome;
    private int idade;
    private ArrayList<Curso> listaCursos;

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public Aluno(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
        this.listaCursos = new ArrayList<>();
    }

    public void listarCursos() {
        System.out.println("\n Cursos Matriculados: ");
        for (int i = 0; i < listaCursos.size(); i++) {
            System.out.println((i + 1) + " - " + listaCursos.get(i));
        }
    }

    public void adicionarCursos(Curso curso) {
        if (curso != null)
            listaCursos.add(curso);
    }

    public void removerCursos(Curso curso) {
        if (curso != null)
            listaCursos.remove(curso);
    }

    @Override
    public String toString() {
        return "Aluno: " + nome + " - Idade: " + idade + " anos";
    }
}