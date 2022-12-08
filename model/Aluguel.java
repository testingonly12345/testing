package model;

public class Aluguel implements IMostrarDados{
    private int idAluguel;
    private String inicioContrato;
    private String fimContrato;
    private Inquilino inquilino;
    private Imovel imovel;

    public Aluguel(int idAluguel, String inicioContrato, String fimContrato, Inquilino inquilino, Imovel imovel) {
        this.idAluguel = idAluguel;
        this.inicioContrato = inicioContrato;
        this.fimContrato = fimContrato;
        this.inquilino = inquilino;
        this.imovel = imovel;
    }

    public int getIdAluguel() {
        return idAluguel;
    }

    public void setIdAluguel(int idAluguel) {
        this.idAluguel = idAluguel;
    }

    public String getInicioContrato() {
        return inicioContrato;
    }

    public void setInicioContrato(String inicioContrato) {
        this.inicioContrato = inicioContrato;
    }

    public String getFimContrato() {
        return fimContrato;
    }

    public void setFimContrato(String fimContrato) {
        this.fimContrato = fimContrato;
    }

    public Inquilino getInquilino() {
        return inquilino;
    }

    public void setInquilino(Inquilino inquilino) {
        this.inquilino = inquilino;
    }

    public Imovel getImovel() {
        return imovel;
    }

    public void setImovel(Imovel imovel) {
        this.imovel = imovel;
    }

    @Override
    public void mostrarDados() {
        System.out.println("________________________________");
        System.out.println("________________________________");
        System.out.println("IdAluguel: " + this.getIdAluguel() +
                "\ninicioContrato: " + this.getInicioContrato() +
                "\nfimContrato: " + this.getFimContrato() +
                "\nImovel: ");
        this.getImovel().mostrarDados();
        System.out.println("Inquilino:");
        this.getInquilino().mostrarDados();
    }
}
