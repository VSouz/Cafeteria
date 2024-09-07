package javaFx.org.geralController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class geralController {


    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    public Label msgErro;

    public void trocarLoginCliente (ActionEvent event){
        try {
            root = FXMLLoader.load(getClass().getResource("/resources/org/loginCliente/loginCliente-view.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void trocarLoginFuncionario (ActionEvent event){
        try {
            root = FXMLLoader.load(getClass().getResource("/resources/org/loginFuncionario/loginFuncionario-view.fxml"));
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
            root = FXMLLoader.load(getClass().getResource("/resources/org/telaInicial/telaInicial-view.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void trocarHomeCliente (ActionEvent event){
        try {
            root = FXMLLoader.load(getClass().getResource("/resources/org/homeCliente/homeCliente-view.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void trocarHomeFuncionario (ActionEvent event){
        try {
            root = FXMLLoader.load(getClass().getResource("/resources/org/homeFuncionario/homeFuncionario-view.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void trocarCadastroCliente(ActionEvent event){
        try {
            root = FXMLLoader.load(getClass().getResource("/resources/org/cadastroCliente/cadastroCliente-view.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Stage newStage(String url) throws IOException {
        Stage stage1 = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/resources/org"+url));
        Scene scene1 = new Scene(fxmlLoader.load());
        stage1.setScene(scene1);
        stage1.getIcons().add(new Image(getClass().getResourceAsStream("/resources/icons/aviso.png")));
        stage1.setTitle("AVISO");
        stage1.show();
        stage1.setResizable(false);
        return stage1;
    }

}
