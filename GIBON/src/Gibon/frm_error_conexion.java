package Gibon;

import clases.conexion;
import java.awt.Image;
import java.awt.Toolkit;

/*
Clase: frm_error_conexion
Autores: Katering,Tomas 
Version 1.0   03/03/2020 
permite mostrar en pantalla el detalle de errores de conexión.
*/
public class frm_error_conexion extends javax.swing.JFrame {

    
    public static String nombre_servidor,mensaje_error;
    
    public frm_error_conexion() {
        initComponents();
        mostrar();
        this.setLocationRelativeTo(null);
    }
    
    public void mostrar(){
        lbl_1.setText("ERROR AL CONECTAR");
        lbl_2.setText("BASE DE DATOS");
        lbl_servidor.setText("Servidor local: "+nombre_servidor.trim());
        txta_error.setText(mensaje_error.trim());
        txta_error.setAutoscrolls(false);
        Image iconoPropio = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/icono.png"));
        setIconImage(iconoPropio);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lbl_2 = new javax.swing.JLabel();
        lbl_1 = new javax.swing.JLabel();
        lbl_servidor = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txta_error = new javax.swing.JTextArea();
        lbl_servidor1 = new javax.swing.JLabel();
        btn_intentar_de_nuevo = new javax.swing.JButton();
        btn_cancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/error_base_de_datos.png"))); // NOI18N

        lbl_2.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        lbl_2.setForeground(new java.awt.Color(255, 51, 51));
        lbl_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_2.setText("BASE DE DATOS");

        lbl_1.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        lbl_1.setForeground(new java.awt.Color(255, 51, 51));
        lbl_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_1.setText("ERROR AL CONECTAR");

        lbl_servidor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_servidor.setForeground(new java.awt.Color(10, 76, 122));
        lbl_servidor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_servidor.setText("Servidor local:");

        txta_error.setColumns(20);
        txta_error.setRows(5);
        txta_error.setAutoscrolls(false);
        jScrollPane1.setViewportView(txta_error);

        lbl_servidor1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_servidor1.setForeground(new java.awt.Color(10, 76, 122));
        lbl_servidor1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_servidor1.setText("Error:");

        btn_intentar_de_nuevo.setBackground(new java.awt.Color(51, 153, 0));
        btn_intentar_de_nuevo.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 12)); // NOI18N
        btn_intentar_de_nuevo.setForeground(new java.awt.Color(255, 255, 255));
        btn_intentar_de_nuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/reintentar.png"))); // NOI18N
        btn_intentar_de_nuevo.setText("  Reconectar");
        btn_intentar_de_nuevo.setToolTipText("Intentar de nuevo");
        btn_intentar_de_nuevo.setBorderPainted(false);
        btn_intentar_de_nuevo.setFocusPainted(false);
        btn_intentar_de_nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_intentar_de_nuevoActionPerformed(evt);
            }
        });

        btn_cancelar.setBackground(new java.awt.Color(204, 51, 0));
        btn_cancelar.setForeground(new java.awt.Color(255, 255, 255));
        btn_cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btn_cerrar.png"))); // NOI18N
        btn_cancelar.setToolTipText("Cancelar");
        btn_cancelar.setBorderPainted(false);
        btn_cancelar.setFocusPainted(false);
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbl_2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(86, 86, 86)
                        .addComponent(btn_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_servidor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbl_servidor1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addComponent(btn_intentar_de_nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(128, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btn_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_2)
                .addGap(13, 13, 13)
                .addComponent(lbl_servidor, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_servidor1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_intentar_de_nuevo, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_cancelarActionPerformed

    private void btn_intentar_de_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_intentar_de_nuevoActionPerformed
        
        lbl_1.setText("INTENTANDO RECONECTAR ....");
        
        conexion clase_conexion=new conexion();
        clase_conexion.conectar();
        
        if(clase_conexion.obtener_estado_conexion()==true){
            this.dispose();
        }else{
            lbl_2.setText("ERROR AL CONECTAR BASE DE DATOS");
            lbl_servidor.setText("Servidor local: "+nombre_servidor);
            txta_error.setText(mensaje_error);
        }
    }//GEN-LAST:event_btn_intentar_de_nuevoActionPerformed


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
            java.util.logging.Logger.getLogger(frm_error_conexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_error_conexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_error_conexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_error_conexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_error_conexion().setVisible(true);
                
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_intentar_de_nuevo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_1;
    private javax.swing.JLabel lbl_2;
    private javax.swing.JLabel lbl_servidor;
    private javax.swing.JLabel lbl_servidor1;
    private javax.swing.JTextArea txta_error;
    // End of variables declaration//GEN-END:variables
}
