package model.dao.impl;

import bancoDados.bancoDados;


public class DAOfactory {
    public static clienteDAO createClienteDao(){
        return new clienteDAO(bancoDados.getConnection());
    }

    public static produtoDAO createProdutoDao(){return new produtoDAO(bancoDados.getConnection());}

    public static funcionarioDAO createFuncionarioDao(){return new funcionarioDAO(bancoDados.getConnection());}

    public static pedidoDaoJDBC createPedidoDaoJDBC(){return new pedidoDaoJDBC(bancoDados.getConnection());}
}
