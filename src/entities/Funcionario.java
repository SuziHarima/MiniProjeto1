package entities;

import enums.Cargo;
import interfaces.IFuncionario;

import java.math.BigDecimal;

public class Funcionario implements IFuncionario {
    private String nome;
    private int idade;
    private BigDecimal salario;
    private Cargo cargo = Cargo.INICIANTE;

    //region Getters and Setters
    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }
    //endregion

    @Override
    public void promover() {
        switch (cargo){
            case INICIANTE -> cargo = Cargo.EXPERIENTE;
            case EXPERIENTE -> cargo = Cargo.AVANCADO;
            case AVANCADO -> System.out.println("Promoção máxima já alcançada!");
            default -> System.out.println("Opção inválida!");
        }
    }

    @Override
    public String toString() {
        return "Funcionário: " + nome + " (Salario: R$" + salario + ")";
    }
}
