import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DadosProfessores {

    private ArrayList<Professor> professores;

    public void adicionarProfessor(Scanner sc, ArrayList<Professor> professores) {
        try {
            System.out.println();
            System.out.println("DIGITE OS DADOS NECESSÁRIOS");
            System.out.print("NOME: ");
            String nome = sc.nextLine();
            System.out.print("IDADE: ");
            int idade = sc.nextInt();
            if (idade < 0) {
                System.out.println("ERRO: Idade não pode ser um valor negativo.");
                return;
            }
            sc.nextLine();
            System.out.print("SALÁRIO: ");
            double salario = sc.nextDouble();
            if (salario < 0) {
                System.out.println("ERRO: Salário não pode ser um valor negativo.");
                return;
            }
            sc.nextLine();
            Professor professor = new Professor(nome, idade, salario);
            professores.add(professor);
        } catch(InputMismatchException e) {
            System.out.println("ERRO: Entrada inválida. Por favor, tente novamente.");
        }
    }
    
}
