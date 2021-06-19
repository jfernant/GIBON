package clases;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/*
Clase: Permisos
Autor: Julio Tinoco
Version 1.0   24/02/2020

Clase que permite almacenar los datos del usuario que inicia sesion y 
asigna permisos segun el nivel de acceso. 
*/

public class Permisos {
    
    conexion clase_conexion=new conexion();
    Connection Conexion=clase_conexion.conectar();
    PreparedStatement prepared_statement; 
    ResultSet result_set;
    
    private static boolean Permiso_1,Permiso_2,Permiso_3,Permiso_4,Permiso_5,Permiso_6
            ,Permiso_7,Permiso_8,Permiso_9,Permiso_10;
    private static int cod_empleado_actual,cod_usuario_actual,nivel_de_acceso_actual;
    
    public Permisos(){
        
    }
    public Permisos(int cod_empleado_actual,int cod_usuario_actual,int nivel_de_acceso_actual){
       Permisos.cod_empleado_actual=cod_empleado_actual;
       Permisos.cod_usuario_actual=cod_usuario_actual;
       Permisos.nivel_de_acceso_actual=nivel_de_acceso_actual;
    }
    public int obtener_empleado_actual(){
        return cod_empleado_actual;
    }
    
    /*la función cambio_de_estado permite modificar los estados de las variables
    de permiso.    
    */
    private void cambio_de_estado(boolean p1,boolean p2,boolean p3,boolean p4, boolean p5, boolean p6, boolean p7, boolean p8,boolean p9,boolean p10){
        Permiso_1=p1;
        Permiso_2=p2;
        Permiso_3=p3;
        Permiso_4=p4;
        Permiso_5=p5;
        Permiso_6=p6;
        Permiso_7=p7;
        Permiso_8=p8;
        Permiso_9=p9;
        Permiso_10=p10;
        
    }
    
    public void Aplicar_permisos(){
        if(Permisos.nivel_de_acceso_actual==1){
            cambio_de_estado(true,false,false,false,false,false,false,false,false,false);
        }
        if(Permisos.nivel_de_acceso_actual==2){
            cambio_de_estado(false,true,false,false,false,false,false,false,false,false);
        }
        if(Permisos.nivel_de_acceso_actual==3){
            cambio_de_estado(false,false,true,false,false,false,false,false,false,false);
        }
        if(Permisos.nivel_de_acceso_actual==4){
            cambio_de_estado(false,false,false,true,false,false,false,false,false,false);
        }
        if(Permisos.nivel_de_acceso_actual==5){
            cambio_de_estado(false,false,false,false,true,false,false,false,false,false);
        }
        if(Permisos.nivel_de_acceso_actual==6){
            cambio_de_estado(false,false,false,false,false,true,false,false,false,false);
        }
        if(Permisos.nivel_de_acceso_actual==7){
            cambio_de_estado(false,false,false,false,false,false,true,false,false,false);
        }
        if(Permisos.nivel_de_acceso_actual==8){
            cambio_de_estado(false,false,false,false,false,false,false,true,false,false);
        }
        if(Permisos.nivel_de_acceso_actual==9){
            cambio_de_estado(false,false,false,false,false,false,false,false,true,false);
        }
        if(Permisos.nivel_de_acceso_actual==10){
            cambio_de_estado(false,false,false,false,false,false,false,false,false,true);
        }
    }
    
    public int obtener_permiso_actual(){
        if(Permiso_1==true){
            return 1;
        }
        if(Permiso_2==true){
            return 2;
        }
        if(Permiso_3==true){
            return 3;
        }
        if(Permiso_4==true){
            return 4;
        }
        if(Permiso_5==true){
            return 5;
        }
        if(Permiso_6==true){
            return 6;
        }
        if(Permiso_7==true){
            return 7;
        }
        if(Permiso_8==true){
            return 8;
        }
        if(Permiso_9==true){
            return 9;
        }
        if(Permiso_10==true){
            return 10;
        }
        return 0;
    }
    
    public String obtener_usuario_actual(){
        
        String nombre_usuario_nivel_acceso="";
        
        try{
            CallableStatement callable_statement_local=Conexion.prepareCall("SELECT * FROM Usuarios WHERE cod_usuario="+Permisos.cod_usuario_actual);
            result_set=callable_statement_local.executeQuery();
                if(result_set.next()){
                    nombre_usuario_nivel_acceso=result_set.getString("nombre_usuario").trim();
                }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Ocurrió un error al mostrar el usuario actual"+e,"ERROR",JOptionPane.ERROR_MESSAGE);
        }
        
        try{
            CallableStatement callable_statement_local=Conexion.prepareCall("SELECT * FROM Niveles_Acceso WHERE [cod_nivel_acceso]="+Permisos.nivel_de_acceso_actual);
            result_set=callable_statement_local.executeQuery();
                if(result_set.next()){
                    nombre_usuario_nivel_acceso=nombre_usuario_nivel_acceso+" / "+result_set.getString("nombre_nivel").trim();
                }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Ocurrió un error al mostrar el usuario actual"+e,"ERROR",JOptionPane.ERROR_MESSAGE);
        }
        
        return nombre_usuario_nivel_acceso;
    }
}
