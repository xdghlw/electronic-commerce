/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Excecao;

/**
 *
 * @author Gustavo Loreto
 */
public class ConexaoException extends Exception {
    
    public ConexaoException (String message) {
        super(message);
    }
    
    public ConexaoException (Throwable cause) {
        super(cause);
    }
    
    public ConexaoException (String message, Throwable cause) {
        super(message, cause);
    }
}
