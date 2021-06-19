package clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/*
Clase: Validaciones
Autores: Julio Tinoco,José Hernández,Tomas Ledezma.
Version 1.0   05/07/2020

Clase que contiene los principales metodos de validaciones del sistema. 
*/

public class Validaciones {
    
    private conexion clase_conexion = new conexion();
    private Connection conexion = clase_conexion.conectar();
    private PreparedStatement prepared_statement;
    private ResultSet result_set;
    private final Date fecha_actual=new Date();
    private final SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
    private Date fecha = null;
    private final Calendar fecha_actual_local = new GregorianCalendar();
    private final int año_actual=fecha_actual_local.get(Calendar.YEAR);

    public boolean validar_punto_decimal(String texto){
        if(texto.length()>0){

            if(texto.contains(".")){
                return false;
            }else{
                return true;    
            }
            
        }else{
            return false;
        }
    }
    /*
    CORRECCIÓN DE ERROR
    Autores: 
    Version 1.0   25/06/2020 
    se corrigio los estandares de seguridad del nombre de usuario, agregando una
    validacion.
    */
    public boolean validar_nombre_de_usuario(String nombre_usuario){
        int longitud_cadena,cant_mayus=0,cant_espacios=0,cant_num=0;
        longitud_cadena=nombre_usuario.length();
        
        if(longitud_cadena>0){
           
            for(int posicion_cadena=0;posicion_cadena<longitud_cadena;posicion_cadena++){
                
                if(Character.isSpaceChar(nombre_usuario.charAt(posicion_cadena))){
                    cant_espacios++;
                }
                if(Character.isUpperCase(nombre_usuario.charAt(posicion_cadena))){
                   cant_mayus++;
                }
                if(Character.isDigit(nombre_usuario.charAt(posicion_cadena))){
                   cant_num++;
                }
                
            }
        }else{
            return false;
        }
       
        if(longitud_cadena>=8 && longitud_cadena<=30 && cant_mayus>=1 && cant_espacios==0 && cant_num>=1){
            return true;
        }else{         
            return false;
        }
        
    }
    
    /*
    CORRECCIÓN DE ERROR
    Autores: 
    Version 1.0   25/06/2020 
    se corrigió el ingreso de espacios en blanco en la contraseña
    modificando la validacion.
    */
    public boolean validar_contraseña(String contraseña){
        
        int longitud,cant_mayus=0,cant_minus=0,cant_num=0,cant_errores=0;
        longitud=contraseña.length();
        
        if(longitud>0){
            
            for(int posicion_cadena=0;posicion_cadena<longitud;posicion_cadena++){
                
                if(Character.isSpaceChar(contraseña.charAt(posicion_cadena))){
                    cant_errores++;
                }
                if(Character.isUpperCase(contraseña.charAt(posicion_cadena))){
                   cant_mayus++;
                }
                if(Character.isLowerCase(contraseña.charAt(posicion_cadena))){
                   cant_minus++;
                }
                if(Character.isDigit(contraseña.charAt(posicion_cadena))){
                   cant_num++;
                } 
            }
        }else{
            return false;
        }

        if(longitud>=8 && longitud<=30 && cant_mayus>=1 && cant_minus>=1 && cant_num>=1 && cant_errores==0){
            return true;
        }else{         
            return false;
        }
        
    }
    

    public boolean validar_num_id(String id){

        int longitud_cadena,año_fecha, cant_digitos=0, cant_errores=0;
        longitud_cadena=id.length();
        
        if(longitud_cadena>0){
                
            for(int posicion_cadena=0;posicion_cadena<longitud_cadena;posicion_cadena++){
                if(Character.isDigit(id.charAt(posicion_cadena))){
                   cant_digitos++;
                }else{
                    cant_errores++;
                }        
            }
                    
        }else{
            return false;
        }
        
        if(cant_digitos == 13 && cant_errores == 0 && validar_año_identificacion(id)==true){
            return true;
        }else{         
            return false;
        }
       
    }

    public boolean validar_rtn(String rtn){

        int logitud_cadena, cant_digitos=0, cont_error=0;
        logitud_cadena=rtn.length();
        
        if(logitud_cadena>0){
            
            for(int posicion_cadena=0;posicion_cadena<logitud_cadena;posicion_cadena++){
                if(Character.isDigit(rtn.charAt(posicion_cadena))){
                   cant_digitos++;
                }else{
                    cont_error++;
                }
            }
        }else{
           return false;         
        }
        if(cant_digitos == 14 && cont_error == 0 && validar_año_identificacion(rtn)==true){
            return true;
        }else{         
            return false;
        } 
       
    }
    
    public boolean validar_id_rtn(String id_rtn){
       
        int logitud_cadena, cant_digitos=0, cont_error=0;
        logitud_cadena=id_rtn.length();
        
        if(logitud_cadena>0){
            
            for(int posicion_cadena=0;posicion_cadena<logitud_cadena;posicion_cadena++){

                if(Character.isDigit(id_rtn.charAt(posicion_cadena))){
                   cant_digitos++;
                }else{
                    cont_error++;
                }        
            }
            
        }else{
            return false;
        }
        if(cant_digitos >= 13 && cant_digitos <= 14 && cont_error == 0 && validar_año_identificacion(id_rtn)==true){
            return true;
        }else{                       
            return false;
        }
       
    }
    
    public boolean validar_año_identificacion(String identificacion){
        int año_identificacion;
        try{
            año_identificacion=Integer.parseInt(identificacion.substring(4,8));
        }catch(NumberFormatException ex){
            return false;
        } 
        
        if(año_identificacion>=(año_actual-100) && año_identificacion<=(año_actual-18)){
            return true;
        }else{
            return false;
        }
    }
    public boolean validar_campo(String cadena){

        int longitud_cadena, cant_errores=0, cant_letras_espacios=0;
        longitud_cadena= cadena.length();

        try{
            for(int posicion_cadena=0;posicion_cadena<longitud_cadena;posicion_cadena++){
                if(posicion_cadena<(longitud_cadena-1) && Character.isSpaceChar(cadena.charAt(posicion_cadena)) && Character.isSpaceChar(cadena.charAt(posicion_cadena+1))){
                   cant_errores++;
                }
                if(Character.isLetter(cadena.charAt(posicion_cadena)) || Character.isSpaceChar(cadena.charAt(posicion_cadena))){
                   cant_letras_espacios++;
                }else{
                    cant_errores++;
                }
            }
            if(cant_errores == 0 && cant_letras_espacios>= 3){
                return true;
            }else{             
                return false;
            }
        }catch(Exception ex){
            return false;
        }  
    }     
    

    public boolean validar_fecha(String cadena) {
        formatoFecha.setLenient(false);
        int año_fecha=0;
            
            try {
                fecha=formatoFecha.parse(cadena);
                año_fecha=Integer.parseInt(cadena.substring(0,4));
                if(fecha.compareTo(fecha_actual)<=0 && año_fecha>=2015){
                    return true;
                }
            } catch (ParseException e) {
                return false;
            }
            return false;
    }
    
    public boolean validar_fecha_posterior(String cadena) {
        formatoFecha.setLenient(false);
        int año_fecha=0;    
            try {
                fecha=formatoFecha.parse(cadena);
                año_fecha=Integer.parseInt(cadena.substring(0,4));
                    if(fecha.compareTo(fecha_actual)>=0 && año_fecha<=(año_actual+5)){
                        return true;
                    }
            } catch (ParseException e) {
                return false;
            }
            return false;
    }

    public boolean validar_fecha_nacimiento(String cadena) {

        int año_fecha;
        formatoFecha.setLenient(false);           
            try {
                fecha=formatoFecha.parse(cadena);
                año_fecha=Integer.parseInt(cadena.substring(0,4));
                if(año_fecha>=(año_actual-100) && año_fecha<=(año_actual-18)){
                    return true;
                }
            } catch (ParseException e) {
                return false;
            }
            return false;
    }
    
    /*
    CORRECCIÓN DE ERROR
    método: validar_rango_de_fechas
    Autores: 
    Version 1.0   28/06/2020 
    Verifica congruencia entre la fecha incial y la final.
    */
    public boolean validar_rango_de_fechas(String cadena_fecha_mayor,String cadena_fecha_menor) {
        
        formatoFecha.setLenient(false);
        Date fecha_mayor,fecha_menor;

        try {
            fecha_mayor=formatoFecha.parse(cadena_fecha_mayor);
            fecha_menor=formatoFecha.parse(cadena_fecha_menor);
            if(fecha_mayor.compareTo(fecha_menor)>=0){
                return true;
            }
        }catch (ParseException e) {
            return false;
        }
        return false;
    }
    

    public boolean validar_numero_contacto(String num){

        int cant_num=0, cont_error=0;

        if(num.length()>0){
            if(num.charAt(0)=='9'||num.charAt(0)=='8'||num.charAt(0)=='2'||num.charAt(0)=='3'){

                for(int posicion_Cadena=0;posicion_Cadena<num.length();posicion_Cadena++){

                    if(Character.isDigit(num.charAt(posicion_Cadena))){
                       cant_num++;
                    }else{
                        cont_error++;
                    }        

                }
            }else{
                cont_error=1;
            }
        }else{
           return false;
        }
        if(cant_num == 8 && cont_error == 0){
            return true;
        }else{             
            return false;
        }
       
    }

    public boolean validar_existencia_registro(String tabla, String campo, String valor){
   
        String sql = "SELECT * FROM "+tabla+" WHERE "+campo+"=?";
 
         try{
            prepared_statement = conexion.prepareStatement(sql);
            prepared_statement.setString(1, valor);
            result_set = prepared_statement.executeQuery();
            
            if(result_set.next()){
                return false;
            }
            else{
                return true;
            }
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al ejecutar la consulta");
            return false;
        }     
    }
    /*
    CORRECCIÓN DE ERROR
    método: validar_existencia_modificar
    Autores: 
    Version 1.0   28/06/2020 
    Busca y verifica la existencia de un campo en la base de datos
    y detemirna si pertenece al registro a modificar.
    */
    public boolean validar_existencia_modificar(String tabla, String campo, String valor_buscado, String campo_codigo,int codigo){

        String sql = "SELECT * FROM "+tabla+" WHERE "+campo+"=?";
        int codigo_encontrado=0;

         try{
            prepared_statement = conexion.prepareStatement(sql);
            prepared_statement.setString(1, valor_buscado);
            result_set = prepared_statement.executeQuery();
            
            if(result_set.next()){
                codigo_encontrado=result_set.getInt(campo_codigo);
                if(codigo_encontrado==codigo){
                    return true;
                }else{
                    return false;
                }
            }else{
                return true;
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al ejecutar la consulta");
            return false;
        }     
    }

    public boolean validar_cantidad_entera(String cantidad_cadena){
        
        int cantidad_entera;

        try{
        
            cantidad_entera = Integer.parseInt(cantidad_cadena);
            
            if(cantidad_entera>= 0 && cantidad_entera <=100){
                return true;
            }else{                
                return false;
            }
            
        }catch(Exception e){
            return false;
        }
    
    }

    public boolean validar_cantidad_entera_mayor(String cadena_numero){

        int numero;

        try{
            numero = Integer.parseInt(cadena_numero);
            if(numero >= 1 && numero <= 10000){
                return true;
            }else{        
                return false;
            }
            
        }catch(Exception e){
            return false;
        }
    
    }

    public boolean validar_cantidad_decimal(String cantidad_cadena){   
        
        double cantidad; 

        try{
            cantidad = Double.parseDouble(cantidad_cadena);
            if(cantidad >= 1 && cantidad<=1000000){
                return true;
            }else{           
                return false;
            }
            
        }catch(Exception e){
            return false;
        }
    
    }

    public boolean validar_correo(String correo){
        
        if(correo.length()>0){
            Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                                            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
            Matcher mather = pattern.matcher(correo);
            return mather.find() == true;
        }else{
            return false;
        }
    }
    /*
    CORRECCIÓN DE ERROR
    método: redondear_decimales
    Autores: 
    Version 1.0  25/06/2020 
    Redondea las cantidades a dos decimales, para corregir el desbordamiento
    en las cajas de texto.
    */
    public double redondear_decimales(double cantidad){
        int parte_entera;
        parte_entera=(int)Math.round(cantidad*100);
        double redondeado = parte_entera/100.0;
        return redondeado;
    }
    /*
    CORRECCIÓN DE ERROR
    Autores: 
    Version 1.0   1/07/2020 
    se corrigio el ingreso del descuento porcentual agregando una validacion.
    */
    public boolean validar_descuento(String porcentaje_descuento_texto){
        int porcentaje_descuento;
        if(porcentaje_descuento_texto.length()==0){
            return true;
        }else{
            try{
                porcentaje_descuento=Integer.parseInt(porcentaje_descuento_texto);
                if(porcentaje_descuento>=1 && porcentaje_descuento<=80){
                    return true;
                }else{
                    return false;
                }
            }catch(Exception e){
                return false;
            }
        }
    }
    /*
    CORRECCIÓN DE ERROR
    método: validar_cai
    Autores: 
    Version 1.0   04/07/2020 
    verifica el cumplimiento del formato de numero de cai.
    */
    public boolean validar_CAI(String cai){
        
        int longitud_cai=cai.length(),contador_errores=0,limite_inferior=0,limite_superior=6;
        
        if(longitud_cai==37){
            
            for(int repetidor_de_ciclo=0;repetidor_de_ciclo<5;repetidor_de_ciclo++){
                
                for(int posicion_Cadena=limite_inferior;posicion_Cadena<limite_superior;posicion_Cadena++){
                    if(Character.isLetterOrDigit(cai.charAt(posicion_Cadena))==false){
                        contador_errores++;   
                    }
                }
                if(cai.charAt(limite_superior)!='-'){
                   contador_errores++;
                }
                limite_inferior=limite_inferior+7;
                limite_superior=limite_superior+7;
                
            }
            if(Character.isLetterOrDigit(cai.charAt(35))==false || Character.isLetterOrDigit(cai.charAt(36))==false){
                   contador_errores++;
            }
            
        }
        if(contador_errores==0){
            return true;
        }else{
            return false;
        }
    }
}


