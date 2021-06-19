package Reportes;

import clases.conexion;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/*
Clase: generar_reporte
Autores: Tomas, Katering
Version 1.0   09/03/2020 
Clase que permite generar todos los reportes del sistema.
*/

public class GenerarReporte {
    
    conexion con = new conexion();
    Connection conexion = con.conectar();
    
    public void Factura_Venta(int codigo){
        try {
            Map parametros = new HashMap();
            parametros.put("N_Factura",codigo);
            String ruta = System.getProperty("user.dir") + "/src/Reportes/Factura_Venta.jasper";
            JasperReport reporte = (JasperReport) JRLoader.loadObject(ruta);
            JasperPrint jasper_print = JasperFillManager.fillReport(reporte,parametros,conexion);
            JasperViewer jasper_viewer = new JasperViewer(jasper_print, false);
            jasper_viewer.setTitle("Factura");
            jasper_viewer.setVisible(true);
            Image iconoPropio = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/icono.png"));
            jasper_viewer.setIconImage(iconoPropio);
            jasper_viewer.setAlwaysOnTop(true);
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error al mostrar el reporte" + e);
        }         
    }

         
    public void Factura_Cotizaciones(int codigo){
        try {
            Map parametros = new HashMap();
            parametros.put("Cod_Cotizacion",codigo);              
            String ruta = System.getProperty("user.dir") + "/src/Reportes/Factura_Cotizaciones.jasper";
            JasperReport reporte = (JasperReport) JRLoader.loadObject(ruta);
            JasperPrint j = JasperFillManager.fillReport(reporte,parametros,conexion);
            JasperViewer jasper_viewer = new JasperViewer(j, false);
            jasper_viewer.setTitle("Cotizacion");
            jasper_viewer.setVisible(true);
            Image iconoPropio = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/icono.png"));
            jasper_viewer.setIconImage(iconoPropio);
            jasper_viewer.setAlwaysOnTop(true);
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error al mostrar el reporte" + e);
        }         
    }
    
    public void Factura_Pedidos(int codigo){
        try {
            Map parametros = new HashMap();
            parametros.put("Cod_Pedido",codigo);
            String ruta = System.getProperty("user.dir") + "/src/Reportes/Factura_Pedidos.jasper";
            JasperReport reporte = (JasperReport) JRLoader.loadObject(ruta);
            JasperPrint j = JasperFillManager.fillReport(reporte,parametros,conexion);
            JasperViewer jasper_viewer = new JasperViewer(j, false);
            jasper_viewer.setTitle("Pedido");
            jasper_viewer.setVisible(true);
            Image iconoPropio = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/icono.png"));
            jasper_viewer.setIconImage(iconoPropio);
            jasper_viewer.setAlwaysOnTop(true);
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error al mostrar el reporte" + e);
        }         
    }
       
    public void Cierre_Caja(int codigo){
        try {
            Map parametros = new HashMap();
            parametros.put("Cod_Cierre_Caja",codigo);              
            String ruta = System.getProperty("user.dir") + "/src/Reportes/Cierre_Caja.jasper";
            JasperReport reporte = (JasperReport) JRLoader.loadObject(ruta);
            JasperPrint j = JasperFillManager.fillReport(reporte,parametros,conexion);
            JasperViewer jasper_viewer = new JasperViewer(j, false);
            jasper_viewer.setTitle("Cierre de Caja");
            jasper_viewer.setVisible(true);
            Image iconoPropio = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/icono.png"));
            jasper_viewer.setIconImage(iconoPropio);
            jasper_viewer.setAlwaysOnTop(true);
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error al mostrar el reporte" + e);
        }         
    }
    public void Catalogo_Materia_Prima(){
        try {
            String ruta = System.getProperty("user.dir") + "/src/Reportes/Catalogo_Materia_Prima.jasper";
            JasperReport reporte = (JasperReport) JRLoader.loadObject(ruta);
            JasperPrint j = JasperFillManager.fillReport(reporte,null,conexion);
            JasperViewer jasper_viewer = new JasperViewer(j, false);
            jasper_viewer.setTitle("Catalogo Productos Materia Prima");
            jasper_viewer.setVisible(true);
            Image iconoPropio = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/icono.png"));
            jasper_viewer.setIconImage(iconoPropio);
            jasper_viewer.setAlwaysOnTop(true);
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error al mostrar el reporte" + e);
        }         
    }

    public void Catalogo_Produtos_Ventas(){
        try {
            String ruta = System.getProperty("user.dir") + "/src/Reportes/Productos_Ventas.jasper";
            JasperReport reporte = (JasperReport) JRLoader.loadObject(ruta);
            JasperPrint j = JasperFillManager.fillReport(reporte,null,conexion);
            JasperViewer jasper_viewer = new JasperViewer(j, false);
            jasper_viewer.setTitle("Catalogo Productos Ventas");
            jasper_viewer.setVisible(true);
            Image iconoPropio = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/icono.png"));
            jasper_viewer.setIconImage(iconoPropio);
            jasper_viewer.setAlwaysOnTop(true);
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error al mostrar el reporte" + e);
        }         
    }
    
    public void Stock_Ventas(){
        try {
            String ruta = System.getProperty("user.dir") + "/src/Reportes/Stock_Ventas.jasper";
            JasperReport reporte = (JasperReport) JRLoader.loadObject(ruta);
            JasperPrint j = JasperFillManager.fillReport(reporte,null,conexion);
            JasperViewer jasper_viewer = new JasperViewer(j, false);
            jasper_viewer.setTitle("Stock Productos Ventas");
            jasper_viewer.setVisible(true);
            Image iconoPropio = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/icono.png"));
            jasper_viewer.setIconImage(iconoPropio);
            jasper_viewer.setAlwaysOnTop(true);
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error al mostrar el reporte" + e);
        }         
    }


    public void Stock_Materia_Prima(){
        try {

            String ruta = System.getProperty("user.dir") + "/src/Reportes/Stock_Materia_Prima.jasper";
            JasperReport reporte = (JasperReport) JRLoader.loadObject(ruta);
            JasperPrint j = JasperFillManager.fillReport(reporte,null,conexion);
            JasperViewer jasper_viewer = new JasperViewer(j, false);
            jasper_viewer.setTitle("Stock Productos Materia Prima");
            jasper_viewer.setVisible(true);
            Image iconoPropio = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/icono.png"));
            jasper_viewer.setIconImage(iconoPropio);
            jasper_viewer.setAlwaysOnTop(true);
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error al mostrar el reporte" + e);
        }         
  }

}
