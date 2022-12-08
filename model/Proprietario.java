package model;

public class Proprietario extends Pessoa{
    private String banco;
    private String conta;

    public Proprietario(int id, String cpf, String nome, String telefone, String banco, String conta) {
        super(id, cpf, nome, telefone);
        this.banco = banco;
        this.conta = conta;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    @Override
    public void mostrarDados() {
        System.out.println("________________________________");
        System.out.println("Id: " + this.getId() +
                "\nCpf: " + this.getCpf() +
                "\nNome: " + this.getNome() +
                "\nTelefone: " + this.getTelefone() +
                "\nBanco: " + this.getBanco() +
                "\nConta: " + this.getConta());
    }
}
