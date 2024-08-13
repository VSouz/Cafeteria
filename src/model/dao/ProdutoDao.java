package model.dao;
import model.entities.produto;
public interface ProdutoDao {
    void cadastrarProduto(produto p);
    void procurarPorId(int id);
    void removerProduto(int id);
    void atualizarProduto(int id, produto p);
}
