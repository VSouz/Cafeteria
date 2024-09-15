package javaFx.org.pedidoCliente;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.CheckBox;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import model.entities.pedidoDetalhe;
import model.entities.produto;
import model.dao.impl.DAOfactory;

import java.net.URL;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;


public class pedidoClienteController implements Initializable {
    @FXML
    private TableView<produto> tabela_principal;
    @FXML
    private TableColumn<produto, String> nome;
    @FXML
    private TableColumn<produto, Float> preco;
    @FXML
    private TableColumn<produto, Boolean> selectCol; // define tipo booleano
    @FXML
    private TableColumn<produto, Byte[]> foto;
    @FXML
    private ListView<String> carrinho;
    @FXML
    private Button confirmar;
    @FXML
    private Button cancelar;
    @FXML
    private TextField teste;


    private ObservableList<produto> produtos = FXCollections.observableArrayList();
    private ObservableList<String> carrinhoItens = FXCollections.observableArrayList();
    private ObservableList<produto> carrinhoProdutos = FXCollections.observableArrayList();


    public void initialize(URL location, ResourceBundle resources) {
        selectCol.setCellFactory(CheckBoxTableCell.forTableColumn(selectCol));
        selectCol.setCellValueFactory(param -> new SimpleBooleanProperty(false));

        nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        preco.setCellValueFactory(new PropertyValueFactory<>("preco"));

        selectCol.setCellFactory(CheckBoxTableCell.forTableColumn(param -> {
            produto prod = tabela_principal.getItems().get(param);
            SimpleBooleanProperty booleanProperty = new SimpleBooleanProperty(false);

            booleanProperty.addListener((obs, wasSelect, isSelected) -> {
                if (isSelected){
                    carrinhoProdutos.add(prod);
                    carrinhoItens.add(prod.getNome());
                }else{
                    carrinhoItens.remove(prod.getNome());
                    carrinhoProdutos.remove(prod);
                }carrinho.setItems(carrinhoItens);
            });
            return booleanProperty;
        }));

        ObservableList<produto> lista = FXCollections.observableArrayList(DAOfactory.createProdutoDao().buscarTodosOsProdutos());
        tabela_principal.setItems(lista);


    }

    public void confirmarPedido(ActionEvent event){

        if(carrinhoProdutos.size() > 0){
            salvarCarrinho(carrinhoProdutos);
        } else {
            System.out.println("carro vazio ");
        }
    }
    private void salvarCarrinho(ObservableList<produto> itensCarrinho){

        //int idPedido = DAOfactory.createPedidoDaoJDBC().fazerPedido();

        for (produto p : itensCarrinho){
            pedidoDetalhe pd = new pedidoDetalhe();
            pd.setId_produto(p.getId_produto());

            DAOfactory.createDetalhePedidoJDBC().adicionarDpedido(pd);
        }
    }
            }





