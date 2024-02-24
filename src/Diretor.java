public class Diretor extends Funcionario{

    private String nome;
    private int tempoCargo = 0;

    public Diretor(String nome, int tempoCargo) {
        this.nome = nome;
        this.tempoCargo = tempoCargo;
    }

    public Diretor(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTempoCargo() {
        return tempoCargo;
    }

    public void setTempoCargo(int tempoCargo) {
        this.tempoCargo = tempoCargo;
    }

    @Override
    public String toString() {
        return "Diretor: " + nome + "; Tempo de direção: " + tempoCargo + " anos.";
    }
}
