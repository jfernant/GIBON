package Gibon;

import Gibon.frm_Cierre_caja;
import Gibon.frm_Login;
import Gibon.frm_abrir_caja;
import Gibon.frm_punto_de_venta;
import Reportes.GenerarReporte;
import clases.Permisos;
import clases.Validaciones;
import clases.conexion;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/*
Clase: frm_gibon
Autores: Todos (Katering,Yuli,Tomas,Erick,Victor,Julio,Jose)
Version 1.0   05/07/2020

Clase que contiene el menu principal y modulos del sistema, permite visualizar y dar 
mantenimiento a la base de datos.
*/

public class frmGibon extends javax.swing.JFrame {

    
    private Permisos clase_permisos=new Permisos();
    private conexion clase_conexion=new conexion();
    private Connection conexion=null;
    private GenerarReporte reporte = new GenerarReporte();
    private Validaciones clase_validaciones = new Validaciones();

    PreparedStatement prepared_statement; 
    ResultSet result_set;
    DefaultTableModel defalut_table_model;
    
    public frmGibon() {
        initComponents();
        this.setLocationRelativeTo(null);

        inicializar_formulario();
        aplicar_permisos();

        Image iconoPropio = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/icono.png"));
        setIconImage(iconoPropio);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel_barra_superior = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lbl_usuario_actual = new javax.swing.JLabel();
        btn_salir = new javax.swing.JButton();
        Panel_menu_principal = new javax.swing.JPanel();
        btn_administracion = new javax.swing.JButton();
        btn_colecciones = new javax.swing.JButton();
        btn_clientes = new javax.swing.JButton();
        btn_compras = new javax.swing.JButton();
        btn_produccion = new javax.swing.JButton();
        btn_materia_prima = new javax.swing.JButton();
        btn_ventas = new javax.swing.JButton();
        btn_productos = new javax.swing.JButton();
        btn_punto_de_venta = new javax.swing.JButton();
        Panel_sub_menu = new javax.swing.JPanel();
        btn_sub_menu_1 = new javax.swing.JButton();
        btn_sub_menu_2 = new javax.swing.JButton();
        btn_sub_menu_3 = new javax.swing.JButton();
        btn_sub_menu_4 = new javax.swing.JButton();
        btn_sub_menu_5 = new javax.swing.JButton();
        Panel_contenedor_pantalla = new javax.swing.JPanel();
        Panel_busqueda_Y_botones = new javax.swing.JPanel();
        btn_busqueda = new javax.swing.JButton();
        txt_busqueda = new javax.swing.JTextField();
        cmb_busqueda = new javax.swing.JComboBox<>();
        btn_modificar = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        btn_imprimir = new javax.swing.JButton();
        btn_guardar = new javax.swing.JButton();
        btn_cancelar = new javax.swing.JButton();
        btn_limpiar_busqueda = new javax.swing.JButton();
        Panel_cajas_de_texto = new javax.swing.JPanel();
        Panel_agregar_nuevo = new javax.swing.JPanel();
        btn_agregar_nuevo = new javax.swing.JButton();
        lbl_agregar_nuevo = new javax.swing.JLabel();
        txt_1 = new javax.swing.JTextField();
        txt_2 = new javax.swing.JTextField();
        txt_3 = new javax.swing.JTextField();
        txt_4 = new javax.swing.JTextField();
        txt_5 = new javax.swing.JTextField();
        txt_6 = new javax.swing.JTextField();
        txt_7 = new javax.swing.JTextField();
        txt_8 = new javax.swing.JTextField();
        txt_9 = new javax.swing.JTextField();
        txt_10 = new javax.swing.JTextField();
        txt_11 = new javax.swing.JTextField();
        txt_12 = new javax.swing.JTextField();
        txt_13 = new javax.swing.JTextField();
        txt_14 = new javax.swing.JTextField();
        txt_15 = new javax.swing.JTextField();
        txt_16 = new javax.swing.JTextField();
        txt_17 = new javax.swing.JTextField();
        txt_18 = new javax.swing.JTextField();
        txt_19 = new javax.swing.JTextField();
        txt_20 = new javax.swing.JTextField();
        txt_21 = new javax.swing.JTextField();
        cmb_1 = new javax.swing.JComboBox<>();
        Scroll_pane_txta_1 = new javax.swing.JScrollPane();
        txta_1 = new javax.swing.JTextArea();
        Scroll_pane_txta_3 = new javax.swing.JScrollPane();
        txta_3 = new javax.swing.JTextArea();
        Scroll_pane_txta_2 = new javax.swing.JScrollPane();
        txta_2 = new javax.swing.JTextArea();
        txt_22 = new javax.swing.JTextField();
        cmb_2 = new javax.swing.JComboBox<>();
        cmb_3 = new javax.swing.JComboBox<>();
        cmb_4 = new javax.swing.JComboBox<>();
        Panel_tabla_datos = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla_principal = new javax.swing.JTable();
        Panel_titulo = new javax.swing.JPanel();
        lbl_titulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gibon ● Grupo Industrial Bonilla");
        setBackground(new java.awt.Color(0, 0, 0));
        setUndecorated(true);

        Panel_barra_superior.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/administracion_usuarios.png"))); // NOI18N

        lbl_usuario_actual.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_usuario_actual.setForeground(new java.awt.Color(255, 255, 255));
        lbl_usuario_actual.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        btn_salir.setBackground(new java.awt.Color(195, 50, 60));
        btn_salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cerrar sesión (1).png"))); // NOI18N
        btn_salir.setToolTipText("Salir del Sistema");
        btn_salir.setBorder(null);
        btn_salir.setBorderPainted(false);
        btn_salir.setFocusPainted(false);
        btn_salir.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btn_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Panel_barra_superiorLayout = new javax.swing.GroupLayout(Panel_barra_superior);
        Panel_barra_superior.setLayout(Panel_barra_superiorLayout);
        Panel_barra_superiorLayout.setHorizontalGroup(
            Panel_barra_superiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_barra_superiorLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_usuario_actual, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_salir, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        Panel_barra_superiorLayout.setVerticalGroup(
            Panel_barra_superiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
            .addComponent(lbl_usuario_actual, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_salir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        Panel_menu_principal.setBackground(new java.awt.Color(10, 76, 122));

        btn_administracion.setBackground(new java.awt.Color(10, 76, 122));
        btn_administracion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Administracion.png"))); // NOI18N
        btn_administracion.setToolTipText("Panel administrativo");
        btn_administracion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        btn_administracion.setEnabled(false);
        btn_administracion.setFocusPainted(false);
        btn_administracion.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_administracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_administracionActionPerformed(evt);
            }
        });

        btn_colecciones.setBackground(new java.awt.Color(10, 76, 122));
        btn_colecciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/colecciones.png"))); // NOI18N
        btn_colecciones.setToolTipText("Panel de colecciones");
        btn_colecciones.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        btn_colecciones.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_colecciones.setEnabled(false);
        btn_colecciones.setFocusPainted(false);
        btn_colecciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_coleccionesActionPerformed(evt);
            }
        });

        btn_clientes.setBackground(new java.awt.Color(10, 76, 122));
        btn_clientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/clientes.png"))); // NOI18N
        btn_clientes.setToolTipText("Panel de clientes");
        btn_clientes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        btn_clientes.setEnabled(false);
        btn_clientes.setFocusPainted(false);
        btn_clientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clientesActionPerformed(evt);
            }
        });

        btn_compras.setBackground(new java.awt.Color(10, 76, 122));
        btn_compras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/compras.png"))); // NOI18N
        btn_compras.setToolTipText("Panel de compras");
        btn_compras.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        btn_compras.setEnabled(false);
        btn_compras.setFocusPainted(false);
        btn_compras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_comprasActionPerformed(evt);
            }
        });

        btn_produccion.setBackground(new java.awt.Color(10, 76, 122));
        btn_produccion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/produccion.png"))); // NOI18N
        btn_produccion.setToolTipText("Panel de producción");
        btn_produccion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        btn_produccion.setEnabled(false);
        btn_produccion.setFocusPainted(false);
        btn_produccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_produccionActionPerformed(evt);
            }
        });

        btn_materia_prima.setBackground(new java.awt.Color(10, 76, 122));
        btn_materia_prima.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Materia_prima.png"))); // NOI18N
        btn_materia_prima.setToolTipText("Panel de materia prima ");
        btn_materia_prima.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        btn_materia_prima.setEnabled(false);
        btn_materia_prima.setFocusPainted(false);
        btn_materia_prima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_materia_primaActionPerformed(evt);
            }
        });

        btn_ventas.setBackground(new java.awt.Color(10, 76, 122));
        btn_ventas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ventas.png"))); // NOI18N
        btn_ventas.setToolTipText("Panel de ventas");
        btn_ventas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        btn_ventas.setEnabled(false);
        btn_ventas.setFocusPainted(false);
        btn_ventas.setPreferredSize(new java.awt.Dimension(139, 70));
        btn_ventas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ventasActionPerformed(evt);
            }
        });

        btn_productos.setBackground(new java.awt.Color(10, 76, 122));
        btn_productos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/productos.png"))); // NOI18N
        btn_productos.setToolTipText("Panel de productos");
        btn_productos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        btn_productos.setEnabled(false);
        btn_productos.setFocusPainted(false);
        btn_productos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_productosActionPerformed(evt);
            }
        });

        btn_punto_de_venta.setBackground(new java.awt.Color(10, 76, 122));
        btn_punto_de_venta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/punto_de_venta.png"))); // NOI18N
        btn_punto_de_venta.setToolTipText("Punto de Venta");
        btn_punto_de_venta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        btn_punto_de_venta.setEnabled(false);
        btn_punto_de_venta.setFocusPainted(false);
        btn_punto_de_venta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_punto_de_ventaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Panel_menu_principalLayout = new javax.swing.GroupLayout(Panel_menu_principal);
        Panel_menu_principal.setLayout(Panel_menu_principalLayout);
        Panel_menu_principalLayout.setHorizontalGroup(
            Panel_menu_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_menu_principalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel_menu_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_clientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_administracion, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_ventas, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btn_compras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(Panel_menu_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btn_produccion, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, Panel_menu_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btn_colecciones, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_productos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_materia_prima, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(btn_punto_de_venta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Panel_menu_principalLayout.setVerticalGroup(
            Panel_menu_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_menu_principalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_administracion, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_clientes, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_colecciones, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_productos, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_materia_prima, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_produccion, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_compras, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_ventas, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_punto_de_venta, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        Panel_sub_menu.setBackground(new java.awt.Color(195, 50, 60));

        btn_sub_menu_1.setBackground(new java.awt.Color(195, 55, 65));
        btn_sub_menu_1.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 11)); // NOI18N
        btn_sub_menu_1.setForeground(new java.awt.Color(255, 255, 255));
        btn_sub_menu_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        btn_sub_menu_1.setFocusCycleRoot(true);
        btn_sub_menu_1.setFocusPainted(false);
        btn_sub_menu_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sub_menu_1ActionPerformed(evt);
            }
        });

        btn_sub_menu_2.setBackground(new java.awt.Color(195, 55, 65));
        btn_sub_menu_2.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 11)); // NOI18N
        btn_sub_menu_2.setForeground(new java.awt.Color(255, 255, 255));
        btn_sub_menu_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        btn_sub_menu_2.setFocusPainted(false);
        btn_sub_menu_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sub_menu_2ActionPerformed(evt);
            }
        });

        btn_sub_menu_3.setBackground(new java.awt.Color(195, 55, 65));
        btn_sub_menu_3.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 11)); // NOI18N
        btn_sub_menu_3.setForeground(new java.awt.Color(255, 255, 255));
        btn_sub_menu_3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        btn_sub_menu_3.setFocusPainted(false);
        btn_sub_menu_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sub_menu_3ActionPerformed(evt);
            }
        });

        btn_sub_menu_4.setBackground(new java.awt.Color(195, 55, 65));
        btn_sub_menu_4.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 11)); // NOI18N
        btn_sub_menu_4.setForeground(new java.awt.Color(255, 255, 255));
        btn_sub_menu_4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        btn_sub_menu_4.setFocusPainted(false);
        btn_sub_menu_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sub_menu_4ActionPerformed(evt);
            }
        });

        btn_sub_menu_5.setBackground(new java.awt.Color(195, 55, 65));
        btn_sub_menu_5.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 11)); // NOI18N
        btn_sub_menu_5.setForeground(new java.awt.Color(255, 255, 255));
        btn_sub_menu_5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        btn_sub_menu_5.setFocusPainted(false);
        btn_sub_menu_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sub_menu_5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Panel_sub_menuLayout = new javax.swing.GroupLayout(Panel_sub_menu);
        Panel_sub_menu.setLayout(Panel_sub_menuLayout);
        Panel_sub_menuLayout.setHorizontalGroup(
            Panel_sub_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_sub_menuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel_sub_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_sub_menu_1, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                    .addComponent(btn_sub_menu_2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_sub_menu_3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_sub_menu_4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_sub_menu_5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Panel_sub_menuLayout.setVerticalGroup(
            Panel_sub_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_sub_menuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_sub_menu_1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_sub_menu_2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_sub_menu_3, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_sub_menu_4, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_sub_menu_5, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Panel_contenedor_pantalla.setBackground(new java.awt.Color(255, 255, 255));
        Panel_contenedor_pantalla.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        Panel_busqueda_Y_botones.setBackground(new java.awt.Color(255, 255, 255));
        Panel_busqueda_Y_botones.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        btn_busqueda.setBackground(new java.awt.Color(0, 153, 255));
        btn_busqueda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btn_buscar.png"))); // NOI18N
        btn_busqueda.setToolTipText("Buscar");
        btn_busqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_busquedaActionPerformed(evt);
            }
        });

        txt_busqueda.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txt_busqueda.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 1, true), "BUSCAR :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Microsoft JhengHei UI Light", 1, 11), new java.awt.Color(10, 76, 122))); // NOI18N
        txt_busqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_busquedaActionPerformed(evt);
            }
        });
        txt_busqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_busquedaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_busquedaKeyTyped(evt);
            }
        });

        cmb_busqueda.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        cmb_busqueda.setToolTipText("Buscar Por...");

        btn_modificar.setBackground(new java.awt.Color(255, 204, 0));
        btn_modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/bnt_modificar.png"))); // NOI18N
        btn_modificar.setToolTipText("Modificar registro");
        btn_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modificarActionPerformed(evt);
            }
        });

        btn_eliminar.setBackground(new java.awt.Color(195, 50, 50));
        btn_eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btn_eliminar.png"))); // NOI18N
        btn_eliminar.setToolTipText("Eliminar registro");
        btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarActionPerformed(evt);
            }
        });

        btn_imprimir.setBackground(new java.awt.Color(0, 153, 255));
        btn_imprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btn_imprimir.png"))); // NOI18N
        btn_imprimir.setToolTipText("Imprimir");
        btn_imprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_imprimirActionPerformed(evt);
            }
        });

        btn_guardar.setBackground(new java.awt.Color(10, 76, 122));
        btn_guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btn_guardar.png"))); // NOI18N
        btn_guardar.setToolTipText("Guardar registro");
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });

        btn_cancelar.setBackground(new java.awt.Color(195, 50, 50));
        btn_cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btn_cancelar.png"))); // NOI18N
        btn_cancelar.setToolTipText("Cancelar");
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });

        btn_limpiar_busqueda.setBackground(new java.awt.Color(195, 50, 50));
        btn_limpiar_busqueda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btn_cancelar.png"))); // NOI18N
        btn_limpiar_busqueda.setToolTipText("Limpiar búsqueda");
        btn_limpiar_busqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_limpiar_busquedaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Panel_busqueda_Y_botonesLayout = new javax.swing.GroupLayout(Panel_busqueda_Y_botones);
        Panel_busqueda_Y_botones.setLayout(Panel_busqueda_Y_botonesLayout);
        Panel_busqueda_Y_botonesLayout.setHorizontalGroup(
            Panel_busqueda_Y_botonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_busqueda_Y_botonesLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(txt_busqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(cmb_busqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(btn_busqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_limpiar_busqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_imprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        Panel_busqueda_Y_botonesLayout.setVerticalGroup(
            Panel_busqueda_Y_botonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_busqueda_Y_botonesLayout.createSequentialGroup()
                .addGap(0, 7, Short.MAX_VALUE)
                .addGroup(Panel_busqueda_Y_botonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_busqueda, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_eliminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(btn_modificar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(btn_imprimir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(btn_guardar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(btn_cancelar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(btn_limpiar_busqueda, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(btn_busqueda, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(cmb_busqueda, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Panel_cajas_de_texto.setBackground(new java.awt.Color(255, 255, 255));
        Panel_cajas_de_texto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        Panel_agregar_nuevo.setBackground(new java.awt.Color(255, 255, 255));
        Panel_agregar_nuevo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        btn_agregar_nuevo.setBackground(new java.awt.Color(255, 255, 255));
        btn_agregar_nuevo.setForeground(new java.awt.Color(255, 255, 255));
        btn_agregar_nuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btn_añadir.png"))); // NOI18N
        btn_agregar_nuevo.setToolTipText("Agregar registro");
        btn_agregar_nuevo.setBorder(null);
        btn_agregar_nuevo.setBorderPainted(false);
        btn_agregar_nuevo.setContentAreaFilled(false);
        btn_agregar_nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agregar_nuevoActionPerformed(evt);
            }
        });

        lbl_agregar_nuevo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_agregar_nuevo.setForeground(new java.awt.Color(0, 102, 0));
        lbl_agregar_nuevo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_agregar_nuevo.setText("Agregar nuevo");

        javax.swing.GroupLayout Panel_agregar_nuevoLayout = new javax.swing.GroupLayout(Panel_agregar_nuevo);
        Panel_agregar_nuevo.setLayout(Panel_agregar_nuevoLayout);
        Panel_agregar_nuevoLayout.setHorizontalGroup(
            Panel_agregar_nuevoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_agregar_nuevo, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
            .addGroup(Panel_agregar_nuevoLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(btn_agregar_nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Panel_agregar_nuevoLayout.setVerticalGroup(
            Panel_agregar_nuevoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_agregar_nuevoLayout.createSequentialGroup()
                .addComponent(lbl_agregar_nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_agregar_nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txt_1.setEditable(false);
        txt_1.setBackground(new java.awt.Color(255, 255, 255));
        txt_1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txt_1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), " ", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 8), new java.awt.Color(10, 76, 122))); // NOI18N
        txt_1.setEnabled(false);
        txt_1.setFocusable(false);
        txt_1.setNextFocusableComponent(txt_2);
        txt_1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_1KeyTyped(evt);
            }
        });

        txt_2.setEditable(false);
        txt_2.setBackground(new java.awt.Color(255, 255, 255));
        txt_2.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txt_2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), " ", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 8), new java.awt.Color(10, 76, 122))); // NOI18N
        txt_2.setFocusable(false);
        txt_2.setNextFocusableComponent(txt_3);
        txt_2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_2KeyTyped(evt);
            }
        });

        txt_3.setEditable(false);
        txt_3.setBackground(new java.awt.Color(255, 255, 255));
        txt_3.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txt_3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), " ", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 8), new java.awt.Color(10, 76, 122))); // NOI18N
        txt_3.setFocusable(false);
        txt_3.setNextFocusableComponent(txt_4);
        txt_3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_3KeyTyped(evt);
            }
        });

        txt_4.setEditable(false);
        txt_4.setBackground(new java.awt.Color(255, 255, 255));
        txt_4.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txt_4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), " ", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 8), new java.awt.Color(10, 76, 122))); // NOI18N
        txt_4.setFocusable(false);
        txt_4.setNextFocusableComponent(txt_5);
        txt_4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_4KeyTyped(evt);
            }
        });

        txt_5.setEditable(false);
        txt_5.setBackground(new java.awt.Color(255, 255, 255));
        txt_5.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txt_5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), " ", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 8), new java.awt.Color(10, 76, 122))); // NOI18N
        txt_5.setFocusable(false);
        txt_5.setNextFocusableComponent(txt_6);
        txt_5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_5KeyTyped(evt);
            }
        });

        txt_6.setEditable(false);
        txt_6.setBackground(new java.awt.Color(255, 255, 255));
        txt_6.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txt_6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), " ", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 8), new java.awt.Color(10, 76, 122))); // NOI18N
        txt_6.setFocusable(false);
        txt_6.setNextFocusableComponent(txt_7);
        txt_6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_6KeyTyped(evt);
            }
        });

        txt_7.setEditable(false);
        txt_7.setBackground(new java.awt.Color(255, 255, 255));
        txt_7.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txt_7.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), " ", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 8), new java.awt.Color(10, 76, 122))); // NOI18N
        txt_7.setFocusable(false);
        txt_7.setNextFocusableComponent(txt_8);
        txt_7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_7KeyTyped(evt);
            }
        });

        txt_8.setEditable(false);
        txt_8.setBackground(new java.awt.Color(255, 255, 255));
        txt_8.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txt_8.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), " ", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 8), new java.awt.Color(10, 76, 122))); // NOI18N
        txt_8.setFocusable(false);
        txt_8.setNextFocusableComponent(txt_9);
        txt_8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_8KeyTyped(evt);
            }
        });

        txt_9.setEditable(false);
        txt_9.setBackground(new java.awt.Color(255, 255, 255));
        txt_9.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txt_9.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), " ", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 8), new java.awt.Color(10, 76, 122))); // NOI18N
        txt_9.setFocusable(false);
        txt_9.setNextFocusableComponent(txta_1);
        txt_9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_9KeyTyped(evt);
            }
        });

        txt_10.setEditable(false);
        txt_10.setBackground(new java.awt.Color(255, 255, 255));
        txt_10.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txt_10.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), " ", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 8), new java.awt.Color(10, 76, 122))); // NOI18N
        txt_10.setFocusable(false);
        txt_10.setNextFocusableComponent(txt_11);
        txt_10.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_10KeyTyped(evt);
            }
        });

        txt_11.setEditable(false);
        txt_11.setBackground(new java.awt.Color(255, 255, 255));
        txt_11.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txt_11.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), " ", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 8), new java.awt.Color(10, 76, 122))); // NOI18N
        txt_11.setFocusable(false);
        txt_11.setNextFocusableComponent(txt_12);
        txt_11.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_11KeyTyped(evt);
            }
        });

        txt_12.setEditable(false);
        txt_12.setBackground(new java.awt.Color(255, 255, 255));
        txt_12.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txt_12.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), " ", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 8), new java.awt.Color(10, 76, 122))); // NOI18N
        txt_12.setFocusable(false);
        txt_12.setNextFocusableComponent(txt_13);
        txt_12.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_12KeyTyped(evt);
            }
        });

        txt_13.setEditable(false);
        txt_13.setBackground(new java.awt.Color(255, 255, 255));
        txt_13.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txt_13.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), " ", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 8), new java.awt.Color(10, 76, 122))); // NOI18N
        txt_13.setFocusable(false);
        txt_13.setNextFocusableComponent(txt_14);
        txt_13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_13ActionPerformed(evt);
            }
        });
        txt_13.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_13KeyTyped(evt);
            }
        });

        txt_14.setEditable(false);
        txt_14.setBackground(new java.awt.Color(255, 255, 255));
        txt_14.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txt_14.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), " ", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 8), new java.awt.Color(10, 76, 122))); // NOI18N
        txt_14.setFocusable(false);
        txt_14.setNextFocusableComponent(txt_15);
        txt_14.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_14KeyTyped(evt);
            }
        });

        txt_15.setEditable(false);
        txt_15.setBackground(new java.awt.Color(255, 255, 255));
        txt_15.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txt_15.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), " ", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 8), new java.awt.Color(10, 76, 122))); // NOI18N
        txt_15.setFocusable(false);
        txt_15.setNextFocusableComponent(txt_16);
        txt_15.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_15KeyTyped(evt);
            }
        });

        txt_16.setEditable(false);
        txt_16.setBackground(new java.awt.Color(255, 255, 255));
        txt_16.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txt_16.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), " ", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 8), new java.awt.Color(10, 76, 122))); // NOI18N
        txt_16.setFocusable(false);
        txt_16.setNextFocusableComponent(txt_17);
        txt_16.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_16KeyTyped(evt);
            }
        });

        txt_17.setEditable(false);
        txt_17.setBackground(new java.awt.Color(255, 255, 255));
        txt_17.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txt_17.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), " ", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 8), new java.awt.Color(10, 76, 122))); // NOI18N
        txt_17.setFocusable(false);
        txt_17.setNextFocusableComponent(txt_18);
        txt_17.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_17KeyTyped(evt);
            }
        });

        txt_18.setEditable(false);
        txt_18.setBackground(new java.awt.Color(255, 255, 255));
        txt_18.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txt_18.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), " ", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 8), new java.awt.Color(10, 76, 122))); // NOI18N
        txt_18.setFocusable(false);
        txt_18.setNextFocusableComponent(txta_2);
        txt_18.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_18KeyTyped(evt);
            }
        });

        txt_19.setEditable(false);
        txt_19.setBackground(new java.awt.Color(255, 255, 255));
        txt_19.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txt_19.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), " ", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 8), new java.awt.Color(10, 76, 122))); // NOI18N
        txt_19.setFocusable(false);
        txt_19.setNextFocusableComponent(txt_20);
        txt_19.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_19KeyTyped(evt);
            }
        });

        txt_20.setEditable(false);
        txt_20.setBackground(new java.awt.Color(255, 255, 255));
        txt_20.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txt_20.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), " ", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 8), new java.awt.Color(10, 76, 122))); // NOI18N
        txt_20.setFocusable(false);
        txt_20.setNextFocusableComponent(txt_21);
        txt_20.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_20KeyTyped(evt);
            }
        });

        txt_21.setEditable(false);
        txt_21.setBackground(new java.awt.Color(255, 255, 255));
        txt_21.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txt_21.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), " ", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 8), new java.awt.Color(10, 76, 122))); // NOI18N
        txt_21.setFocusable(false);
        txt_21.setNextFocusableComponent(txt_22);
        txt_21.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_21KeyTyped(evt);
            }
        });

        cmb_1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        cmb_1.setMaximumRowCount(100);
        cmb_1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), " ", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft YaHei UI Light", 1, 8), new java.awt.Color(10, 76, 122))); // NOI18N
        cmb_1.setEnabled(false);
        cmb_1.setFocusable(false);
        cmb_1.setNextFocusableComponent(cmb_2);

        Scroll_pane_txta_1.setFocusable(false);
        Scroll_pane_txta_1.setNextFocusableComponent(txt_10);

        txta_1.setEditable(false);
        txta_1.setColumns(20);
        txta_1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txta_1.setRows(5);
        txta_1.setAutoscrolls(false);
        txta_1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), " ", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft YaHei UI Light", 1, 8), new java.awt.Color(10, 76, 122))); // NOI18N
        txta_1.setNextFocusableComponent(txt_10);
        txta_1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txta_1KeyTyped(evt);
            }
        });
        Scroll_pane_txta_1.setViewportView(txta_1);

        Scroll_pane_txta_3.setNextFocusableComponent(btn_guardar);

        txta_3.setEditable(false);
        txta_3.setColumns(20);
        txta_3.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txta_3.setRows(5);
        txta_3.setAutoscrolls(false);
        txta_3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), " ", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft YaHei UI Light", 1, 8), new java.awt.Color(10, 76, 122))); // NOI18N
        txta_3.setFocusable(false);
        txta_3.setNextFocusableComponent(btn_guardar);
        txta_3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txta_3KeyTyped(evt);
            }
        });
        Scroll_pane_txta_3.setViewportView(txta_3);

        Scroll_pane_txta_2.setNextFocusableComponent(txt_19);

        txta_2.setEditable(false);
        txta_2.setColumns(20);
        txta_2.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txta_2.setRows(5);
        txta_2.setAutoscrolls(false);
        txta_2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), " ", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft YaHei UI Light", 1, 8), new java.awt.Color(10, 76, 122))); // NOI18N
        txta_2.setFocusable(false);
        txta_2.setMinimumSize(new java.awt.Dimension(180, 115));
        txta_2.setNextFocusableComponent(txt_19);
        txta_2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txta_2KeyTyped(evt);
            }
        });
        Scroll_pane_txta_2.setViewportView(txta_2);

        txt_22.setEditable(false);
        txt_22.setBackground(new java.awt.Color(255, 255, 255));
        txt_22.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txt_22.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), " ", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 8), new java.awt.Color(10, 76, 122))); // NOI18N
        txt_22.setFocusable(false);
        txt_22.setNextFocusableComponent(cmb_1);
        txt_22.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_22KeyTyped(evt);
            }
        });

        cmb_2.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        cmb_2.setMaximumRowCount(100);
        cmb_2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), " ", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft YaHei UI Light", 1, 8), new java.awt.Color(10, 76, 122))); // NOI18N
        cmb_2.setEnabled(false);
        cmb_2.setFocusable(false);
        cmb_2.setNextFocusableComponent(cmb_3);
        cmb_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_2ActionPerformed(evt);
            }
        });

        cmb_3.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        cmb_3.setMaximumRowCount(100);
        cmb_3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), " ", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft YaHei UI Light", 1, 8), new java.awt.Color(10, 76, 122))); // NOI18N
        cmb_3.setEnabled(false);
        cmb_3.setFocusable(false);
        cmb_3.setNextFocusableComponent(cmb_4);
        cmb_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_3ActionPerformed(evt);
            }
        });

        cmb_4.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        cmb_4.setMaximumRowCount(100);
        cmb_4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), " ", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft YaHei UI Light", 1, 8), new java.awt.Color(10, 76, 122))); // NOI18N
        cmb_4.setEnabled(false);
        cmb_4.setFocusable(false);
        cmb_4.setNextFocusableComponent(txta_3);

        javax.swing.GroupLayout Panel_cajas_de_textoLayout = new javax.swing.GroupLayout(Panel_cajas_de_texto);
        Panel_cajas_de_texto.setLayout(Panel_cajas_de_textoLayout);
        Panel_cajas_de_textoLayout.setHorizontalGroup(
            Panel_cajas_de_textoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_cajas_de_textoLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(Panel_cajas_de_textoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txt_9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Scroll_pane_txta_1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(Panel_cajas_de_textoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txt_18, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_17, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_16, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Scroll_pane_txta_2, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(Panel_cajas_de_textoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_19, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(Panel_cajas_de_textoLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(Panel_cajas_de_textoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_20, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_21, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_22, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(Panel_cajas_de_textoLayout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(Panel_cajas_de_textoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmb_1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmb_2, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmb_3, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmb_4, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Scroll_pane_txta_3, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(Panel_agregar_nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        Panel_cajas_de_textoLayout.setVerticalGroup(
            Panel_cajas_de_textoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_cajas_de_textoLayout.createSequentialGroup()
                .addGroup(Panel_cajas_de_textoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel_cajas_de_textoLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(Panel_cajas_de_textoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Panel_cajas_de_textoLayout.createSequentialGroup()
                                .addComponent(txt_1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Scroll_pane_txta_1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(Panel_cajas_de_textoLayout.createSequentialGroup()
                                .addComponent(txt_10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_11, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_12, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_13, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_14, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_15, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_16, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_17, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_18, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Scroll_pane_txta_2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(Panel_cajas_de_textoLayout.createSequentialGroup()
                                .addComponent(txt_19, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_20, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_21, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_22, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmb_1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmb_2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmb_3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmb_4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(Scroll_pane_txta_3, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(Panel_cajas_de_textoLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(Panel_agregar_nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15))
        );

        Panel_tabla_datos.setBackground(new java.awt.Color(255, 255, 255));
        Panel_tabla_datos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setToolTipText("");
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        Tabla_principal = new javax.swing.JTable(){
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        Tabla_principal.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        Tabla_principal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        Tabla_principal.setAutoscrolls(false);
        Tabla_principal.setGridColor(new java.awt.Color(0, 0, 0));
        Tabla_principal.setRowHeight(30);
        Tabla_principal.setRowMargin(2);
        Tabla_principal.setSelectionBackground(new java.awt.Color(50, 86, 122));
        Tabla_principal.setSelectionForeground(new java.awt.Color(251, 252, 252));
        Tabla_principal.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        Tabla_principal.setShowVerticalLines(false);
        Tabla_principal.getTableHeader().setReorderingAllowed(false);
        Tabla_principal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tabla_principalMouseClicked(evt);
            }
        });
        Tabla_principal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Tabla_principalKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(Tabla_principal);

        javax.swing.GroupLayout Panel_tabla_datosLayout = new javax.swing.GroupLayout(Panel_tabla_datos);
        Panel_tabla_datos.setLayout(Panel_tabla_datosLayout);
        Panel_tabla_datosLayout.setHorizontalGroup(
            Panel_tabla_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_tabla_datosLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1)
                .addGap(25, 25, 25))
        );
        Panel_tabla_datosLayout.setVerticalGroup(
            Panel_tabla_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_tabla_datosLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );

        Panel_titulo.setBackground(new java.awt.Color(10, 76, 122));
        Panel_titulo.setForeground(new java.awt.Color(255, 255, 255));

        lbl_titulo.setBackground(new java.awt.Color(10, 76, 122));
        lbl_titulo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_titulo.setForeground(new java.awt.Color(255, 255, 255));
        lbl_titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_titulo.setText("jLabel1");

        javax.swing.GroupLayout Panel_tituloLayout = new javax.swing.GroupLayout(Panel_titulo);
        Panel_titulo.setLayout(Panel_tituloLayout);
        Panel_tituloLayout.setHorizontalGroup(
            Panel_tituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_titulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        Panel_tituloLayout.setVerticalGroup(
            Panel_tituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_titulo, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout Panel_contenedor_pantallaLayout = new javax.swing.GroupLayout(Panel_contenedor_pantalla);
        Panel_contenedor_pantalla.setLayout(Panel_contenedor_pantallaLayout);
        Panel_contenedor_pantallaLayout.setHorizontalGroup(
            Panel_contenedor_pantallaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_contenedor_pantallaLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(Panel_contenedor_pantallaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Panel_cajas_de_texto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Panel_titulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Panel_busqueda_Y_botones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Panel_tabla_datos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10))
        );
        Panel_contenedor_pantallaLayout.setVerticalGroup(
            Panel_contenedor_pantallaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_contenedor_pantallaLayout.createSequentialGroup()
                .addComponent(Panel_titulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Panel_cajas_de_texto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Panel_busqueda_Y_botones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Panel_tabla_datos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel_barra_superior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(Panel_menu_principal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(Panel_sub_menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(Panel_contenedor_pantalla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Panel_barra_superior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Panel_contenedor_pantalla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(Panel_sub_menu, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Panel_menu_principal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(10, 10, 10))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    
    private static String tabla="NULL";//variable que almacena el modulo en uso del sistema.
    private static String tabla_secundaria="NULL";//variable que almacena el sub modulo en uso del sistema.
    private static String accion_bd="NULL";//variable que almacena la accion de mantenimiento en la base de datos.
    private static int num_columnas=0;
    private final int limite_texto_por_defecto=40;
    private final int limite_texto_id=13;
    private final int limite_texto_id_rtn=14;
    private final int limite_texto_celular=8;
    private final int limite_texto_correo=50;
    private final int limite_texto_fecha=10;
    private final int limite_texto_cantidad_entera=5;
    private final int limite_texto_cantidad_decimal=7;
    private final int limite_texto_num_factura=19;
    private final int limite_texto_num_cai=37;
    private final int limite_texto_direccion=70;
    private final int limite_texto_porcentaje=3;
    private final String mensaje_error_validacion="Error al validar los datos : \nVerifique nuevamente los campos marcados en color rojo.\n\n";
    private final String mensaje_error_num_id="Número de identidad incorrecto.\n";
    private final String mensaje_error_num_rtn="Número de RTN incorrecto.\n";
    private final String mensaje_error_num_id_rtn="Número de identidad/RTN incorrecto.\n";
    private final String mensaje_error_campo=" incorrecto,este campo solo admite letras y no más de un espacio consecutivo.\n";
    private final String mensaje_error_fecha=" con formato o rango incorrecto.\n";
    private final String mensaje_error_rango_fecha="Rango de fechas fuera del límite.\n";
    private final String mensaje_error_num_contacto="Número de contacto incorrecto.\n";
    private final String mensaje_error_correo="Formato de correo electrónico incorrecto.\n";
    private final String mensaje_error_nombre_usuario="Nombre de usuario debe contener de 8-32 caracteres,\n una mayúscula y un número.\n";
    private final String mensaje_error_cant_entera=" debe ser una cantidad entera.\n";
    private final String mensaje_error_cant_decimal=" con formato incorrecto o fuera de rango.\n";
    private final String mensaje_error_descuento="Descuento incorrecto (número entero).\n";
    private final String mensaje_error_seleccion="Debe selecionar un/una: ";
    private final String mensaje_error_duplicados=" asignado a otro registro.\n";
    private static String Consulta_mostrar_datos="";
    private static String Titulos_tabla[];
    private static String Titulos_base[];
    private static boolean Tabla_editable=true;
    private static String mensaje="";
    private final int cod_empleado_actual=clase_permisos.obtener_empleado_actual();
    
    /*
    funcion: inicializar_formulario
    Autores: Jose Julio 
    Version 1.0   24/06/2020
    permite dar formarto al diseño inicial del formulario principal.
    */
    private void inicializar_formulario(){ 
        restablecer_color_cajas_contenedoras();
       
        btn_administracion.setEnabled(false);
        btn_clientes.setEnabled(false);
        btn_colecciones.setEnabled(false);
        btn_productos.setEnabled(false);
        btn_materia_prima.setEnabled(false);
        btn_produccion.setEnabled(false);
        btn_compras.setEnabled(false);
        btn_ventas.setEnabled(false);
        btn_punto_de_venta.setEnabled(false);

        btn_sub_menu_1.setVisible(false);
        btn_sub_menu_2.setVisible(false);
        btn_sub_menu_3.setVisible(false);
        btn_sub_menu_4.setVisible(false);
        btn_sub_menu_5.setVisible(false);

        Panel_contenedor_pantalla.setVisible(false);

        btn_cancelar.setVisible(false);
        btn_guardar.setVisible(false);
        btn_imprimir.setVisible(false);
        btn_limpiar_busqueda.setVisible(false);

        Tabla_principal.setCellSelectionEnabled(false);
        Tabla_principal.setColumnSelectionAllowed(false);
        Tabla_principal.setRowSelectionAllowed(true);   
        lbl_usuario_actual.setText(clase_permisos.obtener_usuario_actual());
    };
    
    /*
    funcion: aplicar_permisos
    Autores: Erick,Victor
    Version 1.0   05/07/2020
    permite mostrar los modulos habilitados para el usuario, segun su nivel de acceso.
    */
    private final void aplicar_permisos(){
        
        if(clase_permisos.obtener_permiso_actual()==1){
            btn_administracion.setEnabled(true);
            btn_administracion.setVisible(true);
        }
        if(clase_permisos.obtener_permiso_actual()==2){
            btn_clientes.setEnabled(true);
            btn_clientes.setVisible(true);
        }
        if(clase_permisos.obtener_permiso_actual()==3){
            btn_colecciones.setEnabled(true);
            btn_colecciones.setVisible(true);
        }
        if(clase_permisos.obtener_permiso_actual()==4){
            btn_colecciones.setEnabled(true);
            btn_colecciones.setVisible(true);
            btn_productos.setEnabled(true);
            btn_productos.setVisible(true);
        }
        if(clase_permisos.obtener_permiso_actual()==5){
            btn_colecciones.setEnabled(true);
            btn_colecciones.setVisible(true);
            btn_materia_prima.setEnabled(true);
            btn_materia_prima.setVisible(true);
        }
        if(clase_permisos.obtener_permiso_actual()==6){
            btn_produccion.setEnabled(true);
            btn_produccion.setVisible(true);
            btn_productos.setEnabled(true);
            btn_productos.setVisible(true);
        }
        if(clase_permisos.obtener_permiso_actual()==7){
            btn_compras.setEnabled(true);
            btn_compras.setVisible(true);
            btn_materia_prima.setEnabled(true);
            btn_materia_prima.setVisible(true);
        }
        if(clase_permisos.obtener_permiso_actual()==8 || clase_permisos.obtener_permiso_actual()==9){
            btn_ventas.setEnabled(true);
            btn_ventas.setVisible(true);
            btn_punto_de_venta.setEnabled(true);
            btn_punto_de_venta.setVisible(true);
            btn_clientes.setEnabled(true);
            btn_clientes.setVisible(true);
        }
        if(clase_permisos.obtener_permiso_actual()==10){
            
            btn_administracion.setEnabled(true);
            btn_clientes.setEnabled(true);
            btn_colecciones.setEnabled(true);
            btn_productos.setEnabled(true);
            btn_materia_prima.setEnabled(true);
            btn_produccion.setEnabled(true);
            btn_compras.setEnabled(true);
            btn_ventas.setEnabled(true);
            btn_punto_de_venta.setEnabled(true);

            btn_administracion.setVisible(true);
            btn_clientes.setVisible(true);
            btn_colecciones.setVisible(true);
            btn_productos.setVisible(true);
            btn_materia_prima.setVisible(true);
            btn_produccion.setVisible(true);
            btn_compras.setVisible(true);
            btn_ventas.setVisible(true);
            btn_punto_de_venta.setVisible(true);
        }
    };
    
    /*
    funcion: restablecer_color_cajas_contenedoras
    Autores: Yuli
    Version 1.0   30/03/2020
    restablece a su color por defecto las cajas contenedoras de texto.
    */
    private void restablecer_color_cajas_contenedoras(){
        
        txt_1.setForeground(java.awt.Color.BLACK);
        txt_2.setForeground(java.awt.Color.BLACK);
        txt_3.setForeground(java.awt.Color.BLACK);
        txt_4.setForeground(java.awt.Color.BLACK);
        txt_5.setForeground(java.awt.Color.BLACK);
        txt_6.setForeground(java.awt.Color.BLACK);
        txt_7.setForeground(java.awt.Color.BLACK);
        txt_8.setForeground(java.awt.Color.BLACK);
        txt_9.setForeground(java.awt.Color.BLACK);
        txt_10.setForeground(java.awt.Color.BLACK);
        txt_11.setForeground(java.awt.Color.BLACK);
        txt_12.setForeground(java.awt.Color.BLACK);
        txt_13.setForeground(java.awt.Color.BLACK);
        txt_14.setForeground(java.awt.Color.BLACK);
        txt_15.setForeground(java.awt.Color.BLACK);
        txt_16.setForeground(java.awt.Color.BLACK);
        txt_17.setForeground(java.awt.Color.BLACK);
        txt_18.setForeground(java.awt.Color.BLACK);
        txt_19.setForeground(java.awt.Color.BLACK);
        txt_20.setForeground(java.awt.Color.BLACK);
        txt_21.setForeground(java.awt.Color.BLACK);
        txt_22.setForeground(java.awt.Color.BLACK);
        txta_1.setForeground(java.awt.Color.BLACK);
        txta_2.setForeground(java.awt.Color.BLACK);
        txta_3.setForeground(java.awt.Color.BLACK);
    }
    
    private void limpiar_cajas_contenedoras(){
        
        restablecer_color_cajas_contenedoras();
        
        txt_1.setText(null);
        txt_2.setText(null);
        txt_3.setText(null);
        txt_4.setText(null);
        txt_5.setText(null);
        txt_6.setText(null);
        txt_7.setText(null);
        txt_8.setText(null);
        txt_9.setText(null);
        txt_10.setText(null);
        txt_11.setText(null);
        txt_12.setText(null);
        txt_13.setText(null);
        txt_14.setText(null);
        txt_15.setText(null);
        txt_16.setText(null);
        txt_17.setText(null);
        txt_18.setText(null);
        txt_19.setText(null);
        txt_20.setText(null);
        txt_21.setText(null);
        txt_22.setText(null);
        txta_1.setText(null);
        txta_2.setText(null);
        txta_3.setText(null);
        txt_busqueda.setText(null);
        cmb_1.setSelectedIndex(-1);
        cmb_2.setSelectedIndex(-1);
        cmb_3.setSelectedIndex(-1);
        cmb_4.setSelectedIndex(-1);
        cmb_1.removeAllItems();
        cmb_2.removeAllItems();
        cmb_3.removeAllItems();
        cmb_4.removeAllItems();
    }; 
    
    private void deshabilitar_cajas_contenedoras(){
        txt_2.setEditable(false);
        txt_3.setEditable(false);
        txt_4.setEditable(false);
        txt_5.setEditable(false);
        txt_6.setEditable(false);
        txt_7.setEditable(false);
        txt_8.setEditable(false);
        txt_9.setEditable(false);
        txt_10.setEditable(false);
        txt_11.setEditable(false);
        txt_12.setEditable(false);
        txt_13.setEditable(false);
        txt_14.setEditable(false);
        txt_15.setEditable(false);
        txt_16.setEditable(false);
        txt_17.setEditable(false);
        txt_18.setEditable(false);
        txt_19.setEditable(false);
        txt_20.setEditable(false);
        txt_21.setEditable(false);
        txt_22.setEditable(false);
        txta_1.setEditable(false);
        txta_2.setEditable(false);
        txta_3.setEditable(false);
        cmb_1.setEnabled(false);
        cmb_2.setEnabled(false);
        cmb_3.setEnabled(false);
        cmb_4.setEnabled(false);
    };
    
    private void habilitar_cajas_contenedoras(){
        
        txt_2.setEditable(true);
        txt_3.setEditable(true);
        txt_4.setEditable(true);
        txt_5.setEditable(true);
        txt_6.setEditable(true);
        txt_7.setEditable(true);
        txt_8.setEditable(true);
        txt_9.setEditable(true);
        txt_10.setEditable(true);
        txt_11.setEditable(true);
        txt_12.setEditable(true);
        txt_13.setEditable(true);
        txt_14.setEditable(true);
        txt_15.setEditable(true);
        txt_16.setEditable(true);
        txt_17.setEditable(true);
        txt_18.setEditable(true);
        txt_19.setEditable(true);
        txt_20.setEditable(true);
        txt_21.setEditable(true);
        txt_22.setEditable(true);
        txta_1.setEditable(true);
        txta_2.setEditable(true);
        txta_3.setEditable(true);
        cmb_1.setEnabled(true);
        cmb_2.setEnabled(true);
        cmb_3.setEnabled(true);
        cmb_4.setEnabled(true); 
    }; 
    
    /*
    OPTIMIZACIÓN DE CÓDIGO
    Función: restabler_pantalla
    Autores: Yuli
    Version 1.0   30/06/2020 
    se elimino la duplicidad de código reduciendo el restablecimiento de pantalla
    a una solafunción.
    */
    private void restablecer_pantalla(){
        
        tabla="NULL";
        tabla_secundaria="NULL";
        num_columnas=0;
        Consulta_mostrar_datos="";
        Titulos_tabla=null;
        Titulos_base=null;

        accion_bd="NULL";

        txt_1.setVisible(false);
        txt_2.setVisible(false);
        txt_3.setVisible(false);
        txt_4.setVisible(false);
        txt_5.setVisible(false);
        txt_6.setVisible(false);
        txt_7.setVisible(false);
        txt_8.setVisible(false);
        txt_9.setVisible(false);
        txt_10.setVisible(false);
        txt_11.setVisible(false);
        txt_12.setVisible(false);
        txt_13.setVisible(false);
        txt_14.setVisible(false);
        txt_15.setVisible(false);
        txt_16.setVisible(false);
        txt_17.setVisible(false);
        txt_18.setVisible(false);
        txt_19.setVisible(false);
        txt_20.setVisible(false);
        txt_21.setVisible(false);
        txt_22.setVisible(false);
        
        txt_2.setEnabled(true);
        txt_3.setEnabled(true);
        txt_4.setEnabled(true);
        txt_5.setEnabled(true);
        txt_6.setEnabled(true);
        txt_7.setEnabled(true);
        txt_8.setEnabled(true);
        txt_9.setEnabled(true);
        txt_10.setEnabled(true);
        txt_11.setEnabled(true);
        txt_12.setEnabled(true);
        txt_13.setEnabled(true);
        txt_14.setEnabled(true);
        txt_15.setEnabled(true);
        txt_16.setEnabled(true);
        txt_17.setEnabled(true);
        txt_18.setEnabled(true);
        txt_19.setEnabled(true);
        txt_20.setEnabled(true);
        txt_21.setEnabled(true);
        txt_22.setEnabled(true);
        cmb_1.setEnabled(true);
        cmb_2.setEnabled(true);
        cmb_3.setEnabled(true);
        cmb_4.setEnabled(true);
        Scroll_pane_txta_1.setEnabled(true);
        Scroll_pane_txta_2.setEnabled(true);
        Scroll_pane_txta_3.setEnabled(true);
        txta_1.setEnabled(true);
        txta_2.setEnabled(true);
        txta_3.setEnabled(true);
        
        txt_1.setEditable(false);
        txt_2.setEditable(false);
        txt_3.setEditable(false);
        txt_4.setEditable(false);
        txt_5.setEditable(false);
        txt_6.setEditable(false);
        txt_7.setEditable(false);
        txt_8.setEditable(false);
        txt_9.setEditable(false);
        txt_10.setEditable(false);
        txt_11.setEditable(false);
        txt_12.setEditable(false);
        txt_13.setEditable(false);
        txt_14.setEditable(false);
        txt_15.setEditable(false);
        txt_16.setEditable(false);
        txt_17.setEditable(false);
        txt_18.setEditable(false);
        txt_19.setEditable(false);
        txt_20.setEditable(false);
        txt_21.setEditable(false);
        txt_22.setEditable(false);

        txt_1.setToolTipText(null);
        txt_2.setToolTipText(null);
        txt_3.setToolTipText(null);
        txt_4.setToolTipText(null);
        txt_5.setToolTipText(null);
        txt_6.setToolTipText(null);
        txt_7.setToolTipText(null);
        txt_8.setToolTipText(null);
        txt_9.setToolTipText(null);
        txt_10.setToolTipText(null);
        txt_11.setToolTipText(null);
        txt_12.setToolTipText(null);
        txt_13.setToolTipText(null);
        txt_14.setToolTipText(null);
        txt_15.setToolTipText(null);
        txt_16.setToolTipText(null);
        txt_17.setToolTipText(null);
        txt_18.setToolTipText(null);
        txt_19.setToolTipText(null);
        txt_20.setToolTipText(null);
        txt_21.setToolTipText(null);
        txt_22.setToolTipText(null);
        
        /*
        CORRECCIÓN DE ERROR
        Autores: Erick
        Version 1.0   03/07/2020 
        se corrigió la secuencia de navegación de las cajas de texto deshabilitando 
        la navegación en las cajas ocultas.
        */
        txt_1.setFocusable(false);
        txt_2.setFocusable(false);
        txt_3.setFocusable(false);
        txt_4.setFocusable(false);
        txt_5.setFocusable(false);
        txt_6.setFocusable(false);
        txt_7.setFocusable(false);
        txt_8.setFocusable(false);
        txt_9.setFocusable(false);
        txt_10.setFocusable(false);
        txt_11.setFocusable(false);
        txt_12.setFocusable(false);
        txt_13.setFocusable(false);
        txt_14.setFocusable(false);
        txt_15.setFocusable(false);
        txt_16.setFocusable(false);
        txt_17.setFocusable(false);
        txt_18.setFocusable(false);
        txt_19.setFocusable(false);
        txt_20.setFocusable(false);
        txt_21.setFocusable(false);
        txt_22.setFocusable(false);
        cmb_1.setFocusable(false);
        cmb_2.setFocusable(false);
        cmb_3.setFocusable(false);
        cmb_4.setFocusable(false);
        Scroll_pane_txta_1.setFocusable(false);
        Scroll_pane_txta_2.setFocusable(false);
        Scroll_pane_txta_3.setFocusable(false);
        txta_1.setFocusable(false);
        txta_2.setFocusable(false);
        txta_3.setFocusable(false);
        
        cmb_1.setVisible(false);
        cmb_2.setVisible(false);
        cmb_3.setVisible(false);
        cmb_4.setVisible(false);
        cmb_1.setEditable(false);
        cmb_2.setEditable(false);
        cmb_3.setEditable(false);
        cmb_4.setEditable(false);
        cmb_1.removeAllItems();
        cmb_2.removeAllItems();
        cmb_3.removeAllItems();
        cmb_4.removeAllItems();

        Scroll_pane_txta_1.setVisible(false);
        Scroll_pane_txta_2.setVisible(false);
        Scroll_pane_txta_3.setVisible(false);
        txta_1.setEditable(false);
        txta_2.setEditable(false);
        txta_3.setEditable(false);

        btn_modificar.setVisible(true);
        btn_eliminar.setVisible(false);

        Panel_cajas_de_texto.setVisible(true);

        btn_cancelar.setVisible(false);
        btn_guardar.setVisible(false);
        btn_limpiar_busqueda.setVisible(false);
        btn_modificar.setVisible(true);
        btn_eliminar.setVisible(true);
        btn_imprimir.setVisible(false);
        btn_busqueda.setEnabled(true);
        btn_agregar_nuevo.setEnabled(true);

        limpiar_cajas_contenedoras();
        deshabilitar_cajas_contenedoras();
    }
    
    /*
    funcion: restablecer_menu_principal.
    Autores: Victor
    Version 1.0   20/02/2020
    permite restablecer el diseño predeterminado del menu principal.
    */
     private void restablecer_menu_principal(){
        
        Tabla_editable=true;
        Tabla_principal.setEnabled(Tabla_editable);
        restablecer_color_cajas_contenedoras();
        
        btn_administracion.setBackground(new java.awt.Color(10, 76, 122));
        btn_clientes.setBackground(new java.awt.Color(10, 76, 122));
        btn_colecciones.setBackground(new java.awt.Color(10, 76, 122));
        btn_productos.setBackground(new java.awt.Color(10, 76, 122));
        btn_materia_prima.setBackground(new java.awt.Color(10, 76, 122));
        btn_produccion.setBackground(new java.awt.Color(10, 76, 122));
        btn_compras.setBackground(new java.awt.Color(10, 76, 122));
        btn_ventas.setBackground(new java.awt.Color(10, 76, 122));
        btn_punto_de_venta.setBackground(new java.awt.Color(10, 76, 122));
        
        btn_sub_menu_1.setVisible(false);
        btn_sub_menu_2.setVisible(false);
        btn_sub_menu_3.setVisible(false);
        btn_sub_menu_4.setVisible(false);
        btn_sub_menu_5.setVisible(false);
        
        Panel_contenedor_pantalla.setVisible(false);
        
        restablecer_pantalla();
    };
    /*
    funcion: restablecer_menu_principal.
    Autores: Yuli
    Version 1.0   20/02/2020
    permite restablecer el diseño predeterminado del sub menu.
    */
    private void restablecer_sub_menu(){
        
        Tabla_editable=true;
        Tabla_principal.setEnabled(Tabla_editable);

        restablecer_color_cajas_contenedoras();

        btn_sub_menu_1.setBackground(new java.awt.Color(195,51,51));
        btn_sub_menu_2.setBackground(new java.awt.Color(195,51,51));
        btn_sub_menu_3.setBackground(new java.awt.Color(195,51,51));
        btn_sub_menu_4.setBackground(new java.awt.Color(195,51,51));
        btn_sub_menu_5.setBackground(new java.awt.Color(195,51,51));

        restablecer_pantalla();
    };
    
    /*
    funcion: restablecer_menu_principal.
    Autores: Yuli
    Version 1.0   20/02/2020
    consulta y muestra en pantalla la información almacenada en la base de datos.
    */
    private void mostrar_datos_en_tabla(int num_columnas,String Titulos_tabla[],String Titulos_base[],String Consulta){
        
        
        try{
            conexion=clase_conexion.conectar();
            if(clase_conexion.obtener_estado_conexion()==true){
                String Datos[]=new String[num_columnas];
                defalut_table_model=new DefaultTableModel(null,Titulos_tabla);
                Statement statement_local=conexion.createStatement();
                ResultSet result_set_local=statement_local.executeQuery(Consulta);

                while(result_set_local.next()){
                    for(int contador_de_columnas=0;contador_de_columnas<num_columnas;contador_de_columnas++){
                        Datos[contador_de_columnas]=result_set_local.getString(Titulos_base[contador_de_columnas]);
                    }
                    defalut_table_model.addRow(Datos);
                }
                conexion=null;
                clase_conexion.cerrar_conexion();
                statement_local.close();
                result_set_local.close();
            }
            Tabla_principal.setModel(defalut_table_model);
            Tabla_principal.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
      }catch(SQLException e){
          
      }  
    };
    
    /*
    funciones: mostrar_datos_cmb_busqueda,llenar_cmb_1,llenar_cmb_2,llenar_cmb_3,llenar_cmb_4
    Autores: Julio
    Version 1.0   20/02/2020
    permiten consultar y llenar los combo box con informacion desde la base de datos.
    */
    private void mostrar_datos_cmb_busqueda(int num_columnas,String Titulos_tabla[]){
        
        cmb_busqueda.removeAllItems();
        for(int contador_filas=0;contador_filas<num_columnas;contador_filas++){
            cmb_busqueda.addItem(Titulos_tabla[contador_filas]);
        }
        cmb_busqueda.repaint();
        cmb_busqueda.setSelectedIndex(0);
    }
    
    private void llenar_cmb_1(String comando_sql){
        
        cmb_1.removeAllItems();
        try{
            conexion=clase_conexion.conectar();
            if(clase_conexion.obtener_estado_conexion()==true){
                CallableStatement callable_statement_local=conexion.prepareCall(comando_sql);
                ResultSet result_set_local=callable_statement_local.executeQuery();

                while(result_set_local.next()){
                    for(int contador_fila=0;contador_fila<1;contador_fila++){
                        cmb_1.addItem(result_set_local.getString(contador_fila+1).trim());
                    }
                    cmb_1.repaint();
                    cmb_1.setSelectedIndex(0);
                }
                conexion=null;
                clase_conexion.cerrar_conexion();
                callable_statement_local.close();
                result_set_local.close();
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(this,"Ocurrió un error al cargar datos en la lista desplegable(1) "+e,"ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void llenar_cmb_2(String comando_sql){
        
        cmb_2.removeAllItems();
        try{
            conexion=clase_conexion.conectar();
            if(clase_conexion.obtener_estado_conexion()==true){
                CallableStatement callable_statement_local=conexion.prepareCall(comando_sql);
                ResultSet result_set_local=callable_statement_local.executeQuery();

                while(result_set_local.next()){
                    for(int contador_filas=0;contador_filas<1;contador_filas++){
                        cmb_2.addItem(result_set_local.getString(contador_filas+1).trim());
                    }
                    cmb_2.repaint();
                    cmb_2.setSelectedIndex(0);
                }
                conexion=null;
                clase_conexion.cerrar_conexion();
                callable_statement_local.close();
                result_set_local.close();
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(this,"Ocurrió un error al cargar datos en la lista desplegable(2) "+e,"ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void llenar_cmb_3(String comando_sql){
        
        cmb_3.removeAllItems();
        try{
            conexion=clase_conexion.conectar();
            if(clase_conexion.obtener_estado_conexion()==true){
                CallableStatement callable_statement_local=conexion.prepareCall(comando_sql);
                ResultSet result_set_local=callable_statement_local.executeQuery();

                while(result_set_local.next()){
                    for(int contador_filas=0;contador_filas<1;contador_filas++){
                        cmb_3.addItem(result_set_local.getString(contador_filas+1).trim());
                    }
                    cmb_3.repaint();
                    cmb_3.setSelectedIndex(0);
                }
                conexion=null;
                clase_conexion.cerrar_conexion();
                callable_statement_local.close();
                result_set_local.close();
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(this,"Ocurrió un error al cargar datos en la lista desplegable(3) "+e,"ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void llenar_cmb_4(String comando_sql){
        
        cmb_4.removeAllItems();
        try{
            conexion=clase_conexion.conectar();
            if(clase_conexion.obtener_estado_conexion()==true){
                CallableStatement callable_statement_local=conexion.prepareCall(comando_sql);
                ResultSet result_set_local=callable_statement_local.executeQuery();

                while(result_set_local.next()){
                    for(int contador_filas=0;contador_filas<1;contador_filas++){
                        cmb_4.addItem(result_set_local.getString(contador_filas+1).trim());
                    }
                    cmb_4.repaint();
                    cmb_4.setSelectedIndex(0);
                }
                conexion=null;
                clase_conexion.cerrar_conexion();
                callable_statement_local.close();
                result_set_local.close();
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(this,"Ocurrió un error al cargar datos en la lista desplegable(4) "+e,"ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }
    /*
    funciones: consultar_codigo_de_registro,consultar_nombre_de_registro
    Autores: Jose
    Version 1.0   27/02/2020
    permiten consultar y retornar la informacion obtenida desde la base de datos.
    */
    public int consultar_codigo_de_registro(String Consulta){
        
        int codigo_registro=0;
        try{
            conexion=clase_conexion.conectar();
            if(clase_conexion.obtener_estado_conexion()==true){
                Statement statement_local=conexion.createStatement();
                ResultSet result_set_local=statement_local.executeQuery(Consulta);

                while(result_set_local.next()){
                    for(int contador_filas=0;contador_filas<1;contador_filas++){
                     codigo_registro=result_set_local.getInt(contador_filas+1);
                    }
                }
                conexion=null;
                clase_conexion.cerrar_conexion();
                statement_local.close();
                result_set_local.close();
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(this,"Ocurrió un error inesperado al consultar código "+e,"ERROR",JOptionPane.ERROR_MESSAGE);
        }
        return codigo_registro;
    }
    
    private String consultar_nombre_de_registro(String Consulta){
        
        String nombre="";
        try{
            conexion=clase_conexion.conectar();
            if(clase_conexion.obtener_estado_conexion()==true){
                Statement statement_local=conexion.createStatement();
                ResultSet result_set_local=statement_local.executeQuery(Consulta);

                while(result_set_local.next()){
                    for(int contador_filas=0;contador_filas<1;contador_filas++){
                     nombre=result_set_local.getString(contador_filas+1);
                    }
                }
                conexion=null;
                clase_conexion.cerrar_conexion();
                statement_local.close();
                result_set_local.close();
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(this,"Ocurrió un error inesperado al consultar nombre "+e,"ERROR",JOptionPane.ERROR_MESSAGE);
        }
        return nombre;
    }
    
    /*
    funcion: actualizar_pantalla
    Autores: Erick
    Version 1.0   08/03/2020
    permite refrescar la pantalla, luego de la accion realizada.
    */
    private void actualizar_pantalla(String accion_realizada){
        
        Tabla_editable=true;
        Tabla_principal.setEnabled(Tabla_editable);
        Tabla_principal.clearSelection();

        restablecer_color_cajas_contenedoras();

        btn_cancelar.setVisible(false);
        btn_guardar.setVisible(false);
        btn_modificar.setVisible(true);
        btn_eliminar.setVisible(false);
        btn_imprimir.setVisible(false);
        btn_busqueda.setEnabled(true);
        btn_agregar_nuevo.setEnabled(true);


        if(tabla.equals("Empleados") || tabla.equals("Proveedores") || tabla.equals("Usuarios") || tabla.equals("Datos_Organizacion")|| tabla.equals("Clientes") || tabla.equals("Colecciones")){
              btn_eliminar.setVisible(true);
        }
        if(tabla.equals("Productos_Venta")|| tabla.equals("Productos_Materia_Prima")){
             btn_eliminar.setVisible(true);
             btn_imprimir.setVisible(true);
        }
            
        limpiar_cajas_contenedoras();
        deshabilitar_cajas_contenedoras();
        mostrar_datos_cmb_busqueda(num_columnas,Titulos_tabla);
        accion_bd="NULL";
        mostrar_datos_en_tabla(num_columnas,Titulos_tabla,Titulos_base,Consulta_mostrar_datos);
        
        if(tabla.equals("Pedidos") || tabla.equals("Cotizacion")){
            JOptionPane.showMessageDialog(null,tabla+" guardado correctamente \nEspere el reporte a continuación... ","AVISO",JOptionPane.INFORMATION_MESSAGE);
        }else{
           JOptionPane.showMessageDialog(null,"Registro "+accion_realizada+" correctamente","AVISO",JOptionPane.INFORMATION_MESSAGE);
        }
             
    }
    
    /*
    funcion: eliminar_registro
    Autores: Jose
    Version 1.0   20/02/2020
    permiten hacer un cambio de estado en el regustro seleccionado.
    */
    private void eliminar_registro(String Tabla,String Campo,int Codigo){
        String comando;
        comando = "UPDATE "+Tabla+" SET cod_estado=7,[fecha_modificacion] = GETDATE() WHERE "+Campo+"=?";              
        try{
            conexion=clase_conexion.conectar();
            if(clase_conexion.obtener_estado_conexion()==true){
                prepared_statement=conexion.prepareStatement(comando);
                prepared_statement.setInt(1,Codigo);
                prepared_statement.executeUpdate();
                actualizar_pantalla(" Eliminado ");

                conexion=null;
                clase_conexion.cerrar_conexion();
                prepared_statement.close();
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error al eliminar registro, intente nuevamente "+ex,"ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /*
    funcion: calcular_total
    Autores: Jose
    Version 1.0   20/02/2020
    calcula y retorna el total a pagar de los pedidos y cotizaciones.
    */
    private Double calcular_total(String cantidad_cadena,String precio_cadena,String descuento_cadena){
    Double cantidad,precio,descuento,total;    
        try{
            cantidad=Double.parseDouble(cantidad_cadena);
            precio=Double.parseDouble(precio_cadena);
            descuento=Double.parseDouble(descuento_cadena);
            total=((cantidad*precio)-((cantidad*precio)*descuento));
            return total;
        }catch(Exception e){
            return 0.0;
        }
            
    }
    
    /*
    funcione: convertir_descuento
    Autores: Julio
    Version 1.0   20/02/2020
    convierte la cantidad de descuento a formato decimal.
    */
    private Double convertir_descuento(String descuento_cadena){
    Double descuento;    
        try{ 
            descuento=Double.parseDouble(descuento_cadena);
            descuento=descuento/100;
            return descuento;
        }catch(Exception e){
            return 0.0;
        }
            
    }
    
    /*
    OPTIMIZACIÓN DE CÓDIGO
    Función: busqueda_de_registros
    Autores: Julio
    Version 1.0  02/07/2020 
    se elimino la duplicidad de código reduciendo la busqueda de registros
    a una función.
    */
    private void busqueda_de_registros(){
        
        if(txt_busqueda.getText().length()<1 || cmb_busqueda.getSelectedIndex()<0){
            btn_limpiar_busqueda.setVisible(false);
            mostrar_datos_en_tabla(num_columnas,Titulos_tabla,Titulos_base,Consulta_mostrar_datos);  
            txt_busqueda.setText(null);
            cmb_busqueda.setSelectedIndex(0);
        }else{
            
            
            btn_limpiar_busqueda.setVisible(true);
            int index=-1;
            index=cmb_busqueda.getSelectedIndex();
            String Consulta_busqueda=" ";
            String campo_condicion=" ";
            String busqueda=txt_busqueda.getText();
            campo_condicion=Titulos_base[index];
            /*
            OPTIMIZACIÓN DE CÓDIGO
            Autores: Jose,Victor
            Version 1.0   29/06/2020 
            se elimino la duplicidad de código reduciendo la rutina a una desición
            que contiene elementos comunes.
            */
            if("Empleados".equals(tabla) ||
               "Inventario_Materia_Prima".equals(tabla) ||
                "Productos_Materia_Prima".equals(tabla) ||
                "Productos_Venta".equals(tabla) ||
                "Colecciones".equals(tabla) ||
                "Clientes".equals(tabla)||
                "Datos_Organizacion".equals(tabla)||
                "Tipos_de_Importe".equals(tabla)||
                "Usuarios".equals(tabla)||
                "Proveedores".equals(tabla) ||
                "Pedidos".equals(tabla) ||
                "Cotizacion".equals(tabla)){
                
                    Consulta_busqueda="SELECT "+"*"+" FROM "+tabla+" WHERE "+campo_condicion+" LIKE '%"+busqueda+"%' OR "+campo_condicion+"='"+busqueda+"'";
                    mostrar_datos_en_tabla(num_columnas,Titulos_tabla,Titulos_base,Consulta_busqueda); 
            }

            if("Stock_productos_vt".equals(tabla_secundaria)){
                Consulta_busqueda="SELECT cod_producto_vt,nombre_producto,stock,punto_reorden,IIF(stock>(punto_reorden+1),'','Producto Agotándose')as Aviso FROM Productos_Venta WHERE stock>0  AND "+campo_condicion+" LIKE '%"+busqueda+"%' OR "+campo_condicion+"='"+busqueda+"'";
                mostrar_datos_en_tabla(num_columnas,Titulos_tabla,Titulos_base,Consulta_busqueda); 
            }
            if("stock_productos_mt".equals(tabla_secundaria)){
                Consulta_busqueda=" SELECT [cod_producto_mt],[nombre],stock,punto_reorden,IIF(stock>(punto_reorden+1),'','Producto Agotándose')as Aviso FROM [Productos_Materia_Prima] WHERE stock>0  AND "+campo_condicion+" LIKE '%"+busqueda+"%' OR "+campo_condicion+"='"+busqueda+"'";
                mostrar_datos_en_tabla(num_columnas,Titulos_tabla,Titulos_base,Consulta_busqueda); 
            }
            if("Ordenes_Produccion".equals(tabla_secundaria)){
                Consulta_busqueda="SELECT "+
                " [cod_produccion],[fecha_orden],[cod_empleado],[cantidad_orden],[descripcion],[cod_producto_vt],[cod_estado],[fecha_modificacion]"
                +" FROM "+tabla+" WHERE cantidad_produccion IS NULL AND "+campo_condicion+" LIKE '%"+busqueda+"%' OR "+campo_condicion+"='"+busqueda+"'";
                mostrar_datos_en_tabla(num_columnas,Titulos_tabla,Titulos_base,Consulta_busqueda); 
            }
            if("Produccion_Produccion".equals(tabla_secundaria)){
                Consulta_busqueda="SELECT "+
            " [cod_produccion],[cod_empleado],[fecha_produccion_inicio],[fecha_produccion_fin],[cantidad_produccion],[descripcion],[cod_producto_vt],[cod_estado],[fecha_modificacion]"
            +" FROM "+tabla+" WHERE cantidad_produccion IS NOT NULL AND "+campo_condicion+" LIKE '%"+busqueda+"%' OR "+campo_condicion+"='"+busqueda+"'";
                mostrar_datos_en_tabla(num_columnas,Titulos_tabla,Titulos_base,Consulta_busqueda);
                    
            }
            if("Ordenes_Compras".equals(tabla_secundaria)){
                Consulta_busqueda="SELECT "+
                    " [cod_compra],[cod_proveedor],[cod_empleado] ,[fecha_orden],[cod_producto_mt],[cantidad_orden],[descripcion],[cod_estado],[fecha_modificacion]"
                    +" FROM "+tabla+" WHERE [cantidad_compra] IS NULL AND "+campo_condicion+" LIKE '%"+busqueda+"%' OR "+campo_condicion+"='"+busqueda+"'";
                mostrar_datos_en_tabla(num_columnas,Titulos_tabla,Titulos_base,Consulta_busqueda); 
            } 
            if("Compras_Compras".equals(tabla_secundaria)){
                Consulta_busqueda="SELECT cod_compra,cod_proveedor,cod_empleado,fecha_compra,cod_producto_mt,cantidad_compra,precio,n_referencia,descripcion,cod_estado,fecha_modificacion FROM "+tabla+" WHERE [cantidad_compra] IS NOT NULL AND "+campo_condicion+" LIKE '%"+busqueda+"%' OR "+campo_condicion+"='"+busqueda+"' OR "+campo_condicion+"="+busqueda;
                mostrar_datos_en_tabla(num_columnas,Titulos_tabla,Titulos_base,Consulta_busqueda); 
            }
             if("Factura".equals(tabla)){
                String Titulos_base_2[]={"F.[n_factura]","F.[numero_factura]","F.[cod_empleado]","C.[identificacion]","F.[fecha_emision]","F.[sub_total]","F.[importe_exonerado]","F.[importe_exento]","F.[importe_gravado_15%]","F.[isv_15%]","F.[descuento_y_rebajas]","(F.sub_total+F.[isv_15%]-F.[descuento_y_rebajas])","F.[tipo_pago]","F.[pago_efectivo]","F.[pago_POS]","F.[ref_electronica]","E.nombre"};
                campo_condicion=Titulos_base_2[index];
                
                if("F.[fecha_emision]".equals(campo_condicion)){
                    Consulta_busqueda="DECLARE @fecha datetime ='"+busqueda+"'; SELECT F.[n_factura],F.[numero_factura],F.[cod_empleado],C.[identificacion] as 'ID Cliente',F.[fecha_emision],F.[sub_total],F.[importe_exonerado] " +
                    ",F.[importe_exento],F.[importe_gravado_15%],F.[isv_15%],F.[descuento_y_rebajas] " +
                    ",(F.sub_total+F.[isv_15%]-F.[descuento_y_rebajas])AS 'TOTAL',F.[tipo_pago],F.[pago_efectivo],F.[pago_POS],F.[ref_electronica],E.nombre as 'Estado' " +
                    " FROM [GIBON].[dbo].[Factura] as F " +
                    " JOIN [dbo].[Clientes] as C ON C.cod_cliente=F.cod_cliente " +
                    " JOIN [dbo].[Estados] AS E ON E.cod_estado=F.cod_estado " +
                    " WHERE fecha_emision>=@fecha AND fecha_emision<dateadd(day, 1,@fecha)";
                    mostrar_datos_en_tabla(num_columnas,Titulos_tabla,Titulos_base,Consulta_busqueda); 
                }else{
                    Consulta_busqueda="SELECT F.[n_factura],F.[numero_factura],F.[cod_empleado],C.[identificacion] as 'ID Cliente',F.[fecha_emision],F.[sub_total],F.[importe_exonerado] " +
                    ",F.[importe_exento],F.[importe_gravado_15%],F.[isv_15%],F.[descuento_y_rebajas] " +
                    ",(F.sub_total+F.[isv_15%]-F.[descuento_y_rebajas])AS 'TOTAL',F.[tipo_pago],F.[pago_efectivo],F.[pago_POS],F.[ref_electronica],E.nombre as 'Estado' " +
                    " FROM [GIBON].[dbo].[Factura] as F " +
                    " JOIN [dbo].[Clientes] as C ON C.cod_cliente=F.cod_cliente " +
                    " JOIN [dbo].[Estados] AS E ON E.cod_estado=F.cod_estado " +
                    " WHERE "+campo_condicion+" LIKE '%"+busqueda+"%' OR "+campo_condicion+"='"+busqueda+"'";
                    mostrar_datos_en_tabla(num_columnas,Titulos_tabla,Titulos_base,Consulta_busqueda); 
                }
            }
            if("Detalle_Factura".equals(tabla)){
                String Titulos_base_2[]={"df.n_factura","df.cod_producto_vt","df.cantidad","pv.precio_unitario","df.descuento","df.sub_total"};
                campo_condicion=Titulos_base_2[index];
                Consulta_busqueda=" SELECT df.n_factura as codigo,df.cod_producto_vt as producto,df.cantidad as cant,pv.precio_unitario as precio,df.descuento as descu,df.sub_total as sub " +
                " FROM [dbo].[Detalle_Factura] as df JOIN [dbo].[Productos_Venta] as pv ON pv.cod_producto_vt=df.cod_producto_vt " +
                " WHERE "+campo_condicion+" LIKE '%"+busqueda+"%' OR "+campo_condicion+"='"+busqueda+"'";
                mostrar_datos_en_tabla(num_columnas,Titulos_tabla,Titulos_base,Consulta_busqueda); 
            }
            if("Cierre_diario_Caja".equals(tabla)){
                Consulta_busqueda="SELECT [cod_cierre],[fecha_Inicio] ,[fecha_cierre],[cod_empleado],[cambio_inicial],[total_efectivo] " +
                "      ,[total_efectivo_reportado],([total_efectivo]-([total_efectivo_reportado])) as'Diferencia Efectivo' " +
                "      ,[total_POS],[total_POS_reportado],([total_POS]-[total_POS_reportado]) as'Diferencia POS',[comentario],[cod_estado] " +
                "  FROM [GIBON].[dbo].[Cierre_diario_Caja] WHERE "+campo_condicion+" LIKE '%"+busqueda+"%' OR "+campo_condicion+"='"+busqueda+"'";
              mostrar_datos_en_tabla(num_columnas,Titulos_tabla,Titulos_base,Consulta_busqueda); 
            }
        } 
    }
    
    public void seleccionar_registro(int fila){

        if("Empleados".equals(tabla)){
            limpiar_cajas_contenedoras();
            txt_1.setText(String.valueOf(Tabla_principal.getValueAt(fila,0)).trim());
            txt_2.setText(String.valueOf(Tabla_principal.getValueAt(fila,3)).trim());
            txt_3.setText(String.valueOf(Tabla_principal.getValueAt(fila,1)).trim());
            txt_4.setText(String.valueOf(Tabla_principal.getValueAt(fila,2)).trim());
            txt_10.setText(String.valueOf(Tabla_principal.getValueAt(fila,4)).trim());
            txt_11.setText(String.valueOf(Tabla_principal.getValueAt(fila,5)).trim());
            txt_12.setText(String.valueOf(Tabla_principal.getValueAt(fila,6)).trim());
            txt_13.setText(String.valueOf(Tabla_principal.getValueAt(fila,7)).trim());
            txt_19.setText(String.valueOf(Tabla_principal.getValueAt(fila,10)).trim());
            txta_3.setText(String.valueOf(Tabla_principal.getValueAt(fila,8)).trim());
            cmb_1.addItem(consultar_nombre_de_registro("SELECT nombre FROM Estados WHERE cod_estado="+String.valueOf(Tabla_principal.getValueAt(fila,9))));
            cmb_1.setSelectedIndex(0);
            cmb_1.repaint();
        }
        if("Proveedores".equals(tabla)){
            limpiar_cajas_contenedoras();
            txt_1.setText(Tabla_principal.getValueAt(fila,0).toString().trim());
            txt_2.setText(Tabla_principal.getValueAt(fila,1).toString().trim());
            txt_3.setText(Tabla_principal.getValueAt(fila,2).toString().trim());
            txt_10.setText(Tabla_principal.getValueAt(fila,3).toString().trim());
            txt_11.setText(Tabla_principal.getValueAt(fila,4).toString().trim());
            txt_12.setText(Tabla_principal.getValueAt(fila,5).toString().trim());
            txt_19.setText(Tabla_principal.getValueAt(fila,8).toString().trim());
            txta_3.setText(Tabla_principal.getValueAt(fila,6).toString().trim());
            cmb_1.addItem(consultar_nombre_de_registro("SELECT nombre FROM Estados WHERE cod_estado="+String.valueOf(Tabla_principal.getValueAt(fila,7))));
            cmb_1.setSelectedIndex(0);
            cmb_1.repaint();
        }
        if("Usuarios".equals(tabla)){
            limpiar_cajas_contenedoras();
            txt_1.setText(Tabla_principal.getValueAt(fila,0).toString().trim());
            txt_2.setText(Tabla_principal.getValueAt(fila,1).toString().trim());
            txt_12.setText(Tabla_principal.getValueAt(fila,5).toString().trim());		   
            cmb_1.addItem(consultar_nombre_de_registro("SELECT nombre_nivel FROM Niveles_Acceso WHERE cod_nivel_acceso="+String.valueOf(Tabla_principal.getValueAt(fila,3))));
            cmb_1.setSelectedIndex(0);
            cmb_1.repaint();
            cmb_2.addItem(consultar_nombre_de_registro("SELECT nombre FROM Estados WHERE cod_estado="+String.valueOf(Tabla_principal.getValueAt(fila,4))));
            cmb_2.setSelectedIndex(0);
            cmb_2.repaint(); 		    
            cmb_3.addItem(consultar_nombre_de_registro("SELECT nombres FROM Empleados WHERE cod_empleado="+String.valueOf(Tabla_principal.getValueAt(fila,2))));
            cmb_3.setSelectedIndex(0);
            cmb_3.repaint();
        }
        if("Tipos_de_Importe".equals(tabla)){
            limpiar_cajas_contenedoras();
            txt_1.setText(Tabla_principal.getValueAt(fila,0).toString().trim());
            txt_2.setText(Tabla_principal.getValueAt(fila,1).toString().trim());
            txt_10.setText(Tabla_principal.getValueAt(fila,2).toString().trim());
            txta_2.setText(Tabla_principal.getValueAt(fila,3).toString().trim());		    
            cmb_1.addItem(consultar_nombre_de_registro("SELECT nombre FROM Estados WHERE cod_estado="+String.valueOf(Tabla_principal.getValueAt(fila,4)).trim()));
            cmb_1.setSelectedIndex(0);
            cmb_1.repaint();
        }
        if("Datos_Organizacion".equals(tabla)){
            limpiar_cajas_contenedoras();
            txt_1.setText(Tabla_principal.getValueAt(fila,0).toString().trim());
            txt_2.setText(Tabla_principal.getValueAt(fila,1).toString().trim());
            txt_3.setText(Tabla_principal.getValueAt(fila,2).toString().trim());
            txt_4.setText(Tabla_principal.getValueAt(fila,3).toString().trim());
            txt_5.setText(Tabla_principal.getValueAt(fila,4).toString().trim());
            txt_6.setText(Tabla_principal.getValueAt(fila,5).toString().trim());
            txt_7.setText(Tabla_principal.getValueAt(fila,6).toString().trim());
            txt_8.setText(Tabla_principal.getValueAt(fila,7).toString().trim()); 
            txt_10.setText(Tabla_principal.getValueAt(fila,8).toString().trim());
            txt_11.setText(Tabla_principal.getValueAt(fila,9).toString().trim());
            txt_12.setText(Tabla_principal.getValueAt(fila,10).toString().trim());
            txt_13.setText(Tabla_principal.getValueAt(fila,11).toString().trim());
            txt_14.setText(Tabla_principal.getValueAt(fila,12).toString().trim()); 
            txt_15.setText(Tabla_principal.getValueAt(fila,13).toString().trim());
            txt_16.setText(Tabla_principal.getValueAt(fila,14).toString().trim());
            txt_19.setText(Tabla_principal.getValueAt(fila,15).toString().trim());
            txt_20.setText(Tabla_principal.getValueAt(fila,16).toString().trim());
            txt_21.setText(Tabla_principal.getValueAt(fila,17).toString().trim()); 
            txt_22.setText(Tabla_principal.getValueAt(fila,22).toString().trim()); 
            txta_1.setText(Tabla_principal.getValueAt(fila,18).toString().trim());
            txta_2.setText(Tabla_principal.getValueAt(fila,19).toString().trim());
            txta_3.setText(Tabla_principal.getValueAt(fila,20).toString().trim());
            cmb_1.addItem(consultar_nombre_de_registro("SELECT nombre FROM Estados WHERE cod_estado="+String.valueOf(Tabla_principal.getValueAt(fila,21)).trim()));
            cmb_1.setSelectedIndex(0);
            cmb_1.repaint();
        }
        if("Clientes".equals(tabla)){
            limpiar_cajas_contenedoras();
            txt_1.setText(String.valueOf(Tabla_principal.getValueAt(fila,0)).trim());
            txt_2.setText(String.valueOf(Tabla_principal.getValueAt(fila,2)).trim());
            txt_3.setText(String.valueOf(Tabla_principal.getValueAt(fila,3)).trim());
            txt_10.setText(String.valueOf(Tabla_principal.getValueAt(fila,1)).trim());
            txt_11.setText(String.valueOf(Tabla_principal.getValueAt(fila,4)).trim());
            txt_12.setText(String.valueOf(Tabla_principal.getValueAt(fila,5)).trim());
            txt_19.setText(String.valueOf(Tabla_principal.getValueAt(fila,7)).trim());
            txta_3.setText(String.valueOf(Tabla_principal.getValueAt(fila,6)).trim());
            cmb_1.addItem(consultar_nombre_de_registro("SELECT nombre FROM Estados WHERE cod_estado="+String.valueOf(Tabla_principal.getValueAt(fila,8)).trim()));
            cmb_1.setSelectedIndex(0);
            cmb_1.repaint();
        }
        if("Colecciones".equals(tabla)){
            limpiar_cajas_contenedoras();
            txt_1.setText(String.valueOf(Tabla_principal.getValueAt(fila,0)).trim());
            txt_2.setText(String.valueOf(Tabla_principal.getValueAt(fila,1)).trim());
            txta_1.setText(String.valueOf(Tabla_principal.getValueAt(fila,2)).trim());
            txt_10.setText(String.valueOf(Tabla_principal.getValueAt(fila,4)).trim());
            txt_11.setText(String.valueOf(Tabla_principal.getValueAt(fila,5)).trim());
            txt_12.setText(String.valueOf(Tabla_principal.getValueAt(fila,6)).trim());
            cmb_1.addItem(consultar_nombre_de_registro("SELECT nombre FROM Estados WHERE cod_estado="+String.valueOf(Tabla_principal.getValueAt(fila,3)).trim()));
            cmb_1.setSelectedIndex(0);
            cmb_1.repaint();
        }
         if("Productos_Venta".equals(tabla)){
            limpiar_cajas_contenedoras();
            txt_1.setText(Tabla_principal.getValueAt(fila,0).toString().trim());
            txt_2.setText(Tabla_principal.getValueAt(fila,2).toString().trim());
            txta_2.setText(Tabla_principal.getValueAt(fila,3).toString().trim());
            txt_3.setText(String.valueOf(clase_validaciones.redondear_decimales(Double.parseDouble(Tabla_principal.getValueAt(fila,4).toString().trim()))));
            txt_4.setText(String.valueOf(clase_validaciones.redondear_decimales(Double.parseDouble(Tabla_principal.getValueAt(fila,5).toString().trim()))));
            txt_10.setText(Tabla_principal.getValueAt(fila,6).toString().trim());
            txt_11.setText(Tabla_principal.getValueAt(fila,7).toString().trim());
            txt_12.setText(Tabla_principal.getValueAt(fila,10).toString().trim());
            cmb_1.addItem(consultar_nombre_de_registro("SELECT nombre_coleccion FROM Colecciones WHERE cod_coleccion="+String.valueOf(Tabla_principal.getValueAt(fila,1)).trim()));
            cmb_1.setSelectedIndex(0);
            cmb_1.repaint();
            cmb_2.addItem(consultar_nombre_de_registro("SELECT nombre FROM Estados WHERE cod_estado="+String.valueOf(Tabla_principal.getValueAt(fila,8)).trim()));
            cmb_2.setSelectedIndex(0);
            cmb_2.repaint();
            cmb_3.addItem(consultar_nombre_de_registro("SELECT nombre FROM Tipos_de_Importe WHERE cod_tipo_importe="+String.valueOf(Tabla_principal.getValueAt(fila,9)).trim()));
            cmb_3.setSelectedIndex(0);
            cmb_3.repaint();
        }
         if("Productos_Materia_Prima".equals(tabla)){
            limpiar_cajas_contenedoras();
            txt_1.setText(Tabla_principal.getValueAt(fila,0).toString().trim());
            txt_2.setText(Tabla_principal.getValueAt(fila,1).toString().trim());
            txta_2.setText(Tabla_principal.getValueAt(fila,2).toString().trim());
            txt_3.setText(String.valueOf(clase_validaciones.redondear_decimales(Double.parseDouble(Tabla_principal.getValueAt(fila,3).toString().trim()))));
            txt_10.setText(Tabla_principal.getValueAt(fila,5).toString().trim());
            txt_11.setText(Tabla_principal.getValueAt(fila,6).toString().trim());
            txt_20.setText(Tabla_principal.getValueAt(fila,8).toString().trim());
            cmb_1.addItem(consultar_nombre_de_registro("SELECT nombre FROM Estados WHERE cod_estado="+String.valueOf(Tabla_principal.getValueAt(fila,7)).trim()));
            cmb_1.setSelectedIndex(0);
            cmb_1.repaint();
            cmb_2.addItem(Tabla_principal.getValueAt(fila,4).toString().trim());
            cmb_2.setSelectedIndex(0);
            cmb_2.repaint();
        }
         if("Inventario_Materia_Prima".equals(tabla)){
            limpiar_cajas_contenedoras();
            txt_1.setText(Tabla_principal.getValueAt(fila,0).toString().trim());
            txt_2.setText(Tabla_principal.getValueAt(fila,1).toString().trim());
            txt_3.setText(Tabla_principal.getValueAt(fila,3).toString().trim());
            txt_10.setText(Tabla_principal.getValueAt(fila,4).toString().trim());
            txt_11.setText(Tabla_principal.getValueAt(fila,6).toString().trim());                    
            cmb_1.addItem(Tabla_principal.getValueAt(fila,2).toString().trim());
            cmb_1.setSelectedIndex(0);
            cmb_1.repaint();
            cmb_2.addItem(consultar_nombre_de_registro("SELECT nombre FROM Productos_Materia_Prima WHERE cod_producto_mt="+String.valueOf(Tabla_principal.getValueAt(fila,5)).trim()));
            cmb_2.setSelectedIndex(0);
            cmb_2.repaint();		
            cmb_3.addItem(consultar_nombre_de_registro("SELECT nombre FROM Estados WHERE cod_estado="+String.valueOf(Tabla_principal.getValueAt(fila,7)).trim()));
            cmb_3.setSelectedIndex(0);
            cmb_3.repaint();
        }
         if("Ordenes_Produccion".equals(tabla_secundaria)){
            limpiar_cajas_contenedoras();
            txt_1.setText(Tabla_principal.getValueAt(fila,0).toString().trim());
            txt_2.setText(Tabla_principal.getValueAt(fila,1).toString().trim());
            txt_3.setText(Tabla_principal.getValueAt(fila,2).toString().trim());
            txt_10.setText(Tabla_principal.getValueAt(fila,3).toString().trim());
            txt_11.setText(Tabla_principal.getValueAt(fila,4).toString().trim());
            txt_12.setText(Tabla_principal.getValueAt(fila,7).toString().trim());
            cmb_1.addItem(consultar_nombre_de_registro("SELECT nombre_producto FROM Productos_Venta WHERE cod_producto_vt="+String.valueOf(Tabla_principal.getValueAt(fila,5)).trim()));
            cmb_1.setSelectedIndex(0);
            cmb_1.repaint();
            cmb_2.addItem(consultar_nombre_de_registro("SELECT nombre FROM Estados WHERE cod_estado="+String.valueOf(Tabla_principal.getValueAt(fila,6)).trim()));
            cmb_2.setSelectedIndex(0);
            cmb_2.repaint();
        }
         if("Produccion_Produccion".equals(tabla_secundaria)){
            limpiar_cajas_contenedoras();
            txt_1.setText(Tabla_principal.getValueAt(fila,0).toString().trim());
            txt_2.setText(Tabla_principal.getValueAt(fila,1).toString().trim());
            txt_3.setText(Tabla_principal.getValueAt(fila,2).toString().trim());
            txt_10.setText(Tabla_principal.getValueAt(fila,3).toString().trim());
            txt_11.setText(Tabla_principal.getValueAt(fila,4).toString().trim());
            txt_12.setText(Tabla_principal.getValueAt(fila,5).toString().trim());
            txt_19.setText(Tabla_principal.getValueAt(fila,8).toString().trim());                  
            cmb_1.addItem(consultar_nombre_de_registro("SELECT nombre_producto FROM Productos_Venta WHERE cod_producto_vt="+String.valueOf(Tabla_principal.getValueAt(fila,6)).trim()));
            cmb_1.setSelectedIndex(0);
            cmb_1.repaint();
            cmb_2.addItem(consultar_nombre_de_registro("SELECT nombre FROM Estados WHERE cod_estado="+String.valueOf(Tabla_principal.getValueAt(fila,7)).trim()));
            cmb_2.setSelectedIndex(0);
            cmb_2.repaint();
        }
        if("Ordenes_Compras".equals(tabla_secundaria)){
            limpiar_cajas_contenedoras();
            txt_1.setText(Tabla_principal.getValueAt(fila,0).toString().trim());
            txt_2.setText(Tabla_principal.getValueAt(fila,2).toString().trim());
            txt_3.setText(Tabla_principal.getValueAt(fila,3).toString().trim());
            txt_10.setText(Tabla_principal.getValueAt(fila,6).toString().trim());
            txt_11.setText(Tabla_principal.getValueAt(fila,5).toString().trim());
            txt_12.setText(Tabla_principal.getValueAt(fila,8).toString().trim());
            cmb_1.addItem(consultar_nombre_de_registro("SELECT nombre FROM Proveedores WHERE cod_proveedor="+String.valueOf(Tabla_principal.getValueAt(fila,1)).trim()));
            cmb_1.setSelectedIndex(0);
            cmb_1.repaint();
            cmb_2.addItem(consultar_nombre_de_registro("SELECT nombre FROM Productos_Materia_Prima WHERE cod_producto_mt="+String.valueOf(Tabla_principal.getValueAt(fila,4)).trim()));
            cmb_2.setSelectedIndex(0);
            cmb_2.repaint();
            cmb_3.addItem(consultar_nombre_de_registro("SELECT nombre FROM Estados WHERE cod_estado="+String.valueOf(Tabla_principal.getValueAt(fila,7)).trim()));
            cmb_3.setSelectedIndex(0);
            cmb_3.repaint();
        } 
         if("Compras_Compras".equals(tabla_secundaria)){
            limpiar_cajas_contenedoras();                     
            txt_1.setText(Tabla_principal.getValueAt(fila,0).toString().trim());
            txt_2.setText(Tabla_principal.getValueAt(fila,2).toString().trim());
            txt_3.setText(Tabla_principal.getValueAt(fila,3).toString().trim());
            txt_4.setText(Tabla_principal.getValueAt(fila,5).toString().trim());
            txt_10.setText(String.valueOf(clase_validaciones.redondear_decimales(Double.parseDouble(Tabla_principal.getValueAt(fila,6).toString().trim()))));
            txt_11.setText(Tabla_principal.getValueAt(fila,7).toString().trim());
            txt_12.setText(Tabla_principal.getValueAt(fila,8).toString().trim());
            txt_13.setText(Tabla_principal.getValueAt(fila,10).toString().trim());                  
            cmb_1.addItem(consultar_nombre_de_registro("SELECT nombre FROM Proveedores WHERE cod_proveedor="+String.valueOf(Tabla_principal.getValueAt(fila,1)).trim()));
            cmb_1.setSelectedIndex(0);
            cmb_1.repaint();
            cmb_2.addItem(consultar_nombre_de_registro("SELECT nombre FROM Productos_Materia_Prima WHERE cod_producto_mt="+String.valueOf(Tabla_principal.getValueAt(fila,4)).trim()));
            cmb_2.setSelectedIndex(0);
            cmb_2.repaint();
            cmb_3.addItem(consultar_nombre_de_registro("SELECT nombre FROM Estados WHERE cod_estado="+String.valueOf(Tabla_principal.getValueAt(fila,9)).trim()));
            cmb_3.setSelectedIndex(0);
            cmb_3.repaint();
        }
        /*
        OPTIMIZACIÓN DE CÓDIGO:

        Responsable: Jose Hernandez
        Fecha: 2020-06-29 
        Version:1.0 

        Se redujo a una sola desición las tablas pedidos y cotizaciones  
        */ 
        if("Pedidos".equals(tabla) || "Cotizacion".equals(tabla)){
            //Limpiar y cargar nuevos datos a cajas contenedoras
            limpiar_cajas_contenedoras();
            txt_1.setText(Tabla_principal.getValueAt(fila,0).toString().trim());
            txt_2.setText(Tabla_principal.getValueAt(fila,1).toString().trim());
            txt_3.setText(Tabla_principal.getValueAt(fila,2).toString().trim());
            txt_4.setText(Tabla_principal.getValueAt(fila,3).toString().trim());
            txt_10.setText(Tabla_principal.getValueAt(fila,6).toString().trim());
            txt_11.setText(String.valueOf(clase_validaciones.redondear_decimales(Double.parseDouble(Tabla_principal.getValueAt(fila,7).toString().trim()))));
            txt_12.setText(Tabla_principal.getValueAt(fila,8).toString().trim());
            txt_13.setText(String.valueOf(clase_validaciones.redondear_decimales(calcular_total(txt_10.getText(),txt_11.getText(),txt_12.getText())))); 
            txt_12.setText(String.valueOf(Double.parseDouble(Tabla_principal.getValueAt(fila,8).toString().trim())*100)+" %");
            cmb_1.addItem(consultar_nombre_de_registro("SELECT nombre_producto FROM Productos_Venta WHERE cod_producto_vt="+String.valueOf(Tabla_principal.getValueAt(fila,4)).trim()));
            cmb_1.setSelectedIndex(0);
            cmb_1.repaint();
            cmb_2.addItem(consultar_nombre_de_registro("SELECT nombre FROM Estados WHERE cod_estado="+String.valueOf(Tabla_principal.getValueAt(fila,5)).trim()));
            cmb_2.setSelectedIndex(0);
            cmb_2.repaint();
        }
        mostrar_datos_cmb_busqueda(num_columnas,Titulos_tabla);
    }
    
    private void btn_administracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_administracionActionPerformed
        
        restablecer_menu_principal();
        restablecer_sub_menu();
        
        btn_administracion.setBackground(new java.awt.Color(195,51,51));
       
        btn_sub_menu_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/administracion_empleados.png")));
        btn_sub_menu_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/administracion_proveedores.png")));
        btn_sub_menu_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/administracion_usuarios.png")));
        btn_sub_menu_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/produccion_ordenes.png")));
        btn_sub_menu_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/administracion_configuracion.png"))); 
        
        btn_sub_menu_1.setText("Empleados");
        btn_sub_menu_2.setText("Proveedores");
        btn_sub_menu_3.setText("Usuarios");
        btn_sub_menu_4.setText("Tipos de Importe");
        btn_sub_menu_5.setText("Configuración");
        
        btn_sub_menu_1.setVisible(true);
        btn_sub_menu_2.setVisible(true);
        btn_sub_menu_3.setVisible(true);
        btn_sub_menu_4.setVisible(true);
        btn_sub_menu_5.setVisible(true);
        
    }//GEN-LAST:event_btn_administracionActionPerformed

    private void btn_clientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clientesActionPerformed
        
        restablecer_menu_principal();
        restablecer_sub_menu();
        
        btn_clientes.setBackground(new java.awt.Color(195,51,51));
        Panel_contenedor_pantalla.setVisible(true);
        
        lbl_titulo.setText("CLIENTES");
        tabla="Clientes";

        txt_1.setVisible(true);
        txt_1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "CÓDIGO :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));
        txt_2.setVisible(true);
        txt_2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "NOMBRES :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));
        txt_2.setFocusable(true);
        txt_3.setVisible(true);
        txt_3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "APELLIDOS :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122))); 
        txt_3.setFocusable(true);
        txt_10.setVisible(true);
        txt_10.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "NÚMERO DE IDENTIDAD/RTN :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));
        txt_10.setToolTipText("Número de ID/RTN: ID(13 dígitos) / RTN(14 dígitos)");
        txt_10.setFocusable(true);
        txt_11.setVisible(true);
        txt_11.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "NÚMERO DE CONTACTO :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));
        txt_11.setToolTipText("Número de contacto sin guiones: 99887766");
        txt_11.setFocusable(true);
        txt_12.setVisible(true);
        txt_12.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "CORREO ELECTRÓNICO :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));
        txt_12.setToolTipText("Ejemplo: direccion@gmail.com ");
        txt_12.setFocusable(true);
        txt_19.setVisible(true);
        txt_19.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "FECHA MODIFICACIÓN :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(153,153,153)));
        txt_19.setFocusable(true);
        cmb_1.setVisible(true);
        cmb_1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "ESTADO :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));
        cmb_1.setFocusable(true);
        Scroll_pane_txta_3.setVisible(true);
        Scroll_pane_txta_3.setFocusable(true);
        txta_3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "DIRECCIÓN :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));
        txta_3.setFocusable(true);
        
        
        num_columnas=9;
        String Titulos_tabla_2[]={"Código","Identifiacion","Nombres","Apellidos","Numero de contacto","Correo electrónico","Dirección","Fecha de modificación","Estado"};
        String Titulos_base_2[]={"cod_cliente","identificacion","nombres","apellidos","celular","correo_electronico","direccion","fecha_modificacion","cod_estado"};
        Titulos_tabla=Titulos_tabla_2;
        Titulos_base=Titulos_base_2;
        Consulta_mostrar_datos="SELECT "+" * "+" FROM "+tabla+" WHERE cod_estado!=7 ORDER BY cod_cliente DESC";
        mostrar_datos_en_tabla(num_columnas,Titulos_tabla,Titulos_base,Consulta_mostrar_datos);
        mostrar_datos_cmb_busqueda(num_columnas,Titulos_tabla);
        
        btn_eliminar.setVisible(true);
    }//GEN-LAST:event_btn_clientesActionPerformed

    private void btn_coleccionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_coleccionesActionPerformed
        
        restablecer_menu_principal();
        restablecer_sub_menu();
        
        btn_colecciones.setBackground(new java.awt.Color(195,51,51));
        Panel_contenedor_pantalla.setVisible(true);

        lbl_titulo.setText("COLECCIONES");
        tabla="Colecciones";
        
        txt_1.setVisible(true);
        txt_1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "CÓDIGO :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));
        txt_2.setVisible(true);
        txt_2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "NOMBRE :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));
        txt_2.setFocusable(true);
        Scroll_pane_txta_1.setVisible(true);
        Scroll_pane_txta_1.setFocusable(true);
        txta_1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "DESCRIPCIÓN :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));
        txta_1.setFocusable(true);
        txt_10.setVisible(true);
        txt_10.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "FECHA DE INICIO :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122))); 
        txt_10.setToolTipText("Formato de fecha: año-mes-día (2020-12-31)");
        txt_10.setFocusable(true);
        txt_11.setVisible(true);
        txt_11.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "FECHA DE FIN :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));
        txt_11.setToolTipText("Formato de fecha: año-mes-día (2020-12-31)");
        txt_11.setFocusable(true);
        txt_12.setVisible(true);
        txt_12.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "FECHA MODIFICACIÓN :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(153,153,153)));
        txt_12.setFocusable(true);
        cmb_1.setVisible(true);
        cmb_1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "ESTADO :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));
        cmb_1.setFocusable(true);


        num_columnas=7;
        String Titulos_tabla_2[]={"Código","Nombre","Descripción","Estado","Fecha de inicio","Fecha de fin","Fecha de modificación"};
        String Titulos_base_2[]={"cod_coleccion","nombre_coleccion","descripcion_coleccion","cod_estado","fecha_inicio","fecha_fin","fecha_modificacion"};
        Titulos_tabla=Titulos_tabla_2;
        Titulos_base=Titulos_base_2;
        Consulta_mostrar_datos="SELECT "+" * "+" FROM "+tabla+" WHERE cod_estado!=7 ORDER BY cod_coleccion DESC";
        mostrar_datos_en_tabla(num_columnas,Titulos_tabla,Titulos_base,Consulta_mostrar_datos);
        mostrar_datos_cmb_busqueda(num_columnas,Titulos_tabla);

        btn_eliminar.setVisible(true);
    }//GEN-LAST:event_btn_coleccionesActionPerformed

    private void btn_sub_menu_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sub_menu_1ActionPerformed

        restablecer_sub_menu();

        btn_sub_menu_1.setBackground(new java.awt.Color(51,51,51));
        Panel_contenedor_pantalla.setVisible(true);

        lbl_titulo.setText(btn_sub_menu_1.getText().toUpperCase());

        if(btn_sub_menu_1.getText()=="Empleados"){

            tabla="Empleados";
            
            txt_1.setVisible(true);
            txt_1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "CÓDIGO :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));
            txt_2.setVisible(true);
            txt_2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "NÚMERO DE IDENTIDAD :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));
            txt_2.setToolTipText("Número de identidad sin guiones");
            txt_2.setFocusable(true);
            txt_3.setVisible(true);
            txt_3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "NOMBRES :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));
            txt_3.setFocusable(true);
            txt_4.setVisible(true);
            txt_4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "APELLIDOS :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));
            txt_4.setFocusable(true);
            txt_10.setVisible(true);
            txt_10.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "FECHA DE NACIMIENTO :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));
            txt_10.setToolTipText("Formato de fecha: año-mes-día (2020-12-31)");
            txt_10.setFocusable(true);
            txt_11.setVisible(true);
            txt_11.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "FECHA DE CONTRATACIÓN :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));
            txt_11.setToolTipText("Formato de fecha: año-mes-día (2020-12-31)");
            txt_11.setFocusable(true);
            txt_12.setVisible(true);
            txt_12.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "NÚMERO DE CONTACTO :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));
            txt_12.setToolTipText("Número de contacto sin guiones: 99887766");
            txt_12.setFocusable(true);
            txt_13.setVisible(true);
            txt_13.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "CORREO ELECTRÓNICO :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));
            txt_13.setToolTipText("Ejemplo: direccion@gmail.com ");
            txt_13.setFocusable(true);
            txt_19.setVisible(true);
            txt_19.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "FECHA DE MODIFICACIÓN :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(153,153,153)));
            txt_19.setFocusable(true);
            cmb_1.setVisible(true);
            cmb_1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "ESTADO :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));
            cmb_1.setFocusable(true);
            Scroll_pane_txta_3.setVisible(true);
            Scroll_pane_txta_3.setFocusable(true);
            txta_3.setFocusable(true);
            txta_3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "DIRECCIÓN :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));
            
            num_columnas=11;
            String Titulos_tabla_2 []={"Código","Nombres","Apellidos","Número ID","Fecha de nacimiento","Fecha de contratación","Número de contacto","Correo electrónico","Dirección","Estado","Fecha de modificación"};
            String Titulos_base_2[]={"cod_empleado","nombres","apellidos","num_identidad","fecha_nacimiento","fecha_contratacion","celular","correo_electronico","direccion","cod_estado","fecha_modificacion"};
            Titulos_tabla=Titulos_tabla_2;
            Titulos_base=Titulos_base_2;
            Consulta_mostrar_datos="SELECT "+"*"+" FROM "+tabla+" WHERE cod_estado!=7 ORDER BY cod_empleado DESC";
            mostrar_datos_en_tabla(num_columnas,Titulos_tabla,Titulos_base,Consulta_mostrar_datos);   
            mostrar_datos_cmb_busqueda(num_columnas,Titulos_tabla);
            
            btn_eliminar.setVisible(true);
        }
        if(btn_sub_menu_1.getText()=="Ordenes Compras"){

            tabla="Compras";
            tabla_secundaria="Ordenes_Compras";
            
            txt_1.setVisible(true);
            txt_1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "CÓDIGO :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));
            txt_2.setVisible(true);
            txt_2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "EMPLEADO :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(153,153,153)));
            txt_2.setFocusable(true);
            txt_3.setVisible(true);
            txt_3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "FECHA DE ORDEN :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(153,153,153)));
            txt_3.setFocusable(true);
            txt_10.setVisible(true);
            txt_10.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "DESCRIPCIÓN :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));
            txt_10.setFocusable(true);
            txt_11.setVisible(true);
            txt_11.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "CANTIDAD DE ORDEN :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));
            txt_11.setFocusable(true);
            txt_12.setVisible(true);
            txt_12.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "FECHA DE MODIFICACIÓN :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(153,153,153)));
            txt_12.setFocusable(true);
            cmb_1.setVisible(true);
            cmb_1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "PROVEEDOR :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));
            cmb_1.setFocusable(true);
            cmb_2.setVisible(true);
            cmb_2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "PRODUCTO :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));
            cmb_2.setFocusable(true);
            cmb_3.setVisible(true);
            cmb_3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "ESTADO :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));
            cmb_3.setFocusable(true);
            

            num_columnas=9;
            Consulta_mostrar_datos="SELECT "+
                    "[cod_compra],[cod_proveedor],[cod_empleado] ,[fecha_orden],[cod_producto_mt],[cantidad_orden],[descripcion],[cod_estado],[fecha_modificacion]"
                    +" FROM "+tabla+" WHERE [cantidad_compra] IS NULL AND cod_estado!=7 ORDER BY cod_compra DESC";
            String Titulos_tabla_2[]={"Código","Código de proveedor","Código de empleado","Fecha de orden","Producto materia prima","Cantidad","Descripción","Estado","Fecha de modificación"};
            String Titulos_base_2[]={"cod_compra","cod_proveedor","cod_empleado","fecha_orden","cod_producto_mt","cantidad_orden","descripcion","cod_estado","fecha_modificacion"};
            Titulos_tabla=Titulos_tabla_2;
            Titulos_base=Titulos_base_2;
            mostrar_datos_en_tabla(num_columnas,Titulos_tabla,Titulos_base,Consulta_mostrar_datos);
            mostrar_datos_cmb_busqueda(num_columnas,Titulos_tabla);  

            btn_eliminar.setVisible(false);
        }       
        if(btn_sub_menu_1.getText()=="Ordenes"){

            tabla="Produccion";
            tabla_secundaria="Ordenes_Produccion";
            
            txt_1.setVisible(true);
            txt_1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "CÓDIGO :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));
            txt_2.setVisible(true);
            txt_2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "FECHA DE ORDEN :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(153,153,153)));
            txt_2.setFocusable(true);
            txt_3.setVisible(true);
            txt_3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "EMPLEADO :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(153,153,153)));
            txt_3.setFocusable(true);
            txt_10.setVisible(true);
            txt_10.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "CANTIDAD :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));
            txt_10.setFocusable(true);
            txt_11.setVisible(true);
            txt_11.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "DESCRIPCIÓN :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));
            txt_11.setFocusable(true);
            txt_12.setVisible(true);
            txt_12.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "FECHA DE MODIFICACIÓN :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(153,153,153)));
            txt_12.setFocusable(true);
            cmb_1.setVisible(true);
            cmb_1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "PRODUCTO :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));
            cmb_1.setFocusable(true);
            cmb_2.setVisible(true);
            cmb_2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "ESTADO :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));        
            cmb_2.setFocusable(true);
            
            num_columnas=8;
            Consulta_mostrar_datos="SELECT "+
            "[cod_produccion],[fecha_orden],[cod_empleado],[cantidad_orden],[descripcion],[cod_producto_vt],[cod_estado],[fecha_modificacion]"
            +" FROM "+tabla+" WHERE cantidad_produccion IS NULL AND cod_estado!=7 ORDER BY cod_produccion DESC";
            String Titulos_tabla_2[]={"Código","Fecha de orden","Empleado","Cantidad","Descripción","Producto","Estado","Fecha de modificación"};
            String Titulos_base_2[]={"cod_produccion","fecha_orden","cod_empleado","cantidad_orden","descripcion","cod_producto_vt","cod_estado","fecha_modificacion"};
            Titulos_tabla=Titulos_tabla_2;
            Titulos_base=Titulos_base_2;
            mostrar_datos_en_tabla(num_columnas,Titulos_tabla,Titulos_base,Consulta_mostrar_datos); 
            mostrar_datos_cmb_busqueda(num_columnas,Titulos_tabla);

            btn_eliminar.setVisible(false);
        }
        if(btn_sub_menu_1.getText()=="Ventas"){
            lbl_titulo.setText("VENTAS DEL DÍA Y BÚSQUEDA DE FACTURAS");
            tabla="Factura";

            Panel_cajas_de_texto.setVisible(false);
            btn_modificar.setVisible(false);
            btn_eliminar.setVisible(false);

            num_columnas=17;
            String Titulos_tabla_2[]={"Código","Número de factura","Empleado","ID cliente","Fecha de emisión","Subtotal","Importe exonerado","Importe exento","Importe gravado 15%", "Impuesto sobre ventas 15%", "Descuentos y rebajas","Total","Tipo de pago", "Pago en efectivo", "Pago POS", "Número de referencia","Estado"};
            String Titulos_base_2[]={"n_factura","numero_factura","cod_empleado","ID Cliente","fecha_emision","sub_total","importe_exonerado","importe_exento","importe_gravado_15%","isv_15%","descuento_y_rebajas","TOTAL","tipo_pago","pago_efectivo","pago_POS","ref_electronica","Estado"};
            Titulos_tabla=Titulos_tabla_2;
            Titulos_base=Titulos_base_2;
            Consulta_mostrar_datos="SELECT F.[n_factura],F.[numero_factura],F.[cod_empleado],C.[identificacion] as 'ID Cliente',F.[fecha_emision],F.[sub_total],F.[importe_exonerado] " +
                ",F.[importe_exento],F.[importe_gravado_15%],F.[isv_15%],F.[descuento_y_rebajas] " +
                ",(F.sub_total+F.[isv_15%]-F.[descuento_y_rebajas])AS 'TOTAL',F.[tipo_pago],F.[pago_efectivo],F.[pago_POS],F.[ref_electronica],E.nombre as 'Estado' " +
                " FROM [GIBON].[dbo].[Factura] as F " +
                " JOIN [dbo].[Clientes] as C ON C.cod_cliente=F.cod_cliente " +
                " JOIN [dbo].[Estados] AS E ON E.cod_estado=F.cod_estado " +
                " WHERE convert(varchar(8),fecha_emision,112)= Convert(varchar(8),GetDate(),112) ORDER BY F.[n_factura] DESC";
            mostrar_datos_en_tabla(num_columnas,Titulos_tabla,Titulos_base,Consulta_mostrar_datos);
            Tabla_principal.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            mostrar_datos_cmb_busqueda(num_columnas,Titulos_tabla);
        }
        if(btn_sub_menu_1.getText()=="Productos Venta"){

            tabla="Productos_Venta";
            
            txt_1.setVisible(true);
            txt_1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "CÓDIGO :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));
            txt_2.setVisible(true);
            txt_2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "NOMBRE :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));
            txt_2.setFocusable(true);
            Scroll_pane_txta_2.setVisible(true);
            Scroll_pane_txta_2.setFocusable(true);
            txta_2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "DESCRIPCIÓN :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));
            txta_2.setFocusable(true);
            txt_3.setVisible(true);
            txt_3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "PRECIO UNITARIO :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));
            txt_3.setFocusable(true);
            txt_4.setVisible(true);
            txt_4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "COSTO UNITARIO :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));
            txt_4.setFocusable(true);
            txt_10.setVisible(true);
            txt_10.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "STOCK :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));
            txt_10.setFocusable(true);
            txt_11.setVisible(true);
            txt_11.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "PUNTO DE REORDEN :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));
            txt_11.setFocusable(true);
            txt_12.setVisible(true);
            txt_12.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "FECHA DE MODIFICACIÓN :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(153,153,153)));
            txt_12.setFocusable(true);
            cmb_1.setVisible(true);
            cmb_1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "COLECCIÓN :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));    
            cmb_1.setFocusable(true);
            cmb_2.setVisible(true);
            cmb_2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "ESTADO :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));
            cmb_2.setFocusable(true);
            cmb_3.setVisible(true);
            cmb_3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "TIPO DE IMPORTE :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));
            cmb_3.setFocusable(true);
            
            num_columnas=11;
            Consulta_mostrar_datos="SELECT "+" * "+" FROM "+tabla;
            String Titulos_tabla_2[]={"Código","Colección","Nombre","Descripción","Precio unitario","Costo unitario","Stock","Punto de reorden","Estado","Tipo de importe","Fecha de modificación"};
            String Titulos_base_2[]={"cod_producto_vt","cod_coleccion","nombre_producto","descripcion_producto","precio_unitario","costo_unitario","stock","punto_reorden","cod_estado","cod_tipo_importe","fecha_modificacion"};
            Titulos_tabla=Titulos_tabla_2;
            Titulos_base=Titulos_base_2;
            Consulta_mostrar_datos="SELECT "+"*"+" FROM "+tabla+" WHERE cod_estado!=7 ORDER BY cod_producto_vt DESC";
            mostrar_datos_en_tabla(num_columnas,Titulos_tabla,Titulos_base,Consulta_mostrar_datos);
            mostrar_datos_cmb_busqueda(num_columnas,Titulos_tabla);

            btn_eliminar.setVisible(true);
            btn_imprimir.setVisible(true);
        }
        if(btn_sub_menu_1.getText()=="Productos"){

            lbl_titulo.setText(lbl_titulo.getText()+" MATERIA PRIMA");
            tabla="Productos_Materia_Prima";
            
            txt_1.setVisible(true);
            txt_1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "CÓDIGO :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));
            txt_2.setVisible(true);
            txt_2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "NOMBRE :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));
            txt_2.setFocusable(true);
            Scroll_pane_txta_2.setVisible(true);
            Scroll_pane_txta_2.setFocusable(true);
            txta_2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "DESCRIPCIÓN :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));
            txta_2.setFocusable(true);
            txt_3.setVisible(true);
            txt_3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "PRECIO UNITARIO :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));
            txt_3.setFocusable(true);
            txt_10.setVisible(true);
            txt_10.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "STOCK :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));
            txt_10.setFocusable(true);
            txt_11.setVisible(true);
            txt_11.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "PUNTO DE REORDEN :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));
            txt_11.setFocusable(true);
            txt_20.setVisible(true);
            txt_20.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "FECHA DE MODIFICACIÓN :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(153,153,153)));
            txt_20.setFocusable(true);
            cmb_1.setVisible(true);
            cmb_1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "ESTADO :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));
            cmb_1.setFocusable(true);
            cmb_2.setVisible(true);
            cmb_2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "TIPO DE UNIDAD :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));
            cmb_2.setFocusable(true);
            
            num_columnas=9;
            Consulta_mostrar_datos="SELECT "+" * "+" FROM "+tabla;
            String Titulos_tabla_2[]={"Código","Nombre","Descripción","Precio unitario","Tipo de unidad","Stock","Punto de reorden","Estado","Fecha de modificación"};
            String Titulos_base_2[]={"cod_producto_mt","nombre","descripcion","precio_unitario","tipo_unidad","stock","punto_reorden","cod_estado","fecha_modificacion"};
            Titulos_tabla=Titulos_tabla_2;
            Titulos_base=Titulos_base_2;
            Consulta_mostrar_datos="SELECT "+"*"+" FROM "+tabla+" WHERE cod_estado!=7 ORDER BY cod_producto_mt DESC";
            mostrar_datos_en_tabla(num_columnas,Titulos_tabla,Titulos_base,Consulta_mostrar_datos);
            mostrar_datos_cmb_busqueda(num_columnas,Titulos_tabla);

            btn_eliminar.setVisible(true);
            btn_imprimir.setVisible(true);
        }
    }//GEN-LAST:event_btn_sub_menu_1ActionPerformed

    private void btn_productosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_productosActionPerformed

        restablecer_menu_principal();
        restablecer_sub_menu();

        btn_productos.setBackground(new java.awt.Color(195,51,51));

        btn_sub_menu_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/productos_productos.png")));
        btn_sub_menu_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/productos_stock.png")));
        btn_sub_menu_1.setText("Productos Venta");
        btn_sub_menu_2.setText("Stock");
        btn_sub_menu_1.setVisible(true);
        btn_sub_menu_2.setVisible(true);
        
    }//GEN-LAST:event_btn_productosActionPerformed

    private void btn_materia_primaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_materia_primaActionPerformed

        restablecer_menu_principal();
        restablecer_sub_menu();
        
        btn_materia_prima.setBackground(new java.awt.Color(195,51,51));
        
        btn_sub_menu_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/materia_prima_productos.png")));
        btn_sub_menu_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/materia_prima_inventario.png")));
        btn_sub_menu_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/productos_stock.png")));

        btn_sub_menu_1.setText("Productos");
        btn_sub_menu_2.setText("Inventario");
        btn_sub_menu_3.setText("Stock MP");

        btn_sub_menu_1.setVisible(true);
        btn_sub_menu_2.setVisible(true);
        btn_sub_menu_3.setVisible(true);

    }//GEN-LAST:event_btn_materia_primaActionPerformed

    private void btn_produccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_produccionActionPerformed

        restablecer_menu_principal();
        restablecer_sub_menu();
        
        btn_produccion.setBackground(new java.awt.Color(195,51,51));

        btn_sub_menu_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/produccion_ordenes.png")));
        btn_sub_menu_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/produccion_produccion.png")));

        btn_sub_menu_1.setText("Ordenes");
        btn_sub_menu_2.setText("Producción");
        btn_sub_menu_1.setVisible(true);
        btn_sub_menu_2.setVisible(true);
        
    }//GEN-LAST:event_btn_produccionActionPerformed

    private void btn_comprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_comprasActionPerformed

        restablecer_menu_principal();
        restablecer_sub_menu();
        
        btn_compras.setBackground(new java.awt.Color(195,51,51));
        
        btn_sub_menu_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/compras_ordenes.png")));
        btn_sub_menu_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/compras_compras.png")));
        btn_sub_menu_1.setText("Ordenes Compras");
        btn_sub_menu_2.setText("Compras");
        
        btn_sub_menu_1.setVisible(true);
        btn_sub_menu_2.setVisible(true);
        
    }//GEN-LAST:event_btn_comprasActionPerformed

    private void btn_ventasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ventasActionPerformed

        restablecer_menu_principal();
        restablecer_sub_menu();
        
        btn_ventas.setBackground(new java.awt.Color(195,51,51));
        
        btn_sub_menu_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ventas_ventas.png")));
        btn_sub_menu_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ventas_ventas.png")));
        btn_sub_menu_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ventas_pedidos.png")));
        btn_sub_menu_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ventas_cotizaciones.png")));
        btn_sub_menu_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/compras_ordenes.png")));

        btn_sub_menu_1.setText("Ventas");
        btn_sub_menu_2.setText("Detalle de Ventas");
        btn_sub_menu_3.setText("Pedidos");
        btn_sub_menu_4.setText("Cotizaciones");
        btn_sub_menu_5.setText("Cierre de Caja");

        btn_sub_menu_1.setVisible(true);
        btn_sub_menu_2.setVisible(true);
        btn_sub_menu_3.setVisible(true);
        btn_sub_menu_4.setVisible(true);
        btn_sub_menu_5.setVisible(true);
    }//GEN-LAST:event_btn_ventasActionPerformed

    private void btn_sub_menu_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sub_menu_2ActionPerformed

        restablecer_sub_menu();

        btn_sub_menu_2.setBackground(new java.awt.Color(51,51,51));
        Panel_contenedor_pantalla.setVisible(true);
        lbl_titulo.setText(btn_sub_menu_2.getText().toUpperCase());

        if(btn_sub_menu_2.getText()=="Proveedores"){

            tabla="Proveedores";
            
            txt_1.setVisible(true);
            txt_1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "CÓDIGO :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));
            txt_2.setVisible(true);
            txt_2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "IDENTIFICACIÓN (ID/RTN) :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));
            txt_2.setToolTipText("Número de ID/RTN: 0000000000000 ID(13) / RTN(14)");
            txt_2.setFocusable(true);
            txt_3.setVisible(true);
            txt_3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "NOMBRE :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));
            txt_3.setFocusable(true);
            txt_10.setVisible(true);
            txt_10.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "NOMBRE DE CONTACTO :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));
            txt_10.setFocusable(true);
            txt_11.setVisible(true);
            txt_11.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "NÚMERO DE CONTACTO :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));
            txt_11.setToolTipText("Formato de celular: XXXXXXXX (99887766)");
            txt_11.setFocusable(true);
            txt_12.setVisible(true);
            txt_12.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "CORREO ELECTRÓNICO :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));
            txt_12.setToolTipText("Ejemplo: direccion@gmail.com ");
            txt_12.setFocusable(true);
            txt_19.setVisible(true);
            txt_19.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "FECHA DE MODIFICACIÓN :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(153,153,153)));
            txt_19.setFocusable(true);
            cmb_1.setVisible(true);
            cmb_1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "ESTADO :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));
            cmb_1.setFocusable(true);
            Scroll_pane_txta_3.setVisible(true);
            Scroll_pane_txta_3.setFocusable(true);
            txta_3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "DIRECCIÓN :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));
            txta_3.setFocusable(true);
            
            num_columnas=9;
            String Titulos_tabla_2[]={"Código","Identificación (ID/RTN)","Nombre","Nombre de contacto","Número de contacto","Correo electronico","Dirección","Estado","Fecha de modiciación"};
            String Titulos_base_2[]={"cod_proveedor","n_identificacion","nombre","nombre_contacto","celular","correo_electronico","direccion","cod_estado","fecha_modificacion"};
            Titulos_tabla=Titulos_tabla_2;
            Titulos_base=Titulos_base_2;
            Consulta_mostrar_datos="SELECT "+"*"+" FROM "+tabla+" WHERE cod_estado!=7 ORDER BY cod_proveedor DESC";
            mostrar_datos_en_tabla(num_columnas,Titulos_tabla,Titulos_base,Consulta_mostrar_datos);
            mostrar_datos_cmb_busqueda(num_columnas,Titulos_tabla);

            btn_eliminar.setVisible(true);
        }
        if(btn_sub_menu_2.getText()=="Compras"){

            tabla="Compras";
            tabla_secundaria="Compras_Compras";
            
            txt_1.setVisible(true);
            txt_1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "CÓDIGO :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));
            txt_2.setVisible(true);
            txt_2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "EMPLEADO :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(153,153,153)));
            txt_2.setFocusable(true);
            txt_3.setVisible(true);
            txt_3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "FECHA DE COMPRA :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(153,153,153)));
            txt_3.setFocusable(true);
            txt_4.setVisible(true);
            txt_4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "CANTIDAD DE COMPRA :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));
            txt_4.setFocusable(true);
            txt_10.setVisible(true);
            txt_10.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "PRECIO :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));
            txt_10.setFocusable(true);
            txt_11.setVisible(true);
            txt_11.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "Nº DE FACTURA /(REF) :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));
            txt_11.setFocusable(true);
            txt_12.setVisible(true);
            txt_12.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "CAI :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));
            txt_12.setToolTipText("Formato: AB67S9-CJ7FE9-MDO98D-B87A9C-Z8X7ZX-C5");
            txt_12.setFocusable(true);
            txt_13.setVisible(true);
            txt_13.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "FECHA MODIFICACIÓN :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(153,153,153)));
            txt_13.setFocusable(true);
            cmb_1.setVisible(true);
            cmb_1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "PROVEEDOR :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));
            cmb_1.setFocusable(true);
            cmb_2.setVisible(true);
            cmb_2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "PRODUCTO :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));
            cmb_2.setFocusable(true);
            cmb_3.setVisible(true);
            cmb_3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "ESTADO :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));
            cmb_3.setFocusable(true);
            cmb_4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "CÓDIGO DE ORDEN: ", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));
            cmb_4.setFocusable(true);
            
            num_columnas=11;
            Consulta_mostrar_datos="SELECT cod_compra,cod_proveedor,cod_empleado,fecha_compra,cod_producto_mt,cantidad_compra,precio,n_referencia,descripcion,cod_estado,fecha_modificacion FROM "+tabla+" WHERE [cantidad_compra] IS NOT NULL AND cod_estado!=7 ORDER BY cod_compra DESC ";
            String Titulos_tabla_2[]={"Código","Proveedor","Empleado","Fecha de compra","Código de producto","Cantidad de compra","Precio","Número de factura","CAI","Estado","Fecha de modificación"};
            String Titulos_base_2[]={"cod_compra","cod_proveedor","cod_empleado","fecha_compra","cod_producto_mt","cantidad_compra","precio","n_referencia","descripcion","cod_estado","fecha_modificacion"};
            Titulos_tabla=Titulos_tabla_2;
            Titulos_base=Titulos_base_2;
            mostrar_datos_en_tabla(num_columnas,Titulos_tabla,Titulos_base,Consulta_mostrar_datos);  
            mostrar_datos_cmb_busqueda(num_columnas,Titulos_tabla);

            btn_modificar.setVisible(false);
            btn_eliminar.setVisible(false);
        }
           if(btn_sub_menu_2.getText()=="Producción"){

            tabla="Produccion";
            tabla_secundaria="Produccion_Produccion";
            
            txt_1.setVisible(true);
            txt_1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "CÓDIGO :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));
            txt_2.setVisible(true);
            txt_2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "EMPLEADO :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(153,153,153)));
            txt_2.setFocusable(true);
            txt_3.setVisible(true);
            txt_3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "FECHA DE INICIO :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));
            txt_3.setToolTipText("Formato de fecha: año-mes-dia (2020-12-31)");
            txt_3.setFocusable(true);
            txt_10.setVisible(true);
            txt_10.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "FECHA DE FIN :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));
            txt_10.setToolTipText("Formato de fecha: año-mes-dia (2020-12-31)");
            txt_10.setFocusable(true);
            txt_11.setVisible(true);
            txt_11.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "CANTIDAD PRODUCIDA :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));
            txt_11.setFocusable(true);
            txt_12.setVisible(true);
            txt_12.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "DESCRIPCIÓN :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));
            txt_12.setFocusable(true);
            txt_19.setVisible(true);
            txt_19.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "FECHA DE MODIFICACIÓN :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(153,153,153)));
            txt_19.setFocusable(true);
            cmb_1.setVisible(true);
            cmb_1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "PRODUCTO :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));
            cmb_1.setFocusable(true);
            cmb_2.setVisible(true);
            cmb_2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "ESTADO :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));     
            cmb_2.setFocusable(true);
            cmb_3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "CÓDIGO DE ORDEN: ", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));     
            cmb_3.setFocusable(true);
            btn_modificar.setVisible(false);

            num_columnas=9;
            Consulta_mostrar_datos="SELECT "+
            "[cod_produccion],[cod_empleado],[fecha_produccion_inicio],[fecha_produccion_fin],[cantidad_produccion],[descripcion],[cod_producto_vt],[cod_estado],[fecha_modificacion]"
            +" FROM "+tabla+" WHERE cantidad_produccion IS NOT NULL AND cod_estado!=7 ORDER BY cod_produccion DESC";
            String Titulos_tabla_2[]={"Código","Empleado","Fecha de inicio","Fecha de fin","Cantidad producida","Descripcion","Producto","Estado","Fecha de modificación"};
            String Titulos_base_2[]={"cod_produccion","cod_empleado","fecha_produccion_inicio","fecha_produccion_fin","cantidad_produccion","descripcion","cod_producto_vt","cod_estado","fecha_modificacion"};
            Titulos_tabla=Titulos_tabla_2;
            Titulos_base=Titulos_base_2;
            mostrar_datos_en_tabla(num_columnas,Titulos_tabla,Titulos_base,Consulta_mostrar_datos); 
            mostrar_datos_cmb_busqueda(num_columnas,Titulos_tabla);

            btn_modificar.setVisible(false);
            btn_eliminar.setVisible(false);
        }
        
        if(btn_sub_menu_2.getText()=="Inventario"){

            lbl_titulo.setText(lbl_titulo.getText()+" MATERIA PRIMA");
            tabla="Inventario_Materia_Prima";
            
            txt_1.setVisible(true);
            txt_1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "CÓDIGO :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));
            txt_2.setVisible(true);
            txt_2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "FECHA DE ACCIÓN :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(153,153,153)));
            txt_2.setFocusable(true);
            txt_3.setVisible(true);
            txt_3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "EMPLEADO :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(153,153,153)));
            txt_3.setFocusable(true);
            txt_10.setVisible(true);
            txt_10.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "CANTIDAD :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));
            txt_10.setFocusable(true);
            txt_11.setVisible(true);
            txt_11.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "FECHA DE MODIFICACIÓN :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(153,153,153)));
            txt_11.setFocusable(true);
            cmb_1.setVisible(true);
            cmb_1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "ACCIÓN :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));
            cmb_1.setFocusable(true);
            cmb_2.setVisible(true);
            cmb_2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "PRODUCTO :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));     
            cmb_2.setFocusable(true);
            cmb_3.setVisible(true);
            cmb_3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "ESTADO :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122))); 
            cmb_3.setFocusable(true);
            

            btn_modificar.setVisible(false);
            btn_eliminar.setVisible(false);

            num_columnas=8;
            String Titulos_tabla_2[]={"Código","Fecha de acción","Acción","Empleado","Cantidad","Producto","Fecha de modificación","Estado"};
            String Titulos_base_2[]={"cod_inventario","fecha_accion","accion","cod_empleado","cantidad","cod_producto_mt","fecha_modificacion","cod_estado"};
            Titulos_tabla=Titulos_tabla_2;
            Titulos_base=Titulos_base_2;
            Consulta_mostrar_datos="SELECT "+"*"+" FROM "+tabla+" WHERE cod_estado!=7 ORDER BY cod_inventario DESC ";
            mostrar_datos_en_tabla(num_columnas,Titulos_tabla,Titulos_base,Consulta_mostrar_datos);   
            mostrar_datos_cmb_busqueda(num_columnas,Titulos_tabla);

        }
        if(btn_sub_menu_2.getText()=="Stock"){

            tabla_secundaria="Stock_productos_vt";
            lbl_titulo.setText(lbl_titulo.getText()+" DISPONIBLE PARA LA VENTA");

            Panel_cajas_de_texto.setVisible(false);
            btn_modificar.setVisible(false);
            btn_eliminar.setVisible(false);

            num_columnas=5;
            String Titulos_tabla_2[]={"Código","Nombre", "Unidades en stock", "Punto de reorden"," Aviso "};
            String Titulos_base_2[]={"cod_producto_vt","nombre_producto","stock","punto_reorden","Aviso"};
            Titulos_tabla=Titulos_tabla_2;
            Titulos_base=Titulos_base_2;
            Consulta_mostrar_datos="SELECT cod_producto_vt,nombre_producto,stock,punto_reorden,IIF(stock>(punto_reorden+1),'','Producto Agotándose')as Aviso FROM Productos_Venta WHERE stock>0 ORDER BY stock DESC";
            mostrar_datos_en_tabla(num_columnas,Titulos_tabla,Titulos_base,Consulta_mostrar_datos);
            mostrar_datos_cmb_busqueda(num_columnas,Titulos_tabla);
            btn_imprimir.setVisible(true);
        }
        if(btn_sub_menu_2.getText()=="Detalle de Ventas"){
            lbl_titulo.setText("DETALLE DE VENTAS DEL DÍA Y BÚSQUEDA DE DETALLES DE FACTURA");
            tabla="Detalle_Factura";
            Panel_cajas_de_texto.setVisible(false);

            btn_modificar.setVisible(false);
            btn_eliminar.setVisible(false);
            
            num_columnas=6;
            String Titulos_tabla_2[]={"Código Factura","Código de producto","Cantidad","Precio","Descuento","Subtotal"};
            String Titulos_base_2[]={"codigo","producto","cant","precio","descu","sub"};
            Titulos_tabla=Titulos_tabla_2;
            Titulos_base=Titulos_base_2;
            Consulta_mostrar_datos=" SELECT df.n_factura as codigo,df.cod_producto_vt as producto,df.cantidad as cant,pv.precio_unitario as precio,df.descuento as descu,df.sub_total as sub " +
                " FROM [dbo].[Factura] as f JOIN [dbo].[Detalle_Factura] as df ON f.n_factura=df.n_factura  JOIN [dbo].[Productos_Venta] as pv ON pv.cod_producto_vt=df.cod_producto_vt " +
                " WHERE convert(varchar(8),fecha_emision,112)= Convert(varchar(8),GetDate(),112) " +
                " ORDER BY df.n_factura DESC ";
            mostrar_datos_en_tabla(num_columnas,Titulos_tabla,Titulos_base,Consulta_mostrar_datos);
            mostrar_datos_cmb_busqueda(num_columnas,Titulos_tabla);
        }

    }//GEN-LAST:event_btn_sub_menu_2ActionPerformed

    private void txt_13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_13ActionPerformed
        
    }//GEN-LAST:event_txt_13ActionPerformed

    private void btn_sub_menu_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sub_menu_3ActionPerformed

        restablecer_sub_menu();

        btn_sub_menu_3.setBackground(new java.awt.Color(51,51,51));
        Panel_contenedor_pantalla.setVisible(true);
        lbl_titulo.setText(btn_sub_menu_3.getText().toUpperCase());

        if(btn_sub_menu_3.getText()=="Usuarios"){

            tabla="Usuarios";
            
            txt_1.setVisible(true);
            txt_1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "CÓDIGO :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));
            txt_2.setVisible(true);
            txt_2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "NOMBRE :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));
            txt_2.setToolTipText("Nombre de usuario de 8 a 30 caracteres,con al menos una mayúscula y un número");
            txt_2.setFocusable(true);
            cmb_3.setVisible(true);
            cmb_3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "EMPLEADO :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));
            cmb_3.setFocusable(true);
            txt_12.setVisible(true);
            txt_12.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "FECHA DE MODIFICACIÓN :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(153,153,153)));
            txt_12.setFocusable(true);
            cmb_1.setVisible(true);
            cmb_1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "NIVEL DE ACCESO :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));
            cmb_1.setFocusable(true);
            cmb_2.setVisible(true);
            cmb_2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "ESTADO :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));
            cmb_2.setFocusable(true);
            
            num_columnas=6;
            String Titulos_tabla_2[]={"Código","Nombre","Empleado", "Nivel de acceso","Estado","Fecha de modificación"};
            String Titulos_base_2[]={"cod_usuario","nombre_usuario","cod_empleado","cod_nivel_acceso","cod_estado","fecha_modificacion"};
            Titulos_tabla=Titulos_tabla_2;
            Titulos_base=Titulos_base_2;
            Consulta_mostrar_datos="SELECT "+"*"+" FROM "+tabla+" WHERE cod_estado!=7 ORDER BY cod_usuario DESC ";
            mostrar_datos_en_tabla(num_columnas,Titulos_tabla,Titulos_base,Consulta_mostrar_datos);
            mostrar_datos_cmb_busqueda(num_columnas,Titulos_tabla);

            btn_eliminar.setVisible(true);
        }
        if(btn_sub_menu_3.getText()=="Pedidos"){

            tabla="Pedidos";
            
            txt_1.setVisible(true);
            txt_1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "CÓDIGO :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));
            txt_2.setVisible(true);
            txt_2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "FECHA :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(153,153,153)));
            txt_2.setFocusable(true);
            txt_3.setVisible(true);
            txt_3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "EMPLEADO :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(153,153,153)));
            txt_3.setFocusable(true);
            txt_4.setVisible(true);
            txt_4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "CLIENTE :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(153,153,153)));
            txt_4.setFocusable(true);
            txt_10.setVisible(true);
            txt_10.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "CANTIDAD :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));
            txt_10.setFocusable(true);
            txt_11.setVisible(true);
            txt_11.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "PRECIO :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));
            txt_11.setFocusable(true);
            txt_12.setVisible(true);
            txt_12.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "DESCUENTO (PORCENTAJE):", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));
            txt_12.setToolTipText("Descuento en porcentaje");
            txt_12.setFocusable(true);
            txt_13.setVisible(true);
            txt_13.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "TOTAL :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));
            txt_13.setFocusable(true);
            txt_13.setEnabled(false);
            cmb_1.setVisible(true);
            cmb_1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "CÓDIGO DE PRODUCTO :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));
            cmb_1.setFocusable(true);
            cmb_2.setVisible(true);
            cmb_2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "ESTADO:", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));
            cmb_2.setFocusable(true);
            txt_19.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "ID CLIENTE: ", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));
            txt_19.setToolTipText("ID/RTN del cliente ");
            txt_19.setFocusable(true);
            
            num_columnas=9;
            String Titulos_tabla_2[]={"Código","Fecha","Empleado","Cliente","Producto","Estado","Cantidad","Precio","Descuento"};
            String Titulos_base_2[]={"cod_pedido","fecha_pedido","cod_empleado","cod_cliente","cod_producto_vt","cod_estado","cantidad","precio","descuento"};
            Titulos_tabla=Titulos_tabla_2;
            Titulos_base=Titulos_base_2;
            Consulta_mostrar_datos="SELECT "+"*"+" FROM "+tabla+" WHERE cod_estado!=7 ORDER BY cod_pedido DESC ";
            mostrar_datos_en_tabla(num_columnas,Titulos_tabla,Titulos_base,Consulta_mostrar_datos);
            mostrar_datos_cmb_busqueda(num_columnas,Titulos_tabla);

            btn_eliminar.setVisible(false);
            }
            if(btn_sub_menu_3.getText()=="Stock MP"){
                tabla_secundaria="stock_productos_mt";

                lbl_titulo.setText(lbl_titulo.getText()+" DISPONIBLE PARA PRODUCCIÓN");
                Panel_cajas_de_texto.setVisible(false);
                btn_modificar.setVisible(false);
                btn_eliminar.setVisible(false);

                num_columnas=5;
                String Titulos_tabla_2[]={"Código","Nombre","Stock","Punto de reorden","Aviso"};
                String Titulos_base_2[]={"cod_producto_mt","nombre","stock","punto_reorden","Aviso"};
                Titulos_tabla=Titulos_tabla_2;
                Titulos_base=Titulos_base_2;
                Consulta_mostrar_datos="  SELECT [cod_producto_mt],[nombre],stock,punto_reorden,IIF(stock>(punto_reorden+1),'','Producto agotándose')as Aviso FROM [Productos_Materia_Prima] WHERE stock>0  ORDER BY stock DESC";
                mostrar_datos_en_tabla(num_columnas,Titulos_tabla,Titulos_base,Consulta_mostrar_datos);
                mostrar_datos_cmb_busqueda(num_columnas,Titulos_tabla);

                btn_imprimir.setVisible(true);
            }
    }//GEN-LAST:event_btn_sub_menu_3ActionPerformed

    private void btn_sub_menu_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sub_menu_4ActionPerformed

        restablecer_sub_menu();

        btn_sub_menu_4.setBackground(new java.awt.Color(51,51,51));
        Panel_contenedor_pantalla.setVisible(true);
        lbl_titulo.setText(btn_sub_menu_4.getText().toUpperCase());

        if(btn_sub_menu_4.getText()=="Tipos de Importe"){
           tabla="Tipos_de_Importe";
            txt_1.setVisible(true);
            txt_1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "CÓDIGO :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));
            txt_2.setVisible(true);
            txt_2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "NOMBRE :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));
            txt_2.setFocusable(true);
            txt_10.setVisible(true);
            txt_10.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "PORCENTAJE :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));
            txt_10.setFocusable(true);
            Scroll_pane_txta_2.setVisible(true);
            Scroll_pane_txta_2.setFocusable(true);
            txta_2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "DESCRIPCIÓN :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));
            txta_2.setFocusable(true);
            cmb_1.setVisible(true);
            cmb_1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "ESTADO :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));
            cmb_1.setFocusable(true);
            
            num_columnas=5;
            String Titulos_tabla_2[]={"Código","Nombre","Porcentaje","Descripción","Estado"};
            String Titulos_base_2[]={"cod_tipo_importe","nombre","porcentaje","decripcion","cod_estado"};
            Titulos_tabla=Titulos_tabla_2;
            Titulos_base=Titulos_base_2;
            Consulta_mostrar_datos="SELECT "+"*"+" FROM "+tabla+" WHERE cod_estado!=7 ORDER BY cod_tipo_importe DESC ";
            mostrar_datos_en_tabla(num_columnas,Titulos_tabla,Titulos_base,Consulta_mostrar_datos);
            mostrar_datos_cmb_busqueda(num_columnas,Titulos_tabla);

            btn_eliminar.setVisible(false);
        }
        if(btn_sub_menu_4.getText()=="Cotizaciones"){

            tabla="Cotizacion";
            txt_1.setVisible(true);
            txt_1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "CÓDIGO :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));
            txt_2.setVisible(true);
            txt_2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "FECHA :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(153,153,153)));
            txt_2.setFocusable(true);
            txt_3.setVisible(true);
            txt_3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "EMPLEADO :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(153,153,153)));
            txt_3.setFocusable(true);
            txt_4.setVisible(true);
            txt_4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "CLIENTE :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(153,153,153)));
            txt_4.setFocusable(true);
            txt_10.setVisible(true);
            txt_10.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "CANTIDAD :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));
            txt_10.setFocusable(true);
            txt_11.setVisible(true);
            txt_11.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "PRECIO :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));
            txt_11.setFocusable(true);
            txt_12.setVisible(true);
            txt_12.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "DESCUENTO (PORCENTAJE):", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));
            txt_12.setToolTipText("Descuento en porcentaje");
            txt_12.setFocusable(true);
            txt_13.setVisible(true);
            txt_13.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "TOTAL :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));
            txt_13.setFocusable(true);
            txt_13.setEnabled(false);
            cmb_1.setVisible(true);
            cmb_1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "PRODUCTO :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));
            cmb_1.setFocusable(true);
            cmb_2.setVisible(true);
            cmb_2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "ESTADO:", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));
            cmb_2.setFocusable(true);
            txt_19.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "ID CLIENTE: ", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));
            txt_19.setToolTipText("ID/RTN del cliente");
            txt_19.setFocusable(true);
            
            num_columnas=9;
            String Titulos_tabla_2[]={"Código","Fecha","Empleado","Cliente","Producto","Estado","Cantidad","Precio","Descuento"};
            String Titulos_base_2[]={"cod_cotizacion","fecha_cotizacion","cod_empleado","cod_cliente","cod_producto_vt","cod_estdo","cantidad","precio","descuento"};
            Titulos_tabla=Titulos_tabla_2;
            Titulos_base=Titulos_base_2;
            Consulta_mostrar_datos="SELECT "+"*"+" FROM "+tabla+" WHERE cod_estdo!=7 ORDER BY cod_cotizacion DESC ";
            mostrar_datos_en_tabla(num_columnas,Titulos_tabla,Titulos_base,Consulta_mostrar_datos);
            mostrar_datos_cmb_busqueda(num_columnas,Titulos_tabla);

            btn_eliminar.setVisible(false);
        }
    }//GEN-LAST:event_btn_sub_menu_4ActionPerformed

    private void btn_sub_menu_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sub_menu_5ActionPerformed

        restablecer_sub_menu();

        btn_sub_menu_5.setBackground(new java.awt.Color(51,51,51));
        Panel_contenedor_pantalla.setVisible(true);
        lbl_titulo.setText(btn_sub_menu_5.getText().toUpperCase());

        if(btn_sub_menu_5.getText()=="Configuración"){
            lbl_titulo.setText(lbl_titulo.getText()+"/ Datos de la empresa");
            tabla="Datos_Organizacion";
            txt_1.setVisible(true);
            txt_1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "CÓDIGO :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));
            txt_2.setVisible(true);
            txt_2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "RTN :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));
            txt_2.setToolTipText("Número de RTN : (08011998001496)");
            txt_2.setFocusable(true);
            txt_3.setVisible(true);
            txt_3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "NOMBRE :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));
            txt_3.setFocusable(true);
            txt_4.setVisible(true);
            txt_4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "NOMBRE CORTO :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));
            txt_4.setFocusable(true);
            txt_5.setVisible(true);
            txt_5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "NOMBRE AGENCIA :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));
            txt_5.setFocusable(true);
            txt_6.setVisible(true);
            txt_6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "DIRECCIÓN CASA MATRIZ :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));
            txt_6.setFocusable(true);
            txt_7.setVisible(true);
            txt_7.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "DIRECCIÓN AGENCIA :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));
            txt_7.setFocusable(true);
            txt_8.setVisible(true);
            txt_8.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "PÁGINA WEB :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));
            txt_8.setFocusable(true);
            txt_10.setVisible(true);
            txt_10.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "EMAIL 1 :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));
            txt_10.setToolTipText("Ejemplo: direccion@gmail.com ");
            txt_10.setFocusable(true);
            txt_11.setVisible(true);
            txt_11.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "EMAIL 2 :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));
            txt_11.setToolTipText("Ejemplo: direccion@gmail.com ");
            txt_11.setFocusable(true);
            txt_12.setVisible(true);
            txt_12.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "TELEFONO 1 :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));
            txt_12.setToolTipText("Formato de teléfono (sin guiones): 22034567");
            txt_12.setFocusable(true);
            txt_13.setVisible(true);
            txt_13.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "TELEFONO 2 :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));
            txt_13.setToolTipText("Formato de teléfono (sin guiones): 22034567");
            txt_13.setFocusable(true);
            txt_14.setVisible(true);
            txt_14.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "CELULAR 1 :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));
            txt_14.setToolTipText("Formato de celular (sin guiones): 99887766");
            txt_14.setFocusable(true);
            txt_15.setVisible(true);
            txt_15.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "CELULAR 2 :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));
            txt_15.setToolTipText("Formato de celular (sin guiones): 99887766");
            txt_15.setFocusable(true);
            txt_16.setVisible(true);
            txt_16.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "CAI :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));
            txt_16.setToolTipText("Formato: AB67S9-CJ7FE9-MDO98D-B87A9C-Z8X7ZX-C5");
            txt_16.setFocusable(true);
            txt_19.setVisible(true);
            txt_19.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "FECHA LIMITE EMISIÓN (año-mes-dia):", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));
            txt_19.setToolTipText("Formato de fecha: año-mes-dia (2020-12-31)");
            txt_19.setFocusable(true);
            txt_20.setVisible(true);
            txt_20.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "RANGO INICIAL :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));
            txt_20.setFocusable(true);
            txt_21.setVisible(true);
            txt_21.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "RANGO FINAL :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));
            txt_21.setFocusable(true);
            txt_22.setVisible(true);
            txt_22.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "FECHA MODIFICACIÓN :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(153,153,153)));
            txt_22.setFocusable(true);
            cmb_1.setVisible(true);
            cmb_1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "ESTADO :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));
            cmb_1.setFocusable(true);
            Scroll_pane_txta_1.setVisible(true);
            Scroll_pane_txta_1.setFocusable(true);
            txta_1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "MENSAJE 1 :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));
            txta_1.setFocusable(true);
            Scroll_pane_txta_2.setVisible(true);
            Scroll_pane_txta_2.setFocusable(true);
            txta_2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "MENSAJE 2 :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));
            txta_2.setFocusable(true);
            Scroll_pane_txta_3.setVisible(true);
            Scroll_pane_txta_3.setFocusable(true);
            txta_3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "MENSAJE 3 :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));
            txta_3.setFocusable(true);

            num_columnas=23;
            String Titulos_tabla_2[]={"Código","RTN","Nombre","Nombre corto","Nombre agencia","Dirección casa matríz","Dirección agencia","Página web"," E-mail 1", "E-mail 2", "Teléfono 1", "Teléfono 2", "Celular 1", "Celular 2", "CAI", "Fecha límite emisión", "Rango inicial", "Rango final","Mensaje 1", "Mensaje 2","Mensaje 3", "Estado","Fecha de modificación"};
            String Titulos_base_2[]={"cod_datos_organizacion","rtn","nombre","nombre_corto","nombre_agencia","direccion_casa_matriz","direccion_agencia","pagina_web","email_1","email_2","telefono_1","telefono_2","celular_1", "celular_2", "CAI","fecha_limite_emision","rango_inicial","rango_final", "mensaje_1", "mensaje_2", "mensaje_3", "cod_estado","fecha_modificacion"};
            Titulos_tabla=Titulos_tabla_2;
            Titulos_base=Titulos_base_2;
            Consulta_mostrar_datos="SELECT "+"*"+" FROM "+tabla+" WHERE cod_estado!=7 ORDER BY cod_datos_organizacion DESC ";
            mostrar_datos_en_tabla(num_columnas,Titulos_tabla,Titulos_base,Consulta_mostrar_datos); 
            Tabla_principal.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            mostrar_datos_cmb_busqueda(num_columnas,Titulos_tabla);

            btn_eliminar.setVisible(true);
        }
        if(btn_sub_menu_5.getText()=="Cierre de Caja"){

            tabla="Cierre_diario_Caja";
            Panel_cajas_de_texto.setVisible(false);
            btn_modificar.setVisible(false);
            btn_eliminar.setVisible(false);

            num_columnas=13;
            String Titulos_tabla_2[]={"Código","Fecha inicial","Fecha final","Empleado","Cambio inicial","Total efectivo","Efectivo reportado","Diferencia efectivo","Total POS","POS reportado","Diferencia POS","Comentario","Estado"};
            String Titulos_base_2[]={"cod_cierre","fecha_Inicio","fecha_cierre","cod_empleado","cambio_inicial","total_efectivo","total_efectivo_reportado","Diferencia Efectivo","total_POS","total_POS_reportado","Diferencia POS","comentario","cod_estado"};
            Titulos_tabla=Titulos_tabla_2;
            Titulos_base=Titulos_base_2;
            Consulta_mostrar_datos="SELECT [cod_cierre],[fecha_Inicio] ,[fecha_cierre],[cod_empleado],[cambio_inicial],[total_efectivo] " +
                "      ,[total_efectivo_reportado],(([total_efectivo]+[cambio_inicial])-([total_efectivo_reportado])) as'Diferencia Efectivo' " +
                "      ,[total_POS],[total_POS_reportado],([total_POS]-[total_POS_reportado]) as'Diferencia POS',[comentario],[cod_estado] " +
                "  FROM [GIBON].[dbo].[Cierre_diario_Caja] WHERE MONTH([fecha_cierre])= MONTH(GetDate()) " +
                "  ORDER BY cod_cierre DESC ";
            mostrar_datos_en_tabla(num_columnas,Titulos_tabla,Titulos_base,Consulta_mostrar_datos);
            Tabla_principal.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            mostrar_datos_cmb_busqueda(num_columnas,Titulos_tabla);
        }
        
    }//GEN-LAST:event_btn_sub_menu_5ActionPerformed

    private void btn_agregar_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregar_nuevoActionPerformed
    
        Tabla_editable=false;
        Tabla_principal.setEnabled(Tabla_editable);
        Tabla_principal.clearSelection();
        restablecer_color_cajas_contenedoras();

        btn_agregar_nuevo.setEnabled(false);
        btn_cancelar.setVisible(true);
        btn_guardar.setVisible(true);
        btn_modificar.setVisible(false);
        btn_eliminar.setVisible(false);
        btn_imprimir.setVisible(false);
        btn_busqueda.setEnabled(false);

        accion_bd="insertar";
        limpiar_cajas_contenedoras();
        habilitar_cajas_contenedoras();
        
            if("Empleados".equals(tabla) || "Proveedores".equals(tabla) || "Clientes".equals(tabla)){
               txt_19.setEditable(false);
               llenar_cmb_1("SELECT nombre FROM Estados WHERE cod_estado<7");
            }

            if("Usuarios".equals(tabla)){
                txt_12.setEditable(false);         
                txt_10.setVisible(true);
                txt_10.setFocusable(true);
                txt_10.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "CONTRASEÑA :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));
                txt_10.setToolTipText("Su contraseña debe tener al menos ocho caracteres, un número, una letra mayúscula y una minúscula");
                txt_11.setVisible(true);
                txt_11.setFocusable(true);
                txt_11.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "CONFIRMAR CONTRASEÑA :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Microsoft JhengHei UI Light", 1, 10), new java.awt.Color(10, 76, 122)));   
                txt_11.setToolTipText("Su contraseña debe tener al menos ocho caracteres, un número, una letra mayúscula y una minúscula");
                cmb_2.setVisible(false);
                llenar_cmb_1("SELECT nombre_nivel FROM Niveles_Acceso");
                llenar_cmb_3("SELECT cod_empleado FROM Empleados WHERE cod_estado<7");
            }
            if("Tipos_de_Importe".equals(tabla)){
               llenar_cmb_1("SELECT nombre FROM Estados WHERE cod_estado<7");
            }
            if("Datos_Organizacion".equals(tabla)){
               txt_22.setEditable(false);
               cmb_1.setEnabled(false);
            }
            if("Colecciones".equals(tabla)){
               txt_12.setEditable(false);
               llenar_cmb_1("SELECT nombre FROM Estados WHERE cod_estado<7");
            }
            if("Productos_Venta".equals(tabla)){
               txt_12.setEditable(false);  
               llenar_cmb_1("SELECT nombre_coleccion FROM Colecciones WHERE cod_estado<7");
               llenar_cmb_2("SELECT nombre FROM Estados WHERE cod_estado<7");
               llenar_cmb_3("SELECT nombre FROM Tipos_de_Importe WHERE cod_estado<7");
            }
            if("Productos_Materia_Prima".equals(tabla)){
                txt_20.setEditable(false);
                llenar_cmb_1("SELECT nombre FROM Estados WHERE cod_estado<7");
                /*
                CORRECCIÓN DE ERROR
                Autores: Yuli
                Version 1.0   25/06/2020 
                se validó el ingreso de tipos de unidades, agregando un combobox 
                que contiene solamente las unidades permitidas.
                */
                cmb_2.removeAllItems();
                cmb_2.addItem("Unidad");
                cmb_2.addItem("Yarda");
                cmb_2.addItem("Metro");
                cmb_2.repaint();
                cmb_2.setSelectedIndex(0);   
            }
            if("Inventario_Materia_Prima".equals(tabla)){
                txt_3.setEditable(false); 
                txt_2.setEditable(false); 
                txt_11.setEditable(false); 
                llenar_cmb_3("SELECT nombre FROM Estados WHERE cod_estado<7");
                llenar_cmb_2("SELECT nombre FROM Productos_Materia_Prima WHERE stock>0 AND cod_estado<7");
                cmb_1.addItem("ENTRADA");
                cmb_1.addItem("SALIDA");
                cmb_1.repaint();
                cmb_1.setSelectedIndex(0);
            }
            if("Ordenes_Produccion".equals(tabla_secundaria)){
                txt_12.setEditable(false);
                txt_2.setEditable(false);
                txt_3.setEditable(false);
                llenar_cmb_1("SELECT nombre_producto FROM Productos_Venta WHERE cod_estado<7");
                llenar_cmb_2("SELECT nombre FROM Estados WHERE cod_estado<7");
            }
            if("Produccion_Produccion".equals(tabla_secundaria)){
                txt_19.setEditable(false);
                txt_2.setEditable(false);
                cmb_1.setVisible(false);
                llenar_cmb_2("SELECT nombre FROM Estados WHERE cod_estado<7");
                cmb_3.setVisible(true);
                cmb_3.setFocusable(true);
                llenar_cmb_3("SELECT cod_produccion FROM Produccion WHERE cantidad_produccion IS NULL ");
            }
            if("Ordenes_Compras".equals(tabla_secundaria)){
                txt_12.setEditable(false);
                txt_2.setEditable(false);
                txt_3.setEditable(false);
                llenar_cmb_1("SELECT nombre FROM Proveedores WHERE cod_estado<7");
                llenar_cmb_2("SELECT nombre FROM Productos_Materia_Prima WHERE cod_estado<7");
                llenar_cmb_3("SELECT nombre FROM Estados WHERE cod_estado<7");
            } 
             if("Compras_Compras".equals(tabla_secundaria)){
                txt_13.setEditable(false);
                txt_2.setEditable(false);
                txt_3.setEditable(false);
                cmb_1.setVisible(false);
                cmb_2.setVisible(false);
                llenar_cmb_3("SELECT nombre FROM Estados WHERE cod_estado<7");
                cmb_4.setVisible(true);
                cmb_4.setFocusable(true);
                llenar_cmb_4("SELECT cod_compra FROM [Compras] WHERE [cantidad_compra] IS NULL ");
            } 
            if("Pedidos".equals(tabla)||"Cotizacion".equals(tabla)){
                txt_2.setEditable(false); 
                txt_3.setEditable(false); 
                txt_4.setVisible(false);
                txt_13.setVisible(false); 
                txt_19.setVisible(true); 
                txt_19.setFocusable(true);
                llenar_cmb_1("SELECT nombre_producto FROM Productos_Venta WHERE cod_estado<7");
                llenar_cmb_2("SELECT nombre FROM Estados WHERE cod_estado<7");
            }
    }//GEN-LAST:event_btn_agregar_nuevoActionPerformed

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed

        
        int respuesta=JOptionPane.showConfirmDialog(null,"¿Deasea cancelar la operación?","CANCELAR",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
        if(respuesta==JOptionPane.YES_OPTION){

            restablecer_color_cajas_contenedoras();

            btn_cancelar.setVisible(false);
            btn_guardar.setVisible(false);
            btn_busqueda.setEnabled(true);
            btn_agregar_nuevo.setEnabled(true);
            btn_modificar.setVisible(true);
            btn_eliminar.setVisible(true);
            btn_imprimir.setVisible(true);

            Tabla_editable=true;
            Tabla_principal.setEnabled(Tabla_editable);
            Tabla_principal.clearSelection();
            

            if(tabla=="Empleados"){
                btn_imprimir.setVisible(false);
                txt_10.setEnabled(true);
                txt_11.setEnabled(true);
                txt_19.setEnabled(true);
            }
            if(tabla=="Proveedores"){
                btn_imprimir.setVisible(false);
                txt_19.setEnabled(true);
            }
            if(tabla=="Usuarios"){
                btn_imprimir.setVisible(false);
                cmb_2.setVisible(true);
                txt_2.setEnabled(true);
            }
            if(tabla=="Tipos_de_Importe"){
                btn_eliminar.setVisible(false);
                btn_imprimir.setVisible(false);
                txt_2.setEnabled(true);
                txt_10.setEnabled(true);
                txta_2.setEnabled(true);
                Scroll_pane_txta_2.setEnabled(true);
            }
            if(tabla=="Datos_Organizacion"){
                btn_imprimir.setVisible(false);
                txt_2.setEnabled(true);
                txt_3.setEnabled(true);
                txt_4.setEnabled(true);
                txt_5.setEnabled(true);
                txt_6.setEnabled(true);
                txt_7.setEnabled(true);
                txt_8.setEnabled(true);
                txt_16.setEnabled(true);
                txt_19.setEnabled(true);
                txt_20.setEnabled(true);
                txt_21.setEnabled(true);
                txt_22.setEnabled(true);
            }
            if(tabla=="Clientes"){
                btn_imprimir.setVisible(false);
                txt_19.setEnabled(true);
            }
             if(tabla=="Colecciones"){
                 btn_imprimir.setVisible(false);
                 txt_10.setEnabled(true);
                 txt_11.setEnabled(true);
                 txt_12.setEnabled(true);
            }
             if(tabla=="Productos_Venta"){
                 txt_10.setEnabled(true);
                 txt_12.setEnabled(true);
            }
             if(tabla=="Inventario_Materia_Prima"){
                btn_modificar.setVisible(false);
                btn_eliminar.setVisible(false);
                btn_imprimir.setVisible(false);
                txt_10.setEnabled(true);
                txt_20.setEnabled(true);
            }
             if(tabla_secundaria=="Ordenes_Produccion"){
                btn_eliminar.setVisible(false);
                btn_imprimir.setVisible(false);
            }
             if(tabla_secundaria=="Produccion_Produccion"){
                btn_modificar.setVisible(false);
                btn_eliminar.setVisible(false);
                btn_imprimir.setVisible(false);
                cmb_1.setVisible(true);
                cmb_3.setVisible(false);
                cmb_3.removeAllItems();
            }
            if(tabla_secundaria=="Ordenes_Compras"){
                btn_eliminar.setVisible(false);
                btn_imprimir.setVisible(false);
            } 
             if(tabla_secundaria=="Compras_Compras"){
                btn_modificar.setVisible(false);
                btn_eliminar.setVisible(false);
                btn_imprimir.setVisible(false);
                cmb_1.setVisible(true);
                cmb_2.setVisible(true);
                cmb_4.setVisible(false);
                cmb_4.removeAllItems();
            } 
            if(tabla=="Pedidos"||tabla=="Cotizacion"){
                btn_eliminar.setVisible(false);
                btn_imprimir.setVisible(false);
                txt_4.setVisible(true);
                txt_13.setVisible(true);
                txt_19.setVisible(false);
            }
            if(tabla=="Usuarios" && accion_bd=="insertar"){
                txt_10.setVisible(false);
                txt_11.setVisible(false);
            }
  
            limpiar_cajas_contenedoras();
            deshabilitar_cajas_contenedoras();
            accion_bd="NULL";
        }

    }//GEN-LAST:event_btn_cancelarActionPerformed

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed

        int filaseleccionada= Tabla_principal.getSelectedRow();
        int codigo_registro=-1;

        if (filaseleccionada==-1){
            JOptionPane.showMessageDialog(null, "Error:\n¡No se ha seleccionado ningún registro!","ERROR",JOptionPane.ERROR_MESSAGE);
        }else{
            int respuesta=JOptionPane.showConfirmDialog(null,"¿Está seguro de eliminar el registro seleccionado?","AVISO",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
            if(respuesta==JOptionPane.YES_OPTION){
                codigo_registro=Integer.parseInt(Tabla_principal.getValueAt(filaseleccionada,0).toString());

                if(tabla=="Empleados"){
                    eliminar_registro(tabla,"cod_empleado",codigo_registro);
                }
                if(tabla=="Proveedores"){
                    eliminar_registro(tabla,"cod_proveedor",codigo_registro);
                }
                if(tabla=="Usuarios"){
                    eliminar_registro(tabla,"cod_usuario",codigo_registro);
                }
                if(tabla=="Datos_Organizacion"){
                    eliminar_registro(tabla,"cod_datos_organizacion",codigo_registro);
                }
                if(tabla=="Clientes"){
                    eliminar_registro(tabla,"cod_cliente",codigo_registro);
                }
                if(tabla=="Colecciones"){
                    eliminar_registro(tabla,"cod_coleccion",codigo_registro);
                }
                if(tabla=="Productos_Venta"){
                    eliminar_registro(tabla,"cod_producto_vt",codigo_registro);
                }
                if(tabla=="Productos_Materia_Prima"){
                    eliminar_registro(tabla,"cod_producto_mt",codigo_registro);
                }
            }
        }
    }//GEN-LAST:event_btn_eliminarActionPerformed

    private void btn_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificarActionPerformed

        String cmb_1_item_actual="",cmb_2_item_actual="",cmb_3_item_actual="";

        int filaseleccionada= Tabla_principal.getSelectedRow();
        if (filaseleccionada==-1 || txt_1.getText().length()<=0){
            JOptionPane.showMessageDialog(null, "Error:\n¡No se ha seleccionado ningún registro!","ERROR",JOptionPane.ERROR_MESSAGE);
        }else{
            Tabla_editable=false;
            Tabla_principal.setEnabled(Tabla_editable);

            restablecer_color_cajas_contenedoras();
            btn_agregar_nuevo.setEnabled(false);
            btn_cancelar.setVisible(true);
            btn_guardar.setVisible(true);
            btn_modificar.setVisible(false);
            btn_eliminar.setVisible(false);
            btn_imprimir.setVisible(false);
            btn_busqueda.setEnabled(false);
            deshabilitar_cajas_contenedoras();
            accion_bd="actualizar";
            
            if(tabla=="Empleados"){
                habilitar_cajas_contenedoras();
                
                txt_10.setEnabled(false);
                txt_11.setEnabled(false);
                txt_19.setEnabled(false);
                cmb_1_item_actual=cmb_1.getSelectedItem().toString().trim();
                llenar_cmb_1("SELECT nombre FROM Estados WHERE cod_estado<7");
                cmb_1.setSelectedItem(cmb_1_item_actual);
            }
            if(tabla=="Proveedores"){
                habilitar_cajas_contenedoras();
                
                txt_19.setEnabled(false);
                cmb_1_item_actual=cmb_1.getSelectedItem().toString().trim();
                llenar_cmb_1("SELECT nombre FROM Estados WHERE cod_estado<7");
                cmb_1.setSelectedItem(cmb_1_item_actual);
            }
            if(tabla=="Usuarios"){
                txt_2.setEnabled(false);
                cmb_1.setEnabled(true);
                cmb_2.setEnabled(true);
                cmb_1_item_actual=cmb_1.getSelectedItem().toString().trim();
                llenar_cmb_1("SELECT nombre_nivel FROM Niveles_Acceso");
                cmb_1.setSelectedItem(cmb_1_item_actual);
                cmb_2_item_actual=cmb_2.getSelectedItem().toString().trim();
                llenar_cmb_2("SELECT nombre FROM Estados WHERE cod_estado<=2");  
                cmb_2.setSelectedItem(cmb_2_item_actual);
            }
            if(tabla=="Tipos_de_Importe"){
                txt_2.setEnabled(false);
                txt_10.setEnabled(false);
                txta_2.setEnabled(false);
                Scroll_pane_txta_2.setEnabled(false);
                cmb_1.setEnabled(true);
                cmb_1_item_actual=cmb_1.getSelectedItem().toString().trim();
                llenar_cmb_1("SELECT nombre FROM Estados WHERE cod_estado<7");
                cmb_1.setSelectedItem(cmb_1_item_actual);
            }
            if(tabla=="Datos_Organizacion"){
                habilitar_cajas_contenedoras();

                txt_2.setEnabled(false);
                txt_3.setEnabled(false);
                txt_4.setEnabled(false);
                txt_5.setEnabled(false);
                txt_6.setEnabled(false);
                txt_7.setEnabled(false);
                txt_8.setEnabled(false);
                txt_16.setEnabled(false);
                txt_19.setEnabled(false);
                txt_20.setEnabled(false);
                txt_21.setEnabled(false);
                txt_22.setEnabled(false);
                cmb_1.setEnabled(false);
            }
            if(tabla=="Clientes"){
                habilitar_cajas_contenedoras();

                txt_19.setEnabled(false);
                cmb_1_item_actual=cmb_1.getSelectedItem().toString().trim();
                llenar_cmb_1("SELECT nombre FROM Estados WHERE cod_estado<7");
                cmb_1.setSelectedItem(cmb_1_item_actual);
            }
            if(tabla=="Colecciones"){
                habilitar_cajas_contenedoras();

                txt_10.setEnabled(false);
                txt_11.setEnabled(false);
                txt_12.setEnabled(false);
                cmb_1_item_actual=cmb_1.getSelectedItem().toString().trim();
                llenar_cmb_1("SELECT nombre FROM Estados WHERE cod_estado<7");
                cmb_1.setSelectedItem(cmb_1_item_actual);
            }
            if(tabla=="Productos_Venta"){
                habilitar_cajas_contenedoras();

                txt_10.setEnabled(false);
                txt_12.setEnabled(false);
                cmb_1_item_actual=cmb_1.getSelectedItem().toString().trim();
                llenar_cmb_1("SELECT nombre_coleccion FROM Colecciones WHERE cod_estado<7");
                cmb_1.setSelectedItem(cmb_1_item_actual);
                cmb_2_item_actual=cmb_2.getSelectedItem().toString().trim();
                llenar_cmb_2("SELECT nombre FROM Estados WHERE cod_estado<7");
                cmb_2.setSelectedItem(cmb_2_item_actual);
                cmb_3_item_actual=cmb_3.getSelectedItem().toString().trim();
                llenar_cmb_3("SELECT nombre FROM Tipos_de_Importe WHERE cod_estado<7");
                cmb_3.setSelectedItem(cmb_3_item_actual);
            }
            if(tabla=="Productos_Materia_Prima"){
                habilitar_cajas_contenedoras();

                txt_10.setEnabled(false);
                txt_20.setEnabled(false);
                cmb_1_item_actual=cmb_1.getSelectedItem().toString().trim();
                llenar_cmb_1("SELECT nombre FROM Estados WHERE cod_estado<7");
                cmb_1.setSelectedItem(cmb_1_item_actual);
                cmb_2_item_actual=cmb_2.getSelectedItem().toString().trim();
                cmb_2.removeAllItems();
                cmb_2.addItem("Unidad");
                cmb_2.addItem("Yarda");
                cmb_2.addItem("Metro");
                cmb_2.repaint();
                cmb_2.setSelectedItem(cmb_2_item_actual);  
            }
            if(tabla_secundaria=="Ordenes_Produccion"){

                txt_10.setEditable(true);
                txt_11.setEditable(true);
                cmb_2.setEnabled(true);
                cmb_2_item_actual=cmb_2.getSelectedItem().toString().trim();
                llenar_cmb_2("SELECT nombre FROM Estados WHERE cod_estado<7");
                cmb_2.setSelectedItem(cmb_2_item_actual);
            }
            if(tabla_secundaria=="Ordenes_Compras"){

                txt_10.setEditable(true);
                txt_11.setEditable(true);
                cmb_3.setEnabled(true);
                cmb_3_item_actual=cmb_3.getSelectedItem().toString().trim();
                llenar_cmb_3("SELECT nombre FROM Estados WHERE cod_estado<7");;
                cmb_3.setSelectedItem(cmb_3_item_actual);
            }
            if(tabla=="Pedidos" || tabla=="Cotizacion"){

                txt_10.setEditable(true);
                txt_11.setEditable(true);
                txt_12.setEditable(true);
                cmb_2.setEnabled(true);
                cmb_2_item_actual=cmb_2.getSelectedItem().toString().trim();
                llenar_cmb_2("SELECT nombre FROM Estados WHERE cod_estado<7");
                cmb_2.setSelectedItem(cmb_2_item_actual);
            }

            accion_bd="actualizar";

        }
    }//GEN-LAST:event_btn_modificarActionPerformed

    private void btn_busquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_busquedaActionPerformed
        busqueda_de_registros();
    }//GEN-LAST:event_btn_busquedaActionPerformed

    private void btn_limpiar_busquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limpiar_busquedaActionPerformed

        btn_limpiar_busqueda.setVisible(false);
        mostrar_datos_en_tabla(num_columnas,Titulos_tabla,Titulos_base,Consulta_mostrar_datos);  
        txt_busqueda.setText(null);
        cmb_busqueda.setSelectedIndex(0);
    }//GEN-LAST:event_btn_limpiar_busquedaActionPerformed
    
    /*
    Mantenimiento de la base de datos
    Autores: Todos
    Version 1.0   25/06/2020-15/07/2020 

    Funciones y metodos que dan mantenimiento a la base de datos.
    */
    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed

        String comando_sql="";
        String accion_realizada="";
        String consulta="";
        int codigo_cmb_1=0;
        int codigo_cmb_2=0;
        int codigo_cmb_3=0;
        int codigo_cmb_4=0;
        restablecer_color_cajas_contenedoras();
        
        
        if(accion_bd.equals("insertar")){
            accion_realizada="insertado";  
            
            if(tabla=="Empleados"){
                    /*
                    Validaciones del ingreso de datos
                    Autores: Todos
                    Version 1.0   25/03/2020

                    Permite llamar las validaciones de todos los campos ingresados por el usuario.
                    */
                    if(clase_validaciones.validar_existencia_registro("Empleados","num_identidad", txt_2.getText().trim())==true &&
                        clase_validaciones.validar_num_id(txt_2.getText().trim()) == true && 
                        clase_validaciones.validar_campo(txt_3.getText().trim()) == true && 
                        clase_validaciones.validar_campo(txt_4.getText().trim()) == true && 
                        clase_validaciones.validar_fecha_nacimiento(txt_10.getText().trim()) == true && 
                        clase_validaciones.validar_fecha(txt_11.getText().trim()) == true && 
                        clase_validaciones.validar_numero_contacto(txt_12.getText().trim()) == true &&
                        clase_validaciones.validar_existencia_registro("Empleados","celular",txt_12.getText().trim())==true &&
                        clase_validaciones.validar_correo(txt_13.getText().trim()) == true &&
                        clase_validaciones.validar_existencia_registro("Empleados", "correo_electronico",txt_13.getText().trim())==true &&
                        cmb_1.getSelectedIndex()>=0 && txta_3.getText().length()>0){    
                
                        comando_sql="execute Procedimiento_insertar_empleados ?,?,?,?,?,?,?,?,?";
                        codigo_cmb_1=consultar_codigo_de_registro("SELECT cod_estado FROM Estados WHERE nombre='"+cmb_1.getSelectedItem().toString()+"'");
                        try {
                            /*
                            Insercion de Datos
                            Autores: Todos
                            Version 1.0   25/03/2020

                            Ejecuta y encia parametros al procedimiento almacenado insertar.
                            */
                            conexion=clase_conexion.conectar();
                            if(clase_conexion.obtener_estado_conexion()==true){
                                PreparedStatement pst=conexion.prepareCall(comando_sql);
                                pst.setString(1,txt_3.getText().trim());
                                pst.setString(2,txt_4.getText().trim());
                                pst.setString(3,txt_2.getText().trim());
                                pst.setDate(4,Date.valueOf(txt_10.getText().trim()));
                                pst.setDate(5,Date.valueOf(txt_11.getText().trim()));
                                pst.setString(6,txt_12.getText().trim());
                                pst.setString(7,txt_13.getText().trim());
                                pst.setString(8,txta_3.getText().trim());
                                pst.setInt(9,codigo_cmb_1);
                                pst.execute();
                                actualizar_pantalla(accion_realizada);
                                conexion=null;
                                clase_conexion.cerrar_conexion();                            
                            }
                             
                         } catch (SQLException ex) {
                             JOptionPane.showMessageDialog(null,"Ocurrió un error al insertar el registro, intente nuevamente."+ex,"ERROR",JOptionPane.ERROR_MESSAGE);
                         }
                        
                    }else{
                        /*
                        Muestra errores de validación
                        Autores: Todos
                        Version 1.0   25/03/2020

                        Muestra en pantalla los mensajes y errores de validaciones.
                        */
                        if(clase_validaciones.validar_num_id(txt_2.getText().trim())==false){txt_2.setForeground(java.awt.Color.RED);mensaje=mensaje+mensaje_error_num_id;}
                        if(clase_validaciones.validar_campo(txt_3.getText().trim())==false){txt_3.setForeground(java.awt.Color.RED);mensaje=mensaje+"Nombre"+mensaje_error_campo;}
                        if(clase_validaciones.validar_campo(txt_4.getText().trim())==false){txt_4.setForeground(java.awt.Color.RED);mensaje=mensaje+"Apellido"+mensaje_error_campo;}
                        if(clase_validaciones.validar_fecha_nacimiento(txt_10.getText().trim())==false){txt_10.setForeground(java.awt.Color.RED);mensaje=mensaje+"Fecha de nacimiento"+mensaje_error_fecha;}
                        if(clase_validaciones.validar_fecha(txt_11.getText().trim())==false){txt_11.setForeground(java.awt.Color.RED);mensaje=mensaje+"Fecha de contratación"+mensaje_error_fecha;}
                        if(clase_validaciones.validar_numero_contacto(txt_12.getText().trim())==false){txt_12.setForeground(java.awt.Color.RED);mensaje=mensaje+mensaje_error_num_contacto;}
                        if(clase_validaciones.validar_correo(txt_13.getText().trim())==false){txt_13.setForeground(java.awt.Color.RED);mensaje=mensaje+mensaje_error_correo;}
                        if(cmb_1.getSelectedIndex()<0){mensaje=mensaje+mensaje_error_seleccion+" estado.\n";}
                        if(clase_validaciones.validar_existencia_registro("Empleados","num_identidad", txt_2.getText().trim())==false)
                            {txt_2.setForeground(java.awt.Color.RED);mensaje=mensaje+"Número de identidad"+mensaje_error_duplicados;}
                        if(clase_validaciones.validar_existencia_registro("Empleados","celular",txt_12.getText().trim())==false)
                            {txt_12.setForeground(java.awt.Color.RED);mensaje=mensaje+"Número de contacto"+mensaje_error_duplicados;}
                        if(clase_validaciones.validar_existencia_registro("Empleados", "correo_electronico",txt_13.getText().trim())==false)
                            {txt_13.setForeground(java.awt.Color.RED);mensaje=mensaje+"Correo electrónico"+mensaje_error_duplicados;}
                        JOptionPane.showMessageDialog(null,mensaje_error_validacion+mensaje,"ERROR",JOptionPane.ERROR_MESSAGE);
                        mensaje="";
                    }
                    
                }
                if(tabla=="Proveedores"){
                    
                    if(clase_validaciones.validar_existencia_registro("Proveedores","n_identificacion", txt_2.getText().trim())==true &&
                        clase_validaciones.validar_id_rtn(txt_2.getText().trim())==true && 
                        clase_validaciones.validar_campo(txt_3.getText().trim())==true && 
                        clase_validaciones.validar_campo(txt_10.getText().trim())==true && 
                        clase_validaciones.validar_numero_contacto(txt_11.getText().trim())==true &&
                        clase_validaciones.validar_correo(txt_12.getText().trim()) == true && 
                        clase_validaciones.validar_existencia_registro("Proveedores","celular",txt_11.getText().trim())==true &&
                        clase_validaciones.validar_existencia_registro("Proveedores", "correo_electronico",txt_12.getText().trim())==true && 
                        cmb_1.getSelectedIndex()>=0 && 
                        txta_3.getText().length()>0){

                        comando_sql="execute Procedimiento_insertar_Proveedores ?,?,?,?,?,?,? ";
                        codigo_cmb_1=consultar_codigo_de_registro("SELECT cod_estado FROM Estados WHERE nombre='"+cmb_1.getSelectedItem().toString().trim()+"'");
                         try {
                             conexion=clase_conexion.conectar();
                            if(clase_conexion.obtener_estado_conexion()==true){
                             PreparedStatement pst=conexion.prepareCall(comando_sql);
                             pst.setString(1,txt_2.getText().trim());
                             pst.setString(2,txt_3.getText().trim());
                             pst.setString(3,txt_10.getText().trim());
                             pst.setString(4,txt_11.getText().trim());
                             pst.setString(5,txt_12.getText().trim());
                             pst.setString(6,txta_3.getText().trim());
                             pst.setInt(7,codigo_cmb_1);
                             pst.execute();
                             actualizar_pantalla(accion_realizada); 
                             conexion=null;
                             clase_conexion.cerrar_conexion();
                            } 
                         } catch (SQLException ex) {
                             JOptionPane.showMessageDialog(null,"Ocurrió un error al insertar el registro, intente nuevamente "+ex,"ERROR",JOptionPane.ERROR_MESSAGE);
                         }    
                         
                    }else{
                        if(clase_validaciones.validar_id_rtn(txt_2.getText().trim())==false){txt_2.setForeground(java.awt.Color.RED);mensaje=mensaje+mensaje_error_num_id_rtn;}
                        if(clase_validaciones.validar_campo(txt_3.getText().trim())==false){txt_3.setForeground(java.awt.Color.RED);mensaje=mensaje+"Nombre"+mensaje_error_campo;}                     
                        if(clase_validaciones.validar_campo(txt_10.getText().trim())==false){txt_10.setForeground(java.awt.Color.RED);mensaje=mensaje+"Apellido"+mensaje_error_campo;}                       
                        if(clase_validaciones.validar_numero_contacto(txt_11.getText().trim())==false){txt_11.setForeground(java.awt.Color.RED);mensaje=mensaje+mensaje_error_num_contacto;}
                        if(clase_validaciones.validar_correo(txt_12.getText().trim())==false){txt_12.setForeground(java.awt.Color.RED);mensaje=mensaje+mensaje_error_correo;}
                        if(cmb_1.getSelectedIndex()<0){mensaje=mensaje+mensaje_error_seleccion+" estado.\n";}
                        if(clase_validaciones.validar_existencia_registro("Proveedores","n_identificacion", txt_2.getText().trim())==false)
                            {txt_2.setForeground(java.awt.Color.RED);mensaje=mensaje+"Número de identidad"+mensaje_error_duplicados;}
                        if(clase_validaciones.validar_existencia_registro("Proveedores","celular",txt_11.getText().trim())==false)
                            {txt_11.setForeground(java.awt.Color.RED);mensaje=mensaje+"Número de contacto"+mensaje_error_duplicados;}
                        if(clase_validaciones.validar_existencia_registro("Proveedores", "correo_electronico",txt_12.getText().trim())==false)
                            {txt_12.setForeground(java.awt.Color.RED);mensaje=mensaje+"Correo electrónico"+mensaje_error_duplicados;}
                        JOptionPane.showMessageDialog(null,mensaje_error_validacion+mensaje,"ERROR",JOptionPane.ERROR_MESSAGE);
                        mensaje="";
                    }
                    
                }
                if(tabla=="Usuarios"){
                    
                      if(clase_validaciones.validar_nombre_de_usuario(txt_2.getText().trim())==true && 
                        clase_validaciones.validar_contraseña(txt_10.getText().trim())==true && 
                        clase_validaciones.validar_contraseña(txt_11.getText().trim())==true && 
                        txt_10.getText().trim().equals(txt_11.getText().trim()) && 
                        clase_validaciones.validar_existencia_registro("Usuarios","nombre_usuario", txt_2.getText().trim())==true && 
                        cmb_1.getSelectedIndex()>=0 &&
                        cmb_3.getSelectedIndex()>=0){
                        
                            comando_sql="execute Procedimiento_insertar_usuarios ?,?,?,?,?";
                            codigo_cmb_1=consultar_codigo_de_registro("SELECT cod_nivel_acceso FROM Niveles_Acceso WHERE nombre_nivel='"+cmb_1.getSelectedItem().toString()+"'");
                            
                             try {
                                 conexion=clase_conexion.conectar();
                                if(clase_conexion.obtener_estado_conexion()==true){
                                    PreparedStatement pst=conexion.prepareCall(comando_sql);
                                    pst.setInt(1,codigo_cmb_1); //Nivel de acceso
                                    pst.setString(2,txt_2.getText().trim());//nombre
                                    pst.setString(3,txt_10.getText().trim());//contraseña
                                    pst.setInt(4,Integer.parseInt(cmb_3.getSelectedItem().toString())); // empleado
                                    pst.setInt(5,1); // estado
                                    pst.execute();
                                    txt_10.setVisible(false);
                                    txt_11.setVisible(false);
                                    actualizar_pantalla(accion_realizada);
                                    conexion=null;
                                    clase_conexion.cerrar_conexion();
                                }
                                
                            } catch (SQLException ex) {
                                JOptionPane.showMessageDialog(null,"Ocurrió un error al insertar el registro, intente nuevamente "+ex,"ERROR",JOptionPane.ERROR_MESSAGE);
                            }    
                        
                    }else{
                        

                        if(cmb_1.getSelectedIndex()<0){mensaje=mensaje+mensaje_error_seleccion+" nivel de acceso.\n";}
                        if(cmb_3.getSelectedIndex()<0){mensaje=mensaje+mensaje_error_seleccion+" empleado.\n";}
                        if(clase_validaciones.validar_nombre_de_usuario(txt_2.getText().trim())==false)
                            {txt_2.setForeground(java.awt.Color.RED);mensaje=mensaje+mensaje_error_nombre_usuario;}
                        if(clase_validaciones.validar_existencia_registro("Usuarios","nombre_usuario",txt_2.getText().trim())==false)
                            {txt_2.setForeground(java.awt.Color.RED);mensaje=mensaje+"Usuario"+mensaje_error_duplicados;}      
                        if(clase_validaciones.validar_contraseña(txt_10.getText().trim())==false)
                            {txt_10.setForeground(java.awt.Color.RED);mensaje=mensaje+" \n Su contraseña debe tener de 8 a 30 caraceres, \n Al menos un número ,una letra mayúscula y una minúscula.\n";}
                        if(!txt_10.getText().trim().equals(txt_11.getText().trim()))
                            {txt_11.setForeground(java.awt.Color.RED);txt_10.setForeground(java.awt.Color.RED);mensaje=mensaje+" \n Ambas contraseñas deben coincidir. \n";}
                        JOptionPane.showMessageDialog(null,mensaje_error_validacion+mensaje,"ERROR",JOptionPane.ERROR_MESSAGE);
                        mensaje="";
                    }
                    
                }
                if(tabla=="Tipos_de_Importe"){
                    
     
                    if(clase_validaciones.validar_campo(txt_2.getText().trim())==true && 
                        clase_validaciones.validar_cantidad_entera(txt_10.getText().trim())==true && 
                        cmb_1.getSelectedIndex()>=0 && 
                        txta_2.getText().length()>0 && 
                        clase_validaciones.validar_existencia_registro("Tipos_de_Importe","nombre", txt_2.getText().trim())==true){
                        
  
                            comando_sql="execute Procedimiento_insertar_tipos_de_importe ?,?,?,?";
                            codigo_cmb_1=consultar_codigo_de_registro("SELECT cod_estado FROM Estados WHERE nombre='"+cmb_1.getSelectedItem().toString()+"'");
                             try {
                                 conexion=clase_conexion.conectar();
                                if(clase_conexion.obtener_estado_conexion()==true){
                                    PreparedStatement pst=conexion.prepareCall(comando_sql);
                                    pst.setString(1,txt_2.getText().trim());
                                    pst.setString(2,txta_2.getText().trim());
                                    pst.setInt(3,Integer.parseInt(txt_10.getText().trim()));
                                    pst.setInt(4,codigo_cmb_1);                     
                                    pst.execute();
                                    actualizar_pantalla(accion_realizada);
                                    conexion=null;
                                    clase_conexion.cerrar_conexion();
                                }
                             } catch (SQLException ex) {
                                 JOptionPane.showMessageDialog(null,"Ocurrió un error al insertar el registro, intente nuevamente "+ex,"ERROR",JOptionPane.ERROR_MESSAGE);
                             } 
                             
                    }else{
                       
                        if(cmb_1.getSelectedIndex()<0){mensaje=mensaje+mensaje_error_seleccion+" estado.\n";}
                        if(clase_validaciones.validar_campo(txt_2.getText().trim())==false){txt_2.setForeground(java.awt.Color.RED);mensaje=mensaje+"Nombre"+mensaje_error_campo;}
                        if(clase_validaciones.validar_cantidad_entera(txt_10.getText().trim())==false){txt_10.setForeground(java.awt.Color.RED);mensaje=mensaje+"Porcentaje"+mensaje_error_cant_entera;}
                        if(clase_validaciones.validar_existencia_registro("Tipos_de_Importe","nombre", txt_2.getText().trim())==false)
                            {txt_2.setForeground(java.awt.Color.RED);mensaje=mensaje+"Importe"+mensaje_error_duplicados;}
                        JOptionPane.showMessageDialog(null,mensaje_error_validacion+mensaje,"ERROR",JOptionPane.ERROR_MESSAGE);
                        mensaje="";
                    }
                    
                }
                if(tabla=="Datos_Organizacion"){
                    
                   if(clase_validaciones.validar_rtn(txt_2.getText().trim())==true && clase_validaciones.validar_campo(txt_3.getText().trim())==true && 
                      clase_validaciones.validar_campo(txt_4.getText().trim())==true && clase_validaciones.validar_campo(txt_5.getText().trim())==true && 
                      clase_validaciones.validar_numero_contacto(txt_12.getText().trim())==true && clase_validaciones.validar_numero_contacto(txt_13.getText().trim())==true && 
                      clase_validaciones.validar_numero_contacto(txt_14.getText().trim())==true && clase_validaciones.validar_numero_contacto(txt_15.getText().trim())==true && 
                      clase_validaciones.validar_fecha(txt_19.getText().trim())==true && clase_validaciones.validar_correo(txt_10.getText().trim())==true &&
                      clase_validaciones.validar_correo(txt_11.getText().trim())==true && txta_1.getText().length()>0 && txta_2.getText().length()>0 && txta_3.getText().length()>0 &&
                      clase_validaciones.validar_CAI(txt_16.getText().trim())==true){                  
  
                            comando_sql="execute Procedimiento_insertar_datos_organizacion ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?";
                            try {
                                conexion=clase_conexion.conectar();
                                if(clase_conexion.obtener_estado_conexion()==true){
                                    PreparedStatement pst=conexion.prepareCall(comando_sql);
                                    pst.setString(1,txt_2.getText().trim());
                                    pst.setString(2,txt_3.getText().trim());
                                    pst.setString(3,txt_4.getText().trim());
                                    pst.setString(4,txt_5.getText().trim());
                                    pst.setString(5,txt_6.getText().trim());
                                    pst.setString(6,txt_7.getText().trim());
                                    pst.setString(7,txt_8.getText().trim());
                                    pst.setString(8,txt_10.getText().trim());
                                    pst.setString(9,txt_11.getText().trim());
                                    pst.setString(10,txt_12.getText().trim());
                                    pst.setString(11,txt_13.getText().trim());
                                    pst.setString(12,txt_14.getText().trim());
                                    pst.setString(13,txt_15.getText().trim());
                                    pst.setString(14,txt_16.getText().trim());
                                    pst.setDate(15,Date.valueOf(txt_19.getText().trim()));
                                    pst.setString(16,txt_20.getText().trim());
                                    pst.setString(17,txt_21.getText().trim());
                                    pst.setString(18,txta_1.getText().trim());
                                    pst.setString(19,txta_2.getText().trim());
                                    pst.setString(20,txta_3.getText().trim());
                                    pst.setInt(21,1);
                                    pst.execute();
                                    actualizar_pantalla(accion_realizada);
                                    conexion=null;
                                    clase_conexion.cerrar_conexion();
                                }
                            } catch (SQLException ex) {
                                 JOptionPane.showMessageDialog(null,"Ocurrió un error al insertar el registro, intente nuevamente "+ex,"ERROR",JOptionPane.ERROR_MESSAGE);
                            }
                            try{
                                prepared_statement=conexion.prepareStatement(" UPDATE [dbo].[Datos_Organizacion] SET [cod_estado] = 2,[fecha_modificacion] = GETDATE() " +
                                                        " WHERE [cod_datos_organizacion]!=(SELECT MAX([cod_datos_organizacion]) FROM [Datos_Organizacion]) ");
                                prepared_statement.executeUpdate();
                            }catch(SQLException ex){
                                JOptionPane.showMessageDialog(null,"ERROR al actualizar datos de organización antiguos, intente nuevamente "+ex,"ERROR",JOptionPane.ERROR_MESSAGE);
                            } 
                             
                    }else{
                       
                        if(clase_validaciones.validar_rtn(txt_2.getText().trim())==false){txt_2.setForeground(java.awt.Color.RED);mensaje=mensaje+mensaje_error_num_rtn;}
                        if(clase_validaciones.validar_campo(txt_3.getText().trim())==false){txt_3.setForeground(java.awt.Color.RED);mensaje=mensaje+"Nombre"+mensaje_error_campo;}
                        if(clase_validaciones.validar_campo(txt_4.getText().trim())==false){txt_4.setForeground(java.awt.Color.RED);mensaje=mensaje+"Nombre corto"+mensaje_error_campo;}
                        if(clase_validaciones.validar_campo(txt_5.getText().trim())==false){txt_5.setForeground(java.awt.Color.RED);mensaje=mensaje+"Nombre agencia"+mensaje_error_campo;}                      
                        if(clase_validaciones.validar_numero_contacto(txt_12.getText().trim())==false){txt_12.setForeground(java.awt.Color.RED);mensaje=mensaje+mensaje_error_num_contacto;}
                        if(clase_validaciones.validar_numero_contacto(txt_13.getText().trim())==false){txt_13.setForeground(java.awt.Color.RED);mensaje=mensaje+mensaje_error_num_contacto;}
                        if(clase_validaciones.validar_numero_contacto(txt_14.getText().trim())==false){txt_14.setForeground(java.awt.Color.RED);mensaje=mensaje+mensaje_error_num_contacto;}
                        if(clase_validaciones.validar_numero_contacto(txt_15.getText().trim())==false){txt_15.setForeground(java.awt.Color.RED);mensaje=mensaje+mensaje_error_num_contacto;}
                        if(clase_validaciones.validar_CAI(txt_16.getText().trim())==false){txt_16.setForeground(java.awt.Color.RED);mensaje=mensaje+"CAI debe contener 37 carácteres alfanuméricos. \n";}
                        if(clase_validaciones.validar_fecha(txt_19.getText().trim())==false){txt_12.setForeground(java.awt.Color.RED);mensaje=mensaje+"Fecha límite de emisión"+mensaje_error_fecha;}
                        if(clase_validaciones.validar_correo(txt_10.getText().trim())==false){txt_10.setForeground(java.awt.Color.RED);mensaje=mensaje+mensaje_error_correo;}
                        if(clase_validaciones.validar_correo(txt_11.getText().trim())==false){txt_11.setForeground(java.awt.Color.RED);mensaje=mensaje+mensaje_error_correo;}
                        
                        JOptionPane.showMessageDialog(null,mensaje_error_validacion+mensaje,"ERROR",JOptionPane.ERROR_MESSAGE);
                        mensaje="";
                    }
                    
                }
                if(tabla=="Clientes"){

                    if(clase_validaciones.validar_id_rtn(txt_10.getText().trim())==true && 
                        clase_validaciones.validar_existencia_registro("Clientes","identificacion", txt_10.getText().trim())==true &&
                        clase_validaciones.validar_campo(txt_2.getText().trim())==true &&
                        clase_validaciones.validar_campo(txt_3.getText().trim())==true && 
                        clase_validaciones.validar_numero_contacto(txt_11.getText().trim())==true && 
                        clase_validaciones.validar_correo(txt_12.getText().trim())==true &&
                        clase_validaciones.validar_existencia_registro("Clientes","celular",txt_11.getText().trim())==true &&
                        clase_validaciones.validar_existencia_registro("Clientes","correo_electronico", txt_12.getText().trim())==true &&                        
                        cmb_1.getSelectedIndex()>=0 && 
                        txta_3.getText().length()>0){ 
                   
                        comando_sql="execute Procedimiento_insertar_clientes ?,?,?,?,?,?,?";
                        codigo_cmb_1=consultar_codigo_de_registro("SELECT cod_estado FROM Estados WHERE nombre='"+cmb_1.getSelectedItem().toString()+"'");
                         try {
                             conexion=clase_conexion.conectar();
                            if(clase_conexion.obtener_estado_conexion()==true){
                                PreparedStatement pst=conexion.prepareCall(comando_sql);
                                pst.setString(1,txt_10.getText().trim());
                                pst.setString(2,txt_2.getText().trim());
                                pst.setString(3,txt_3.getText().trim());
                                pst.setString(4,txt_11.getText().trim());
                                pst.setString(5,txt_12.getText().trim());
                                pst.setString(6,txta_3.getText().trim());
                                pst.setInt(7,codigo_cmb_1);
                                pst.execute();
                                actualizar_pantalla(accion_realizada);
                                conexion=null;
                                clase_conexion.cerrar_conexion();
                            }
                         } catch (SQLException ex) {
                             JOptionPane.showMessageDialog(null,"Ocurrió un error al insertar el registro, intente nuevamente "+ex,"ERROR",JOptionPane.ERROR_MESSAGE);
                         }
                             
                    }else{
                        
                        if(cmb_1.getSelectedIndex()<0){mensaje=mensaje+mensaje_error_seleccion+" estado.\n";}
                        if(clase_validaciones.validar_campo(txt_3.getText().trim())==false){txt_3.setForeground(java.awt.Color.RED);mensaje=mensaje+"Nombre"+mensaje_error_campo;}
                        if(clase_validaciones.validar_campo(txt_2.getText().trim())==false){txt_2.setForeground(java.awt.Color.RED);mensaje=mensaje+"Apellido"+mensaje_error_campo;}                                              
                        if(clase_validaciones.validar_id_rtn(txt_10.getText().trim())==false){txt_10.setForeground(java.awt.Color.RED);mensaje=mensaje+mensaje_error_num_id_rtn;}
                        if(clase_validaciones.validar_numero_contacto(txt_11.getText().trim())==false){txt_11.setForeground(java.awt.Color.RED);mensaje=mensaje+mensaje_error_num_contacto;}
                        if(clase_validaciones.validar_correo(txt_12.getText().trim())==false){txt_12.setForeground(java.awt.Color.RED);mensaje=mensaje+mensaje_error_correo;}
                        if(clase_validaciones.validar_existencia_registro("Clientes","identificacion", txt_10.getText().trim())==false)
                            {txt_10.setForeground(java.awt.Color.RED);mensaje=mensaje+"Número de identidad"+mensaje_error_duplicados;}
                        if(clase_validaciones.validar_existencia_registro("Clientes","celular",txt_11.getText().trim())==false)
                            {txt_12.setForeground(java.awt.Color.RED);mensaje=mensaje+"Número de contacto"+mensaje_error_duplicados;}
                        if(clase_validaciones.validar_existencia_registro("Clientes","correo_electronico", txt_12.getText().trim())==false)
                            {txt_12.setForeground(java.awt.Color.RED);mensaje=mensaje+"Correo electrónico"+mensaje_error_duplicados;}
                        JOptionPane.showMessageDialog(null,mensaje_error_validacion+mensaje,"ERROR",JOptionPane.ERROR_MESSAGE); 
                        mensaje="";
                    }
                    
                }
                 if(tabla=="Colecciones"){
                     
                    if(clase_validaciones.validar_fecha_posterior(txt_10.getText().trim())==true && 
                        clase_validaciones.validar_campo(txt_2.getText().trim())==true && 
                        clase_validaciones.validar_fecha_posterior(txt_11.getText().trim())==true &&
                        clase_validaciones.validar_rango_de_fechas(txt_11.getText().trim(),txt_10.getText().trim())==true && 
                        cmb_1.getSelectedIndex()>=0 && 
                        txta_1.getText().length()>0){
                        
                            comando_sql="execute Procedimiento_insertar_colecciones ?,?,?,?,?";
                            codigo_cmb_1=consultar_codigo_de_registro("SELECT cod_estado FROM Estados WHERE nombre='"+cmb_1.getSelectedItem().toString()+"'");
                             try {
                                 conexion=clase_conexion.conectar();
                                if(clase_conexion.obtener_estado_conexion()==true){
                                    PreparedStatement pst=conexion.prepareCall(comando_sql);
                                    pst.setString(1,txt_2.getText().trim());
                                    pst.setString(2,txta_1.getText().trim());
                                    pst.setInt(3,codigo_cmb_1);
                                    pst.setDate(4,Date.valueOf(txt_10.getText().trim()));
                                    pst.setDate(5,Date.valueOf(txt_11.getText().trim()));
                                    pst.execute();
                                    actualizar_pantalla(accion_realizada);
                                    conexion=null;
                                    clase_conexion.cerrar_conexion();
                                }
                             } catch (SQLException ex) {
                                 JOptionPane.showMessageDialog(null,"Ocurrió un error al insertar el registro, intente nuevamente "+ex,"ERROR",JOptionPane.ERROR_MESSAGE);
                             }       
                    }else{
                        
                        if(cmb_1.getSelectedIndex()<0){mensaje=mensaje+mensaje_error_seleccion+" estado.\n";}
                        if(clase_validaciones.validar_campo(txt_2.getText().trim())==false){txt_2.setForeground(java.awt.Color.RED);mensaje=mensaje+"Nombre"+mensaje_error_campo;}                      
                        if(clase_validaciones.validar_fecha_posterior(txt_10.getText().trim())==false){txt_10.setForeground(java.awt.Color.RED);mensaje=mensaje+"Fecha inicial"+mensaje_error_fecha;}
                        if(clase_validaciones.validar_fecha_posterior(txt_11.getText().trim())==false){txt_11.setForeground(java.awt.Color.RED);mensaje=mensaje+"Fecha final"+mensaje_error_fecha;}
                        if(clase_validaciones.validar_rango_de_fechas(txt_11.getText().trim(),txt_10.getText().trim())==false)
                            {txt_11.setForeground(java.awt.Color.RED);txt_10.setForeground(java.awt.Color.RED);mensaje=mensaje+mensaje_error_rango_fecha;}
                        JOptionPane.showMessageDialog(null,mensaje_error_validacion+mensaje,"ERROR",JOptionPane.ERROR_MESSAGE);
                        mensaje="";
                    }
                    
                }
                 if(tabla=="Productos_Venta"){
                     
                    if(clase_validaciones.validar_campo(txt_2.getText().trim())==true && 
                        clase_validaciones.validar_cantidad_decimal(txt_3.getText().trim())==true && 
                        clase_validaciones.validar_cantidad_decimal(txt_4.getText().trim())==true && 
                        clase_validaciones.validar_cantidad_entera_mayor(txt_10.getText().trim())==true && 
                        clase_validaciones.validar_cantidad_entera_mayor(txt_11.getText().trim())==true && 
                        cmb_1.getSelectedIndex()>=0 &&
                        cmb_2.getSelectedIndex()>=0 && 
                        cmb_3.getSelectedIndex()>=0 && 
                        txta_2.getText().length()>0 &&
                        clase_validaciones.validar_existencia_registro("Productos_Venta","nombre_producto", txt_2.getText().trim())==true){
                        
                            comando_sql="execute Procedimiento_insertar_productos_venta ?,?,?,?,?,?,?,?,?";
                            codigo_cmb_1=consultar_codigo_de_registro("SELECT cod_coleccion FROM Colecciones WHERE nombre_coleccion='"+cmb_1.getSelectedItem().toString()+"'");
                            codigo_cmb_2=consultar_codigo_de_registro("SELECT cod_estado FROM Estados WHERE nombre='"+cmb_2.getSelectedItem().toString()+"'");
                            codigo_cmb_3=consultar_codigo_de_registro("SELECT cod_tipo_importe FROM Tipos_de_Importe WHERE nombre='"+cmb_3.getSelectedItem().toString()+"'");
                             try {
                                 conexion=clase_conexion.conectar();
                                if(clase_conexion.obtener_estado_conexion()==true){
                                    PreparedStatement pst=conexion.prepareCall(comando_sql);
                                    pst.setInt(1,codigo_cmb_1);//coleccion
                                    pst.setString(2,txt_2.getText().trim()); //Nombre Producto
                                    pst.setString(3,txta_2.getText().trim()); //Descripcion
                                    pst.setDouble(4,Double.parseDouble(txt_3.getText().trim())); //precio_unitario
                                    pst.setDouble(5,Double.parseDouble(txt_4.getText().trim())); //costo_unitario
                                    pst.setInt(6,Integer.parseInt(txt_10.getText().trim())); //stock
                                    pst.setInt(7,Integer.parseInt(txt_11.getText().trim())); //punto_reorden
                                    pst.setInt(8,codigo_cmb_2); //cod_estado
                                    pst.setInt(9,codigo_cmb_3); //cod_tipo_importe
                                    pst.execute();
                                    actualizar_pantalla(accion_realizada);
                                    conexion=null;
                                    clase_conexion.cerrar_conexion();
                                }
                             } catch (SQLException ex) {
                                 JOptionPane.showMessageDialog(null,"Ocurrió un error al insertar el registro, intente nuevamente "+ex,"ERROR",JOptionPane.ERROR_MESSAGE);
                             }  
                    }else{
                        
                        if(cmb_1.getSelectedIndex()<0){mensaje=mensaje+mensaje_error_seleccion+" colección.\n";}
                        if(cmb_2.getSelectedIndex()<0){mensaje=mensaje+mensaje_error_seleccion+" estado.\n";}
                        if(cmb_3.getSelectedIndex()<0){mensaje=mensaje+mensaje_error_seleccion+" importe.\n";}
                        if(clase_validaciones.validar_campo(txt_2.getText().trim())==false){txt_2.setForeground(java.awt.Color.RED);mensaje=mensaje+"Nombre"+mensaje_error_campo;}
                        if(clase_validaciones.validar_cantidad_decimal(txt_3.getText().trim())==false){txt_3.setForeground(java.awt.Color.RED);mensaje=mensaje+"Precio"+mensaje_error_cant_decimal;}
                        if(clase_validaciones.validar_cantidad_decimal(txt_4.getText().trim())==false){txt_4.setForeground(java.awt.Color.RED);mensaje=mensaje+"Costo"+mensaje_error_cant_decimal;}                                              
                        if(clase_validaciones.validar_cantidad_entera_mayor(txt_10.getText().trim())==false){txt_10.setForeground(java.awt.Color.RED);mensaje=mensaje+"Stock"+mensaje_error_cant_entera;}
                        if(clase_validaciones.validar_cantidad_entera_mayor(txt_11.getText().trim())==false){txt_11.setForeground(java.awt.Color.RED);mensaje=mensaje+"Punto de reorden"+mensaje_error_cant_entera;}
                        if(clase_validaciones.validar_existencia_registro("Productos_Venta","nombre_producto", txt_2.getText().trim())==false)
                            {txt_2.setForeground(java.awt.Color.RED);mensaje=mensaje+"Producto"+mensaje_error_duplicados;}
                        JOptionPane.showMessageDialog(null,mensaje_error_validacion+mensaje,"ERROR",JOptionPane.ERROR_MESSAGE);
                        mensaje="";
                    }
                    
                }
                 
                if(tabla=="Productos_Materia_Prima"){
                     
                    if(clase_validaciones.validar_campo(txt_2.getText().trim())==true && 
                        clase_validaciones.validar_cantidad_decimal(txt_3.getText().trim())==true && 
                        clase_validaciones.validar_cantidad_entera_mayor(txt_10.getText().trim())==true && 
                        clase_validaciones.validar_cantidad_entera_mayor(txt_11.getText().trim())==true && 
                        cmb_1.getSelectedIndex()>=0 && 
                        cmb_2.getSelectedIndex()>=0 && 
                        txta_2.getText().length()>0 &&
                        clase_validaciones.validar_existencia_registro("Productos_Materia_Prima","nombre", txt_2.getText().trim())==true){ 
                        
                                comando_sql="execute Procedimiento_insertar_productos_materia_prima ?,?,?,?,?,?,?";
                                codigo_cmb_1=consultar_codigo_de_registro("SELECT cod_estado FROM Estados WHERE nombre='"+cmb_1.getSelectedItem().toString()+"'");
                                try {
                                    conexion=clase_conexion.conectar();
                                    if(clase_conexion.obtener_estado_conexion()==true){
                                        PreparedStatement pst=conexion.prepareCall(comando_sql);
                                        pst.setString(1,txt_2.getText().trim()); //  Nombre producto MP
                                        pst.setString(2,txta_2.getText().trim()); // descripcion
                                        pst.setDouble(3,Double.parseDouble(txt_3.getText().trim())); //  Precio Unitario
                                        pst.setString(4,cmb_2.getSelectedItem().toString()); //  Tipo Unidad
                                        pst.setInt(5,Integer.parseInt(txt_10.getText().trim())); // stock
                                        pst.setInt(6,Integer.parseInt(txt_11.getText().trim())); // Punto de Reorden
                                        pst.setInt(7,codigo_cmb_1); // estado
                                        pst.execute();
                                        actualizar_pantalla(accion_realizada);
                                        conexion=null;
                                        clase_conexion.cerrar_conexion();
                                }
                                } catch (SQLException ex) {
                                    JOptionPane.showMessageDialog(null,"Ocurrió un error al insertar el registro, intente nuevamente "+ex,"ERROR",JOptionPane.ERROR_MESSAGE);
                                }                              
                    }else{
                        
                        if(cmb_1.getSelectedIndex()<0){mensaje=mensaje+mensaje_error_seleccion+" estado.\n";}
                        if(cmb_2.getSelectedIndex()<0){mensaje=mensaje+mensaje_error_seleccion+" tipo de unidad.\n";}
                        if(clase_validaciones.validar_campo(txt_2.getText().trim())==false){txt_2.setForeground(java.awt.Color.RED);mensaje=mensaje+"Nombre"+mensaje_error_campo;}
                        if(clase_validaciones.validar_cantidad_decimal(txt_3.getText().trim())==false){txt_3.setForeground(java.awt.Color.RED);mensaje=mensaje+"Precio"+mensaje_error_cant_decimal;}                                          
                        if(clase_validaciones.validar_cantidad_entera_mayor(txt_10.getText().trim())==false){txt_10.setForeground(java.awt.Color.RED);mensaje=mensaje+"Stock"+mensaje_error_cant_entera;}
                        if(clase_validaciones.validar_cantidad_entera_mayor(txt_11.getText().trim())==false){txt_11.setForeground(java.awt.Color.RED);mensaje=mensaje+"Punto de reorden"+mensaje_error_cant_entera;}
                        if(clase_validaciones.validar_existencia_registro("Productos_Materia_Prima","nombre", txt_2.getText().trim())==false)
                            {txt_2.setForeground(java.awt.Color.RED);mensaje=mensaje+"Nombre"+mensaje_error_duplicados;}
                        JOptionPane.showMessageDialog(null,mensaje_error_validacion+mensaje,"ERROR",JOptionPane.ERROR_MESSAGE);
                        mensaje="";
                    }
                    
                }
                 if(tabla=="Inventario_Materia_Prima"){
                     
                    if(clase_validaciones.validar_cantidad_entera_mayor(txt_10.getText().trim())==true && 
                        cmb_1.getSelectedIndex()>=0 && 
                        cmb_2.getSelectedIndex()>=0 && 
                        cmb_3.getSelectedIndex()>=0){ 
                        codigo_cmb_2=consultar_codigo_de_registro("SELECT cod_producto_mt FROM Productos_Materia_Prima WHERE nombre='"+cmb_2.getSelectedItem().toString()+"'");
                        codigo_cmb_3=consultar_codigo_de_registro("SELECT cod_estado FROM Estados WHERE nombre='"+cmb_3.getSelectedItem().toString()+"'");
                        int stock_disponible,stock_solicitado=Integer.parseInt(txt_10.getText().trim());
                           
                        if(cmb_1.getSelectedIndex()>-1 && cmb_2.getSelectedIndex()>-1 && cmb_3.getSelectedIndex()>-1){   

                                if(cmb_1.getSelectedItem().equals("SALIDA")){
                                    try{
                                        conexion=clase_conexion.conectar();
                                        if(clase_conexion.obtener_estado_conexion()==true){
                                            prepared_statement=conexion.prepareStatement("SELECT * FROM  Productos_Materia_Prima WHERE cod_producto_mt=?");
                                            prepared_statement.setInt(1,codigo_cmb_2);
                                            result_set=prepared_statement.executeQuery();
                                            if(result_set.next()){
                                                stock_disponible=result_set.getInt("stock");
                                            }else{
                                                JOptionPane.showMessageDialog(null,"Producto no encontrado ","AVISO",JOptionPane.INFORMATION_MESSAGE);
                                                stock_disponible=0;
                                            }
                                                
                                            if(stock_disponible>=stock_solicitado){
                                                comando_sql="execute Procedimiento_insertar_inventario_materia_prima ?,?,?,?,?";
                                                try {
                                                    PreparedStatement pst=conexion.prepareCall(comando_sql);
                                                    pst.setString(1,cmb_1.getSelectedItem().toString()); //accion
                                                    pst.setInt(2,cod_empleado_actual); //  Codigo empleado
                                                    pst.setInt(3,Integer.parseInt(txt_10.getText().trim())); //  cantidad
                                                    pst.setInt(4,codigo_cmb_2); //producto materia prima
                                                    pst.setInt(5,codigo_cmb_3); //estado
                                                    pst.execute();
                                                    actualizar_pantalla(accion_realizada);

                                            
                                            } catch (SQLException ex) {
                                                JOptionPane.showMessageDialog(null,"Ocurrió un error al insertar el registro, intente nuevamente 1"+ex,"ERROR",JOptionPane.ERROR_MESSAGE);
                                            }
                                            }else{
                                                JOptionPane.showMessageDialog(null,"AVISO: La cantidad que desea es menor a al STOCK disponible del Producto: "+cmb_3.getSelectedItem().toString(),"AVISO",JOptionPane.WARNING_MESSAGE);
                                            }
                                            
                                            conexion=null;
                                            clase_conexion.cerrar_conexion();
                                            prepared_statement.close();
                                            result_set.close();
                                        }    
                                    }catch(SQLException e){
                                        JOptionPane.showMessageDialog(this,"Ocurrió un error al buscar producto "+e,"ERROR",JOptionPane.ERROR_MESSAGE);
                                    }
                                }else{

                                        comando_sql="execute Procedimiento_insertar_inventario_materia_prima ?,?,?,?,?";
                                        try {
                                            conexion=clase_conexion.conectar();
                                            if(clase_conexion.obtener_estado_conexion()==true){
                                                PreparedStatement pst=conexion.prepareCall(comando_sql);
                                                pst.setString(1, cmb_1.getSelectedItem().toString()); //accion
                                                pst.setInt(2,cod_empleado_actual); //  Codigo empleado
                                                pst.setInt(3,Integer.parseInt(txt_10.getText().trim())); //  cantidad
                                                pst.setInt(4,codigo_cmb_2); //producto materia prima
                                                pst.setInt(5,codigo_cmb_3); //estado
                                                pst.execute();
                                                actualizar_pantalla(accion_realizada);
                                                conexion=null;
                                                clase_conexion.cerrar_conexion();
                                                prepared_statement.close();
                                                result_set.close();
                                            }    
                                        } catch (SQLException ex) {
                                            JOptionPane.showMessageDialog(null,"Ocurrió un error al insertar el registro, intente nuevamente 2"+ex,"ERROR",JOptionPane.ERROR_MESSAGE);
                                        }
                                }
                        }else{
                            JOptionPane.showMessageDialog(null,"ERROR, Debe completar y seleccionar los campos requeridos ","ERROR",JOptionPane.ERROR_MESSAGE);
                        }   
                    }else{
                                                                   
                        if(clase_validaciones.validar_cantidad_entera_mayor(txt_10.getText().trim())==false){txt_10.setForeground(java.awt.Color.RED);mensaje=mensaje+"La cantidad"+mensaje_error_cant_entera;}
                        if(cmb_1.getSelectedIndex()<0){mensaje=mensaje+mensaje_error_seleccion+" acción.\n";}
                        if(cmb_2.getSelectedIndex()<0){mensaje=mensaje+mensaje_error_seleccion+" producto.\n";}
                        if(cmb_3.getSelectedIndex()<0){mensaje=mensaje+mensaje_error_seleccion+" estado.\n";}
                        JOptionPane.showMessageDialog(null,mensaje_error_validacion+mensaje,"ERROR",JOptionPane.ERROR_MESSAGE);
                        mensaje=""; 
                    }     
                  
                }
                 if(tabla_secundaria=="Ordenes_Produccion"){
                            
                    if(clase_validaciones.validar_cantidad_entera_mayor(txt_10.getText().trim())==true && 
                        cmb_1.getSelectedIndex()>=0 && 
                        cmb_2.getSelectedIndex()>=0){ 
                        
                        comando_sql="execute Procedimiento_insertar_produccion ?,?,?,?,?";
                        codigo_cmb_1=consultar_codigo_de_registro("SELECT cod_producto_vt FROM Productos_Venta WHERE nombre_producto='"+cmb_1.getSelectedItem().toString()+"'");
                        codigo_cmb_2=consultar_codigo_de_registro("SELECT cod_estado FROM Estados WHERE nombre='"+cmb_2.getSelectedItem().toString()+"'");
                          try {
                              conexion=clase_conexion.conectar();
                              if(clase_conexion.obtener_estado_conexion()==true){
                                    PreparedStatement pst=conexion.prepareCall(comando_sql);
                                    pst.setInt(1,cod_empleado_actual); //  codigo empledo
                                    pst.setInt(2,codigo_cmb_1);//producto venta
                                    pst.setInt(3,Integer.parseInt(txt_10.getText().trim())); // cantidad orden 
                                    pst.setString(4,txt_11.getText().trim()); //  descripcion
                                    pst.setInt(5,codigo_cmb_2); //estado
                                    pst.execute();
                                    actualizar_pantalla(accion_realizada);
                                    conexion=null;
                                    clase_conexion.cerrar_conexion();
                               }
                          } catch (SQLException ex) {
                              JOptionPane.showMessageDialog(null,"Ocurrió un error al insertar el registro, intente nuevamente "+ex,"ERROR",JOptionPane.ERROR_MESSAGE);
                          }                         
                    }else{
                                                                                          
                        if(clase_validaciones.validar_cantidad_entera_mayor(txt_10.getText().trim())==false){txt_10.setForeground(java.awt.Color.RED);mensaje=mensaje+"La cantidad"+mensaje_error_cant_entera;}
                        if(cmb_1.getSelectedIndex()<0){mensaje=mensaje+mensaje_error_seleccion+" producto.\n";}
                        if(cmb_2.getSelectedIndex()<0){mensaje=mensaje+mensaje_error_seleccion+" estado.\n";}
                        JOptionPane.showMessageDialog(null,mensaje_error_validacion+mensaje,"ERROR",JOptionPane.ERROR_MESSAGE);
                        mensaje=""; 
                    }
                    
                }
                 if(tabla_secundaria=="Produccion_Produccion"){

                    if(clase_validaciones.validar_fecha(txt_3.getText().trim())==true && 
                        clase_validaciones.validar_fecha(txt_10.getText().trim())==true && 
                        clase_validaciones.validar_rango_de_fechas(txt_10.getText().trim(),txt_3.getText().trim())==true &&
                        clase_validaciones.validar_cantidad_entera_mayor(txt_11.getText().trim())==true && 
                        cmb_2.getSelectedIndex()>=0 && 
                        cmb_3.getSelectedIndex()>=0){
                        
                            comando_sql="execute Procedimiento_actualizar_produccion ?,?,?,?,?,?";
                            codigo_cmb_2=consultar_codigo_de_registro("SELECT cod_estado FROM Estados WHERE nombre='"+cmb_2.getSelectedItem().toString()+"'");
                             try {
                                 conexion=clase_conexion.conectar();
                                 if(clase_conexion.obtener_estado_conexion()==true){
                                    PreparedStatement pst=conexion.prepareCall(comando_sql);
                                    pst.setInt(1,Integer.parseInt(cmb_3.getSelectedItem().toString().trim())); //  codigo produccion
                                    pst.setDate(2,Date.valueOf(txt_3.getText().trim()));  //fecha inicio
                                    pst.setDate(3,Date.valueOf(txt_10.getText().trim())); //  fecha fin 
                                    pst.setInt(4,Integer.parseInt(txt_11.getText().trim())); // cantidad produccion 
                                    pst.setString(5,txt_12.getText().trim()); //  descripcion
                                    pst.setInt(6,codigo_cmb_2); //estado
                                    pst.execute();
                                    actualizar_pantalla(accion_realizada);
                                    cmb_1.setVisible(true);
                                    cmb_3.setVisible(false);
                                    conexion=null;
                                    clase_conexion.cerrar_conexion();
                                }
                             } catch (SQLException ex) {
                                 JOptionPane.showMessageDialog(null,"Ocurrió un error al insertar el registro, intente nuevamente "+ex,"ERROR",JOptionPane.ERROR_MESSAGE);
                             }
                    }else{
                                                                    
                        if(clase_validaciones.validar_fecha(txt_3.getText().trim())==false){txt_3.setForeground(java.awt.Color.RED);mensaje=mensaje+"Fecha inicial"+mensaje_error_fecha;}                                                                    
                        if(clase_validaciones.validar_fecha(txt_10.getText().trim())==false){txt_10.setForeground(java.awt.Color.RED);mensaje=mensaje+"Fecha final"+mensaje_error_fecha;}
                        if(clase_validaciones.validar_cantidad_entera_mayor(txt_11.getText().trim())==false){txt_11.setForeground(java.awt.Color.RED);mensaje=mensaje+"La cantidad producida"+mensaje_error_cant_entera;}
                        if(clase_validaciones.validar_rango_de_fechas(txt_10.getText().trim(),txt_3.getText().trim())==false)
                            {txt_3.setForeground(java.awt.Color.RED);txt_10.setForeground(java.awt.Color.RED);mensaje=mensaje+mensaje_error_rango_fecha;}
                        if(cmb_2.getSelectedIndex()<0){mensaje=mensaje+mensaje_error_seleccion+" estado.\n";}
                        if(cmb_3.getSelectedIndex()<0){mensaje=mensaje+mensaje_error_seleccion+" código de orden.\n";}
                        JOptionPane.showMessageDialog(null,mensaje_error_validacion+mensaje,"ERROR",JOptionPane.ERROR_MESSAGE);
                        mensaje=""; 
                    }
                    
                }
                if(tabla_secundaria=="Ordenes_Compras"){
                    
                    if(clase_validaciones.validar_cantidad_entera_mayor(txt_11.getText().trim())==true && 
                        cmb_1.getSelectedIndex()>=0 && 
                        cmb_2.getSelectedIndex()>=0 && 
                        cmb_3.getSelectedIndex()>=0){ 
                        
                        comando_sql="execute Procedimiento_insertar_compras ?,?,?,?,?,?";
                        codigo_cmb_1=consultar_codigo_de_registro("SELECT cod_proveedor FROM Proveedores WHERE nombre='"+cmb_1.getSelectedItem().toString()+"'");
                        codigo_cmb_2=consultar_codigo_de_registro("SELECT cod_producto_mt FROM Productos_Materia_Prima WHERE nombre='"+cmb_2.getSelectedItem().toString()+"'");
                        codigo_cmb_3=consultar_codigo_de_registro("SELECT cod_estado FROM Estados WHERE nombre='"+cmb_3.getSelectedItem().toString()+"'");
                        try {
                            conexion=clase_conexion.conectar();
                            if(clase_conexion.obtener_estado_conexion()==true){
                                PreparedStatement pst=conexion.prepareCall(comando_sql);
                                pst.setInt(1,codigo_cmb_1); //proveedor
                                pst.setInt(2,cod_empleado_actual); // codigo empleado
                                pst.setInt(3,codigo_cmb_2);//producto materia prima
                                pst.setInt(4,Integer.parseInt(txt_11.getText().trim())); // cantidad orden 
                                pst.setString(5,txt_10.getText().trim()); //  descripcion
                                pst.setInt(6,codigo_cmb_3); //estado
                                pst.execute();
                                actualizar_pantalla(accion_realizada);
                                conexion=null;
                                clase_conexion.cerrar_conexion();
                            }
                        } catch (SQLException ex) {
                            JOptionPane.showMessageDialog(null,"Ocurrió un error al insertar el registro, intente nuevamente "+ex,"ERROR",JOptionPane.ERROR_MESSAGE);
                        }                              
                    }else{
                                           
                        if(clase_validaciones.validar_cantidad_entera_mayor(txt_11.getText().trim())==false){txt_11.setForeground(java.awt.Color.RED);mensaje=mensaje+"La cantidad de orden"+mensaje_error_cant_entera;}
                        if(cmb_1.getSelectedIndex()<0){mensaje=mensaje+mensaje_error_seleccion+" proveedor.\n";}
                        if(cmb_2.getSelectedIndex()<0){mensaje=mensaje+mensaje_error_seleccion+" producto.\n";}
                        if(cmb_3.getSelectedIndex()<0){mensaje=mensaje+mensaje_error_seleccion+" estado.\n";}
                        JOptionPane.showMessageDialog(null,mensaje_error_validacion+mensaje,"ERROR",JOptionPane.ERROR_MESSAGE);
                        mensaje="";
                    }

                } 
                 if(tabla_secundaria=="Compras_Compras"){
                     
                    if(clase_validaciones.validar_cantidad_decimal(txt_10.getText().trim())==true && 
                        clase_validaciones.validar_cantidad_entera_mayor(txt_4.getText().trim())==true && 
                        cmb_3.getSelectedIndex()>=0 &&
                        clase_validaciones.validar_CAI(txt_12.getText().trim())==true){
                        
                            comando_sql="execute Procedimiento_actualizar_compras ?,?,?,?,?,?";
                            codigo_cmb_3=consultar_codigo_de_registro("SELECT cod_estado FROM Estados WHERE nombre='"+cmb_3.getSelectedItem().toString()+"'");
                             try {
                                 conexion=clase_conexion.conectar();
                                if(clase_conexion.obtener_estado_conexion()==true){
                                    PreparedStatement pst=conexion.prepareCall(comando_sql);
                                    pst.setInt(1,Integer.parseInt(cmb_4.getSelectedItem().toString().trim())); //  codigo compra
                                    pst.setInt(2,Integer.parseInt(txt_4.getText().trim())); // cantidad compra
                                    pst.setDouble(3,Double.parseDouble(txt_10.getText().trim())); //  precio
                                    pst.setString(4,txt_11.getText().trim()); //  numero de referencia/ numero de factura
                                    pst.setString(5,txt_12.getText().trim()); // CAI
                                    pst.setInt(6,codigo_cmb_3); //estado
                                    pst.execute();
                                    actualizar_pantalla(accion_realizada);
                                    cmb_1.setVisible(true);
                                    cmb_2.setVisible(true);
                                    cmb_4.setVisible(false);
                                    conexion=null;
                                    clase_conexion.cerrar_conexion();
                                }
                             } catch (SQLException ex) {
                                 JOptionPane.showMessageDialog(null,"Ocurrió un error al insertar el registro, intente nuevamente "+ex,"ERROR",JOptionPane.ERROR_MESSAGE);
                             }                            
                    }else{
                                           
                        if(clase_validaciones.validar_cantidad_decimal(txt_10.getText().trim())==false){txt_10.setForeground(java.awt.Color.RED);mensaje=mensaje+"Precio"+mensaje_error_cant_decimal;}
                        if(clase_validaciones.validar_CAI(txt_12.getText().trim())==false){txt_12.setForeground(java.awt.Color.RED);mensaje=mensaje+"CAI debe contener 37 carácteres alfanuméricos. \n";}
                        if(clase_validaciones.validar_cantidad_entera_mayor(txt_4.getText().trim())==false){txt_4.setForeground(java.awt.Color.RED);mensaje=mensaje+"La cantidad de compra"+mensaje_error_cant_entera;} 
                        if(cmb_1.getSelectedIndex()<0){mensaje=mensaje+mensaje_error_seleccion+" proveedor.\n";}
                        if(cmb_2.getSelectedIndex()<0){mensaje=mensaje+mensaje_error_seleccion+" producto.\n";}
                        if(cmb_3.getSelectedIndex()<0){mensaje=mensaje+mensaje_error_seleccion+" estado.\n";}
                        JOptionPane.showMessageDialog(null,mensaje_error_validacion+mensaje,"ERROR",JOptionPane.ERROR_MESSAGE);
                        mensaje="";
                    }
                }
                 /*
                CORRECCIÓN DE ERROR
                Autores: Jose Manuel
                Version 1.0   02/07/2020 
                se automatizó el proceso de descuento en Pedidos, cambiando el formato a una cantidad
                porcentual.
                */
                if(tabla=="Pedidos"){
                    
                    if(clase_validaciones.validar_cantidad_entera_mayor(txt_10.getText().trim())==true && 
                        clase_validaciones.validar_cantidad_decimal(txt_11.getText().trim())==true && 
                        cmb_1.getSelectedIndex()>=0 && 
                        cmb_2.getSelectedIndex()>=0 &&
                        clase_validaciones.validar_descuento(txt_12.getText().trim())==true &&
                        clase_validaciones.validar_existencia_registro("Clientes", "identificacion", txt_19.getText().trim())==false){
                        
                        comando_sql="execute Procedimiento_insertar_pedido ?,?,?,?,?,?,?";
                        codigo_cmb_1=consultar_codigo_de_registro("SELECT cod_producto_vt FROM Productos_Venta WHERE nombre_producto='"+cmb_1.getSelectedItem().toString()+"'");
                        codigo_cmb_2=consultar_codigo_de_registro("SELECT cod_estado FROM Estados WHERE nombre='"+cmb_2.getSelectedItem().toString()+"'");
                        codigo_cmb_3=consultar_codigo_de_registro("SELECT cod_cliente FROM Clientes WHERE identificacion='"+txt_19.getText().trim()+"'");
                        try {
                            conexion=clase_conexion.conectar();
                            if(clase_conexion.obtener_estado_conexion()==true){
                                PreparedStatement pst=conexion.prepareCall(comando_sql);
                                pst.setInt(1,cod_empleado_actual); //  codigo empledo
                                pst.setInt(2,codigo_cmb_3); // codigo cliente
                                pst.setInt(3,codigo_cmb_1); //codigo del producto venta
                                pst.setInt(4,codigo_cmb_2); //estado
                                pst.setInt(5,Integer.parseInt(txt_10.getText().trim())); //  cantidad
                                pst.setDouble(6,Double.parseDouble(txt_11.getText().trim())); // precio
                                pst.setDouble(7,convertir_descuento(txt_12.getText().trim())); //  descuento
                                pst.execute();
                                actualizar_pantalla(accion_realizada);
                                txt_19.setVisible(false);
                                txt_4.setVisible(true);
                                txt_13.setVisible(true);
                                reporte.Factura_Pedidos(consultar_codigo_de_registro("SELECT MAX(cod_pedido) FROM Pedidos "));
                                conexion=null;
                                clase_conexion.cerrar_conexion();
                            }
                        } catch (SQLException ex) {
                            JOptionPane.showMessageDialog(null,"Ocurrió un error al insertar el registro, intente nuevamente "+ex,"ERROR",JOptionPane.ERROR_MESSAGE);
                        }          
                    }else{
                                                               
                        if(clase_validaciones.validar_cantidad_entera_mayor(txt_10.getText().trim())==false){txt_10.setForeground(java.awt.Color.RED);mensaje=mensaje+"La cantidad"+mensaje_error_cant_entera;}
                        if(clase_validaciones.validar_cantidad_decimal(txt_11.getText().trim())==false){txt_11.setForeground(java.awt.Color.RED);mensaje=mensaje+"Precio"+mensaje_error_cant_decimal;}
                        if(clase_validaciones.validar_descuento(txt_12.getText().trim())==false){txt_12.setForeground(java.awt.Color.RED);mensaje=mensaje+mensaje_error_descuento;}
                        if(cmb_2.getSelectedIndex()<0){mensaje=mensaje+mensaje_error_seleccion+" estado.\n";}
                        if(cmb_1.getSelectedIndex()<0){mensaje=mensaje+mensaje_error_seleccion+" producto.\n";}
                        if(clase_validaciones.validar_existencia_registro("Clientes", "identificacion", txt_19.getText().trim())==true)
                            {txt_19.setForeground(java.awt.Color.RED);mensaje=mensaje+"Número de identidad inexistente";}
                        JOptionPane.showMessageDialog(null,mensaje_error_validacion+mensaje,"ERROR",JOptionPane.ERROR_MESSAGE);
                        mensaje="";
                    }

                }
                /*
                CORRECCIÓN DE ERROR
                Autores: Jose Manuel
                Version 1.0   02/07/2020 
                se automatizó el proceso de descuento en cotizaciones, cambiando el formato a una cantidad
                porcentual.
                */
                if(tabla=="Cotizacion"){
                    
                    if(clase_validaciones.validar_cantidad_entera_mayor(txt_10.getText().trim())==true && 
                        clase_validaciones.validar_cantidad_decimal(txt_11.getText().trim())==true && 
                        cmb_1.getSelectedIndex()>=0 && 
                        cmb_2.getSelectedIndex()>=0 &&
                        clase_validaciones.validar_descuento(txt_12.getText().trim())==true &&
                        clase_validaciones.validar_existencia_registro("Clientes", "identificacion", txt_19.getText().trim())==false){
                                   
                        comando_sql="execute Procedimiento_insertar_cotizacion ?,?,?,?,?,?,?";
                        codigo_cmb_1=consultar_codigo_de_registro("SELECT cod_producto_vt FROM Productos_Venta WHERE nombre_producto='"+cmb_1.getSelectedItem().toString()+"'");
                        codigo_cmb_2=consultar_codigo_de_registro("SELECT cod_estado FROM Estados WHERE nombre='"+cmb_2.getSelectedItem().toString()+"'");
                        codigo_cmb_3=consultar_codigo_de_registro("SELECT cod_cliente FROM Clientes WHERE identificacion='"+txt_19.getText().trim()+"'");
                        try {
                            conexion=clase_conexion.conectar();
                            if(clase_conexion.obtener_estado_conexion()==true){
                                PreparedStatement pst=conexion.prepareCall(comando_sql);
                                pst.setInt(1,cod_empleado_actual); //  codigo empledo
                                pst.setInt(2,codigo_cmb_3); // codigo cliente
                                pst.setInt(3,codigo_cmb_1);//codigo del producto venta
                                pst.setInt(4,codigo_cmb_2); //estado
                                pst.setInt(5,Integer.parseInt(txt_10.getText().trim())); //  cantidad
                                pst.setDouble(6,Double.parseDouble(txt_11.getText().trim())); // precio
                                pst.setDouble(7,convertir_descuento(txt_12.getText().trim())); //  descuento
                                pst.execute();
                                actualizar_pantalla(accion_realizada);
                                txt_19.setVisible(false);
                                txt_4.setVisible(true);
                                txt_13.setVisible(true);
                                reporte.Factura_Cotizaciones(consultar_codigo_de_registro("SELECT MAX(cod_cotizacion) FROM Cotizacion"));
                                conexion=null;
                                clase_conexion.cerrar_conexion();
                            }
                        } catch (SQLException ex) {
                            JOptionPane.showMessageDialog(null,"Ocurrió un error al insertar el registro, intente nuevamente "+ex,"ERROR",JOptionPane.ERROR_MESSAGE);
                        }
                                
                    }else{
                                                                   
                        if(clase_validaciones.validar_cantidad_entera_mayor(txt_10.getText().trim())==false){txt_10.setForeground(java.awt.Color.RED);mensaje=mensaje+"La cantidad"+mensaje_error_cant_entera;}
                        if(clase_validaciones.validar_cantidad_decimal(txt_11.getText().trim())==false){txt_11.setForeground(java.awt.Color.RED);mensaje=mensaje+"Precio"+mensaje_error_cant_decimal;}
                        if(clase_validaciones.validar_descuento(txt_12.getText().trim())==false){txt_12.setForeground(java.awt.Color.RED);mensaje=mensaje+mensaje_error_descuento;}
                        if(cmb_1.getSelectedIndex()<0){mensaje=mensaje+mensaje_error_seleccion+" producto.\n";}
                        if(cmb_2.getSelectedIndex()<0){mensaje=mensaje+mensaje_error_seleccion+" estado.\n";}
                        if(clase_validaciones.validar_existencia_registro("Clientes", "identificacion", txt_19.getText().trim())==true)
                            {txt_19.setForeground(java.awt.Color.RED);mensaje=mensaje+"Número de identidad inexistente";}
                        JOptionPane.showMessageDialog(null,mensaje_error_validacion+mensaje,"ERROR",JOptionPane.ERROR_MESSAGE);
                        mensaje="";
                    }
                    
                }
        }
        
        //------------------------------------------------------ACTUALIZAR-------------------------------------------------------------

        if(accion_bd.equals("actualizar")){
            accion_realizada="actualizado";
           
            if("Empleados".equals(tabla)){
                
                if(clase_validaciones.validar_existencia_modificar("Empleados","num_identidad", txt_2.getText().trim(),"cod_empleado",Integer.parseInt(txt_1.getText()))==true && 
                    clase_validaciones.validar_existencia_modificar("Empleados","celular", txt_12.getText().trim(),"cod_empleado",Integer.parseInt(txt_1.getText()))==true &&
                    clase_validaciones.validar_existencia_modificar("Empleados","correo_electronico", txt_13.getText().trim(),"cod_empleado",Integer.parseInt(txt_1.getText()))==true &&
                    clase_validaciones.validar_num_id(txt_2.getText().trim())==true && 
                    clase_validaciones.validar_campo(txt_3.getText().trim())==true && 
                    clase_validaciones.validar_campo(txt_4.getText().trim())==true && 
                    clase_validaciones.validar_numero_contacto(txt_12.getText().trim())==true &&
                    clase_validaciones.validar_correo(txt_13.getText().trim())==true && 
                    cmb_1.getSelectedIndex()>=0 && 
                    txta_3.getText().length()>0){
                    
                    comando_sql="execute Procedimiento_actualizar_empleados ?,?,?,?,?,?,?,?";
                    codigo_cmb_1=consultar_codigo_de_registro("SELECT cod_estado FROM Estados WHERE nombre='"+String.valueOf(cmb_1.getSelectedItem()+"'"));
                    
                    try {
                        conexion=clase_conexion.conectar();
                        if(clase_conexion.obtener_estado_conexion()==true){
                            PreparedStatement pst=conexion.prepareCall(comando_sql);
                            pst.setInt(1,Integer.parseInt(txt_1.getText())); //  codigo empledo
                            pst.setString(2,txt_3.getText()); //  nombre empleado
                            pst.setString(3,txt_4.getText()); //  apellidos empleado
                            pst.setString(4,txt_2.getText()); //  identificacion empleado
                            pst.setString(5,txt_12.getText()); //  celular empleado
                            pst.setString(6,txt_13.getText()); //  correo empleado
                            pst.setString(7,txta_3.getText()); // direccion del empleado
                            pst.setInt(8,codigo_cmb_1); //estado
                            pst.execute();                        
                            actualizar_pantalla(accion_realizada);
                            txt_10.setEnabled(true);
                            txt_11.setEnabled(true);
                            txt_19.setEnabled(true);
                            conexion=null;
                            clase_conexion.cerrar_conexion();
                        }
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null,"Ocurrió un error al actualizar el registro, intente nuevamente "+ex,"ERROR",JOptionPane.ERROR_MESSAGE);
                    }
                }else{
                    
                        if(clase_validaciones.validar_num_id(txt_2.getText().trim())==false){txt_2.setForeground(java.awt.Color.RED);mensaje=mensaje+mensaje_error_num_id;}
                        if(clase_validaciones.validar_campo(txt_3.getText().trim())==false){txt_3.setForeground(java.awt.Color.RED);mensaje=mensaje+"Nombre"+mensaje_error_campo;}
                        if(clase_validaciones.validar_campo(txt_4.getText().trim())==false){txt_4.setForeground(java.awt.Color.RED);mensaje=mensaje+"Apellido"+mensaje_error_campo;}                        
                        if(clase_validaciones.validar_numero_contacto(txt_12.getText().trim())==false){txt_12.setForeground(java.awt.Color.RED);mensaje=mensaje+mensaje_error_num_contacto;}
                        if(clase_validaciones.validar_correo(txt_13.getText().trim())==false){txt_13.setForeground(java.awt.Color.RED);mensaje=mensaje+mensaje_error_correo;}
                        if(cmb_1.getSelectedIndex()<0){mensaje=mensaje+mensaje_error_seleccion+" estado.\n";}
                        if(clase_validaciones.validar_existencia_modificar("Empleados","num_identidad", txt_2.getText().trim(),"cod_empleado",Integer.parseInt(txt_1.getText()))==false)
                            {txt_2.setForeground(java.awt.Color.RED);mensaje=mensaje+"Número de identidad"+mensaje_error_duplicados;}
                        if(clase_validaciones.validar_existencia_modificar("Empleados","celular", txt_12.getText().trim(),"cod_empleado",Integer.parseInt(txt_1.getText()))==false)
                            {txt_12.setForeground(java.awt.Color.RED);mensaje=mensaje+"Número de contacto"+mensaje_error_duplicados;}
                        if(clase_validaciones.validar_existencia_modificar("Empleados","correo_electronico", txt_13.getText().trim(),"cod_empleado",Integer.parseInt(txt_1.getText()))==false)
                            {txt_13.setForeground(java.awt.Color.RED);mensaje=mensaje+"Correo electrónico"+mensaje_error_duplicados;}
                        JOptionPane.showMessageDialog(null,mensaje_error_validacion+mensaje,"ERROR",JOptionPane.ERROR_MESSAGE);
                        mensaje="";
                }    

            }
            if("Proveedores".equals(tabla)){

                if(clase_validaciones.validar_existencia_modificar("Proveedores","n_identificacion", txt_2.getText().trim(),"cod_proveedor",Integer.parseInt(txt_1.getText()))==true &&
                    clase_validaciones.validar_existencia_modificar("Proveedores","celular", txt_11.getText().trim(),"cod_proveedor",Integer.parseInt(txt_1.getText()))==true &&
                    clase_validaciones.validar_existencia_modificar("Proveedores","correo_electronico", txt_12.getText().trim(),"cod_proveedor",Integer.parseInt(txt_1.getText()))==true &&
                    clase_validaciones.validar_id_rtn(txt_2.getText().trim())==true && 
                    clase_validaciones.validar_campo(txt_3.getText().trim())==true && 
                    clase_validaciones.validar_campo(txt_10.getText().trim())==true && 
                    clase_validaciones.validar_numero_contacto(txt_11.getText().trim())==true &&
                    clase_validaciones.validar_correo(txt_12.getText().trim())==true && 
                    cmb_1.getSelectedIndex()>=0 && 
                    txta_3.getText().length()>0){
                    
                        comando_sql="execute Procedimiento_actualizar_proveedores ?,?,?,?,?,?,?,?";
                        codigo_cmb_1=consultar_codigo_de_registro("SELECT cod_estado FROM Estados WHERE nombre='"+String.valueOf(cmb_1.getSelectedItem()+"'"));
                        try {
                            conexion=clase_conexion.conectar();
                            if(clase_conexion.obtener_estado_conexion()==true){
                                PreparedStatement pst=conexion.prepareCall(comando_sql);
                                pst.setInt(1,Integer.parseInt(txt_1.getText().trim())); // codigo proveedor
                                pst.setString(2,txt_2.getText().trim()); //  identificacion 
                                pst.setString(3,txt_3.getText().trim()); //  nombre 
                                pst.setString(4,txt_10.getText().trim()); //  nombre contacto
                                pst.setString(5,txt_11.getText().trim()); //  celular 
                                pst.setString(6,txt_12.getText().trim()); //  correo 
                                pst.setString(7,txta_3.getText().trim()); // direccion 
                                pst.setInt(8,codigo_cmb_1);//estado
                                pst.execute();                            
                                actualizar_pantalla(accion_realizada);
                                txt_19.setEnabled(true);
                                conexion=null;
                                clase_conexion.cerrar_conexion();
                            }
                        } catch (SQLException ex) {
                            JOptionPane.showMessageDialog(null,"Ocurrió un error al actualizar el registro, intente nuevamente "+ex,"ERROR",JOptionPane.ERROR_MESSAGE);
                        }
                }else{
                    
                        if(clase_validaciones.validar_id_rtn(txt_2.getText().trim())==false){txt_2.setForeground(java.awt.Color.RED);mensaje=mensaje+mensaje_error_num_id_rtn;}
                        if(clase_validaciones.validar_campo(txt_3.getText().trim())==false){txt_3.setForeground(java.awt.Color.RED);mensaje=mensaje+"Nombre"+mensaje_error_campo;}                     
                        if(clase_validaciones.validar_campo(txt_10.getText().trim())==false){txt_10.setForeground(java.awt.Color.RED);mensaje=mensaje+"Apellido"+mensaje_error_campo;}                       
                        if(clase_validaciones.validar_numero_contacto(txt_11.getText().trim())==false){txt_11.setForeground(java.awt.Color.RED);mensaje=mensaje+mensaje_error_num_contacto;}
                        if(clase_validaciones.validar_correo(txt_12.getText().trim())==false){txt_12.setForeground(java.awt.Color.RED);mensaje=mensaje+mensaje_error_correo;}
                        if(cmb_1.getSelectedIndex()<0){mensaje=mensaje+mensaje_error_seleccion+" estado.\n";}
                        if(clase_validaciones.validar_existencia_modificar("Proveedores","n_identificacion", txt_2.getText().trim(),"cod_proveedor",Integer.parseInt(txt_1.getText()))==false)
                            {txt_2.setForeground(java.awt.Color.RED);mensaje=mensaje+"Número de identidad"+mensaje_error_duplicados;}
                        if(clase_validaciones.validar_existencia_modificar("Proveedores","celular", txt_11.getText().trim(),"cod_proveedor",Integer.parseInt(txt_1.getText()))==false)
                            {txt_11.setForeground(java.awt.Color.RED);mensaje=mensaje+"Número de contacto"+mensaje_error_duplicados;}
                        if(clase_validaciones.validar_existencia_modificar("Proveedores","correo_electronico", txt_12.getText().trim(),"cod_proveedor",Integer.parseInt(txt_1.getText()))==false)
                            {txt_12.setForeground(java.awt.Color.RED);mensaje=mensaje+"Correo electrónico"+mensaje_error_duplicados;}
                        JOptionPane.showMessageDialog(null,mensaje_error_validacion+mensaje,"ERROR",JOptionPane.ERROR_MESSAGE);
                        mensaje="";
                }        

            }
            if(tabla=="Usuarios"){

                if(cmb_1.getSelectedIndex()>=0 && 
                    cmb_2.getSelectedIndex()>=0){
                    
                    comando_sql="execute Procedimiento_actualizar_usuarios ?,?,?";
                    codigo_cmb_1=consultar_codigo_de_registro("SELECT cod_nivel_acceso FROM Niveles_Acceso WHERE nombre_nivel='"+String.valueOf(cmb_1.getSelectedItem()+"'"));
                    codigo_cmb_2=consultar_codigo_de_registro("SELECT cod_estado FROM Estados WHERE nombre='"+String.valueOf(cmb_2.getSelectedItem()+"'"));
                    try {
                        conexion=clase_conexion.conectar();
                        if(clase_conexion.obtener_estado_conexion()==true){
                            PreparedStatement pst=conexion.prepareCall(comando_sql);
                            pst.setInt(1,Integer.parseInt(txt_1.getText().trim())); // codigo usuario
                            pst.setInt(2,codigo_cmb_1); //nivel de acceso
                            pst.setInt(3,codigo_cmb_2); //estado
                            pst.execute();                        
                            actualizar_pantalla(accion_realizada);
                            conexion=null;
                            clase_conexion.cerrar_conexion();
                        }
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null,"Ocurrió un error al actualizar el registro, intente nuevamente "+ex,"ERROR",JOptionPane.ERROR_MESSAGE);
                    }
                }else{
                    if(cmb_1.getSelectedIndex()<0){mensaje=mensaje+mensaje_error_seleccion+" nivel de acceso.\n";}
                    if(cmb_2.getSelectedIndex()<0){mensaje=mensaje+mensaje_error_seleccion+" estado.\n";}                    
                    JOptionPane.showMessageDialog(null,mensaje_error_validacion+mensaje,"ERROR",JOptionPane.ERROR_MESSAGE);
                    mensaje="";
                }
                                
            }
            if(tabla=="Tipos_de_Importe"){

               if(cmb_1.getSelectedIndex()>=0){

                comando_sql="execute Procedimiento_actualizar_tipos_de_importe ?,?";
                codigo_cmb_1=consultar_codigo_de_registro("SELECT cod_estado FROM Estados WHERE nombre='"+String.valueOf(cmb_1.getSelectedItem()+"'"));
                 try {
                     conexion=clase_conexion.conectar();
                    if(clase_conexion.obtener_estado_conexion()==true){
                        PreparedStatement pst=conexion.prepareCall(comando_sql);
                        pst.setInt(1,Integer.parseInt(txt_1.getText().trim())); // codigo 
                        pst.setInt(2,codigo_cmb_1); //estado
                        pst.execute();
                        actualizar_pantalla(accion_realizada);
                        conexion=null;
                        clase_conexion.cerrar_conexion();
                    }
                 } catch (SQLException ex) {
                     JOptionPane.showMessageDialog(null,"Ocurrió un error al actualizar el registro, intente nuevamente "+ex,"ERROR",JOptionPane.ERROR_MESSAGE);
                 }
               }else{
                    if(cmb_1.getSelectedIndex()<0){mensaje=mensaje+mensaje_error_seleccion+" estado.\n";}
                    JOptionPane.showMessageDialog(null,mensaje_error_validacion+mensaje,"ERROR",JOptionPane.ERROR_MESSAGE);
                    mensaje="";
                }
               
            }
            if(tabla=="Datos_Organizacion"){

                if(clase_validaciones.validar_numero_contacto(txt_12.getText().trim())==true && 
                    clase_validaciones.validar_numero_contacto(txt_13.getText().trim())==true && 
		    clase_validaciones.validar_numero_contacto(txt_14.getText().trim())==true && 
                    clase_validaciones.validar_numero_contacto(txt_15.getText().trim())==true &&
                    clase_validaciones.validar_correo(txt_10.getText().trim())==true && 
                    clase_validaciones.validar_correo(txt_11.getText().trim())==true && 
                    txta_1.getText().length()>0 && 
                    txta_2.getText().length()>0 && 
                    txta_3.getText().length()>0){

                    comando_sql="execute Procedimiento_actualizar_datos_organizacion ?,?,?,?,?,?,?,?,?,?,?";
                    try {
                         conexion=clase_conexion.conectar();
                        if(clase_conexion.obtener_estado_conexion()==true){
                            PreparedStatement pst=conexion.prepareCall(comando_sql);
                            pst.setInt(1,Integer.parseInt(txt_1.getText().trim())); //  codigo
                            pst.setString(2,txt_10.getText().trim()); //  email 1 
                            pst.setString(3,txt_11.getText().trim()); //  email 2 
                            pst.setString(4,txt_12.getText().trim()); //  telefono 1
                            pst.setString(5,txt_13.getText().trim()); //  telefono 2 
                            pst.setString(6,txt_14.getText().trim()); //  celular 1 
                            pst.setString(7,txt_15.getText().trim()); // celular 2 
                            pst.setString(8,txta_1.getText().trim());//  mensaje 1
                            pst.setString(9,txta_2.getText().trim());//  mensaje 2
                            pst.setString(10,txta_3.getText().trim());//  mensaje 3
                            pst.setInt(11,1); //estado
                            pst.execute();
                            actualizar_pantalla(accion_realizada);
                            txt_2.setEnabled(true);
                            txt_3.setEnabled(true);
                            txt_4.setEnabled(true);
                            txt_5.setEnabled(true);
                            txt_6.setEnabled(true);
                            txt_7.setEnabled(true);
                            txt_8.setEnabled(true);
                            txt_16.setEnabled(true);
                            txt_19.setEnabled(true);
                            txt_20.setEnabled(true);
                            txt_21.setEnabled(true);
                            txt_22.setEnabled(true);
                            conexion=null;
                            clase_conexion.cerrar_conexion();
                        }
                    } catch (SQLException ex) {
                         JOptionPane.showMessageDialog(null,"Ocurrió un error al actualizar el registro, intente nuevamente "+ex,"ERROR",JOptionPane.ERROR_MESSAGE);
                    }
                }else{
                                         
                        if(clase_validaciones.validar_numero_contacto(txt_12.getText().trim())==false){txt_12.setForeground(java.awt.Color.RED);mensaje=mensaje+mensaje_error_num_contacto;}
                        if(clase_validaciones.validar_numero_contacto(txt_13.getText().trim())==false){txt_13.setForeground(java.awt.Color.RED);mensaje=mensaje+mensaje_error_num_contacto;}
                        if(clase_validaciones.validar_numero_contacto(txt_14.getText().trim())==false){txt_14.setForeground(java.awt.Color.RED);mensaje=mensaje+mensaje_error_num_contacto;}
                        if(clase_validaciones.validar_numero_contacto(txt_15.getText().trim())==false){txt_15.setForeground(java.awt.Color.RED);mensaje=mensaje+mensaje_error_num_contacto;}
                        if(clase_validaciones.validar_correo(txt_10.getText().trim())==false){txt_10.setForeground(java.awt.Color.RED);mensaje=mensaje+mensaje_error_correo;}
                        if(clase_validaciones.validar_correo(txt_11.getText().trim())==false){txt_11.setForeground(java.awt.Color.RED);mensaje=mensaje+mensaje_error_correo;}
                        JOptionPane.showMessageDialog(null,mensaje_error_validacion+mensaje,"ERROR",JOptionPane.ERROR_MESSAGE);
                        mensaje="";
                } 
                
            }
            if(tabla=="Clientes"){

                if(clase_validaciones.validar_existencia_modificar("Clientes","identificacion", txt_10.getText().trim(),"cod_cliente",Integer.parseInt(txt_1.getText()))==true && 
                    clase_validaciones.validar_existencia_modificar("Clientes","celular", txt_11.getText().trim(),"cod_cliente",Integer.parseInt(txt_1.getText()))==true &&
                    clase_validaciones.validar_existencia_modificar("Clientes","correo_electronico", txt_12.getText().trim(),"cod_cliente",Integer.parseInt(txt_1.getText()))==true &&
                    clase_validaciones.validar_id_rtn(txt_10.getText().trim())==true && 
                    clase_validaciones.validar_campo(txt_2.getText().trim())==true && 
                    clase_validaciones.validar_campo(txt_3.getText().trim())==true && 
                    clase_validaciones.validar_numero_contacto(txt_11.getText().trim())==true &&
                    clase_validaciones.validar_correo(txt_12.getText().trim())==true && 
                    cmb_1.getSelectedIndex()>=0 && 
                    txta_3.getText().length()>0){

                    comando_sql="execute Procedimiento_actualizar_clientes ?,?,?,?,?,?,?,?";
                    codigo_cmb_1=consultar_codigo_de_registro("SELECT cod_estado FROM Estados WHERE nombre='"+String.valueOf(cmb_1.getSelectedItem()+"'"));
                     try {
                         conexion=clase_conexion.conectar();
                        if(clase_conexion.obtener_estado_conexion()==true){
                            PreparedStatement pst=conexion.prepareCall(comando_sql);
                            pst.setInt(1,Integer.parseInt(txt_1.getText().trim())); //  codigo cliente
                            pst.setString(2,txt_10.getText().trim()); //  identificacion 
                            pst.setString(3,txt_2.getText().trim()); //  nombre 
                            pst.setString(4,txt_3.getText().trim()); //  apellidos
                            pst.setString(5,txt_11.getText().trim()); //  celular 
                            pst.setString(6,txt_12.getText().trim()); //  correo 
                            pst.setString(7,txta_3.getText().trim()); // direccion 
                            pst.setInt(8,codigo_cmb_1);//estado
                            pst.execute();
                            actualizar_pantalla(accion_realizada);
                            txt_19.setEnabled(true);
                            conexion=null;
                            clase_conexion.cerrar_conexion();
                        }
                    } catch (SQLException ex) {
                         JOptionPane.showMessageDialog(null,"Ocurrió un error al actualizar el registro, intente nuevamente "+ex,"ERROR",JOptionPane.ERROR_MESSAGE);
                    }
                }else{
              
                        if(cmb_1.getSelectedIndex()<0){mensaje=mensaje+mensaje_error_seleccion+" estado.\n";}
                        if(clase_validaciones.validar_campo(txt_3.getText().trim())==false){txt_3.setForeground(java.awt.Color.RED);mensaje=mensaje+"Nombre"+mensaje_error_campo;}
                        if(clase_validaciones.validar_campo(txt_2.getText().trim())==false){txt_2.setForeground(java.awt.Color.RED);mensaje=mensaje+"Apellido"+mensaje_error_campo;}
                        if(clase_validaciones.validar_id_rtn(txt_10.getText().trim())==false){txt_10.setForeground(java.awt.Color.RED);mensaje=mensaje+mensaje_error_num_id_rtn;}
                        if(clase_validaciones.validar_numero_contacto(txt_11.getText().trim())==false){txt_11.setForeground(java.awt.Color.RED);mensaje=mensaje+mensaje_error_num_contacto;}
                        if(clase_validaciones.validar_correo(txt_12.getText().trim())==false){txt_12.setForeground(java.awt.Color.RED);mensaje=mensaje+mensaje_error_correo;}
                        if(clase_validaciones.validar_existencia_modificar("Clientes","identificacion", txt_10.getText().trim(),"cod_cliente",Integer.parseInt(txt_1.getText()))==false)
                            {txt_10.setForeground(java.awt.Color.RED);mensaje=mensaje+"Número de identidad"+mensaje_error_duplicados;}
                        if(clase_validaciones.validar_existencia_modificar("Clientes","celular", txt_11.getText().trim(),"cod_cliente",Integer.parseInt(txt_1.getText()))==false)
                            {txt_11.setForeground(java.awt.Color.RED);mensaje=mensaje+"Número de contacto"+mensaje_error_duplicados;}
                        if(clase_validaciones.validar_existencia_modificar("Clientes","correo_electronico", txt_12.getText().trim(),"cod_cliente",Integer.parseInt(txt_1.getText()))==false)
                            {txt_12.setForeground(java.awt.Color.RED);mensaje=mensaje+"Correo electrónico"+mensaje_error_duplicados;}
                        JOptionPane.showMessageDialog(null,mensaje_error_validacion+mensaje,"ERROR",JOptionPane.ERROR_MESSAGE);
                        mensaje="";
                }     
                
            }
             if(tabla=="Colecciones"){

                if(clase_validaciones.validar_campo(txt_2.getText().trim())==true && 
                    cmb_1.getSelectedIndex()>=0 && 
                    txta_1.getText().length()>0){

                    comando_sql="execute Procedimiento_actualizar_colecciones ?,?,?,?";
                    codigo_cmb_1=consultar_codigo_de_registro("SELECT cod_estado FROM Estados WHERE nombre='"+String.valueOf(cmb_1.getSelectedItem()+"'"));
                     try {
                         conexion=clase_conexion.conectar();
                         if(clase_conexion.obtener_estado_conexion()==true){
                            PreparedStatement pst=conexion.prepareCall(comando_sql);
                            pst.setInt(1,Integer.parseInt(txt_1.getText().trim())); //codigo coleccion
                            pst.setString(2,txt_2.getText().trim()); // nombre 
                            pst.setString(3,txta_1.getText().trim()); // descripcion
                            pst.setInt(4,codigo_cmb_1);//estado
                            pst.execute();                         
                            actualizar_pantalla(accion_realizada);
                            txt_10.setEnabled(true);
                            txt_11.setEnabled(true);
                            txt_12.setEnabled(true);
                            conexion=null;
                            clase_conexion.cerrar_conexion();
                        }
                    } catch (SQLException ex) {
                         JOptionPane.showMessageDialog(null,"Ocurrió un error al actualizar el registro, intente nuevamente "+ex,"ERROR",JOptionPane.ERROR_MESSAGE);
                    }
                }else{                  
                        if(cmb_1.getSelectedIndex()<0){mensaje=mensaje+mensaje_error_seleccion+" estado.\n";}
                        if(clase_validaciones.validar_campo(txt_2.getText().trim())==false){txt_2.setForeground(java.awt.Color.RED);mensaje=mensaje+"Nombre"+mensaje_error_campo;}
                        JOptionPane.showMessageDialog(null,mensaje_error_validacion+mensaje,"ERROR",JOptionPane.ERROR_MESSAGE);
                        mensaje="";
                } 
                
            }
            if(tabla=="Productos_Venta"){
 
                if(clase_validaciones.validar_existencia_modificar("Productos_Venta","nombre_producto", txt_2.getText().trim(),"cod_producto_vt",Integer.parseInt(txt_1.getText()))==true &&
                    clase_validaciones.validar_campo(txt_2.getText().trim())==true && 
                    clase_validaciones.validar_cantidad_decimal(txt_3.getText().trim())==true && 
		    clase_validaciones.validar_cantidad_decimal(txt_4.getText().trim())==true && 
                    clase_validaciones.validar_cantidad_entera_mayor(txt_11.getText().trim())==true && 
                    cmb_1.getSelectedIndex()>=0 && 
                    cmb_2.getSelectedIndex()>=0 && 
                    cmb_3.getSelectedIndex()>=0 &&
                    txta_2.getText().length()>0){ 

                    comando_sql="execute Procedimiento_actualizar_productos_venta ?,?,?,?,?,?,?,?,?";
                    codigo_cmb_1=consultar_codigo_de_registro("SELECT cod_coleccion FROM Colecciones WHERE nombre_coleccion='"+String.valueOf(cmb_1.getSelectedItem())+"'");
                    codigo_cmb_2=consultar_codigo_de_registro("SELECT cod_estado FROM Estados WHERE nombre='"+String.valueOf(cmb_2.getSelectedItem())+"'");
                    codigo_cmb_3=consultar_codigo_de_registro("SELECT cod_tipo_importe FROM Tipos_de_Importe WHERE nombre='"+String.valueOf(cmb_3.getSelectedItem())+"'");
                     try {
                         conexion=clase_conexion.conectar();
                        if(clase_conexion.obtener_estado_conexion()==true){
                            PreparedStatement pst=conexion.prepareCall(comando_sql);
                            pst.setInt(1,Integer.parseInt(txt_1.getText()));
                            pst.setInt(2,codigo_cmb_1);
                            pst.setString(3,txt_2.getText().trim());
                            pst.setString(4,txta_2.getText().trim());
                            pst.setDouble(5,Double.parseDouble(txt_3.getText().trim()));
                            pst.setDouble(6,Double.parseDouble(txt_4.getText().trim()));
                            pst.setInt(7,Integer.parseInt(txt_11.getText().trim()));
                            pst.setInt(8,codigo_cmb_2);
                            pst.setInt(9,codigo_cmb_3);
                            pst.execute();                         
                            actualizar_pantalla(accion_realizada);
                            txt_10.setEnabled(true);
                            txt_12.setEnabled(true);
                            conexion=null;
                            clase_conexion.cerrar_conexion();
                        }
                    } catch (SQLException ex) {
                         JOptionPane.showMessageDialog(null,"Ocurrió un error al actualizar el registro, intente nuevamente "+ex,"ERROR",JOptionPane.ERROR_MESSAGE);
                    }
                }else{
                 
                        if(clase_validaciones.validar_campo(txt_2.getText().trim())==false){txt_2.setForeground(java.awt.Color.RED);mensaje=mensaje+"Nombre"+mensaje_error_campo;}
                        if(clase_validaciones.validar_cantidad_decimal(txt_3.getText().trim())==false){txt_3.setForeground(java.awt.Color.RED);mensaje=mensaje+"Precio"+mensaje_error_cant_decimal;}
                        if(clase_validaciones.validar_cantidad_decimal(txt_4.getText().trim())==false){txt_4.setForeground(java.awt.Color.RED);mensaje=mensaje+"Costo"+mensaje_error_cant_decimal;}
                        if(clase_validaciones.validar_cantidad_entera_mayor(txt_11.getText().trim())==false){txt_11.setForeground(java.awt.Color.RED);mensaje=mensaje+"Punto de reorden"+mensaje_error_cant_entera;}
                        if(cmb_1.getSelectedIndex()<0){mensaje=mensaje+mensaje_error_seleccion+" colección.\n";}
                        if(cmb_2.getSelectedIndex()<0){mensaje=mensaje+mensaje_error_seleccion+" estado.\n";}
                        if(cmb_3.getSelectedIndex()<0){mensaje=mensaje+mensaje_error_seleccion+" importe.\n";}
                        if(clase_validaciones.validar_existencia_modificar("Productos_Venta","nombre_producto", txt_2.getText().trim(),"cod_producto_vt",Integer.parseInt(txt_1.getText()))==false)
                            {txt_2.setForeground(java.awt.Color.RED);mensaje=mensaje+"Producto"+mensaje_error_duplicados;}
                        JOptionPane.showMessageDialog(null,mensaje_error_validacion+mensaje,"ERROR",JOptionPane.ERROR_MESSAGE);
                        mensaje="";
                }  
                
            }
            if(tabla=="Productos_Materia_Prima"){

                if(clase_validaciones.validar_existencia_modificar("Productos_Materia_Prima","nombre", txt_2.getText().trim(),"cod_producto_mt",Integer.parseInt(txt_1.getText()))==true &&
                    clase_validaciones.validar_campo(txt_2.getText().trim())==true && 
                    clase_validaciones.validar_cantidad_decimal(txt_3.getText().trim())==true && 
                    clase_validaciones.validar_cantidad_entera_mayor(txt_11.getText().trim())==true && 
                    cmb_1.getSelectedIndex()>=0 && 
                    cmb_2.getSelectedIndex()>=0 && 
                    txta_2.getText().length()>0){    

                    comando_sql="execute Procedimiento_actualizar_Productos_Materia_Prima ?,?,?,?,?,?,?";
                    codigo_cmb_1=consultar_codigo_de_registro("SELECT cod_estado FROM Estados WHERE nombre='"+cmb_1.getSelectedItem().toString()+"'");
                     try {
                         conexion=clase_conexion.conectar();
                        if(clase_conexion.obtener_estado_conexion()==true){
                            PreparedStatement pst=conexion.prepareCall(comando_sql);
                            pst.setInt(1,Integer.parseInt(txt_1.getText().trim()));
                            pst.setString(2,txt_2.getText().trim());
                            pst.setString(3,txta_2.getText().trim());
                            pst.setDouble(4,Double.parseDouble(txt_3.getText().trim()));
                            pst.setString(5,cmb_2.getSelectedItem().toString());
                            pst.setInt(6,Integer.parseInt(txt_11.getText().trim()));
                            pst.setInt(7,codigo_cmb_1);
                            pst.execute();
                            actualizar_pantalla(accion_realizada);
                            txt_10.setEnabled(true);
                            txt_20.setEnabled(true);
                            conexion=null;
                            clase_conexion.cerrar_conexion();
                        }     
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null,"Ocurrió un error al actualizar el registro, intente nuevamente "+ex,"ERROR",JOptionPane.ERROR_MESSAGE);
                    }
                }else{
                 
                        if(clase_validaciones.validar_campo(txt_2.getText().trim())==false){txt_2.setForeground(java.awt.Color.RED);mensaje=mensaje+"Nombre"+mensaje_error_campo;}
                        if(clase_validaciones.validar_cantidad_decimal(txt_3.getText().trim())==false){txt_3.setForeground(java.awt.Color.RED);mensaje=mensaje+"Precio"+mensaje_error_cant_decimal;}                       
                        if(clase_validaciones.validar_cantidad_entera_mayor(txt_11.getText().trim())==false){txt_11.setForeground(java.awt.Color.RED);mensaje=mensaje+"Punto de reorden"+mensaje_error_cant_entera;}
                        if(cmb_1.getSelectedIndex()<0){mensaje=mensaje+mensaje_error_seleccion+" estado.\n";}
                        if(cmb_2.getSelectedIndex()<0){mensaje=mensaje+mensaje_error_seleccion+" tipo de unidad.\n";}
                        if(clase_validaciones.validar_existencia_modificar("Productos_Materia_Prima","nombre", txt_2.getText().trim(),"cod_producto_mt",Integer.parseInt(txt_1.getText()))==false)
                            {txt_2.setForeground(java.awt.Color.RED);mensaje=mensaje+"Nombre"+mensaje_error_duplicados;}
                        JOptionPane.showMessageDialog(null,mensaje_error_validacion+mensaje,"ERROR",JOptionPane.ERROR_MESSAGE);
                        mensaje="";
                }
                
            }
            if(tabla_secundaria=="Ordenes_Produccion"){

                if(clase_validaciones.validar_cantidad_entera_mayor(txt_10.getText().trim())==true && 
                    cmb_2.getSelectedIndex()>=0){    

                    comando_sql="execute Procedimiento_actualizar_orden_produccion ?,?,?,?";
                    codigo_cmb_2=consultar_codigo_de_registro("SELECT cod_estado FROM Estados WHERE nombre='"+cmb_2.getSelectedItem().toString()+"'");
                     try {
                         conexion=clase_conexion.conectar();
                        if(clase_conexion.obtener_estado_conexion()==true){
                            PreparedStatement pst=conexion.prepareCall(comando_sql);
                            pst.setInt(1,Integer.parseInt(txt_1.getText().trim()));
                            pst.setInt(2,Integer.parseInt(txt_10.getText().trim()));
                            pst.setString(3,txt_11.getText().trim());
                            pst.setInt(4,codigo_cmb_2);
                            pst.execute();
                            actualizar_pantalla(accion_realizada);
                            conexion=null;
                            clase_conexion.cerrar_conexion();
                        }
                    } catch (SQLException ex) {
                         JOptionPane.showMessageDialog(null,"Ocurrió un error al actualizar el registro, intente nuevamente "+ex,"ERROR",JOptionPane.ERROR_MESSAGE);
                    }
                }else{
                                  
                        if(clase_validaciones.validar_cantidad_entera_mayor(txt_10.getText().trim())==false){txt_10.setForeground(java.awt.Color.RED);mensaje=mensaje+"La cantidad"+mensaje_error_cant_entera;}
                        if(cmb_2.getSelectedIndex()<0){mensaje=mensaje+mensaje_error_seleccion+" estado.\n";}
                        JOptionPane.showMessageDialog(null,mensaje_error_validacion+mensaje,"ERROR",JOptionPane.ERROR_MESSAGE);
                        mensaje="";
                }
                
            }
            if(tabla_secundaria=="Ordenes_Compras"){

                if(clase_validaciones.validar_cantidad_entera_mayor(txt_11.getText().trim())==true && 
                    cmb_3.getSelectedIndex()>=0){   
                    
                    comando_sql="execute Procedimiento_actualizar_ordenes_compras ?,?,?,?";
                    codigo_cmb_3=consultar_codigo_de_registro("SELECT cod_estado FROM Estados WHERE nombre='"+cmb_3.getSelectedItem().toString()+"'");
                    try {
                        conexion=clase_conexion.conectar();
                        if(clase_conexion.obtener_estado_conexion()==true){
                            PreparedStatement pst=conexion.prepareCall(comando_sql);
                            pst.setInt(1,Integer.parseInt(txt_1.getText().trim()));
                            pst.setInt(2,Integer.parseInt(txt_11.getText().trim()));
                            pst.setString(3,txt_10.getText().trim());
                            pst.setInt(4,codigo_cmb_3);
                            pst.execute();
                            actualizar_pantalla(accion_realizada);
                            conexion=null;
                            clase_conexion.cerrar_conexion();
                        }
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null,"Ocurrió un error al actualizar el registro, intente nuevamente "+ex,"ERROR",JOptionPane.ERROR_MESSAGE);
                    }
                }else{
                                    
                        if(clase_validaciones.validar_cantidad_entera_mayor(txt_11.getText().trim())==false){txt_11.setForeground(java.awt.Color.RED);mensaje=mensaje+"La cantidad de orden"+mensaje_error_cant_entera;}                        
                        if(cmb_3.getSelectedIndex()<0){mensaje=mensaje+mensaje_error_seleccion+" estado.\n";}
                        JOptionPane.showMessageDialog(null,mensaje_error_validacion+mensaje,"ERROR",JOptionPane.ERROR_MESSAGE);
                        mensaje="";
                }
                
            } 
            if(tabla=="Pedidos"){
   
                if(clase_validaciones.validar_cantidad_entera_mayor(txt_10.getText().trim())==true && 
                    clase_validaciones.validar_cantidad_decimal(txt_11.getText().trim())==true && 
		    cmb_2.getSelectedIndex()>=0 &&
                    clase_validaciones.validar_descuento(txt_12.getText().trim())==true){    

                    comando_sql="execute Procedimiento_actualizar_pedido ?,?,?,?,?";
                    codigo_cmb_2=consultar_codigo_de_registro("SELECT cod_estado FROM Estados WHERE nombre='"+cmb_2.getSelectedItem().toString()+"'");
                    try {
                        conexion=clase_conexion.conectar();
                        if(clase_conexion.obtener_estado_conexion()==true){
                            PreparedStatement pst=conexion.prepareCall(comando_sql);
                            pst.setInt(1,Integer.parseInt(txt_1.getText().trim())); // codigo
                            pst.setInt(2,codigo_cmb_2); //estado
                            pst.setInt(3,Integer.parseInt(txt_10.getText().trim())); // cantidad
                            pst.setDouble(4,Double.parseDouble(txt_11.getText().trim())); //precio 
                            pst.setDouble(5,convertir_descuento(txt_12.getText().trim())); //descuento
                            pst.execute();
                            actualizar_pantalla(accion_realizada);
                            conexion=null;
                            clase_conexion.cerrar_conexion();
                        }
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null,"Ocurrió un error al actualizar el registro, intente nuevamente "+ex,"ERROR",JOptionPane.ERROR_MESSAGE);
                    }
                }else{
               
                        if(clase_validaciones.validar_cantidad_entera_mayor(txt_10.getText().trim())==false){txt_10.setForeground(java.awt.Color.RED);mensaje=mensaje+"La cantidad"+mensaje_error_cant_entera;}
                        if(clase_validaciones.validar_cantidad_decimal(txt_11.getText().trim())==false){txt_11.setForeground(java.awt.Color.RED);mensaje=mensaje+"Precio"+mensaje_error_cant_decimal;}
                        if(clase_validaciones.validar_descuento(txt_12.getText().trim())==false){txt_12.setForeground(java.awt.Color.RED);mensaje=mensaje+mensaje_error_descuento;}
                        if(cmb_2.getSelectedIndex()<0){mensaje=mensaje+mensaje_error_seleccion+" estado.\n";}
                        JOptionPane.showMessageDialog(null,mensaje_error_validacion+mensaje,"ERROR",JOptionPane.ERROR_MESSAGE);
                        mensaje="";
                }
                
            }
            if(tabla=="Cotizacion"){

                if(clase_validaciones.validar_cantidad_entera_mayor(txt_10.getText().trim())==true && 
                    clase_validaciones.validar_cantidad_decimal(txt_11.getText().trim())==true && 
		    cmb_2.getSelectedIndex()>=0 &&
                    clase_validaciones.validar_descuento(txt_12.getText().trim())==true){

                    comando_sql="execute Procedimiento_actualizar_cotizacion ?,?,?,?,?";
                    codigo_cmb_2=consultar_codigo_de_registro("SELECT cod_estado FROM Estados WHERE nombre='"+cmb_2.getSelectedItem().toString()+"'");
                    try {
                        conexion=clase_conexion.conectar();
                        if(clase_conexion.obtener_estado_conexion()==true){
                            PreparedStatement pst=conexion.prepareCall(comando_sql);
                            pst.setInt(1,Integer.parseInt(txt_1.getText().trim()));
                            pst.setInt(2,codigo_cmb_2);
                            pst.setInt(3,Integer.parseInt(txt_10.getText().trim()));
                            pst.setDouble(4,Double.parseDouble(txt_11.getText().trim()));
                            pst.setDouble(5,convertir_descuento(txt_12.getText().trim()));
                            pst.execute();
                            actualizar_pantalla(accion_realizada);
                            conexion=null;
                            clase_conexion.cerrar_conexion();
                        }
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null,"Ocurrió un error al actualizar el registro, Intente nuevamente "+ex,"ERROR",JOptionPane.ERROR_MESSAGE);
                    }
                }else{                    
                        if(clase_validaciones.validar_cantidad_entera_mayor(txt_10.getText().trim())==false){txt_10.setForeground(java.awt.Color.RED);mensaje=mensaje+"La cantidad"+mensaje_error_cant_entera;}
                        if(clase_validaciones.validar_cantidad_decimal(txt_11.getText().trim())==false){txt_11.setForeground(java.awt.Color.RED);mensaje=mensaje+"Precio"+mensaje_error_cant_decimal;}
                        if(clase_validaciones.validar_descuento(txt_12.getText().trim())==false){txt_12.setForeground(java.awt.Color.RED);mensaje=mensaje+mensaje_error_descuento;}
                        if(cmb_2.getSelectedIndex()<0){mensaje=mensaje+mensaje_error_seleccion+" estado.\n";}
                        JOptionPane.showMessageDialog(null,mensaje_error_validacion+mensaje,"ERROR",JOptionPane.ERROR_MESSAGE);
                        mensaje="";
                }
            }
        }
    }//GEN-LAST:event_btn_guardarActionPerformed

    private void btn_punto_de_ventaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_punto_de_ventaActionPerformed
      
            int cod_cierre=0;

            try{
                conexion=clase_conexion.conectar();
                if(clase_conexion.obtener_estado_conexion()==true){
                    prepared_statement=conexion.prepareStatement("SELECT *  FROM Cierre_diario_Caja WHERE [cod_estado]=8");
                    result_set=prepared_statement.executeQuery();
                    if(result_set.next()){
                        cod_cierre=result_set.getInt("cod_cierre");
                        try{
                        prepared_statement=conexion.prepareStatement("SELECT * FROM Cierre_diario_Caja WHERE DATEDIFF(DAY,[fecha_Inicio],GETDATE())>0 AND cod_cierre="+cod_cierre);
                        result_set=prepared_statement.executeQuery();
                            if(result_set.next()){
                                int respuesta=JOptionPane.showConfirmDialog(null,"Para poder continuar debe:\n Cerrar la caja del día anterior\n","Cierre obligatorio de caja",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
                                if(respuesta==JOptionPane.YES_OPTION){
                                    frm_Cierre_caja cerrar_caja=new frm_Cierre_caja();
                                    cerrar_caja.setVisible(true);
                                    this.dispose();
                                }
                            }else{
                                frm_punto_de_venta punto_de_venta = new frm_punto_de_venta();
                                punto_de_venta.setVisible(true);
                                this.dispose();
                            }
                        }catch(SQLException e){
                            JOptionPane.showMessageDialog(this,"Ocurrió un error inesperado "+e,"ERROR",JOptionPane.ERROR_MESSAGE);
                        }
                    }else{
                        int respuesta=JOptionPane.showConfirmDialog(null,"Para poder continuar debe:\n Abrir la caja e indicar el efectivo inicial. \n","Apertura obligatoria de caja",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
                        if(respuesta==JOptionPane.YES_OPTION){
                            frm_abrir_caja abrir_caja=new frm_abrir_caja();
                            abrir_caja.setVisible(true); 
                            this.dispose();
                        }
                    }
                    conexion=null;
                    clase_conexion.cerrar_conexion();
                    prepared_statement.close();
                    result_set.close();
                }
            }catch(SQLException e){
                JOptionPane.showMessageDialog(this,"Ocurrió un error inesperado: "+e,"ERROR",JOptionPane.ERROR_MESSAGE);
            }
    }//GEN-LAST:event_btn_punto_de_ventaActionPerformed

    private void Tabla_principalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tabla_principalMouseClicked
        if(Tabla_editable==true){
            seleccionar_registro(Tabla_principal.rowAtPoint(evt.getPoint()));
        }
    }//GEN-LAST:event_Tabla_principalMouseClicked

    private void btn_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salirActionPerformed
        int respuesta=JOptionPane.showConfirmDialog(null,"¿Está seguro de salir del sistema?","AVISO",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
        if(respuesta==JOptionPane.YES_OPTION){
            this.dispose();
            frm_Login login=new frm_Login();
            login.setVisible(true);
            
        }
    }//GEN-LAST:event_btn_salirActionPerformed

    private void btn_imprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_imprimirActionPerformed
        if(tabla.equals("Productos_Venta")){
            reporte.Catalogo_Produtos_Ventas();
        }
        if(tabla.equals("Productos_Materia_Prima")){
            reporte.Catalogo_Materia_Prima();
        }
        if(tabla_secundaria.equals("Stock_productos_vt")){
            reporte.Stock_Ventas();
        }
        if(tabla_secundaria.equals("stock_productos_mt")){
            reporte.Stock_Materia_Prima();
        }
    }//GEN-LAST:event_btn_imprimirActionPerformed
    /*
    CORRECCIÓN DE ERROR
    Autores: Julio Tinoco
    Version 1.0   26/06/2020 
    se validó el ingreso de caracteres en las cajas de texto, limitandolos
    segun el tipo de dato.
    */
    private void txt_busquedaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_busquedaKeyTyped
        if(txt_busqueda.getText().length()>=50){
            evt.consume();
        }
    }//GEN-LAST:event_txt_busquedaKeyTyped

    private void txt_busquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_busquedaActionPerformed
       busqueda_de_registros();
    }//GEN-LAST:event_txt_busquedaActionPerformed

    private void txta_1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txta_1KeyTyped
       if(txta_1.getText().length()>=80){
            evt.consume();
       }
    }//GEN-LAST:event_txta_1KeyTyped

    private void txta_2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txta_2KeyTyped
        if(txta_2.getText().length()>=80){
            evt.consume();
       }
    }//GEN-LAST:event_txta_2KeyTyped

    private void txta_3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txta_3KeyTyped
        if(txta_3.getText().length()>=limite_texto_direccion){
            evt.consume();
       }
    }//GEN-LAST:event_txta_3KeyTyped

    private void txt_1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_1KeyTyped
       if(txt_1.getText().length()>=limite_texto_por_defecto){
            evt.consume();
       }
    }//GEN-LAST:event_txt_1KeyTyped

    private void txt_2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_2KeyTyped
        int limite_texto=limite_texto_por_defecto;
            if(tabla.equals("Empleados")){
                limite_texto=limite_texto_id;
            }
            if(tabla.equals("Proveedores") || tabla.equals("Datos_Organizacion")){
                limite_texto=limite_texto_id_rtn;
            }
            if(txt_2.getText().length()>=limite_texto){
                evt.consume();
            }
    }//GEN-LAST:event_txt_2KeyTyped

    private void txt_3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_3KeyTyped
        int limite_texto=limite_texto_por_defecto;
            if(tabla.equals("Productos_Venta") || tabla.equals("Productos_Materia_Prima")){
               limite_texto=limite_texto_cantidad_decimal;
            }
            if(tabla_secundaria.equals("Produccion_Produccion") && txt_3.getText().length()>=limite_texto_fecha){
               limite_texto=limite_texto_fecha;
            }
            if(txt_3.getText().length()>=limite_texto){
                evt.consume();
            }
    }//GEN-LAST:event_txt_3KeyTyped

    private void txt_4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_4KeyTyped
       int limite_texto=limite_texto_por_defecto;
       if(tabla.equals("Productos_Venta")){
            limite_texto=limite_texto_cantidad_decimal;
       }
       if(tabla_secundaria.equals("Compras_Compras")){
            limite_texto=limite_texto_cantidad_entera;
       }
       if(txt_4.getText().length()>=limite_texto){
                evt.consume();
       }
    }//GEN-LAST:event_txt_4KeyTyped

    private void txt_5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_5KeyTyped
        if(txt_5.getText().length()>=limite_texto_por_defecto){
            evt.consume();
       }
    }//GEN-LAST:event_txt_5KeyTyped

    private void txt_6KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_6KeyTyped
        if(txt_6.getText().length()>=limite_texto_por_defecto){
            evt.consume();
       }       
    }//GEN-LAST:event_txt_6KeyTyped

    private void txt_7KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_7KeyTyped
        if(txt_7.getText().length()>=limite_texto_por_defecto){
            evt.consume();
       }        
    }//GEN-LAST:event_txt_7KeyTyped

    private void txt_8KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_8KeyTyped
       if(txt_8.getText().length()>=limite_texto_por_defecto){
            evt.consume();
       }
    }//GEN-LAST:event_txt_8KeyTyped

    private void txt_9KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_9KeyTyped
       if(txt_9.getText().length()>=limite_texto_por_defecto){
            evt.consume();
       }
    }//GEN-LAST:event_txt_9KeyTyped

    private void txt_10KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_10KeyTyped
        int limite_texto=limite_texto_por_defecto;
        if(tabla.equals("Clientes")){
            limite_texto=limite_texto_id_rtn;
        }
        if(tabla.equals("Colecciones") || tabla.equals("Empleados") || tabla_secundaria.equals("Produccion_Produccion") ){
            limite_texto=limite_texto_fecha;
        }
        if(tabla_secundaria.equals("Ordenes_Compras") || tabla_secundaria.equals("Ordenes_Produccion") || tabla.equals("Productos_Venta") || tabla.equals("Productos_Materia_Prima") || tabla.equals("Inventario_Materia_Prima") || tabla.equals("Pedidos") || tabla.equals("Cotizacion")){
            limite_texto=limite_texto_cantidad_entera;
        }
        if(tabla_secundaria.equals("Compras_Compras")){
            limite_texto=limite_texto_cantidad_decimal;
        }
        if(tabla.equals("Datos_Organizacion")){
            limite_texto=limite_texto_correo;
        }
        if(tabla.equals("Tipos_de_Importe")){
            limite_texto=limite_texto_porcentaje;
        }
        if(txt_10.getText().length()>=limite_texto){
                evt.consume();
       }
    }//GEN-LAST:event_txt_10KeyTyped

    private void txt_11KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_11KeyTyped
         int limite_texto=limite_texto_por_defecto;
        if(tabla.equals("Clientes") || tabla.equals("Proveedores")){
           limite_texto=limite_texto_celular;
        }
        if(tabla.equals("Colecciones") || tabla.equals("Empleados")){
           limite_texto=limite_texto_fecha;
        }
        if(tabla.equals("Productos_Venta") || tabla.equals("Productos_Materia_Prima") || tabla_secundaria.equals("Ordenes_Compras") || tabla_secundaria.equals("Produccion_Produccion") || tabla.equals("Pedidos") || tabla.equals("Cotizacion")){
           limite_texto=limite_texto_cantidad_entera;
        }
        if(tabla_secundaria.equals("Compras_Compras")){
           limite_texto=limite_texto_num_factura;
        }
        if(tabla.equals("Datos_Organizacion")){
           limite_texto=limite_texto_correo;
        }
        if(txt_11.getText().length()>=limite_texto){
                evt.consume();
       }
    }//GEN-LAST:event_txt_11KeyTyped

    private void txt_12KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_12KeyTyped
        int limite_texto=limite_texto_por_defecto;
        if(tabla.equals("Clientes")||tabla.equals("Proveedores")){
            limite_texto=limite_texto_correo;
       }
       if(tabla.equals("Empleados")||tabla.equals("Datos_Organizacion")){
            limite_texto=limite_texto_celular;
       }
       if(tabla_secundaria.equals("Compras_Compras")){
            limite_texto=limite_texto_num_cai;
       }
       if(tabla.equals("Pedidos") || tabla.equals("Cotizacion")){
            limite_texto=limite_texto_porcentaje;
       }
       if(txt_12.getText().length()>=limite_texto){
            evt.consume();
       }
    }//GEN-LAST:event_txt_12KeyTyped

    private void txt_13KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_13KeyTyped
         int limite_texto=limite_texto_por_defecto;
        if(tabla.equals("Empleados")){
            limite_texto=limite_texto_correo;
        }
        if(tabla.equals("Datos_Organizacion")){
            limite_texto=limite_texto_celular;
       }
        if(txt_13.getText().length()>=limite_texto){
            evt.consume();
       }
    }//GEN-LAST:event_txt_13KeyTyped

    private void txt_14KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_14KeyTyped
        int limite_texto=limite_texto_por_defecto;
        if(tabla.equals("Datos_Organizacion")){
            limite_texto=limite_texto_celular;
        }
        if(txt_14.getText().length()>=limite_texto){
            evt.consume();
        }
    }//GEN-LAST:event_txt_14KeyTyped

    private void txt_15KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_15KeyTyped
        int limite_texto=limite_texto_por_defecto;
        if(tabla.equals("Datos_Organizacion")){
            limite_texto=limite_texto_celular;
        }
        if(txt_15.getText().length()>=limite_texto){
            evt.consume();
        }
    }//GEN-LAST:event_txt_15KeyTyped

    private void txt_16KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_16KeyTyped
         int limite_texto=limite_texto_por_defecto;
        if(tabla.equals("Datos_Organizacion")){
            limite_texto=limite_texto_num_cai;
       }
        if(txt_16.getText().length()>=limite_texto){
                evt.consume();
       }
    }//GEN-LAST:event_txt_16KeyTyped

    private void txt_17KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_17KeyTyped
        if(txt_17.getText().length()>=limite_texto_por_defecto){
            evt.consume();
       }
    }//GEN-LAST:event_txt_17KeyTyped

    private void txt_18KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_18KeyTyped
        if(txt_18.getText().length()>=limite_texto_por_defecto){
            evt.consume();
       }
    }//GEN-LAST:event_txt_18KeyTyped

    private void txt_19KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_19KeyTyped
         int limite_texto=limite_texto_por_defecto;
        if(tabla.equals("Pedidos")||tabla.equals("Cotizacion")){
            limite_texto=limite_texto_id_rtn;
       }
        if(tabla.equals("Datos_Organizacion")){
            limite_texto=limite_texto_fecha;
       }
        if(txt_19.getText().length()>=limite_texto){
                evt.consume();
       }
    }//GEN-LAST:event_txt_19KeyTyped

    private void txt_20KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_20KeyTyped
       int limite_texto=limite_texto_por_defecto;
        if(tabla.equals("Datos_Organizacion")){
            limite_texto=limite_texto_cantidad_decimal;
       }
        if(txt_20.getText().length()>=limite_texto){
            evt.consume();
       }
    }//GEN-LAST:event_txt_20KeyTyped

    private void txt_21KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_21KeyTyped
        int limite_texto=limite_texto_por_defecto;
        if(tabla.equals("Datos_Organizacion")){
            limite_texto=limite_texto_cantidad_decimal;
        }
        if(txt_21.getText().length()>=limite_texto){
            evt.consume();
        }
    }//GEN-LAST:event_txt_21KeyTyped

    private void txt_22KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_22KeyTyped
        if(txt_22.getText().length()>=limite_texto_por_defecto){
            evt.consume();
       }
    }//GEN-LAST:event_txt_22KeyTyped

    private void txt_busquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_busquedaKeyReleased
        busqueda_de_registros();
    }//GEN-LAST:event_txt_busquedaKeyReleased

    private void cmb_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_2ActionPerformed

    private void cmb_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_3ActionPerformed

    private void Tabla_principalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Tabla_principalKeyReleased
        if(Tabla_editable==true){
            seleccionar_registro(Tabla_principal.getSelectedRow());
        }
                
    }//GEN-LAST:event_Tabla_principalKeyReleased

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
            java.util.logging.Logger.getLogger(frmGibon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"ERROR : "+ex,"ERROR",JOptionPane.ERROR_MESSAGE);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmGibon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"ERROR : "+ex,"ERROR",JOptionPane.ERROR_MESSAGE);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmGibon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"ERROR : "+ex,"ERROR",JOptionPane.ERROR_MESSAGE);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmGibon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"ERROR : "+ex,"ERROR",JOptionPane.ERROR_MESSAGE);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmGibon().setVisible(true);
                
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panel_agregar_nuevo;
    private javax.swing.JPanel Panel_barra_superior;
    private javax.swing.JPanel Panel_busqueda_Y_botones;
    private javax.swing.JPanel Panel_cajas_de_texto;
    private javax.swing.JPanel Panel_contenedor_pantalla;
    private javax.swing.JPanel Panel_menu_principal;
    private javax.swing.JPanel Panel_sub_menu;
    private javax.swing.JPanel Panel_tabla_datos;
    private javax.swing.JPanel Panel_titulo;
    private javax.swing.JScrollPane Scroll_pane_txta_1;
    private javax.swing.JScrollPane Scroll_pane_txta_2;
    private javax.swing.JScrollPane Scroll_pane_txta_3;
    private javax.swing.JTable Tabla_principal;
    private javax.swing.JButton btn_administracion;
    private javax.swing.JButton btn_agregar_nuevo;
    private javax.swing.JButton btn_busqueda;
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_clientes;
    private javax.swing.JButton btn_colecciones;
    private javax.swing.JButton btn_compras;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_imprimir;
    private javax.swing.JButton btn_limpiar_busqueda;
    private javax.swing.JButton btn_materia_prima;
    private javax.swing.JButton btn_modificar;
    private javax.swing.JButton btn_produccion;
    private javax.swing.JButton btn_productos;
    private javax.swing.JButton btn_punto_de_venta;
    private javax.swing.JButton btn_salir;
    private javax.swing.JButton btn_sub_menu_1;
    private javax.swing.JButton btn_sub_menu_2;
    private javax.swing.JButton btn_sub_menu_3;
    private javax.swing.JButton btn_sub_menu_4;
    private javax.swing.JButton btn_sub_menu_5;
    private javax.swing.JButton btn_ventas;
    private javax.swing.JComboBox<String> cmb_1;
    private javax.swing.JComboBox<String> cmb_2;
    private javax.swing.JComboBox<String> cmb_3;
    private javax.swing.JComboBox<String> cmb_4;
    private javax.swing.JComboBox<String> cmb_busqueda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_agregar_nuevo;
    private javax.swing.JLabel lbl_titulo;
    private javax.swing.JLabel lbl_usuario_actual;
    private javax.swing.JTextField txt_1;
    private javax.swing.JTextField txt_10;
    private javax.swing.JTextField txt_11;
    private javax.swing.JTextField txt_12;
    private javax.swing.JTextField txt_13;
    private javax.swing.JTextField txt_14;
    private javax.swing.JTextField txt_15;
    private javax.swing.JTextField txt_16;
    private javax.swing.JTextField txt_17;
    private javax.swing.JTextField txt_18;
    private javax.swing.JTextField txt_19;
    private javax.swing.JTextField txt_2;
    private javax.swing.JTextField txt_20;
    private javax.swing.JTextField txt_21;
    private javax.swing.JTextField txt_22;
    private javax.swing.JTextField txt_3;
    private javax.swing.JTextField txt_4;
    private javax.swing.JTextField txt_5;
    private javax.swing.JTextField txt_6;
    private javax.swing.JTextField txt_7;
    private javax.swing.JTextField txt_8;
    private javax.swing.JTextField txt_9;
    private javax.swing.JTextField txt_busqueda;
    private javax.swing.JTextArea txta_1;
    private javax.swing.JTextArea txta_2;
    private javax.swing.JTextArea txta_3;
    // End of variables declaration//GEN-END:variables
}
