package model.dao.impl;

import bancoDados.bancoDados;
import model.dao.FuncionarioDao;
import model.entities.funcionario;
import model.entities.produto;

import java.sql.*;

public class funcionarioDAO implements FuncionarioDao {

    private Connection conn;

    public funcionarioDAO(Connection conn) {
        this.conn = conn;
    }

    public void cadastrarFuncionario(funcionario funcionario) {

        PreparedStatement st = null;

        try {
            st = conn.prepareStatement("insert into" +
                            " funcionario(cpf,nome,cargo,email,telefone) values(?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            st.setString(1, String.valueOf(funcionario.getCpf()));
            st.setString(2, funcionario.getNome());
            st.setString(3, funcionario.getCargo());
            st.setString(4, funcionario.getEmail());
            st.setString(5, funcionario.getTelefone());

            st.execute();
            st.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void atualizarFuncionario(String cpf, funcionario f) {
        PreparedStatement st = null;

        try {
            st = conn.prepareStatement("UPDATE funcionario SET nome = ?, cargo = ?, email = ?, telefone = ? WHERE cpf = ?",
                    Statement.RETURN_GENERATED_KEYS);

            st.setString(1, f.getNome());
            st.setString(2, f.getCargo());
            st.setString(3, f.getEmail());
            st.setString(4, f.getTelefone());
            st.setString(5, cpf);

            st.execute();
            st.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void removerFuncionario(String cpf) {
        PreparedStatement st = null;

        try {
            st = conn.prepareStatement("delete from funcionario where cpf=?");
            st.setString(1, cpf);
            st.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            bancoDados.closedStatement(st);
        }
    }

    @Override
    public funcionario procurarFuncionario(String cpf) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement("Select cpf,nome,cargo,email,telefone from funcionario where cpf=?");
            st.setString(1, cpf);
            rs = st.executeQuery();

            if (rs.next()) {
                funcionario f = new funcionario();
                f.setCpf(rs.getString("cpf"));
                f.setNome(rs.getString("nome"));
                f.setCargo(rs.getString("cargo"));
                f.setEmail(rs.getString("email"));
                f.setTelefone(rs.getString("telefone"));

                return f;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally{
            bancoDados.closeResultSet(rs);
            bancoDados.closedStatement(st);
        }
        return null;
    }
}