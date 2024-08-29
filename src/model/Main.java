package model;

import model.dao.ClienteDao;
import model.dao.impl.DAOfactory;
import model.entities.cliente;
import model.entities.funcionario;
import model.entities.produto;
import model.dao.impl.clienteDAO;
import java.util.Scanner;
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

        //UPDATE
//        cliente d = new cliente();
//        d.setNome("Carlim Pro");
//        d.setEmail("carlim@gmail.com");
//        d.setEndereco("Rua 3");
//        d.setTelefone("2332212");
//
//        DAOfactory.createClienteDao().atualizarCliente(36,d);
//
//        // DELETE
//        DAOfactory.createClienteDao().removerCliente(12);
        menu();
    }

    public static void menu(){
        Scanner scanNum = new Scanner(System.in);
        Scanner scanSt = new Scanner(System.in);
        int op;

        do {
            System.out.println("escolha uma opção");
            System.out.println("1 - Cliente      ");
            System.out.println("2 - Funcionario  ");
            System.out.println("3 - Produto      ");
            System.out.println("0 - Sair         ");
            op = scanNum.nextInt();
            switch (op){
                case 1:
                    clienteMenu();
                    break;
                case 2:
                    funcionarioMenu();
                    break;
                case 3:
                    produtoMenu();
                    break;
                case 0:
                    System.out.println("Saindo ....");
                    break;
                default:
                    System.out.println("escolha outra");
                    break;
            }

        }while (op != 0);
    }
    public static void clienteMenu(){
        Scanner scanNum = new Scanner(System.in);
        Scanner scanStr = new Scanner(System.in);
        int op;
        String id;

        do {
            System.out.println("escolha uma opção  ");
            System.out.println("1 - Cadastrar      ");
            System.out.println("2 - Remover        ");
            System.out.println("3 - Atualizar      ");
            System.out.println("4 - Procurar por id");
            System.out.println("0 - Voltar         ");
            op = scanNum.nextInt();
            switch (op){
                case 1:
                    addCliente();
                    break;
                case 2:
                    System.out.println("qual cliente remover? ");
                    id = scanStr.next();
                    removeCliente(id);
                    break;
                case 3:
                    System.out.println("qual cliente atualizar? ");
                    id = scanStr.next();
                    updateCliente(id);
                    break;
                case 4:
                    System.out.println("qual cliente procurar (digite ID)? ");
                    id = scanStr.next();
                    searchCliente(id);
                    break;
                case 0:
                    System.out.println("Saindo (/'-')/<3");
                    break;
                default:
                    System.out.println("escolha outra :p");
                    break;
            }

        }while (op != 0);

    }
    public static void funcionarioMenu(){
        Scanner scanNum = new Scanner(System.in);
        Scanner scanStr = new Scanner(System.in);
        int op, id;
        String cpf;

        do {
            System.out.println("escolha uma opção  ");
            System.out.println("1 - Cadastrar      ");
            System.out.println("2 - Remover        ");
            System.out.println("3 - Atualizar      ");
            System.out.println("4 - Procurar por id");
            System.out.println("0 - Voltar         ");
            op = scanNum.nextInt();
            switch (op){
                case 1:
                    addFuncio();
                    break;
                case 2:
                    System.out.println("qual funcionario deseja remover? ");
                    id = scanNum.nextInt();
                    removeFuncio(id);
                    break;
                case 3:
                    System.out.println("qual funcionario deseja atualizar? ");
                    cpf = scanStr.next();
                    updateFuncio(cpf);
                    break;
                case 4:
                    System.out.println("qual funcionario procurar (digite CPF)? ");
                    cpf = scanStr.next();
                    searchFuncio(cpf);
                    break;
                case 0:
                    System.out.println("Saindo (/'-')/<3");
                    break;
                default:
                    System.out.println("escolha outra :p");
                    break;
            }

        }while (op != 0);
    }
    public static void produtoMenu(){
        Scanner scanNum = new Scanner(System.in);
        int op, id;

        do {
            System.out.println("escolha uma opção  ");
            System.out.println("1 - Cadastrar      ");
            System.out.println("2 - Remover        ");
            System.out.println("3 - Atualizar      ");
            System.out.println("4 - Procurar por id");
            System.out.println("0 - Voltar         ");
            op = scanNum.nextInt();
            switch (op){
                case 1:
                    addProduto();
                    break;
                case 2:
                    System.out.println("qual produto deseja remover? ");
                    id = scanNum.nextInt();
                    removeProduto(id);
                    break;
                case 3:
                    System.out.println("qual produto deseja atualizar? ");
                    id = scanNum.nextInt();
                    updateProduto(id);
                    break;
                case 4:
                    System.out.println("qual produto procurar (digite ID)? ");
                    id = scanNum.nextInt();
                    searchProduto(id);
                    break;
                case 0:
                    System.out.println("Saindo (/'-')/<3");
                    break;
                default:
                    System.out.println("escolha outra :p");
                    break;
            }

        }while (op != 0);
    }

    public static void addCliente(){

        Scanner scanSt = new Scanner(System.in);
        Scanner scanL = new Scanner(System.in);
        cliente c = new cliente();
        String cpf,nome, telefone, end, email;
        System.out.println("Digite o Cpf: ");
        cpf = scanL.nextLine();
        c.setCpf(cpf);
        System.out.println("Digite Nome: ");
        nome = scanL.nextLine();
        c.setNome(nome);
        System.out.println("Digite email: ");
        email = scanSt.next();
        c.setEmail(email);
        System.out.println("Digite endereço: ");
        end =scanL.nextLine();
        c.setEndereco(end);
        System.out.println("Digite telefone: ");
        telefone = scanSt.next();
        c.setTelefone(telefone);
        DAOfactory.createClienteDao().cadastrarCliente(c);
    }
    public static void removeCliente(String cpf){
        cliente c = new cliente();
        c = DAOfactory.createClienteDao().procurarCliente(cpf);
        if (c == null){
            System.out.println("Cliente não encontrado!");
        }else {
            DAOfactory.createClienteDao().removerCliente(cpf);
            System.out.println("Cliente Removido!");
        }
    }
    public static void updateCliente(String cpf){
        Scanner scanSt = new Scanner(System.in);
        Scanner scanL = new Scanner(System.in);
        cliente c = new cliente();
        c = DAOfactory.createClienteDao().procurarCliente(cpf);
        if (c == null){
            System.out.println("Cliente não encontrado!");
        }else{
            String nome, telefone, end, email;
            System.out.println("Digite novo Nome: ");
            nome = scanL.nextLine();
            c.setNome(nome);
            System.out.println("Digite novo email: ");
            email = scanSt.next();
            c.setEmail(email);
            System.out.println("Digite novo endereço: ");
            end =scanL.nextLine();
            c.setEndereco(end);
            System.out.println("Digite novo telefone: ");
            telefone = scanSt.next();
            c.setTelefone(telefone);
            DAOfactory.createClienteDao().atualizarCliente(cpf,c);
        }
    }
    public static void searchCliente(String cpf){
        cliente procurado = new cliente();
        procurado = DAOfactory.createClienteDao().procurarCliente(cpf);
        if (procurado == null){
            System.out.println("Cliente não encontrado!");
        }else{
        System.out.println(procurado.toString());
        }
    }

    public static void addFuncio(){
        Scanner scanSt = new Scanner(System.in);
        Scanner scanL = new Scanner(System.in);
        funcionario f = new funcionario();
        String cpf,nome, telefone, cargo, email;
        System.out.println("Digite o Cpf: ");
        cpf = scanL.nextLine();
        f.setCpf(cpf);
        System.out.println("Digite Nome: ");
        nome = scanL.nextLine();
        f.setNome(nome);
        System.out.println("Digite email: ");
        email = scanSt.next();
        f.setEmail(email);
        System.out.println("Digite cargo: ");
        cargo =scanL.next();
        f.setCargo(cargo);
        System.out.println("Digite telefone: ");
        telefone = scanSt.next();
        f.setTelefone(telefone);
        DAOfactory.createFuncionarioDao().cadastrarFuncionario(f);
    }
    public static void removeFuncio(int id){
//        DAOfactory.createFuncionarioDao().removerCliente(id);
    }
    public static void updateFuncio(String cpf){
        Scanner scanSt = new Scanner(System.in);
        Scanner scanL = new Scanner(System.in);
        funcionario f = new funcionario();
        String nome, telefone, cargo, email;
        System.out.println("Digite novo Nome: ");
        nome = scanL.nextLine();
        f.setNome(nome);
        System.out.println("Digite novo email: ");
        email = scanSt.next();
        f.setEmail(email);
        System.out.println("Digite novo cargo: ");
        cargo =scanL.nextLine();
        f.setCargo(cargo);
        System.out.println("Digite novo telefone: ");
        telefone = scanSt.next();
        f.setTelefone(telefone);
        DAOfactory.createFuncionarioDao().atualizarFuncionario(cpf, f);
    }
    public static void searchFuncio(String cpf){
        funcionario procurado = new funcionario();
        procurado = DAOfactory.createFuncionarioDao().procurarFuncionario(cpf);
        if (procurado == null){
            System.out.println("Funcionario não encontrado!");
        }else{
            System.out.println(procurado.toString());
        }
    }

    public static void addProduto(){
        Scanner scanNum = new Scanner(System.in);
        Scanner scanFlo = new Scanner(System.in);
        Scanner scanL = new Scanner(System.in);
        produto p = new produto();
        String nome;
        float preco;
        int quant_est;
        System.out.println("Digite Nome: ");
        nome = scanL.nextLine();
        p.setNome(nome);
        System.out.println("Digite preço: ");
        preco = scanFlo.nextFloat();
        p.setPreco(preco);
        System.out.println("Digite quantidade em estoque: ");
        quant_est =scanNum.nextInt();
        p.setQtd_estoque(quant_est);
        DAOfactory.createProdutoDao().cadastrarProduto(p);

    }
    public static void removeProduto(int id){

        produto p = new produto();
        p = DAOfactory.createProdutoDao().procurarPorId(id);

        if (p == null){
            System.out.println("Produto não encontrado!");
        }else{
            DAOfactory.createProdutoDao().removerProduto(id);
            System.out.println("Produto Removido!");
        }
    }
    public static void updateProduto(int id){
        Scanner scanNum = new Scanner(System.in);
        Scanner scanFlo = new Scanner(System.in);
        Scanner scanL = new Scanner(System.in);
        produto p = new produto();

        p = DAOfactory.createProdutoDao().procurarPorId(id);
        if (p == null){
            System.out.println("Produto não encontrado!");
        }else{
            String nome;
            float preco;
            int quant_est;
            System.out.println("Digite novo Nome: ");
            nome = scanL.nextLine();
            p.setNome(nome);
            System.out.println("Digite novo preço: ");
            preco = scanFlo.nextFloat();
            p.setPreco(preco);
            System.out.println("Digite novo quantidade em estoque: ");
            quant_est =scanNum.nextInt();
            p.setQtd_estoque(quant_est);
            DAOfactory.createProdutoDao().atualizarProduto(id,p);
        }
    }
    public static void searchProduto(int id){
        produto p = new produto();
        p = DAOfactory.createProdutoDao().procurarPorId(id);
        if (p == null){
            System.out.println("Produto não encontrado!");
        }else{
        System.out.println(p.toString());
        }
    }
}

