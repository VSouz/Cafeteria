package javaFx.org.pedido;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import model.dao.impl.DAOfactory;
import model.entities.pedido;

import java.util.Date;

public class pedidoController {

    @FXML
    private TableView<pedido> tabela_pedidos;

    @FXML
    private ChoiceBox statusEscolha;

    @FXML
    private Label pedido;
    private pedido pedidoSelecionado;



    public void initialize (){

        TableColumn<pedido, Integer> colIdPedido = new TableColumn<>("ID Pedido");
        colIdPedido.setCellValueFactory(new PropertyValueFactory<>("id_pedido"));

        // Coluna ID do Cliente
        TableColumn<pedido, String >colIdCliente = new TableColumn<>("Cliente");
        colIdCliente.setCellValueFactory(new PropertyValueFactory<>("cpf_cliente"));

        // Coluna ID do Funcionário
        TableColumn<pedido, String> colIdFuncionario = new TableColumn<>("Funcionário");
        colIdFuncionario.setCellValueFactory(new PropertyValueFactory<>("id_funcionario"));

        // Coluna Status (usando ChoiceBox dentro da tabela)
        TableColumn<pedido, String> colStatus = new TableColumn<>("Status");
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));

        // Definindo a ChoiceBox para a coluna Status
        ObservableList<String> statusOptions = FXCollections.observableArrayList("Pendente", "Processando", "Concluido", "Cancelado");
        colStatus.setCellFactory(ComboBoxTableCell.forTableColumn(statusOptions));

        // Coluna Data do Pedido
        TableColumn<pedido, Date> colDataPedido = new TableColumn<>("Data Pedido");
        colDataPedido.setCellValueFactory(new PropertyValueFactory<>("data"));

        // Adicionando as colunas na TableView
        tabela_pedidos.getColumns().addAll(colIdPedido, colIdCliente, colIdFuncionario, colStatus, colDataPedido);


        tabela_pedidos.setItems(DAOfactory.createPedidoDaoJDBC().buscarTodosOsPedidos());


        tabela_pedidos.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {

                pedidoSelecionado = newSelection;
                pedido.setText("  ID:   " + pedidoSelecionado.getId_pedido() + "  Cliente:   " + pedidoSelecionado.getCpf_cliente()+ "  Status:");
                statusEscolha.setValue(pedidoSelecionado.getStatus());
                statusEscolha.setItems(statusOptions);
            }
        });

    }

    @FXML
    protected void onSalvarClick(){

        pedido p = new pedido();

        p.setId_pedido(pedidoSelecionado.getId_pedido());
        p.setStatus(statusEscolha.getValue().toString());
        p.setData(pedidoSelecionado.getData());
        p.setCpf_cliente(pedidoSelecionado.getCpf_cliente());
        p.setId_funcionario(pedidoSelecionado.getId_funcionario());

        DAOfactory.createPedidoDaoJDBC().alterarStatusPedido(p);
        tabela_pedidos.setItems(DAOfactory.createPedidoDaoJDBC().buscarTodosOsPedidos());


        System.out.println(p.getId_pedido());
        System.out.println(p.getCpf_cliente());
        System.out.println(p.getId_funcionario());
        System.out.println(p.getData());
        System.out.println(p.getStatus());

    }

}
