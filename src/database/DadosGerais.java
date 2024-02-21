package database;

import entities.*;
import util.*;

import java.util.ArrayList;
import java.util.List;

public class DadosGerais {
    private DadosAlunos dadosAlunos;
    private DadosProfessores dadosProfessores;
    private DadosDiretores dadosDiretores;
    private DadosCursos dadosCursos;
    private DadosTurmas dadosTurmas;

    public DadosGerais(){
        initAlunos();
        initDiretores();
        initProfessores();
        initCursos();
        initTurmas();
    }

    //region Getters
    public DadosAlunos getDadosAlunos() {
        return dadosAlunos;
    }

    public DadosDiretores getDadosDiretores() {
        return dadosDiretores;
    }

    public DadosProfessores getDadosProfessores() {
        return dadosProfessores;
    }

    public DadosCursos getDadosCursos() {
        return dadosCursos;
    }

    public DadosTurmas getDadosTurmas() {
        return dadosTurmas;
    }
    //endregion

    /**
     * Inicializa os alunos pré-registrados
     */
    private void initAlunos(){
        dadosAlunos = new DadosAlunos();
        dadosAlunos.adicionar(new Aluno("Camila",33));
        dadosAlunos.adicionar(new Aluno("Arthur",13));
        dadosAlunos.adicionar(new Aluno("Ketherine",15));
        dadosAlunos.adicionar(new Aluno("Laura",8));
        dadosAlunos.adicionar(new Aluno("Ísis",2));
    }

    /**
     * Inicializa os diretores pré-definidos
     */
    private void initDiretores(){
        dadosDiretores = new DadosDiretores();
        dadosDiretores.adicionar(new Diretor("Heverton",36));
    }

    /**
     * Inicializa os Professores pré-definidos
     */
    private void initProfessores(){
        dadosProfessores = new DadosProfessores();
        dadosProfessores.adicionar(new Professor("Andre",28));
        dadosProfessores.adicionar(new Professor("Fulano",32));
        dadosProfessores.adicionar(new Professor("Ciclano",36));
    }

    /**
     * Inicializa os Cursos padrão
     */
    private void initCursos(){
        if(dadosProfessores.getLista().isEmpty())
            return ;
        dadosCursos = new DadosCursos();
        dadosCursos.adicionar(new Curso("FullStack",dadosProfessores.buscar(0)));
        dadosCursos.adicionar(new Curso("Front-end",dadosProfessores.buscar(1)));
        dadosCursos.adicionar(new Curso("Back-end",dadosProfessores.buscar(2)));
    }

    private void initTurmas(){
        if(dadosCursos.getLista().isEmpty())
            return ;
        dadosTurmas = new DadosTurmas();
        dadosTurmas.adicionar(new Turma(dadosCursos.buscar(0)));
        dadosTurmas.adicionar(new Turma(dadosCursos.buscar(1)));
        dadosTurmas.adicionar(new Turma(dadosCursos.buscar(2)));
    }
}
