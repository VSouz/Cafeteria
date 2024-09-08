package javaFx.org.homeFuncionario;

import javaFx.org.geralController.geralController;
import javaFx.org.produto.produtoApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.stage.Stage;

import java.io.IOException;

public class homeFuncionarioController {

    private static Stage stage;


    @FXML
    protected  void onVoltarClick(ActionEvent event){
        geralController controle = new geralController();
        controle.trocarLoginFuncionario(event);
    }

    @FXML
    protected  void onProdutoClick(ActionEvent event){
        produtoApplication p = new produtoApplication();
        try {
            p.start(stage);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Stage getStage() {
        return stage;
    }
}
