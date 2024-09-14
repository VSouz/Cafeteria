package javaFx.org.cadastroFuncionario;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class cadastroFuncionarioApplication extends Application {

    private Scene scene;

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/resources/org/cadastroFuncionario/cadastroFuncionario-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();

        stage.initModality(Modality.APPLICATION_MODAL);

        stage.setTitle("Cafeteria.Java");
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/resources/icons/iconLogo.png")));
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args){launch(args);}
}
