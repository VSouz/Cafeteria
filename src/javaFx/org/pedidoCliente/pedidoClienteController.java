package javaFx.org.pedidoCliente;

import javaFx.org.geralController.geralController;
import javaFx.org.homeCliente.homeClienteController;
import javaFx.org.loginCliente.loginClienteController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import model.entities.pedido;
import model.entities.pedidoDetalhe;
import model.entities.produto;
import model.entities.carrinho;
import model.dao.impl.DAOfactory;

import java.io.ByteArrayInputStream;
import java.io.IOException;


public class pedidoClienteController {



    @FXML
    private TableView<produto> listaDeProdutos;
    private produto produtoSelecionado;
    @FXML
    private Label produto;
    @FXML
    private Spinner<Integer> spinner;
    @FXML
    private ListView<carrinho> carrinho;
    @FXML
    private Label total;

    private geralController controle = new geralController();


    private ObservableList<carrinho> itensCarrinho = FXCollections.observableArrayList();

    public void initialize (){


        carrinho.setItems(itensCarrinho);
        carrinho.setCellFactory(param -> new ListCell<carrinho>() {
            @Override
            protected void updateItem(carrinho item, boolean empty) {
                super.updateItem(item, empty);

                if (empty || item == null) {
                    setText(null);
                } else {
                    setText(item.getProdutoNome() + " | Qtd: " + item.getQtd() + " | Total: " + item.getTotal());
                }
            }
        });


        TableColumn<produto, byte[]> colIdFoto = new TableColumn<>("Foto");
        colIdFoto.setCellValueFactory(new PropertyValueFactory<>("foto"));
        colIdFoto.setCellFactory(column -> new TableCell<produto, byte[]>() {
            private final ImageView imageView = new ImageView();

            @Override
            protected void updateItem(byte[] fotoBytes, boolean empty) {
                super.updateItem(fotoBytes, empty);

                if (empty || fotoBytes == null) {
                    setGraphic(null);
                } else {

                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(fotoBytes);
                    Image image = new Image(byteArrayInputStream);


                    imageView.setImage(image);
                    imageView.setFitHeight(150);
                    imageView.setFitWidth(150);
                    setGraphic(imageView);
                }
            }
        });


        TableColumn<produto, String >colIdNome = new TableColumn<>("Produto");
        colIdNome.setCellValueFactory(new PropertyValueFactory<>("nome"));


        TableColumn<produto, String> colIdPreco = new TableColumn<>("Preço R$");
        colIdPreco.setCellValueFactory(new PropertyValueFactory<>("preco"));

        colIdNome.setStyle("-fx-alignment: CENTER; -fx-font-weight: bold;");
        colIdPreco.setStyle("-fx-alignment: CENTER; -fx-font-weight: bold;");

        listaDeProdutos.getColumns().addAll(colIdFoto,colIdNome,colIdPreco);


        listaDeProdutos.setItems(DAOfactory.createProdutoDao().buscarTodosOsProdutos());

        listaDeProdutos.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {

                produtoSelecionado = newSelection;
                produto.setText(produtoSelecionado.getNome() + "  Preço:   " +  produtoSelecionado.getPreco());
                SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, produtoSelecionado.getQtd_estoque(), 0);
                spinner.setValueFactory(valueFactory);

            }
    });

    }

    @FXML
    public void onAdicionarAoCarrinhoClick(ActionEvent event) {

        carrinho novoItem = new carrinho();

        novoItem.setId_produto(produtoSelecionado.getId_produto());
        novoItem.setQtd(spinner.getValue());
        novoItem.setProdutoNome(produtoSelecionado.getNome());
        novoItem.setPreco(produtoSelecionado.getPreco());

        System.out.println(novoItem.getPreco());
        itensCarrinho.add(novoItem);
        total();
    }

    @FXML
    public void onRemoverDoCarrinhoClick(ActionEvent event) {

        carrinho itemSelecionado = carrinho.getSelectionModel().getSelectedItem();

        if (itemSelecionado != null) {

            itensCarrinho.remove(itemSelecionado);
            total();
        } else {

            System.out.println("Nenhum item selecionado para remover.");
        }
    }

    @FXML
    public void total(){

        double totalCarrinho = 0;

        for (carrinho item : itensCarrinho) {

            totalCarrinho += item.getPreco() * item.getQtd();
        }

        total.setText("Total: "+totalCarrinho);
    }

    @FXML
    public void onFinalizarPedidoClick() throws IOException {

        pedidoDetalhe p = new pedidoDetalhe();
        pedido pedido = new pedido();

        pedido.setCpf_cliente(loginClienteController.getInstance().getCpf());
        DAOfactory.createPedidoDaoJDBC().fazerPedido(pedido);


        for (carrinho item : itensCarrinho) {
            System.out.println(pedido.getId_pedido());
            p.setId_pedido(pedido.getId_pedido());
            p.setId_produto(item.getId_produto());
            p.setQuantidade(item.getQtd());
            p.setPreco_unitario(item.getPreco());
            DAOfactory.createDetalhePedidoJDBC().adicionarDetalhePedido(p);
        }

        controle.newStage("/mensagens/mensagemAccept.fxml");
        limparCarrinho();
    }

    public void limparCarrinho() {

        itensCarrinho.clear();

        produto.setText("");
        spinner.getValueFactory().setValue(0);
    }
}