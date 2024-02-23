package ui;

import entities.*;
import util.*;

import java.util.Scanner;


public class MenuDiretor extends Menu {

    public static void diretorMenu(Diretor diretorAtual, DadosProfessores dadosProfessores, DadosAlunos dadosAlunos, DadosTurmas dadosTurmas,DadosCursos dadosCursos) {
        professores = dadosProfessores;
        alunos = dadosAlunos;
        turmas = dadosTurmas;
        cursos = dadosCursos;


        diretor = diretorAtual;
        scanner = new Scanner(System.in);
        int resposta;
        do {
            System.out.println("-------------------------");
            System.out.println("1. Manipular Alunos");
            System.out.println("2. Manipular Professores");
            System.out.println("3. Manipular Turmas");
            System.out.println("9. Sair do Sistema");
            System.out.println("-------------------------");
            System.out.println("O que deseja fazer?: ");
            resposta = Utilitarios.validateInput();
            System.out.println("-------------------------");
            switch (resposta) {
                case 1:
                    manipularAlunos();
                    break;
                case 2:
                    manipularProfessores();
                    break;
                case 3:
                    manipularTurmas();
                    break;
                case 9:
                    System.out.println("Logoff efetuado. Por favor, faça o login novamente.\n");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (resposta != 9);
    }

    private static void manipularAlunos(){
        int resposta;
        do {
            System.out.println("-------------------------");
            System.out.println("MANIPULAR ALUNOS");
            System.out.println("1. Listar");
            System.out.println("2. Adicionar");
            System.out.println("3. Remover");
            System.out.println("4. Formar");
            System.out.println("9. Voltar");
            System.out.println("-------------------------");
            System.out.println("O que deseja fazer?: ");
            resposta = Utilitarios.validateInput();
            System.out.println("-------------------------");
            switch (resposta) {
                case 1:
                    listarAlunos();
                    break;
                case 2:
                    novoAluno();
                    break;
                case 3:
                    removeAluno();
                    break;
                case 4:
                    formarAluno();
                    break;
                case 9:
                    System.out.println("Voltando...\n");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (resposta != 9);
    }
    private static void manipularProfessores(){
        int resposta;
        do {
            System.out.println("-------------------------");
            System.out.println("MANIPULAR PROFESSORES");
            System.out.println("1. Listar");
            System.out.println("2. Adicionar");
            System.out.println("3. Remover");
            System.out.println("4. Promover");
            System.out.println("9. Voltar");
            System.out.println("-------------------------");
            System.out.println("O que deseja fazer?: ");
            resposta = Utilitarios.validateInput();
            System.out.println("-------------------------");
            switch (resposta) {
                case 1:
                    professores.listar();
                    break;
                case 2:
                    novoProfessor();
                    break;
                case 3:
                    removeProfessor();
                    break;
                case 4:
                    promoveProfessor();
                    break;
                case 9:
                    System.out.println("Voltando...\n");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (resposta != 9);
    }
    private static void manipularTurmas(){
        int resposta;
        do {
            System.out.println("-------------------------");
            System.out.println("MANIPULAR TURMAS");
            System.out.println("1. Listar");
            System.out.println("2. Adicionar");
            System.out.println("3. Remover");
            System.out.println("4. Vincular Aluno");
            System.out.println("5. Desvincular Aluno");
            System.out.println("9. Voltar");
            System.out.println("-------------------------");
            System.out.println("O que deseja fazer?: ");
            resposta = Utilitarios.validateInput();
            System.out.println("-------------------------");
            switch (resposta) {
                case 1:
                    turmas.listar();
                    break;
                case 2:
                    novaTurma();
                    break;
                case 3:
                    removeTurma();
                    break;
                case 4:
                    vincularAluno();
                    break;
                case 5:
                    desvincularAluno();
                    break;
                case 9:
                    System.out.println("Voltando...\n");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (resposta != 9);
    }

    private static void novaTurma(){
        try {
            cursos.listar();
            if(cursos.getLista().isEmpty())
                return;
            System.out.println("Selecione um Curso:");
            int indiceCurso = Utilitarios.validateInput() - 1;
            Curso cursoSelecionado = cursos.buscar(indiceCurso);
            turmas.adicionar(new Turma(Utilitarios.inputNome(), cursoSelecionado));
            System.out.println("Turma adicionada com sucesso!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    private static void removeTurma(){
        try {
            turmas.listar();
            if(turmas.getLista().isEmpty())
                return;
            System.out.println("Informe o Id da turma a ser removida: ");
            int idTurma = Utilitarios.validateInput() - 1;
            turmas.remover(idTurma);
            System.out.println("Turma removida com sucesso!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    private static void listarAlunos(){
        try{
            System.out.println("Deseja filtrar por turma? (S) Sim ou (N) Não");
            String resposta = scanner.nextLine().toUpperCase();
            if(resposta.equals("N")) {
                alunos.listar();
                return;
            }
            turmas.listar();
            if(turmas.getLista().isEmpty())
                return;
            System.out.println("Informe o Id da turma: ");
            int idTurma = Utilitarios.validateInput() - 1;
            Turma turma = turmas.buscar(idTurma);
            turma.listarAlunos();
        }catch(Exception e){
            System.out.println("Erro ao listar Alunos. Verifique as informações e tente novamente!");
        }
    }
    private static void novoAluno(){
        try {
            Aluno novoAluno = new Aluno(Utilitarios.inputNome(),Utilitarios.inputIdade());
            alunos.adicionar(novoAluno);
            System.out.println("Aluno adicionado com sucesso!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    private static void removeAluno(){
        try {
            alunos.listar();
            if(alunos.getLista().isEmpty())
                return;
            System.out.println("Informe o Id do aluno a ser removido: ");
            int idAluno = Utilitarios.validateInput() - 1;
            alunos.remover(idAluno);
            System.out.println("Aluno removido com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao remover um aluno. Verifique as informações e tente novamente!");
        }
    }



    private static void novoProfessor() {
        try {
            Professor novoProfessor = new Professor(Utilitarios.inputNome(), Utilitarios.inputIdade());
            professores.adicionar(novoProfessor);
            System.out.println("Professor adicionado com sucesso!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    private static void removeProfessor(){
        try {
            professores.listar();
            if(professores.getLista().isEmpty())
                return;
            System.out.println("Informe o Id do professor a ser removido: ");
            int idProfessor = Utilitarios.validateInput() - 1;
            professores.remover(idProfessor);
            System.out.println("Professor removido com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao remover um professor. Verifique as informações e tente novamente!");
        }
    }

    private static void promoveProfessor(){
        try {
            professores.listar();
            if(professores.getLista().isEmpty())
                return;
            System.out.println("Informe o Id do professor a ser promovido: ");
            int idProfessor = Utilitarios.validateInput();
            Professor professor = professores.buscar(idProfessor);
            professor.promover();
            System.out.println("Professor promovido com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao remover um professor. Verifique as informações e tente novamente!");
        }
    }
    private static void formarAluno(){
        try{
            alunos.listar();
            if(alunos.getLista().isEmpty())
                return;
            System.out.println("Informe o Id do aluno a ser formado: ");
            int idAluno = Utilitarios.validateInput();
            Aluno aluno = alunos.buscar(idAluno);
            aluno.formarAluno();
            System.out.println("Aluno Formado com sucesso!");
        }catch (Exception e){
            System.out.println("Erro ao formar um Aluno. Verifique as informações e tente novamente!");
        }
    }
    private static void vincularAluno(){
        try{
            turmas.listar();
            if(turmas.getLista().isEmpty())
                return;
            System.out.println("Informe a Turma que deseja manipular: ");
            int idTurma = Utilitarios.validateInput() - 1;
            Turma turma = turmas.buscar(idTurma);
            alunos.listar();
            if(alunos.getLista().isEmpty())
                return;
            System.out.println("Informe o Id do aluno a ser vinculado nesta Turma: ");
            int idAluno = Utilitarios.validateInput() - 1;
            Aluno aluno = alunos.buscar(idAluno);
            turma.adicionarAluno(aluno);
            System.out.println("Aluno vinculado à Turma com sucesso!");
        }catch (Exception e){
            System.out.println("Erro ao formar um Aluno. Verifique as informações e tente novamente!");
        }
    }
    private static void desvincularAluno(){
        try{
            turmas.listar();
            if(turmas.getLista().isEmpty())
                return;
            System.out.println("Informe a Turma que deseja manipular: ");
            int idTurma = Utilitarios.validateInput() - 1;
            Turma turma = turmas.buscar(idTurma);
            turma.listarAlunos();
            if(turma.getListaAlunos().isEmpty())
                return;
            System.out.println("Informe o Id do aluno a ser desvinculado desta Turma: ");
            int idAluno = Utilitarios.validateInput() - 1;
            turma.removerAluno(idAluno);
            System.out.println("Aluno desvinculado Turma com sucesso!");
        }catch (Exception e){
            System.out.println("Erro ao desvincular um Aluno de Turma. Verifique as informações e tente novamente!");
        }
    }
}
