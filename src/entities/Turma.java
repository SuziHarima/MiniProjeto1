package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Turma{
    private final ArrayList<Aluno> listaAlunos;
    private int ano;
    private Curso curso;
    private String nome;

    public Turma(String nome, Curso curso) {
        this.nome = nome;
        this.listaAlunos = new ArrayList<>();
        this.curso = curso;
        Calendar cal = GregorianCalendar.getInstance();
        this.ano = cal.get(Calendar.YEAR);
    }

    public void adicionarAluno(Aluno aluno) {
        listaAlunos.add(aluno);
    }

    public void removerAluno(int indice) {
        listaAlunos.remove(indice);
    }

    public ArrayList<Aluno> getListaAlunos() {
        return listaAlunos;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void listarAlunos() {
        if(listaAlunos.isEmpty()){
            System.out.println("Nenhum Aluno registrado para esta Turma");
        }

        System.out.println("Alunos da Turma - Ano "+ano+" - Curso "+curso.getNome());
        for (int i = 0; i < listaAlunos.size(); i++) {
            System.out.println((i+1)+ ". "+listaAlunos.get(i).getNome());
        }
    }

    @Override
    public String toString() {
        return "Turma: "+ano+ "(Curso: "+curso+")";
    }
}
