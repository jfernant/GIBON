
package Gibon;

import clases.conexion;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/*
Clase: frm_acceso_admin
Autores: erick victor
Version 1.0   03/20/2020 
permite a los usuario administradores dar paso al restablecimiento de contraseña
de los usuarios del sistema.
*/

public class frm_Acceso_admin extends javax.swing.JFrame {

    
    private conexion clase_conexion = new conexion();
    private Connection conexion = null;
    private int contador_intentos=3;
    private PreparedStatement prepared_statement;
    private ResultSet result_set;
    
    public frm_Acceso_admin() {
        initComponents();
        this.setLocationRelativeTo(null);
        Image iconoPropio = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/icono.png"));
        setIconImage(iconoPropio);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbl_aviso = new javax.swing.JLabel();
        lbl_logo = new javax.swing.JLabel();
        btn_aceptar = new javax.swing.JButton();
        txt_usuario = new javax.swing.JTextField();
        pwf_contraseña = new javax.swing.JPasswordField();
        lbl_usuario = new javax.swing.JLabel();
        lbl_contraseña = new javax.swing.JLabel();
        lbl_error = new javax.swing.JLabel();
        btn_cerrar1 = new javax.swing.JButton();
        lbl_usuario1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Restablecimiento de Contraseña ");
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        lbl_aviso.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_aviso.setForeground(new java.awt.Color(255, 0, 0));
        lbl_aviso.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_aviso.setText("AVISO: ¡Usted esta habilitando el restablecimiento de contraseña! ");

        lbl_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/login_icono_candado.png"))); // NOI18N

        btn_aceptar.setBackground(new java.awt.Color(0, 176, 60));
        btn_aceptar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_aceptar.setForeground(new java.awt.Color(255, 255, 255));
        btn_aceptar.setText("Aceptar");
        btn_aceptar.setToolTipText("Conceder permiso para restablecer contraseña");
        btn_aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_aceptarActionPerformed(evt);
            }
        });

        txt_usuario.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txt_usuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_usuarioKeyTyped(evt);
            }
        });

        pwf_contraseña.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        pwf_contraseña.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pwf_contraseñaKeyTyped(evt);
            }
        });

        lbl_usuario.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_usuario.setForeground(new java.awt.Color(10, 76, 122));
        lbl_usuario.setText("Usuario:");

        lbl_contraseña.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_contraseña.setForeground(new java.awt.Color(10, 76, 122));
        lbl_contraseña.setText("Contraseña:");

        lbl_error.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lbl_error.setForeground(new java.awt.Color(255, 0, 0));
        lbl_error.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        btn_cerrar1.setBackground(new java.awt.Color(195, 50, 50));
        btn_cerrar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btn_cerrar.png"))); // NOI18N
        btn_cerrar1.setToolTipText("Salir");
        btn_cerrar1.setBorderPainted(false);
        btn_cerrar1.setFocusPainted(false);
        btn_cerrar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cerrar1ActionPerformed(evt);
            }
        });

        lbl_usuario1.setFont(new java.awt.Font("Calibri Light", 0, 24)); // NOI18N
        lbl_usuario1.setForeground(new java.awt.Color(214, 41, 57));
        lbl_usuario1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_usuario1.setText("Permiso de administrador");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_error, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(164, 164, 164)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pwf_contraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_contraseña)
                            .addComponent(lbl_usuario))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_aviso, javax.swing.GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(lbl_logo)
                                .addGap(170, 170, 170)
                                .addComponent(btn_cerrar1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btn_aceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(182, 182, 182))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_usuario1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_logo, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btn_cerrar1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(lbl_usuario1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_usuario)
                .addGap(2, 2, 2)
                .addComponent(txt_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_contraseña)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(lbl_error, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(pwf_contraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_aceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_aviso)
                .addGap(98, 98, 98))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_cerrar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cerrar1ActionPerformed
        int respuesta=JOptionPane.showConfirmDialog(null,"¿Esta seguro de Cerrar el Restablecimiento de Contraseña?","AVISO",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
        if(respuesta==JOptionPane.YES_OPTION){
            frm_Login login=new frm_Login();
            login.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btn_cerrar1ActionPerformed
    /*
    Rutina: acceder al restablecimiento de contraseña
    Autores: erick
    Version 1.0   04/07/2020 
    verifica que el usuario cuente con los permisos adecuados para dar acceso
    al restablecimiento de contraseña.
    */
    private void btn_aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_aceptarActionPerformed

        if(contador_intentos>=2){
            try{
                String Usuario = txt_usuario.getText();
                String Contra = String.valueOf(pwf_contraseña.getPassword());
                String query_sql = "SELECT * FROM usuarios WHERE nombre_usuario = '" +Usuario+ "' COLLATE SQL_Latin1_General_CP1_CS_AS and CONVERT(VARCHAR(MAX), DECRYPTBYPASSPHRASE('DeCryPtGBN', [contraseña]))= '"+ Contra+ "' COLLATE SQL_Latin1_General_CP1_CS_AS and cod_nivel_acceso=1 AND cod_estado=1";
                conexion=clase_conexion.conectar();
                if(clase_conexion.obtener_estado_conexion()==true){
                    
                    prepared_statement = conexion.prepareStatement(query_sql);
                    result_set = prepared_statement.executeQuery();
                    if(result_set.next()){
                        frm_Restablecer formulario_restablecer = new frm_Restablecer();
                        formulario_restablecer.setVisible(true);
                        dispose();
                    
                    }else{
                        query_sql = "SELECT * FROM usuarios WHERE nombre_usuario = '" +Usuario+ "' COLLATE SQL_Latin1_General_CP1_CS_AS and CONVERT(VARCHAR(MAX), DECRYPTBYPASSPHRASE('DeCryPtGBN', [contraseña]))= '"+ Contra+ "' COLLATE SQL_Latin1_General_CP1_CS_AS and cod_nivel_acceso=10 AND cod_estado=1";
                        prepared_statement = conexion.prepareStatement(query_sql);
                        result_set = prepared_statement.executeQuery();
                        
                        if(result_set.next()){
                            frm_Restablecer formulario_restablecer = new frm_Restablecer();
                            formulario_restablecer.setVisible(true);
                            dispose();
                        
                        }else{
                            contador_intentos=contador_intentos-1;
                            lbl_error.setText("Usuario o Contraseña incorrectos, Quedan "+contador_intentos+" intentos");
                            txt_usuario.setText("");
                            pwf_contraseña.setText("");
                            txt_usuario.grabFocus();
                        }
                    }
                    conexion=null;
                    clase_conexion.cerrar_conexion();
                    prepared_statement.close();
                    result_set.close();
                }
            }catch (SQLException ex){
                JOptionPane.showMessageDialog(null,"Intente de Nuevamente","ERROR CON EL ACCESO",JOptionPane.ERROR_MESSAGE);
            }
        }else{
            frm_Login frm_login = new frm_Login();
            frm_login.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btn_aceptarActionPerformed

    private void txt_usuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_usuarioKeyTyped
        if(txt_usuario.getText().length()>=30){
            evt.consume();
            lbl_error.setText("Ha sobrepasado la longitud máxima de usuario");
        }else{
            lbl_error.setText("");
        }
    }//GEN-LAST:event_txt_usuarioKeyTyped

    private void pwf_contraseñaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pwf_contraseñaKeyTyped
        if(String.valueOf(pwf_contraseña.getPassword()).length()>=30){
            evt.consume();
            lbl_error.setText("Ha sobrepasado la longitud máxima de contraseña");
        }else{
            lbl_error.setText("");
        }
    }//GEN-LAST:event_pwf_contraseñaKeyTyped

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
            java.util.logging.Logger.getLogger(frm_Acceso_admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_Acceso_admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_Acceso_admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_Acceso_admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_Acceso_admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_aceptar;
    private javax.swing.JButton btn_cerrar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl_aviso;
    private javax.swing.JLabel lbl_contraseña;
    private javax.swing.JLabel lbl_error;
    private javax.swing.JLabel lbl_logo;
    private javax.swing.JLabel lbl_usuario;
    private javax.swing.JLabel lbl_usuario1;
    private javax.swing.JPasswordField pwf_contraseña;
    private javax.swing.JTextField txt_usuario;
    // End of variables declaration//GEN-END:variables
}
