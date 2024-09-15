package model.dao;
import model.entities.pedidoDetalhe;
import model.entities.produto;

public interface DetalhePedidoDAO {
    void adicionarDpedido(pedidoDetalhe pd);
    void verDetalhesPedido(pedidoDetalhe pd);
}
