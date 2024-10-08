package model.dao.impl;

import bancoDados.bancoDados;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.dao.ProdutoDao;
import model.entities.produto;

import java.sql.*;

public class produtoDAO implements ProdutoDao {

    private Connection conn;

    public produtoDAO(Connection conn) {
        this.conn = conn;
    }

    public void cadastrarProduto(produto p) {
            PreparedStatement st = null;
        try {
            st = conn.prepareStatement("insert into"+
                            " produto(id_produto,nome,preco,qtd_estoque,foto) values(?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);

            st.setInt(1,p.getId_produto());
            st.setString(2,p.getNome());
            st.setDouble(3,p.getPreco());
            st.setInt(4,p.getQtd_estoque());
            st.setBytes(5,p.getFoto());

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
    public produto procurarPorNome(String nome) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement("select id_produto, nome, preco, qtd_estoque,foto from produto where nome like ?");
            st.setString(1,"%" + nome + "%");
            rs = st.executeQuery();

            while (rs.next()){
                produto p = new produto();
                p.setId_produto(rs.getInt("id_produto"));
                p.setNome(rs.getString("nome"));
                p.setPreco(rs.getFloat("preco"));
                p.setQtd_estoque(rs.getInt("qtd_estoque"));
                p.setFoto(rs.getBytes("foto"));
                return p;
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
    public produto procurarPorId(int id) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement("select id_produto, nome, preco, qtd_estoque,foto from produto where id_produto =?");
            st.setInt(1,id);
            rs = st.executeQuery();

            if (rs.next()){
                produto p = new produto();
                p.setId_produto(rs.getInt("id_produto"));
                p.setNome(rs.getString("nome"));
                p.setPreco(rs.getFloat("preco"));
                p.setQtd_estoque(rs.getInt("qtd_estoque"));
                p.setFoto(rs.getBytes("foto"));
                return p;
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
    public void removerProduto(int id) {

        PreparedStatement st = null;

        try {
            st = conn.prepareStatement("delete from produto where id_produto=?");
            st.setInt(1,id);
            st.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            bancoDados.closedStatement(st);
        }
    }

    @Override
    public void atualizarProduto(int id, produto p) {
        PreparedStatement st = null;

        try {
            st = conn.prepareStatement("UPDATE produto SET nome = ?, preco = ?, qtd_estoque = ?, foto = ? WHERE id_produto = ?");
            st.setString(1,p.getNome());
            st.setDouble(2, p.getPreco());
            st.setInt(3,p.getQtd_estoque());
            st.setBytes(4, p.getFoto());
            st.setInt(5, id);

            st.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            bancoDados.closedStatement(st);
        }
    }

    @Override
    public ObservableList<produto> buscarTodosOsProdutos() {
        ObservableList<produto> listaDeProdutos = FXCollections.observableArrayList();

        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement("select id_produto, nome, preco, qtd_estoque,foto from produto");
            rs = st.executeQuery();

            while (rs.next()){
                produto p = new produto();
                p.setId_produto(rs.getInt("id_produto"));
                p.setNome(rs.getString("nome"));
                p.setPreco(rs.getFloat("preco"));
                p.setQtd_estoque(rs.getInt("qtd_estoque"));
                p.setFoto(rs.getBytes("foto"));
                listaDeProdutos.add(p);

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally{
            bancoDados.closeResultSet(rs);
            bancoDados.closedStatement(st);
        }

        return listaDeProdutos;
    }

}
