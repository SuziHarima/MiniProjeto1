import java.util.ArrayList;
import java.util.Scanner;

public class Aluno {
    private String nome;
    private int idade;

    StatusMatricula inicial = StatusMatricula.valueOf("ATIVO");

    public Aluno(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public Aluno(String nome) {
        this.nome = nome;
    }

    public Aluno(int idade) {
        this.idade = idade;
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

    public static void listarCursos(ArrayList<Curso> listaCursos){
        System.out.println("\n Cursos Matriculados: ");
        for (int i = 0; i < listaCursos.size(); i++) {
            System.out.println(i + " - " + listaCursos.get(i).getNome());
        }
    }

    public static void adicionarCursos(Scanner scanner, ArrayList<Curso> listaCursos){
        System.out.println("Digite curso para adicionar: ");
        String nomeCurso = scanner.next();
        Curso curso = new Curso();
        listaCursos.add(curso);
    }

    public static void removerCursos(Scanner scanner, ArrayList<Curso> listaCursos){
        listarCursos(scanner, listaCursos);
        System.out.println("Selecione o número do curso para ser removido: ");
        int indiceCurso = scanner.nextInt();
        listaCursos.remove(indiceCurso);
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", inicial=" + inicial +
                '}';
    }
}
