package javaFx.org.homeCliente;

import javaFx.org.geralController.geralController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class homeClienteController {

    @FXML
    protected void onSairClick(ActionEvent event) throws IOException {

        geralController a = new geralController();
        a.trocarLoginCliente(event);
    }
}
