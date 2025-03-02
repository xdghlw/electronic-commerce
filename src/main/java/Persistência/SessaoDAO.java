/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistência;

import Excecao.ColecaoException;
import Modelo.Sessao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author guhwl
 */
public class SessaoDAO implements ColecaoDeSessao {
    public Connection conexao;

    public SessaoDAO(Connection con) {
        this.conexao = con;
    }
    
    @Override
    public List<Sessao> todos() throws ColecaoException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Sessao porId(int id) throws ColecaoException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void inserir(Sessao objeto) throws ColecaoException {
            PreparedStatement ps = null;
        try {
            String sql = "INSERT INTO sessao(sessao_usuario_id) SELECT usuario_id FROM usuario WHERE usuario_email=?;";
            ps = this.conexao.prepareStatement(sql);
    //        ps.setString(1, usuario.getUsuario_email());
            ps.execute();
        //    System.out.println("Sessão iniciada com usuário: " + usuario.getUsuario_email());
        } catch (SQLException e) {
            throw new ColecaoException("Erro ao iniciar sessão", e);
        } finally {
            try {
                ps.close();
            } catch (SQLException e) {
                throw new ColecaoException("Erro ao fechar o manipulador de banco de dados!", e);
            }
        }
    }

    @Override
    public void alterar(Sessao objeto) throws ColecaoException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void remover(int id) throws ColecaoException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
