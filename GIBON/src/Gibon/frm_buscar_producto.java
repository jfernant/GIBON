package Gibon;

import clases.conexion;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class frm_buscar_producto extends javax.swing.JFrame {

    private conexion clase_conexion=new conexion();
    private Connection conexion=null;
    private DefaultTableModel defalut_table_model;
    private String Titulos_tabla []={"Código","Nombre","Stock","Precio unitario"};
    private String Titulos_base[]={"cod_producto_vt","nombre_producto","stock","precio_unitario"};
    private String Datos[]=new String[4];
    private String cod_producto,nombre_producto,precio_producto;
    private int fila_seleccionada,stock_producto;    

    public frm_buscar_producto() {
        initComponents();
        Tabla_principal.setCellSelectionEnabled(false);
        Tabla_principal.setColumnSelectionAllowed(false);
        Tabla_principal.setRowSelectionAllowed(true); 
        mostrar_datos_tabla("SELECT cod_producto_vt,nombre_producto,stock,precio_unitario FROM Productos_Venta WHERE cod_estado!=7");
        this.setLocationRelativeTo(null);
        Image iconoPropio = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/icono.png"));
        setIconImage(iconoPropio);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel_barra_superior = new javax.swing.JPanel();
        btn_cerrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        txt_busqueda = new javax.swing.JTextField();
        cmb_busqueda = new javax.swing.JComboBox<>();
        btn_agregar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        Tabla_principal = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setName("Buscar Producto"); // NOI18N
        setUndecorated(true);

        Panel_barra_superior.setBackground(new java.awt.Color(0, 0, 0));

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

        jLabel1.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Buscar y añadir productos");

        javax.swing.GroupLayout Panel_barra_superiorLayout = new javax.swing.GroupLayout(Panel_barra_superior);
        Panel_barra_superior.setLayout(Panel_barra_superiorLayout);
        Panel_barra_superiorLayout.setHorizontalGroup(
            Panel_barra_superiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_barra_superiorLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(177, 177, 177)
                .addComponent(btn_cerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        Panel_barra_superiorLayout.setVerticalGroup(
            Panel_barra_superiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_barra_superiorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel_barra_superiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_cerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));

        jPanel1.setBackground(new java.awt.Color(10, 76, 122));

        txt_busqueda.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 14)); // NOI18N
        txt_busqueda.setToolTipText("");
        txt_busqueda.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Buscar :", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Microsoft JhengHei UI Light", 0, 12), new java.awt.Color(10, 76, 122))); // NOI18N
        txt_busqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_busquedaKeyReleased(evt);
            }
        });

        cmb_busqueda.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 12)); // NOI18N
        cmb_busqueda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Código", "Nombre" }));
        cmb_busqueda.setToolTipText("Buscar por ...");

        btn_agregar.setBackground(new java.awt.Color(39, 174, 96));
        btn_agregar.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 11)); // NOI18N
        btn_agregar.setForeground(new java.awt.Color(255, 255, 255));
        btn_agregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btn_añadir_a_la_venta.png"))); // NOI18N
        btn_agregar.setText("Agregar a la venta");
        btn_agregar.setToolTipText("Cerrar Caja");
        btn_agregar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        btn_agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agregarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_busqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmb_busqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_agregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_agregar, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                    .addComponent(cmb_busqueda)
                    .addComponent(txt_busqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane2.setToolTipText("");
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        Tabla_principal = new javax.swing.JTable(){
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        Tabla_principal.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        Tabla_principal.setAutoscrolls(false);
        Tabla_principal.setGridColor(new java.awt.Color(0, 0, 0));
        Tabla_principal.setRowHeight(30);
        Tabla_principal.setRowMargin(2);
        Tabla_principal.setSelectionBackground(new java.awt.Color(50, 86, 122));
        Tabla_principal.setSelectionForeground(new java.awt.Color(251, 252, 252));
        Tabla_principal.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        Tabla_principal.setShowVerticalLines(false);
        Tabla_principal.getTableHeader().setResizingAllowed(false);
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
        jScrollPane2.setViewportView(Tabla_principal);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 658, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel_barra_superior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Panel_barra_superior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    /*
    Funcion: mostrar_datos_tabla
    Autores: José Hernández
    Version 1.0   22/07/2020 
    funcion que permite ejecutar y mostrar la busqueda de productos.
    */
    private void mostrar_datos_tabla(String consulta){
        defalut_table_model=new DefaultTableModel(null,Titulos_tabla);
        conexion=clase_conexion.conectar();
        if(clase_conexion.obtener_estado_conexion()==true){
            try{
                Statement statement=conexion.createStatement();
                ResultSet result_set=statement.executeQuery(consulta);
                while(result_set.next()){
                    for(int contador_de_columnas=0;contador_de_columnas<4;contador_de_columnas++){
                        Datos[contador_de_columnas]=result_set.getString(Titulos_base[contador_de_columnas]);
                    }
                    defalut_table_model.addRow(Datos);
                }
                Tabla_principal.setModel(defalut_table_model);
                Tabla_principal.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
                statement.close();
                result_set.close();
                conexion=null;
                clase_conexion.cerrar_conexion();
            }catch(Exception ex){

            }
        }
    }
    private void btn_cerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_cerrarActionPerformed
    
    /*
    Evento: btn_agregarActionPerformed
    Autores: José Hernández, Julio Tinoco
    Version 1.0   23/07/2020 
    funcion que permite agregar a la venta el producto seleccionado.
    */
    private void btn_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregarActionPerformed
        
        fila_seleccionada=Tabla_principal.getSelectedRow();
        if(fila_seleccionada>=0){
            cod_producto=String.valueOf(Tabla_principal.getValueAt(fila_seleccionada,0)).trim();
            nombre_producto=String.valueOf(Tabla_principal.getValueAt(fila_seleccionada,1)).trim();
            stock_producto=Integer.parseInt(Tabla_principal.getValueAt(fila_seleccionada,2).toString().trim());
            precio_producto=String.valueOf(Tabla_principal.getValueAt(fila_seleccionada,3)).trim();
            if(stock_producto>0){
                frm_punto_de_venta punto_de_venta= new frm_punto_de_venta(cod_producto,nombre_producto,precio_producto);
                if(punto_de_venta.validar_producto(cod_producto)==false){
                    punto_de_venta.agregar_fila();
                    this.dispose();
                }else{
                     JOptionPane.showMessageDialog(null, "Error: Este producto ya ha sido agregado a la venta.","ERROR",JOptionPane.ERROR_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(null, "Error: Ha seleccionado un producto sin unidades en inventario.","ERROR",JOptionPane.ERROR_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Error: Debe seleccionar un producto.","ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_agregarActionPerformed
    
    /*
    Evento: txt_busquedaKeyReleased
    Autores: José Hernández, Julio Tinoco
    Version 1.0   23/07/2020 
    funcion que genera la consulta según los parámetros de búsqueda ingresados.
    */
    private void txt_busquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_busquedaKeyReleased
        int tipo_busqueda;
        String campo_condicion="",query_sql="",busqueda="";
        tipo_busqueda=cmb_busqueda.getSelectedIndex();
        busqueda=txt_busqueda.getText().trim();
        
            if(tipo_busqueda==0){
               campo_condicion="cod_producto_vt";
               query_sql=" ='"+busqueda+"'";
            }else{
               campo_condicion="nombre_producto";
               query_sql=" LIKE '%"+busqueda+"%'";
            }
        if(busqueda.length()>0){
            mostrar_datos_tabla("SELECT cod_producto_vt,nombre_producto,stock,precio_unitario FROM Productos_Venta WHERE cod_estado!=7 AND "+campo_condicion+query_sql);
        }else{
            mostrar_datos_tabla("SELECT cod_producto_vt,nombre_producto,stock,precio_unitario FROM Productos_Venta WHERE cod_estado!=7");
        }    
    }//GEN-LAST:event_txt_busquedaKeyReleased

    private void Tabla_principalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Tabla_principalKeyReleased
        fila_seleccionada=Tabla_principal.getSelectedRow();
    }//GEN-LAST:event_Tabla_principalKeyReleased

    private void Tabla_principalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tabla_principalMouseClicked
        
    }//GEN-LAST:event_Tabla_principalMouseClicked

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
            java.util.logging.Logger.getLogger(frm_buscar_producto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_buscar_producto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_buscar_producto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_buscar_producto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_buscar_producto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panel_barra_superior;
    private javax.swing.JTable Tabla_principal;
    private javax.swing.JButton btn_agregar;
    private javax.swing.JButton btn_cerrar;
    private javax.swing.JComboBox<String> cmb_busqueda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField txt_busqueda;
    // End of variables declaration//GEN-END:variables
}
