package controllers;

import dao.ReservaDAO;
import factory.ConnectionFactory;
import java.sql.Connection;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import javax.swing.JDialog;
import models.Reserva;
import views.Exito;
import static views.ReservasView.txtFechaEntrada;
import static views.ReservasView.txtFechaSalida;

/**
 *
 * @author Carlos Alberto Bravo Ismiño
 */
public class ReservaController {
    
    private ReservaDAO reservaDAO;

    public ReservaController() {
        // Inicializar el controlador
        Connection connection = new ConnectionFactory().recuperarConexion(); // Obtener la conexión a la base de datos
        reservaDAO = new ReservaDAO(connection);
    }
    
    
    // Método para crear una nueva reserva
    public int crearReserva(Reserva reserva) {
        int resultado = reservaDAO.crearReserva(reserva);
        if(resultado >  0 ){
            System.out.println("Registro los datos en el sistema");
        }else{
            System.out.println("Error al registrar Reserva");
        }
        return resultado;
    }

    // Método para obtener una reserva por su ID
    public Reserva obtenerReservaPorID(int id) {
        return reservaDAO.obtenerReservaPorID(id);
    }

    // Método para actualizar una reserva
    public void actualizarReserva(Reserva reserva) {
        reservaDAO.actualizarReserva(reserva);
    }

    // Método para eliminar una reserva por su ID
    public void eliminarReserva(int id) {
        reservaDAO.eliminarReserva(id);
    }

    // Método para obtener todas las reservas
    public List<Reserva> obtenerTodasLasReservas(String consulta) {
        return reservaDAO.obtenerTodasLasReservas(consulta);
    }
    
    public double calcularDiferencia(Date txtFechaEntrada, Date txtFechaSalida ) {
        Date date1 = txtFechaEntrada;
        Date date2 = txtFechaSalida;

        if (date1 != null && date2 != null) {
            LocalDate localDate1 = date1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate localDate2 = date2.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

            long diffDays = ChronoUnit.DAYS.between(localDate1, localDate2);

            // Haz lo que necesites con la diferencia en días
            System.out.println("Diferencia en días: " + diffDays);
            return (int) diffDays * 250;
        }else{
            System.out.println("Los date estan nulos");
            System.out.println("Date 1 "+date1);
            System.out.println("Date 2 "+date2);
            return 0;
        }
    }
    //Tranformador de Date a LocalDate
    private LocalDate fromDateToLocalDate(Date date) {
        return date.toInstant()
          .atZone(ZoneId.systemDefault())
          .toLocalDate();
    }
}
