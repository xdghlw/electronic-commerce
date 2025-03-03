/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistência;

import Excecao.ColecaoException;
import Modelo.Sessao;
import Persistência.ColecaoDeSessao;
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
    public void inserir(Sessao sessao) throws ColecaoException {
            PreparedStatement ps = null;
        try {
            String sql = "INSERT INTO sessao(sessao_usuario_id) VALUES(?)";
            ps = this.conexao.prepareStatement(sql);
            ps.setInt(1, sessao.getSessao_usuario_id());
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
