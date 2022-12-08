package data;

import model.Inquilino;

import java.util.List;

public interface InquilinoDAO extends DAO<Inquilino> {
    void  salvar(Inquilino inquilino);
    void atualizar (Inquilino inquilino);
    void apagar (Inquilino inquilino);
    Inquilino buscar (int id);
    List<Inquilino> buscarTodos();
}