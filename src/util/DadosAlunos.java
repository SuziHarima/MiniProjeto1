package util;

import entities.Aluno;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DadosAlunos {
    private List<Aluno> alunos;

    public DadosAlunos() {
        this.alunos = new ArrayList<>();
    }


    /**
     * Adicionar um aluno à lista
     *
     * @param aluno objeto aluno a ser incluído à lista
     */
    public void adicionar(Aluno aluno) {
        try{
            if(this.alunos.stream().anyMatch(a -> a.getNome().equalsIgnoreCase(aluno.getNome())))
                throw new Exception("Aluno já existe!");

            this.alunos.add(aluno);
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    /**
     * Remover um aluno da lista
     *
     * @param id índice do aluno a ser removido da lista
     */
    public void remover(int id) {
        this.alunos.remove(id);
    }

    /**
     * Buscar um aluno na lista
     *
     * @param id índice da posição do aluno na lista
     * @return aluno encontrado
     */
    public Aluno buscar(int id) {
        return this.alunos.get(id);
    }

    /**
     * Lista de alunos
     *
     * @return Lista de alunos adicionados
     */
    public List<Aluno> getLista() {
        return this.alunos;
    }

    /**
     * Busca um Aluno pelo nome
     * @param nome nome do aluno
     * @return Aluno encontrado ou NULL
     */
    public Aluno getAlunoByName(String nome){
         Optional<Aluno> aluno = this.alunos.stream()
                .filter(x -> x.getNome().equalsIgnoreCase(nome))
                .findFirst();
         return aluno.orElse(null);
    }

    /**
     * Listar alunos
     */
    public void listar() {
        if(this.alunos.isEmpty()) {
            System.out.println("Nenhum Aluno Registrado!");
            return;
        }
        System.out.println("Alunos registrados: ");
        for (int i = 0; i < this.alunos.size(); i++) {
            System.out.println((i+1) + ". "+this.alunos.get(i));
        }
    }
}
