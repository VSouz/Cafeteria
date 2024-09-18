package model.dao;
import model.entities.pedidoDetalhe;
import model.entities.produto;

public interface DetalhePedidoDAO {
    void adicionarDetalhePedido(pedidoDetalhe pd);
    void verDetalhesPedido(pedidoDetalhe pd);
}
