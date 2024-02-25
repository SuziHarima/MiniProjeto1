package entities;

import enums.Matricula;

import java.util.ArrayList;

public class Aluno {
    private String nome;
    private int idade;
    private Matricula matricula;
    private ArrayList<Curso> listaCursos;

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public boolean isAtivo() {
        return matricula.equals(Matricula.ATIVO);
    }

    public void setAtivo(boolean ativo) {
        this.matricula = ativo ? Matricula.ATIVO : Matricula.TRANCADO;
    }

    public void formarAluno(){
        this.matricula = Matricula.FORMADO;
    }


    public ArrayList<Curso> getListaCursos() {
        return listaCursos;
    }

    public Aluno(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
        this.listaCursos = new ArrayList<>();
        this.matricula = Matricula.ATIVO;
    }

    public void listarCursos() {
        if(listaCursos.isEmpty()){
            System.out.println("Nenhum curso matriculado!");
            return;
        }

        System.out.println("Cursos Matriculados: ");
        for (int i = 0; i < listaCursos.size(); i++) {
            System.out.println((i + 1) + " - " + listaCursos.get(i));
        }
    }

    public void adicionarCurso(Curso curso) {
        if (curso != null)
            listaCursos.add(curso);
    }

    public void removerCurso(Curso curso) {
        if (curso != null)
            listaCursos.remove(curso);
    }

    @Override
    public String toString() {
        return "Aluno: " + nome + " - Idade: " + idade + " anos";
    }
}
