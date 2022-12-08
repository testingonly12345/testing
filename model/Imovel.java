package model;

public class Imovel implements IMostrarDados{
    private int idImovel;
    private String endereco;
    private double valorAluguel;
    private Proprietario proprietario;

    public Imovel(int idImovel, String endereco, double valorAluguel, Proprietario proprietario) {
        this.idImovel = idImovel;
        this.endereco = endereco;
        this.valorAluguel = valorAluguel;
        this.proprietario = proprietario;
    }

    public int getIdImovel() {
        return idImovel;
    }

    public void setIdImovel(int idImovel) {
        this.idImovel = idImovel;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public double getValorAluguel() {
        return valorAluguel;
    }

    public void setValorAluguel(double valorAluguel) {
        this.valorAluguel = valorAluguel;
    }

    public Proprietario getProprietario() {
        return proprietario;
    }

    public void setProprietario(Proprietario proprietario) {
        this.proprietario = proprietario;
    }

    @Override
    public void mostrarDados() {
        System.out.println("________________________________");
        System.out.println("IdImovel: " + this.getIdImovel() +
                "\nEndereço: " + this.getEndereco() +
                "\nValor Aluguel: " + this.getValorAluguel() +
                "\nProprietario: ");
        this.getProprietario().mostrarDados();
    }
}
