package javaFx.org.pedido;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class pedidoApplication extends Application {

    private Scene scene;

    @Override
    public void start(Stage stage) throws IOException {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/resources/org/pedido/pedido-view.fxml"));
            scene = new Scene(fxmlLoader.load());
            stage.setScene(scene);
            stage.show();


    }
    public static void main(String[] args){launch(args);}
}
