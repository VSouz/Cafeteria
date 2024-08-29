package model.dao.impl;

import bancoDados.bancoDados;
import model.entities.cliente;
import model.dao.ClienteDao;

import java.sql.*;

public class clienteDAO implements ClienteDao{

    private Connection conn;

    public clienteDAO(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void cadastrarCliente(cliente c) {
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
