package javaFx.org.produto;

import javaFx.org.geralController.geralController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javaFx.org.homeFuncionario.homeFuncionarioController;
import javafx.stage.Stage;
import model.dao.impl.DAOfactory;
import model.entities.cliente;
import model.entities.produto;

import java.io.ByteArrayInputStream;
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
    private ImageView fotoAtl;
    @FXML
    private TextField nomeAtl;
    @FXML
    private TextField qtdAtl;
    @FXML
    private TextField precoAtl;
    @FXML
    protected Button salvarAtl;

    @FXML
    private ListView<produto> listaDeProdutos;

    File file;

    @FXML
    private Button pesquisar;
    @FXML
    private TextField busca;
    @FXML
    private TextField buscaAtl;

    @FXML
    private TextField buscaRm;
    @FXML
    private Label resultadoRm;

    geralController controle = new geralController();



    @FXML
    void onFotoClick() throws IOException {
        handleFotoClick(foto);
    }

    @FXML
    void onFotoAltClick() throws IOException {
        handleFotoClick(fotoAtl);
    }
    @FXML
    void handleFotoClick(ImageView imageView) throws IOException {
        FileChooser fc = new FileChooser();
        file = fc.showOpenDialog(homeFuncionarioController.getStage());
        if(file!=null){
            imageView.setImage(new Image(file.toURI().toString()));
        }

    }
    @FXML
    public void salvar(ActionEvent event) throws IOException {

        produto produto = new produto();



        if(file!=null){
            byte[] fileBytes = Files.readAllBytes(file.toPath());
            produto.setFoto(fileBytes);
        }


        if (nome.getText().isEmpty() || file == null || preco.getText().isEmpty() || qtd.getText().isEmpty()){



            controle.newStage("/mensagens/mensagemErro.fxml");
//            produto.setNome(nome.getText().toLowerCase());
        }else{
            produto.setNome(nome.getText().toLowerCase());
            produto.setPreco(Float.parseFloat(preco.getText()));
            produto.setQtd_estoque(Integer.parseInt(qtd.getText()));

            DAOfactory.createProdutoDao().cadastrarProduto(produto);
            limparCampos();
            controle.newStage("/mensagens/mensagemAccept.fxml");
        }

    }

    private void limparCampos() {
        nome.setText("");
        preco.setText("");
        qtd.setText("");
        Image img = new Image(getClass().getResource("/resources/icons/fotoAdd.png").toString());
        foto.setImage(img);
        nomeAtl.setText("");
        precoAtl.setText("");
        qtdAtl.setText("");
        fotoAtl.setImage(img);
        resultadoRm.setText("");
        buscaRm.setText("");
        buscaAtl.setText("");
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
    protected void pesquisarPorNome() throws IOException {

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

                controle.newStage("/mensagens/mensagemErro.fxml");
            }
        }

    }

    @FXML
    protected void atualizarProduto() throws IOException {



        if (buscaAtl.getText().isEmpty()){

            controle.newStage("/mensagens/mensagemErro.fxml");

        }else{
            int id = Integer.parseInt(buscaAtl.getText());

            produto p;
            p = DAOfactory.createProdutoDao().procurarPorId(id);
            if (p != null) {

                Image image = new Image(new ByteArrayInputStream(p.getFoto()));
                fotoAtl.setImage(image);
                nomeAtl.setText(p.getNome());
                qtdAtl.setText(String.valueOf(p.getQtd_estoque()));
                precoAtl.setText(String.valueOf(p.getPreco()));

            }else {
                controle.newStage("/mensagens/mensagemErro.fxml");
            }
        }
    }

    @FXML
    public void salvarAtl() throws IOException {

        int id = Integer.parseInt(buscaAtl.getText());
        produto produto = new produto();



        if(file!=null){
            byte[] fileBytes = Files.readAllBytes(file.toPath());
            produto.setFoto(fileBytes);
        }


        if (nomeAtl.getText().isEmpty() || fotoAtl == null || precoAtl.getText().isEmpty() || qtdAtl.getText().isEmpty()){



            controle.newStage("/mensagens/mensagemErro.fxml");
//            produto.setNome(nome.getText().toLowerCase());
        }else{
            produto.setNome(nomeAtl.getText().toLowerCase());
            produto.setPreco(Float.parseFloat(precoAtl.getText()));
            produto.setQtd_estoque(Integer.parseInt(qtdAtl.getText()));

            DAOfactory.createProdutoDao().atualizarProduto(id,produto);
            limparCampos();
            controle.newStage("/mensagens/mensagemAccept.fxml");
        }

    }

    @FXML
    protected void removerProduto(){

        int id = Integer.parseInt(buscaRm.getText());

        produto p = DAOfactory.createProdutoDao().procurarPorId(id);

        resultadoRm.setText("id: " + p.getId_produto() + "Nome: " + p.getNome());



    }

    @FXML
    protected  void confirmarRemover() throws IOException {
        int id = Integer.parseInt(buscaRm.getText());

        DAOfactory.createProdutoDao().removerProduto(id);

        resultadoRm.setText(null);

        controle.newStage("/mensagens/mensagemAccept.fxml");
    }


}

