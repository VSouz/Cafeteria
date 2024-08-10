package model.dao;
import model.entities.funcionario;
public interface FuncionarioDao {
    void cadastrarFuncionario(funcionario f);
    void atualizarFuncionario(funcionario f);
    void removerCliente(funcionario f);
}
