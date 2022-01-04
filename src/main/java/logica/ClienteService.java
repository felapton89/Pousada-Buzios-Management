package logica;

import datos.Cliente;
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
public class ClienteService {

    private Conexion conexion = new Conexion();
    private Connection conn = conexion.conectar();
    private String sSQL = "";
    private int totalClientes = 0;

    public int getTotalRegistro() {
        return totalClientes;
    }

    public DefaultTableModel mostrarTabla(String documento) {
        DefaultTableModel tabla;
        String[] columna = {"ID", "Nombre", "Apellido", "Documento", "Nº Documento", "Dirección", "Teléfono", "Email", "Comentario"};
        String[] registro = new String[9];
        tabla = new DefaultTableModel(null, columna);
        sSQL = "SELECT * FROM cliente WHERE num_documento LIKE '%" + documento + "%' ORDER BY id_cliente";

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                registro[0] = rs.getString("id_cliente");
                registro[1] = rs.getString("nombre");
                registro[2] = rs.getString("apellido");
                registro[3] = rs.getString("tipo_documento");
                registro[4] = rs.getString("num_documento");
                registro[5] = rs.getString("direccion");
                registro[6] = rs.getString("telefono");
                registro[7] = rs.getString("email");
                registro[8] = rs.getString("comentario");
                totalClientes++;
                tabla.addRow(registro);
            }
            return tabla;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

        return null;
    }

    public boolean insertar(Cliente cliente) {
        sSQL = "INSERT INTO cliente(nombre, apellido, tipo_documento, num_documento, direccion, telefono, email, comentario) VALUES(?,?,?,?,?,?,?,?)";

        try {

            PreparedStatement pstm = conn.prepareStatement(sSQL);

            pstm.setString(1, cliente.getNombre());
            pstm.setString(2, cliente.getApellido());
            pstm.setString(3, cliente.getTipoDocumento());
            pstm.setString(4, cliente.getNumDocumento());
            pstm.setString(5, cliente.getDireccion());
            pstm.setString(6, cliente.getTelefono());
            pstm.setString(7, cliente.getEmail());
            if (cliente.getComentario().isEmpty() || cliente.getComentario() == null) {
                pstm.setString(8, "---");
            } else {
                pstm.setString(8, cliente.getComentario());
            }

            int resultado = pstm.executeUpdate();

            if (resultado != 0) {
                return true;
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return false;
    }

    public boolean editar(Cliente cliente) {
        sSQL = "UPDATE cliente SET nombre=?, apellido=?, tipo_documento=?, num_documento=?, direccion=?, telefono=?, email=?, comentario=? WHERE id_cliente=?";

        try {

            PreparedStatement pstm = conn.prepareStatement(sSQL);

            pstm.setString(1, cliente.getNombre());
            pstm.setString(2, cliente.getApellido());
            pstm.setString(3, cliente.getTipoDocumento());
            pstm.setString(4, cliente.getNumDocumento());
            pstm.setString(5, cliente.getDireccion());
            pstm.setString(6, cliente.getTelefono());
            pstm.setString(7, cliente.getEmail());
            if (cliente.getComentario().isEmpty() || cliente.getComentario() == null) {
                pstm.setString(8, "---");
            } else {
                pstm.setString(8, cliente.getComentario());
            }
            pstm.setInt(9, cliente.getIdCliente());

            int resultado = pstm.executeUpdate();

            if (resultado != 0) {
                return true;
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return false;
    }

    public boolean eliminar(Cliente cliente) {
        sSQL = "DELETE FROM cliente WHERE id_cliente = ?";

        try {
            PreparedStatement pstm = conn.prepareStatement(sSQL);

            pstm.setInt(1, cliente.getIdCliente());

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
