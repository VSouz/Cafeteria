package model.dao.impl;

import bancoDados.bancoDados;
import model.entities.cliente;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class clienteDAO {

    public  void cadastrarCliente( cliente cliente){

        String sql = "INSERT INTO cliente (id_cliente,nome, email, endereco, telefone) VALUES (?,?,?,?,?)";

        PreparedStatement ps = null;

        try {
            ps = bancoDados.getbancoDados().prepareStatement(sql);
            ps.setString(1, String.valueOf(cliente.getId_cliente()));
            ps.setString(2, cliente.getNome());
            ps.setString(3, cliente.getEmail());
            ps.setString(4, cliente.getEndereco());
            ps.setString(5, cliente.getTelefone());

            ps.execute();
            ps.close();

        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
