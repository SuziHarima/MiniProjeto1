public class Curso {

    private String nomeDoCurso;

    private final String professorDoCurso;

    public Curso(String nomeDoCurso, String professorDoCurso) {
        this.nomeDoCurso = nomeDoCurso;
        this.professorDoCurso = professorDoCurso;
    }

    public String getNomeDoCurso() {
        return nomeDoCurso;
    }

    public String getProfessorDoCurso() {
        return professorDoCurso;
    }

    public Curso(String professorDoCurso) {
        this.professorDoCurso = professorDoCurso;
    }


    @Override
    public String toString() {
        return "Curso{" +
                "nomeDoCurso='" + nomeDoCurso + '\'' +
                ", professorDoCurso='" + professorDoCurso + '\'' +
                '}';
    }
}