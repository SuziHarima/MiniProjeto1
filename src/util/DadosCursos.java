package util;

import entities.Curso;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DadosCursos {
    private List<Curso> cursos;

    public DadosCursos() {
        this.cursos = new ArrayList<>();
    }


    /**
     * Adicionar um curso à lista
     *
     * @param curso objeto curso a ser incluído à lista
     */
    public void adicionar(Curso curso) {
        try{
            if(this.cursos.stream().anyMatch(a -> a.getNome().equalsIgnoreCase(curso.getNome())))
                throw new Exception("Curso já existe!");

            this.cursos.add(curso);
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    /**
     * Remover um curso da lista
     *
     * @param id índice do cur a ser removido da lista
     */
    public void remover(int id) {
        this.cursos.remove(id);
    }

    /**
     * Buscar um curso na lista
     *
     * @param id índice da posição do curso na lista
     * @return curso encontrado
     */
    public Curso buscar(int id) {
        return this.cursos.get(id);
    }

    /**
     * Lista de cursos
     *
     * @return Lista de cursos adicionados
     */
    public List<Curso> getLista() {
        return this.cursos;
    }

    /**
     * Busca um curso pelo nome
     * @param nome nome do curso
     * @return curso encontrado ou NULL
     */
    public Curso getCursoByName(String nome){
        Optional<Curso> curso = this.cursos.stream()
                .filter(x -> x.getNome().equalsIgnoreCase(nome))
                .findFirst();
        return curso.orElse(null);
    }

    /**
     * Listar cursos
     */
    public void listar() {
        if(this.cursos.isEmpty()) {
            System.out.println("Nenhum Curso Registrado!");
            return;
        }
        System.out.println("Cursos registrados: ");
        for (int i = 0; i < this.cursos.size(); i++) {
            System.out.println((i+1) + ". "+this.cursos.get(i));
        }
    }
}
