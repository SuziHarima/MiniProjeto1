import java.util.ArrayList;
import java.util.Scanner;

public class Aluno {
    public String nome;
    public int idade;


    public static void listarCursos(Scanner scanner, ArrayList<Curso> listaCursos){
        System.out.println("\n Cursos Matriculados: ");
        for (int i = 0; i < listaCursos.size(); i++) {
            System.out.println(i + " - " + listaCursos.get(i).nome);
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

}
