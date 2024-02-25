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

    public void listarProfessores(ArrayList<Professor> professores) {
        System.out.println();
        for (int i = 0; i < professores.size(); i++) {
            System.out.println(i + " - " + professores.get(i).getNome());
        }
        System.out.println();
    }

    public void removerProfessor(Scanner sc, ArrayList<Professor> professores) {
        listarProfessores(professores);
        try {
            System.out.print("DIGITE O NÚMERO RESPECTIVO AO PROFESSOR QUE DESEJA REMOVER: ");
            int indice = sc.nextInt();
            sc.nextLine();
            professores.remove(indice);
        } catch(IndexOutOfBoundsException e) {
            System.out.println("ERRO: Índice inválido. Por favor, tente novamente.");
        } catch(InputMismatchException e) {
            System.out.println("ERRO: Entrada inválida. Por favor, tente novamente.");
        }
    }

    public void buscarProfessoresID(Scanner sc, ArrayList<Professor> professores) {
        listarProfessores(professores);
        try {
            System.out.print("DIGITE O NÚMERO RESPECTIVO AO PROFESSOR QUE DESEJA BUSCAR: ");
            int indice = sc.nextInt();
            sc.nextLine();
            System.out.println();
            System.out.println("PROFESSOR: " + professores.get(indice).getNome());
            System.out.println("IDADE: " + professores.get(indice).getIdade());
            System.out.println("SALÁRIO: " + professores.get(indice).getSalario());
            System.out.println("CARGO: " + professores.get(indice).getCargo());
            System.out.println("TEMPO DE CARGO: " + professores.get(indice).getTempoCargo());
        } catch(IndexOutOfBoundsException e) {
            System.out.println("ERRO: Índice inválido. Por favor, tente novamente.");
        } catch(InputMismatchException e) {
            System.out.println("ERRO: Entrada inválida. Por favor, tente novamente.");
        }
    }

}