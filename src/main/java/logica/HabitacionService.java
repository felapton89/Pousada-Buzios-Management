package logica;

import datos.Habitacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class HabitacionService {

    private Conexion conexion = new Conexion();
    private Connection conn = conexion.conectar();
    private String sSQL = "";
    private int totalRegistro = 0;

    public int getTotalRegistro() {
        return totalRegistro;
    }
    

    public DefaultTableModel tableModel(String estado) {
        DefaultTableModel tabla;
        String[] columna = {"ID", "Número", "Característica", "Precio", "Estado", "Tipo habitación"};
        String[] registro = new String[6];
        tabla = new DefaultTableModel(null, columna);
        sSQL = "SELECT * FROM habitacion WHERE estado LIKE '%" + estado + "%' ORDER BY id_habitacion";

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                registro[0] = rs.getString("id_habitacion");
                registro[1] = rs.getString("numero");
                registro[2] = rs.getString("caracteristicas");
                registro[3] = rs.getString("precio_diario");
                registro[4] = rs.getString("estado");
                registro[5] = rs.getString("tipo_habitacion");
                totalRegistro++;
                tabla.addRow(registro);
            }
            return tabla;

        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(null, ex);
        }

        return null;
    }
    
    public DefaultTableModel habitacionesDisponibles() {
        DefaultTableModel tabla;
        String[] columna = {"ID", "Número", "Característica", "Precio", "Estado", "Tipo habitación"};
        String[] registro = new String[6];
        tabla = new DefaultTableModel(null, columna);
        sSQL = "SELECT * FROM habitacion WHERE estado = 'Disponible' ORDER BY id_habitacion";

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                registro[0] = rs.getString("id_habitacion");
                registro[1] = rs.getString("numero");
                registro[2] = rs.getString("caracteristicas");
                registro[3] = rs.getString("precio_diario");
                registro[4] = rs.getString("estado");
                registro[5] = rs.getString("tipo_habitacion");
                totalRegistro++;
                tabla.addRow(registro);
            }
            return tabla;

        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(null, ex);
        }

        return null;
    }

    public boolean insertar(Habitacion habitacion) {
        sSQL = "INSERT INTO habitacion(numero, caracteristicas, precio_diario, estado, tipo_habitacion) VALUES(?,?,?,?,?)";

        try {

            PreparedStatement pstm = conn.prepareStatement(sSQL);
            pstm.setString(1, habitacion.getNumero());
            pstm.setString(2, habitacion.getCaracteristica());
            pstm.setDouble(3, habitacion.getPrecioDiario());
            pstm.setString(4, habitacion.getEstado());
            pstm.setString(5, habitacion.getTipoHabitacion());
            int resultado = pstm.executeUpdate();
            if (resultado != 0) {
                return true;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
        }
        return false;
    }

    public boolean editar(Habitacion habitacion) {
        sSQL = "UPDATE habitacion SET numero = ?, caracteristicas = ?, precio_diario = ?, estado = ?, tipo_habitacion = ? WHERE id_habitacion = ?";
        
        try {
            
            PreparedStatement pstm = conn.prepareStatement(sSQL);
            pstm.setString(1, habitacion.getNumero());
            pstm.setString(2, habitacion.getCaracteristica());
            pstm.setDouble(3, habitacion.getPrecioDiario());
            pstm.setString(4, habitacion.getEstado());
            pstm.setString(5, habitacion.getTipoHabitacion());
            pstm.setInt(6, habitacion.getIdHabitacion());
            int resultado = pstm.executeUpdate();
            if (resultado != 0) {
                return true;
            }      
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
        }
        return false;
    }

    public boolean eliminar(Habitacion habitacion) {
        sSQL = "DELETE FROM habitacion WHERE id_habitacion = ?";
        
        try {
            PreparedStatement pstm = conn.prepareStatement(sSQL);
            pstm.setInt(1, habitacion.getIdHabitacion());
            int resultado = pstm.executeUpdate();
            if (resultado != 0) {
                return true;
            }    

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
        }
        return false;
    }
    
    public double precio(int idHabitacion){
        sSQL = "SELECT precio_diario FROM habitacion WHERE id_habitacion = '" + idHabitacion + "'";
        
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                return rs.getDouble("precio_diario");
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
        }
        return 0;
    }
    
    public void ocuparHabitacion(Habitacion habitacion) {
        sSQL = "UPDATE habitacion SET estado = 'Ocupado' WHERE id_habitacion = ?";
        
        try {
            
            PreparedStatement pstm = conn.prepareStatement(sSQL);
            pstm.setInt(1, habitacion.getIdHabitacion());
            
            int resultado = pstm.executeUpdate();
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
        }
    }
    
    public void desocuparHabitacion(Habitacion habitacion) {
        sSQL = "UPDATE habitacion SET estado = 'Disponible' WHERE id_habitacion = ?";
        
        try {
            
            PreparedStatement pstm = conn.prepareStatement(sSQL);
            pstm.setInt(1, habitacion.getIdHabitacion());
            
            int resultado = pstm.executeUpdate();
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
        }
    }

}
