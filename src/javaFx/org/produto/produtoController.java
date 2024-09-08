package javaFx.org.produto;

import javaFx.org.geralController.geralController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javaFx.org.homeFuncionario.homeFuncionarioController;
import javafx.stage.Stage;
import model.dao.impl.DAOfactory;
import model.entities.cliente;
import model.entities.produto;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class produtoController {

    @FXML
    private ImageView foto;
    @FXML
    private TextField nome;
    @FXML
    private TextField qtd;
    @FXML
    private TextField preco;
    @FXML
    protected Button salvar;

    @FXML
    private ListView<produto> listaDeProdutos;

    File file;

    @FXML
    private Button pesquisar;
    @FXML
    private TextField busca;

    @FXML
    void onFotoClick() throws IOException {
        FileChooser fc = new FileChooser();
        file = fc.showOpenDialog(homeFuncionarioController.getStage());
        if(file!=null){
            foto.setImage(new Image(file.toURI().toString()));
        }

    }
    @FXML
    public void salvar(ActionEvent event) throws IOException {

        produto produto = new produto();

        produto.setNome(nome.getText().toLowerCase());
        produto.setPreco(Float.parseFloat(preco.getText()));
        produto.setQtd_estoque(Integer.parseInt(qtd.getText()));

        if(file!=null){
            byte[] fileBytes = Files.readAllBytes(file.toPath());
            produto.setFoto(fileBytes);
        }

        geralController controle = new geralController();

        if (nome.getText().isEmpty() || file == null || preco.getText().isEmpty() || qtd.getText().isEmpty()){

            controle.newStage("/mensagens/mensagemErro.fxml");
        }else{
            DAOfactory.createProdutoDao().cadastrarProduto(produto);
            limparCampos();
            controle.newStage("/mensagens/mensagemAccept.fxml");
        }

    }

    private void limparCampos() {
        nome.setText(null);
        preco.setText(null);
        qtd.setText(null);
        Image img = new Image(getClass().getResource("/resources/icons/fotoAdd.png").toString());
        foto.setImage(img);
    }



    public void initialize() {

        listaDeProdutos.setItems(DAOfactory.createProdutoDao().buscarTodosOsProdutos());
        listaDeProdutos.setCellFactory(param -> new ListCell<produto>() {
            @Override
            protected void updateItem(produto produto, boolean empty) {
                super.updateItem(produto, empty);
                if (empty || produto == null) {
                    setText(null);
                } else {

                    setText("ID:  " + produto.getId_produto() + " -  " + produto.getNome() + "   - Preço: R$ " + produto.getPreco() + "    - Qtd:  " + produto.getQtd_estoque());
                }
            }
        });
    }

    @FXML
    protected void pesquisarId(ActionEvent event) throws IOException {

        if (busca.getText().isEmpty()){
            initialize();
        }else{
            String nome = busca.getText().toLowerCase();

            produto p;
            p = DAOfactory.createProdutoDao().procurarPorNome(nome);
            if (p != null) {
                ObservableList<produto> lista = FXCollections.observableArrayList();
                lista.add(p);

                listaDeProdutos.setItems(lista);
            }else {
                geralController erro = new geralController();
                erro.newStage("/mensagens/mensagemErro.fxml");
            }
        }

    }


}

