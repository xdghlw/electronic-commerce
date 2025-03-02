/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author guhwl
 */
public class Carrinho {
    
    private int carrinho_id;
    private int carrinho_usuario_id;
    private int carrinho_produto_id;

    public Carrinho() {
    }

    public int getCarrinho_id() {
        return carrinho_id;
    }

    public void setCarrinho_id(int carrinho_id) {
        this.carrinho_id = carrinho_id;
    }

    public int getCarrinho_usuario_id() {
        return carrinho_usuario_id;
    }

    public void setCarrinho_usuario_id(int carrinho_usuario_id) {
        this.carrinho_usuario_id = carrinho_usuario_id;
    }

    public int getCarrinho_produto_id() {
        return carrinho_produto_id;
    }

    public void setCarrinho_produto_id(int carrinho_produto_id) {
        this.carrinho_produto_id = carrinho_produto_id;
    }
}
