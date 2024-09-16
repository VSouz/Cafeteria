package javaFx.org.homeCliente;

import javaFx.org.geralController.geralController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

import javaFx.org.pedidoCliente.pedidoClienteApplication;
import javafx.stage.Stage;
import model.entities.pedido;

public class homeClienteController {

    @FXML
    protected void onCriarPedidoClick(ActionEvent event) throws IOException {
        pedidoClienteApplication a = new pedidoClienteApplication();
        a.start(new Stage());
    }

    @FXML
    protected void onSairClick(ActionEvent event) throws IOException {

        geralController a = new geralController();
        a.trocarLoginCliente(event);
    }
}
