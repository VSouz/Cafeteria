package javaFx.org.loginFuncionario;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class loginFuncionarioApplication extends Application {

    private Scene scene;

    @Override
    public void start(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/resources/org/loginFuncionario/loginFuncionario-view.fxml"));
            scene = new Scene(fxmlLoader.load());
            stage.getIcons().add(new Image(getClass().getResourceAsStream("/resources/icons/iconLogo.png")));
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Erro ao carregar o FXML ou o ícone: " + e.getMessage());
        }
    }

    public static void main(String[] args){launch(args);}
}
