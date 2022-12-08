package data;

import model.Imovel;
import model.Proprietario;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ImovelDAOSQLite implements ImovelDAO{

    @Override
    public void salvar(Imovel imovel) {
        String sql = "INSERT INTO imovel values (?, ?, ?, ?)";
        try(PreparedStatement stmt=ConnectionFactory.criaStatement(sql)) {
            stmt.setInt(1 , imovel.getIdImovel());
            stmt.setString(2, imovel.getEndereco());
            stmt.setDouble(3, imovel.getValorAluguel());
            stmt.setInt(4, imovel.getProprietario().getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void atualizar(Imovel imovel) {
        String sql = "UPDATE imovel SET idImovel=?, endereco=?, valorAluguel=?, proprietario=? WHERE idImovel=?";
        try(PreparedStatement stmt=ConnectionFactory.criaStatement(sql)) {
            stmt.setInt(1 , imovel.getIdImovel());
            stmt.setString(2, imovel.getEndereco());
            stmt.setDouble(3, imovel.getValorAluguel());
            stmt.setInt(4, imovel.getProprietario().getId());
            stmt.setInt(5, imovel.getIdImovel());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void apagar(Imovel imovel) {
        String sql = "DELETE FROM imovel WHERE idImovel=?";
        try(PreparedStatement stmt=ConnectionFactory.criaStatement(sql)){
            stmt.setInt(1,imovel.getIdImovel());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Imovel buscar(int id) {
        Imovel imovel=null;
        String sql = "SELECT * FROM imovel WHERE idImovel=?";
        try(PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Proprietario proprietario = new ProprietarioDAOSQLite().buscar(rs.getInt("proprietario"));
                imovel = new Imovel(rs.getInt("idImovel"), rs.getString("endereco"), rs.getDouble("valorAluguel"), proprietario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return imovel;
    }

    @Override
    public List<Imovel> buscarTodos() {
        String sql = "SELECT * FROM imovel";
        List<Imovel> listaImovel =new ArrayList<>();
        try(PreparedStatement stmt = ConnectionFactory.criaStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Proprietario proprietario = new ProprietarioDAOSQLite().buscar(rs.getInt("proprietario"));
                Imovel im = new Imovel(rs.getInt("idImovel"), rs.getString("endereco"), rs.getDouble("valorAluguel"), proprietario);
                listaImovel.add(im);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaImovel;
    }
}
