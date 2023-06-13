package models;

import java.util.Date;

/**
 *
 * @author Carlos Alberto Bravo Ismiño
 */
public class Reserva {
    
    private int id;
    private Date FechaEntrada;
    private Date FechaSalida;
    private double Valor;
    private String formaPago;

    public Reserva() {
    }
    
    
    
    public Reserva(Date FechaEntrada, Date FechaSalida, double Valor, String formaPago) {
        this.FechaEntrada = FechaEntrada;
        this.FechaSalida = FechaSalida;
        this.Valor = Valor;
        this.formaPago = formaPago;
    }

    

    public Reserva(int id, Date FechaEntrada, Date FechaSalida, double Valor, String formaPago) {
        this.id = id;
        this.FechaEntrada = FechaEntrada;
        this.FechaSalida = FechaSalida;
        this.Valor = Valor;
        this.formaPago = formaPago;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFechaEntrada() {
        return FechaEntrada;
    }

    public void setFechaEntrada(Date FechaEntrada) {
        this.FechaEntrada = FechaEntrada;
    }

    public Date getFechaSalida() {
        return FechaSalida;
    }

    public void setFechaSalida(Date FechaSalida) {
        this.FechaSalida = FechaSalida;
    }

    public double getValor() {
        return Valor;
    }

    public void setValor(double Valor) {
        this.Valor = Valor;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }
}
