package model;

import model.dao.impl.DAOfactory;
import model.entities.cliente;
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

        // PROCURAR POR ID
//        cliente a = DAOfactory.createClienteDao().procurarCliente(12);
//        System.out.println(a.toString());
//        produto a = DAOfactory.createProdutoDao().procurarPorId(2);
//        System.out.println(a.toString());


        // PROCURAR TODOS
        /*List<Departamento> lista = new ArrayList<>();
        lista = DaoFactory.createDepartamentoDao().procurarTodos();
        System.out.println(lista.toString());*/

        // INSERT
//        cliente c = new cliente();
//        c.setId_cliente(12);
//        c.setNome("Ana");
//        c.setEmail("ana@gmail.com");
//        c.setEndereco("Rua 5");
//        c.setTelefone("23232341");
//
//        DAOfactory.createClienteDao().cadastrarCliente(c);

//        produto p = new produto();
//        p.setId_produto(3);
//        p.setNome("Café");
//        p.setQtd_estoque(5);
//        p.setPreco(3.5F);
//
//        DAOfactory.createProdutoDao().cadastrarProduto(p);

        //UPDATE
//        cliente d = new cliente();
//        d.setNome("Carlim Pro");
//        d.setEmail("carlim@gmail.com");
//        d.setEndereco("Rua 3");
//        d.setTelefone("2332212");
//
//        DAOfactory.createClienteDao().atualizarCliente(36,d);
//
//          produto d = new produto();
//          d.setNome("Pão");
//          d.setPreco(1f);
//          d.setQtd_estoque(10);
//
//          DAOfactory.createProdutoDao().atualizarProduto(2,d);
//        // DELETE
//        DAOfactory.createClienteDao().removerCliente(12);

//         DAOfactory.createProdutoDao().removerProduto(1);

    }
}