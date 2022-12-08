package data;

import model.Inquilino;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InquilinoDAOSQLite implements InquilinoDAO{

    @Override
    public void salvar(Inquilino inquilino) {
        String sql = "INSERT INTO inquilino values (?, ?, ?, ?, ?)";
        try(PreparedStatement stmt=ConnectionFactory.criaStatement(sql)) {
            stmt.setInt(1 , inquilino.getId());
            stmt.setString(2, inquilino.getCpf());
            stmt.setString(3, inquilino.getNome());
            stmt.setString(4, inquilino.getTelefone());
            stmt.setDouble(5, inquilino.getRendaMensal());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void atualizar(Inquilino inquilino) {
        String sql = "UPDATE inquilino SET id=?, cpf=?, nome=?, telefone=?, rendaMensal=? WHERE id=?";
        try(PreparedStatement stmt=ConnectionFactory.criaStatement(sql)) {
            stmt.setInt(1 , inquilino.getId());
            stmt.setString(2, inquilino.getCpf());
            stmt.setString(3, inquilino.getNome());
            stmt.setString(4, inquilino.getTelefone());
            stmt.setDouble(5, inquilino.getRendaMensal());
            stmt.setInt(6 , inquilino.getId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void apagar(Inquilino inquilino) {
        String sql = "DELETE FROM inquilino WHERE id=?";
        try(PreparedStatement stmt=ConnectionFactory.criaStatement(sql)){
            stmt.setInt(1,inquilino.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Inquilino buscar(int id) {
        Inquilino inquilino=null;
        String sql = "SELECT * FROM inquilino WHERE id=?";
        try(PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                inquilino = new Inquilino(rs.getInt("id"), rs.getString("cpf"), rs.getString("nome"), rs.getString("telefone"), rs.getDouble("rendaMensal"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return inquilino;
    }

    @Override
    public List<Inquilino> buscarTodos() {
        String sql = "SELECT * FROM inquilino";
        List<Inquilino> listaInquilino =new ArrayList<>();
        try(PreparedStatement stmt = ConnectionFactory.criaStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Inquilino inquilino = new Inquilino(rs.getInt("id"), rs.getString("cpf"), rs.getString("nome"), rs.getString("telefone"), rs.getDouble("rendaMensal"));
                listaInquilino.add(inquilino);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaInquilino;
    }
}