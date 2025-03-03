/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistência;

import Excecao.ColecaoException;
import Modelo.Produto;
import Modelo.ProdutoCarrinho;
import Persistência.ColecaoDeProdutoCarrinho;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author guhwl
 */
public class ProdutoCarrinhoDAO implements ColecaoDeProdutoCarrinho {
    
    private Connection conexao;

    public ProdutoCarrinhoDAO(Connection conexao) {
        this.conexao = conexao;
    }
    
    @Override
    public List<ProdutoCarrinho> todos() throws ColecaoException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ProdutoCarrinho porId(int id) throws ColecaoException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void inserir(ProdutoCarrinho produto) throws ColecaoException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "INSERT INTO produto_carrinho(carrinho_id, produto_id) SELECT carrinho_id, ? FROM carrinho WHERE carrinho_usuario_id=(SELECT sessao_usuario_id FROM sessao ORDER BY sessao_usuario_id DESC LIMIT 1)";
            ps = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, produto.getProduto_id());
            ps.execute();
            rs = ps.getGeneratedKeys();
//            if (rs.next()) {
//                produto.setId(rs.getInt(1));
//            }
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

    @Override
    public void alterar(ProdutoCarrinho objeto) throws ColecaoException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void remover(int id) throws ColecaoException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
