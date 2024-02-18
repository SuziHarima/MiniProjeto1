package ui;

import entities.Aluno;
import entities.Diretor;
import entities.Professor;
import util.DadosAlunos;
import util.DadosDiretores;
import util.DadosProfessores;

import java.util.Scanner;

public class Login {

    private static Scanner scanner;

    /**
     * Mostra a tela de Login
     *
     * @param alunos      Objeto Dados de Alunos existentes
     * @param professores Objeto Dados de Professores existentes
     * @param diretores   Objeto Dados de Diretores existentes
     */
    public static void logar(DadosAlunos alunos, DadosProfessores professores, DadosDiretores diretores) {
        scanner = new Scanner(System.in);
        System.out.println("Bem Vindo ao SchoolManager!");
        String resposta = identificar();
        String nome = getUserName();

        switch (resposta) {
            case "P":
                Professor professor = professores.getProfessorByName(nome);
                if(professor != null) {
                    System.out.println("Bem Vindo prof. "+professor.getNome()+"!");
                    break;
                }
                professor = new Professor(nome, getIdade());
                professores.adicionar(professor);
                System.out.println("Diretor criado com sucesso!");
                break;
            case "D":
                Diretor diretor = diretores.getDiretorByName(nome);
                if(diretor != null) {
                    System.out.println("Bem Vindo diretor "+diretor.getNome()+"!");
                    break;
                }
                diretor = new Diretor(getUserName(), getIdade());
                diretores.adicionar(diretor);
                System.out.println("Professor criado com sucesso!");
                break;
            case "A":
                Aluno aluno = alunos.getAlunoByName(nome);
                if(aluno != null) {
                    System.out.println("Bem Vindo "+aluno.getNome()+"!");
                    break;
                }
                aluno = new Aluno(getUserName(), getIdade());
                alunos.adicionar(aluno);
                System.out.println("Aluno criado com sucesso!");
                break;
            case "E":
                System.out.println("Programa encerrado. Até mais!");
                return;
            default:
                System.out.println("Opção inválida. Encerando o programa.");
        }
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
        validateInput("string");
        if (resposta.equals("F"))
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
        String resposta = scanner.nextLine().toUpperCase();
        validateInput("string");
        return resposta;
    }


    /**
     * Manipula o input de nome
     *
     * @return nome do usuário
     */
    private static String getUserName() {
        scanner = new Scanner(System.in);
        System.out.println("Digite seu nome:");
        validateInput("string");
        return scanner.nextLine();
    }

    /**
     * Manipula o input de idade
     *
     * @return idade do usuário
     */
    private static int getIdade() {
        scanner = new Scanner(System.in);
        System.out.println("Digite sua idade:");
        validateInput("int");
        return scanner.nextInt();
    }

    /**
     * Valida o tipo de entrada conforme o tipo
     *
     * @param inputType tipo de entrada permitida
     */
    private static void validateInput(String inputType) {
        switch (inputType.toLowerCase()) {
            case "string":
                while (!scanner.hasNext() || scanner.hasNextInt()) {
                    System.out.println("Entrada inválida. Tente novamente");
                    scanner.next();
                }
                break;
            case "int":
                while (!scanner.hasNextInt()) {
                    System.out.println("Entrada inválida. Tente novamente");
                    scanner.next();
                }
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + inputType.toLowerCase());
        }
    }
}
