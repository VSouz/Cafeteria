package javaFx.org.pedido;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class pedidoApplication extends Application {



    @Override
    public void start(Stage primayrStage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/resources/org/pedido/pedido-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.initStyle(StageStyle.UNDECORATED);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Cafeteria.Java");
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/resources/icons/iconLogo.png")));
        stage.setScene(scene);
        stage.show();

    }
    public static void main(String[] args){launch(args);}
}
