package entities;

public class Diretor extends Funcionario {
    private int tempoCargo;

    public Diretor(String nome, int idade) {
        this.setNome(nome);
        this.setIdade(idade);
        this.tempoCargo = 0;
    }

    //region Getters and Setters
    public int getTempoCargo() {
        return tempoCargo;
    }

    public void setTempoCargo(int tempoCargo) {
        this.tempoCargo = tempoCargo;
    }
    //endregion


    @Override
    public String toString() {
        return "Diretor: " + this.getNome() + " - Tempo de Cargo: " + tempoCargo;
    }
}
