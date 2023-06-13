
package dao;

import java.util.List;

/**
 *
 * @author Carlos Alberto Bravo Ismiño
 * @param <T>
 */
public interface CRUD<T>{
    //Crear
    void guardar(T t);
    //Leer
    List<T> listar();
    //Modificar
    int modificar(T t);
    //Eleminar
    int eleminar(T t);
}
