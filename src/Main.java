import database.DadosGerais;
import entities.Aluno;
import entities.Curso;
import entities.Diretor;
import entities.Professor;
import enums.Cargo;
import ui.*;
import util.*;

import java.util.List;

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



//        if(diretor != null)
//        System.out.println("Diretor Encontrado: "+diretor.getNome());
//
//
    }

    private static void login(){
        boolean login = Login.logar(dadosAlunos,dadosProfessores,dadosDiretores);
        if (!login) return;

        Aluno aluno = Login.getAluno();
        Diretor diretor = Login.getDiretor();
        Professor professor = Login.getProfessor();
        if (aluno != null)
            MenuAluno.alunoMenu(aluno, dadosCursos);
        if (diretor != null)
            MenuDiretor.diretorMenu(diretor,dadosProfessores,dadosAlunos);
        if (professor != null)
            MenuProfessor.professorMenu(professor,dadosTurmas);

        login();
    }

    private static void initDB(){
        DadosGerais dados = new DadosGerais();
        dadosAlunos = dados.getDadosAlunos();
        dadosProfessores = dados.getDadosProfessores();
        dadosDiretores = dados.getDadosDiretores();
        dadosCursos = dados.getDadosCursos();
        dadosTurmas = dados.getDadosTurmas();
    }
}
