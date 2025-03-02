/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Persistência;

import Excecao.ColecaoException;
import java.util.List;
import Modelo.Usuario;

/**
 *
 * @author Gustavo Loreto
 */
public interface ColecaoDeUsuario extends Colecao<Usuario> {
    public List<Usuario> porNome(String nome) throws ColecaoException;
    public int verificarUsuario(String email, String senha) throws ColecaoException;
}
