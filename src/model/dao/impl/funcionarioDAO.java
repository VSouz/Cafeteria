package model.dao.impl;

import bancoDados.bancoDados;
import model.entities.funcionario;

import java.sql.PreparedStatement;
import java.sql.SQLException;
public class funcionarioDAO {

    public  void cadastrarFuncionario( funcionario funcionario){

        String sql = "INSERT INTO funcionario (cpf,nome, email, sexo, telefone) VALUES (?,?,?,?,?)";

        PreparedStatement ps = null;

        try {
            ps = bancoDados.getbancoDados().prepareStatement(sql);
            ps.setString(1, String.valueOf(funcionario.getCpf()));
            ps.setString(2, funcionario.getNome());
            ps.setString(3, funcionario.getEmail());
            ps.setString(4, funcionario.getSexo());
            ps.setString(5, funcionario.getTelefone());

            ps.execute();
            ps.close();

        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
