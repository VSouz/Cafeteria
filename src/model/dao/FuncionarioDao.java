package model.dao;
import javafx.collections.ObservableList;
import model.entities.funcionario;
public interface FuncionarioDao {
    void cadastrarFuncionario(funcionario f);
    void atualizarFuncionario(String cpf, funcionario f);
    void removerFuncionario(String cpf);

    funcionario procurarFuncionario(String cpf);
    ObservableList<funcionario> listarTodosFuncionarios();
}
