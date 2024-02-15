import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Professor novoProfessor = new Professor("Fulano de Tal", 40, 2);

        System.out.println(novoProfessor);

        sc.close();

    }
}
