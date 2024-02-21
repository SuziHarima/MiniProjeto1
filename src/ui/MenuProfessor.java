package ui;

import entities.Professor;
import util.DadosTurmas;
import util.Utilitarios;

import java.util.Scanner;


public class MenuProfessor extends Menu{
    /*
    Professor
         listar alunos,
         adicionar aluno,
         remover aluno da sua turma
     */
    public static void professorMenu(Professor professorAtual, DadosTurmas turmas) {
        professor = professorAtual;

        scanner = new Scanner(System.in);
        int resposta;
        do {
            System.out.println("-------------------------");

            System.out.println("1. Listar Turmas");
            System.out.println("1. Adicionar Turma");
            System.out.println("1. Listar Alunos");
            System.out.println("2. Adicionar Aluno");
            System.out.println("3. Remover Aluno");
            System.out.println("9. Sair do Sistema");
            System.out.println("-------------------------");
            System.out.println("O que deseja fazer?: ");
            resposta = Utilitarios.validateInput();
            System.out.println("-------------------------");
            switch (resposta) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 9:
                    System.out.println("Logoff efetuado. Por favor, faça o login novamente.\n");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (resposta != 9);
    }
}
