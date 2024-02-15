import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Turma{

    private ArrayList<Aluno> listaAlunos;
    private int ano;
    private Curso curso;

    public Turma(Curso curso) {
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

    public void listarAlunos(ArrayList<Aluno> listaAlunos) {
        for (Aluno aluno : listaAlunos) {
            System.out.println("Aluno: " + aluno.getNome() + " - Idade: " + aluno.getIdade());
        }
    }

}
