package model.entities;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.Property;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.ByteArrayInputStream;
import java.util.Objects;

public class produto {


    private int id_produto;
    private String nome;
    private BooleanProperty selected ;
    private float preco;
    private int qtd_estoque;

    private byte[] foto;

    public int getId_produto() {
        return id_produto;
    }

    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public int getQtd_estoque() {
        return qtd_estoque;
    }

    public void setQtd_estoque(int qtd_estoque) {
        this.qtd_estoque = qtd_estoque;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        produto produto = (produto) o;
        return id_produto == produto.id_produto && Float.compare(preco, produto.preco) == 0 && Objects.equals(nome, produto.nome) && Objects.equals(qtd_estoque, produto.qtd_estoque);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_produto, nome, preco, qtd_estoque);
    }

    @Override
    public String toString() {
        return "produto{" +
                "id_produto=" + id_produto +
                ", nome='" + nome + '\'' +
                ", preco=" + preco +
                ", qtd_estoque='" + qtd_estoque + '\'' +
                '}';
    }
    public boolean isSelected(){
        return selected.get();
    }

    public void setSelected(boolean selected){
        this.selected.set(selected);
    }

    public Property<Boolean> selectedProperty() {
    return selected;
    }

    public ImageView getImagemView() {
        ByteArrayInputStream bis = new ByteArrayInputStream(foto);
        Image img = new Image(bis);
        ImageView imageView = new ImageView(img);
        imageView.setFitHeight(50);  // Ajusta o tamanho da imagem
        imageView.setFitWidth(50);
        return imageView;
    }
}
