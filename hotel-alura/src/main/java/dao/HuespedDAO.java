package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import models.Huesped;

/**
 *
 * @author Carlos Alberto Bravo Ismiño
 */
public class HuespedDAO {
    private Connection connection;

    public HuespedDAO(Connection connection) {
        this.connection = connection;
    }
    
    public int agregarHuesped(Huesped huesped) {
        String query = "INSERT INTO huespedes (Id, Nombres, Apellidos, FechaNacimiento, Nacionalidad, Telefono, idReserva) VALUES (?, ?, ?, ?, ?, ?, ?)";
        int id = 0;
        try {
            PreparedStatement statement = connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, huesped.getId());
            statement.setString(2, huesped.getNombres());
            statement.setString(3, huesped.getApellidos());
            statement.setDate(4, new Date(huesped.getFechaNacimiento().getTime()));
            statement.setString(5, huesped.getNacionalidad());
            statement.setString(6, huesped.getTelefono());
            statement.setInt(7, huesped.getIdReserva());

            statement.execute();
                
            final ResultSet resultSet = statement.getGeneratedKeys();
                
            try(resultSet){
                while(resultSet.next()){
                    id = resultSet.getInt(1);
                    huesped.setId(id);
                    System.out.println("La persona con fue creado con el id: "+ id);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }
    
    public Huesped obtenerHuespedPorID(int id) {
        Huesped huesped = null;
        try{
            String sql = "SELECT * FROM Huespedes WHERE Id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            // Ejecutar la consulta
            ResultSet resultSet = statement.executeQuery();

            // Verificar si se encontró una reserva y crear el objeto Reserva correspondiente
            if (resultSet.next()) {
                huesped = new Huesped(
                        resultSet.getInt("Id"),
                        resultSet.getString("Nombres"), 
                        resultSet.getString("Apellidos"), 
                        resultSet.getDate("FechaNacimiento"),
                        resultSet.getString("Nacionalidad"),
                        resultSet.getString("Telefono"),
                        resultSet.getInt("idReserva")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return huesped;
    }
    
    public void actualizarHuesped(Huesped huesped){
        try {
            // Preparar la sentencia SQL para actualizar una reserva
            String sql = "UPDATE Huespedes SET Nombres = ?, Apellidos = ?, FechaNacimiento = ?, Nacionalidad = ?, Telefono = ?, idReserva = ? WHERE Id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, huesped.getNombres());
            statement.setString(2, huesped.getApellidos());
            statement.setDate(3, new Date(huesped.getFechaNacimiento().getTime()));
            statement.setString(4, huesped.getNacionalidad());
            statement.setString(5, huesped.getTelefono());
            statement.setInt(6, huesped.getIdReserva());
            statement.setInt(7, huesped.getId());

            // Ejecutar la sentencia
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void eliminarHuesped(int id) {
         System.out.println("En dao Eleminacion de Huesped "+id);
         try {
            // Preparar la sentencia SQL para eliminar una reserva por su ID
            String sql = "DELETE FROM huespedes WHERE Id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            JOptionPane.showMessageDialog(null, "eleminado correctamente");
            // Ejecutar la sentencia
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            
            JOptionPane.showMessageDialog(null, "Error al Eleminar");
        }
     }
    
    public List<Huesped> ObtenerTodosLosHuespedes(String consulta) {
        System.out.println("Pendejo");
        List<Huesped> huespeds = new ArrayList<>();
        try {
            // Preparar la sentencia SQL para obtener una reserva por su ID
            String sql = "SELECT * FROM huespedes WHERE idReserva LIKE ? OR Apellidos = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "%"+consulta+"%");
            statement.setString(2, "%"+consulta+"%");
            
            
            // Ejecutar la consulta
            ResultSet resultSet = statement.executeQuery();
            
            // Verificar si se encontró una reserva y crear el objeto Reserva correspondiente
            while (resultSet.next()) {
                System.out.println("Entro");
                Huesped huesped = new Huesped(
                        resultSet.getInt("Id"),
                        resultSet.getString("Nombres"), 
                        resultSet.getString("Apellidos"), 
                        resultSet.getDate("FechaNacimiento"),
                        resultSet.getString("Nacionalidad"),
                        resultSet.getString("Telefono"),
                        resultSet.getInt("idReserva")
                );
                
                huespeds.add(huesped);
            }
        } catch (SQLException e) {
            System.out.println("Errrorrrrrrrrrrrrrrrrrrrrrrrrr");
            e.printStackTrace();
        }
        return huespeds;
    }
    
    public Huesped obtenerHuespedPorIDReserva(int id) {
        Huesped huesped = null;
        try{
            String sql = "SELECT * FROM Huespedes WHERE idReserva = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            // Ejecutar la consulta
            ResultSet resultSet = statement.executeQuery();

            // Verificar si se encontró una reserva y crear el objeto Reserva correspondiente
            if (resultSet.next()) {
                huesped = new Huesped(
                        resultSet.getInt("Id"),
                        resultSet.getString("Nombres"), 
                        resultSet.getString("Apellidos"), 
                        resultSet.getDate("FechaNacimiento"),
                        resultSet.getString("Nacionalidad"),
                        resultSet.getString("Telefono"),
                        resultSet.getInt("idReserva")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return huesped;
    }
}
