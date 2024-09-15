package model.dao;
import javafx.collections.ObservableList;
import model.entities.cliente;
import model.entities.funcionario;
import model.entities.pedido;
import model.entities.produto;

import java.util.List;

public interface PedidoDAO {

    pedido fazerPedido(pedido p, cliente c, funcionario f);
    void cancelarPedido(int id_p);
    void alterarPedido(int id_p, pedido p);
    List<pedido> listarPedidos();

    public void alterarStatusPedido (pedido p);
    ObservableList<pedido> buscarTodosOsPedidos();
}
