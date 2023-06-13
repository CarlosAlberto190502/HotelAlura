package dao;

import java.util.ArrayList;
import java.util.List;
import models.Usuario;

/**
 *
 * @author Carlos Alberto Bravo Ismiño
 */
public class UsuarioDAO {
    private List<Usuario> userList;

    public UsuarioDAO() {
            userList = new ArrayList<>();

            // Agregar usuarios predefinidos
            userList.add(new Usuario("admin", "12345"));
            userList.add(new Usuario("user1", "123"));
            userList.add(new Usuario("user2", "234"));
            userList.add(new Usuario("user3", "345"));
    }

    public boolean authenticateUser(String username, String password) {
        // Verificar las credenciales ingresadas
        for (Usuario user : userList) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

}
