
package Gibon;

import Reportes.GenerarReporte;
import clases.Validaciones;
import clases.conexion;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

/*
Clase: frm_cierre_caja
Autores: Jose Julio Tomas
Version 1.0   03/28/2020 
Permite finalizar el proceso de ventas del dia, cerrando y cuadrando los ingresos
por las ventas del dia.
*/

public class frm_Cierre_caja extends javax.swing.JFrame{
    

    private Calendar fechaActual=new GregorianCalendar();
    private conexion clase_conexion=new conexion();
    private Connection Conexion=null;
    private GenerarReporte clase_reportes = new GenerarReporte();
    private Validaciones clase_validaciones=new Validaciones();
    private PreparedStatement prepared_statement; 
    private ResultSet result_set;
    private frmGibon formulario_principal = new frmGibon();

    private boolean correcto=false;
    private Double efectivo_total=0.0,efectivo_caja=0.0,POS_total=0.0,POS_caja=0.0,efectivo_inicial=efectivo_inicial_caja_abierta();
    private int codigo=codigo_caja_abierta();
    
    public frm_Cierre_caja() {
        
        initComponents();
        this.setLocationRelativeTo(null);
        inicializar_formulario();
        lbl_fecha.setText(fecha());
        setVisible(true);
        Image iconoPropio = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/icono.png"));
        setIconImage(iconoPropio);
        
    }
    
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel_fondo = new javax.swing.JPanel();
        Panel_barra_superior = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        lbl_fecha = new javax.swing.JLabel();
        btn_cerrar = new javax.swing.JButton();
        Panel_totales = new javax.swing.JPanel();
        btn_cierre_caja = new javax.swing.JButton();
        txt_tarjeta_diferencia = new javax.swing.JTextField();
        txt_efectivo_recaudado = new javax.swing.JTextField();
        txt_efectivo_diferencia = new javax.swing.JTextField();
        txt_efectivo_caja = new javax.swing.JTextField();
        txt_total_3 = new javax.swing.JTextField();
        txt_tarjeta_caja = new javax.swing.JTextField();
        txt_total_2 = new javax.swing.JTextField();
        txt_total_1 = new javax.swing.JTextField();
        txt_tarjeta_recaudado = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txta_comentario = new javax.swing.JTextArea();
        btn_previsualizar = new javax.swing.JButton();
        txt_efectivo_inicial = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        Panel_fondo.setBackground(new java.awt.Color(255, 255, 255));

        Panel_barra_superior.setBackground(new java.awt.Color(0, 0, 0));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/img_gibon_grande.png"))); // NOI18N

        lbl_fecha.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 24)); // NOI18N
        lbl_fecha.setForeground(new java.awt.Color(255, 255, 255));
        lbl_fecha.setText("DD/MM/YYYY");

        btn_cerrar.setBackground(new java.awt.Color(195, 50, 50));
        btn_cerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btn_cerrar.png"))); // NOI18N
        btn_cerrar.setToolTipText("Salir");
        btn_cerrar.setBorderPainted(false);
        btn_cerrar.setFocusPainted(false);
        btn_cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Panel_barra_superiorLayout = new javax.swing.GroupLayout(Panel_barra_superior);
        Panel_barra_superior.setLayout(Panel_barra_superiorLayout);
        Panel_barra_superiorLayout.setHorizontalGroup(
            Panel_barra_superiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_barra_superiorLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(226, 226, 226)
                .addComponent(lbl_fecha)
                .addGap(64, 64, 64)
                .addComponent(btn_cerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        Panel_barra_superiorLayout.setVerticalGroup(
            Panel_barra_superiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_barra_superiorLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel9))
            .addGroup(Panel_barra_superiorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel_barra_superiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_cerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_fecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Panel_totales.setBackground(new java.awt.Color(255, 255, 255));

        btn_cierre_caja.setBackground(new java.awt.Color(0, 153, 0));
        btn_cierre_caja.setForeground(new java.awt.Color(255, 255, 255));
        btn_cierre_caja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cerrar_caja.png"))); // NOI18N
        btn_cierre_caja.setText("Cerrar Caja");
        btn_cierre_caja.setToolTipText("Cerrar caja");
        btn_cierre_caja.setBorderPainted(false);
        btn_cierre_caja.setFocusPainted(false);
        btn_cierre_caja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cierre_cajaActionPerformed(evt);
            }
        });

        txt_tarjeta_diferencia.setEditable(false);
        txt_tarjeta_diferencia.setBackground(new java.awt.Color(195, 50, 60));
        txt_tarjeta_diferencia.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_tarjeta_diferencia.setForeground(new java.awt.Color(255, 255, 255));
        txt_tarjeta_diferencia.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tarjetas / POS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(255, 255, 255))); // NOI18N

        txt_efectivo_recaudado.setEditable(false);
        txt_efectivo_recaudado.setBackground(new java.awt.Color(250, 250, 250));
        txt_efectivo_recaudado.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_efectivo_recaudado.setForeground(new java.awt.Color(102, 102, 102));
        txt_efectivo_recaudado.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Efectivo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(102, 102, 102))); // NOI18N

        txt_efectivo_diferencia.setEditable(false);
        txt_efectivo_diferencia.setBackground(new java.awt.Color(195, 50, 60));
        txt_efectivo_diferencia.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_efectivo_diferencia.setForeground(new java.awt.Color(255, 255, 255));
        txt_efectivo_diferencia.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Efectivo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(255, 255, 255))); // NOI18N

        txt_efectivo_caja.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_efectivo_caja.setText("0");
        txt_efectivo_caja.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Efectivo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N
        txt_efectivo_caja.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_efectivo_cajaKeyTyped(evt);
            }
        });

        txt_total_3.setEditable(false);
        txt_total_3.setBackground(new java.awt.Color(195, 50, 60));
        txt_total_3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_total_3.setForeground(new java.awt.Color(255, 255, 255));
        txt_total_3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Diferencia total:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N

        txt_tarjeta_caja.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_tarjeta_caja.setText("0");
        txt_tarjeta_caja.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tarjetas / POS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N
        txt_tarjeta_caja.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_tarjeta_cajaKeyTyped(evt);
            }
        });

        txt_total_2.setEditable(false);
        txt_total_2.setBackground(new java.awt.Color(255, 255, 255));
        txt_total_2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_total_2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Total reportado:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        txt_total_1.setEditable(false);
        txt_total_1.setBackground(new java.awt.Color(250, 250, 250));
        txt_total_1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_total_1.setForeground(new java.awt.Color(102, 102, 102));
        txt_total_1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Total recaudado:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(102, 102, 102))); // NOI18N

        txt_tarjeta_recaudado.setEditable(false);
        txt_tarjeta_recaudado.setBackground(new java.awt.Color(250, 250, 250));
        txt_tarjeta_recaudado.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_tarjeta_recaudado.setForeground(new java.awt.Color(102, 102, 102));
        txt_tarjeta_recaudado.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tarjetas / POS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(102, 102, 102))); // NOI18N

        txta_comentario.setColumns(20);
        txta_comentario.setRows(5);
        txta_comentario.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Comentario :", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N
        txta_comentario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txta_comentarioKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(txta_comentario);

        btn_previsualizar.setBackground(new java.awt.Color(255, 153, 0));
        btn_previsualizar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_previsualizar.setForeground(new java.awt.Color(255, 255, 255));
        btn_previsualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/check.png"))); // NOI18N
        btn_previsualizar.setText("Previsualizar");
        btn_previsualizar.setToolTipText("");
        btn_previsualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_previsualizarActionPerformed(evt);
            }
        });

        txt_efectivo_inicial.setEditable(false);
        txt_efectivo_inicial.setBackground(new java.awt.Color(250, 250, 250));
        txt_efectivo_inicial.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_efectivo_inicial.setForeground(new java.awt.Color(102, 102, 102));
        txt_efectivo_inicial.setToolTipText("Cantidad de dinero en efectivo reportada al abrir la caja");
        txt_efectivo_inicial.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        jLabel1.setBackground(new java.awt.Color(10, 76, 122));
        jLabel1.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CIERRE DE CAJA");
        jLabel1.setOpaque(true);

        jLabel4.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(10, 76, 122));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Total vendido");

        jLabel5.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(10, 76, 122));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Total reportado");

        jLabel6.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(10, 76, 122));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Diferencia");

        jLabel7.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(10, 76, 122));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Efectivo inicial");

        javax.swing.GroupLayout Panel_totalesLayout = new javax.swing.GroupLayout(Panel_totales);
        Panel_totales.setLayout(Panel_totalesLayout);
        Panel_totalesLayout.setHorizontalGroup(
            Panel_totalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_totalesLayout.createSequentialGroup()
                .addGroup(Panel_totalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, Panel_totalesLayout.createSequentialGroup()
                        .addGap(254, 254, 254)
                        .addComponent(jScrollPane1))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, Panel_totalesLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(Panel_totalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                            .addComponent(txt_efectivo_inicial))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                        .addGroup(Panel_totalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_efectivo_recaudado)
                            .addComponent(txt_tarjeta_recaudado)
                            .addComponent(txt_total_1)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                        .addGroup(Panel_totalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Panel_totalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txt_tarjeta_caja, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                                .addComponent(txt_efectivo_caja)
                                .addComponent(txt_total_2))
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(71, 71, 71)
                        .addGroup(Panel_totalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Panel_totalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txt_tarjeta_diferencia, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txt_efectivo_diferencia, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE))
                            .addComponent(txt_total_3, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE))
                        .addGap(9, 9, 9)))
                .addGap(237, 237, 237))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_totalesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(Panel_totalesLayout.createSequentialGroup()
                .addGap(358, 358, 358)
                .addComponent(btn_previsualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79)
                .addComponent(btn_cierre_caja, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Panel_totalesLayout.setVerticalGroup(
            Panel_totalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_totalesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addGroup(Panel_totalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addGap(27, 27, 27)
                .addGroup(Panel_totalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel_totalesLayout.createSequentialGroup()
                        .addGroup(Panel_totalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_efectivo_recaudado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(Panel_totalesLayout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(txt_efectivo_inicial, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(24, 24, 24)
                        .addComponent(txt_tarjeta_recaudado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(Panel_totalesLayout.createSequentialGroup()
                        .addGroup(Panel_totalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_efectivo_caja, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_efectivo_diferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(Panel_totalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_tarjeta_caja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_tarjeta_diferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(Panel_totalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_total_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_total_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_total_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(41, 41, 41)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(Panel_totalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_previsualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_cierre_caja, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout Panel_fondoLayout = new javax.swing.GroupLayout(Panel_fondo);
        Panel_fondo.setLayout(Panel_fondoLayout);
        Panel_fondoLayout.setHorizontalGroup(
            Panel_fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel_barra_superior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Panel_totales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        Panel_fondoLayout.setVerticalGroup(
            Panel_fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_fondoLayout.createSequentialGroup()
                .addComponent(Panel_barra_superior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Panel_totales, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(Panel_fondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Panel_fondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /*
    función: inicializar_formulario
    Autores: Jose
    Version 1.0   25/04/2020 
    Da formato al formulario y presenta en pantalla los totales de venta previo
    a cerrar la caja.
    */
    private void inicializar_formulario(){
        Conexion=clase_conexion.conectar();
        if(clase_conexion.obtener_estado_conexion()==true){
            try{
                prepared_statement=Conexion.prepareStatement("SELECT SUM(f.[pago_efectivo]) as 'te',SUM(f.[pago_POS]) as 'tt' " +
                        " FROM [Factura] as f  " +
                        " CROSS JOIN [Cierre_diario_Caja] as cc " +
                        " WHERE cc.cod_cierre=? AND f.[fecha_emision]>=cc.fecha_Inicio");
                prepared_statement.setInt(1,codigo);
                result_set=prepared_statement.executeQuery();
                if(result_set.next()){
                    efectivo_total=result_set.getDouble("te");
                    POS_total=result_set.getDouble("tt");
                }
                Conexion=null;
                clase_conexion.cerrar_conexion();
                prepared_statement.close();
                result_set.close();
                mostrar_datos_de_caja_abierta();
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Error al mostrar datos \n"+ex,"ERROR",JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    /*
    función: codigo_caja_abierta
    Autores: Jose
    Version 1.0   25/04/2020 
    funcion que retorna el codigo de la caja abierta en el sistema.
    */
    private int codigo_caja_abierta(){

        int codigo_caja=0;
        Conexion=clase_conexion.conectar();
        if(clase_conexion.obtener_estado_conexion()==true){
            try{
                prepared_statement=Conexion.prepareStatement("SELECT *  FROM Cierre_diario_Caja WHERE [cod_estado]=8");
                result_set=prepared_statement.executeQuery();
                if(result_set.next()){
                    codigo_caja=result_set.getInt("cod_cierre");
                }
                Conexion=null;
                clase_conexion.cerrar_conexion();
                prepared_statement.close();
                result_set.close();
            }catch(SQLException e){
                JOptionPane.showMessageDialog(this,"Ocurrió un error inesperado "+e,"ERROR",JOptionPane.ERROR_MESSAGE);
            }
        }  
        return codigo_caja;
    }
    
    /*
    función: efectivo_incial
    Autores: jose
    Version 1.0   25/04/2020 
    funcion que retorna la cantidad de dinero en efectivo con la que se aperturó 
    la caja.
    */
    private Double efectivo_inicial_caja_abierta(){

        Double efectivo_inicial=0.0;
        Conexion=clase_conexion.conectar();
        if(clase_conexion.obtener_estado_conexion()==true){
            try{
                prepared_statement=Conexion.prepareStatement("SELECT *  FROM Cierre_diario_Caja WHERE [cod_estado]=8");
                result_set=prepared_statement.executeQuery();
                if(result_set.next()){
                    efectivo_inicial=result_set.getDouble("cambio_inicial");
                }
                Conexion=null;
                clase_conexion.cerrar_conexion();
                prepared_statement.close();
                result_set.close();
            }catch(SQLException e){
                JOptionPane.showMessageDialog(this,"Ocurrió un error inesperado "+e,"ERROR",JOptionPane.ERROR_MESSAGE);
            }
        }
        return efectivo_inicial;
    }

    /*
    función: mostrar_datos_de_caja_abierta
    Autores: jose
    Version 1.0   25/04/2020 
    funcion que permite calcular y mostrar en pantalla los totales de venta del dia.
    */
    private void mostrar_datos_de_caja_abierta(){
        
        txt_efectivo_inicial.setText(String.valueOf(clase_validaciones.redondear_decimales(efectivo_inicial)));
        txt_efectivo_recaudado.setText(String.valueOf(clase_validaciones.redondear_decimales(efectivo_total)));
        txt_tarjeta_recaudado.setText(String.valueOf(clase_validaciones.redondear_decimales(POS_total)));
        txt_efectivo_diferencia.setText(String.valueOf(clase_validaciones.redondear_decimales((efectivo_total+efectivo_inicial)-efectivo_caja)));
        txt_tarjeta_diferencia.setText(String.valueOf(clase_validaciones.redondear_decimales(POS_total-POS_caja)));
        txt_total_1.setText(String.valueOf(clase_validaciones.redondear_decimales(efectivo_total+POS_total)));
        txt_total_2.setText(String.valueOf(clase_validaciones.redondear_decimales(efectivo_caja+POS_caja)));
        txt_total_3.setText(String.valueOf(clase_validaciones.redondear_decimales(((efectivo_total+efectivo_inicial)-efectivo_caja)+(POS_total-POS_caja))));
}
    private void btn_cerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cerrarActionPerformed
        int respuesta=JOptionPane.showConfirmDialog(null,"¿Esta seguro de cerrar la ventana?","AVISO",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
        if(respuesta==JOptionPane.YES_OPTION){
            frmGibon GBN = new frmGibon();
            GBN.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btn_cerrarActionPerformed
    
    /*
    Rutina: cerrar caja
    Autores: tomas
    Version 1.0   28/03/2020 
    funcion que permite culminar el proceso de ventas, actualizando en la base
    de datos, los totales de venta del dia.
    */
    private void btn_cierre_cajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cierre_cajaActionPerformed
    int codigo_caja=codigo_caja_abierta();
    int respuesta=JOptionPane.showConfirmDialog(null,"¿Esta seguro de cerrar la caja?","AVISO",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
    if(respuesta==JOptionPane.YES_OPTION){
        try{
            efectivo_caja=Double.parseDouble(txt_efectivo_caja.getText().trim());
            POS_caja=Double.parseDouble(txt_tarjeta_caja.getText().trim());
            correcto=true;
            /*
            CORRECCIÓN DE ERROR
            Autores: tomas
            Version 1.0   28/06/2020 
            verificar el ingreso de cantidades validas.
            */
            if(efectivo_caja<0 || POS_caja<0){
                correcto=false;
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Ingrese una cantidad válida","AVISO",JOptionPane.WARNING_MESSAGE);
        }
        if(correcto==true){
            inicializar_formulario();
            Conexion=clase_conexion.conectar();
            if(clase_conexion.obtener_estado_conexion()==true){
                try{
                    PreparedStatement prepared_statement_local;
                    prepared_statement_local=Conexion.prepareStatement("UPDATE [Cierre_diario_Caja] " +
                            "   SET [fecha_cierre] = GETDATE(),[total_efectivo] = ?,[total_efectivo_reportado] = ? " +
                            "   ,[total_POS] =? ,[total_POS_reportado] = ?,[comentario] = ?,[cod_estado] = 9 " +
                            "   WHERE [cod_cierre]=? ");
                    prepared_statement_local.setDouble(1,efectivo_total);
                    prepared_statement_local.setDouble(2,efectivo_caja);
                    prepared_statement_local.setDouble(3,POS_total);
                    prepared_statement_local.setDouble(4,POS_caja);
                    prepared_statement_local.setString(5,txta_comentario.getText().trim());
                    prepared_statement_local.setInt(6,codigo_caja);
                    prepared_statement_local.executeUpdate();
                    prepared_statement.close();
                    Conexion=null;
                    clase_conexion.cerrar_conexion();
                    JOptionPane.showMessageDialog(null,"Caja Cerrada con éxito. \n Generando reporte ...","AVISO",JOptionPane.INFORMATION_MESSAGE);
                    clase_reportes.Cierre_Caja(codigo_caja);
                    formulario_principal.setVisible(true);
                    this.dispose();
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null,"ERROR Al Cerrar Caja, Intente Nuevamente "+ex,"ERROR",JOptionPane.ERROR_MESSAGE);
                }
            }
        }else{
            JOptionPane.showMessageDialog(null,"Ingrese una cantidad válida","AVISO",JOptionPane.WARNING_MESSAGE);
        }
    }
    }//GEN-LAST:event_btn_cierre_cajaActionPerformed
    /*
    Rutina: previsualizar
    Autores: tomas
    Version 1.0   28/03/2020 
    permite mostrar en pantalla una actualizacion de calculos, tomando en cuenta
    los datos ingresados por el usuario.
    */
    private void btn_previsualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_previsualizarActionPerformed

        try{
            efectivo_caja=Double.parseDouble(txt_efectivo_caja.getText().trim());
            POS_caja=Double.parseDouble(txt_tarjeta_caja.getText().trim());
            correcto=true;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Ingrese una cantidad válida","AVISO",JOptionPane.WARNING_MESSAGE);
        }
        if(correcto==true){
            Conexion=clase_conexion.conectar();
            if(clase_conexion.obtener_estado_conexion()==true){
                try{
                prepared_statement=Conexion.prepareStatement("SELECT SUM(f.[pago_efectivo]) as 'te',SUM(f.[pago_POS]) as 'tt' " +
                        " FROM [Factura] as f  " +
                        " CROSS JOIN [Cierre_diario_Caja] as cc " +
                        " WHERE cc.cod_cierre=? AND f.[fecha_emision]>=cc.fecha_Inicio");
                prepared_statement.setInt(1,codigo);
                result_set=prepared_statement.executeQuery();
                if(result_set.next()){
                    efectivo_total=result_set.getDouble("te");
                    POS_total=result_set.getDouble("tt");
                }
                prepared_statement.close();
                result_set.close();
                Conexion=null;
                clase_conexion.cerrar_conexion();
                mostrar_datos_de_caja_abierta();
                }catch(SQLException ex){
                    JOptionPane.showMessageDialog(null,"ERROR al Cerrar Caja, Intente Nuevamente "+ex,"ERROR",JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_btn_previsualizarActionPerformed

    private void txta_comentarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txta_comentarioKeyTyped
        if(txta_comentario.getText().length()>=99){
            evt.consume();
        }
    }//GEN-LAST:event_txta_comentarioKeyTyped

    private void txt_efectivo_cajaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_efectivo_cajaKeyTyped
        if(txt_efectivo_caja.getText().length()>=8){
            evt.consume();
        }
    }//GEN-LAST:event_txt_efectivo_cajaKeyTyped

    private void txt_tarjeta_cajaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_tarjeta_cajaKeyTyped
        if(txt_tarjeta_caja.getText().length()>=8){
            evt.consume();
        }
    }//GEN-LAST:event_txt_tarjeta_cajaKeyTyped

    private static String fecha(){
        Date fecha = new Date();
        SimpleDateFormat Formato_fecha = new SimpleDateFormat("dd/MM/YYYY");
        return Formato_fecha.format(fecha);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frm_Cierre_caja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_Cierre_caja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_Cierre_caja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_Cierre_caja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_Cierre_caja().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panel_barra_superior;
    private javax.swing.JPanel Panel_fondo;
    private javax.swing.JPanel Panel_totales;
    private javax.swing.JButton btn_cerrar;
    private javax.swing.JButton btn_cierre_caja;
    private javax.swing.JButton btn_previsualizar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_fecha;
    private javax.swing.JTextField txt_efectivo_caja;
    private javax.swing.JTextField txt_efectivo_diferencia;
    private javax.swing.JTextField txt_efectivo_inicial;
    private javax.swing.JTextField txt_efectivo_recaudado;
    private javax.swing.JTextField txt_tarjeta_caja;
    private javax.swing.JTextField txt_tarjeta_diferencia;
    private javax.swing.JTextField txt_tarjeta_recaudado;
    private javax.swing.JTextField txt_total_1;
    private javax.swing.JTextField txt_total_2;
    private javax.swing.JTextField txt_total_3;
    private javax.swing.JTextArea txta_comentario;
    // End of variables declaration//GEN-END:variables
}
