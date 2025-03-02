/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author guhwl
 */
public class Sessao {
    private int sessao_id;
    private int sessao_usuario_id;
    private String sessao_inicio;
    private String sessao_fim;

    public Sessao() {
    }

    public int getSessao_id() {
        return sessao_id;
    }

    public void setSessao_id(int sessao_id) {
        this.sessao_id = sessao_id;
    }

    public int getSessao_usuario_id() {
        return sessao_usuario_id;
    }

    public void setSessao_usuario_id(int sessao_usuario_id) {
        this.sessao_usuario_id = sessao_usuario_id;
    }

    public String getSessao_inicio() {
        return sessao_inicio;
    }

    public void setSessao_inicio(String sessao_inicio) {
        this.sessao_inicio = sessao_inicio;
    }

    public String getSessao_fim() {
        return sessao_fim;
    }

    public void setSessao_fim(String sessao_fim) {
        this.sessao_fim = sessao_fim;
    }
}
