/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import com.toedter.calendar.JTextFieldDateEditor;
import entidad.Alojamiento;
import entidad.Ciudad;
import entidad.Turista;
import java.awt.CardLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.table.DefaultTableModel;
import persistencia.AlojamientoData;
import persistencia.CiudadData;
import persistencia.TuristaData;

/**
 *
 * @author Mila
 */
public class VistaCrearPaquete extends javax.swing.JInternalFrame {

    private final ArrayList<Turista> guardarTurista = new ArrayList<>();
    String[] columnNames = {"Ciudad", "Nombre", "Tipo", "Precio", "Capacidad", "Estado"};
    DefaultTableModel model = new DefaultTableModel(columnNames, 0);
    private double precioPasaje;
    private double presupuestoBase;
    private double presupuestoFinal;

    public VistaCrearPaquete() {
        initComponents();
        cargarCiudad();
        ComboOrigen.addActionListener(e -> actualizarPrecio());
        ComboDestino.addActionListener(e -> actualizarPrecio());
        ComboAsiento.addActionListener(e -> actualizarPrecio());

        RadioAvion.addActionListener(e -> actualizarPrecio());
        RadioColectivo.addActionListener(e -> actualizarPrecio());
        RadioBarco.addActionListener(e -> actualizarPrecio());

        RadioSinPension.addActionListener(e -> actualizarPresupuesto());
        RadioDesayuno.addActionListener(e -> actualizarPresupuesto());
        RadioMediaPension.addActionListener(e -> actualizarPresupuesto());
        RadioPensionCompleta.addActionListener(e -> actualizarPresupuesto());

        RadioSi.addActionListener(e -> actualizarPresupuesto());
        RadioNo.addActionListener(e -> actualizarPresupuesto());

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GrupoTransporte = new javax.swing.ButtonGroup();
        GrupoMenu = new javax.swing.ButtonGroup();
        GrupoTraslados = new javax.swing.ButtonGroup();
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
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        PanelPasaje = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        ComboOrigen = new javax.swing.JComboBox<>();
        ComboDestino = new javax.swing.JComboBox<>();
        Calendario2 = new com.toedter.calendar.JDateChooser();
        Calendario = new com.toedter.calendar.JDateChooser();
        RadioAvion = new javax.swing.JRadioButton();
        RadioColectivo = new javax.swing.JRadioButton();
        RadioBarco = new javax.swing.JRadioButton();
        jButton5 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        BotonSalir1 = new javax.swing.JButton();
        jSpinner1 = new javax.swing.JSpinner();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        ComboAsiento = new javax.swing.JComboBox<>();
        LabelAsiento = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        LabelPrecio = new javax.swing.JLabel();
        PanelAlojamiento = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        ComboAlojamiento = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaAlojamiento = new javax.swing.JTable();
        jLabel35 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        RadioSi = new javax.swing.JRadioButton();
        RadioNo = new javax.swing.JRadioButton();
        RadioPensionCompleta = new javax.swing.JRadioButton();
        jLabel38 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        RadioMediaPension = new javax.swing.JRadioButton();
        RadioDesayuno = new javax.swing.JRadioButton();
        jLabel40 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        RadioSinPension = new javax.swing.JRadioButton();
        jLabel37 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        Label89 = new javax.swing.JLabel();
        LabelAlojamiento = new javax.swing.JLabel();
        PanelFinal = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();

        setClosable(true);

        PanelPrincipal.setLayout(new java.awt.CardLayout());

        ImageIcon imagen = new ImageIcon(getClass().getResource("/imagenes/icono2.jpg"));
        Image miImagen = imagen.getImage();
        PanelTurista = new javax.swing.JPanel(){
            public void paintComponent(Graphics g){
                g.drawImage(miImagen, 0, 0, getWidth(), getHeight(), this);
            }
        };
        PanelTurista.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Turista ");
        PanelTurista.add(jLabel2);
        jLabel2.setBounds(61, 98, 87, 32);

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("DNI");
        PanelTurista.add(jLabel3);
        jLabel3.setBounds(61, 288, 56, 26);

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Nombre");
        jLabel4.setToolTipText("");
        PanelTurista.add(jLabel4);
        jLabel4.setBounds(60, 200, 86, 26);

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Apellido");
        PanelTurista.add(jLabel5);
        jLabel5.setBounds(420, 200, 79, 26);

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Mail");
        PanelTurista.add(jLabel6);
        jLabel6.setBounds(420, 290, 45, 26);

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Edad");
        PanelTurista.add(jLabel7);
        jLabel7.setBounds(61, 382, 50, 26);

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Telefono");
        PanelTurista.add(jLabel8);
        jLabel8.setBounds(420, 380, 97, 26);

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
        FieldApellido.setBounds(420, 240, 200, 30);

        FieldEmail.setToolTipText("Ingrese el correo en formato: turista@dominio.com");
        FieldEmail.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        FieldEmail.setEnabled(false);
        FieldEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FieldEmailActionPerformed(evt);
            }
        });
        PanelTurista.add(FieldEmail);
        FieldEmail.setBounds(420, 330, 200, 32);

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
        FieldEdad.setBounds(60, 420, 60, 32);

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
        FieldTelefono.setBounds(420, 420, 200, 32);

        BotonSalir.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        BotonSalir.setText("Salir");
        BotonSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonSalir.setEnabled(false);
        BotonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonSalirActionPerformed(evt);
            }
        });
        PanelTurista.add(BotonSalir);
        BotonSalir.setBounds(60, 510, 150, 46);

        BotonSiguiente.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        BotonSiguiente.setText("Siguiente");
        BotonSiguiente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonSiguiente.setEnabled(false);
        BotonSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonSiguienteActionPerformed(evt);
            }
        });
        PanelTurista.add(BotonSiguiente);
        BotonSiguiente.setBounds(480, 510, 150, 47);

        jLabel15.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("¿Cuantos viajan?");
        PanelTurista.add(jLabel15);
        jLabel15.setBounds(370, 80, 173, 42);

        LabelViajeros.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        LabelViajeros.setForeground(new java.awt.Color(255, 255, 255));
        LabelViajeros.setText("Viajero");
        PanelTurista.add(LabelViajeros);
        LabelViajeros.setBounds(280, 130, 80, 40);

        Numero.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        Numero.setForeground(new java.awt.Color(255, 255, 255));
        Numero.setText("1");
        PanelTurista.add(Numero);
        Numero.setBounds(420, 140, 20, 24);

        BotonSumar.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        BotonSumar.setText("+");
        BotonSumar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonSumar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonSumarActionPerformed(evt);
            }
        });
        PanelTurista.add(BotonSumar);
        BotonSumar.setBounds(440, 130, 41, 29);

        BotonRestar.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        BotonRestar.setText("-");
        BotonRestar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonRestar.setEnabled(false);
        BotonRestar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonRestarActionPerformed(evt);
            }
        });
        PanelTurista.add(BotonRestar);
        BotonRestar.setBounds(370, 130, 37, 29);

        Advertencia.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        Advertencia.setForeground(new java.awt.Color(255, 51, 51));
        PanelTurista.add(Advertencia);
        Advertencia.setBounds(250, 180, 340, 17);

        BotonEstablecer.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        BotonEstablecer.setText("Establecer");
        BotonEstablecer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonEstablecer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonEstablecerActionPerformed(evt);
            }
        });
        PanelTurista.add(BotonEstablecer);
        BotonEstablecer.setBounds(500, 130, 120, 37);

        BotonGuardar.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        BotonGuardar.setText("Guardar");
        BotonGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonGuardar.setEnabled(false);
        BotonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonGuardarActionPerformed(evt);
            }
        });
        PanelTurista.add(BotonGuardar);
        BotonGuardar.setBounds(270, 510, 150, 47);

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

        jLabel27.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Campos Obligatorios");
        PanelTurista.add(jLabel27);
        jLabel27.setBounds(70, 470, 160, 40);

        jLabel28.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 0));
        jLabel28.setText("*");
        PanelTurista.add(jLabel28);
        jLabel28.setBounds(500, 200, 30, 30);

        jLabel29.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 0));
        jLabel29.setText("*");
        PanelTurista.add(jLabel29);
        jLabel29.setBounds(50, 480, 30, 30);

        jLabel30.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 0));
        jLabel30.setText("*");
        PanelTurista.add(jLabel30);
        jLabel30.setBounds(140, 200, 30, 30);

        jLabel31.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 0));
        jLabel31.setText("*");
        PanelTurista.add(jLabel31);
        jLabel31.setBounds(100, 290, 30, 30);

        jLabel32.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 0, 0));
        jLabel32.setText("*");
        PanelTurista.add(jLabel32);
        jLabel32.setBounds(100, 290, 30, 30);

        jLabel33.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 0));
        jLabel33.setText("*");
        PanelTurista.add(jLabel33);
        jLabel33.setBounds(110, 380, 30, 30);

        PanelPrincipal.add(PanelTurista, "PanelTurista");

        PanelPasaje = new javax.swing.JPanel(){
            public void paintComponent(Graphics g){
                g.drawImage(miImagen, 0, 0, getWidth(), getHeight(), this);
            }
        };
        PanelPasaje.setName(""); // NOI18N
        PanelPasaje.setLayout(null);

        jLabel9.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Pasaje");
        PanelPasaje.add(jLabel9);
        jLabel9.setBounds(300, 0, 84, 49);

        jLabel10.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Ciudad Origen:");
        PanelPasaje.add(jLabel10);
        jLabel10.setBounds(30, 70, 132, 22);

        jLabel11.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Ciudad Destino:");
        PanelPasaje.add(jLabel11);
        jLabel11.setBounds(360, 70, 140, 22);

        jLabel12.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Fecha Check-in:");
        PanelPasaje.add(jLabel12);
        jLabel12.setBounds(30, 122, 142, 30);

        jLabel13.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Fecha Check-out:");
        PanelPasaje.add(jLabel13);
        jLabel13.setBounds(360, 122, 154, 30);

        jLabel14.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Transporte ");
        PanelPasaje.add(jLabel14);
        jLabel14.setBounds(290, 230, 120, 24);

        DefaultComboBoxModel<Ciudad> modeloOrigen = new DefaultComboBoxModel<>();
        ComboOrigen.setModel(modeloOrigen);
        ComboOrigen.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ComboOrigenItemStateChanged(evt);
            }
        });
        ComboOrigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboOrigenActionPerformed(evt);
            }
        });
        ComboOrigen.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                ComboOrigenPropertyChange(evt);
            }
        });
        PanelPasaje.add(ComboOrigen);
        ComboOrigen.setBounds(170, 70, 170, 20);

        DefaultComboBoxModel<Ciudad> modeloDestino = new DefaultComboBoxModel<>();
        ComboDestino.setModel(modeloDestino);
        ComboDestino.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ComboDestinoItemStateChanged(evt);
            }
        });
        ComboDestino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboDestinoActionPerformed(evt);
            }
        });
        PanelPasaje.add(ComboDestino);
        ComboDestino.setBounds(510, 70, 160, 20);

        Calendario2.setEnabled(false);
        Calendario.addPropertyChangeListener("date", new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if (Calendario.getDate() != null) {
                    Calendario2.setEnabled(true);
                }

                Date selectedDate = Calendario.getDate();

                if (selectedDate != null) {
                    Calendar cal2 = Calendar.getInstance();
                    cal2.setTime(selectedDate);
                    cal2.add(Calendar.DAY_OF_MONTH, 5); // Añadir un día

                    // Habilitar solo fechas a partir del día siguiente en el segundo calendario
                    Calendario2.setMinSelectableDate(cal2.getTime());
                }

            }
        });

        JTextFieldDateEditor editor1 = (JTextFieldDateEditor) Calendario.getDateEditor();
        editor1.setEditable(false);
        Calendario2.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                Calendario2AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        PanelPasaje.add(Calendario2);
        Calendario2.setBounds(520, 120, 150, 20);

        Date fechaActual = new Date();
        Calendario.setMinSelectableDate(fechaActual);

        JTextFieldDateEditor editor = (JTextFieldDateEditor) Calendario.getDateEditor();
        editor.setEditable(false);
        Calendario.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                CalendarioAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        Calendario.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                CalendarioPropertyChange(evt);
            }
        });
        PanelPasaje.add(Calendario);
        Calendario.setBounds(180, 120, 160, 20);

        GrupoTransporte.add(RadioAvion);
        RadioAvion.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        RadioAvion.setForeground(new java.awt.Color(255, 255, 255));
        RadioAvion.setText("Avion");
        PanelPasaje.add(RadioAvion);
        RadioAvion.setBounds(100, 390, 90, 25);

        GrupoTransporte.add(RadioColectivo);
        RadioColectivo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        RadioColectivo.setForeground(new java.awt.Color(255, 255, 255));
        RadioColectivo.setText("Colectivo");
        PanelPasaje.add(RadioColectivo);
        RadioColectivo.setBounds(290, 390, 110, 25);

        GrupoTransporte.add(RadioBarco);
        RadioBarco.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        RadioBarco.setForeground(new java.awt.Color(255, 255, 255));
        RadioBarco.setText("Barco");
        PanelPasaje.add(RadioBarco);
        RadioBarco.setBounds(500, 390, 80, 25);

        jButton5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButton5.setText("Continuar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        PanelPasaje.add(jButton5);
        jButton5.setBounds(490, 510, 140, 33);

        jLabel17.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Costo actual por Persona:");
        PanelPasaje.add(jLabel17);
        jLabel17.setBounds(40, 460, 230, 40);

        jLabel80.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel80.setForeground(new java.awt.Color(51, 204, 0));
        jLabel80.setText("$");
        PanelPasaje.add(jLabel80);
        jLabel80.setBounds(270, 470, 10, 20);

        ImageIcon barco = new ImageIcon(getClass().getResource("/imagenes/barco.png"));
        Image miImagen1 = barco.getImage();
        jLabel19 = new javax.swing.JLabel(){
            public void paintComponent(Graphics g){
                g.drawImage(miImagen1, 0, 0, getWidth(), getHeight(), this);
            }
        };
        jLabel19.setBackground(new java.awt.Color(255, 255, 255));
        jLabel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel19MouseClicked(evt);
            }
        });
        PanelPasaje.add(jLabel19);
        jLabel19.setBounds(490, 280, 90, 90);

        ImageIcon avion = new ImageIcon(getClass().getResource("/imagenes/plano.png"));
        Image miImagen2 = avion.getImage();
        jLabel20 = new javax.swing.JLabel(){
            public void paintComponent(Graphics g){
                g.drawImage(miImagen2, 0, 0, getWidth(), getHeight(), this);
            }
        };
        jLabel20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel20MouseClicked(evt);
            }
        });
        PanelPasaje.add(jLabel20);
        jLabel20.setBounds(100, 280, 90, 90);

        ImageIcon autobus = new ImageIcon(getClass().getResource("/imagenes/autobus-alternativo.png"));
        Image miImagen3 = autobus.getImage();
        jLabel21 = new javax.swing.JLabel(){
            public void paintComponent(Graphics g){
                g.drawImage(miImagen3, 0, 0, getWidth(), getHeight(), this);
            }
        };
        jLabel21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel21MouseClicked(evt);
            }
        });
        PanelPasaje.add(jLabel21);
        jLabel21.setBounds(300, 280, 90, 90);

        BotonSalir1.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        BotonSalir1.setText("Salir");
        BotonSalir1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonSalir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonSalir1ActionPerformed(evt);
            }
        });
        PanelPasaje.add(BotonSalir1);
        BotonSalir1.setBounds(30, 510, 150, 40);

        SpinnerDateModel model = new SpinnerDateModel();
        jSpinner1.setModel(model);
        JSpinner.DateEditor editor4 = new JSpinner.DateEditor(jSpinner1, "HH:mm");
        jSpinner1.setEditor(editor4);
        JFormattedTextField Horas = ((JSpinner.DefaultEditor) jSpinner1.getEditor()).getTextField();
        Horas.setEditable(false);
        PanelPasaje.add(jSpinner1);
        jSpinner1.setBounds(180, 170, 70, 30);

        jLabel22.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Hora de Salida:");
        PanelPasaje.add(jLabel22);
        jLabel22.setBounds(30, 170, 140, 30);

        jLabel23.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Asiento:");
        PanelPasaje.add(jLabel23);
        jLabel23.setBounds(360, 170, 80, 30);

        ComboAsiento.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        ComboAsiento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione Asiento", "Estandar", "Premium" }));
        ComboAsiento.setToolTipText("Con el asiento premium, disfruta de asientos de mayor calidad, mejores vistas y la posibilidad de personalizar tu comida a tu gusto para una experiencia de viaje más cómoda y placentera.");
        ComboAsiento.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ComboAsientoItemStateChanged(evt);
            }
        });
        ComboAsiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboAsientoActionPerformed(evt);
            }
        });
        PanelPasaje.add(ComboAsiento);
        ComboAsiento.setBounds(460, 170, 210, 30);

        LabelAsiento.setForeground(new java.awt.Color(255, 255, 255));
        PanelPasaje.add(LabelAsiento);
        LabelAsiento.setBounds(420, 200, 230, 20);

        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Añade 5% al Costo Actual");
        PanelPasaje.add(jLabel24);
        jLabel24.setBounds(480, 420, 150, 14);

        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Añade 7% al Costo Actual");
        PanelPasaje.add(jLabel25);
        jLabel25.setBounds(70, 420, 150, 14);

        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Añade 3% al Costo Actual");
        PanelPasaje.add(jLabel26);
        jLabel26.setBounds(280, 420, 150, 14);
        PanelPasaje.add(jSeparator2);
        jSeparator2.setBounds(20, 220, 650, 10);

        LabelPrecio.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        LabelPrecio.setForeground(new java.awt.Color(51, 204, 0));
        PanelPasaje.add(LabelPrecio);
        LabelPrecio.setBounds(280, 470, 100, 20);

        PanelPrincipal.add(PanelPasaje, "PanelPasaje");

        PanelAlojamiento = new javax.swing.JPanel(){
            public void paintComponent(Graphics g){
                g.drawImage(miImagen, 0, 0, getWidth(), getHeight(), this);
            }
        };
        PanelAlojamiento.setLayout(null);

        jLabel16.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Alojamiento");
        PanelAlojamiento.add(jLabel16);
        jLabel16.setBounds(270, 0, 140, 38);

        jLabel34.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("Elija el tipo de alojamiento:");
        PanelAlojamiento.add(jLabel34);
        jLabel34.setBounds(20, 40, 240, 50);

        ComboAlojamiento.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        ComboAlojamiento.setForeground(new java.awt.Color(255, 255, 255));
        ComboAlojamiento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione Alojamiento", "Hotel", "Hostel", "Cabaña" }));
        ComboAlojamiento.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ComboAlojamientoItemStateChanged(evt);
            }
        });
        ComboAlojamiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboAlojamientoActionPerformed(evt);
            }
        });
        PanelAlojamiento.add(ComboAlojamiento);
        ComboAlojamiento.setBounds(260, 50, 210, 30);

        TablaAlojamiento.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        TablaAlojamiento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ciudad", "Nombre", "Tipo", "Precio por Noche", "Cantidad", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TablaAlojamiento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaAlojamientoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablaAlojamiento);

        PanelAlojamiento.add(jScrollPane1);
        jScrollPane1.setBounds(20, 140, 650, 130);

        jLabel35.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText("Seleccione algun Alojamiento");
        PanelAlojamiento.add(jLabel35);
        jLabel35.setBounds(20, 110, 210, 20);
        PanelAlojamiento.add(jSeparator1);
        jSeparator1.setBounds(20, 90, 650, 20);

        jButton1.setText("Presupuestar");
        PanelAlojamiento.add(jButton1);
        jButton1.setBounds(550, 540, 120, 40);

        jButton3.setText("Volver");
        PanelAlojamiento.add(jButton3);
        jButton3.setBounds(30, 540, 100, 40);

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setLayout(null);

        jLabel42.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel42.setText("¿Traslados hacia el hotel?");
        jPanel2.add(jLabel42);
        jLabel42.setBounds(10, 170, 190, 30);

        RadioSi.setBackground(new java.awt.Color(204, 204, 204));
        GrupoTraslados.add(RadioSi);
        RadioSi.setText("Si");
        jPanel2.add(RadioSi);
        RadioSi.setBounds(200, 170, 33, 30);

        RadioNo.setBackground(new java.awt.Color(204, 204, 204));
        GrupoTraslados.add(RadioNo);
        RadioNo.setText("No");
        jPanel2.add(RadioNo);
        RadioNo.setBounds(250, 170, 50, 30);

        RadioPensionCompleta.setBackground(new java.awt.Color(204, 204, 204));
        GrupoMenu.add(RadioPensionCompleta);
        RadioPensionCompleta.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        RadioPensionCompleta.setText("Pension Completa");
        jPanel2.add(RadioPensionCompleta);
        RadioPensionCompleta.setBounds(120, 130, 160, 27);

        jLabel38.setForeground(new java.awt.Color(102, 102, 102));
        jLabel38.setText("(Incluye Todas las Comidas) +8% al presupuesto");
        jPanel2.add(jLabel38);
        jLabel38.setBounds(280, 130, 280, 30);

        jLabel41.setForeground(new java.awt.Color(102, 102, 102));
        jLabel41.setText("(Incluye Desayuno y Cena) +5% al presupuesto");
        jPanel2.add(jLabel41);
        jLabel41.setBounds(260, 100, 270, 30);

        RadioMediaPension.setBackground(new java.awt.Color(204, 204, 204));
        GrupoMenu.add(RadioMediaPension);
        RadioMediaPension.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        RadioMediaPension.setText("Media Pension");
        jPanel2.add(RadioMediaPension);
        RadioMediaPension.setBounds(120, 100, 140, 27);

        RadioDesayuno.setBackground(new java.awt.Color(204, 204, 204));
        GrupoMenu.add(RadioDesayuno);
        RadioDesayuno.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        RadioDesayuno.setText("Desayuno Incluido");
        RadioDesayuno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RadioDesayunoActionPerformed(evt);
            }
        });
        jPanel2.add(RadioDesayuno);
        RadioDesayuno.setBounds(120, 70, 155, 27);

        jLabel40.setForeground(new java.awt.Color(102, 102, 102));
        jLabel40.setText("(Incluye Desayuno solamente) +2% al presupuesto");
        jPanel2.add(jLabel40);
        jLabel40.setBounds(280, 70, 290, 30);

        jLabel39.setForeground(new java.awt.Color(102, 102, 102));
        jLabel39.setText("(No incluye comidas)");
        jPanel2.add(jLabel39);
        jLabel39.setBounds(240, 40, 120, 30);

        RadioSinPension.setBackground(new java.awt.Color(204, 204, 204));
        GrupoMenu.add(RadioSinPension);
        RadioSinPension.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        RadioSinPension.setText("Sin Pension");
        jPanel2.add(RadioSinPension);
        RadioSinPension.setBounds(120, 40, 120, 27);

        jLabel37.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel37.setText("Tipos de menu:");
        jPanel2.add(jLabel37);
        jLabel37.setBounds(10, 70, 110, 50);

        jLabel36.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel36.setText("Menu");
        jPanel2.add(jLabel36);
        jLabel36.setBounds(280, 0, 70, 32);

        jLabel18.setForeground(new java.awt.Color(102, 102, 102));
        jLabel18.setText("+1% al presupuesto");
        jPanel2.add(jLabel18);
        jLabel18.setBounds(300, 170, 130, 30);

        PanelAlojamiento.add(jPanel2);
        jPanel2.setBounds(20, 280, 650, 210);

        jLabel43.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setText("Costo Actual:");
        PanelAlojamiento.add(jLabel43);
        jLabel43.setBounds(20, 500, 120, 30);

        Label89.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        Label89.setForeground(new java.awt.Color(51, 204, 0));
        Label89.setText("$");
        PanelAlojamiento.add(Label89);
        Label89.setBounds(140, 500, 10, 30);

        LabelAlojamiento.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        LabelAlojamiento.setForeground(new java.awt.Color(51, 204, 0));
        PanelAlojamiento.add(LabelAlojamiento);
        LabelAlojamiento.setBounds(150, 500, 100, 30);

        PanelPrincipal.add(PanelAlojamiento, "PanelAlojamiento");

        jLabel45.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setText("Paquete");

        javax.swing.GroupLayout PanelFinalLayout = new javax.swing.GroupLayout(PanelFinal);
        PanelFinal.setLayout(PanelFinalLayout);
        PanelFinalLayout.setHorizontalGroup(
            PanelFinalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelFinalLayout.createSequentialGroup()
                .addGap(285, 285, 285)
                .addComponent(jLabel45)
                .addContainerGap(307, Short.MAX_VALUE))
        );
        PanelFinalLayout.setVerticalGroup(
            PanelFinalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelFinalLayout.createSequentialGroup()
                .addComponent(jLabel45)
                .addGap(0, 556, Short.MAX_VALUE))
        );

        PanelPrincipal.add(PanelFinal, "card5");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        TuristaData td = new TuristaData();
        for (Turista aux : guardarTurista) {
            td.cargarTurista(aux);
        }
        
        CardLayout cardLayout = (CardLayout) PanelPrincipal.getLayout();
        cardLayout.show(PanelPrincipal, "PanelPasaje");
        PanelPrincipal.validate();
        PanelPrincipal.repaint();
    }//GEN-LAST:event_BotonSiguienteActionPerformed

    private void ComboOrigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboOrigenActionPerformed

    }//GEN-LAST:event_ComboOrigenActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        Ciudad origen = (Ciudad) ComboOrigen.getSelectedItem();
        Ciudad destino = (Ciudad) ComboDestino.getSelectedItem();

        if (!checkeoPasaje()) {

            if (!origen.getContinente().equals(destino.getContinente()) && RadioColectivo.isSelected()) {

                JOptionPane.showMessageDialog(this, "Si viaja a otro continente no puede ir en colectivo.", "Advertencia", JOptionPane.WARNING_MESSAGE);

            } else {

                int respuesta = JOptionPane.showConfirmDialog(null, "¿Desea continuar?. No podrá cambiar los datos una vez confirmado.", "Confirmación", JOptionPane.YES_NO_OPTION);

                if (respuesta == JOptionPane.YES_OPTION) {
                    CardLayout cardLayout = (CardLayout) PanelPrincipal.getLayout();
                    cardLayout.show(PanelPrincipal, "PanelAlojamiento");
                    PanelPrincipal.validate();
                    PanelPrincipal.repaint();
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Complete los campos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void FieldTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FieldTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FieldTelefonoActionPerformed

    private void BotonRestarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonRestarActionPerformed

        int num = Integer.parseInt(Numero.getText());
        num--;

        if (num < 1 || num == 1) {
            BotonRestar.setEnabled(false);
            Numero.setText(String.valueOf(num));
        } else {
            BotonRestar.setEnabled(true);
            Numero.setText(String.valueOf(num));
            Advertencia.setText("");
        }

        if (num == 1) {
            LabelViajeros.setText("Viajero");
        }
    }//GEN-LAST:event_BotonRestarActionPerformed

    private void BotonSumarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonSumarActionPerformed
        int num = Integer.parseInt(Numero.getText());
        num++;
        if (num <= 7) {
            Numero.setText(String.valueOf(num));
        }

        if (num > 7) {
            Advertencia.setText("No se pueden ingresar mas de 7 turistas");
        } else {
            Advertencia.setText("");
        }

        if (num > 1) {
            LabelViajeros.setText("Viajeros");
            BotonRestar.setEnabled(true);
        }

    }//GEN-LAST:event_BotonSumarActionPerformed

    private void BotonEstablecerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonEstablecerActionPerformed
        int resultado = JOptionPane.showConfirmDialog(this, "¿Seguro de la eleccion? Este proceso no se podra cambiar.");
        if (resultado == JOptionPane.YES_OPTION) {
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
        try{
            int contador = Integer.parseInt(Contador.getText());
        int num = Integer.parseInt(Numero.getText());

        if (!checkeoTurista()) {
            String email = FieldEmail.getText().isEmpty() ? null : FieldEmail.getText();
            Long telefono = FieldTelefono.getText().isEmpty() ? null : Long.parseLong(FieldTelefono.getText());

            Turista t = new Turista(Integer.parseInt(FieldDni.getText()), FieldNombre.getText(), FieldApellido.getText(), Integer.parseInt(FieldEdad.getText()), telefono, email);
            guardarTurista.add(t);
            JOptionPane.showMessageDialog(this, "El Turista fue agregado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            contador++;
            Contador.setText(String.valueOf(contador));
            vaciarCamposTurista();
        }

        if (contador > num) {
            BotonGuardar.setEnabled(false);
            BotonSiguiente.setEnabled(true);
        }
        } catch (NumberFormatException w) {
            JOptionPane.showMessageDialog(this, "Ingrese datos Válidos", "Error", JOptionPane.ERROR_MESSAGE);
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
        int resultado = JOptionPane.showConfirmDialog(this, "Si sales, se borrará toda la información ingresada. ¿Deseas continuar?", "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (resultado == JOptionPane.YES_OPTION) {
            this.dispose();
        }

    }//GEN-LAST:event_BotonSalirActionPerformed

    private void jLabel20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseClicked
        RadioAvion.setSelected(true);
        actualizarPrecio();
    }//GEN-LAST:event_jLabel20MouseClicked

    private void jLabel21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseClicked
        Ciudad origen = (Ciudad) ComboOrigen.getSelectedItem();
        Ciudad destino = (Ciudad) ComboDestino.getSelectedItem();

        if (origen.getContinente().equals(destino.getContinente())) {
            RadioColectivo.setSelected(true);
            actualizarPrecio();
        }

    }//GEN-LAST:event_jLabel21MouseClicked

    private void jLabel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseClicked
        RadioBarco.setSelected(true);
        actualizarPrecio();
    }//GEN-LAST:event_jLabel19MouseClicked

    private void CalendarioPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_CalendarioPropertyChange

    }//GEN-LAST:event_CalendarioPropertyChange

    private void Calendario2AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_Calendario2AncestorAdded

    }//GEN-LAST:event_Calendario2AncestorAdded

    private void CalendarioAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_CalendarioAncestorAdded

    }//GEN-LAST:event_CalendarioAncestorAdded

    private void BotonSalir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonSalir1ActionPerformed
        int resultado = JOptionPane.showConfirmDialog(this, "Si sales, se borrará toda la información ingresada. ¿Deseas continuar?", "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (resultado == JOptionPane.YES_OPTION) {
            this.dispose();
        }

    }//GEN-LAST:event_BotonSalir1ActionPerformed

    private void ComboAsientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboAsientoActionPerformed
        if (ComboAsiento.getSelectedItem().equals("Premium")) {
            LabelAsiento.setText("Esta opcion añade un 3% al Costo Actual.");
        }

        if (ComboAsiento.getSelectedItem().equals("Estandar")) {
            LabelAsiento.setText("");
        }

    }//GEN-LAST:event_ComboAsientoActionPerformed

    private void ComboOrigenPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_ComboOrigenPropertyChange

    }//GEN-LAST:event_ComboOrigenPropertyChange

    private void ComboOrigenItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ComboOrigenItemStateChanged

    }//GEN-LAST:event_ComboOrigenItemStateChanged

    private void ComboDestinoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ComboDestinoItemStateChanged

    }//GEN-LAST:event_ComboDestinoItemStateChanged

    private void ComboAsientoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ComboAsientoItemStateChanged
        ComboAsiento.removeItem("Seleccione Asiento");

    }//GEN-LAST:event_ComboAsientoItemStateChanged

    private void ComboAlojamientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboAlojamientoActionPerformed
        
        DefaultTableModel alomodel = (DefaultTableModel) TablaAlojamiento.getModel();
        alomodel.setRowCount(0);
        AlojamientoData ad = new AlojamientoData();
        
        String select =(String)ComboAlojamiento.getSelectedItem();
        Ciudad city = (Ciudad)ComboDestino.getSelectedItem();
        
        List<Alojamiento> alojamientos = ad.listarAlojamientosXCiudadYTipo(city.getNombre(), select);
        
        for (Alojamiento aux : alojamientos) {
            alomodel.addRow(new Object[]{
                aux.getNbreCiudad(),
                aux.getNombre(),
                aux.getTipo(),
                aux.getPrecioNoche(),
                aux.getCapacidad(),
                aux.getEstado()
                
            });
        }
        
        
    }//GEN-LAST:event_ComboAlojamientoActionPerformed

    private void RadioDesayunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioDesayunoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RadioDesayunoActionPerformed

    private void ComboDestinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboDestinoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboDestinoActionPerformed

    private void ComboAlojamientoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ComboAlojamientoItemStateChanged
        ComboAlojamiento.removeItem("Seleccione Alojamiento");
    }//GEN-LAST:event_ComboAlojamientoItemStateChanged

    private void TablaAlojamientoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaAlojamientoMouseClicked
        int fila = TablaAlojamiento.getSelectedRow();

    if (fila != -1) {
        Object valorCelda = TablaAlojamiento.getValueAt(fila, 4);

        // Verificar si el valor no es nulo y es un número (double)
        if (valorCelda != null && valorCelda instanceof Number) {
            double precioPorNoche = ((Number) valorCelda).doubleValue();  
            actualizarPresupuestoConAlojamiento(precioPorNoche);
        } else {
            JOptionPane.showMessageDialog(this, "El precio por noche no es válido", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    }//GEN-LAST:event_TablaAlojamientoMouseClicked

    public boolean checkeoTurista() {
        String email = FieldEmail.getText();
        String telefono = FieldTelefono.getText();
        String expresion = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        String expresionTelefono = "^[0-9]{10,15}$";

        if (FieldNombre.getText().isEmpty() || FieldApellido.getText().isEmpty() || FieldDni.getText().isEmpty() || FieldEdad.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Todos los campos obligatorios deben ser completos.", "Error", JOptionPane.ERROR_MESSAGE);
            return true;
        }

        if (!email.isEmpty() && !email.matches(expresion)) {
            JOptionPane.showMessageDialog(null, "El formato del correo electrónico no es válido.", "Error", JOptionPane.ERROR_MESSAGE);
            return true;
        }
        if (!telefono.isEmpty() && !telefono.matches(expresionTelefono)) {
            JOptionPane.showMessageDialog(null, "El teléfono debe tener al menos 10 digitos.", "Error", JOptionPane.ERROR_MESSAGE);
            return true;
        }

        return false;
    }

    public void vaciarCamposTurista() {
        FieldNombre.setText("");
        FieldApellido.setText("");
        FieldDni.setText("");
        FieldEmail.setText("");
        FieldEdad.setText("");
        FieldTelefono.setText("");
    }

    public boolean checkeoPasaje() {

        return (ComboOrigen.getSelectedItem().equals("Seleccione Ciudad") || ComboDestino.getSelectedItem().equals("Seleccione Ciudad") || (Calendario.getDate() == null) || (Calendario2.getDate() == null) || ComboAsiento.getSelectedItem().equals("Seleccione Asiento") || (GrupoTransporte.getSelection() == null));
    }

    public void cargarCiudad() {

        CiudadData c = new CiudadData();

        List<Ciudad> ciudad = c.listarCiudades();

        //Ciudad seleccion = new Ciudad();
        //ComboOrigen.addItem(seleccion);
        //ComboDestino.addItem(seleccion);
        for (Ciudad c1 : ciudad) {

            ComboOrigen.addItem(c1);
            ComboDestino.addItem(c1);
        }

    }

    private void actualizarPresupuesto() {
        presupuestoFinal = presupuestoBase;

        if (RadioSinPension.isSelected()) {
            presupuestoFinal += presupuestoBase * 0;
        } else if (RadioDesayuno.isSelected()) {
            presupuestoFinal += presupuestoBase * 0.02;
        } else if (RadioMediaPension.isSelected()) {
            presupuestoFinal += presupuestoBase * 0.05;
        } else if (RadioPensionCompleta.isSelected()) {
            presupuestoFinal += presupuestoBase * 0.08;
        }

        if (RadioSi.isSelected()) {
            presupuestoFinal += presupuestoBase * 0.01;
        }

        LabelAlojamiento.setText(String.valueOf(presupuestoFinal));
    }

    public void actualizarPrecio() {
        Ciudad origen = (Ciudad) ComboOrigen.getSelectedItem();
        Ciudad destino = (Ciudad) ComboDestino.getSelectedItem();

        if (origen == null || destino == null) {
            return;
        }

        if (!origen.getContinente().equals(destino.getContinente())) {
            precioPasaje = 30000;
            RadioColectivo.setEnabled(false);
        } else {
            precioPasaje = 10000;
            RadioColectivo.setEnabled(true);
        }

        double precioFinal = precioPasaje;
        if ("Premium".equals(ComboAsiento.getSelectedItem())) {
            precioFinal *= 1.03;
        }

        if (RadioAvion.isSelected()) {
            precioFinal *= 1.07;
        } else if (RadioColectivo.isSelected()) {
            precioFinal *= 1.03;
        } else if (RadioBarco.isSelected()) {
            precioFinal *= 1.05;
        }

        double cantidad = Double.parseDouble(Numero.getText());
        LabelPrecio.setText(String.valueOf(precioFinal));
        LabelAlojamiento.setText(String.valueOf(precioFinal * cantidad));
        presupuestoBase = precioFinal;
    }

    private void actualizarPresupuestoConAlojamiento(double precioPorNoche) {
        
    Date fechaInicio = Calendario.getDate();
    Date fechaFin = Calendario2.getDate();
    
    long diferenciaEnMilisegundos = Math.abs(fechaInicio.getTime() - fechaFin.getTime());
            
    long diferenciaEnDias = diferenciaEnMilisegundos / (24 * 60 * 60 * 1000);
    
    int  diferencia = (int) diferenciaEnDias;
    presupuestoFinal = presupuestoBase + precioPorNoche;
    
    presupuestoFinal = presupuestoFinal * diferencia;
    LabelAlojamiento.setText(String.valueOf(presupuestoFinal));
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Advertencia;
    private javax.swing.JButton BotonEstablecer;
    private javax.swing.JButton BotonGuardar;
    private javax.swing.JButton BotonRestar;
    private javax.swing.JButton BotonSalir;
    private javax.swing.JButton BotonSalir1;
    private javax.swing.JButton BotonSiguiente;
    private javax.swing.JButton BotonSumar;
    private com.toedter.calendar.JDateChooser Calendario;
    private com.toedter.calendar.JDateChooser Calendario2;
    private javax.swing.JComboBox<String> ComboAlojamiento;
    private javax.swing.JComboBox<String> ComboAsiento;
    private javax.swing.JComboBox<Ciudad> ComboDestino;
    private javax.swing.JComboBox<Ciudad> ComboOrigen;
    private javax.swing.JLabel Contador;
    private javax.swing.JTextField FieldApellido;
    private javax.swing.JTextField FieldDni;
    private javax.swing.JTextField FieldEdad;
    private javax.swing.JTextField FieldEmail;
    private javax.swing.JTextField FieldNombre;
    private javax.swing.JTextField FieldTelefono;
    private javax.swing.ButtonGroup GrupoMenu;
    private javax.swing.ButtonGroup GrupoTransporte;
    private javax.swing.ButtonGroup GrupoTraslados;
    private javax.swing.JLabel Label89;
    private javax.swing.JLabel LabelAlojamiento;
    private javax.swing.JLabel LabelAsiento;
    private javax.swing.JLabel LabelPrecio;
    private javax.swing.JLabel LabelViajeros;
    private javax.swing.JLabel Numero;
    private javax.swing.JPanel PanelAlojamiento;
    private javax.swing.JPanel PanelFinal;
    private javax.swing.JPanel PanelPasaje;
    private javax.swing.JPanel PanelPrincipal;
    private javax.swing.JPanel PanelTurista;
    private javax.swing.JRadioButton RadioAvion;
    private javax.swing.JRadioButton RadioBarco;
    private javax.swing.JRadioButton RadioColectivo;
    private javax.swing.JRadioButton RadioDesayuno;
    private javax.swing.JRadioButton RadioMediaPension;
    private javax.swing.JRadioButton RadioNo;
    private javax.swing.JRadioButton RadioPensionCompleta;
    private javax.swing.JRadioButton RadioSi;
    private javax.swing.JRadioButton RadioSinPension;
    private javax.swing.JTable TablaAlojamiento;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSpinner jSpinner1;
    // End of variables declaration//GEN-END:variables
}
