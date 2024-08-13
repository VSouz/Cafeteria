package model.dao.impl;

import bancoDados.bancoDados;
import model.dao.ProdutoDao;
import model.entities.produto;

import java.sql.*;

public class produtoDAO implements ProdutoDao {

    private Connection conn;
    public void cadastrarProduto(produto p) {
            PreparedStatement st = null;
        try {
            st = conn.prepareStatement("insert into"+
                            " produto(id_produto,nome,preco,qtd_estoque) values(?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);

            st.setInt(1,p.getId_produto());
            st.setString(2,p.getNome());
            st.setDouble(3,p.getPreco());
            st.setInt(4,p.getQtd_estoque());

            int linha = st.executeUpdate();


            if (linha > 0) {
                ResultSet rs = st.getGeneratedKeys();
                if(rs.next()){
                    p.setId_produto(rs.getInt(1));
                }
                bancoDados.closeResultSet(rs);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            bancoDados.closedStatement(st);
        }
    }

    @Override
    public void procurarPorId(int id) {

    }

    @Override
    public void removerProduto(int id) {

    }

    @Override
    public void atualizarProduto(int id, produto p) {

    }
}
