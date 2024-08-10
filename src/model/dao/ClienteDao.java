package model.dao;
import model.entities.cliente;
public interface ClienteDao {
    void cadastrarCliente(cliente c);
    void fazerPedido(cliente c);
    void removerCliente(cliente c);
    void atualizarCliente(cliente c);
    void verMenu();
}
