package javaFx.org.homeFuncionario;

import javaFx.org.geralController.geralController;
import javaFx.org.pedido.pedidoApplication;
import javaFx.org.produto.produtoApplication;
import javaFx.org.cadastroFuncionario.cadastroFuncionarioApplication;
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

    @FXML
    protected void onPedidoClick(ActionEvent event){
        pedidoApplication pa = new pedidoApplication();
        try {
            pa.start(stage);
        } catch (IOException e){
            throw new RuntimeException(e);
        }

    }
    @FXML
    protected void onCadastroFuncionarioClick(ActionEvent event){
        cadastroFuncionarioApplication cf = new cadastroFuncionarioApplication();
        try {
            cf.start(stage);
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    public static Stage getStage() {
        return stage;
    }
}
