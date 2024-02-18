package entities;

import interfaces.IFuncionario;

import java.math.BigDecimal;

public class Funcionario implements IFuncionario {
    private String nome;
    private int idade;
    private BigDecimal salario;

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
    //endregion

    @Override
    public void promover() {
        System.out.println("Não implementado");
    }

    @Override
    public String toString() {
        return "Funcionário: " + nome + " (Salario: R$" + salario + ")";
    }
}
