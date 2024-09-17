package javaFx.org.historicoCliente;

import javaFx.org.loginCliente.loginClienteController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import model.dao.impl.DAOfactory;
import model.entities.pedido;

import java.util.Date;

public class historicoClienteController {

    @FXML
    private Label titulo;
    @FXML
    private TableView<pedido> tabela_pedidos;

    @FXML
    void initialize(){
        titulo.setText("Historico de pedidos de " + loginClienteController.getInstance().getNome());

        TableColumn<pedido, Integer> colIdPedido = new TableColumn<>("ID Pedido");
        colIdPedido.setCellValueFactory(new PropertyValueFactory<>("id_pedido"));

        // Coluna ID do Cliente
        TableColumn<pedido, String >colIdCliente = new TableColumn<>("Cliente");
        colIdCliente.setCellValueFactory(new PropertyValueFactory<>("cpf_cliente"));


        TableColumn<pedido, String> colStatus = new TableColumn<>("Status");
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));


        TableColumn<pedido, Date> colDataPedido = new TableColumn<>("Data Pedido");
        colDataPedido.setCellValueFactory(new PropertyValueFactory<>("data"));


        tabela_pedidos.getColumns().addAll(colIdPedido, colIdCliente, colStatus, colDataPedido);


        tabela_pedidos.setItems(DAOfactory.createClienteDao().historicoPedidos(loginClienteController.getInstance().getCpf()));

    }

}
