
package Gibon;

import Reportes.GenerarReporte;
import clases.Datos_de_facturacion;
import clases.Permisos;
import clases.Validaciones;
import clases.conexion;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/*
Clase: frm_punto_de_venta
Autores: Jose Hernandez
Version 1.0   04/07/2020 
Clase que permite: relizar las ventas del sistema y cerrar la caja del dia.
*/
public class frm_punto_de_venta extends javax.swing.JFrame {
    
    Calendar fecha_actual=new GregorianCalendar();
    private conexion clase_conexion=new conexion();
    private Connection conexion=null;
    private GenerarReporte clase_reportes = new GenerarReporte();
    private Permisos clase_permisos=new Permisos();
    private frmGibon formulario_principal = new frmGibon();
    private Validaciones clase_validaciones = new Validaciones();
    public static DefaultTableModel modelo_tabla;
    private PreparedStatement prepared_statement; 
    private ResultSet result_set;
    private String Titulos_tabla []={"Código","Nombre","Precio unitario","Cantidad","Sub total"};
    private boolean variable_de_validacion=false;
    private String hora,minutos,segundos;
    
    private static String cod_producto_agregar="";
    private static String nombre_producto_agregar="";
    private static String precio_producto_agregar="";
    
    private int cod_producto=0;
    private static String nombre_producto="";
    private static double precio_producto=0;
    private static String tipo_de_importe="";
    private double porcentaje_importe=0;
    private static int cantidad=0;

    private static double sub_total=0;
    private static double importe_exonerado=0;
    private static double importe_exento=0;
    private static double importe_gravado_15=0;
    private static double isv_15=0;
    private static double descuentos_y_rebajas=0;
    private static double total=0;
    private static double total_efectivo=0;
    private static double total_tarjeta=0;
    private static double cambio=0;
    
    private static int cod_cliente=0;
    private final int cod_empleado=clase_permisos.obtener_empleado_actual();
    private static String n_referencia="";
    
    private static String caja_actual="";
    
    public frm_punto_de_venta() {
        
        initComponents();
        this.setLocationRelativeTo(null);
        lbl_fecha.setText(fecha());
        modelo_tabla=new DefaultTableModel();
        modelo_tabla.addColumn("Código");
        modelo_tabla.addColumn("Nombre");
        modelo_tabla.addColumn("Precio unitario");
        modelo_tabla.addColumn("Cantidad");
        modelo_tabla.addColumn("Sub total");
        Tabla_principal.setModel(modelo_tabla);
        inicializar_formulario();

        Image iconoPropio = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/icono.png"));
        setIconImage(iconoPropio);
    }
    public frm_punto_de_venta(String cod_producto,String nombre_producto,String precio_unitario){
        cod_producto_agregar=cod_producto; 
        nombre_producto_agregar=nombre_producto; 
        precio_producto_agregar=precio_unitario;
    }
    
    /*
    Función: inicializar_formulario
    Autores: Jose Hernandez
    Version 1.0   18/03/2020 
    funcion que permite iniciar y dar formato a la pantalla de ventas.
    */
    private void inicializar_formulario(){
        Tabla_principal.setCellSelectionEnabled(false);
        Tabla_principal.setColumnSelectionAllowed(false);
        Tabla_principal.setRowSelectionAllowed(true);
        
        lbl_usuario_actual.setText(clase_permisos.obtener_usuario_actual());
        lbl_numero_factura.setText(correlativo_factura());
        
        txt_id.setText("");
        txt_nombres.setText("");
        txt_apellidos.setText("");
        txt_celular.setText("");
        txt_correo.setText("");
        txt_codigo_producto.setText("");
        txt_cantidad_producto.setText("");
        txt_nombre_producto.setText("");
        txt_precio_producto.setText("");
        txt_subtotal_producto.setText("");
        lbl_subtotal.setText("0");
        lbl_exonerado.setText("0");
        lbl_exento.setText("0");
        lbl_gravado.setText("0");
        lbl_isv.setText("0");
        lbl_total.setText("0");
        txt_efectivo.setText("");
        txt_tarjeta.setText("");
        txt_ref.setText("");
        txt_cambio.setText("");
        txt_descuentos_rebajas.setText("0");
        Panel_producto_1.setVisible(true);
               
        for( int contador_filas = modelo_tabla.getRowCount() - 1; contador_filas >= 0; contador_filas-- ) {
           modelo_tabla.removeRow(contador_filas);
        }
        
        cmb_medio_de_pago.setSelectedIndex(0);
        txt_efectivo.setEnabled(true);
               
        cod_producto=0;
        nombre_producto="";
        precio_producto=0;
        tipo_de_importe="";
        porcentaje_importe=0;
        cantidad=0;
        sub_total=0;
        importe_exonerado=0;
        importe_exento=0;
        importe_gravado_15=0;
        isv_15=0;
        descuentos_y_rebajas=0;
        total=0;
        total_efectivo=0;
        total_tarjeta=0;
        cambio=0;
        cod_cliente=0;
        n_referencia="";
        variable_de_validacion=false;
    }
    
    /*
    Funcion: correlativo_factura 
    Autores: José Hernández
    Version 1.0   25/03/2020 
    funcion que permite obtener el nuevo correlativo de factura desde la base
    de datos.
    */
    private String correlativo_factura(){
    
            String correlativo_anterior="",numero="",correlativo_nuevo_tipo_cadena="",correlativo_completo="";
            int correlativo_nuevo_tipo_entero=0;
            conexion=clase_conexion.conectar();
            if(clase_conexion.obtener_estado_conexion()==true){
                try{
                    CallableStatement callable_statement_local=conexion.prepareCall("SELECT numero_factura " +
                            " FROM [dbo].[Factura]" +
                            " WHERE [n_factura]=(SELECT MAX([n_factura])FROM [dbo].[Factura])");
                    ResultSet result_set_local=callable_statement_local.executeQuery();
                    if(result_set_local.next()){
                        correlativo_anterior=result_set_local.getString("numero_factura").trim();
                        //extraer los ultimos digitos del correlativo anterior e incrementar el siguiente
                        correlativo_nuevo_tipo_entero=Integer.parseInt(correlativo_anterior.substring(11,19))+1;
                        numero=String.valueOf(correlativo_nuevo_tipo_entero);

                        if(numero.length()<=8){
                            //rellenar los espacios en blanco con (0)
                            for(int posicion_cadena=0;posicion_cadena<(8-numero.length());posicion_cadena++){
                                correlativo_nuevo_tipo_cadena=correlativo_nuevo_tipo_cadena+"0";
                            }
                            correlativo_nuevo_tipo_cadena=correlativo_nuevo_tipo_cadena+numero;
                            correlativo_completo=correlativo_anterior.substring(0,11)+correlativo_nuevo_tipo_cadena;
                        }else{
                            JOptionPane.showMessageDialog(null,"ERROR AL PROCESAR LA VENTA:  El Número de Correlativo ha llegado a su màximo","ERROR EN VENTA",JOptionPane.ERROR_MESSAGE);
                        }

                    }
                    conexion=null;
                    clase_conexion.cerrar_conexion();
                    callable_statement_local.close();
                    result_set_local.close();
                }catch(SQLException ex){
                        JOptionPane.showMessageDialog(null,"ERROR AL PROCESAR LA VENTA:  "+ex,"ERROR EN VENTA",JOptionPane.ERROR_MESSAGE);
                }
            }
        return correlativo_completo;
    }
    
    /*
    Funcion: validar_producto
    Autores: José Hernández
    Version 1.0   20/07/2020 
    funcion que permite validar si un producto ya fue agregado a la venta.
    */
    public boolean validar_producto(String cod_producto){
        for(int contador_filas=0;contador_filas<Tabla_principal.getRowCount();contador_filas++){
            if(String.valueOf(Tabla_principal.getValueAt(contador_filas,0)).trim().equals(cod_producto)){
               return true; 
            } 
        }
        return false;
    }
    
    /*
    Funcion: agregar_fila
    Autores: José Hernández
    Version 1.0   22/07/2020 
    funcion que permite agregar a la venta el producto seleccionado.
    */
    public void agregar_fila(){
        String Datos[]=new String[5];
        Datos[0]=cod_producto_agregar; 
        Datos[1]=nombre_producto_agregar; 
        Datos[2]=String.valueOf(clase_validaciones.redondear_decimales(Double.parseDouble(precio_producto_agregar))); 
        Datos[3]="1"; 
        Datos[4]=Datos[2];
        modelo_tabla.addRow(Datos);
        cod_producto_agregar=null;
        nombre_producto_agregar=null;
        precio_producto_agregar=null;
        calcular_totales();
    }
    
    /*
    Funcion: seleccionar_producto
    Autores: José Hernández
    Version 1.0   22/07/2020 
    funcion que permite cargar el producto seleccionado a la vista detallada.
    */
    private void seleccionar_producto(int fila_seleccionada){
        txt_codigo_producto.setText(Tabla_principal.getValueAt(fila_seleccionada,0).toString().trim());
        txt_nombre_producto.setText(Tabla_principal.getValueAt(fila_seleccionada,1).toString().trim());
        txt_precio_producto.setText(Tabla_principal.getValueAt(fila_seleccionada,2).toString().trim());
        txt_cantidad_producto.setText(Tabla_principal.getValueAt(fila_seleccionada,3).toString().trim());
        txt_subtotal_producto.setText(Tabla_principal.getValueAt(fila_seleccionada,4).toString().trim());
    }

    /*
    Funcion: Calcular_totales
    Autores: Jose Julio
    Version 1.0   01/07/2020 
    funcion para calcular el total de la venta,impuestos y descuentos, tomando 
    los datos de los productos seleccionados.
    */
    public void calcular_totales(){
        sub_total=0;
        importe_exento=0;
        importe_exonerado=0;
        importe_gravado_15=0;
        isv_15=0;
        int codigo_producto,porcentaje_impuesto=0;
        String tipo_importe="";
        conexion=clase_conexion.conectar();
        if(clase_conexion.obtener_estado_conexion()==true){         
            for(int contador_filas=0;contador_filas<Tabla_principal.getRowCount();contador_filas++){
                codigo_producto=Integer.parseInt(Tabla_principal.getValueAt(contador_filas,0).toString().trim());
                try{
                    prepared_statement=conexion.prepareStatement("SELECT ti.[nombre] as 'importe',ti.porcentaje as 'porcentaje' FROM [dbo].[Productos_Venta] AS pv " +
                        " JOIN [dbo].[Tipos_de_Importe] AS ti ON pv.cod_tipo_importe=ti.cod_tipo_importe WHERE pv.cod_producto_vt=?");
                    prepared_statement.setInt(1,codigo_producto);
                    result_set=prepared_statement.executeQuery();
                    if(result_set.next()){
                        tipo_importe=result_set.getString("importe");
                        porcentaje_impuesto=result_set.getInt("porcentaje");
                    }
                    if (tipo_importe.toLowerCase().contains("exento")) {
                    importe_exento+=Double.parseDouble(Tabla_principal.getValueAt(contador_filas,4).toString().trim());
                    }
                    if (tipo_importe.toLowerCase().contains("exonerado")) {
                        importe_exonerado+=Double.parseDouble(Tabla_principal.getValueAt(contador_filas,4).toString().trim());
                    }
                    if (tipo_importe.toLowerCase().contains("gravado")) {
                        importe_gravado_15+=Double.parseDouble(Tabla_principal.getValueAt(contador_filas,4).toString().trim());
                        isv_15+=(importe_gravado_15*(porcentaje_impuesto/100));               
                    }
                    sub_total+=Double.parseDouble(Tabla_principal.getValueAt(contador_filas,4).toString().trim());
                }catch(SQLException ex){}
            } 
            conexion=null;
            clase_conexion.cerrar_conexion();
            sub_total=clase_validaciones.redondear_decimales(sub_total);
            importe_exento=clase_validaciones.redondear_decimales(importe_exento);
            importe_exonerado=clase_validaciones.redondear_decimales(importe_exonerado);
            importe_gravado_15=clase_validaciones.redondear_decimales(importe_gravado_15);

            if(txt_descuentos_rebajas.getText().trim().length()>0){
                try{
                    descuentos_y_rebajas=Double.parseDouble(txt_descuentos_rebajas.getText().trim());
                    clase_validaciones.redondear_decimales(descuentos_y_rebajas);
                }catch(NumberFormatException e){
                    JOptionPane.showMessageDialog(null,"Ingrese un descuento válido","AVISO",JOptionPane.WARNING_MESSAGE);
                }
            }else{
               descuentos_y_rebajas=0;
               txt_descuentos_rebajas.setText("0");
            }

            isv_15=importe_gravado_15*0.15;
            total=(sub_total+isv_15)-descuentos_y_rebajas;
            isv_15=clase_validaciones.redondear_decimales(isv_15);
            total=clase_validaciones.redondear_decimales(total);

            //validacion del total de descuento
            if(descuentos_y_rebajas>0 && descuentos_y_rebajas>=(total*0.8)){
                descuentos_y_rebajas=0;
                txt_descuentos_rebajas.setText("0");
                total=(sub_total+isv_15)-descuentos_y_rebajas;
                total=clase_validaciones.redondear_decimales(total);
                JOptionPane.showMessageDialog(null,"El descuento supera la cantidad máxima","ERROR",JOptionPane.WARNING_MESSAGE);
            }
            
            descuentos_y_rebajas=clase_validaciones.redondear_decimales(descuentos_y_rebajas);
            lbl_subtotal.setText(String.valueOf(sub_total));
            lbl_exonerado.setText(String.valueOf(importe_exonerado));
            lbl_exento.setText(String.valueOf(importe_exento));
            lbl_gravado.setText(String.valueOf(importe_gravado_15));
            lbl_isv.setText(String.valueOf(isv_15));
            lbl_total.setText(String.valueOf(total));
        }
    }
    
    /*
    OPTIMIZACIÓN DE CÓDIGO
    Funcion: teclado_en_pantalla
    Autores: Julio
    Version 1.0   03/07/2020 
    permite agregar digitos del teclado en pantalla hacia la caja de texto
    seleccionada.
    */
    private void teclado_en_pantalla(String numero){

        if("efectivo".equals(caja_actual) && txt_efectivo.getText().length()<6){
            txt_efectivo.setText(txt_efectivo.getText().trim()+numero);
        }
        if("tarjeta".equals(caja_actual) && txt_tarjeta.getText().length()<6){
            txt_tarjeta.setText(txt_tarjeta.getText().trim()+numero);
        }
        if("descuento".equals(caja_actual) && txt_descuentos_rebajas.getText().length()<6){
            txt_descuentos_rebajas.setText(txt_descuentos_rebajas.getText().trim()+numero);
        }
        if("id".equals(caja_actual) && txt_id.getText().length()<14){
            txt_id.setText(txt_id.getText().trim()+numero);
        }
        if("treferencia".equals(caja_actual) && txt_ref.getText().length()<15){
            txt_ref.setText(txt_ref.getText().trim()+numero);
        }
    }
    /*
    OPTIMIZACIÓN DE CÓDIGO
    Funcion: validar_venta
    Autores: Jose
    Version 1.0   04/07/2020 
    permite verificar los parametros de la venta y almacena en variables el resultado
    de la validación.
    */
    private void validar_venta(){
    calcular_totales();
        
        if(txt_efectivo.getText().trim().length()>0 || txt_tarjeta.getText().trim().length()>0){
            if(cmb_medio_de_pago.getSelectedItem().equals("Efectivo")){
                if(txt_efectivo.getText().trim().length()>0){
                    try{
                        total_efectivo=Double.parseDouble(txt_efectivo.getText().trim());
                        variable_de_validacion=true;
                    }catch(NumberFormatException e){
                        variable_de_validacion=false;
                        JOptionPane.showMessageDialog(null,"Ingrese una cantidad de efectivo válida","AVISO",JOptionPane.WARNING_MESSAGE);
                    }
                }else{
                    JOptionPane.showMessageDialog(null,"ERROR, Debe llenar la cantidad de dinero en efectivo.","ERROR",JOptionPane.ERROR_MESSAGE);
                }
                if(total_efectivo>=total){
                    cambio=total_efectivo-total;
                    total_efectivo=total_efectivo-cambio;
                    variable_de_validacion=true;
                }else{
                    variable_de_validacion=false;
                }
            }
            if(cmb_medio_de_pago.getSelectedItem().equals("Tarjeta")){
                if(txt_tarjeta.getText().trim().length()>0 && txt_ref.getText().trim().length()>0){
                    try{
                        total_tarjeta=Double.parseDouble(txt_tarjeta.getText().trim());
                        n_referencia=txt_ref.getText().trim();
                        variable_de_validacion=true;
                    }catch(NumberFormatException e){
                        variable_de_validacion=false;
                        JOptionPane.showMessageDialog(null,"Ingrese una cantidad de pago con tarjeta válida.","AVISO",JOptionPane.WARNING_MESSAGE);
                    }
                }else{
                    JOptionPane.showMessageDialog(null,"ERROR, Debe llenar la cantidad de pago con tarjeta y número de referencia.","ERROR",JOptionPane.ERROR_MESSAGE);
                }
                if(total_tarjeta==total){
                    cambio=0;
                    variable_de_validacion=true;
                }else{
                    variable_de_validacion=false;
                }
            }
            if(cmb_medio_de_pago.getSelectedItem().equals("Efectivo y Tarjeta")){

                if(txt_efectivo.getText().trim().length()>0 && txt_tarjeta.getText().trim().length()>0 && txt_ref.getText().trim().length()>0){
                    try{
                        total_efectivo=Double.parseDouble(txt_efectivo.getText().trim());
                        total_tarjeta=Double.parseDouble(txt_tarjeta.getText().trim());
                        n_referencia=txt_ref.getText().trim();
                        variable_de_validacion=true;
                    }catch(NumberFormatException e){
                        variable_de_validacion=false;
                        JOptionPane.showMessageDialog(null,"Ingrese una cantidad de dinero en efectivo,pago con tarjeta y número de referencia.","AVISO",JOptionPane.WARNING_MESSAGE);
                    }
                }else{
                    variable_de_validacion=false;
                    JOptionPane.showMessageDialog(null,"ERROR, Debe llenar los campos requeridos de pago.","ERROR",JOptionPane.ERROR_MESSAGE);
                }
                if((total_efectivo+total_tarjeta)>=total){
                    cambio=(total_efectivo+total_tarjeta)-total;
                    total_efectivo=total_efectivo-cambio;
                    variable_de_validacion=true;
                }else{
                    variable_de_validacion=false;
                }
            }
            if(variable_de_validacion==false){
                cambio=0;
                txt_cambio.setText(String.valueOf(clase_validaciones.redondear_decimales(cambio)));
                JOptionPane.showMessageDialog(null,"La Suma de pago en efectivo o tarjeta debe ser mayor o igual al total de la venta.","AVISO",JOptionPane.WARNING_MESSAGE);
            }else{
                txt_cambio.setText(String.valueOf(clase_validaciones.redondear_decimales(cambio)));
            }
        }else{
            JOptionPane.showMessageDialog(null,"ERROR, Debe llenar los campos requeridos de pago.","ERROR",JOptionPane.ERROR_MESSAGE);
        }
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel_fondo = new javax.swing.JPanel();
        Panel_barra_superior = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        lbl_fecha = new javax.swing.JLabel();
        btn_cerrar = new javax.swing.JButton();
        jLabel35 = new javax.swing.JLabel();
        lbl_usuario_actual = new javax.swing.JLabel();
        Panel_añadir_producto = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        btn_agregar = new javax.swing.JButton();
        Panel_datos_cliente = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_id = new javax.swing.JTextField();
        btn_buscar_cliente = new javax.swing.JButton();
        txt_nombres = new javax.swing.JTextField();
        txt_apellidos = new javax.swing.JTextField();
        txt_celular = new javax.swing.JTextField();
        txt_correo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        Panel_calculadora = new javax.swing.JPanel();
        Panel_teclado = new javax.swing.JPanel();
        btn_enter = new javax.swing.JButton();
        btn_0 = new javax.swing.JButton();
        btn_punto = new javax.swing.JButton();
        btn_1 = new javax.swing.JButton();
        btn_2 = new javax.swing.JButton();
        btn_3 = new javax.swing.JButton();
        btn_4 = new javax.swing.JButton();
        btn_5 = new javax.swing.JButton();
        btn_6 = new javax.swing.JButton();
        btn_7 = new javax.swing.JButton();
        btn_8 = new javax.swing.JButton();
        btn_9 = new javax.swing.JButton();
        Panel_ingreso_producto = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        Panel_producto_1 = new javax.swing.JPanel();
        lbl_nombre_producto_1 = new javax.swing.JLabel();
        lbl_descripcion_producto_1 = new javax.swing.JLabel();
        txt_cantidad_producto = new javax.swing.JTextField();
        btn_agregar_producto = new javax.swing.JButton();
        btn_eliminar_producto = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txt_codigo_producto = new javax.swing.JTextField();
        txt_nombre_producto = new javax.swing.JTextField();
        lbl_nombre_producto_2 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        lbl_descripcion_producto_2 = new javax.swing.JLabel();
        txt_precio_producto = new javax.swing.JTextField();
        lbl_descripcion_producto_3 = new javax.swing.JLabel();
        txt_subtotal_producto = new javax.swing.JTextField();
        btn_Eliminar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        Tabla_principal = new javax.swing.JTable();
        Panel_total = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        lbl_subtotal = new javax.swing.JLabel();
        lbl_exonerado = new javax.swing.JLabel();
        lbl_exento = new javax.swing.JLabel();
        lbl_gravado = new javax.swing.JLabel();
        lbl_isv = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        lbl_total = new javax.swing.JLabel();
        txt_descuentos_rebajas = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        Panel_pagar = new javax.swing.JPanel();
        cmb_medio_de_pago = new javax.swing.JComboBox<>();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        txt_cambio = new javax.swing.JTextField();
        txt_tarjeta = new javax.swing.JTextField();
        txt_efectivo = new javax.swing.JTextField();
        btn_pagar = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        btn_precuenta = new javax.swing.JButton();
        txt_ref = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel30 = new javax.swing.JLabel();
        Panel_numero_factura = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        Panel_numero_factura_2 = new javax.swing.JPanel();
        lbl_numero_factura = new javax.swing.JLabel();
        Panel_añadir_producto1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        btn_cierre_de_caja = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Punto de Venta ● Grupo Industrial Bonilla");
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        Panel_fondo.setBackground(new java.awt.Color(255, 255, 255));

        Panel_barra_superior.setBackground(new java.awt.Color(0, 0, 0));

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/img_gibon_grande.png"))); // NOI18N

        lbl_fecha.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 24)); // NOI18N
        lbl_fecha.setForeground(new java.awt.Color(255, 255, 255));
        lbl_fecha.setText("DD/MM/YYYY");

        btn_cerrar.setBackground(new java.awt.Color(195, 50, 50));
        btn_cerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btn_cerrar.png"))); // NOI18N
        btn_cerrar.setToolTipText("Cerrar punto de venta");
        btn_cerrar.setBorderPainted(false);
        btn_cerrar.setFocusPainted(false);
        btn_cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cerrarActionPerformed(evt);
            }
        });

        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/administracion_usuarios.png"))); // NOI18N

        lbl_usuario_actual.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        lbl_usuario_actual.setForeground(new java.awt.Color(255, 255, 255));
        lbl_usuario_actual.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout Panel_barra_superiorLayout = new javax.swing.GroupLayout(Panel_barra_superior);
        Panel_barra_superior.setLayout(Panel_barra_superiorLayout);
        Panel_barra_superiorLayout.setHorizontalGroup(
            Panel_barra_superiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_barra_superiorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_usuario_actual, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(349, 349, 349)
                .addComponent(lbl_fecha)
                .addGap(53, 53, 53)
                .addComponent(btn_cerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        Panel_barra_superiorLayout.setVerticalGroup(
            Panel_barra_superiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_barra_superiorLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel9))
            .addGroup(Panel_barra_superiorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel_barra_superiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_usuario_actual, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_fecha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(Panel_barra_superiorLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(btn_cerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Buscar producto");
        jLabel6.setOpaque(true);

        btn_agregar.setBackground(new java.awt.Color(39, 174, 96));
        btn_agregar.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 12)); // NOI18N
        btn_agregar.setForeground(new java.awt.Color(255, 255, 255));
        btn_agregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btn_añadir_a_la_venta.png"))); // NOI18N
        btn_agregar.setText("Agregar producto");
        btn_agregar.setToolTipText("Buscar y añadir productos a la venta");
        btn_agregar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        btn_agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agregarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Panel_añadir_productoLayout = new javax.swing.GroupLayout(Panel_añadir_producto);
        Panel_añadir_producto.setLayout(Panel_añadir_productoLayout);
        Panel_añadir_productoLayout.setHorizontalGroup(
            Panel_añadir_productoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_añadir_productoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        Panel_añadir_productoLayout.setVerticalGroup(
            Panel_añadir_productoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_añadir_productoLayout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btn_agregar, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );

        Panel_datos_cliente.setBackground(new java.awt.Color(10, 76, 122));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Búsqueda de cliente");
        jLabel1.setOpaque(true);

        txt_id.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Identidad/RTN:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(10, 76, 122))); // NOI18N
        txt_id.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_idMouseEntered(evt);
            }
        });
        txt_id.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                txt_idInputMethodTextChanged(evt);
            }
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
        });
        txt_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_idActionPerformed(evt);
            }
        });
        txt_id.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_idKeyTyped(evt);
            }
        });

        btn_buscar_cliente.setBackground(new java.awt.Color(0, 204, 255));
        btn_buscar_cliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buscar_cliente.png"))); // NOI18N
        btn_buscar_cliente.setToolTipText("Buscar clliente");
        btn_buscar_cliente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        btn_buscar_cliente.setBorderPainted(false);
        btn_buscar_cliente.setFocusPainted(false);
        btn_buscar_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscar_clienteActionPerformed(evt);
            }
        });

        txt_nombres.setEditable(false);
        txt_nombres.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txt_nombres.setForeground(new java.awt.Color(102, 102, 102));
        txt_nombres.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nombre:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(102, 102, 102))); // NOI18N

        txt_apellidos.setEditable(false);
        txt_apellidos.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txt_apellidos.setForeground(new java.awt.Color(102, 102, 102));
        txt_apellidos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Apellidos:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(102, 102, 102))); // NOI18N

        txt_celular.setEditable(false);
        txt_celular.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txt_celular.setForeground(new java.awt.Color(102, 102, 102));
        txt_celular.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Número de contacto:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(102, 102, 102))); // NOI18N

        txt_correo.setEditable(false);
        txt_correo.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txt_correo.setForeground(new java.awt.Color(102, 102, 102));
        txt_correo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Correo:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(102, 102, 102))); // NOI18N

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Cliente encontrado:");

        javax.swing.GroupLayout Panel_datos_clienteLayout = new javax.swing.GroupLayout(Panel_datos_cliente);
        Panel_datos_cliente.setLayout(Panel_datos_clienteLayout);
        Panel_datos_clienteLayout.setHorizontalGroup(
            Panel_datos_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_datos_clienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel_datos_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel_datos_clienteLayout.createSequentialGroup()
                        .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_buscar_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txt_celular, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_apellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_nombres, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_correo, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        Panel_datos_clienteLayout.setVerticalGroup(
            Panel_datos_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_datos_clienteLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(Panel_datos_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_id)
                    .addComponent(btn_buscar_cliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(34, 34, 34)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(txt_nombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_apellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_celular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_correo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(264, Short.MAX_VALUE))
        );

        Panel_calculadora.setBackground(new java.awt.Color(245, 245, 245));

        Panel_teclado.setBackground(new java.awt.Color(255, 255, 255));

        btn_enter.setBackground(new java.awt.Color(222, 235, 247));
        btn_enter.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 11)); // NOI18N
        btn_enter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/boton_borrar.png"))); // NOI18N
        btn_enter.setToolTipText("Borrar");
        btn_enter.setBorder(null);
        btn_enter.setBorderPainted(false);
        btn_enter.setContentAreaFilled(false);
        btn_enter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_enterActionPerformed(evt);
            }
        });

        btn_0.setBackground(new java.awt.Color(222, 235, 247));
        btn_0.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 11)); // NOI18N
        btn_0.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/boton_tactil_0.png"))); // NOI18N
        btn_0.setToolTipText("Seleccionar número 0");
        btn_0.setBorder(null);
        btn_0.setBorderPainted(false);
        btn_0.setContentAreaFilled(false);
        btn_0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_0ActionPerformed(evt);
            }
        });

        btn_punto.setBackground(new java.awt.Color(222, 235, 247));
        btn_punto.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 11)); // NOI18N
        btn_punto.setForeground(new java.awt.Color(255, 255, 255));
        btn_punto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/boton_tactil_punto.png"))); // NOI18N
        btn_punto.setToolTipText("Seleccionar punto decimal");
        btn_punto.setBorder(null);
        btn_punto.setBorderPainted(false);
        btn_punto.setContentAreaFilled(false);
        btn_punto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_puntoActionPerformed(evt);
            }
        });

        btn_1.setBackground(new java.awt.Color(222, 235, 247));
        btn_1.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 11)); // NOI18N
        btn_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/boton_tactil_1.png"))); // NOI18N
        btn_1.setToolTipText("Seleccionar número 1");
        btn_1.setBorder(null);
        btn_1.setBorderPainted(false);
        btn_1.setContentAreaFilled(false);
        btn_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_1ActionPerformed(evt);
            }
        });

        btn_2.setBackground(new java.awt.Color(222, 235, 247));
        btn_2.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 11)); // NOI18N
        btn_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/boton_tactil_2.png"))); // NOI18N
        btn_2.setToolTipText("Seleccionar número 2");
        btn_2.setBorder(null);
        btn_2.setBorderPainted(false);
        btn_2.setContentAreaFilled(false);
        btn_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_2ActionPerformed(evt);
            }
        });

        btn_3.setBackground(new java.awt.Color(222, 235, 247));
        btn_3.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 11)); // NOI18N
        btn_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/boton_tactil_3.png"))); // NOI18N
        btn_3.setToolTipText("Seleccionar número 3");
        btn_3.setBorder(null);
        btn_3.setBorderPainted(false);
        btn_3.setContentAreaFilled(false);
        btn_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_3ActionPerformed(evt);
            }
        });

        btn_4.setBackground(new java.awt.Color(222, 235, 247));
        btn_4.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 11)); // NOI18N
        btn_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/boton_tactil_4.png"))); // NOI18N
        btn_4.setToolTipText("Seleccionar número 4");
        btn_4.setBorder(null);
        btn_4.setBorderPainted(false);
        btn_4.setContentAreaFilled(false);
        btn_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_4ActionPerformed(evt);
            }
        });

        btn_5.setBackground(new java.awt.Color(222, 235, 247));
        btn_5.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 11)); // NOI18N
        btn_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/boton_tactil_5.png"))); // NOI18N
        btn_5.setToolTipText("Seleccionar número 5");
        btn_5.setBorder(null);
        btn_5.setBorderPainted(false);
        btn_5.setContentAreaFilled(false);
        btn_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_5ActionPerformed(evt);
            }
        });

        btn_6.setBackground(new java.awt.Color(222, 235, 247));
        btn_6.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 11)); // NOI18N
        btn_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/boton_tactil_6.png"))); // NOI18N
        btn_6.setToolTipText("Seleccionar número 6");
        btn_6.setBorder(null);
        btn_6.setBorderPainted(false);
        btn_6.setContentAreaFilled(false);
        btn_6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_6ActionPerformed(evt);
            }
        });

        btn_7.setBackground(new java.awt.Color(222, 235, 247));
        btn_7.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 11)); // NOI18N
        btn_7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/boton_tactil_7.png"))); // NOI18N
        btn_7.setToolTipText("Seleccionar número 7");
        btn_7.setBorder(null);
        btn_7.setBorderPainted(false);
        btn_7.setContentAreaFilled(false);
        btn_7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_7ActionPerformed(evt);
            }
        });

        btn_8.setBackground(new java.awt.Color(222, 235, 247));
        btn_8.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 11)); // NOI18N
        btn_8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/boton_tactil_8.png"))); // NOI18N
        btn_8.setToolTipText("Seleccionar número 8");
        btn_8.setBorder(null);
        btn_8.setBorderPainted(false);
        btn_8.setContentAreaFilled(false);
        btn_8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_8ActionPerformed(evt);
            }
        });

        btn_9.setBackground(new java.awt.Color(222, 235, 247));
        btn_9.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 11)); // NOI18N
        btn_9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/boton_tactil_9.png"))); // NOI18N
        btn_9.setToolTipText("Seleccionar número 9");
        btn_9.setBorder(null);
        btn_9.setBorderPainted(false);
        btn_9.setContentAreaFilled(false);
        btn_9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Panel_tecladoLayout = new javax.swing.GroupLayout(Panel_teclado);
        Panel_teclado.setLayout(Panel_tecladoLayout);
        Panel_tecladoLayout.setHorizontalGroup(
            Panel_tecladoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_tecladoLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(Panel_tecladoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btn_4, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_enter, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_7, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(Panel_tecladoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel_tecladoLayout.createSequentialGroup()
                        .addComponent(btn_0, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_punto, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(Panel_tecladoLayout.createSequentialGroup()
                        .addGroup(Panel_tecladoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btn_5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(Panel_tecladoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(Panel_tecladoLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(btn_3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(Panel_tecladoLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(btn_6, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(Panel_tecladoLayout.createSequentialGroup()
                        .addComponent(btn_8, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_9, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(17, 17, 17))
        );
        Panel_tecladoLayout.setVerticalGroup(
            Panel_tecladoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_tecladoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel_tecladoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_7, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_8, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_9, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(Panel_tecladoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_4, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_5, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_6, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(Panel_tecladoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(Panel_tecladoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_enter, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_0, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_punto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout Panel_calculadoraLayout = new javax.swing.GroupLayout(Panel_calculadora);
        Panel_calculadora.setLayout(Panel_calculadoraLayout);
        Panel_calculadoraLayout.setHorizontalGroup(
            Panel_calculadoraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_calculadoraLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Panel_teclado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        Panel_calculadoraLayout.setVerticalGroup(
            Panel_calculadoraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_calculadoraLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Panel_teclado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        Panel_ingreso_producto.setBackground(new java.awt.Color(245, 245, 245));
        Panel_ingreso_producto.setPreferredSize(new java.awt.Dimension(704, 530));

        jLabel8.setBackground(new java.awt.Color(0, 0, 0));
        jLabel8.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 15)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Productos seleccionados");
        jLabel8.setOpaque(true);

        Panel_producto_1.setBackground(new java.awt.Color(10, 76, 122));

        lbl_nombre_producto_1.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 11)); // NOI18N
        lbl_nombre_producto_1.setForeground(new java.awt.Color(255, 255, 255));
        lbl_nombre_producto_1.setText("Código:");

        lbl_descripcion_producto_1.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 11)); // NOI18N
        lbl_descripcion_producto_1.setForeground(new java.awt.Color(255, 255, 255));
        lbl_descripcion_producto_1.setText("Producto:");

        txt_cantidad_producto.setEditable(false);
        txt_cantidad_producto.setBackground(new java.awt.Color(255, 255, 255));
        txt_cantidad_producto.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 1, 24)); // NOI18N
        txt_cantidad_producto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_cantidad_producto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        btn_agregar_producto.setBackground(new java.awt.Color(0, 153, 0));
        btn_agregar_producto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/mas.png"))); // NOI18N
        btn_agregar_producto.setToolTipText("Añadir más");
        btn_agregar_producto.setBorder(null);
        btn_agregar_producto.setBorderPainted(false);
        btn_agregar_producto.setFocusPainted(false);
        btn_agregar_producto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_agregar_producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agregar_productoActionPerformed(evt);
            }
        });

        btn_eliminar_producto.setBackground(new java.awt.Color(195, 50, 50));
        btn_eliminar_producto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/menos.png"))); // NOI18N
        btn_eliminar_producto.setToolTipText("Quitar");
        btn_eliminar_producto.setBorder(null);
        btn_eliminar_producto.setBorderPainted(false);
        btn_eliminar_producto.setFocusPainted(false);
        btn_eliminar_producto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_eliminar_producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminar_productoActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 11)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Cantidad:");

        txt_codigo_producto.setEditable(false);
        txt_codigo_producto.setBackground(new java.awt.Color(255, 255, 255));
        txt_codigo_producto.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 12)); // NOI18N

        txt_nombre_producto.setEditable(false);
        txt_nombre_producto.setBackground(new java.awt.Color(255, 255, 255));
        txt_nombre_producto.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 12)); // NOI18N

        lbl_nombre_producto_2.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 16)); // NOI18N
        lbl_nombre_producto_2.setForeground(new java.awt.Color(255, 255, 255));
        lbl_nombre_producto_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_nombre_producto_2.setText("Detalle del producto");

        jSeparator4.setForeground(new java.awt.Color(10, 76, 122));

        lbl_descripcion_producto_2.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 11)); // NOI18N
        lbl_descripcion_producto_2.setForeground(new java.awt.Color(255, 255, 255));
        lbl_descripcion_producto_2.setText("Precio unitario:");

        txt_precio_producto.setEditable(false);
        txt_precio_producto.setBackground(new java.awt.Color(255, 255, 255));
        txt_precio_producto.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 12)); // NOI18N

        lbl_descripcion_producto_3.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 11)); // NOI18N
        lbl_descripcion_producto_3.setForeground(new java.awt.Color(255, 255, 255));
        lbl_descripcion_producto_3.setText("Subtotal:");

        txt_subtotal_producto.setEditable(false);
        txt_subtotal_producto.setBackground(new java.awt.Color(255, 255, 255));
        txt_subtotal_producto.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 12)); // NOI18N

        javax.swing.GroupLayout Panel_producto_1Layout = new javax.swing.GroupLayout(Panel_producto_1);
        Panel_producto_1.setLayout(Panel_producto_1Layout);
        Panel_producto_1Layout.setHorizontalGroup(
            Panel_producto_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_producto_1Layout.createSequentialGroup()
                .addGroup(Panel_producto_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel_producto_1Layout.createSequentialGroup()
                        .addGap(206, 206, 206)
                        .addComponent(lbl_nombre_producto_2))
                    .addGroup(Panel_producto_1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(Panel_producto_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 582, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(Panel_producto_1Layout.createSequentialGroup()
                                .addGroup(Panel_producto_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(Panel_producto_1Layout.createSequentialGroup()
                                        .addGroup(Panel_producto_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(lbl_nombre_producto_1)
                                            .addComponent(jLabel10))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_codigo_producto, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(Panel_producto_1Layout.createSequentialGroup()
                                        .addComponent(txt_cantidad_producto, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(34, 34, 34)
                                        .addComponent(btn_agregar_producto, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btn_eliminar_producto, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(34, 34, 34)
                                .addGroup(Panel_producto_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(Panel_producto_1Layout.createSequentialGroup()
                                        .addComponent(lbl_descripcion_producto_3, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txt_subtotal_producto, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(Panel_producto_1Layout.createSequentialGroup()
                                        .addGroup(Panel_producto_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbl_descripcion_producto_1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbl_descripcion_producto_2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(Panel_producto_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txt_precio_producto, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txt_nombre_producto, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))))))))
                .addContainerGap())
        );
        Panel_producto_1Layout.setVerticalGroup(
            Panel_producto_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_producto_1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(lbl_nombre_producto_2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Panel_producto_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel_producto_1Layout.createSequentialGroup()
                        .addGroup(Panel_producto_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_nombre_producto_1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_codigo_producto, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(Panel_producto_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_cantidad_producto, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_agregar_producto, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_eliminar_producto, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(Panel_producto_1Layout.createSequentialGroup()
                        .addGroup(Panel_producto_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_descripcion_producto_1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_nombre_producto, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(Panel_producto_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_descripcion_producto_2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_precio_producto, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(Panel_producto_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_subtotal_producto, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_descripcion_producto_3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(20, 20, 20))
        );

        btn_Eliminar.setBackground(new java.awt.Color(195, 50, 50));
        btn_Eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btn_eliminar.png"))); // NOI18N
        btn_Eliminar.setToolTipText("Cancelar venta");
        btn_Eliminar.setBorderPainted(false);
        btn_Eliminar.setContentAreaFilled(false);
        btn_Eliminar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_Eliminar.setOpaque(true);
        btn_Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_EliminarActionPerformed(evt);
            }
        });

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane2.setToolTipText("");
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        Tabla_principal = new javax.swing.JTable(){
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        Tabla_principal.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        Tabla_principal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
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
        Tabla_principal.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                Tabla_principalComponentAdded(evt);
            }
        });
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

        javax.swing.GroupLayout Panel_ingreso_productoLayout = new javax.swing.GroupLayout(Panel_ingreso_producto);
        Panel_ingreso_producto.setLayout(Panel_ingreso_productoLayout);
        Panel_ingreso_productoLayout.setHorizontalGroup(
            Panel_ingreso_productoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_ingreso_productoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel_ingreso_productoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_ingreso_productoLayout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 558, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_Eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Panel_producto_1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 602, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        Panel_ingreso_productoLayout.setVerticalGroup(
            Panel_ingreso_productoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_ingreso_productoLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(Panel_ingreso_productoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(btn_Eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Panel_producto_1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        Panel_total.setBackground(new java.awt.Color(255, 255, 255));

        jLabel13.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 1, 11)); // NOI18N
        jLabel13.setText("Subtotal");

        jLabel14.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 1, 11)); // NOI18N
        jLabel14.setText("Importe Exonerado");

        jLabel15.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 1, 11)); // NOI18N
        jLabel15.setText("Importe Exento");

        jLabel16.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 1, 11)); // NOI18N
        jLabel16.setText("Importe Gravado 15%");

        jLabel17.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 1, 11)); // NOI18N
        jLabel17.setText("ISV 15%");

        jLabel18.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 1, 11)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(204, 0, 0));
        jLabel18.setText("Descuentos y Rebajas");

        jLabel19.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 36)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(10, 76, 122));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("TOTAL");

        jLabel20.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 14)); // NOI18N
        jLabel20.setText("L.");

        jLabel21.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 14)); // NOI18N
        jLabel21.setText("L.");

        jLabel22.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 14)); // NOI18N
        jLabel22.setText("L.");

        jLabel23.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 14)); // NOI18N
        jLabel23.setText("L.");

        jLabel24.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 14)); // NOI18N
        jLabel24.setText("L.");

        jLabel25.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(204, 0, 0));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel25.setText("-  L.");

        lbl_subtotal.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 14)); // NOI18N
        lbl_subtotal.setText("0");
        lbl_subtotal.setPreferredSize(new java.awt.Dimension(0, 16));

        lbl_exonerado.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 14)); // NOI18N
        lbl_exonerado.setText("0");
        lbl_exonerado.setPreferredSize(new java.awt.Dimension(0, 16));

        lbl_exento.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 14)); // NOI18N
        lbl_exento.setText("0");
        lbl_exento.setPreferredSize(new java.awt.Dimension(0, 16));

        lbl_gravado.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 14)); // NOI18N
        lbl_gravado.setText("0");
        lbl_gravado.setPreferredSize(new java.awt.Dimension(0, 16));

        lbl_isv.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 14)); // NOI18N
        lbl_isv.setText("0");
        lbl_isv.setPreferredSize(new java.awt.Dimension(0, 16));

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(10, 76, 122));
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel32.setText("L.");

        lbl_total.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 36)); // NOI18N
        lbl_total.setForeground(new java.awt.Color(10, 76, 122));
        lbl_total.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_total.setText("0");

        txt_descuentos_rebajas.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 14)); // NOI18N
        txt_descuentos_rebajas.setForeground(new java.awt.Color(204, 0, 0));
        txt_descuentos_rebajas.setText("0");
        txt_descuentos_rebajas.setToolTipText("Descuento total de la venta");
        txt_descuentos_rebajas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_descuentos_rebajasMouseEntered(evt);
            }
        });
        txt_descuentos_rebajas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_descuentos_rebajasActionPerformed(evt);
            }
        });
        txt_descuentos_rebajas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_descuentos_rebajasKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_descuentos_rebajasKeyTyped(evt);
            }
        });

        jSeparator5.setForeground(new java.awt.Color(102, 102, 102));
        jSeparator5.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout Panel_totalLayout = new javax.swing.GroupLayout(Panel_total);
        Panel_total.setLayout(Panel_totalLayout);
        Panel_totalLayout.setHorizontalGroup(
            Panel_totalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_totalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel_totalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(Panel_totalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel22)
                        .addGroup(Panel_totalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(Panel_totalLayout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(106, 106, 106)
                                .addComponent(jLabel20))
                            .addGroup(Panel_totalLayout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel21)))
                        .addComponent(jLabel23)
                        .addComponent(jLabel24))
                    .addComponent(jLabel14)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17)
                    .addGroup(Panel_totalLayout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Panel_totalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel_totalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(lbl_isv, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbl_gravado, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbl_exento, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_descuentos_rebajas, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbl_subtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_exonerado, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addGroup(Panel_totalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel_totalLayout.createSequentialGroup()
                        .addComponent(jLabel32)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_total, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        Panel_totalLayout.setVerticalGroup(
            Panel_totalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_totalLayout.createSequentialGroup()
                .addGroup(Panel_totalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel_totalLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(Panel_totalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_total, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_totalLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(Panel_totalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(Panel_totalLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(Panel_totalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_subtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(Panel_totalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel13)
                                        .addComponent(jLabel20)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(Panel_totalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_exonerado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(Panel_totalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel14)
                                        .addComponent(jLabel22)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(Panel_totalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel21)
                                    .addComponent(lbl_exento, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(6, 6, 6)
                                .addGroup(Panel_totalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_gravado, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(Panel_totalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel16)
                                        .addComponent(jLabel23)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(Panel_totalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(Panel_totalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel17)
                                        .addComponent(jLabel24))
                                    .addComponent(lbl_isv, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(4, 4, 4)
                                .addGroup(Panel_totalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel18)
                                    .addComponent(jLabel25)
                                    .addComponent(txt_descuentos_rebajas, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jSeparator5))))
                .addContainerGap())
        );

        Panel_pagar.setBackground(new java.awt.Color(250, 250, 250));

        cmb_medio_de_pago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Efectivo", "Tarjeta", "Efectivo y Tarjeta" }));
        cmb_medio_de_pago.setToolTipText("Seleccinar medio de pago");
        cmb_medio_de_pago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_medio_de_pagoActionPerformed(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("Medio de Pago ");

        jLabel29.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(10, 76, 122));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("Cambio en efectivo:");

        txt_cambio.setEditable(false);
        txt_cambio.setBackground(new java.awt.Color(222, 235, 247));
        txt_cambio.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_cambio.setForeground(new java.awt.Color(10, 76, 122));
        txt_cambio.setToolTipText("cantidad de cambio a devolver al cliente");

        txt_tarjeta.setToolTipText("Cantidad en tarjeta");
        txt_tarjeta.setBorder(javax.swing.BorderFactory.createTitledBorder("Tarjeta :"));
        txt_tarjeta.setEnabled(false);
        txt_tarjeta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_tarjetaMouseEntered(evt);
            }
        });
        txt_tarjeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tarjetaActionPerformed(evt);
            }
        });
        txt_tarjeta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_tarjetaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_tarjetaKeyTyped(evt);
            }
        });

        txt_efectivo.setToolTipText("Cantidad en efectivo");
        txt_efectivo.setBorder(javax.swing.BorderFactory.createTitledBorder("Efectivo :"));
        txt_efectivo.setEnabled(false);
        txt_efectivo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_efectivoMouseEntered(evt);
            }
        });
        txt_efectivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_efectivoActionPerformed(evt);
            }
        });
        txt_efectivo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_efectivoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_efectivoKeyTyped(evt);
            }
        });

        btn_pagar.setBackground(new java.awt.Color(0, 153, 0));
        btn_pagar.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 1, 18)); // NOI18N
        btn_pagar.setForeground(new java.awt.Color(255, 255, 255));
        btn_pagar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Pagar.png"))); // NOI18N
        btn_pagar.setText("Pagar");
        btn_pagar.setToolTipText("Realizar venta");
        btn_pagar.setBorderPainted(false);
        btn_pagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pagarActionPerformed(evt);
            }
        });

        btn_precuenta.setBackground(new java.awt.Color(0, 204, 255));
        btn_precuenta.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 14)); // NOI18N
        btn_precuenta.setForeground(new java.awt.Color(255, 255, 255));
        btn_precuenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/previsualizar.png"))); // NOI18N
        btn_precuenta.setText("previsualizar");
        btn_precuenta.setToolTipText("visualizar precuenta");
        btn_precuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_precuentaActionPerformed(evt);
            }
        });

        txt_ref.setToolTipText("referencia de pago electrónico");
        txt_ref.setBorder(javax.swing.BorderFactory.createTitledBorder("Referencia electrónica:"));
        txt_ref.setEnabled(false);
        txt_ref.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_refMouseEntered(evt);
            }
        });
        txt_ref.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_refActionPerformed(evt);
            }
        });
        txt_ref.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_refKeyTyped(evt);
            }
        });

        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("Detalle de Pago");

        javax.swing.GroupLayout Panel_pagarLayout = new javax.swing.GroupLayout(Panel_pagar);
        Panel_pagar.setLayout(Panel_pagarLayout);
        Panel_pagarLayout.setHorizontalGroup(
            Panel_pagarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_pagarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel_pagarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel30, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_precuenta, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_cambio, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_tarjeta, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmb_medio_de_pago, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_pagar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator3)
                    .addComponent(txt_ref, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_efectivo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        Panel_pagarLayout.setVerticalGroup(
            Panel_pagarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_pagarLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmb_medio_de_pago, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_efectivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_tarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_ref, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_precuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_cambio, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_pagar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        Panel_numero_factura.setBackground(new java.awt.Color(0, 0, 0));

        jLabel26.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("Nº de factura ");

        Panel_numero_factura_2.setBackground(new java.awt.Color(10, 76, 122));

        lbl_numero_factura.setBackground(new java.awt.Color(0, 0, 0));
        lbl_numero_factura.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lbl_numero_factura.setForeground(new java.awt.Color(255, 255, 255));
        lbl_numero_factura.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_numero_factura.setOpaque(true);

        javax.swing.GroupLayout Panel_numero_factura_2Layout = new javax.swing.GroupLayout(Panel_numero_factura_2);
        Panel_numero_factura_2.setLayout(Panel_numero_factura_2Layout);
        Panel_numero_factura_2Layout.setHorizontalGroup(
            Panel_numero_factura_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_numero_factura, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
        );
        Panel_numero_factura_2Layout.setVerticalGroup(
            Panel_numero_factura_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_numero_factura_2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lbl_numero_factura, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout Panel_numero_facturaLayout = new javax.swing.GroupLayout(Panel_numero_factura);
        Panel_numero_factura.setLayout(Panel_numero_facturaLayout);
        Panel_numero_facturaLayout.setHorizontalGroup(
            Panel_numero_facturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_numero_facturaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel_numero_facturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Panel_numero_factura_2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        Panel_numero_facturaLayout.setVerticalGroup(
            Panel_numero_facturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_numero_facturaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Panel_numero_factura_2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel7.setBackground(new java.awt.Color(0, 0, 0));
        jLabel7.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Otras opciones");
        jLabel7.setOpaque(true);

        btn_cierre_de_caja.setBackground(new java.awt.Color(255, 153, 51));
        btn_cierre_de_caja.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 14)); // NOI18N
        btn_cierre_de_caja.setForeground(new java.awt.Color(255, 255, 255));
        btn_cierre_de_caja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cerrar_caja.png"))); // NOI18N
        btn_cierre_de_caja.setText("Cerrar caja");
        btn_cierre_de_caja.setToolTipText("Cerrar Caja");
        btn_cierre_de_caja.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        btn_cierre_de_caja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cierre_de_cajaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Panel_añadir_producto1Layout = new javax.swing.GroupLayout(Panel_añadir_producto1);
        Panel_añadir_producto1.setLayout(Panel_añadir_producto1Layout);
        Panel_añadir_producto1Layout.setHorizontalGroup(
            Panel_añadir_producto1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(Panel_añadir_producto1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_cierre_de_caja, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        Panel_añadir_producto1Layout.setVerticalGroup(
            Panel_añadir_producto1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_añadir_producto1Layout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btn_cierre_de_caja, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Logo_1.png"))); // NOI18N

        javax.swing.GroupLayout Panel_fondoLayout = new javax.swing.GroupLayout(Panel_fondo);
        Panel_fondo.setLayout(Panel_fondoLayout);
        Panel_fondoLayout.setHorizontalGroup(
            Panel_fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel_barra_superior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(Panel_fondoLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(Panel_datos_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Panel_fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Panel_añadir_producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Panel_calculadora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Panel_añadir_producto1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Panel_fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Panel_ingreso_producto, javax.swing.GroupLayout.PREFERRED_SIZE, 623, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Panel_total, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Panel_fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Panel_pagar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Panel_numero_factura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        Panel_fondoLayout.setVerticalGroup(
            Panel_fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_fondoLayout.createSequentialGroup()
                .addComponent(Panel_barra_superior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Panel_fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(Panel_fondoLayout.createSequentialGroup()
                        .addComponent(Panel_numero_factura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Panel_pagar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_fondoLayout.createSequentialGroup()
                        .addComponent(Panel_ingreso_producto, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Panel_total, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_fondoLayout.createSequentialGroup()
                        .addComponent(Panel_añadir_producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Panel_añadir_producto1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Panel_calculadora, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(Panel_datos_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel_fondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel_fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed

    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        
    }//GEN-LAST:event_formWindowClosing

    private void btn_cerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cerrarActionPerformed
            int respuesta=JOptionPane.showConfirmDialog(null,"¿Esta seguro de cerrar el punto de venta?","AVISO",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
            if(respuesta==JOptionPane.YES_OPTION){
                formulario_principal.setVisible(true);
                dispose();
            }
    }//GEN-LAST:event_btn_cerrarActionPerformed
    /*
    Rutina: btn_buscar_cliente
    Autores: Jose
    Version 1.0   04/07/2020 
    consulta y muestra los datos del cliente buscado.
    */
    private void btn_buscar_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscar_clienteActionPerformed
 
        if(txt_id.getText().length()>0){
            conexion=clase_conexion.conectar();
            if(clase_conexion.obtener_estado_conexion()==true){
                try{
                    prepared_statement=conexion.prepareStatement("SELECT * FROM Clientes WHERE identificacion=?");
                    prepared_statement.setString(1,txt_id.getText().trim());
                    result_set=prepared_statement.executeQuery();

                    if(result_set.next()){
                        cod_cliente=result_set.getInt("cod_cliente");
                        txt_nombres.setText(result_set.getString("nombres").trim());
                        txt_apellidos.setText(result_set.getString("apellidos").trim());
                        txt_celular.setText(result_set.getString("celular").trim());
                        txt_correo.setText(result_set.getString("correo_electronico").trim());
                    }else{
                        JOptionPane.showMessageDialog(null,"Cliente no encontrado ","AVISO",JOptionPane.INFORMATION_MESSAGE);
                        cod_cliente=0;
                        txt_id.setText(null);
                        txt_id.grabFocus();
                        txt_nombres.setText(null);
                        txt_apellidos.setText(null);
                        txt_celular.setText(null);
                        txt_correo.setText(null);
                    }
                    conexion=null;
                    clase_conexion.cerrar_conexion();
                    prepared_statement.close();
                    result_set.close();
                }catch(SQLException e){
                    JOptionPane.showMessageDialog(this,"Ocurrió un error inesperado "+e,"ERROR",JOptionPane.ERROR_MESSAGE);
                }
            }
        }else{
            JOptionPane.showMessageDialog(null, "Debe llenar el Numero de Identidad del Cliente","AVISO",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btn_buscar_clienteActionPerformed

/*
Rutina: Botones de agregar y quitar productos
Autores: Jose
Version 1.0   04/07/2020 
los botones permiten, agregar productos hasta su existencia máxima de inventario,
asi como quitar productos de la venta.
*/
    private void btn_agregar_productoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregar_productoActionPerformed
        conexion=clase_conexion.conectar();
        int cantidad=0,stock_producto=0;
        Double precio=0.0,subtotal=0.0;
        if(Tabla_principal.getSelectedRow()>=0){
            if(clase_conexion.obtener_estado_conexion()==true){
                try{
                    prepared_statement=conexion.prepareStatement("SELECT stock FROM [dbo].[Productos_Venta] WHERE cod_producto_vt=? AND stock>0 ");
                    prepared_statement.setInt(1,Integer.parseInt(txt_codigo_producto.getText().trim()));
                    result_set=prepared_statement.executeQuery();

                    if(result_set.next()){
                        stock_producto=result_set.getInt("stock");
                        cantidad=Integer.parseInt(txt_cantidad_producto.getText().trim());
                        if(cantidad<stock_producto){
                            cantidad=cantidad+1;
                            precio=Double.parseDouble(txt_precio_producto.getText().trim());
                            subtotal=cantidad*precio;
                            clase_validaciones.redondear_decimales(subtotal);
                            txt_cantidad_producto.setText(String.valueOf(cantidad));
                            txt_subtotal_producto.setText(String.valueOf(clase_validaciones.redondear_decimales(subtotal)));
                            modelo_tabla.setValueAt(cantidad,Tabla_principal.getSelectedRow(),3);
                            modelo_tabla.setValueAt(clase_validaciones.redondear_decimales(subtotal),Tabla_principal.getSelectedRow(),4);
                            calcular_totales();
                        }else{
                            JOptionPane.showMessageDialog(null,"Producto sin unidades en existencia","AVISO",JOptionPane.INFORMATION_MESSAGE);
                        }
                    }else{
                        JOptionPane.showMessageDialog(null,"Producto sin unidades en existencia","AVISO",JOptionPane.INFORMATION_MESSAGE);
                    }
                conexion=null;
                clase_conexion.cerrar_conexion();
                prepared_statement.close();
                result_set.close();
                }catch(SQLException e){
                    JOptionPane.showMessageDialog(this,"Ocurrió un error inesperado","ERROR",JOptionPane.ERROR_MESSAGE);
                }
            }
        }else{
            JOptionPane.showMessageDialog(this,"Debe seleccionar un producto","Aviso",JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btn_agregar_productoActionPerformed

    private void btn_eliminar_productoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminar_productoActionPerformed
        int cantidad=0,stock_producto=0;
        Double precio=0.0,subtotal=0.0;
        if(Tabla_principal.getSelectedRow()>-1){
            cantidad=Integer.parseInt(txt_cantidad_producto.getText().trim());
            cantidad=cantidad-1;
            if(cantidad>0 ){
                precio=Double.parseDouble(txt_precio_producto.getText().trim());
                subtotal=cantidad*precio;
                clase_validaciones.redondear_decimales(subtotal);
                txt_cantidad_producto.setText(String.valueOf(cantidad));
                txt_subtotal_producto.setText(String.valueOf(clase_validaciones.redondear_decimales(subtotal)));
                modelo_tabla.setValueAt(cantidad,Tabla_principal.getSelectedRow(),3);
                modelo_tabla.setValueAt(clase_validaciones.redondear_decimales(subtotal),Tabla_principal.getSelectedRow(),4);
                calcular_totales();
            }else{
                int respuesta=JOptionPane.showConfirmDialog(null,"¿Esta seguro Eliminar el Producto de la Venta?","Advertencia",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
                if(respuesta==JOptionPane.YES_OPTION){
                    modelo_tabla.removeRow(Tabla_principal.getSelectedRow());
                    txt_codigo_producto.setText("");
                    txt_nombre_producto.setText("");
                    txt_precio_producto.setText("");
                    txt_cantidad_producto.setText("");
                    txt_subtotal_producto.setText("");
                    calcular_totales();
                }
            }
        }else{
             JOptionPane.showMessageDialog(this,"Debe seleccionar un producto","Aviso",JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btn_eliminar_productoActionPerformed
    /*
    btn_precuenta
    Autores: jose
    Version 1.0   04/07/2020 
    muestra en pantalla el calculo total de la venta previo a cancelación.
    */
    private void btn_precuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_precuentaActionPerformed
        cambio=0;
        variable_de_validacion=false;
        lbl_numero_factura.setText(correlativo_factura());
        validar_venta();

    }//GEN-LAST:event_btn_precuentaActionPerformed

    private void cmb_medio_de_pagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_medio_de_pagoActionPerformed
    
        txt_efectivo.setText("");
        txt_tarjeta.setText("");
        txt_ref.setText("");
        
        if(cmb_medio_de_pago.getSelectedItem().equals("Efectivo")){
            txt_efectivo.setEnabled(true);
            txt_tarjeta.setEnabled(false);
            txt_ref.setEnabled(false);
        }
        if(cmb_medio_de_pago.getSelectedItem().equals("Tarjeta")){
            txt_tarjeta.setEnabled(true);
            txt_ref.setEnabled(true);
            txt_efectivo.setEnabled(false);
        }
        if(cmb_medio_de_pago.getSelectedItem().equals("Efectivo y Tarjeta")){
            txt_tarjeta.setEnabled(true);
            txt_efectivo.setEnabled(true);
            txt_ref.setEnabled(true);
        }
    }//GEN-LAST:event_cmb_medio_de_pagoActionPerformed

    private void btn_cierre_de_cajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cierre_de_cajaActionPerformed
        frm_Cierre_caja cc=new frm_Cierre_caja();
        cc.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_cierre_de_cajaActionPerformed
    /*
    Rutina: Pagar y finalizar venta
    Autores: jose julio
    Version 1.0   04/04/2020 
    pemite dar finalizacion al proceso de ventas, recalculando los totales e insertando
    la nueva venta en la base de datos.
    */
    private void btn_pagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pagarActionPerformed
    int n_factura=0;  
    String correlativo_factura=correlativo_factura();
        cambio=0;
        variable_de_validacion=false;
        if(total>0){
            if(cod_cliente>0 && txt_nombres.getText().length()>0){
            validar_venta();
            
                if(variable_de_validacion==true){
                    conexion=clase_conexion.conectar();
                    if(clase_conexion.obtener_estado_conexion()==true){
                        try{
                            PreparedStatement prepared_statement=conexion.prepareStatement("INSERT INTO Factura "
                                    + "([n_factura],[numero_factura],[cod_empleado],[cod_cliente],[fecha_emision],[sub_total],[importe_exonerado],[importe_exento],[importe_gravado_15%],[isv_15%]" +
                                    ",[descuento_y_rebajas],[tipo_pago],[pago_efectivo],[pago_POS],[ref_electronica],[cod_estado]) VALUES ((SELECT MAX(n_factura)+1 FROM Factura),?,?,?,GETDATE(),?,?,?,?,?,?,?,?,?,?,?)");
                            prepared_statement.setString(1,correlativo_factura);
                            prepared_statement.setInt(2,cod_empleado);
                            prepared_statement.setInt(3,cod_cliente);
                            prepared_statement.setDouble(4,sub_total);
                            prepared_statement.setDouble(5,importe_exonerado);
                            prepared_statement.setDouble(6,importe_exento);
                            prepared_statement.setDouble(7,importe_gravado_15);
                            prepared_statement.setDouble(8, isv_15);
                            prepared_statement.setDouble(9, descuentos_y_rebajas);
                            prepared_statement.setString(10, cmb_medio_de_pago.getSelectedItem().toString());
                            prepared_statement.setDouble(11, total_efectivo);
                            prepared_statement.setDouble(12, total_tarjeta);
                            prepared_statement.setString(13, n_referencia);
                            prepared_statement.setInt(14,5);
                            prepared_statement.executeUpdate();
                            prepared_statement.close();
                            
                            try{
                                PreparedStatement prepared_statement_factura=conexion.prepareStatement("SELECT MAX(n_factura) AS n_factura FROM Factura");
                                result_set=prepared_statement_factura.executeQuery();
                                if(result_set.next()){                       
                                    n_factura=result_set.getInt("n_factura");
                                }
                                prepared_statement_factura.close();
                                result_set.close();
                            }catch(Exception ex){
                                JOptionPane.showMessageDialog(null, ex);
                            }
                            
                            //inserción del los detalles de factura

                            for(int contador_filas=0;contador_filas<Tabla_principal.getRowCount();contador_filas++){

                                PreparedStatement prepared_statement_local=conexion.prepareStatement("INSERT INTO Detalle_Factura ([n_factura],[cod_producto_vt],[cantidad],[sub_total]) VALUES (?,?,?,?)");
                                prepared_statement_local.setInt(1,n_factura);
                                prepared_statement_local.setInt(2,Integer.parseInt(Tabla_principal.getValueAt(contador_filas,0).toString().trim()));
                                prepared_statement_local.setInt(3,Integer.parseInt(Tabla_principal.getValueAt(contador_filas,3).toString().trim()));
                                prepared_statement_local.setDouble(4,Double.parseDouble(Tabla_principal.getValueAt(contador_filas,4).toString().trim()));
                                prepared_statement_local.executeUpdate();
                                prepared_statement_local.close();

                                PreparedStatement prepared_statement_actualizar=conexion.prepareStatement("UPDATE [dbo].[Productos_Venta] SET [stock] = [stock]-?  WHERE [cod_producto_vt]=?");
                                prepared_statement_actualizar.setInt(1,Integer.parseInt(Tabla_principal.getValueAt(contador_filas,3).toString().trim()));
                                prepared_statement_actualizar.setInt(2,Integer.parseInt(Tabla_principal.getValueAt(contador_filas,0).toString().trim()));
                                prepared_statement_actualizar.executeUpdate();
                                prepared_statement_actualizar.close();
                            }

                            Datos_de_facturacion datos_de_facturacion=new Datos_de_facturacion(total_efectivo,total_tarjeta,Double.parseDouble(lbl_total.getText().trim()),cambio);
                            frm_venta_exitosa venta_finalizada=new frm_venta_exitosa();
                            clase_reportes.Factura_Venta(n_factura);
                            venta_finalizada.setVisible(true);
                            inicializar_formulario();
                        }catch(SQLException ex){
                            JOptionPane.showMessageDialog(this,"Error al procesar la venta :"+ex,"ERROR EN VENTA",JOptionPane.ERROR_MESSAGE);
                        }
                        conexion=null;
                        clase_conexion.cerrar_conexion();
                    }
               }
            }else{
                JOptionPane.showMessageDialog(this,"ERROR: Debe Seleccionar un cliente ","ERROR EN VENTA",JOptionPane.ERROR_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(this,"ERROR: Debe agregar un producto a la venta","ERROR EN VENTA",JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btn_pagarActionPerformed

    private void btn_EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_EliminarActionPerformed
        int respuesta=JOptionPane.showConfirmDialog(null,"¿Esta seguro de Cancelar la Venta?","AVISO",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
            if(respuesta==JOptionPane.YES_OPTION){
                inicializar_formulario();
            }
    }//GEN-LAST:event_btn_EliminarActionPerformed

    private void txt_efectivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_efectivoActionPerformed
        caja_actual="efectivo";
    }//GEN-LAST:event_txt_efectivoActionPerformed

    private void txt_descuentos_rebajasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_descuentos_rebajasActionPerformed
        if(txt_descuentos_rebajas.getText().trim().equals("0")){
            txt_descuentos_rebajas.setText("");
        }
        caja_actual="descuento";
    }//GEN-LAST:event_txt_descuentos_rebajasActionPerformed

    private void txt_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_idActionPerformed
        caja_actual="id";
    }//GEN-LAST:event_txt_idActionPerformed

    private void txt_tarjetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_tarjetaActionPerformed
        caja_actual="tarjeta";
    }//GEN-LAST:event_txt_tarjetaActionPerformed

    private void txt_refActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_refActionPerformed
        caja_actual="referencia";
    }//GEN-LAST:event_txt_refActionPerformed

    private void btn_7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_7ActionPerformed
        teclado_en_pantalla("7");
    }//GEN-LAST:event_btn_7ActionPerformed

    private void btn_enterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_enterActionPerformed
    String cadena="";
    
        if("efectivo".equals(caja_actual) && txt_efectivo.getText().trim().length()>0){
            cadena=txt_efectivo.getText().trim().substring(0,txt_efectivo.getText().trim().length()-1);
            txt_efectivo.setText(cadena);
        }
        if("tarjeta".equals(caja_actual) && txt_tarjeta.getText().trim().length()>0){
            cadena=txt_tarjeta.getText().trim().substring(0,txt_tarjeta.getText().trim().length()-1);
            txt_tarjeta.setText(cadena);
        }
        if("descuento".equals(caja_actual) && txt_descuentos_rebajas.getText().trim().length()>0){
            cadena=txt_descuentos_rebajas.getText().trim().substring(0,txt_descuentos_rebajas.getText().trim().length()-1);
            txt_descuentos_rebajas.setText(cadena);
        }
        if("id".equals(caja_actual) && txt_id.getText().trim().length()>0){
            cadena=txt_id.getText().trim().substring(0,txt_id.getText().trim().length()-1);
            txt_id.setText(cadena);
        }
        if("referencia".equals(caja_actual) && txt_ref.getText().trim().length()>0){
            cadena=txt_ref.getText().trim().substring(0,txt_ref.getText().trim().length()-1);
            txt_ref.setText(cadena);
        }
    }//GEN-LAST:event_btn_enterActionPerformed

    private void txt_idMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_idMouseEntered
        caja_actual="id";
    }//GEN-LAST:event_txt_idMouseEntered

    private void txt_descuentos_rebajasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_descuentos_rebajasMouseEntered
        caja_actual="descuento";
    }//GEN-LAST:event_txt_descuentos_rebajasMouseEntered

    private void txt_efectivoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_efectivoMouseEntered
        caja_actual="efectivo";
    }//GEN-LAST:event_txt_efectivoMouseEntered

    private void txt_tarjetaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_tarjetaMouseEntered
        caja_actual="tarjeta";
    }//GEN-LAST:event_txt_tarjetaMouseEntered

    private void txt_refMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_refMouseEntered
        caja_actual="referencia";
    }//GEN-LAST:event_txt_refMouseEntered

    private void btn_8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_8ActionPerformed
        teclado_en_pantalla("8");
    }//GEN-LAST:event_btn_8ActionPerformed

    private void btn_9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_9ActionPerformed
        teclado_en_pantalla("9");
    }//GEN-LAST:event_btn_9ActionPerformed

    private void btn_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_4ActionPerformed
        teclado_en_pantalla("4");
    }//GEN-LAST:event_btn_4ActionPerformed

    private void btn_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_5ActionPerformed
        teclado_en_pantalla("5");
    }//GEN-LAST:event_btn_5ActionPerformed

    private void btn_6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_6ActionPerformed
        teclado_en_pantalla("6");
    }//GEN-LAST:event_btn_6ActionPerformed

    private void btn_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_1ActionPerformed
        teclado_en_pantalla("1");
    }//GEN-LAST:event_btn_1ActionPerformed

    private void btn_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_2ActionPerformed
        teclado_en_pantalla("2");
    }//GEN-LAST:event_btn_2ActionPerformed

    private void btn_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_3ActionPerformed
        teclado_en_pantalla("3");
    }//GEN-LAST:event_btn_3ActionPerformed

    private void btn_0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_0ActionPerformed
        teclado_en_pantalla("0");
    }//GEN-LAST:event_btn_0ActionPerformed
    
    private void btn_puntoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_puntoActionPerformed
      
        String numero=".";
        
        if("efectivo".equals(caja_actual) && clase_validaciones.validar_punto_decimal(txt_efectivo.getText().trim())==true){
            txt_efectivo.setText(txt_efectivo.getText().trim()+numero);
        }
        if("tarjeta".equals(caja_actual) && clase_validaciones.validar_punto_decimal(txt_tarjeta.getText().trim())==true){
            txt_tarjeta.setText(txt_tarjeta.getText().trim()+numero);
        }
        if("descuento".equals(caja_actual) && clase_validaciones.validar_punto_decimal(txt_descuentos_rebajas.getText().trim())==true){
            txt_descuentos_rebajas.setText(txt_descuentos_rebajas.getText().trim()+numero);
        }
    }//GEN-LAST:event_btn_puntoActionPerformed

    private void txt_idKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_idKeyTyped
        if(txt_id.getText().length()>=14){
            evt.consume();
        }
    }//GEN-LAST:event_txt_idKeyTyped

    private void txt_descuentos_rebajasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_descuentos_rebajasKeyTyped
        if(txt_descuentos_rebajas.getText().length()>=5){
            evt.consume();
        }
    }//GEN-LAST:event_txt_descuentos_rebajasKeyTyped

    private void txt_efectivoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_efectivoKeyTyped
        if(txt_efectivo.getText().length()>=6){
             evt.consume();
        }
    }//GEN-LAST:event_txt_efectivoKeyTyped

    private void txt_tarjetaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_tarjetaKeyTyped
       if(txt_tarjeta.getText().length()>=6){
            evt.consume();
       }
    }//GEN-LAST:event_txt_tarjetaKeyTyped

    private void txt_refKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_refKeyTyped
        if(txt_ref.getText().length()>=15){
            evt.consume();
       }
    }//GEN-LAST:event_txt_refKeyTyped

    private void txt_descuentos_rebajasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_descuentos_rebajasKeyReleased
        if(txt_descuentos_rebajas.getText().length()>0){
            calcular_totales();
        }
    }//GEN-LAST:event_txt_descuentos_rebajasKeyReleased

    private void txt_idInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txt_idInputMethodTextChanged

    }//GEN-LAST:event_txt_idInputMethodTextChanged

    private void Tabla_principalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tabla_principalMouseClicked
        seleccionar_producto(Tabla_principal.rowAtPoint(evt.getPoint()));
    }//GEN-LAST:event_Tabla_principalMouseClicked

    private void btn_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregarActionPerformed
        frm_buscar_producto buscar_producto=new frm_buscar_producto();
        buscar_producto.setVisible(true);
    }//GEN-LAST:event_btn_agregarActionPerformed

    private void Tabla_principalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Tabla_principalKeyReleased
        seleccionar_producto(Tabla_principal.getSelectedRow());
    }//GEN-LAST:event_Tabla_principalKeyReleased

    private void Tabla_principalComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_Tabla_principalComponentAdded
       calcular_totales();
    }//GEN-LAST:event_Tabla_principalComponentAdded

    private void txt_efectivoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_efectivoKeyReleased
        
    }//GEN-LAST:event_txt_efectivoKeyReleased

    private void txt_tarjetaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_tarjetaKeyReleased
        
    }//GEN-LAST:event_txt_tarjetaKeyReleased

    /*
    Rutina: fecha y fecha_2
    Autor: erick, victor
    Version 1.0   04/03/2020 
    permiten obtener las fechas actuales en diferentes formatos.
    */
    
    public static String fecha(){
        Date fecha = new Date();
        SimpleDateFormat Formato_fecha = new SimpleDateFormat("dd/MM/YYYY");
        return Formato_fecha.format(fecha);
    }
    public static String fecha_2(){
        Date fecha_2 = new Date();
        SimpleDateFormat Formato_fecha = new SimpleDateFormat("YYYY/MM/dd");
        return Formato_fecha.format(fecha_2);
    }
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
            java.util.logging.Logger.getLogger(frm_punto_de_venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_punto_de_venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_punto_de_venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_punto_de_venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_punto_de_venta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panel_añadir_producto;
    private javax.swing.JPanel Panel_añadir_producto1;
    private javax.swing.JPanel Panel_barra_superior;
    private javax.swing.JPanel Panel_calculadora;
    private javax.swing.JPanel Panel_datos_cliente;
    private javax.swing.JPanel Panel_fondo;
    private javax.swing.JPanel Panel_ingreso_producto;
    private javax.swing.JPanel Panel_numero_factura;
    private javax.swing.JPanel Panel_numero_factura_2;
    private javax.swing.JPanel Panel_pagar;
    private javax.swing.JPanel Panel_producto_1;
    private javax.swing.JPanel Panel_teclado;
    private javax.swing.JPanel Panel_total;
    public static javax.swing.JTable Tabla_principal;
    private javax.swing.JButton btn_0;
    private javax.swing.JButton btn_1;
    private javax.swing.JButton btn_2;
    private javax.swing.JButton btn_3;
    private javax.swing.JButton btn_4;
    private javax.swing.JButton btn_5;
    private javax.swing.JButton btn_6;
    private javax.swing.JButton btn_7;
    private javax.swing.JButton btn_8;
    private javax.swing.JButton btn_9;
    private javax.swing.JButton btn_Eliminar;
    private javax.swing.JButton btn_agregar;
    private javax.swing.JButton btn_agregar_producto;
    private javax.swing.JButton btn_buscar_cliente;
    private javax.swing.JButton btn_cerrar;
    private javax.swing.JButton btn_cierre_de_caja;
    private javax.swing.JButton btn_eliminar_producto;
    private javax.swing.JButton btn_enter;
    private javax.swing.JButton btn_pagar;
    private javax.swing.JButton btn_precuenta;
    private javax.swing.JButton btn_punto;
    private javax.swing.JComboBox<String> cmb_medio_de_pago;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JLabel lbl_descripcion_producto_1;
    private javax.swing.JLabel lbl_descripcion_producto_2;
    private javax.swing.JLabel lbl_descripcion_producto_3;
    public static javax.swing.JLabel lbl_exento;
    public static javax.swing.JLabel lbl_exonerado;
    private javax.swing.JLabel lbl_fecha;
    public static javax.swing.JLabel lbl_gravado;
    public static javax.swing.JLabel lbl_isv;
    private javax.swing.JLabel lbl_nombre_producto_1;
    private javax.swing.JLabel lbl_nombre_producto_2;
    private javax.swing.JLabel lbl_numero_factura;
    public static javax.swing.JLabel lbl_subtotal;
    public static javax.swing.JLabel lbl_total;
    private javax.swing.JLabel lbl_usuario_actual;
    private javax.swing.JTextField txt_apellidos;
    private javax.swing.JTextField txt_cambio;
    private javax.swing.JTextField txt_cantidad_producto;
    private javax.swing.JTextField txt_celular;
    private javax.swing.JTextField txt_codigo_producto;
    private javax.swing.JTextField txt_correo;
    public static javax.swing.JTextField txt_descuentos_rebajas;
    private javax.swing.JTextField txt_efectivo;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_nombre_producto;
    private javax.swing.JTextField txt_nombres;
    private javax.swing.JTextField txt_precio_producto;
    private javax.swing.JTextField txt_ref;
    private javax.swing.JTextField txt_subtotal_producto;
    private javax.swing.JTextField txt_tarjeta;
    // End of variables declaration//GEN-END:variables
}
