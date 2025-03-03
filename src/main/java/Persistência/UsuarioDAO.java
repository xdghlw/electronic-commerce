/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistência;

import Excecao.ColecaoException;
import Modelo.Usuario;
import Persistência.ColecaoDeUsuario;
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
public class UsuarioDAO implements ColecaoDeUsuario { // MANIPULADOR
    
    private Connection conexao;

    public UsuarioDAO(Connection conexao) {
        this.conexao = conexao;
    }
    
    @Override
    public void inserir(Usuario usuario) throws ColecaoException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            String sql = "INSERT INTO usuario(usuario_nome, usuario_sobrenome, usuario_email, usuario_senha) VALUES(?,?,?,?)";
            ps = this.conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, usuario.getUsuario_nome());
            ps.setString(2, usuario.getUsuario_sobrenome());
            ps.setString(3, usuario.getUsuario_email());
            ps.setString(4, usuario.getUsuario_senha());
            ps.execute();
            rs = ps.getGeneratedKeys();
        } catch (SQLException e) {
            throw new ColecaoException("O manipulador não pode realizar a operação de inserção no banco de dados.", e);
            }
         finally {
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
    public void alterar(Usuario usuario) throws ColecaoException {
        PreparedStatement ps = null;
        try {
            String sql = "UPDATE PRODUTO SET produto_nome=? WHERE produto_id=?";
            ps = this.conexao.prepareStatement(sql);
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
    public List<Usuario> todos() throws ColecaoException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Usuario porId(int id) throws ColecaoException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
        
    @Override
    public int verificarUsuario(String email, String senha) throws ColecaoException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Usuario> lp = null;
        try {
            String sql = "SELECT usuario_administrador FROM usuario WHERE usuario_email LIKE ? and usuario_senha LIKE ?";
            ps = this.conexao.prepareStatement(sql);
            ps.setString(1, "%"+email+"%");
            ps.setString(2, "%"+senha+"%");
            rs = ps.executeQuery();
            if(rs.next()){
                if(rs.getBoolean("usuario_administrador") == true){
                    return 1;
                } else {
                    return 2;
                }
            } 
        } catch (SQLException e) {
            throw new ColecaoException("Erro ao verificar usuário no banco de dados.", e);
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
        return 3;
    }

/*    @Override
    public List<Usuario> todos() throws ColecaoException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Usuario> lp = null;
        
        try {
            lp = new ArrayList<Usuario>();
            String sql = "SELECT produto_id, produto_nome, produto_preco, produto_estoque, produto_unidade_medida FROM PRODUTO;";
            ps = this.conexao.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Usuario p = new Usuario(rs.getString("usuario_nome"), rs.getString("usuario_sobrenome"), rs.getString("usuario_email"), rs.getString("usuario_nascimento"), rs.getBoolean("usuario_administrador"));
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
    }*/

  /*@Override
    public Usuario porId(int id) throws ColecaoException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Usuario> lp = null;
        
        try {
            lp = new ArrayList<Usuario>();
            String sql = "SELECT produto_id, produto_nome FROM PRODUTO WHERE produto_id LIKE ?";
            ps = this.conexao.prepareStatement(sql);
            ps.setInt(1, id);
            
            rs = ps.executeQuery();
            while(rs.next()) {
                Usuario p = new Usuario(rs.getString("usuario_nome"), rs.getString("usuario_sobrenome"), rs.getString("usuario_email"), rs.getString("usuario_nascimento"), rs.getBoolean("usuario_administrador"));
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
    }*/
    
        /*@Override
        public void remover(String[] id) throws ColecaoException {
        PreparedStatement ps = null;
        try {
           String sql = "DELETE FROM PRODUTO WHERE produto_id=?";
           ps = this.conexao.prepareStatement(sql);
           for (String e : id) {
                ps.setInt(1, Integer.parseInt(e));
                ps.execute();
           }
        } catch (SQLException e) {
            throw new ColecaoException("Erro ao remover o produto do banco de dados!" + e);
        } finally {
            try {
                ps.close();
            } catch (SQLException e) {
                throw new ColecaoException("Erro ao fechar o manipulador de banco de dados!", e);
            }
        }
    }*/

    @Override
    public List<Usuario> porNome(String nome) throws ColecaoException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Usuario porEmail(String email) throws ColecaoException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Usuario> lp = null;
        
        try {
            lp = new ArrayList<Usuario>();
            String sql = "SELECT usuario_id, usuario_nome, usuario_sobrenome, usuario_email, usuario_nascimento FROM usuario WHERE usuario_email=?";
            ps = this.conexao.prepareStatement(sql);
            ps.setString(1, email);
            
            rs = ps.executeQuery();
            while(rs.next()) {
                //Usuario p = new Usuario(rs.getString("usuario_nome"), rs.getString("usuario_sobrenome"), rs.getString("usuario_email"), rs.getString("usuario_nascimento"), rs.getBoolean("usuario_administrador"));
                Usuario u = new Usuario();
                u.setUsuario_id(rs.getInt("usuario_id"));
                u.setUsuario_nome(rs.getString("usuario_nome"));
                u.setUsuario_sobrenome(rs.getString("usuario_sobrenome"));
                u.setUsuario_email(rs.getString("usuario_email"));
                //u.setUsuario_nascimento("usuario_nascimento");
                lp.add(u);
            }
        } catch (SQLException e) {
            throw new ColecaoException("Não foi possível obter registro no banco de dados a partir do email.", e);
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
}