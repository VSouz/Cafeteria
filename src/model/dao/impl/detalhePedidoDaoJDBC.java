package model.dao.impl;

import model.dao.DetalhePedidoDAO;
import model.entities.pedidoDetalhe;
import model.entities.produto;

import bancoDados.bancoDados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class detalhePedidoDaoJDBC implements DetalhePedidoDAO {

    private Connection conn;
    public detalhePedidoDaoJDBC(Connection conn){this.conn = conn;}
    @Override
    public void adicionarDetalhePedido(pedidoDetalhe pd) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement("Insert into detalhe_pedido(id_pedido, preco_unitario, quantidade, id_produto) values (?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
            st.setInt(1,pd.getId_pedido());
            st.setDouble(2,pd.getPreco_unitario());
            st.setInt(3,pd.getQuantidade());
            st.setInt(4,pd.getId_produto());
            st.execute();
            rs = st.getGeneratedKeys();
            if (rs.next()){
                pd.setId_produto(rs.getInt(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            bancoDados.closeResultSet(rs);
            bancoDados.closedStatement(st);
        }
    }

    @Override
    public void verDetalhesPedido(pedidoDetalhe pd) {

    }
}
