package javaFx.org.cadastroCliente;

import javaFx.org.geralController.geralController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.dao.impl.DAOfactory;
import model.dao.impl.clienteDAO;
import model.entities.cliente;

import java.io.IOException;

public class cadastroClienteController {

    @FXML
    private Button cadastrar;

    @FXML
    private Button cancelar;

    @FXML
    private TextField cpf;
    @FXML
    private TextField nome;
    @FXML
    private TextField email;
    @FXML
    private TextField endereco;
    @FXML
    private TextField telefone;

    @FXML
    protected void cancelar(ActionEvent event){
        geralController voltar = new geralController();
        voltar.trocarLoginCliente(event);
    }

    @FXML
    protected void cadastrar(ActionEvent event) throws IOException {

        cliente cliente = new cliente();

        cliente.setCpf(cpf.getText());
        cliente.setNome(nome.getText());
        cliente.setEmail(email.getText());
        cliente.setEndereco(endereco.getText());
        cliente.setTelefone(telefone.getText());
        geralController controle = new geralController();

        if (telefone.getText().isEmpty() || cpf.getText().isEmpty() || nome.getText().isEmpty() || email.getText().isEmpty() || endereco.getText().isEmpty()){

            controle.newStage("/mensagens/mensagemErro.fxml");
        }else{
            System.out.println("cheguei aqui");
            cliente c = DAOfactory.createClienteDao().cadastrarCliente(cliente);
            controle.trocarLoginCliente(event);
        }





    }
}
