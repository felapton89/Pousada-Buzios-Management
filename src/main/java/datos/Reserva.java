package datos;

import java.time.LocalDate;
import java.sql.Date;

/**
 *
 * @author pablo
 */
public class Reserva {
    
    private int idReserva;
    private int idCliente;
    private int idHabitacion;
    private String tipoReserva;
    private Date fechaReserva;
    private Date checkIn;
    private Date checkOut;
    private double costoAlojamiento;
    private String estado;

    public Reserva() {
    }

    public Reserva(int idReserva, int idCliente, int idHabitacion, String tipoReserva, Date fechaReserva, Date checkIn, Date checkOut, double costoAlojamiento, String estado) {
        this.idReserva = idReserva;
        this.idCliente = idCliente;
        this.idHabitacion = idHabitacion;
        this.tipoReserva = tipoReserva;
        this.fechaReserva = fechaReserva;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.costoAlojamiento = costoAlojamiento;
        this.estado = estado;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(int idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public String getTipoReserva() {
        return tipoReserva;
    }

    public void setTipoReserva(String tipoReserva) {
        this.tipoReserva = tipoReserva;
    }

    public Date getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(Date fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

    public double getCostoAlojamiento() {
        return costoAlojamiento;
    }

    public void setCostoAlojamiento(double costoAlojamiento) {
        this.costoAlojamiento = costoAlojamiento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}
