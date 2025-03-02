/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Persistência;

import Excecao.ColecaoException;
import Excecao.ConexaoException;
import java.util.List;


/**
 *
 * @author Gustavo Loreto
 * @param <T>
 */
public interface Colecao<T> {
    public List<T> todos() throws ColecaoException;
    public T porId(int id) throws ColecaoException;
    public void inserir(T objeto) throws ColecaoException;
    public void alterar(T objeto) throws ColecaoException;
    public void remover(int id) throws ColecaoException;
}
