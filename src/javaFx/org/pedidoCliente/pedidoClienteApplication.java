package javaFx.org.pedidoCliente;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class pedidoClienteApplication extends Application {

    private  static  Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/resources/org/pedidoCliente/pedidoCliente-view.fxml"));
        scene = new Scene(fxmlLoader.load());
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/resources/icons/iconLogo.png")));

        stage.initModality(Modality.APPLICATION_MODAL);

        stage.setTitle("Cafeteria.Java - Pedido");
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args){launch(args);}
}
