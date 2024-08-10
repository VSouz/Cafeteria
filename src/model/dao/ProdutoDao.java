package model.dao;
import model.entities.produto;
public interface ProdutoDao {
    void cadastrarProduto(produto p);
    void removerProduto(produto p);
    void atualizarProduto(produto p);
}
