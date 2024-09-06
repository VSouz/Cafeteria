package javaFx.org.loginCliente;

import javaFx.org.geralController.geralController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.dao.ClienteDao;
import model.dao.impl.DAOfactory;
import org.w3c.dom.events.Event;

import model.entities.cliente;

import java.io.IOException;
import java.sql.SQLException;

public class loginClienteController {

    @FXML
    private Button entrar;
    @FXML
    private Button cadastrar;

    @FXML
    private TextField cpf;

    @FXML
    private Button voltar;

    @FXML
    protected void onVoltarClick(ActionEvent event){
        geralController a = new geralController();
        a.trocarTelaInicial(event);
    }

    @FXML
    protected void onEntrarClick(ActionEvent event) throws IOException {
        cliente cliente = new cliente();
        cliente.setCpf(cpf.getText());
        System.out.println(cliente.getCpf());

        cliente c = DAOfactory.createClienteDao().procurarCliente(cpf.getText());
        geralController erro = new geralController();
        if (c == null){


            erro.newStage("/mensagens/mensagemErro.fxml");

        }else{
           erro.trocarHomeCliente(event);
        }
    }

}
