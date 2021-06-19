package clases;

/*
Clase: Datos_de_facturacion
Autor: Julio Tinoco
Version 1.0   01/07/2020

Clase que permite compartir datos de facturación entre 
los formularios de punto de venta y venta exitosa. 
*/

public class Datos_de_facturacion {
    Validaciones clase_validaciones=new Validaciones();
    private static Double cantidad_efectivo,cantidad_tarjeta,total_venta,cambio;
    public Datos_de_facturacion(){

    }
    public Datos_de_facturacion(Double cantidad_efectivo,Double cantidad_tarjeta,Double total_venta,Double cambio){
        Datos_de_facturacion.cantidad_efectivo=clase_validaciones.redondear_decimales(cantidad_efectivo);
        Datos_de_facturacion.cantidad_tarjeta=clase_validaciones.redondear_decimales(cantidad_tarjeta);
        Datos_de_facturacion.total_venta=clase_validaciones.redondear_decimales(total_venta);
        Datos_de_facturacion.cambio=clase_validaciones.redondear_decimales(cambio);
    }
    public Double obtener_cantidad_efectivo(){
        return cantidad_efectivo;
    }
    public Double obtener_cantidad_tarjeta(){
        return cantidad_tarjeta;
    }
    public Double obtener_total_venta(){
        return total_venta;
    }
    public Double obtener_cambio(){
        return cambio;
    }
}
