
package Gibon;

import clases.Datos_de_facturacion;

/*
Clase: Frm_venta_exitosa
Autores: José Hernández, Julio
Version 1.0   01/07/2020 
Clase que permite mostrar los datos obtenidos desde el punto de venta
y almacenados em la clase datos_de_facturacion.
*/

public class frm_venta_exitosa extends javax.swing.JFrame {

    private Datos_de_facturacion Datos_de_facturacion=new Datos_de_facturacion();
    public frm_venta_exitosa() {
        initComponents();
        this.setLocationRelativeTo(null);
        mostrar_datos_de_venta();
    }
    public final void mostrar_datos_de_venta(){
        txt_efectivo.setText(String.valueOf(Datos_de_facturacion.obtener_cantidad_efectivo()));
        txt_tarjeta.setText(String.valueOf(Datos_de_facturacion.obtener_cantidad_tarjeta()));
        txt_total.setText(String.valueOf(Datos_de_facturacion.obtener_total_venta()));
        txt_cambio.setText(String.valueOf(Datos_de_facturacion.obtener_cambio()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel_barra_superior = new javax.swing.JPanel();
        imagen_logo = new javax.swing.JLabel();
        btn_cerrar = new javax.swing.JButton();
        txt_efectivo = new javax.swing.JTextField();
        txt_tarjeta = new javax.swing.JTextField();
        txt_total = new javax.swing.JTextField();
        txt_cambio = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        setResizable(false);

        Panel_barra_superior.setBackground(new java.awt.Color(0, 0, 0));

        imagen_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/img_gibon_grande.png"))); // NOI18N

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
                .addContainerGap(128, Short.MAX_VALUE)
                .addComponent(imagen_logo, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(84, 84, 84)
                .addComponent(btn_cerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        Panel_barra_superiorLayout.setVerticalGroup(
            Panel_barra_superiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_barra_superiorLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(imagen_logo))
            .addGroup(Panel_barra_superiorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_cerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txt_efectivo.setEditable(false);
        txt_efectivo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_efectivo.setToolTipText("Cantidad cancelada en efectivo");
        txt_efectivo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Efectivo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        txt_tarjeta.setEditable(false);
        txt_tarjeta.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_tarjeta.setToolTipText("Cantidad cancelada con tarjeta");
        txt_tarjeta.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tarjetas / POS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        txt_total.setEditable(false);
        txt_total.setBackground(new java.awt.Color(245, 245, 245));
        txt_total.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_total.setToolTipText("Total de la venta");
        txt_total.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Total:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        txt_cambio.setEditable(false);
        txt_cambio.setBackground(new java.awt.Color(10, 76, 122));
        txt_cambio.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_cambio.setForeground(new java.awt.Color(255, 255, 255));
        txt_cambio.setToolTipText("Cambio del cliente");
        txt_cambio.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cambio en efectivo", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 0, 0));
        jLabel1.setText("Mostrando factura a continuación ...");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Panel_barra_superior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txt_total, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_tarjeta, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_efectivo, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_cambio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(45, 45, 45))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Panel_barra_superior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txt_efectivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_tarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txt_cambio, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_cerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_cerrarActionPerformed

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
            java.util.logging.Logger.getLogger(frm_venta_exitosa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_venta_exitosa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_venta_exitosa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_venta_exitosa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_venta_exitosa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panel_barra_superior;
    private javax.swing.JButton btn_cerrar;
    private javax.swing.JLabel imagen_logo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField txt_cambio;
    private javax.swing.JTextField txt_efectivo;
    private javax.swing.JTextField txt_tarjeta;
    private javax.swing.JTextField txt_total;
    // End of variables declaration//GEN-END:variables
}
