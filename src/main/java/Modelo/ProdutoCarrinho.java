/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author guhwl
 */
public class ProdutoCarrinho {
    
    private int produto_carrinho_id;
    private int produto_id;
    private int carrinho_id;

    public ProdutoCarrinho() {
    }

    public int getProduto_carrinho_id() {
        return produto_carrinho_id;
    }

    public void setProduto_carrinho_id(int produto_carrinho_id) {
        this.produto_carrinho_id = produto_carrinho_id;
    }

    public int getProduto_id() {
        return produto_id;
    }

    public void setProduto_id(int produto_id) {
        this.produto_id = produto_id;
    }

    public int getCarrinho_id() {
        return carrinho_id;
    }

    public void setCarrinho_id(int carrinho_id) {
        this.carrinho_id = carrinho_id;
    }
}
