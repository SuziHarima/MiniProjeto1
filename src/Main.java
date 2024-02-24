import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Professor novoProfessor = new Professor("Fulano de Tal", 40, 2);

        System.out.println(novoProfessor);

        sc.close();

        ArrayList<Curso> listaCursos = new ArrayList<Curso>();

        Diretor novoDiretor = new Diretor("Joselito", 2);

        System.out.println(novoDiretor);

    }
}
