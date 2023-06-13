package dao;

/**
 *
 * @author Carlos Alberto Bravo Ismiño
 */
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import models.Reserva;

public class ReservaDAO {
    
    private Connection connection;

    // Constructor que establece la conexión con la base de datos
    public ReservaDAO(Connection connection) {
        this.connection = connection;
    }

    // Método para crear una nueva reserva
    public int crearReserva(Reserva reserva) {
        int id = 0;
        try {
            // Preparar la sentencia SQL para insertar una nueva reserva
            String sql = "INSERT INTO Reservas (Id, FechaEntrada, FechaSalida, Valor, FormaPago) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, reserva.getId());
            statement.setDate(2, new Date( reserva.getFechaEntrada().getTime()));
            statement.setDate(3, new Date( reserva.getFechaSalida().getTime()));
            statement.setDouble(4, reserva.getValor());
            statement.setString(5, reserva.getFormaPago());

            // Ejecutar la sentencia
            statement.execute();
                
            final ResultSet resultSet = statement.getGeneratedKeys();
                
            try(resultSet){
                while(resultSet.next()){
                    id = resultSet.getInt(1);
                    reserva.setId(id);
                    System.out.println("La persona con fue creado con el id: "+ id);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
        return id;
    }

    // Método para obtener una reserva por su ID
    public Reserva obtenerReservaPorID(int id) {
        Reserva reserva = null;
        try {
            // Preparar la sentencia SQL para obtener una reserva por su ID
            String sql = "SELECT * FROM Reservas WHERE Id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            // Ejecutar la consulta
            ResultSet resultSet = statement.executeQuery();

            // Verificar si se encontró una reserva y crear el objeto Reserva correspondiente
            if (resultSet.next()) {
                reserva = new Reserva();
                reserva.setId(resultSet.getInt("Id"));
                reserva.setFechaEntrada(resultSet.getDate("FechaEntrada"));
                reserva.setFechaSalida(resultSet.getDate("FechaSalida"));
                reserva.setValor(resultSet.getDouble("Valor"));
                reserva.setFormaPago(resultSet.getString("FormaPago"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return reserva;
    }

    // Método para actualizar una reserva
    public void actualizarReserva(Reserva reserva) {
        try {
            // Preparar la sentencia SQL para actualizar una reserva
            String sql = "UPDATE Reservas SET FechaEntrada = ?, FechaSalida = ?, Valor = ?, FormaPago = ? WHERE Id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setDate(1, new Date(reserva.getFechaEntrada().getTime()));
            statement.setDate(2, new Date(reserva.getFechaSalida().getTime()));
            statement.setDouble(3, reserva.getValor());
            statement.setString(4, reserva.getFormaPago());
            statement.setInt(5, reserva.getId());

            // Ejecutar la sentencia
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para eliminar una reserva por su ID
    public void eliminarReserva(int id) {
        try {
            // Preparar la sentencia SQL para eliminar una reserva por su ID
            String sql = "DELETE FROM Reservas WHERE Id = ?";
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

    // ...

    public List<Reserva> obtenerTodasLasReservas(String consulta) {
        List<Reserva> reservas = new ArrayList<>();
        try {
            // Preparar la sentencia SQL para obtener una reserva por su ID
            String sql = "SELECT * FROM Reservas WHERE Id LIKE ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "%"+consulta+"%");
            // Ejecutar la consulta
            
            ResultSet resultSet = statement.executeQuery();

            // Verificar si se encontró una reserva y crear el objeto Reserva correspondiente
            while (resultSet.next()) {
                Reserva reserva = new Reserva();
                reserva.setId(resultSet.getInt("Id"));
                reserva.setFechaEntrada(resultSet.getDate("FechaEntrada"));
                reserva.setFechaSalida(resultSet.getDate("FechaSalida"));
                reserva.setValor(resultSet.getDouble("Valor"));
                reserva.setFormaPago(resultSet.getString("FormaPago"));
                
                reservas.add(reserva);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reservas;
    }
}

