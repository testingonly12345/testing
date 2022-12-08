package model;

public class Inquilino extends Pessoa{
    private double rendaMensal;

    public Inquilino(int id, String cpf, String nome, String telefone, double rendaMensal) {
        super(id, cpf, nome, telefone);
        this.rendaMensal = rendaMensal;
    }

    public double getRendaMensal() {
        return rendaMensal;
    }

    public void setRendaMensal(double rendaMensal) {
        this.rendaMensal = rendaMensal;
    }


    @Override
    public void mostrarDados() {
        System.out.println("________________________________");
        System.out.println("Id: " + this.getId() +
                "\nCpf: " + this.getCpf() +
                "\nNome: " + this.getNome() +
                "\nTelefone: " + this.getTelefone() +
                "\nrendaMensal: " + this.getRendaMensal());
    }
}
