/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import entidad.Turista;
import java.awt.CardLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Mila
 */
public class VistaCrearPaquete extends javax.swing.JInternalFrame {

    private final ArrayList<Turista> guardarTurista = new ArrayList<>();
    public VistaCrearPaquete() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        PanelPrincipal = new javax.swing.JPanel();
        PanelTurista = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        FieldDni = new javax.swing.JTextField();
        FieldApellido = new javax.swing.JTextField();
        FieldEmail = new javax.swing.JTextField();
        FieldNombre = new javax.swing.JTextField();
        FieldEdad = new javax.swing.JTextField();
        FieldTelefono = new javax.swing.JTextField();
        BotonSalir = new javax.swing.JButton();
        BotonSiguiente = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        LabelViajeros = new javax.swing.JLabel();
        Numero = new javax.swing.JLabel();
        BotonSumar = new javax.swing.JButton();
        BotonRestar = new javax.swing.JButton();
        Advertencia = new javax.swing.JLabel();
        BotonEstablecer = new javax.swing.JButton();
        BotonGuardar = new javax.swing.JButton();
        Contador = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        PanelPasaje = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        PanelAlojamiento = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();

        PanelPrincipal.setLayout(new java.awt.CardLayout());

        ImageIcon imagen = new ImageIcon(getClass().getResource("/imagenes/icono2.jpg"));
        Image miImagen = imagen.getImage();
        PanelTurista = new javax.swing.JPanel(){
            public void paintComponent(Graphics g){
                g.drawImage(miImagen, 0, 0, getWidth(), getHeight(), this);
            }
        };
        PanelTurista.setForeground(new java.awt.Color(0, 0, 0));
        PanelTurista.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Turista ");
        PanelTurista.add(jLabel2);
        jLabel2.setBounds(61, 98, 87, 32);

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("DNI");
        PanelTurista.add(jLabel3);
        jLabel3.setBounds(61, 288, 56, 26);

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Nombre");
        PanelTurista.add(jLabel4);
        jLabel4.setBounds(60, 200, 86, 26);

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Apellido");
        PanelTurista.add(jLabel5);
        jLabel5.setBounds(390, 200, 79, 26);

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Mail");
        PanelTurista.add(jLabel6);
        jLabel6.setBounds(390, 290, 45, 26);

        jLabel7.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Edad");
        PanelTurista.add(jLabel7);
        jLabel7.setBounds(61, 382, 200, 26);

        jLabel8.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Telefono");
        PanelTurista.add(jLabel8);
        jLabel8.setBounds(390, 380, 97, 26);

        FieldDni.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        FieldDni.setEnabled(false);
        FieldDni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                FieldDniKeyTyped(evt);
            }
        });
        PanelTurista.add(FieldDni);
        FieldDni.setBounds(61, 332, 200, 32);

        FieldApellido.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        FieldApellido.setEnabled(false);
        PanelTurista.add(FieldApellido);
        FieldApellido.setBounds(390, 240, 200, 30);

        FieldEmail.setToolTipText("Ingrese el correo en formato: turista@dominio.com");
        FieldEmail.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        FieldEmail.setEnabled(false);
        FieldEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FieldEmailActionPerformed(evt);
            }
        });
        PanelTurista.add(FieldEmail);
        FieldEmail.setBounds(390, 330, 200, 32);

        FieldNombre.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        FieldNombre.setEnabled(false);
        FieldNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FieldNombreActionPerformed(evt);
            }
        });
        PanelTurista.add(FieldNombre);
        FieldNombre.setBounds(61, 240, 200, 30);

        FieldEdad.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        FieldEdad.setEnabled(false);
        FieldEdad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                FieldEdadKeyTyped(evt);
            }
        });
        PanelTurista.add(FieldEdad);
        FieldEdad.setBounds(60, 420, 200, 32);

        FieldTelefono.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        FieldTelefono.setEnabled(false);
        FieldTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FieldTelefonoActionPerformed(evt);
            }
        });
        FieldTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                FieldTelefonoKeyTyped(evt);
            }
        });
        PanelTurista.add(FieldTelefono);
        FieldTelefono.setBounds(390, 420, 200, 32);

        BotonSalir.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        BotonSalir.setText("Salir");
        BotonSalir.setEnabled(false);
        BotonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonSalirActionPerformed(evt);
            }
        });
        PanelTurista.add(BotonSalir);
        BotonSalir.setBounds(60, 480, 150, 46);

        BotonSiguiente.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        BotonSiguiente.setText("Siguiente");
        BotonSiguiente.setEnabled(false);
        BotonSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonSiguienteActionPerformed(evt);
            }
        });
        PanelTurista.add(BotonSiguiente);
        BotonSiguiente.setBounds(450, 480, 150, 47);

        jLabel15.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("¿Cuantos viajan?");
        PanelTurista.add(jLabel15);
        jLabel15.setBounds(260, 90, 173, 42);

        LabelViajeros.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        LabelViajeros.setForeground(new java.awt.Color(255, 255, 255));
        LabelViajeros.setText("Viajero");
        PanelTurista.add(LabelViajeros);
        LabelViajeros.setBounds(260, 130, 74, 29);

        Numero.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        Numero.setForeground(new java.awt.Color(255, 255, 255));
        Numero.setText("1");
        PanelTurista.add(Numero);
        Numero.setBounds(370, 140, 8, 19);

        BotonSumar.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        BotonSumar.setText("+");
        BotonSumar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonSumarActionPerformed(evt);
            }
        });
        PanelTurista.add(BotonSumar);
        BotonSumar.setBounds(380, 130, 39, 37);

        BotonRestar.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        BotonRestar.setText("-");
        BotonRestar.setEnabled(false);
        BotonRestar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonRestarActionPerformed(evt);
            }
        });
        PanelTurista.add(BotonRestar);
        BotonRestar.setBounds(330, 130, 35, 37);

        Advertencia.setForeground(new java.awt.Color(255, 102, 102));
        PanelTurista.add(Advertencia);
        Advertencia.setBounds(300, 185, 413, 17);

        BotonEstablecer.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        BotonEstablecer.setText("Establecer");
        BotonEstablecer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonEstablecerActionPerformed(evt);
            }
        });
        PanelTurista.add(BotonEstablecer);
        BotonEstablecer.setBounds(440, 130, 120, 37);

        BotonGuardar.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        BotonGuardar.setText("Guardar");
        BotonGuardar.setEnabled(false);
        BotonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonGuardarActionPerformed(evt);
            }
        });
        PanelTurista.add(BotonGuardar);
        BotonGuardar.setBounds(240, 480, 150, 47);

        Contador.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        Contador.setForeground(new java.awt.Color(255, 255, 255));
        Contador.setText("1");
        PanelTurista.add(Contador);
        Contador.setBounds(154, 98, 13, 32);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 28)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Creación de Paquete");
        PanelTurista.add(jLabel1);
        jLabel1.setBounds(200, 10, 279, 37);

        PanelPrincipal.add(PanelTurista, "PanelTurista");

        PanelPasaje.setName(""); // NOI18N

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel9.setText("Pasaje");

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel10.setText("Ciudad Origen:");

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel11.setText("Ciudad Destino:");

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel12.setText("Fecha Check-in:");

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel13.setText("Fecha Check-out:");

        jLabel14.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel14.setText("Transporte: ");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Avion");

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Colectivo");

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setText("Barco");

        jButton3.setText("Volver");

        jButton4.setText("Limpiar Campos");

        jButton5.setText("Continuar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelPasajeLayout = new javax.swing.GroupLayout(PanelPasaje);
        PanelPasaje.setLayout(PanelPasajeLayout);
        PanelPasajeLayout.setHorizontalGroup(
            PanelPasajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelPasajeLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(272, 272, 272))
            .addGroup(PanelPasajeLayout.createSequentialGroup()
                .addGroup(PanelPasajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelPasajeLayout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(PanelPasajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelPasajeLayout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(PanelPasajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jRadioButton1)
                                    .addComponent(jRadioButton2)
                                    .addComponent(jRadioButton3)))
                            .addGroup(PanelPasajeLayout.createSequentialGroup()
                                .addGroup(PanelPasajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(PanelPasajeLayout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(PanelPasajeLayout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(74, 74, 74)
                                .addGroup(PanelPasajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(PanelPasajeLayout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(PanelPasajeLayout.createSequentialGroup()
                                        .addComponent(jLabel13)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(PanelPasajeLayout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jButton3)
                        .addGap(133, 133, 133)
                        .addComponent(jButton4)
                        .addGap(94, 94, 94)
                        .addComponent(jButton5)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        PanelPasajeLayout.setVerticalGroup(
            PanelPasajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPasajeLayout.createSequentialGroup()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(PanelPasajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PanelPasajeLayout.createSequentialGroup()
                        .addGroup(PanelPasajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(54, 54, 54)
                        .addGroup(PanelPasajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(PanelPasajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel12)
                                .addComponent(jLabel13))
                            .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(65, 65, 65)
                .addComponent(jRadioButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelPasajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jRadioButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 139, Short.MAX_VALUE)
                .addGroup(PanelPasajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addGap(41, 41, 41))
        );

        PanelPrincipal.add(PanelPasaje, "PanelPasaje");

        jLabel16.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel16.setText("Alojamiento");

        javax.swing.GroupLayout PanelAlojamientoLayout = new javax.swing.GroupLayout(PanelAlojamiento);
        PanelAlojamiento.setLayout(PanelAlojamientoLayout);
        PanelAlojamientoLayout.setHorizontalGroup(
            PanelAlojamientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelAlojamientoLayout.createSequentialGroup()
                .addContainerGap(244, Short.MAX_VALUE)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(230, 230, 230))
        );
        PanelAlojamientoLayout.setVerticalGroup(
            PanelAlojamientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelAlojamientoLayout.createSequentialGroup()
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 508, Short.MAX_VALUE))
        );

        PanelPrincipal.add(PanelAlojamiento, "PanelAlojamiento");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PanelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotonSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonSiguienteActionPerformed
        CardLayout cardLayout = (CardLayout) PanelPrincipal.getLayout();
        cardLayout.show(PanelPrincipal, "PanelPasaje");
        PanelPrincipal.validate();
        PanelPrincipal.repaint();       
    }//GEN-LAST:event_BotonSiguienteActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        CardLayout cardLayout = (CardLayout) PanelPrincipal.getLayout();
        cardLayout.show(PanelPrincipal, "PanelAlojamiento");
        PanelPrincipal.validate();
        PanelPrincipal.repaint();     
    }//GEN-LAST:event_jButton5ActionPerformed

    private void FieldTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FieldTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FieldTelefonoActionPerformed

    private void BotonRestarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonRestarActionPerformed
        
        int num = Integer.parseInt(Numero.getText());
        num--;
        
        if(num < 1 || num == 1){
            BotonRestar.setEnabled(false);
            Numero.setText(String.valueOf(num));
        }else{
            BotonRestar.setEnabled(true);
            Numero.setText(String.valueOf(num));
            Advertencia.setText("");
        }
        
        if(num == 1){
            LabelViajeros.setText("Viajero");
        }      
    }//GEN-LAST:event_BotonRestarActionPerformed

    private void BotonSumarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonSumarActionPerformed
        int num = Integer.parseInt(Numero.getText());
        num++;
        if(num <= 7){
        Numero.setText(String.valueOf(num));
        }
        
        if(num > 7 ){
            Advertencia.setText("No se pueden ingresar mas de 7 turistas");
        }else{
            Advertencia.setText("");
        }
        
        if(num>1){
            LabelViajeros.setText("Viajeros");
            BotonRestar.setEnabled(true);
        }
           
    }//GEN-LAST:event_BotonSumarActionPerformed

    private void BotonEstablecerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonEstablecerActionPerformed
        int resultado = JOptionPane.showConfirmDialog(this, "¿Seguro de la eleccion? Este proceso no se podra cambiar.");
        if(resultado == JOptionPane.YES_OPTION){
            FieldNombre.setEnabled(true);
            FieldApellido.setEnabled(true);
            FieldDni.setEnabled(true);
            FieldEdad.setEnabled(true);
            FieldEmail.setEnabled(true);
            FieldTelefono.setEnabled(true);
            BotonSalir.setEnabled(true);
            BotonGuardar.setEnabled(true);
            BotonEstablecer.setEnabled(false);
            BotonRestar.setEnabled(false);
            BotonSumar.setEnabled(false);
        }
    }//GEN-LAST:event_BotonEstablecerActionPerformed

    private void FieldNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FieldNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FieldNombreActionPerformed

    private void BotonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonGuardarActionPerformed
        int contador = Integer.parseInt(Contador.getText());
        int num = Integer.parseInt(Numero.getText());
        
        if(!checked()){
        Turista t = new Turista(Integer.parseInt(FieldDni.getText()),FieldNombre.getText(),FieldApellido.getText(),Integer.parseInt(FieldEdad.getText()), Long.parseLong(FieldTelefono.getText()), FieldEmail.getText());
        guardarTurista.add(t);
        JOptionPane.showMessageDialog(this, "El Turista fue agregado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        contador++;
        Contador.setText(String.valueOf(contador));
        vaciarCampos();      
        }else{
            JOptionPane.showMessageDialog(this, "Complete los campos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
        
        if(contador > num){
            BotonGuardar.setEnabled(false);
            BotonSiguiente.setEnabled(true);
        }
    }//GEN-LAST:event_BotonGuardarActionPerformed

    private void FieldDniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FieldDniKeyTyped
       char dni = evt.getKeyChar();
        if (!Character.isDigit(dni)) {
            evt.consume();
        }   
    }//GEN-LAST:event_FieldDniKeyTyped

    private void FieldEdadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FieldEdadKeyTyped
        char edad = evt.getKeyChar();
        if (!Character.isDigit(edad)) {
            evt.consume();
        }   
    }//GEN-LAST:event_FieldEdadKeyTyped

    private void FieldTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FieldTelefonoKeyTyped
        char telefono = evt.getKeyChar();
        if (!Character.isDigit(telefono)) {
            evt.consume();
        }   
    }//GEN-LAST:event_FieldTelefonoKeyTyped

    private void FieldEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FieldEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FieldEmailActionPerformed

    private void BotonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonSalirActionPerformed
        int resultado = JOptionPane.showConfirmDialog(this,"Si sales, se borrará toda la información ingresada. ¿Deseas continuar?", "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if(resultado == JOptionPane.YES_OPTION){
            this.dispose();
        }

    }//GEN-LAST:event_BotonSalirActionPerformed

    public boolean checked(){
        String email = FieldEmail.getText();
        String expresion = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return (FieldNombre.getText().isEmpty() || FieldApellido.getText().isEmpty() || FieldDni.getText().isEmpty() || (FieldEmail.getText().isEmpty() || !email.matches(expresion)) || FieldEdad.getText().isEmpty() || FieldTelefono.getText().isEmpty());
    }
    
    public void vaciarCampos(){
        FieldNombre.setText("");
        FieldApellido.setText("");
        FieldDni.setText("");
        FieldEmail.setText("");
        FieldEdad.setText("");
        FieldTelefono.setText("");
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Advertencia;
    private javax.swing.JButton BotonEstablecer;
    private javax.swing.JButton BotonGuardar;
    private javax.swing.JButton BotonRestar;
    private javax.swing.JButton BotonSalir;
    private javax.swing.JButton BotonSiguiente;
    private javax.swing.JButton BotonSumar;
    private javax.swing.JLabel Contador;
    private javax.swing.JTextField FieldApellido;
    private javax.swing.JTextField FieldDni;
    private javax.swing.JTextField FieldEdad;
    private javax.swing.JTextField FieldEmail;
    private javax.swing.JTextField FieldNombre;
    private javax.swing.JTextField FieldTelefono;
    private javax.swing.JLabel LabelViajeros;
    private javax.swing.JLabel Numero;
    private javax.swing.JPanel PanelAlojamiento;
    private javax.swing.JPanel PanelPasaje;
    private javax.swing.JPanel PanelPrincipal;
    private javax.swing.JPanel PanelTurista;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    // End of variables declaration//GEN-END:variables
}
