package javaFx.org.pedidoCliente;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.CheckBox;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import model.entities.produto;
import model.dao.impl.DAOfactory;

import java.net.URL;
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
    private ListView<produto> carrinho;
    @FXML
    private Button confirmar;
    @FXML
    private Button cancelar;

    private produto p = new produto();


    private ObservableList<produto> carrinhoItens = FXCollections.observableArrayList();



    public void initialize(URL location, ResourceBundle resources) {
        selectCol.setCellFactory(CheckBoxTableCell.forTableColumn(selectCol));
        selectCol.setCellValueFactory(param -> new SimpleBooleanProperty(false));

        nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        preco.setCellValueFactory(new PropertyValueFactory<>("preco"));

        ObservableList<produto> lista = FXCollections.observableArrayList(DAOfactory.createProdutoDao().buscarTodosOsProdutos());
        tabela_principal.setItems(lista);

//        selectCol.setCellValueFactory(new PropertyValueFactory<>("selected"));
//        selectCol.setCellFactory(col -> new CheckBoxTableCell<produto, Boolean>() {
//            @Override
//            public void updateItem(Boolean item, boolean empty) {
//                super.updateItem(item, empty);
//                if (empty || item == null) {
//                    setGraphic(null);
//                } else {
//                    CheckBox checkBox = new CheckBox();
//                    checkBox.selectedProperty().bindBidirectional(getTableRow().getItem().selectedProperty());
//                    checkBox.selectedProperty().addListener((obs, wasSelected, isSelected) -> {
//                        produto p = getTableRow().getItem();
//                        if (isSelected) {
//                            if (!carrinhoItens.contains(p)) {
//                                carrinhoItens.add(p);
//                            }
//                        } else {
//                            carrinhoItens.remove(p);
//                        }
//                        carrinho.setItems(carrinhoItens);
//                    });
//                    setGraphic(checkBox);
//                }
//            }
//        });
                }
            }





