package model;

import model.dao.impl.produtoDAO;

import model.entities.produto;
//import javafx.application.Application;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.stage.Stage;

public class Main {

//    @Override
//    public void start(Stage primaryStage) throws Exception {
//        Parent root = FXMLLoader.load(getClass().getResource("/resources/sample.fxml"));
//        primaryStage.setTitle("Sample Application");
//        primaryStage.setScene(new Scene(root));
//        primaryStage.show();
//    }
    public static void main(String[] args) {

//        cliente pessoa = new cliente();
//
//        pessoa.setId_cliente(36);
//        pessoa.setNome("carlim");
//        pessoa.setEmail("carlim@gmail.com");
//        pessoa.setEndereco("saopaulo");
//        pessoa.setTelefone("9823984");
//
//        new clienteDAO().cadastrarCliente(pessoa);

        produto cerveja = new produto();
        cerveja.setId_produto(2);
        cerveja.setNome("cerveja");
        cerveja.setPreco(12.50F);
        cerveja.setQtd_estoque("3");

        new produtoDAO().cadastrarProduto(cerveja);

//        launch(args);
    }

}