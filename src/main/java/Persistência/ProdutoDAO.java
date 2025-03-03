/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistência;

import Excecao.ColecaoException;
import Modelo.Produto;
import Persistência.ColecaoDeProduto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


//CLASSE RESPONSÁVEL POR MANIPULAR O BANCO DE DADOS
/**
 *
 * @author Gustavo Loreto
 */
public class ProdutoDAO implements ColecaoDeProduto { // MANIPULADOR
    
    private Connection conexao;

    public ProdutoDAO(Connection conexao) {
        this.conexao = conexao;
    }

    @Override
    public List<Produto> porNome(String nome) throws ColecaoException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Produto> lp = null;
        
        try {
            lp = new ArrayList<Produto>();
            String sql = "SELECT produto_id, produto_nome FROM PRODUTO WHERE produto_nome LIKE ?";
            ps = this.conexao.prepareStatement(sql);
            ps.setString(1, "%"+nome+"%");
            
            rs = ps.executeQuery();
            while(rs.next()) {
                Produto p = new Produto();
                p.setProduto_id(rs.getInt("produto_id"));
                p.setProduto_nome(rs.getString("produto_nome"));
                p.setProduto_descricao(rs.getString("produto_descricao"));
                p.setProduto_preco(rs.getFloat("produto_preco"));
                p.setProduto_estoque(rs.getInt("produto_estoque"));
                lp.add(p);
            }
        } catch (SQLException e) {
            throw new ColecaoException("Erro ao selecionar o produto pelo nome!", e);
        } finally {
            try {
                ps.close();
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                throw new ColecaoException("Erro ao fechar o manipulador de banco de dados!", e);
            }
        }
        return lp;
    }

    @Override
    public List<Produto> todos() throws ColecaoException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Produto> lp = null;
        
        try {
            lp = new ArrayList<Produto>();
            String sql = "SELECT produto_id, produto_nome, produto_descricao, produto_preco, produto_estoque FROM produto;";
            //String sql = "SELECT * FROM produto";
            ps = this.conexao.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Produto p = new Produto();
                p.setProduto_id(rs.getInt("produto_id"));
                p.setProduto_nome(rs.getString("produto_nome"));
                p.setProduto_descricao(rs.getString("produto_descricao"));
                p.setProduto_preco(rs.getFloat("produto_preco"));
                p.setProduto_estoque(rs.getInt("produto_estoque"));
                lp.add(p);
            }
        } catch (SQLException e) {
            throw new ColecaoException("Não foi possível obter os produtos do banco de dados!", e);
        } finally {
            try {
                ps.close();
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                throw new ColecaoException("Não foi possível fechar o manipulador de banco de dados.", e);
            }
        }
        return lp;
    }

    @Override
    public Produto porId(int id) throws ColecaoException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Produto> lp = null;
        
        try {
            lp = new ArrayList<Produto>();
            String sql = "SELECT produto_id, produto_nome FROM PRODUTO WHERE produto_id LIKE ?";
            ps = this.conexao.prepareStatement(sql);
            ps.setInt(1, id);
            
            rs = ps.executeQuery();
            while(rs.next()) {
                Produto p = new Produto();
                p.setProduto_id(rs.getInt("produto_id"));
                p.setProduto_nome(rs.getString("produto_nome"));
                p.setProduto_descricao(rs.getString("produto_descricao"));
                p.setProduto_preco(rs.getFloat("produto_preco"));
                p.setProduto_estoque(rs.getInt("produto_estoque"));

                lp.add(p);
            }
        } catch (SQLException e) {
            throw new ColecaoException("Erro ao obter pelo nome!", e);
        } finally {
            try {
                ps.close();
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                throw new ColecaoException("Erro ao fechar o manipulador de banco de dados!", e);
            }
        }
        return lp.get(0);
    }
    
    @Override
    public void inserir(Produto produto) throws ColecaoException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            String sql = "INSERT INTO produto(produto_nome, produto_descricao, produto_preco, produto_estoque) VALUES (?, ?, ?, ?) ON CONFLICT (produto_nome) DO UPDATE SET produto_estoque = produto.produto_estoque + ?";
            //String sql = "INSERT INTO PRODUTO(produto_nome, produto_descricao, produto_preco, produto_estoque) VALUES (?, ?, ?, ?)";
            ps = this.conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, produto.getProduto_nome());
            ps.setString(2, produto.getProduto_descricao());
            ps.setFloat(3, produto.getProduto_preco());
            ps.setInt(4, produto.getProduto_estoque());
            ps.setInt(5, produto.getProduto_estoque());
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
    public void alterar(Produto produto) throws ColecaoException {
        PreparedStatement ps = null;
        try {
            String sql = "UPDATE PRODUTO SET produto_nome=? WHERE produto_nome=?";
            ps = this.conexao.prepareStatement(sql);
            ps.setString(1, produto.getProduto_nome());
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
    public void remover(int id) throws ColecaoException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void alterarNome(int nome, Produto produto) throws ColecaoException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void alterarPreco(int nome, Produto produto) throws ColecaoException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void alterarDescricao(int nome, Produto produto) throws ColecaoException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
