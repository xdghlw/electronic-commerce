/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author guhwl
 */
public class Usuario {
    private int usuario_id;
    private String usuario_nome;
    private String usuario_sobrenome;
    private String usuario_email;
    private String usuario_senha;
    private String usuario_nascimento;
    private boolean usuario_administrador;

    public Usuario() {
    }
    
    public int getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }

    public String getUsuario_nome() {
        return usuario_nome;
    }

    public void setUsuario_nome(String usuario_nome) {
        this.usuario_nome = usuario_nome;
    }

    public String getUsuario_sobrenome() {
        return usuario_sobrenome;
    }

    public void setUsuario_sobrenome(String usuario_sobrenome) {
        this.usuario_sobrenome = usuario_sobrenome;
    }

    public String getUsuario_email() {
        return usuario_email;
    }

    public void setUsuario_email(String usuario_email) {
        this.usuario_email = usuario_email;
    }

    public String getUsuario_senha() {
        return usuario_senha;
    }

    public void setUsuario_senha(String usuario_senha) {
        this.usuario_senha = usuario_senha;
    }

    public String getUsuario_nascimento() {
        return usuario_nascimento;
    }

    public void setUsuario_nascimento(String usuario_nascimento) {
        this.usuario_nascimento = usuario_nascimento;
    }

    public boolean isUsuario_administrador() {
        return usuario_administrador;
    }

    public void setUsuario_administrador(boolean usuario_administrador) {
        this.usuario_administrador = usuario_administrador;
    }
}
