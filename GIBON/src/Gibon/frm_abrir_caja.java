package Gibon;

import clases.Permisos;
import clases.conexion;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/*
Clase: frm_abrir_caja
Autores: Julio Tinoco
Version 1.0   04/07/2020 
permite incicializar la apertura de caja para comenzar el proceso de ventas.
*/
public class frm_abrir_caja extends javax.swing.JFrame {

    private Permisos clase_permisos=new Permisos();
    private conexion clase_conexion=new conexion();
    private Connection Conexion=null;
    private frmGibon formulario_principal = new frmGibon();
    private PreparedStatement prepared_statement; 
    
    public frm_abrir_caja() {
        initComponents();
        this.setLocationRelativeTo(null);
        Image iconoPropio = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/icono.png"));
        setIconImage(iconoPropio);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btn_cerrar = new javax.swing.JButton();
        lbl_icono = new javax.swing.JLabel();
        lbl_titulo = new javax.swing.JLabel();
        btn_abrir_caja = new javax.swing.JButton();
        lbl_subtitulo = new javax.swing.JLabel();
        txt_cambio_inicial = new javax.swing.JTextField();
        lbl_error = new java.awt.Label();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        btn_cerrar.setBackground(new java.awt.Color(195, 50, 50));
        btn_cerrar.setFont(new java.awt.Font("Tahoma", 0, 3)); // NOI18N
        btn_cerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btn_cerrar.png"))); // NOI18N
        btn_cerrar.setToolTipText("Salir");
        btn_cerrar.setBorder(null);
        btn_cerrar.setBorderPainted(false);
        btn_cerrar.setFocusPainted(false);
        btn_cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cerrarActionPerformed(evt);
            }
        });

        lbl_icono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logo_cuadrado_pequeño.png"))); // NOI18N

        lbl_titulo.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        lbl_titulo.setForeground(new java.awt.Color(10, 76, 122));
        lbl_titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_titulo.setText("Apertura de caja");

        btn_abrir_caja.setBackground(new java.awt.Color(51, 153, 0));
        btn_abrir_caja.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_abrir_caja.setForeground(new java.awt.Color(255, 255, 255));
        btn_abrir_caja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/abrir_caja .png"))); // NOI18N
        btn_abrir_caja.setText("Abrir caja");
        btn_abrir_caja.setToolTipText("Abrir caja");
        btn_abrir_caja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_abrir_cajaActionPerformed(evt);
            }
        });

        lbl_subtitulo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_subtitulo.setText("Efectivo inicial :");

        txt_cambio_inicial.setText("0");
        txt_cambio_inicial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_cambio_inicialKeyTyped(evt);
            }
        });

        lbl_error.setAlignment(java.awt.Label.CENTER);
        lbl_error.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lbl_error.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbl_titulo, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                    .addComponent(btn_abrir_caja, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_cambio_inicial, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                            .addComponent(lbl_subtitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(5, 5, 5)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbl_icono)
                        .addGap(79, 79, 79)
                        .addComponent(btn_cerrar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbl_error, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_icono, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_cerrar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_titulo)
                .addGap(18, 18, 18)
                .addComponent(lbl_subtitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_cambio_inicial, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_error, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(btn_abrir_caja)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_cerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cerrarActionPerformed
        int respuesta=JOptionPane.showConfirmDialog(null,"¿Esta seguro de cerrar esta ventana?","AVISO",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
        if(respuesta==JOptionPane.YES_OPTION){
            formulario_principal.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btn_cerrarActionPerformed
    
    /*
    Evento: btn_abrir_cajaActionPerformed
    Autores: Julio Tinoco
    Version 1.0   04/07/2020 
    permite incicializar la apertura de caja para comenzar el proceso de ventas.
    */
    private void btn_abrir_cajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_abrir_cajaActionPerformed

        Double cambio_inicial=0.0;
        boolean correcto=false;
        
        try{
            cambio_inicial=Double.parseDouble(txt_cambio_inicial.getText().trim());
            if(cambio_inicial>=0.0){
               correcto=true;
            }
        }catch(NumberFormatException e){
            lbl_error.setText("Error, Ingrese una cantidad válida");
        }

        if(correcto==true){
            Conexion=clase_conexion.conectar();
            if(clase_conexion.obtener_estado_conexion()==true){
                try{
                    prepared_statement=Conexion.prepareStatement("INSERT INTO [dbo].[Cierre_diario_Caja] ([fecha_Inicio],[fecha_cierre],[cod_empleado],[cambio_inicial],[total_efectivo],[total_efectivo_reportado],[total_POS],[total_POS_reportado],[comentario],[cod_estado]) "+
                            "VALUES (GETDATE(),NULL,?,?,NULL,NULL,NULL,NULL,NULL,8)");
                    prepared_statement.setInt(1,clase_permisos.obtener_empleado_actual());
                    prepared_statement.setDouble(2,cambio_inicial);
                    prepared_statement.executeUpdate();
                    prepared_statement.close();
                    Conexion=null;
                    clase_conexion.cerrar_conexion();
                    JOptionPane.showMessageDialog(null,"Caja abierta con éxito","AVISO",JOptionPane.INFORMATION_MESSAGE);
                    frm_punto_de_venta PDV = new frm_punto_de_venta();
                    PDV.setVisible(true);
                    this.dispose();
                }catch(SQLException ex){
                    JOptionPane.showMessageDialog(null,"Error al abrir caja, Intente nuevamente "+ex,"ERROR",JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_btn_abrir_cajaActionPerformed

    private void txt_cambio_inicialKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cambio_inicialKeyTyped
        if(txt_cambio_inicial.getText().length()>=5){
            evt.consume();
            lbl_error.setText("Ha sobrepasado el límite de cambio inicial");
        }else{
            lbl_error.setText("");
        }
    }//GEN-LAST:event_txt_cambio_inicialKeyTyped

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
            java.util.logging.Logger.getLogger(frm_abrir_caja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_abrir_caja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_abrir_caja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_abrir_caja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_abrir_caja().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_abrir_caja;
    private javax.swing.JButton btn_cerrar;
    private javax.swing.JPanel jPanel1;
    private java.awt.Label lbl_error;
    private javax.swing.JLabel lbl_icono;
    private javax.swing.JLabel lbl_subtitulo;
    private javax.swing.JLabel lbl_titulo;
    private javax.swing.JTextField txt_cambio_inicial;
    // End of variables declaration//GEN-END:variables
}
