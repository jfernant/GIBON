
package Gibon;

import clases.Validaciones;
import clases.conexion;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/*
Clase: frm_restablecer
Autores: Erick, Victor
Version 1.0   04/04/2020 
permite al usuario restablecer su contraseña de sesión.
*/

public class frm_Restablecer extends javax.swing.JFrame {

    private conexion clase_conexion = new conexion();
    private Connection conexion = null;
    private frmGibon formulario_principal=new frmGibon();
    private frm_Login formulario_login = new frm_Login();
    private PreparedStatement prepared_statement;
    
    public frm_Restablecer() {
        initComponents();
        this.setLocationRelativeTo(null);
        Image iconoPropio = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/icono.png"));
        setIconImage(iconoPropio);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btn_cambiar = new javax.swing.JButton();
        txt_usuario = new javax.swing.JTextField();
        txt_nueva = new javax.swing.JTextField();
        txt_repetir = new javax.swing.JTextField();
        lbl_usuario = new javax.swing.JLabel();
        lbl_nueva = new javax.swing.JLabel();
        lbl_repetir = new javax.swing.JLabel();
        btn_cerrar1 = new javax.swing.JButton();
        lbl_error_contraseña = new javax.swing.JLabel();
        lbl_logo1 = new javax.swing.JLabel();
        lbl_logo = new javax.swing.JLabel();
        lbl_usuario1 = new javax.swing.JLabel();
        lbl_error = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gibon ● Grupo Industrial Bonilla");
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        btn_cambiar.setBackground(new java.awt.Color(0, 176, 60));
        btn_cambiar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_cambiar.setForeground(new java.awt.Color(255, 255, 255));
        btn_cambiar.setText("Restablecer");
        btn_cambiar.setToolTipText("Restablecer contraseña");
        btn_cambiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cambiarActionPerformed(evt);
            }
        });

        txt_usuario.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_usuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_usuarioKeyTyped(evt);
            }
        });

        txt_nueva.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_nueva.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_nuevaKeyTyped(evt);
            }
        });

        txt_repetir.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_repetir.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_repetirKeyTyped(evt);
            }
        });

        lbl_usuario.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        lbl_usuario.setForeground(new java.awt.Color(10, 76, 122));
        lbl_usuario.setText("Usuario:");

        lbl_nueva.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        lbl_nueva.setForeground(new java.awt.Color(10, 76, 122));
        lbl_nueva.setText("Contraseña nueva:");

        lbl_repetir.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        lbl_repetir.setForeground(new java.awt.Color(10, 76, 122));
        lbl_repetir.setText("Repetir contraseña:");

        btn_cerrar1.setBackground(new java.awt.Color(195, 50, 50));
        btn_cerrar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btn_cerrar.png"))); // NOI18N
        btn_cerrar1.setToolTipText("Salir");
        btn_cerrar1.setFocusPainted(false);
        btn_cerrar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cerrar1ActionPerformed(evt);
            }
        });

        lbl_error_contraseña.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        lbl_error_contraseña.setForeground(new java.awt.Color(255, 0, 0));
        lbl_error_contraseña.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lbl_logo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_logo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logo_cuadrado.jpg"))); // NOI18N

        lbl_logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/login_icono_candado.png"))); // NOI18N

        lbl_usuario1.setFont(new java.awt.Font("Calibri Light", 0, 24)); // NOI18N
        lbl_usuario1.setForeground(new java.awt.Color(214, 41, 57));
        lbl_usuario1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_usuario1.setText("Restablecimiento de contraseña");

        lbl_error.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        lbl_error.setForeground(new java.awt.Color(255, 0, 0));
        lbl_error.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(131, 131, 131)
                .addComponent(btn_cambiar, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(72, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_error, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_usuario)
                                    .addComponent(lbl_repetir)
                                    .addComponent(lbl_nueva))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txt_nueva, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txt_usuario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txt_repetir, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(62, 62, 62))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_cerrar1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_logo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_logo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_usuario1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbl_error_contraseña, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_cerrar1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_logo1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_logo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_usuario1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_usuario))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_nueva, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_nueva))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_repetir, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_repetir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_error, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_error_contraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_cambiar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(118, 118, 118))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    /*
    Evento: btn_cambiarActionPerformed
    Autores: Erick, Victor
    Version 1.0   04/04/2020 
    permite al usuario restablecer su contraseña de sesión.
    */
    private void btn_cambiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cambiarActionPerformed

        String mensaje_error="";
        int cod_usuario_modificar=0;
        String contraseña_nueva = txt_nueva.getText().trim();
        String contraseña_nueva_repetir = txt_repetir.getText().trim();
        Validaciones val = new Validaciones();
        
            if(contraseña_nueva.equals(contraseña_nueva_repetir) && val.validar_contraseña(contraseña_nueva) == true && val.validar_existencia_registro("Usuarios","nombre_usuario",txt_usuario.getText().trim())==false)
            {
                    cod_usuario_modificar=formulario_principal.consultar_codigo_de_registro(" SELECT [cod_usuario] FROM [Usuarios] WHERE [nombre_usuario]='"+txt_usuario.getText().trim()+"' COLLATE SQL_Latin1_General_CP1_CS_AS  AND cod_estado=1");
                    conexion=clase_conexion.conectar();
                    if(clase_conexion.obtener_estado_conexion()==true){
                        try{
                            String comando_sql="execute Procedimiento_restablecer_contraseña ?,?";
                            prepared_statement=conexion.prepareCall(comando_sql);
                            prepared_statement.setInt(1,cod_usuario_modificar);
                            prepared_statement.setString(2,contraseña_nueva);
                            prepared_statement.execute();
                            prepared_statement.close();
                            conexion=null;
                            clase_conexion.cerrar_conexion();
                            JOptionPane.showMessageDialog(null, " Contraseña restablecida con éxito ","AVISO", JOptionPane.INFORMATION_MESSAGE);
                            formulario_login.setVisible(true);
                            dispose();
                        }catch (SQLException ex){
                            JOptionPane.showMessageDialog(null, "Error al restablecer contraseña "+ex,"AVISO", JOptionPane.ERROR_MESSAGE);
                        } 
                    }         
             }else{
                mensaje_error="";
                lbl_error_contraseña.setText("");
                
                if(!contraseña_nueva.equals(contraseña_nueva_repetir)){mensaje_error=mensaje_error+"  Contraseñas deben coincidir  ";}
                if(val.validar_contraseña(contraseña_nueva) == false){JOptionPane.showConfirmDialog(null,"Contraseña debe contener al menos: ocho caracteres, una letra mayúscula, una letra minúscula y un número","ERROR",JOptionPane.ERROR_MESSAGE); }
                if(val.validar_existencia_registro("Usuarios","nombre_usuario",txt_usuario.getText().trim())== true){mensaje_error=mensaje_error+" Usuario no encontrado ";}
                lbl_error.setText(mensaje_error);
                
            }    
    }//GEN-LAST:event_btn_cambiarActionPerformed

    private void btn_cerrar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cerrar1ActionPerformed
    
        int respuesta=JOptionPane.showConfirmDialog(null,"¿Está seguro de salir del restablecimiento de contraseña?","AVISO",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
        if(respuesta==JOptionPane.YES_OPTION){
        formulario_login.setVisible(true);
        this.dispose();
        }
    }//GEN-LAST:event_btn_cerrar1ActionPerformed

    private void txt_usuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_usuarioKeyTyped
        if(txt_usuario.getText().length()>=30){
            evt.consume();
            lbl_error.setText("Ha sobrepasado la longitud máxima de usuario");
        }else{
            lbl_error.setText("");
        }
    }//GEN-LAST:event_txt_usuarioKeyTyped

    private void txt_nuevaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nuevaKeyTyped
        if(txt_nueva.getText().length()>=30){
            evt.consume();
            lbl_error.setText("Ha sobrepasado la longitud máxima de contraseña");
        }else{
            lbl_error.setText("");
        }
    }//GEN-LAST:event_txt_nuevaKeyTyped

    private void txt_repetirKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_repetirKeyTyped
        if(txt_repetir.getText().length()>=30){
            evt.consume();
            lbl_error.setText("Ha sobrepasado la longitud máxima de contraseña");
        }else{
            lbl_error.setText("");
        }
    }//GEN-LAST:event_txt_repetirKeyTyped

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
            java.util.logging.Logger.getLogger(frm_Restablecer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_Restablecer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_Restablecer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_Restablecer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_Restablecer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cambiar;
    private javax.swing.JButton btn_cerrar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl_error;
    private javax.swing.JLabel lbl_error_contraseña;
    private javax.swing.JLabel lbl_logo;
    private javax.swing.JLabel lbl_logo1;
    private javax.swing.JLabel lbl_nueva;
    private javax.swing.JLabel lbl_repetir;
    private javax.swing.JLabel lbl_usuario;
    private javax.swing.JLabel lbl_usuario1;
    private javax.swing.JTextField txt_nueva;
    private javax.swing.JTextField txt_repetir;
    private javax.swing.JTextField txt_usuario;
    // End of variables declaration//GEN-END:variables
}
