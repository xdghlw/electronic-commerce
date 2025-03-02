/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexao;

import Excecao.ConexaoException;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Gustavo Loreto
 */
public class ConnectionFactory {
    
    public static Connection getConexao() throws ConexaoException {
    
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String usuario = "postgres";
        String senha = "postgres";
        Connection connection = null;
        try{
    
            connection = DriverManager.getConnection(url, usuario, senha);
            //System.out.println("Conexao Realizada com Sucesso!");
        } catch (Exception e) {
            System.out.println("ERRO!");
            e.printStackTrace();
        }
        return connection;
    }
}
