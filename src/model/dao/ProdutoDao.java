package model.dao;
import javafx.collections.ObservableList;
import model.entities.produto;
public interface ProdutoDao {
    void cadastrarProduto(produto p);
    produto procurarPorNome(String nome);
    produto procurarPorId(int id);
    void removerProduto(int id);
    void atualizarProduto(int id, produto p);

    ObservableList<produto> buscarTodosOsProdutos();
}
