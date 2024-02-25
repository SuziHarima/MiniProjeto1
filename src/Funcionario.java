public class Funcionario implements IFuncionario{

    private String nome;
    private double salario;

    public void promover(){

    }


    @Override
    public String toString() {
        return "Funcionario: " + nome + "; Salário: " + salario;
    }
}
