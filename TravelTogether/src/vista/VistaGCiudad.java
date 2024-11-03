/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import entidad.Ciudad;
import javax.swing.JOptionPane;
import persistencia.CiudadData;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Celi Leandro
 */
public class VistaGCiudad extends javax.swing.JInternalFrame {

    Ciudad ciudad;
    CiudadData ciudadData;
    String[] columnNames = {"Pais", "Ciudad", "Continente", "Rol", "Inicio Temporada", "Fin Temporada"};
    DefaultTableModel model = new DefaultTableModel(columnNames, 0);
    int filaSelecionada;

    public VistaGCiudad() {
        initComponents();
        jPanelTemporada.setVisible(false);
        cargarTabla();
        jButtonEliminar.setEnabled(false);
        jButtonModificar.setEnabled(false);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaCiudades = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButtonModificar = new javax.swing.JButton();
        jButtonEliminar = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTFNbreCiudad = new javax.swing.JTextField();
        jComboBoxRol = new javax.swing.JComboBox<>();
        jPanelTemporada = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jDateChooserInicio = new com.toedter.calendar.JDateChooser();
        jDateChooserFin = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        jTFNbrePais = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();

        setClosable(true);
        setTitle("Gestion Ciudad");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFrameIcon(null);

        jLabel1.setText("Gestion de Ciudad");

        TablaCiudades.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Pais", "Ciudad", "Inicio Temporada", "Fin Temporada", "Rol"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TablaCiudades.setColumnSelectionAllowed(true);
        TablaCiudades.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        TablaCiudades.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaCiudadesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablaCiudades);
        TablaCiudades.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButtonModificar.setText("Actulizar");
        jButtonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarActionPerformed(evt);
            }
        });

        jButtonEliminar.setText("Eliminar");
        jButtonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarActionPerformed(evt);
            }
        });

        jButton4.setText("Nuevo");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel2.setText("Nombre de Ciudad");

        jLabel3.setText("Rol de Ciuadad");

        jComboBoxRol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "Origen", "Origen-Destino", "Destino" }));
        jComboBoxRol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxRolActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Fechas de Temporada");

        jLabel5.setText("Comienzo de Temporada");

        jLabel7.setText("Fin de Temporada");

        javax.swing.GroupLayout jPanelTemporadaLayout = new javax.swing.GroupLayout(jPanelTemporada);
        jPanelTemporada.setLayout(jPanelTemporadaLayout);
        jPanelTemporadaLayout.setHorizontalGroup(
            jPanelTemporadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTemporadaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelTemporadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanelTemporadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jDateChooserInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooserFin, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelTemporadaLayout.setVerticalGroup(
            jPanelTemporadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTemporadaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(14, 14, 14)
                .addGroup(jPanelTemporadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addGroup(jPanelTemporadaLayout.createSequentialGroup()
                        .addGroup(jPanelTemporadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jDateChooserInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addComponent(jDateChooserFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jLabel8.setText("Nombre de Pais");

        jTFNbrePais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFNbrePaisActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel8))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTFNbreCiudad)
                    .addComponent(jComboBoxRol, 0, 186, Short.MAX_VALUE)
                    .addComponent(jTFNbrePais))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addComponent(jPanelTemporada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanelTemporada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTFNbrePais, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jTFNbreCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jComboBoxRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(54, 54, 54))
        );

        jButton6.setText("Guardar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonModificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 816, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 16, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(370, 370, 370)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(23, 23, 23)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButtonModificar)
                    .addComponent(jButtonEliminar)
                    .addComponent(jButton4)
                    .addComponent(jButton6))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        jPanelTemporada.setVisible(false);
        limpiarCampos();
        jTFNbreCiudad.setEditable(true);


    }//GEN-LAST:event_jButton4ActionPerformed

    private void jComboBoxRolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxRolActionPerformed
        String seleccion = (String) jComboBoxRol.getSelectedItem();

        if (!seleccion.equals("Origen") && (!seleccion.equals("-"))) {
            jPanelTemporada.setVisible(true);
        } else {
            jPanelTemporada.setVisible(false);
        }


    }//GEN-LAST:event_jComboBoxRolActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed


    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTFNbrePaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFNbrePaisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFNbrePaisActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        if (!chequeoCampos()) // verificamos campos
        {
            JOptionPane.showMessageDialog(null, "Hay Campos Sin Completar ", "Atencion", JOptionPane.ERROR_MESSAGE);

        } else {
            ciudad = new Ciudad();
            //Ahora cargamos los campos
            ciudad.setPais(jTFNbrePais.getText()); // Pais
            ciudad.setNombre(jTFNbreCiudad.getText()); // Ciudad
            ciudad.setRol((String) jComboBoxRol.getSelectedItem()); // Rol

            if (jDateChooserInicio.getDate() != null || jDateChooserFin.getDate() != null) {
                Date selectedDate = jDateChooserInicio.getDate();
                LocalDate localDateInicio = selectedDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                ciudad.setInicioTem(localDateInicio);

                Date selectedDate2 = jDateChooserFin.getDate();
                LocalDate localDateFin = selectedDate2.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                ciudad.setFinTem(localDateFin);
            } else {

                ciudad.setInicioTem(null);
                ciudad.setFinTem(null);

            }

            ciudadData = new CiudadData();

            if (ciudadData.guardarCiudad(ciudad)) {
                JOptionPane.showMessageDialog(null, "Se almaceno Nueva Ciudad", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                limpiarCampos();
                insertCiudad(ciudad);
                jPanelTemporada.setVisible(false);

            } else {
                JOptionPane.showMessageDialog(null, "Tuvismo un problema para Almacenar", "Error", JOptionPane.ERROR_MESSAGE);
            }

        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void TablaCiudadesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaCiudadesMouseClicked
        jTFNbreCiudad.setEditable(false);
        filaSelecionada = TablaCiudades.getSelectedRow();
        System.out.println("fila Selecionada " + filaSelecionada);

        jTFNbrePais.setText((String) TablaCiudades.getValueAt(filaSelecionada, 0));
        jTFNbreCiudad.setText((String) TablaCiudades.getValueAt(filaSelecionada, 1));

        String rol = ((String) TablaCiudades.getValueAt(filaSelecionada, 3));
        if (rol.equals("Origen")) {
            jComboBoxRol.setSelectedIndex(1);
        } else {
            if (rol.equals("Destino")) {
                jComboBoxRol.setSelectedIndex(3);
            } else {
                jComboBoxRol.setSelectedIndex(2);
            }

            LocalDate localDate = (LocalDate) TablaCiudades.getValueAt(filaSelecionada, 4);
            Date fecha = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
            jDateChooserInicio.setDate(fecha);

            localDate = (LocalDate) TablaCiudades.getValueAt(filaSelecionada, 5);
            fecha = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
            jDateChooserFin.setDate(fecha);

        }
        jButtonEliminar.setEnabled(true);
        jButtonModificar.setEnabled(true);

    }//GEN-LAST:event_TablaCiudadesMouseClicked

    private void jButtonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarActionPerformed

        ciudadData.borrarCiudad(jTFNbreCiudad.getText());
        model.removeRow(filaSelecionada);
        TablaCiudades.setModel(model);
        limpiarCampos();


    }//GEN-LAST:event_jButtonEliminarActionPerformed

    private void jButtonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarActionPerformed
        //Actualizar datos 

        if (!chequeoCampos()) // verificamos campos
        {
            JOptionPane.showMessageDialog(null, "Hay Campos Sin Completar ", "Atencion", JOptionPane.ERROR_MESSAGE);

        } else {
            ciudad = new Ciudad();
            //Ahora cargamos los campos
            ciudad.setPais(jTFNbrePais.getText()); // Pais
            ciudad.setNombre(jTFNbreCiudad.getText()); // Ciudad
            ciudad.setRol((String) jComboBoxRol.getSelectedItem()); // Rol

            if (jDateChooserInicio.getDate() != null || jDateChooserFin.getDate() != null) {
                Date selectedDate = jDateChooserInicio.getDate();
                LocalDate localDateInicio = selectedDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                ciudad.setInicioTem(localDateInicio);

                Date selectedDate2 = jDateChooserFin.getDate();
                LocalDate localDateFin = selectedDate2.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                ciudad.setFinTem(localDateFin);
            } else {

                ciudad.setInicioTem(null);
                ciudad.setFinTem(null);

            }

            if (ciudadData.actualizarCiudad(ciudad)) 
            {
                JOptionPane.showMessageDialog(null, "Se Completo La Actulizacion ", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, "Tuvismo un problema para Actulizar", "Error", JOptionPane.ERROR_MESSAGE);
            }

        }
    }//GEN-LAST:event_jButtonModificarActionPerformed

    public void cargarTabla() {
        if (ciudadData == null) {
            ciudadData = new CiudadData();

            List<Ciudad> ciudades = ciudadData.listarCiudades();

            // Llenar el modelo con los datos de las ciudades
            for (Ciudad ciudad : ciudades) {
                Object[] rowData = {
                    ciudad.getPais(),
                    ciudad.getNombre(),
                    ciudad.getContinente(),
                    ciudad.getRol(),
                    ciudad.getInicioTem(),
                    ciudad.getFinTem()
                };
                model.addRow(rowData);
            }

            TablaCiudades.setModel(model);

            //JScrollPane scrollPane = new JScrollPane(table);
        }

    }

    public void insertCiudad(Ciudad c) {
        Object[] rowData
                = {
                    //c.getCodCiudad(),
                    c.getPais(),
                    c.getNombre(),
                    c.getContinente(),
                    c.getRol(),
                    c.getInicioTem(),
                    c.getFinTem()
                };

        model.addRow(rowData);
        TablaCiudades.setModel(model);
    }

    public void limpiarCampos() {
        jTFNbrePais.setText("");
        jTFNbreCiudad.setText("");
        jComboBoxRol.setSelectedIndex(0);
        jDateChooserFin.setDate(null);
        jDateChooserInicio.setDate(null);
    }

    public boolean chequeoCampos() {

        boolean respuesta = false;
        if (!jTFNbrePais.getText().isEmpty() && !jTFNbreCiudad.getText().isEmpty()) {
            if (!jComboBoxRol.getSelectedItem().equals("-")) {
                if (jComboBoxRol.getSelectedItem().equals("Origen")) {
                    respuesta = true;
                } else {
                    respuesta = ((jDateChooserInicio.getDate() != null) && (jDateChooserFin.getDate() != null));

                }

            }

        }

        return respuesta;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaCiudades;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButtonEliminar;
    private javax.swing.JButton jButtonModificar;
    private javax.swing.JComboBox<String> jComboBoxRol;
    private com.toedter.calendar.JDateChooser jDateChooserFin;
    private com.toedter.calendar.JDateChooser jDateChooserInicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelTemporada;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTFNbreCiudad;
    private javax.swing.JTextField jTFNbrePais;
    // End of variables declaration//GEN-END:variables
}
