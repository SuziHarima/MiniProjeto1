package ui;

import entities.Aluno;
import entities.Professor;
import entities.Turma;
import util.DadosAlunos;
import util.DadosTurmas;
import util.Utilitarios;

import java.util.Scanner;


public class MenuProfessor extends Menu{

    public static void professorMenu(Professor professorAtual, DadosAlunos dadosAlunos, DadosTurmas dadosTurmas) {
        professor = professorAtual;
        alunos = dadosAlunos;
        turmas = dadosTurmas;

        scanner = new Scanner(System.in);
        int resposta;
        do {
            System.out.println("-------------------------");
            System.out.println("1. Listar Alunos");
            System.out.println("2. Adicionar Aluno");
            System.out.println("3. Remover Aluno");
            System.out.println("4. Formar Aluno");
            System.out.println("9. Sair do Sistema");
            System.out.println("-------------------------");
            System.out.println("O que deseja fazer?: ");
            resposta = Utilitarios.validateInput();
            System.out.println("-------------------------");
            switch (resposta) {
                case 1:
                    listarAlunos();
                    break;
                case 2:
                    adicionarAluno();
                    break;
                case 3:
                    removerAluno();
                    break;
                case 4:
                    formarAluno();
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

    private static void adicionarAluno(){
        try{
            turmas.listarByProf(professor.getNome());
            System.out.println("Informe a Turma que deseja manipular: ");
            int idTurma = Utilitarios.validateInput() - 1;
            Turma turma = turmas.getListaByProf(professor.getNome()).get(idTurma);
            alunos.listar();
            System.out.println("Informe o Id do aluno a ser adicionado nesta Turma: ");
            int idAluno = Utilitarios.validateInput() - 1;
            Aluno aluno = alunos.buscar(idAluno);
            turma.adicionarAluno(aluno);
            System.out.println("Aluno adicionado à Turma com sucesso!");
        }catch (Exception e){
            System.out.println("Erro ao formar um Aluno. Verifique as informações e tente novamente!");
        }
    }
    private static void removerAluno(){
        try{
            turmas.listarByProf(professor.getNome());
            System.out.println("Informe a Turma que deseja manipular: ");
            int idTurma = Utilitarios.validateInput() - 1;
            Turma turmaAtual = turmas.getListaByProf(professor.getNome()).get(idTurma);
            turmaAtual.listarAlunos();
            System.out.println("Informe o Id do aluno a ser removido desta Turma: ");
            int idAluno = Utilitarios.validateInput() - 1;
            turmaAtual.removerAluno(idAluno);
            System.out.println("Aluno removido da Turma com sucesso!");
        }catch (Exception e){
            System.out.println("Erro ao desvincular um Aluno de Turma. Verifique as informações e tente novamente!");
        }
    }
    private static void listarAlunos(){
        try{
            turmas.listarByProf(professor.getNome());
            System.out.println("Informe o Id da turma: ");
            int idTurma = Utilitarios.validateInput() - 1;
            Turma turmaAtual = turmas.getListaByProf(professor.getNome()).get(idTurma);
            turmaAtual.listarAlunos();
        }catch(Exception e){
            System.out.println("Erro ao listar Alunos. Verifique as informações e tente novamente!");
        }
    }
    private static void formarAluno(){
        try{
            turmas.listarByProf(professor.getNome());
            System.out.println("Informe o Id da turma: ");
            int idTurma = Utilitarios.validateInput() - 1;
            Turma turmaAtual = turmas.getListaByProf(professor.getNome()).get(idTurma);
            turmaAtual.listarAlunos();
            System.out.println("Informe o Id do aluno a ser formado: ");
            int idAluno = Utilitarios.validateInput();
            Aluno aluno = alunos.buscar(idAluno);
            turmaAtual.removerAluno(idAluno);
            aluno.formarAluno();
            System.out.println("Aluno Formado com sucesso!");
        }catch (Exception e){
            System.out.println("Erro ao formar um Aluno. Verifique as informações e tente novamente!");
        }
    }
}
