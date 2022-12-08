package data;

import model.Aluguel;
import model.Inquilino;

import java.util.List;

public interface AluguelDAO extends DAO<Aluguel> {
    void  salvar(Aluguel aluguel);
    void atualizar (Aluguel aluguel);
    void apagar (Aluguel aluguel);
    Aluguel buscar (int id);
    List<Aluguel> buscarTodos();
    public List<Aluguel> buscarTodosInquilino(Inquilino inquilino);
}