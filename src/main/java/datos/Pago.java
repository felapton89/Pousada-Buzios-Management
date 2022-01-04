package datos;

import java.nio.ByteBuffer;
import java.sql.Date;
import java.util.UUID;

/**
 *
 * @author pablo
 */
public class Pago {

    private int idPago;
    private int idReserva;
    private String numComprobante;
    private double totalPago;
    private Date fechaEmision;
    private Date fechaPago;

    public Pago() {
    }

    public Pago(int idPago, int idReserva, String tipoComprobante, String numComprobante, double totalPago, Date fechaEmision, Date fechaPago) {
        this.idPago = idPago;
        this.idReserva = idReserva;
        this.numComprobante = numComprobante;
        this.totalPago = totalPago;
        this.fechaEmision = fechaEmision;
        this.fechaPago = fechaPago;
    }

    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public String getNumComprobante() {
        return numComprobante;
    }

    public void setNumComprobante(String numComprobante) {
        String unique = shortUUID();
        this.numComprobante = unique;
    }

    public double getTotalPago() {
        return totalPago;
    }

    public void setTotalPago(double totalPago) {
        this.totalPago = totalPago;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public static String shortUUID() {
        UUID uuid = UUID.randomUUID();
        long l = ByteBuffer.wrap(uuid.toString().getBytes()).getLong();
        return Long.toString(l, Character.MAX_RADIX);
    }

}
