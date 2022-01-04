package presentacion;

import datos.Habitacion;
import datos.Reserva;
import java.sql.Date;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import logica.HabitacionService;
import logica.ReservaService;

/**
 *
 * @author pablo
 */
public class FrmReserva extends javax.swing.JInternalFrame {

    /**
     * Creates new form FrmReserva
     */
    public FrmReserva() {
        initComponents();
        llenarTabla("");
        inhabilitarCajasDeTextoYBotones();
    }

    private String accion = "guardar";

    private void ocultarColumnaIdReserva() {
        tablaListar.getColumnModel().getColumn(0).setMaxWidth(0);
        tablaListar.getColumnModel().getColumn(0).setMinWidth(0);
        tablaListar.getColumnModel().getColumn(0).setPreferredWidth(0);
        tablaListar.getColumnModel().getColumn(1).setMaxWidth(0);
        tablaListar.getColumnModel().getColumn(1).setMinWidth(0);
        tablaListar.getColumnModel().getColumn(1).setPreferredWidth(0);
        tablaListar.getColumnModel().getColumn(2).setMaxWidth(0);
        tablaListar.getColumnModel().getColumn(2).setMinWidth(0);
        tablaListar.getColumnModel().getColumn(2).setPreferredWidth(0);
    }

    private void inhabilitarCajasDeTextoYBotones() {
        txtIdReserva.setVisible(false);
        txtIdHabitacion.setVisible(false);
        txtIdCliente.setVisible(false);
        txtNumeroHabitacion.setEnabled(false);
        txtHuesped.setEnabled(false);
        cboTipoReserva.setEnabled(false);
        txtCosto.setEnabled(false);
        cboEstadoReserva.setEnabled(false);

        dcFechaReserva.setEnabled(false);
        dcCheckIn.setEnabled(false);
        dcCheckOut.setEnabled(false);

        btnGuardar.setEnabled(false);
        btnCancelar.setEnabled(false);
        btnBorrar.setEnabled(false);
        btnBuscarHabitacion.setEnabled(false);
        btnBuscarHuesped.setEnabled(false);

        txtIdReserva.setText("");
        txtNumeroHabitacion.setText("");
        txtHuesped.setText("");
        txtCosto.setText("");
    }

    private void habilitarCajasDeTextoYBotones() {
        txtIdReserva.setVisible(false);
        txtIdHabitacion.setVisible(false);
        txtIdCliente.setVisible(false);
        txtNumeroHabitacion.setEnabled(false);
        txtHuesped.setEnabled(false);
        cboTipoReserva.setEnabled(true);
        txtCosto.setEnabled(false);
        cboEstadoReserva.setEnabled(true);

        dcFechaReserva.setEnabled(true);
        dcCheckIn.setEnabled(true);
        dcCheckOut.setEnabled(true);

        btnGuardar.setEnabled(true);
        btnCancelar.setEnabled(true);
        btnBorrar.setEnabled(true);
        btnBuscarHabitacion.setEnabled(true);
        btnBuscarHuesped.setEnabled(true);

        txtIdReserva.setText("");
        txtNumeroHabitacion.setText("");
        txtHuesped.setText("");
        txtCosto.setText("");
    }

    private void llenarTabla(String buscar) {
        try {
            DefaultTableModel tableModel;
            ReservaService service = new ReservaService();
            tableModel = service.mostrarTabla(buscar);
            tablaListar.setModel(tableModel);
            inhabilitarCajasDeTextoYBotones();
            ocultarColumnaIdReserva();
            lblTotalClientes.setText("Total de reservas: " + Integer.toString(service.getTotalRegistro()));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtIdReserva = new javax.swing.JTextField();
        txtNumeroHabitacion = new javax.swing.JTextField();
        txtHuesped = new javax.swing.JTextField();
        cboTipoReserva = new javax.swing.JComboBox<>();
        txtCosto = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        dcFechaReserva = new com.toedter.calendar.JDateChooser();
        dcCheckIn = new com.toedter.calendar.JDateChooser();
        dcCheckOut = new com.toedter.calendar.JDateChooser();
        cboEstadoReserva = new javax.swing.JComboBox<>();
        btnBuscarHabitacion = new javax.swing.JButton();
        btnBuscarHuesped = new javax.swing.JButton();
        txtIdHabitacion = new javax.swing.JTextField();
        txtIdCliente = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        txtBuscar = new javax.swing.JTextField();
        jLabel51 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        tablaListar = new javax.swing.JTable();
        lblTotalClientes = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnRealizarPagos = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jPanel1.setBackground(new java.awt.Color(208, 219, 229));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Registro Reservas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 18))); // NOI18N

        txtNumeroHabitacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumeroHabitacionActionPerformed(evt);
            }
        });

        txtHuesped.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHuespedActionPerformed(evt);
            }
        });

        cboTipoReserva.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Alquiler", "Huesped Fijo" }));

        txtCosto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCostoActionPerformed(evt);
            }
        });

        jLabel1.setText("Tipo de Reserva:");

        jLabel2.setText("Nº Habitación:");

        jLabel3.setText("Check-Out:");

        jLabel4.setText("Huesped:");

        jLabel5.setText("Fecha de Reserva:");

        jLabel6.setText("Check-In:");

        jLabel7.setText("Precio:");

        jLabel8.setText("Estado:");

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        cboEstadoReserva.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Alquilado", "Pagado", "Anulado", " " }));

        btnBuscarHabitacion.setText("Disponibles");
        btnBuscarHabitacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarHabitacionActionPerformed(evt);
            }
        });

        btnBuscarHuesped.setText("Buscar");
        btnBuscarHuesped.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarHuespedActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(btnNuevo)
                        .addGap(18, 18, 18)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel3)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dcCheckIn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dcFechaReserva, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dcCheckOut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cboTipoReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtHuesped)
                                    .addComponent(txtNumeroHabitacion))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnBuscarHabitacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnBuscarHuesped, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(cboEstadoReserva, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtCosto, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(txtIdReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtIdHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(129, 129, 129))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNumeroHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnBuscarHabitacion))
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtHuesped, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboTipoReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(dcFechaReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(dcCheckIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(dcCheckOut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(txtCosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cboEstadoReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnNuevo)
                                    .addComponent(btnGuardar)
                                    .addComponent(btnCancelar)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnBuscarHuesped)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(208, 219, 229));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Listado de reservas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 18))); // NOI18N

        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscartxtBuscarActionPerformed(evt);
            }
        });

        jLabel51.setText("Buscar por Check-In:");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarbtnBuscar4ActionPerformed(evt);
            }
        });

        btnBorrar.setText("Borrar");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarbtnBorrarActionPerformed(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirbtnSalirActionPerformed(evt);
            }
        });

        tablaListar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablaListar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaListartablaListarMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(tablaListar);

        lblTotalClientes.setText("Registros");

        jLabel9.setText("(año-mes-dia)");

        btnRealizarPagos.setText("Realizar pagos");
        btnRealizarPagos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRealizarPagosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane8))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblTotalClientes, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                        .addGap(141, 141, 141)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel51)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel9)
                                                .addGap(25, 25, 25)))
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                .addComponent(btnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnBorrar)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnRealizarPagos, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSalir)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnBuscar)
                                .addComponent(btnBorrar))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel51)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)))
                .addGap(31, 31, 31)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTotalClientes)
                .addGap(42, 42, 42)
                .addComponent(btnRealizarPagos)
                .addContainerGap(73, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNumeroHabitacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumeroHabitacionActionPerformed
        txtNumeroHabitacion.transferFocus();
    }//GEN-LAST:event_txtNumeroHabitacionActionPerformed

    private void txtHuespedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHuespedActionPerformed
        txtHuesped.transferFocus();
    }//GEN-LAST:event_txtHuespedActionPerformed

    private void txtCostoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCostoActionPerformed
        txtCosto.transferFocus();
    }//GEN-LAST:event_txtCostoActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        habilitarCajasDeTextoYBotones();
        btnGuardar.setText("Guardar");
        accion = "guardar";
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (txtIdHabitacion.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Seleccione una habitación");
            txtNumeroHabitacion.requestFocus();
            return;
        }
        if (txtIdCliente.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Seleccione un huesped");
            txtHuesped.requestFocus();
            return;
        }

        Reserva nuevaReserva = new Reserva();
        ReservaService service = new ReservaService();
        HabitacionService hs = new HabitacionService();

        nuevaReserva.setIdCliente(Integer.parseInt(txtIdCliente.getText()));
        nuevaReserva.setIdHabitacion(Integer.parseInt(txtIdHabitacion.getText()));
        nuevaReserva.setTipoReserva(cboTipoReserva.getSelectedItem().toString());
        
        Calendar cal;
        int dia, mes, anio;
        cal = dcFechaReserva.getCalendar();
        dia = cal.get(Calendar.DAY_OF_MONTH);
        mes = cal.get(Calendar.MONTH);
        anio = cal.get(Calendar.YEAR) - 1900;
        nuevaReserva.setFechaReserva(new Date(anio, mes, dia));
        
        cal = dcCheckIn.getCalendar();
        dia = cal.get(Calendar.DAY_OF_MONTH);
        mes = cal.get(Calendar.MONTH);
        anio = cal.get(Calendar.YEAR) - 1900;
        nuevaReserva.setCheckIn(new Date(anio, mes, dia));
        
        cal = dcCheckOut.getCalendar();
        dia = cal.get(Calendar.DAY_OF_MONTH);
        mes = cal.get(Calendar.MONTH);
        anio = cal.get(Calendar.YEAR) - 1900;
        nuevaReserva.setCheckOut(new Date(anio, mes, dia));

        int milisecondsByDay = 86400000;
        int dias = (int) ((dcCheckOut.getDate().getTime() - dcCheckIn.getDate().getTime()) / milisecondsByDay);
        nuevaReserva.setCostoAlojamiento(hs.precio(Integer.parseInt(txtIdHabitacion.getText())) * dias);       
        nuevaReserva.setEstado(cboEstadoReserva.getSelectedItem().toString());

        if (accion.equals("guardar")) {
            if (service.insertar(nuevaReserva)) {
                JOptionPane.showMessageDialog(rootPane, "Reserva agregada con éxito");
                llenarTabla("");
                inhabilitarCajasDeTextoYBotones();
                
                //OCUPAMOS LA HABITACION ALQUILADA
                HabitacionService habitacionService = new HabitacionService();
                Habitacion alquilada = new Habitacion();
                alquilada.setIdHabitacion(Integer.parseInt(txtIdHabitacion.getText()));
                habitacionService.ocuparHabitacion(alquilada);
                
            } else {
                JOptionPane.showMessageDialog(rootPane, "Falló el registro de Reserva");
            }
        }

        if (accion.equals("editar")) {
            nuevaReserva.setIdReserva(Integer.parseInt(txtIdReserva.getText()));

            if (service.editar(nuevaReserva)) {
                JOptionPane.showMessageDialog(rootPane, "Reserva editada con éxito");
                llenarTabla("");
                inhabilitarCajasDeTextoYBotones();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Falló editar reserva");
            }

        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        inhabilitarCajasDeTextoYBotones();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtBuscartxtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscartxtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscartxtBuscarActionPerformed

    private void btnBuscarbtnBuscar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarbtnBuscar4ActionPerformed
        llenarTabla(txtBuscar.getText());
    }//GEN-LAST:event_btnBuscarbtnBuscar4ActionPerformed

    private void btnBorrarbtnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarbtnBorrarActionPerformed
        if (!txtIdReserva.getText().equals("")) {
            int confirmacion = JOptionPane.showConfirmDialog(rootPane, "¿Está seguro que desea eliminar la reserva?", "Confirmar", 2);

            if (confirmacion == 0) {
                ReservaService service = new ReservaService();
                Reserva reservaEliminar = new Reserva();

                reservaEliminar.setIdReserva(Integer.parseInt(txtIdReserva.getText()));
                service.eliminar(reservaEliminar);
                llenarTabla("");
                inhabilitarCajasDeTextoYBotones();
            }
        }
    }//GEN-LAST:event_btnBorrarbtnBorrarActionPerformed

    private void btnSalirbtnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirbtnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirbtnSalirActionPerformed

    private void tablaListartablaListarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaListartablaListarMouseClicked
        btnGuardar.setText("Editar");
        habilitarCajasDeTextoYBotones();
        accion = "editar";

        int fila = tablaListar.rowAtPoint(evt.getPoint());

        txtIdReserva.setText(tablaListar.getValueAt(fila, 0).toString());
        txtIdCliente.setText(tablaListar.getValueAt(fila, 1).toString());
        txtIdHabitacion.setText(tablaListar.getValueAt(fila, 2).toString());
        txtNumeroHabitacion.setText(tablaListar.getValueAt(fila, 3).toString());
        txtHuesped.setText(tablaListar.getValueAt(fila, 4).toString());
        cboTipoReserva.setSelectedItem(tablaListar.getValueAt(fila, 5));
        dcFechaReserva.setDate(Date.valueOf(tablaListar.getValueAt(fila, 6).toString()));
        dcCheckIn.setDate(Date.valueOf(tablaListar.getValueAt(fila, 7).toString()));
        dcCheckOut.setDate(Date.valueOf(tablaListar.getValueAt(fila, 8).toString()));
        txtCosto.setText(tablaListar.getValueAt(fila, 9).toString());
        cboEstadoReserva.setSelectedItem(tablaListar.getValueAt(fila, 10));

    }//GEN-LAST:event_tablaListartablaListarMouseClicked

    private void btnBuscarHabitacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarHabitacionActionPerformed
        FrmVistaHabitacion vista = new FrmVistaHabitacion();
        vista.toFront();
        vista.setVisible(true);
    }//GEN-LAST:event_btnBuscarHabitacionActionPerformed

    private void btnBuscarHuespedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarHuespedActionPerformed
        FrmVistaCliente vista = new FrmVistaCliente();
        vista.toFront();
        vista.setVisible(true);
    }//GEN-LAST:event_btnBuscarHuespedActionPerformed

    private void btnRealizarPagosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRealizarPagosActionPerformed
        int fila = tablaListar.getSelectedRow();
        FrmPago.idReserva = tablaListar.getValueAt(fila, 0).toString();
        FrmPago.cliente = tablaListar.getValueAt(fila, 4).toString();
        FrmPago.totalReserva = Double.parseDouble(tablaListar.getValueAt(fila, 9).toString());
        FrmPago.idHabitacion = tablaListar.getValueAt(fila, 2).toString();
        FrmPago.habitacion = tablaListar.getValueAt(fila, 3).toString();
        FrmPago form = new FrmPago();
        FrmInicio.escritorio.add(form);
        form.toFront();
        form.setVisible(true);
        
        
    }//GEN-LAST:event_btnRealizarPagosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnBuscarHabitacion;
    private javax.swing.JButton btnBuscarHuesped;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnRealizarPagos;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cboEstadoReserva;
    private javax.swing.JComboBox<String> cboTipoReserva;
    private com.toedter.calendar.JDateChooser dcCheckIn;
    private com.toedter.calendar.JDateChooser dcCheckOut;
    private com.toedter.calendar.JDateChooser dcFechaReserva;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JLabel lblTotalClientes;
    private javax.swing.JTable tablaListar;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCosto;
    public static javax.swing.JTextField txtHuesped;
    public static javax.swing.JTextField txtIdCliente;
    public static javax.swing.JTextField txtIdHabitacion;
    private javax.swing.JTextField txtIdReserva;
    public static javax.swing.JTextField txtNumeroHabitacion;
    // End of variables declaration//GEN-END:variables
}