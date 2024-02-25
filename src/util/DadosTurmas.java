package util;

import entities.Turma;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DadosTurmas {
    private List<Turma> turmas;

    public DadosTurmas() {
        this.turmas = new ArrayList<>();
    }


    /**
     * Adicionar um turma à lista
     *
     * @param turma objeto turma a ser incluído à lista
     */
    public void adicionar(Turma turma) {
        try{
            if(this.turmas.stream().anyMatch(a -> a.getNome().equalsIgnoreCase(turma.getNome())))
                throw new Exception("Turma já existe!");

            this.turmas.add(turma);
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    /**
     * Remover uma turma da lista
     *
     * @param id índice da turma a ser removido da lista
     */
    public void remover(int id) {
        this.turmas.remove(id);
    }

    /**
     * Buscar uma turma na lista
     *
     * @param id índice da posição do turma na lista
     * @return turma encontrado
     */
    public Turma buscar(int id) {
        return this.turmas.get(id);
    }

    /**
     * Lista de turmas
     *
     * @return Lista de turmas adicionados
     */
    public List<Turma> getLista() {
        return this.turmas;
    }

    /**
     * Busca um Turma pelo nome do curso
     * @param nome nome do curso
     * @return Turma encontrada ou NULL
     */
    public Turma getTurmaByCurso(String nome){
        Optional<Turma> turma = this.turmas.stream()
                .filter(x -> x.getCurso().getNome().equalsIgnoreCase(nome))
                .findFirst();
        return turma.orElse(null);
    }

    /**
     * Listar turmas
     */
    public void listar() {
        if(this.turmas.isEmpty()) {
            System.out.println("Nenhuma Turma Registrada!");
            return;
        }
        System.out.println("Turmas registradas: ");
        for (int i = 0; i < this.turmas.size(); i++) {
            System.out.println((i+1) + ". "+this.turmas.get(i));
        }
    }
    public List<Turma> getListaByProf(String nomeProfessor) {
        return this.turmas.stream().filter(t -> t.getCurso().getProfessor().getNome().equalsIgnoreCase(nomeProfessor)).toList();
    }
    public void listarByProf(String nomeProfessor) {
        List<Turma> turmasProfessor = getListaByProf(nomeProfessor);
        System.out.println("Turmas registradas: ");
        if(turmasProfessor.isEmpty()) {
            System.out.println("Nenhum Turma Registrado!");
            return;
        }
        for (int i = 0; i < turmasProfessor.size(); i++) {
            System.out.println((i+1) + ". "+turmasProfessor.get(i));
        }
    }
}
