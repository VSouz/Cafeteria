package model.dao.impl;

import bancoDados.bancoDados;
import javaFx.org.geralController.geralController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.entities.cliente;
import model.dao.ClienteDao;
import model.entities.pedido;

import java.sql.*;

public class clienteDAO implements ClienteDao{

    private Connection conn;

    public clienteDAO(Connection conn) {
        this.conn = conn;
    }

    @Override
    public cliente cadastrarCliente(cliente c) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("insert into"+
                            " cliente(cpf,nome,email,endereco,telefone) values(?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);

            st.setString(1,c.getCpf());
            st.setString(2,c.getNome());
            st.setString(3,c.getEmail());
            st.setString(4,c.getEndereco());
            st.setString(5,c.getTelefone());

            int linha = st.executeUpdate();
            if (linha > 0) {
                ResultSet rs = st.getGeneratedKeys();
                if(rs.next()){
                    c.setCpf(rs.getString(1));
                }
                bancoDados.closeResultSet(rs);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            bancoDados.closedStatement(st);
        }
        return c;
    }

    public void atualizarCliente(String cpf, cliente c){
        PreparedStatement st = null;

        try {
            st = conn.prepareStatement("UPDATE cliente SET cpf=?, nome = ?, email = ?, endereco = ?, telefone = ? WHERE cpf = ?");
            st.setString(1,c.getCpf());
            st.setString(2,c.getNome());
            st.setString(3, c.getEmail());
            st.setString(4,c.getEndereco());
            st.setString(5,c.getTelefone());
            st.setString(6, cpf);
            st.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            bancoDados.closedStatement(st);
        }


    }

    public cliente procurarCliente(String cpf){
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement("select cpf, nome, email, endereco, telefone from cliente where cpf =?");
            st.setString(1,cpf);
            rs = st.executeQuery();

            if (rs.next()){
                cliente c = new cliente();
                c.setCpf(rs.getString("cpf"));
                c.setNome(rs.getString("nome"));
                c.setEmail(rs.getString("email"));
                c.setEndereco(rs.getString("endereco"));
                c.setTelefone(rs.getString("telefone"));
                return c;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally{
            bancoDados.closeResultSet(rs);
            bancoDados.closedStatement(st);
        }

        return null;
    }

    @Override
    public ObservableList<pedido> historicoPedidos(String cpf) {
        ObservableList<pedido> listaDePedidos = FXCollections.observableArrayList();

        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement("select id_pedido, cpf_cliente, status, data, id_funcionario from pedido where cpf_cliente = ?",  Statement.RETURN_GENERATED_KEYS);
            st.setString(1,cpf);
            rs = st.executeQuery();

            while (rs.next()){
                pedido p = new pedido();
                p.setId_pedido(rs.getInt("id_pedido"));
                p.setCpf_cliente(rs.getString("cpf_cliente"));
                p.setData(rs.getDate("data"));
                p.setStatus(rs.getString("status"));
                p.setId_funcionario(rs.getString("id_funcionario"));
                listaDePedidos.add(p);

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally{
            bancoDados.closeResultSet(rs);
            bancoDados.closedStatement(st);
        }
        return listaDePedidos;
    }

    @Override
    public void fazerPedido(cliente c) {

    }

    @Override
    public void removerCliente(String cpf) {
        PreparedStatement st = null;

        try {
            st = conn.prepareStatement("delete from cliente where cpf=?");
            st.setString(1,cpf);
            st.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            bancoDados.closedStatement(st);
        }

    }

    @Override
    public void verMenu() {

    }
}
