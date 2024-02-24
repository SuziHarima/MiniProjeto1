package util;

import entities.Diretor;
import entities.Professor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Utilitário base para registro de professores
 */
public class DadosProfessores {
    private List<Professor> professores;

    public DadosProfessores(){
        this.professores = new ArrayList<>();
    }


    /**
     * Adicionar um professor à lista
     * @param professor objeto Professor a ser incluído à lista
     */
    public void adicionar(Professor professor){
        try{
            if(this.professores.stream().anyMatch(a -> a.getNome().equalsIgnoreCase(professor.getNome())))
                throw new Exception("Professor já existe!");

            this.professores.add(professor);
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    /**
     * Remover um professor da lista
     * @param id índice do Professor a ser removido da lista
     */
    public void remover(int id){
        this.professores.remove(id);
    }

    /**
     * Buscar um professor na lista
     * @param id índice da posição do professor na lista
     * @return professor encontrado
     */
    public Professor buscar(int id){
        return this.professores.get(id);
    }

    /**
     * Lista de Professores
     * @return Lista de professores adicionados
     */
    public List<Professor> getLista(){
        return this.professores;
    }

    /**
     * Busca um Professor pelo nome
     *
     * @param nome nome do diretor
     * @return Professor encontrado ou NULL
     */
    public Professor getProfessorByName(String nome) {
        Optional<Professor> professor = this.professores.stream()
                .filter(x -> x.getNome().equalsIgnoreCase(nome))
                .findFirst();
        return professor.orElse(null);
    }
    /**
     * Listar Professores
     */
    public void listar(){
        if(this.professores.isEmpty()) {
            System.out.println("Nenhum Professor Registrado!");
            return;
        }
        System.out.println("Professores registrados: ");
        for (int i = 0; i < this.professores.size(); i++) {
            System.out.println((i+1) + ". "+this.professores.get(i));
        }
    }
}
