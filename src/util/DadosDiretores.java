package util;

import entities.Aluno;
import entities.Diretor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DadosDiretores {
    private List<Diretor> diretores;

    public DadosDiretores() {
        this.diretores = new ArrayList<>();
    }


    /**
     * Adicionar um diretor à lista
     *
     * @param diretor objeto diretor a ser incluído à lista
     */
    public void adicionar(Diretor diretor) {
        try{
            if(this.diretores.stream().anyMatch(a -> a.getNome().equalsIgnoreCase(diretor.getNome())))
                throw new Exception("Diretor já existe!");

            this.diretores.add(diretor);
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    /**
     * Remover um diretor da lista
     *
     * @param id índice do diretor a ser removido da lista
     */
    public void remover(int id) {
        this.diretores.remove(id);
    }

    /**
     * Buscar um diretor na lista
     *
     * @param id índice da posição do diretor na lista
     * @return diretor encontrado
     */
    public Diretor buscar(int id) {
        return this.diretores.get(id);
    }

    /**
     * Lista de diretores
     *
     * @return Lista de diretores adicionados
     */
    public List<Diretor> getLista() {
        return this.diretores;
    }

    /**
     * Busca um Diretor pelo nome
     *
     * @param nome nome do diretor
     * @return Diretor encontrado ou NULL
     */
    public Diretor getDiretorByName(String nome) {
        Optional<Diretor> diretor = this.diretores.stream()
                .filter(x -> x.getNome().equalsIgnoreCase(nome))
                .findFirst();
        return diretor.orElse(null);
    }

    /**
     * Listar diretores
     */
    public void listar() {
        if (this.diretores.isEmpty()) {
            System.out.println("Nenhum Diretor Registrado!");
            return;
        }
        System.out.println("Diretores registrados: ");
        for (int i = 0; i < this.diretores.size(); i++) {
            System.out.println((i+1) + ". "+this.diretores.get(i));
        }
    }
}
