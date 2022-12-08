package data;

import model.Proprietario;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProprietarioDAOSQLite implements ProprietarioDAO{

    @Override
    public void salvar(Proprietario proprietario) {
        String sql = "INSERT INTO proprietario values (?, ?, ?, ?, ?, ?)";
        try(PreparedStatement stmt=ConnectionFactory.criaStatement(sql)) {
            stmt.setInt(1 , proprietario.getId());
            stmt.setString(2, proprietario.getCpf());
            stmt.setString(3, proprietario.getNome());
            stmt.setString(4, proprietario.getTelefone());
            stmt.setString(5, proprietario.getBanco());
            stmt.setString(6, proprietario.getConta());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void atualizar(Proprietario proprietario) {
        String sql = "UPDATE proprietario SET id=?, cpf=?, nome=?, telefone=?, banco=?, conta=?  WHERE id=?";
        try(PreparedStatement stmt=ConnectionFactory.criaStatement(sql)) {
            stmt.setInt(1 , proprietario.getId());
            stmt.setString(2, proprietario.getCpf());
            stmt.setString(3, proprietario.getNome());
            stmt.setString(4, proprietario.getTelefone());
            stmt.setString(5, proprietario.getBanco());
            stmt.setString(6, proprietario.getConta());
            stmt.setInt(7 , proprietario.getId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void apagar(Proprietario proprietario) {
        String sql = "DELETE FROM proprietario WHERE id=?";
        try(PreparedStatement stmt=ConnectionFactory.criaStatement(sql)){
            stmt.setInt(1,proprietario.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Proprietario buscar(int id) {
        Proprietario proprietario=null;
        String sql = "SELECT * FROM proprietario WHERE id=?";
        try(PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                proprietario = new Proprietario(rs.getInt("id"), rs.getString("cpf"), rs.getString("nome"), rs.getString("telefone"), rs.getString("banco"), rs.getString("conta"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return proprietario;
    }

    @Override
    public List<Proprietario> buscarTodos() {
        String sql = "SELECT * FROM proprietario";
        List<Proprietario> listaProprietario =new ArrayList<>();
        try(PreparedStatement stmt = ConnectionFactory.criaStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Proprietario proprietario = new Proprietario(rs.getInt("id"), rs.getString("cpf"), rs.getString("nome"), rs.getString("telefone"), rs.getString("banco"), rs.getString("conta"));
                listaProprietario.add(proprietario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaProprietario;
    }
}