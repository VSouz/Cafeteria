package model.dao.impl;

import bancoDados.bancoDados;
import model.entities.produto;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class produtoDAO {

    public void cadastrarProduto(produto produto) {
        String sql = "INSERT INTO produto (id_produto,nome, preco, qtd_estoque) VALUES (?,?,?,?)";

        PreparedStatement ps = null;

        try {
            ps = bancoDados.getbancoDados().prepareStatement(sql);
            ps.setInt(1, produto.getId_produto());
            ps.setString(2, produto.getNome());
            ps.setFloat(3, produto.getPreco());
            ps.setString(4, produto.getQtd_estoque());

            ps.execute();
            ps.close();

        } catch (
                SQLException e) {
            e.printStackTrace();
        }
    }
}
