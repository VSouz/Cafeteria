package model.dao;
import javafx.collections.ObservableList;
import model.entities.cliente;
import model.entities.pedido;

public interface ClienteDao {
    cliente cadastrarCliente(cliente c);
    void fazerPedido(cliente c);
    void removerCliente(String cpf);
    void atualizarCliente(String cpf, cliente c);
    void verMenu();
    cliente procurarCliente(String cpf);
    ObservableList<pedido> historicoPedidos(String cpf);

}
