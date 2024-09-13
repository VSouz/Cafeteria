package javaFx.org.homeFuncionario;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class homeFuncionarioApplication extends Application {

    private Scene scene;

    @Override
    public void start(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/resources/org/homeFuncionario/homeFuncionario-view.fxml"));
            scene = new Scene(fxmlLoader.load());
            stage.setScene(scene);
            stage.show();
        } catch (IOException e){
            e.printStackTrace();
            System.out.println("Erro ao carregar o FXML ou o ícone: " + e.getMessage());
        }


    }
    public static void main(String[] args){launch(args);}
}
