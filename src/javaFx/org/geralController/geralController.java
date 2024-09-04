package javaFx.org.geralController;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class geralController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void trocarLoginCliente (ActionEvent event){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/resources/org/loginCliente/loginCliente-view.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public void trocarTelaInicial (ActionEvent event){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/resources/org/telaInicial/telaInicial-view.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
