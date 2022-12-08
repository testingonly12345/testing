package data;

import model.Aluguel;
import model.Imovel;
import model.Inquilino;
import model.Proprietario;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AluguelDAOSQLite implements AluguelDAO{

    @Override
    public void salvar(Aluguel aluguel) {
        String sql = "INSERT INTO aluguel values (?, ?, ?, ?, ?)";
        try(PreparedStatement stmt=ConnectionFactory.criaStatement(sql)) {
            stmt.setInt(1 , aluguel.getIdAluguel());
            stmt.setString(2, aluguel.getInicioContrato());
            stmt.setString(3, aluguel.getFimContrato());
            stmt.setInt(4, aluguel.getInquilino().getId());
            stmt.setInt(5, aluguel.getImovel().getIdImovel());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void atualizar(Aluguel aluguel) {
        String sql = "UPDATE aluguel SET idAluguel=?, inicioContrato=?, fimContrato=?, inquilino=?, imovel=? WHERE idAluguel=?";
        try(PreparedStatement stmt=ConnectionFactory.criaStatement(sql)) {
            stmt.setInt(1 , aluguel.getIdAluguel());
            stmt.setString(2, aluguel.getInicioContrato());
            stmt.setString(3, aluguel.getFimContrato());
            stmt.setInt(4, aluguel.getInquilino().getId());
            stmt.setInt(5, aluguel.getImovel().getIdImovel());
            stmt.setInt(6, aluguel.getIdAluguel());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void apagar(Aluguel aluguel) {
        String sql = "DELETE FROM aluguel WHERE idAluguel=?";
        try(PreparedStatement stmt=ConnectionFactory.criaStatement(sql)){
            stmt.setInt(1,aluguel.getIdAluguel());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Aluguel buscar(int id) {
        Aluguel aluguel=null;
        String sql = "SELECT * FROM aluguel WHERE idAluguel=?";
        try(PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Inquilino inquilino = new InquilinoDAOSQLite().buscar(rs.getInt("inquilino"));
                Imovel imovel = new ImovelDAOSQLite().buscar(rs.getInt("imovel"));
                aluguel = new Aluguel(rs.getInt("idAluguel"), rs.getString("inicioContrato"), rs.getString("fimContrato"), inquilino, imovel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return aluguel;
    }

    @Override
    public List<Aluguel> buscarTodos() {
        String sql = "SELECT * FROM aluguel";
        List<Aluguel> listaAluguel =new ArrayList<>();
        try(PreparedStatement stmt = ConnectionFactory.criaStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Inquilino inquilino = new InquilinoDAOSQLite().buscar(rs.getInt("inquilino"));
                Imovel imovel = new ImovelDAOSQLite().buscar(rs.getInt("imovel"));
                Aluguel aluguel = new Aluguel(rs.getInt("idAluguel"), rs.getString("inicioContrato"), rs.getString("fimContrato"), inquilino, imovel);
                listaAluguel.add(aluguel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaAluguel;
    }

    public List<Aluguel> buscarTodosInquilino(Inquilino inquilinoParam) {
        String sql = "SELECT * FROM aluguel WHERE inquilino=?";
        List<Aluguel> listaAluguel =new ArrayList<>();
        try(PreparedStatement stmt = ConnectionFactory.criaStatement(sql)) {
            stmt.setInt(1, inquilinoParam.getId());
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Inquilino inquilino = new InquilinoDAOSQLite().buscar(rs.getInt("inquilino"));
                Imovel imovel = new ImovelDAOSQLite().buscar(rs.getInt("imovel"));
                Aluguel aluguel = new Aluguel(rs.getInt("idAluguel"), rs.getString("inicioContrato"), rs.getString("fimContrato"), inquilino, imovel);
                listaAluguel.add(aluguel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaAluguel;
    }
}