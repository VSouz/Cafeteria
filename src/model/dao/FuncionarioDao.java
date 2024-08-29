package model.dao;
import model.entities.funcionario;
public interface FuncionarioDao {
    void cadastrarFuncionario(funcionario f);
    void atualizarFuncionario(String cpf, funcionario f);
    void removerFuncionario(String cpf);

    funcionario procurarFuncionario(String cpf);
}
