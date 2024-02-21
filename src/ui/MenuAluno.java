package ui;

import entities.Aluno;
import entities.Curso;
import util.DadosCursos;
import util.Utilitarios;

import java.util.Scanner;


public class MenuAluno extends Menu {

    public static void alunoMenu(Aluno alunoAtual, DadosCursos dadosCursos) {
        aluno = alunoAtual;
        cursos = dadosCursos.getLista();
        scanner = new Scanner(System.in);
        int resposta;
        do {
            System.out.println("-------------------------");
            System.out.println("1. Listar Cursos");
            System.out.println("2. Adicionar Curso");
            System.out.println("3. Remover Curso");
            System.out.println("4. Alterar Status Curso");
            System.out.println("9. Sair do Sistema");
            System.out.println("-------------------------");
            System.out.println("O que deseja fazer?: ");
            resposta = Utilitarios.validateInput();
            System.out.println("-------------------------");
            switch (resposta) {
                case 1:
                    System.out.println("Cursos Matriculados: ");
                    aluno.listarCursos();
                    break;
                case 2:
                    matricular();
                    break;
                case 3:
                    desistir();
                    break;
                case 4:
                    alterarStatus();
                    break;
                case 9:
                    System.out.println("Logoff efetuado. Por favor, faça o login novamente.\n");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (resposta != 9);
    }

    private static Curso novoCurso() {
        System.out.println("Os cursos disponíveis são estes.");
        for (int i = 0; i < cursos.size(); i++) {
            System.out.println((i + 1) + " - " + cursos.get(i).getNome());
        }
        System.out.println("Selecione o Curso:");
        scanner = new Scanner(System.in);
        return cursos.get(Utilitarios.validateInput() - 1);
    }

    private static void matricular() {
        System.out.println("Deseja matricular-se em um novo Curso");
        Curso curso = novoCurso();
        if (curso == null)
            return;
        aluno.adicionarCurso(curso);
        System.out.println("Matricula realizada no curso " + curso.getNome());
    }

    private static Curso cursoExistente() {
        aluno.listarCursos();
        System.out.println("Selecione o Curso:");
        scanner = new Scanner(System.in);
        return aluno.getListaCursos().get(Utilitarios.validateInput() - 1);
    }

    private static void desistir() {
        System.out.println("Deseja cancelar um Curso registrado");
        Curso curso = cursoExistente();
        if (curso == null)
            return;
        aluno.removerCurso(curso);
        System.out.println("Curso " + curso.getNome() + " removido das suas matriculas");
    }

    private static void alterarStatus() {
        System.out.println("Deseja " + (aluno.isAtivo() ? "trancar" : "ativar") + " sua conta? ('S' para Sim ou 'N' para Não)");
        scanner = new Scanner(System.in);
        String resposta = scanner.nextLine();
        if (resposta.equalsIgnoreCase("N"))
            return;

        aluno.setAtivo(!aluno.isAtivo());

        System.out.println("Sua conta foi " + (!aluno.isAtivo() ? "in" : "") + "ativada com sucesso!");
    }
}
