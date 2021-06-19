
package Gibon;

import clases.Permisos;
import clases.conexion;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/*
Clase: frm_login
Autores: Julio Jose
Version 1.0   28/03/2020 
Permite a los usuarios: el inicio de sesión y la apertura del restablecimiento de
contraseña.
*/
public class frm_Login extends javax.swing.JFrame {

    private conexion clase_conexion = new conexion();
    private Connection conexion = null;
    private PreparedStatement prepared_statement;
    private ResultSet result_set;
    private int contador_intentos=3;
    
    public frm_Login() {
        initComponents();
        this.setLocationRelativeTo(null);
        lbl_mostrar.setVisible(false);
        Image iconoPropio = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/icono.png"));
        setIconImage(iconoPropio);
    }
    /*
    OPTIMIZACIÓN DE CÓDIGO
    Función: iniciar_sesion
    Autores: Julio Jose
    Version 1.0   29/06/2020 
    se elimino la duplicidad de código reduciendo el incio de sesión a una función.
    */
    private void iniciar_sesion(){
        
        if(contador_intentos>=2){
            
            try{
                String Usuario = txt_usuario.getText().trim();
                String Contra = String.valueOf(pwf_contraseña.getPassword());
                /*
                CORRECCIÓN DE ERROR
                Autores: Julio Jose
                Version 1.0   15/06/2020 
                se corrigió la consulta SQL que verifica los campos del usuario en la base de datos
                para que impida el acceso de usuarios no autorizados.
                (Distincion de mayusculas y minusculas, usuarios inactivos).
                */
                conexion=clase_conexion.conectar();
                if(clase_conexion.obtener_estado_conexion()==true){
                    String sql = "SELECT *  FROM usuarios WHERE nombre_usuario = '"+Usuario+"' COLLATE SQL_Latin1_General_CP1_CS_AS and CONVERT(VARCHAR(MAX), DECRYPTBYPASSPHRASE('DeCryPtGBN', [contraseña]))= '"+Contra+"' COLLATE SQL_Latin1_General_CP1_CS_AS AND cod_estado=1";
                    prepared_statement = conexion.prepareStatement(sql);
                    result_set = prepared_statement.executeQuery();

                    if(result_set.next()){
                        Permisos Permisos=new Permisos(result_set.getInt("cod_empleado"),result_set.getInt("cod_usuario"),result_set.getInt("cod_nivel_acceso"));
                        Permisos.Aplicar_permisos();
                        frmGibon GBN = new frmGibon();
                        GBN.setVisible(true);
                        this.dispose();
                    } else{
                        contador_intentos=contador_intentos-1;
                        lbl_error.setText("Usuario o Contraseña incorrectos, Quedan "+contador_intentos+" intentos");
                        txt_usuario.setText("");
                        pwf_contraseña.setText("");
                        txt_usuario.grabFocus();
                    }
                    conexion=null;
                    clase_conexion.cerrar_conexion();
                    prepared_statement.close();
                    result_set.close();
                }
                
            }catch (SQLException ex){
                JOptionPane.showMessageDialog(null,"Intente de Nuevamente","ERROR AL ACCEDER",JOptionPane.ERROR_MESSAGE);
            }
        }else{
            System.exit(0);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbl_usuario = new javax.swing.JLabel();
        lbl_contraseña = new javax.swing.JLabel();
        txt_usuario = new javax.swing.JTextField();
        pwf_contraseña = new javax.swing.JPasswordField();
        btn_iniciar_sesion = new javax.swing.JButton();
        lbl_restablecer = new javax.swing.JLabel();
        lbl_error = new javax.swing.JLabel();
        btn_visible = new javax.swing.JButton();
        lbl_mostrar = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lbl_logo = new javax.swing.JLabel();
        lbl_logo1 = new javax.swing.JLabel();
        lbl_usuario1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gibon ● Grupo Industrial Bonilla");
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setToolTipText("Iniciar Sesión");

        lbl_usuario.setFont(new java.awt.Font("Calibri Light", 1, 12)); // NOI18N
        lbl_usuario.setForeground(new java.awt.Color(10, 76, 122));
        lbl_usuario.setText("Usuario:");

        lbl_contraseña.setFont(new java.awt.Font("Calibri Light", 1, 12)); // NOI18N
        lbl_contraseña.setForeground(new java.awt.Color(10, 76, 122));
        lbl_contraseña.setText("Contraseña:");

        txt_usuario.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_usuario.setToolTipText("Usuario");
        txt_usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_usuarioActionPerformed(evt);
            }
        });
        txt_usuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_usuarioKeyTyped(evt);
            }
        });

        pwf_contraseña.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pwf_contraseña.setToolTipText("Contraseña");
        pwf_contraseña.setNextFocusableComponent(btn_visible);
        pwf_contraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pwf_contraseñaActionPerformed(evt);
            }
        });
        pwf_contraseña.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pwf_contraseñaKeyTyped(evt);
            }
        });

        btn_iniciar_sesion.setBackground(new java.awt.Color(10, 76, 122));
        btn_iniciar_sesion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_iniciar_sesion.setForeground(new java.awt.Color(255, 255, 255));
        btn_iniciar_sesion.setText("Iniciar sesión");
        btn_iniciar_sesion.setToolTipText("Iniciar sesión");
        btn_iniciar_sesion.setNextFocusableComponent(lbl_restablecer);
        btn_iniciar_sesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_iniciar_sesionActionPerformed(evt);
            }
        });

        lbl_restablecer.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_restablecer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_restablecer.setText("¿Ha olvidado su contraseña? ");
        lbl_restablecer.setToolTipText("Recuperar Contraseña");
        lbl_restablecer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_restablecerMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_restablecerMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl_restablecerMouseExited(evt);
            }
        });

        lbl_error.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        lbl_error.setForeground(new java.awt.Color(255, 0, 0));
        lbl_error.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        btn_visible.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/visible.png"))); // NOI18N
        btn_visible.setToolTipText("Mostrar contraseña");
        btn_visible.setBorder(null);
        btn_visible.setBorderPainted(false);
        btn_visible.setContentAreaFilled(false);
        btn_visible.setFocusPainted(false);
        btn_visible.setNextFocusableComponent(btn_iniciar_sesion);
        btn_visible.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_visibleActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(10, 76, 122));
        jLabel1.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("¡ Bienvenido !");
        jLabel1.setOpaque(true);

        lbl_logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/login_icono_candado.png"))); // NOI18N

        lbl_logo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_logo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logo_cuadrado.jpg"))); // NOI18N

        lbl_usuario1.setFont(new java.awt.Font("Calibri Light", 0, 36)); // NOI18N
        lbl_usuario1.setForeground(new java.awt.Color(214, 41, 57));
        lbl_usuario1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_usuario1.setText("Inicio de sesión");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbl_logo1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbl_logo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbl_usuario1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE))
                    .addComponent(lbl_error, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(pwf_contraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_visible, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbl_restablecer, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(402, 402, 402)
                        .addComponent(lbl_mostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_usuario)
                            .addComponent(lbl_contraseña)
                            .addComponent(txt_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(btn_iniciar_sesion, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_logo1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbl_logo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbl_usuario1)
                .addGap(18, 18, 18)
                .addComponent(lbl_usuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(lbl_contraseña)
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_visible, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(pwf_contraseña, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
                .addGap(8, 8, 8)
                .addComponent(lbl_error, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(lbl_mostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(btn_iniciar_sesion, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(lbl_restablecer)))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_iniciar_sesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_iniciar_sesionActionPerformed
        iniciar_sesion();  
    }//GEN-LAST:event_btn_iniciar_sesionActionPerformed

    private void lbl_restablecerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_restablecerMouseClicked
        frm_Acceso_admin ACC = new frm_Acceso_admin();
        ACC.setVisible(true);
        dispose();
    }//GEN-LAST:event_lbl_restablecerMouseClicked

    private void lbl_restablecerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_restablecerMouseEntered
        lbl_restablecer.setForeground(new java.awt.Color(255,0,0));
        
    }//GEN-LAST:event_lbl_restablecerMouseEntered

    private void lbl_restablecerMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_restablecerMouseExited
  
        lbl_restablecer.setForeground(new java.awt.Color(0,0,0));
        
    }//GEN-LAST:event_lbl_restablecerMouseExited

    private void btn_visibleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_visibleActionPerformed
        if(lbl_mostrar.getText().equals(""))
        {

            btn_visible.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/visible_oscuro.png")));
            pwf_contraseña.setEchoChar((char)0);
            lbl_mostrar.setText(("Set"));
        }
        else
        {

            btn_visible.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/visible.png")));
            pwf_contraseña.setEchoChar('*');
            lbl_mostrar.setText("");
        }

    }//GEN-LAST:event_btn_visibleActionPerformed

    private void pwf_contraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pwf_contraseñaActionPerformed
        iniciar_sesion();  
    }//GEN-LAST:event_pwf_contraseñaActionPerformed

    private void txt_usuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_usuarioKeyTyped
        if(txt_usuario.getText().length()>=30){
            evt.consume();
            lbl_error.setText("Ha sobrepasado la longitud máxima del usuario");
        }else{
            lbl_error.setText("");
        }
    }//GEN-LAST:event_txt_usuarioKeyTyped

    private void txt_usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_usuarioActionPerformed
         iniciar_sesion();  
    }//GEN-LAST:event_txt_usuarioActionPerformed

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
            java.util.logging.Logger.getLogger(frm_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_iniciar_sesion;
    private javax.swing.JButton btn_visible;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl_contraseña;
    private javax.swing.JLabel lbl_error;
    private javax.swing.JLabel lbl_logo;
    private javax.swing.JLabel lbl_logo1;
    private javax.swing.JLabel lbl_mostrar;
    private javax.swing.JLabel lbl_restablecer;
    private javax.swing.JLabel lbl_usuario;
    private javax.swing.JLabel lbl_usuario1;
    private javax.swing.JPasswordField pwf_contraseña;
    private javax.swing.JTextField txt_usuario;
    // End of variables declaration//GEN-END:variables
}
