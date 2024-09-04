package javaFx.org.telaInicial;
import javaFx.org.geralController.geralController;
import javaFx.org.loginCliente.loginClienteApplication;

import javaFx.org.loginCliente.loginClienteApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class telaInicialController {
    @FXML
    private Button ButtonCliente;

    @FXML
    private Button ButtonFuncionario;

    @FXML
    private Label welcomeText;



    @FXML
    protected void onHelloClienteButtonClick(ActionEvent event) throws IOException {

        geralController a = new geralController();
       a.trocarLoginCliente(event);
    }
    @FXML
    protected void onHelloFuncionarioButtonClick(ActionEvent event) {
        welcomeText.setText("Welcome Funcionario!");
    }
}
