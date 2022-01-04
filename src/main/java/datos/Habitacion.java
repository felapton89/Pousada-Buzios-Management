package datos;

/**
 *
 * @author pablo
 */

public class Habitacion {
    
    private int idHabitacion;
    private String numero;
    private String caracteristica;
    private double precioDiario;
    private String estado;
    private String tipoHabitacion;

    public Habitacion() {
    }

    public Habitacion(int idHabitacion, String numero, String caracteristica, double precioDiario, String estado, String tipoHabitacion) {
        this.idHabitacion = idHabitacion;
        this.numero = numero;
        this.caracteristica = caracteristica;
        this.precioDiario = precioDiario;
        this.estado = estado;
        this.tipoHabitacion = tipoHabitacion;
    }

    public int getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(int idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCaracteristica() {
        return caracteristica;
    }

    public void setCaracteristica(String caracteristica) {
        this.caracteristica = caracteristica;
    }

    public double getPrecioDiario() {
        return precioDiario;
    }

    public void setPrecioDiario(double precioDiario) {
        this.precioDiario = precioDiario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(String tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }
    
    
}
