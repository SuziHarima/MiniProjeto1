package ui;

import entities.Aluno;
import entities.Diretor;
import entities.Professor;
import util.DadosAlunos;
import util.DadosDiretores;
import util.DadosProfessores;
import util.Utilitarios;

import java.util.Arrays;
import java.util.Scanner;

public class Login {
    private static Aluno aluno;
    private static Professor professor;
    private static Diretor diretor;

    private static Scanner scanner;

    public static Aluno getAluno() {
        return aluno;
    }

    public static Professor getProfessor() {
        return professor;
    }

    public static Diretor getDiretor() {
        return diretor;
    }

    /**
     * Mostra a tela de Login
     *
     * @param alunos      Objeto Dados de Alunos existentes
     * @param professores Objeto Dados de Professores existentes
     * @param diretores   Objeto Dados de Diretores existentes
     */
    public static boolean logar(DadosAlunos alunos, DadosProfessores professores, DadosDiretores diretores) {
        scanner = new Scanner(System.in);
        String resposta = identificar();
        String nome = "";
        if (!resposta.equalsIgnoreCase("E") && Arrays.asList(new String[] {"P","D","A"}).contains(resposta.toUpperCase()))
            nome = Utilitarios.inputNome();

        switch (resposta) {
            case "P":
                professor = professores.getProfessorByName(nome);
                if (professor != null) {
                    System.out.println("\nBem Vindo prof. " + professor.getNome() + "!");
                    break;
                }
                professor = new Professor(nome, Utilitarios.inputIdade());
                professores.adicionar(professor);
                System.out.println("Professor criado com sucesso!");
                break;
            case "D":
                diretor = diretores.getDiretorByName(nome);
                if (diretor != null) {
                    System.out.println("\nBem Vindo diretor " + diretor.getNome() + "!");
                    break;
                }
                diretor = new Diretor(nome, Utilitarios.inputIdade());
                diretores.adicionar(diretor);
                System.out.println("Diretor criado com sucesso!");
                break;
            case "A":
                aluno = alunos.getAlunoByName(nome);
                if (aluno != null) {
                    System.out.println("\nBem Vindo " + aluno.getNome() + "!");
                    break;
                }
                aluno = new Aluno(nome, Utilitarios.inputIdade());
                alunos.adicionar(aluno);
                System.out.println("Aluno criado com sucesso!");
                break;
            case "E":
                System.out.println("Programa encerrado. Até mais!");
                return false;
            default:
                System.out.println("Opção inválida. Tente novamente.");
        }
        return true;
    }


    /**
     * Realiza a identificação do usuário
     *
     * @return 'P' para Professor, 'D' para Diretor ou 'A' para Aluno
     */
    private static String identificar() {
        System.out.println("Você é Funcionário ou Aluno?");
        System.out.println("Digite 'F' para Funcionário ou 'A' para Aluno ('E' para encerrar o programa):");
        String resposta = scanner.nextLine().toUpperCase();
        if (resposta.equalsIgnoreCase("F"))
            resposta = identificarFuncionario();
        return resposta;
    }

    /**
     * Identifica o tipo de Funcionário
     *
     * @return 'P' para Professor ou 'D' para Diretor
     */
    private static String identificarFuncionario() {
        System.out.println("Você é Professor ou Diretor?");
        System.out.println("Digite 'P' para Professor, 'D' para Diretor ('E' para encerrar o programa):");
        return scanner.nextLine().toUpperCase();
    }

    /**
     * Resetar dados de login
     */
    public static void clearData(){
        aluno = null;
        professor = null;
        diretor = null;
    }




}
