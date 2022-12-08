package data;

import model.Proprietario;

import java.util.List;

public interface ProprietarioDAO extends DAO<Proprietario> {
    void  salvar(Proprietario proprietario);
    void atualizar (Proprietario proprietario);
    void apagar (Proprietario proprietario);
    Proprietario buscar (int id);
    List<Proprietario> buscarTodos();
}