package javaFx.org.loginCliente;

import javaFx.org.geralController.geralController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.w3c.dom.events.Event;

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
}
