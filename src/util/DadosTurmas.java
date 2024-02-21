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
        this.turmas.add(turma);
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
        System.out.println("Turmas registrados: ");
        if(this.turmas.isEmpty()) {
            System.out.println("Nenhum Turma Registrado!");
            return;
        }
        for (int i = 0; i < this.turmas.size(); i++) {
            System.out.println((i+1) + ". "+this.turmas.get(i));
        }
    }
}
