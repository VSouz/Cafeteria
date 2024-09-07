package javaFx.org.loginFuncionario;

import javaFx.org.geralController.geralController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.dao.impl.DAOfactory;
import model.entities.funcionario;

import java.io.IOException;

public class loginFuncionarioController {

    @FXML
    private Button entrar;

    @FXML
    private TextField cpf;


    @FXML
    protected void onVoltarClick(ActionEvent event){
        geralController tela = new geralController();
        tela.trocarTelaInicial(event);
    }

    @FXML
    protected void onEntrarClick(ActionEvent event) throws IOException {

        funcionario f = new funcionario();
        f = DAOfactory.createFuncionarioDao().procurarFuncionario(cpf.getText());

        geralController controle = new geralController();

        if (f == null){
            controle.newStage("/mensagens/mensagemErro.fxml");
        }else{
            controle.trocarHomeFuncionario(event);
        }
    }
}
