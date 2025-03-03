/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistência;

import Excecao.ColecaoException;
import Modelo.Produto;
import Modelo.Usuario;
import Persistência.ColecaoDeCarrinho;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author guhwl
 */
public class CarrinhoDAO implements ColecaoDeCarrinho {
    private Connection conexao;
    
    public CarrinhoDAO(Connection conexao) {
        this.conexao = conexao;
    }
    
    @Override
    public List todos() throws ColecaoException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Object porId(int id) throws ColecaoException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void alterar(int id, Produto produto) throws ColecaoException {
        PreparedStatement ps = null;
        try {
            String sql = "UPDATE PRODUTO SET produto_nome=? WHERE produto_nome=?";
            ps = this.conexao.prepareStatement(sql);
            ps.setString(1, produto.getProduto_nome());
            ps.setInt(2, id);
            ps.execute();
        } catch(SQLException e) {
                throw new ColecaoException("Não foi possível alterar o produto no banco de dados.", e);
        } finally {
            try {
                ps.close();
            } catch (SQLException e) {
                throw new ColecaoException("Não foi possível fechar o manipulador do banco de dados.", e);
            }
        }
    }

    @Override
    public void alterar(Object objeto) throws ColecaoException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void remover(int id) throws ColecaoException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void inserir(Object objeto) throws ColecaoException {
                PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            String sql = "INSERT INTO carrinho(carrinho_usuario_id) SELECT sessao_usuario_id FROM sessao ORDER BY sessao_usuario_id DESC LIMIT 1 ON CONFLICT(carrinho_usuario_id) DO NOTHING";
            ps = this.conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.execute();
            rs = ps.getGeneratedKeys();
        } catch (SQLException e) {
            try {
                throw new ColecaoException("Erro ao inserir a pessoa no banco de dados.", e);
            } catch (ColecaoException ex) {
                Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
              try {
                ps.close();
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                throw new ColecaoException("Erro ao fechar o manipulador de banco de dados.", e);
            }
        }
    }
}
