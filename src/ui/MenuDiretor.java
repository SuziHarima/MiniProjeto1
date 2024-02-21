package ui;

import entities.Diretor;
import entities.Professor;
import util.DadosAlunos;
import util.DadosProfessores;
import util.Utilitarios;

import java.util.Scanner;


public class MenuDiretor extends Menu {
    private static DadosProfessores professores;
    private static DadosAlunos alunos;

    public static void diretorMenu(Diretor diretorAtual, DadosProfessores dadosProfessores, DadosAlunos dadosAlunos) {
        professores = dadosProfessores;
        alunos = dadosAlunos;
        diretor = diretorAtual;
        scanner = new Scanner(System.in);
        int resposta;
        do {
            System.out.println("-------------------------");
            System.out.println("1. Listar Alunos");
            System.out.println("2. Listar Professores");
            System.out.println("3. Adicionar Professor");
            System.out.println("4. Remover Professor");
            System.out.println("5. Promover Professor");
            System.out.println("9. Sair do Sistema");
            System.out.println("-------------------------");
            System.out.println("O que deseja fazer?: ");
            resposta = Utilitarios.validateInput();
            System.out.println("-------------------------");
            switch (resposta) {
                case 1:
                    alunos.listar();
                    break;
                case 2:
                    professores.listar();
                    break;
                case 3:
                    novoProfessor(professores);
                    break;
                case 4:
                    removeProfessor(professores);
                    break;
                case 5:
                    promoveProfessor(professores);
                    break;
                case 9:
                    System.out.println("Logoff efetuado. Por favor, faça o login novamente.\n");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (resposta != 9);
    }

    private static void novoProfessor(DadosProfessores professores) {
        try {
            Professor novoProfessor = new Professor(Utilitarios.inputNome(), Utilitarios.inputIdade());
            professores.adicionar(novoProfessor);
            System.out.println("Professor adicionado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao adicionar um professor. Verifique as informações e tente novamente!");
        }
    }
    private static void removeProfessor(DadosProfessores professores){
        try {
            professores.listar();
            System.out.println("Informe o Id do professor a ser removido: ");
            int idProfessor = Utilitarios.validateInput();
            professores.remover(idProfessor);
            System.out.println("Professor removido com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao remover um professor. Verifique as informações e tente novamente!");
        }
    }
    private static void promoveProfessor(DadosProfessores professores){
        try {
            professores.listar();
            System.out.println("Informe o Id do professor a ser promovido: ");
            int idProfessor = Utilitarios.validateInput();
            Professor professor = professores.buscar(idProfessor);
            professor.promover();
            System.out.println("Professor promovido com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao remover um professor. Verifique as informações e tente novamente!");
        }
    }
}
