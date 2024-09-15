package model.dao.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.dao.PedidoDAO;
import model.entities.cliente;
import model.entities.funcionario;
import model.entities.pedido;

import java.sql.*;
import java.util.List;

import bancoDados.bancoDados;
import model.entities.produto;

public class pedidoDaoJDBC implements PedidoDAO {
    private Connection conn;

    public pedidoDaoJDBC(Connection conn) { this.conn = conn;}

    @Override
    public pedido fazerPedido(pedido p, cliente c, funcionario f) { //gambiarra temporaria
        PreparedStatement st = null;

        try {
            st = conn.prepareStatement("insert into pedido(cpf_cliente, status, data, id_funcionario)" +
                    " values(?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            st.setString(1,c.getCpf());
            st.setString(2,p.getStatus());
            st.setDate(3,new Date(p.getData().getTime()));
            st.setString(4,f.getCpf());
            int linha = st.executeUpdate();
            if (linha > 0){
                ResultSet rs = st.getGeneratedKeys();
                if (rs.next()){
                    p.setId_pedido(rs.getInt(1));
                }
                bancoDados.closeResultSet(rs);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            bancoDados.closedStatement(st);
        }
        return null;
    }

    @Override
    public void cancelarPedido(int id_p) {
        PreparedStatement st = null;

        try {
            st = conn.prepareStatement("delete from pedido where id_pedido = ?");
            st.setInt(1,id_p);
            st.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            bancoDados.closedStatement(st);
        }
    }

    @Override
    public void alterarPedido(int id_p, pedido p) {
        PreparedStatement st = null;

        try {
            st = conn.prepareStatement("Update pedido set status = ? where id_produto = ?");
            st.setString(1,p.getStatus());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<pedido> listarPedidos() {
        return List.of();
    }

    @Override
    public ObservableList<pedido> buscarTodosOsPedidos() {

        ObservableList<pedido> listaDePedidos = FXCollections.observableArrayList();

        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement("select id_pedido, cpf_cliente, status, data, id_funcionario from pedido",  Statement.RETURN_GENERATED_KEYS);
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
    public void alterarStatusPedido (pedido p) {

        PreparedStatement st = null;

        try {
            st = conn.prepareStatement("UPDATE pedido SET status = ? WHERE id_pedido = ?");
            st.setString(1,p.getStatus());
            st.setDouble(2, p.getId_pedido());

            st.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            bancoDados.closedStatement(st);
        }
    }
}
