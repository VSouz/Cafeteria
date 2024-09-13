package model.dao;
import model.entities.cliente;
import model.entities.funcionario;
import model.entities.pedido;

import java.util.List;

public interface PedidoDAO {

    pedido fazerPedido(pedido p, cliente c, funcionario f);
    void cancelarPedido(int id_p);
    void alterarPedido(int id_p, pedido p);
    List<pedido> listarPedidos();
}
