/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Gustavo Loreto
 */
public class Venda {
    
    private int venda_id;
    private int venda_usuario_id;
    private int venda_carrinho_id;
    private String venda_data;

    public Venda() {
    }

    public int getVenda_id() {
        return venda_id;
    }

    public void setVenda_id(int venda_id) {
        this.venda_id = venda_id;
    }

    public int getVenda_usuario_id() {
        return venda_usuario_id;
    }

    public void setVenda_usuario_id(int venda_usuario_id) {
        this.venda_usuario_id = venda_usuario_id;
    }

    public int getVenda_carrinho_id() {
        return venda_carrinho_id;
    }

    public void setVenda_carrinho_id(int venda_carrinho_id) {
        this.venda_carrinho_id = venda_carrinho_id;
    }

    public String getVenda_data() {
        return venda_data;
    }

    public void setVenda_data(String venda_data) {
        this.venda_data = venda_data;
    }
}