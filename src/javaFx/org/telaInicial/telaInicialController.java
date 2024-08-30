package javaFx.org.telaInicial;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class telaInicialController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}
