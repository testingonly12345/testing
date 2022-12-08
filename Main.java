import data.*;
import model.Aluguel;
import model.Imovel;
import model.Inquilino;
import model.Proprietario;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Proprietario prop1 = new Proprietario(1, "2121212133", "Richarlison Pombo", "199999999", "Banco do Brasil", "19999-9");
        ProprietarioDAO propDAO = new ProprietarioDAOSQLite();
        propDAO.salvar(prop1);

        Proprietario prop2 = new Proprietario(2, "324324324", "Mané", "293892983", "Santander", "121212-9");
        propDAO.salvar(prop2);
        Proprietario prop3 = new Proprietario(3, "32213123", "Zezim", "21321312", "Nubank", "145345-9");
        propDAO.salvar(prop3);

        prop3.setBanco("Bradesco");
        propDAO.atualizar(prop3);
        Proprietario printProp = propDAO.buscar(3);
        printProp.mostrarDados();
        System.out.println("--------------- Apagou o 3 ---------------");
        propDAO.apagar(printProp);

        List<Proprietario> listaProprietario= propDAO.buscarTodos();
        for (Proprietario p : listaProprietario )
            p.mostrarDados();



        Inquilino inq1 = new Inquilino(1, "929129192912", "Casemiro", "98192881", 12000.00);
        InquilinoDAO inquilinoDAO = new InquilinoDAOSQLite();
        inquilinoDAO.salvar(inq1);

        Inquilino inq2 = new Inquilino(2, "23432432", "Vini JR", "23213123", 20000.00);
        inquilinoDAO.salvar(inq2);

        Imovel imo1 = new Imovel(1, "Rua dos Palmares 218", 1000.00, prop1);
        ImovelDAO imovelDAO = new ImovelDAOSQLite();
        imovelDAO.salvar(imo1);

        System.out.println("---------Aluguel----------");
        Aluguel alu1 = new Aluguel(1, "12/01/2022", "12/12/2021", inq1, imo1);
        AluguelDAO aluguelDAO = new AluguelDAOSQLite();
        aluguelDAO.salvar(alu1);
        Aluguel alu2 = new Aluguel(2, "12/01/2022", "12/12/2021", inq2, imo1);
        aluguelDAO.salvar(alu2);
        Aluguel alu3 = new Aluguel(3, "12/01/2022", "12/12/2021", inq2, imo1);
        aluguelDAO.salvar(alu3);

        System.out.println("----------- todos alugueis ------------");
        List<Aluguel> listaAluguel= aluguelDAO.buscarTodos();
        for (Aluguel l : listaAluguel )
            l.mostrarDados();

        System.out.println("----------- alugueis de Vini JR------------");
        List<Aluguel> listaAluguelInquilino= aluguelDAO.buscarTodosInquilino(inq2);
        for (Aluguel l : listaAluguel )
            l.mostrarDados();
    }
}