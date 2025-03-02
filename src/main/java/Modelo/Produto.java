/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Gustavo Loreto
 */
public class Produto {
    private int produto_id;
    private String produto_nome;
    private String produto_descricao;
    private float produto_preco;
    private int produto_estoque;

    public Produto() {
    }

    public int getProduto_id() {
        return produto_id;
    }

    public void setProduto_id(int produto_id) {
        this.produto_id = produto_id;
    }

    public String getProduto_nome() {
        return produto_nome;
    }

    public void setProduto_nome(String produto_nome) {
        this.produto_nome = produto_nome;
    }

    public String getProduto_descricao() {
        return produto_descricao;
    }

    public void setProduto_descricao(String produto_descricao) {
        this.produto_descricao = produto_descricao;
    }

    public float getProduto_preco() {
        return produto_preco;
    }

    public void setProduto_preco(float produto_preco) {
        this.produto_preco = produto_preco;
    }

    public int getProduto_estoque() {
        return produto_estoque;
    }

    public void setProduto_estoque(int produto_estoque) {
        this.produto_estoque = produto_estoque;
    }
}