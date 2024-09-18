package model.entities;

import javafx.beans.property.BooleanProperty;

import java.util.List;
import java.util.Objects;

public class carrinho {

    private int id_produto;
    private String produtoNome;
    private float preco;
    private int qtd;


    public float getTotal() {
        return preco * qtd;
    }

    public int getId_produto() {
        return id_produto;
    }

    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }

    public String getProdutoNome() {
        return produtoNome;
    }

    public void setProdutoNome(String produtoNome) {
        this.produtoNome = produtoNome;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        carrinho carrinho = (carrinho) o;
        return id_produto == carrinho.id_produto && Float.compare(preco, carrinho.preco) == 0 && qtd == carrinho.qtd && Objects.equals(produtoNome, carrinho.produtoNome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_produto, produtoNome, preco, qtd);
    }
}
