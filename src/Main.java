import database.DadosGerais;
import entities.Aluno;
import entities.Diretor;
import entities.Professor;
import ui.*;
import util.*;

public class Main {
    private static DadosAlunos dadosAlunos;
    private static DadosProfessores dadosProfessores;
    private static DadosDiretores dadosDiretores;
    private static DadosCursos dadosCursos;
    private static DadosTurmas dadosTurmas;
    public static void main(String[] args) {
        initDB();

        System.out.println("Bem Vindo ao SchoolManager!");
        login();
    }

    /**
     * Efetua Login e demonstra o menu conforme o nível de permissão
     */
    private static void login(){
        boolean login = Login.logar(dadosAlunos,dadosProfessores,dadosDiretores);
        if (!login) return;


        Aluno aluno = Login.getAluno();
        Diretor diretor = Login.getDiretor();
        Professor professor = Login.getProfessor();
        System.out.println(aluno);
        System.out.println(diretor);
        System.out.println(professor);
        if (aluno != null)
            MenuAluno.alunoMenu(aluno, dadosCursos);
        if (diretor != null)
            MenuDiretor.diretorMenu(diretor,dadosProfessores,dadosAlunos,dadosTurmas,dadosCursos);
        if (professor != null)
            MenuProfessor.professorMenu(professor,dadosAlunos,dadosTurmas);

        Login.clearData();
        login();
    }

    /**
     * Inicia dados pré-existentes
     */
    private static void initDB(){
        DadosGerais dados = new DadosGerais();
        dadosAlunos = dados.getDadosAlunos();
        dadosProfessores = dados.getDadosProfessores();
        dadosDiretores = dados.getDadosDiretores();
        dadosCursos = dados.getDadosCursos();
        dadosTurmas = dados.getDadosTurmas();
    }
}
