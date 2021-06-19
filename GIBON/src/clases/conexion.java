
package clases;

import Gibon.frm_error_conexion;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.*;
import javax.swing.JOptionPane;

/*
Clase: conexion
Autor: José Hernández
Version 1.0   20/02/2020

Clase que permite realizar la conexión con la base de datos y
almacenar detalles de error.
*/

public class conexion {
    
    
    private Connection conexion = null;
    private static boolean estado_conexion;
    private String sHostName="";
    
    public Connection conectar(){

        try {
            sHostName = InetAddress.getLocalHost().getHostName();
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String Url = "jdbc:sqlserver://"+sHostName+":1433;databaseName=GIBON;integratedSecurity=true;";
            conexion = DriverManager.getConnection(Url);
            estado_conexion=true;
        }
        catch(Exception ex){
            frm_error_conexion.nombre_servidor=sHostName;
            frm_error_conexion.mensaje_error="Error al conectar con la base de datos \n Intente de nevo más tarde \n : "+ex;
            estado_conexion=false;
            frm_error_conexion frm_error_conexion=new frm_error_conexion();
            frm_error_conexion.setVisible(true);
        }
        return conexion; 
    }
    
    public void cerrar_conexion(){
        try {
           conexion.close();
           estado_conexion=false;
        }catch (SQLException  ex) {
           JOptionPane.showMessageDialog(null,"Error al desconectar con la base de datos \n Intente nuevamente.");
        }
    }
    
    public boolean obtener_estado_conexion(){
        return estado_conexion;
    }
}
