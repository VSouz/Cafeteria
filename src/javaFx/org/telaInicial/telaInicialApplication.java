package javaFx.org.telaInicial;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class telaInicialApplication extends Application {


    static Stage stage;
    static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/resources/org/telaInicial/telaInicial-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Cafeteria.Java");
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/resources/icons/iconLogo.png")));
        stage.setScene(scene);
        stage.show();
    }


    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        telaInicialApplication.stage = stage;
    }

    public static Scene getScene() {
        return scene;
    }

    public static void setScene(Scene scene) {
        telaInicialApplication.scene = scene;
    }

    public static void main(String[] args) {
        launch(args);
    }

}
