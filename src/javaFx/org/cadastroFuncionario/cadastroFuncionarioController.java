package javaFx.org.cadastroFuncionario;


import javaFx.org.geralController.geralController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import model.dao.impl.DAOfactory;
import model.entities.funcionario;

import java.io.IOException;


public class cadastroFuncionarioController {

    @FXML
    private TextField nome;
    @FXML
    private TextField cpf;
    @FXML
    private TextField cargo;
    @FXML
    private TextField email;
    @FXML
    private TextField telefone;
    @FXML
    private Button salvar;
    @FXML
    private TextField nomeAtl;
    @FXML
    private TextField cpfAtl;
    @FXML
    private TextField cargoAtl;
    @FXML
    private TextField emailAtl;
    @FXML
    private TextField telefoneAtl;
    @FXML
    private TextField busca;
    @FXML
    private TextField buscaAtl;
    @FXML
    private Button limpar;
    @FXML
    private ListView<funcionario> listaFuncio;

    geralController controle = new geralController();

    @FXML
    public void salvar(ActionEvent event) throws IOException {
        funcionario func = new funcionario();
        func.setNome(nome.getText());
        func.setCpf(cpf.getText());
        func.setCargo(cargo.getText());
        func.setEmail(email.getText());
        func.setTelefone(telefone.getText());
        if (nome.getText().isEmpty() || cpf.getText().isEmpty() || cargo.getText().isEmpty() || email.getText().isEmpty() || telefone.getText().isEmpty()){
            controle.newStage("/mensagens/mensagemError.fxml");
        }else{
            funcionario f = DAOfactory.createFuncionarioDao().procurarFuncionario(cpf.getText());
            if (f == null){
                DAOfactory.createFuncionarioDao().cadastrarFuncionario(func);
                controle.newStage("/mensagens/mensagemAccept.fxml");
            }else {
                controle.newStage("/mensagens/mensagemError.fxml");

            }
        }
    }

    public void limparCampos(ActionEvent event){
        nome.setText(null);
        cargo.setText(null);
        email.setText(null);
        cpf.setText(null);
        telefone.setText(null);
        nomeAtl.setText(null);
        cargoAtl.setText(null);
        cpfAtl.setText(null);
        telefoneAtl.setText(null);
        emailAtl.setText(null);
    }
    public void initialize() {
        listaFuncio.setItems(DAOfactory.createFuncionarioDao().listarTodosFuncionarios());
        listaFuncio.setCellFactory(param -> new ListCell<funcionario>() {
            @Override
            protected void updateItem(funcionario func, boolean empty){
                super.updateItem(func, empty);
                if (empty || func == null){
                    setText(null);
                } else {
                    setText("CPF: " + func.getCpf() + " - Nome: " + func.getNome() +" - Cargo: " + func.getCargo()
                            + " - Email: " + func.getEmail() + " - Telefone "+ func.getTelefone());
                }
            }
        });
    }
    public void pesquisarPorNome(ActionEvent event) throws IOException{
        if (busca.getText().isEmpty()){
            initialize();
        }else {
            String nome = busca.getText().toLowerCase();
            funcionario p;
            p = DAOfactory.createFuncionarioDao().procurarFuncionario(nome);
            if (p != null){
                ObservableList<funcionario> list = FXCollections.observableArrayList();
                list.add(p);

                listaFuncio.setItems(list);
            }else {
                controle.newStage("/mensagens/mensagemErro.fxml");
            }
        }
    }

    public void atualizarFuncionario(ActionEvent event) throws IOException {
        if (buscaAtl.getText().isEmpty()){
            controle.newStage("/mensagens/mensagemError.fxml");
        }else {
            String id = buscaAtl.getText();
            funcionario f;
            f = DAOfactory.createFuncionarioDao().procurarFuncionario(id);
            if (f != null){
                nomeAtl.setText(f.getNome());
                cpfAtl.setText(f.getCpf());
                cargoAtl.setText(f.getCargo());
                emailAtl.setText(f.getEmail());
                telefoneAtl.setText(f.getTelefone());
            } else {
                controle.newStage("/mensagens/mensagemError.fxml");
            }
        }
    }

    public void salvarAtl(ActionEvent event) {
    }

    public void removerFuncionario(ActionEvent event) {
    }

    public void confirmarRemover(ActionEvent event) {
    }
}
