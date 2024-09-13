package model.dao.impl;

import model.dao.PedidoDAO;
import model.entities.cliente;
import model.entities.funcionario;
import model.entities.pedido;

import java.sql.*;
import java.util.List;

import bancoDados.bancoDados;

public class pedidoDaoJDBC implements PedidoDAO {
    private Connection conn;

    public pedidoDaoJDBC(Connection connection) { this.conn = conn;}

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
}
