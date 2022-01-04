package logica;

import datos.Reserva;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author pablo
 */
public class ReservaService {

    private Conexion conexion = new Conexion();
    private Connection conn = conexion.conectar();
    private String sSQL = "";
    private int totalReservas = 0;

    public int getTotalRegistro() {
        return totalReservas;
    }

    public DefaultTableModel mostrarTabla(String fechaReserva) {
        DefaultTableModel tabla;
        String[] columna = {"ID",  "idCliente", "idHabitacion", "Nº habitación", "Huesped", "Tipo de reserva", "Fecha de reserva", "CheckIn", "CheckOut", "Costo", "Estado"};
        String[] registro = new String[11];
        tabla = new DefaultTableModel(null, columna);
        sSQL = "SELECT r.id_reserva, r.id_cliente, r.id_habitacion, h.numero, "
                + "(SELECT nombre FROM cliente WHERE cliente.id_cliente = r.id_cliente) as clienteNombre, "
                + "(SELECT apellido FROM cliente WHERE cliente.id_cliente = r.id_cliente) as clienteApellido, "
                + "r.tipo_reserva, r.fecha_reserva, r.check_in, r.check_out, r.costo_alojamiento, r.estado "
                + "FROM reserva r "
                + "INNER JOIN habitacion h "
                + "ON r.id_habitacion = h.id_habitacion "
                + "WHERE r.check_in LIKE '%" + fechaReserva + "%' "
                + "ORDER BY id_reserva DESC";

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                registro[0] = rs.getString("id_reserva");
                registro[1] = rs.getString("id_cliente");
                registro[2] = rs.getString("id_habitacion");
                registro[3] = rs.getString("numero");
                registro[4] = rs.getString("clienteNombre") + " " + rs.getString("clienteApellido");
                registro[5] = rs.getString("tipo_reserva");
                registro[6] = rs.getString("fecha_reserva");
                registro[7] = rs.getString("check_in");
                registro[8] = rs.getString("check_out");
                registro[9] = rs.getString("costo_alojamiento");
                registro[10] = rs.getString("estado");
                totalReservas++;
                tabla.addRow(registro);
            }
            return tabla;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

        return null;
    }

    public boolean insertar(Reserva reserva) {
        sSQL = "INSERT INTO reserva(id_cliente, id_habitacion, tipo_reserva, fecha_reserva, check_in, check_out, costo_alojamiento, estado) VALUES(?,?,?,?,?,?,?,?)";

        try {

            PreparedStatement pstm = conn.prepareStatement(sSQL);

            pstm.setInt(1, reserva.getIdCliente());
            pstm.setInt(2, reserva.getIdHabitacion());
            pstm.setString(3, reserva.getTipoReserva());
            pstm.setDate(4, reserva.getFechaReserva());
            pstm.setDate(5, reserva.getCheckIn());
            pstm.setDate(6, reserva.getCheckOut());
            pstm.setDouble(7, reserva.getCostoAlojamiento());
            pstm.setString(8, reserva.getEstado());

            int resultado = pstm.executeUpdate();

            if (resultado != 0) {
                return true;
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return false;
    }

    public boolean editar(Reserva reserva) {
        sSQL = "UPDATE reserva SET id_cliente=?, id_habitacion=?, tipo_reserva=?, fecha_reserva=?, check_in=?, check_out=?, costo_alojamiento=?, estado=? WHERE id_reserva=?";

        try {

            PreparedStatement pstm = conn.prepareStatement(sSQL);

            pstm.setInt(1, reserva.getIdCliente());
            pstm.setInt(2, reserva.getIdHabitacion());
            pstm.setString(3, reserva.getTipoReserva());
            pstm.setDate(4, reserva.getFechaReserva());
            pstm.setDate(5, reserva.getCheckIn());
            pstm.setDate(6, reserva.getCheckOut());
            pstm.setDouble(7, reserva.getCostoAlojamiento());
            pstm.setString(8, reserva.getEstado());
            pstm.setInt(9, reserva.getIdReserva());

            int resultado = pstm.executeUpdate();

            if (resultado != 0) {
                return true;
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return false;
    }

    public boolean eliminar(Reserva reserva) {
        sSQL = "DELETE FROM reserva WHERE id_reserva = ?";

        try {
            PreparedStatement pstm = conn.prepareStatement(sSQL);

            pstm.setInt(1, reserva.getIdReserva());

            int resultado = pstm.executeUpdate();
            if (resultado != 0) {
                return true;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return false;
    }
    
    public boolean reservaPagada(Reserva reserva) {
        sSQL = "UPDATE reserva SET estado='Pagado' WHERE id_reserva=?";

        try {

            PreparedStatement pstm = conn.prepareStatement(sSQL);

            pstm.setInt(1, reserva.getIdReserva());
            
            int resultado = pstm.executeUpdate();

            if (resultado != 0) {
                return true;
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return false;
    }

}
