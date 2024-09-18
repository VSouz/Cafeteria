package javaFx.org.historicoCliente;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;


public class historicoClienteApplication extends Application {

    private static Scene scene;
    private static Stage stage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/resources/org/historicoCliente/historicoCliente-view.fxml"));
        scene = new Scene(fxmlLoader.load());

        stage.initModality(Modality.APPLICATION_MODAL);

        stage.setTitle("Cafeteria.Java - Histórico");
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/resources/icons/iconLogo.png")));
        stage.setScene(scene);
        stage.show();
    }


}
