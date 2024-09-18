package javaFx.org.homeCliente;

import javaFx.org.geralController.geralController;
import javaFx.org.historicoCliente.historicoClienteApplication;
import javaFx.org.loginCliente.loginClienteController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;
import java.util.Date;

import javaFx.org.pedidoCliente.pedidoClienteApplication;
import javafx.stage.Stage;
import model.dao.impl.DAOfactory;
import model.entities.funcionario;
import model.entities.pedido;

public class homeClienteController {


    @FXML
    protected void onCriarPedidoClick(ActionEvent event) throws IOException {
        pedidoClienteApplication a = new pedidoClienteApplication();
        a.start(new Stage());

    }

    @FXML
    protected void onHistoricoClienteClick(ActionEvent event) throws IOException {
        historicoClienteApplication a = new historicoClienteApplication();
        a.start(new Stage());
    }

    @FXML
    protected void onSairClick(ActionEvent event) throws IOException {

        geralController a = new geralController();
        a.trocarLoginCliente(event);
    }
}
