package controllers;

import dao.HuespedDAO;
import factory.ConnectionFactory;
import java.sql.Connection;
import java.util.List;
import models.Huesped;

/**
 *
 * @author Carlos Alberto Bravo Ismiño
 */
public class HuespedController {
    
    private HuespedDAO huespedDAO;
    
    public HuespedController() {
        // Inicializar el controlador
        Connection connection = new ConnectionFactory().recuperarConexion(); // Obtener la conexión a la base de datos
        huespedDAO = new HuespedDAO(connection);
    }
    
    public int agregarHuesped(Huesped huesped){
        return huespedDAO.agregarHuesped(huesped);
    }
    // Método para obtener una  huesped por su ID
    public Huesped obtenerHuespedPorID(int id) {
        return huespedDAO.obtenerHuespedPorID(id);
    }

    // Método para actualizar una huesped
    public int actualizarHuesped(Huesped huesped) {
        try{
            huespedDAO.actualizarHuesped(huesped);
            return 1;
        }catch(Exception e){
            return 0;
        }
        
    }
    public void eliminarHuesped(int id) {
        System.out.println("En contorlador para eleminar huesped "+id);
        huespedDAO.eliminarHuesped(id);
    }
    
    public List<Huesped> obtenerTodosLosHuespedes(String consulta) {
        System.out.println("1");
        return huespedDAO.ObtenerTodosLosHuespedes(consulta);
    }
    
    public Huesped obtenerHuespedPorIDReserva(int id) {
        return huespedDAO.obtenerHuespedPorIDReserva(id);
    }
}
