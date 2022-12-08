package data;

import model.Imovel;

import java.util.List;

public interface ImovelDAO extends DAO<Imovel> {
    void  salvar(Imovel imovel);
    void atualizar (Imovel imovel);
    void apagar (Imovel imovel);
    Imovel buscar (int id);
    List<Imovel> buscarTodos();
}