/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Excecao;

/**
 *
 * @author Gustavo Loreto
 */
public class ColecaoException extends Exception {
    public ColecaoException (String message) {
        super(message);
    }
    
    public ColecaoException (Throwable cause) {
        super(cause);
    }
    
    public ColecaoException (String message, Throwable cause) {
        super(message, cause);
    }
}
