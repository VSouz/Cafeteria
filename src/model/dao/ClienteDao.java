package model.dao;
import model.entities.cliente;
public interface ClienteDao {
    void cadastrarCliente(cliente c);
    void fazerPedido(cliente c);
    void removerCliente(String cpf);
    void atualizarCliente(String cpf, cliente c);
    void verMenu();
    cliente procurarCliente(String cpf);

}
