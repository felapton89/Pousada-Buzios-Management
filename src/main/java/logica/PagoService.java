package logica;

import datos.Pago;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author pablo
 */
public class PagoService {
    
    private Conexion conexion = new Conexion();
    private Connection conn = conexion.conectar();
    private String sSQL = "";
    private int totalRegistros = 0;

    public int getTotalRegistro() {
        return totalRegistros;
    }

    public DefaultTableModel mostrarTabla(String reserva) {
        DefaultTableModel tabla;
        String[] columna = {"ID", "IdReserva", "Nº Comprobante", "Total", "Fecha Emisión", "Fecha Pago"};
        String[] registro = new String[7];
        tabla = new DefaultTableModel(null, columna);
        sSQL = "SELECT * FROM pago WHERE id_reserva = " + reserva + " ORDER BY id_pago DESC";

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                registro[0] = rs.getString("id_pago");
                registro[1] = rs.getString("id_reserva");
                registro[2] = rs.getString("num_comprobante");
                registro[3] = rs.getString("total_pago");
                registro[4] = rs.getString("fecha_emision");
                registro[5] = rs.getString("fecha_pago");
                totalRegistros++;
                tabla.addRow(registro);
            }
            return tabla;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

        return null;
    }

    public boolean insertar(Pago pago) {
        sSQL = "INSERT INTO pago(id_reserva, num_comprobante, total_pago, fecha_emision, fecha_pago) VALUES(?,?,?,?,?)";

        try {

            PreparedStatement pstm = conn.prepareStatement(sSQL);

            pstm.setInt(1, pago.getIdReserva());
            pstm.setString(2, pago.getNumComprobante());
            pstm.setDouble(3, pago.getTotalPago());
            pstm.setDate(4, pago.getFechaEmision());
            pstm.setDate(5, pago.getFechaPago());

            int resultado = pstm.executeUpdate();

            if (resultado != 0) {
                return true;
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return false;
    }

    public boolean editar(Pago pago) {
        sSQL = "UPDATE pago SET id_reserva=?, num_comprobante=?, total_pago=?, fecha_emision=?, fecha_pago=? WHERE id_pago=?";

        try {

            PreparedStatement pstm = conn.prepareStatement(sSQL);

            pstm.setInt(1, pago.getIdReserva());
            pstm.setString(2, pago.getNumComprobante());
            pstm.setDouble(3, pago.getTotalPago());
            pstm.setDate(4, pago.getFechaEmision());
            pstm.setDate(5, pago.getFechaPago());
            pstm.setInt(6, pago.getIdPago());

            int resultado = pstm.executeUpdate();

            if (resultado != 0) {
                return true;
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return false;
    }

    public boolean eliminar(Pago pago) {
        sSQL = "DELETE FROM pago WHERE id_pago = ?";

        try {
            PreparedStatement pstm = conn.prepareStatement(sSQL);

            pstm.setInt(1, pago.getIdPago());

            int resultado = pstm.executeUpdate();
            if (resultado != 0) {
                return true;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return false;
    }
    
}
