package models;

import java.util.Date;

/**
 *
 * @author Carlos Alberto Bravo Ismiños
 */
public class Huesped {
    
    int id;
    String Nombres;
    String Apellidos;
    Date FechaNacimiento;
    String Nacionalidad;
    String Telefono;
    int IdReserva;

    public Huesped(String Nombres, String Apellidos, Date FechaNacimiento, String Nacionalidad, String Telefono, int IdReserva) {
        this.Nombres = Nombres;
        this.Apellidos = Apellidos;
        this.FechaNacimiento = FechaNacimiento;
        this.Nacionalidad = Nacionalidad;
        this.Telefono = Telefono;
        this.IdReserva = IdReserva;
    }
    
    
    
    public Huesped(int id, String Nombres, String Apellidos, Date FechaNacimiento, String Nacionalidad, String Telefono, int IdReserva) {
        this.id = id;
        this.Nombres = Nombres;
        this.Apellidos = Apellidos;
        this.FechaNacimiento = FechaNacimiento;
        this.Nacionalidad = Nacionalidad;
        this.Telefono = Telefono;
        this.IdReserva = IdReserva;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public Date getFechaNacimiento() {
        return FechaNacimiento;
    }

    public void setFechaNacimiento(Date FechaNacimiento) {
        this.FechaNacimiento = FechaNacimiento;
    }

    public String getNacionalidad() {
        return Nacionalidad;
    }

    public void setNacionalidad(String Nacionalidad) {
        this.Nacionalidad = Nacionalidad;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public int getIdReserva() {
        return IdReserva;
    }

    public void setIdReserva(int IdReserva) {
        this.IdReserva = IdReserva;
    }

   
    
    
    
    
}
