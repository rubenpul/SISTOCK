/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistock;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/**
 *
 * @author ruben
 */
public class reporte_excel {
    
    private File file;
    private String nombreTab;
    private JTable tablaentrada;
    private JTable tablasalida;

    public reporte_excel(File file, String nombreTab, JTable tablaentrada, JTable tablasalida) {
        this.file = file;
        this.nombreTab = nombreTab;
        this.tablaentrada = tablaentrada;
        this.tablasalida = tablasalida;
    }

    public reporte_excel(File file, String nombreTab, JTable tablaentrada) {
        this.file = file;
        this.nombreTab = nombreTab;
        this.tablaentrada = tablaentrada;
        
    }
  
    public Boolean excel_export(){
    
        int i=0;
        int j=0;
        String area;
        Double costo;
        Double total_stock;
        Double total_usado;
        Double total;
        WritableFont fuente_titulo = new WritableFont(WritableFont.ARIAL, 14, WritableFont.BOLD, true);
        WritableCellFormat celda_titulo = new WritableCellFormat(fuente_titulo); 
        WritableFont fuente_subtitulo = new WritableFont(WritableFont.ARIAL, 12, WritableFont.BOLD, true);
        WritableCellFormat celda_subtitulo = new WritableCellFormat(fuente_subtitulo); 
        WritableFont fuente_datos = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD, true);
        WritableCellFormat celda_datos = new WritableCellFormat(fuente_datos); 
        try{
        
            //Nuestro flujo de salida para apuntar a donde vamos a escribir
            DataOutputStream out=new DataOutputStream(new FileOutputStream(file));
 
            //Representa nuestro archivo en excel y necesita un OutputStream para saber donde va locoar los datos
            WritableWorkbook w = Workbook.createWorkbook(out);
 
 
            //Como excel tiene muchas hojas esta crea o toma la hoja
            //Coloca el nombre del "tab" y el indice del tab
            WritableSheet s = w.createSheet(nombreTab, 0);
 
           
            Label etiqueta_titulo = new Label(0, 0, "STOCK", celda_titulo); 
            s.addCell(etiqueta_titulo);
            j++;
            
            Label etiqueta_subtitulo = new Label(0, j, "AREA", celda_subtitulo); 
            s.addCell(etiqueta_subtitulo);
            
            etiqueta_subtitulo = new Label(1, j, "COSTO $", celda_subtitulo); 
            s.addCell(etiqueta_subtitulo);
           
            j++;
            
            area = tablaentrada.getValueAt(0,0).toString();
            costo = 0.0;
            total_stock = 0.0;
            total_usado = 0.0;
            total = 0.0;
            
            Label etiqueta_datos; 
            
            while(i < tablaentrada.getRowCount()){
                
                if (area.equals(tablaentrada.getValueAt(i,0).toString())){
                    costo+= Double.parseDouble(tablaentrada.getValueAt(i,9).toString()); 
                    total_stock+= Double.parseDouble(tablaentrada.getValueAt(i,9).toString()); 
                    etiqueta_subtitulo = new Label(0, j, tablaentrada.getValueAt(i,0).toString(), celda_datos); 
                    s.addCell(etiqueta_subtitulo);
                    etiqueta_subtitulo = new Label(1, j, costo.toString(), celda_datos); 
                    s.addCell(etiqueta_subtitulo);
                    
                    
                }
                else{
                    area = tablaentrada.getValueAt(i,0).toString();
                    j++;
                    costo = 0.0;
                    i--;
                }
                i++;
            }
            
            j+=2;
            etiqueta_subtitulo = new Label(0, j, "TOTAL STOCK", celda_subtitulo); 
            s.addCell(etiqueta_subtitulo);
         
            etiqueta_subtitulo = new Label(1, j, total_stock.toString(), celda_subtitulo); 
            s.addCell(etiqueta_subtitulo);
            
            
            j+=2;
            etiqueta_titulo = new Label(0, j, "USADO", celda_titulo); 
            s.addCell(etiqueta_titulo);
        
            j++;
            
            etiqueta_subtitulo = new Label(0, j, "AREA", celda_subtitulo); 
            s.addCell(etiqueta_subtitulo);
            
            etiqueta_subtitulo = new Label(1, j, "COSTO $", celda_subtitulo); 
            s.addCell(etiqueta_subtitulo);
           
            j++;
            
            
            area = tablasalida.getValueAt(0,0).toString();
            costo = 0.0;
            i=0;
            
            while(i < tablasalida.getRowCount()){
                
                if (area.equals(tablasalida.getValueAt(i,0).toString())){
                    costo+= Double.parseDouble(tablasalida.getValueAt(i,8).toString());  
                    total_usado+= Double.parseDouble(tablasalida.getValueAt(i,8).toString()); 
                    etiqueta_subtitulo = new Label(0, j, tablasalida.getValueAt(i,0).toString(), celda_datos); 
                    s.addCell(etiqueta_subtitulo);
                    etiqueta_subtitulo = new Label(1, j, costo.toString(), celda_datos); 
                    s.addCell(etiqueta_subtitulo);
                }
                else{                                    
                    j++;
                    costo = 0.0;
                    area = tablasalida.getValueAt(i,0).toString();
                    i--;
                }
                i++;
            }

           j+=2;
            etiqueta_subtitulo = new Label(0, j, "TOTAL USADO", celda_subtitulo); 
            s.addCell(etiqueta_subtitulo);
            etiqueta_subtitulo = new Label(1, j, total_usado.toString(), celda_subtitulo); 
            s.addCell(etiqueta_subtitulo);
            
            
            j+=2;
            total = total_stock + total_usado;
            
            etiqueta_subtitulo = new Label(0, j, "TOTAL GENERAL", celda_subtitulo); 
            s.addCell(etiqueta_subtitulo);
            etiqueta_subtitulo = new Label(1, j, total.toString(), celda_subtitulo); 
            s.addCell(etiqueta_subtitulo);
            
            w.write(); 
            //Cerramos el WritableWorkbook y DataOutputStream
            w.close();
            out.close();
 
 
            //si todo sale bien salimos de aqui con un true :D
            return true;
 
        }catch(IOException | WriteException ex){JOptionPane.showMessageDialog(null, "EL ARCHIVO ESTA ABIERTO. POR FAVOR CERRAR.");}
 
        //Si llegamos hasta aqui algo salio mal
        return false;
}

 public Boolean excel_repote_resumen_area() throws WriteException, IOException{
    
        int i;
        int j=0;
        int k;
        int m;
        String area;
        boolean bandera;
        Double consumibles;
        Double materiales;
        Double repuestos;
        Double servicios;
        Double totconsumibles;
        Double totmateriales;
        Double totrepuestos;
        Double totservicios;
        Double totarea;
        Double totalgeneral;
        
        
        WritableFont fuente_titulo = new WritableFont(WritableFont.ARIAL, 14, WritableFont.BOLD, true);
        WritableCellFormat celda_titulo = new WritableCellFormat(fuente_titulo); 
        WritableFont fuente_subtitulo = new WritableFont(WritableFont.ARIAL, 12, WritableFont.BOLD, true);
        WritableCellFormat celda_subtitulo = new WritableCellFormat(fuente_subtitulo); 
        WritableFont fuente_datos = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD, true);
        WritableCellFormat celda_datos = new WritableCellFormat(fuente_datos); 
        try{
        
            //Nuestro flujo de salida para apuntar a donde vamos a escribir
            DataOutputStream out=new DataOutputStream(new FileOutputStream(file));
 
            //Representa nuestro archivo en excel y necesita un OutputStream para saber donde va locoar los datos
            WritableWorkbook w = Workbook.createWorkbook(out);
 
 
            //Como excel tiene muchas hojas esta crea o toma la hoja
            //Coloca el nombre del "tab" y el indice del tab
            WritableSheet s = w.createSheet(nombreTab, 0);
 
           
            Label etiqueta_titulo = new Label(j, 0, "CENTRO DE COSTO", celda_titulo); 
            s.addCell(etiqueta_titulo);
            j++;
            
            Label etiqueta_subtitulo = new Label(j, 0, "CONSUMIBLES", celda_subtitulo); 
            s.addCell(etiqueta_subtitulo);
            
             j++;
            
            etiqueta_subtitulo = new Label(j, 0, "MATERIALES", celda_subtitulo); 
            s.addCell(etiqueta_subtitulo);
           
            j++;
            
            etiqueta_subtitulo = new Label(j, 0, "REPUESTOS", celda_subtitulo); 
            s.addCell(etiqueta_subtitulo);
            
            j++;
            
            etiqueta_subtitulo = new Label(j, 0, "SERVICIOS", celda_subtitulo); 
            s.addCell(etiqueta_subtitulo);
            
            j++;
            
            etiqueta_subtitulo = new Label(j, 0, "TOTAL $ AREA", celda_subtitulo); 
            s.addCell(etiqueta_subtitulo);
            
            j=1;
            
            i=0;
            k=1;
           
            consumibles = 0.0;
            materiales = 0.0;
            repuestos = 0.0;
            servicios = 0.0;

            totconsumibles = 0.0;
            totmateriales = 0.0;
            totrepuestos = 0.0;
            totservicios = 0.0;
            totalgeneral = 0.0;
            totarea = 0.0;
            
            while(i < tablaentrada.getRowCount()){
                area = tablaentrada.getValueAt(i,19).toString();
                etiqueta_subtitulo = new Label(0, j, area, celda_subtitulo); 
                s.addCell(etiqueta_subtitulo);
                k=i;
                bandera = true;
                
                while (k < tablaentrada.getRowCount() && bandera){
                    
                    if (area.equals(tablaentrada.getValueAt(k,19).toString()) ){
                        
                         if (tablaentrada.getValueAt(k,2).toString().equals("CONSUMIBLES")){
                           consumibles += Double.parseDouble(tablaentrada.getValueAt(k,22).toString());
                           
                           etiqueta_subtitulo = new Label(1, j, String.format("%.2f",consumibles), celda_subtitulo);
                         }
                         if (tablaentrada.getValueAt(k,2).toString().equals("MATERIALES")){
                            materiales += Double.parseDouble(tablaentrada.getValueAt(k,22).toString()); 
                           
                            etiqueta_subtitulo = new Label(2, j,  String.format("%.2f",materiales), celda_subtitulo);
                         }
                         if (tablaentrada.getValueAt(k,2).toString().equals("REPUESTOS")){
                            repuestos += Double.parseDouble(tablaentrada.getValueAt(k,22).toString());
                            
                            etiqueta_subtitulo = new Label(3, j, String.format("%.2f",repuestos), celda_subtitulo);
                         }
                         if (tablaentrada.getValueAt(k,2).toString().equals("PKF")){
                             servicios += Double.parseDouble(tablaentrada.getValueAt(k,22).toString());
                             
                             etiqueta_subtitulo = new Label(4, j, String.format("%.2f",servicios), celda_subtitulo);
                         }
                        
                          
                         s.addCell(etiqueta_subtitulo);
                         k++;
                    }
                    else{
                        bandera = false;
                                            
                    }
                }
                i=k;
                j++;
                totconsumibles += consumibles;
                totmateriales += materiales ;
                totservicios += servicios;
                totrepuestos += repuestos;
                totarea = consumibles + materiales + servicios + repuestos;
                totalgeneral += totarea;
                consumibles = 0.0;
                materiales = 0.0;
                repuestos = 0.0;
                servicios = 0.0;
                etiqueta_subtitulo = new Label(5, j-1, String.format("%.2f",totarea), celda_subtitulo);
                s.addCell(etiqueta_subtitulo);
                
            }
            j++;

            etiqueta_subtitulo = new Label(0, j, "TOTALES $", celda_subtitulo); 
            s.addCell(etiqueta_subtitulo);
            
            etiqueta_subtitulo = new Label(1, j, String.format("%.2f",totconsumibles), celda_subtitulo);
            s.addCell(etiqueta_subtitulo);

            etiqueta_subtitulo = new Label(2, j, String.format("%.2f",totmateriales), celda_subtitulo);
            s.addCell(etiqueta_subtitulo);

            etiqueta_subtitulo = new Label(3, j, String.format("%.2f",totrepuestos), celda_subtitulo);
            s.addCell(etiqueta_subtitulo);

            etiqueta_subtitulo = new Label(4, j, String.format("%.2f",totservicios), celda_subtitulo);
            s.addCell(etiqueta_subtitulo);
            
            etiqueta_subtitulo = new Label(5, j, String.format("%.2f",totalgeneral), celda_subtitulo);
            s.addCell(etiqueta_subtitulo);
            
            w.write(); 
            //Cerramos el WritableWorkbook y DataOutputStream
            w.close();
            out.close();
             return true;
     }catch(IOException | WriteException ex){
         JOptionPane.showMessageDialog(null, "EL ARCHIVO ESTA ABIERTO. POR FAVOR CERRAR.");
         return false;
     }
            
           
           /* costo = 0.0;
            total_stock = 0.0;
            total_usado = 0.0;
            total = 0.0;
            
            Label etiqueta_datos; 
            
            while(i < tablaentrada.getRowCount()){
                
                if (area.equals(tablaentrada.getValueAt(i,0).toString())){
                    costo+= Double.parseDouble(tablaentrada.getValueAt(i,9).toString()); 
                    total_stock+= Double.parseDouble(tablaentrada.getValueAt(i,9).toString()); 
                    etiqueta_subtitulo = new Label(0, j, tablaentrada.getValueAt(i,0).toString(), celda_datos); 
                    s.addCell(etiqueta_subtitulo);
                    etiqueta_subtitulo = new Label(1, j, costo.toString(), celda_datos); 
                    s.addCell(etiqueta_subtitulo);
                    
                    
                }
                else{
                    area = tablaentrada.getValueAt(i,0).toString();
                    j++;
                    costo = 0.0;
                    i--;
                }
                i++;
            }
            
            j+=2;
            etiqueta_subtitulo = new Label(0, j, "TOTAL STOCK", celda_subtitulo); 
            s.addCell(etiqueta_subtitulo);
         
            etiqueta_subtitulo = new Label(1, j, total_stock.toString(), celda_subtitulo); 
            s.addCell(etiqueta_subtitulo);
            
            
            j+=2;
            etiqueta_titulo = new Label(0, j, "USADO", celda_titulo); 
            s.addCell(etiqueta_titulo);
        
            j++;
            
            etiqueta_subtitulo = new Label(0, j, "AREA", celda_subtitulo); 
            s.addCell(etiqueta_subtitulo);
            
            etiqueta_subtitulo = new Label(1, j, "COSTO $", celda_subtitulo); 
            s.addCell(etiqueta_subtitulo);
           
            j++;
            
            
            area = tablasalida.getValueAt(0,0).toString();
            costo = 0.0;
            i=0;
            
            while(i < tablasalida.getRowCount()){
                
                if (area.equals(tablasalida.getValueAt(i,0).toString())){
                    costo+= Double.parseDouble(tablasalida.getValueAt(i,8).toString());  
                    total_usado+= Double.parseDouble(tablasalida.getValueAt(i,8).toString()); 
                    etiqueta_subtitulo = new Label(0, j, tablasalida.getValueAt(i,0).toString(), celda_datos); 
                    s.addCell(etiqueta_subtitulo);
                    etiqueta_subtitulo = new Label(1, j, costo.toString(), celda_datos); 
                    s.addCell(etiqueta_subtitulo);
                }
                else{                                    
                    j++;
                    costo = 0.0;
                    area = tablasalida.getValueAt(i,0).toString();
                    i--;
                }
                i++;
            }

           j+=2;
            etiqueta_subtitulo = new Label(0, j, "TOTAL USADO", celda_subtitulo); 
            s.addCell(etiqueta_subtitulo);
            etiqueta_subtitulo = new Label(1, j, total_usado.toString(), celda_subtitulo); 
            s.addCell(etiqueta_subtitulo);
            
            
            j+=2;
            total = total_stock + total_usado;
            
            etiqueta_subtitulo = new Label(0, j, "TOTAL GENERAL", celda_subtitulo); 
            s.addCell(etiqueta_subtitulo);
            etiqueta_subtitulo = new Label(1, j, total.toString(), celda_subtitulo); 
            s.addCell(etiqueta_subtitulo);
            
            w.write(); 
            //Cerramos el WritableWorkbook y DataOutputStream
            w.close();
            out.close();
 
 
            //si todo sale bien salimos de aqui con un true :D
            return true;
 
       
 
        //Si llegamos hasta aqui algo salio mal
        return false;*/
}    
    
    
    
public Boolean excel_export_reporte() throws IOException, WriteException{
    
        int i=0;
        int j=0;
        WritableFont fuente_titulo = new WritableFont(WritableFont.ARIAL, 14, WritableFont.BOLD, true);
        WritableCellFormat celda_titulo = new WritableCellFormat(fuente_titulo); 
        WritableFont fuente_subtitulo = new WritableFont(WritableFont.ARIAL, 12, WritableFont.BOLD, true);
        WritableCellFormat celda_subtitulo = new WritableCellFormat(fuente_subtitulo); 
        WritableFont fuente_datos = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD, true);
        WritableCellFormat celda_datos = new WritableCellFormat(fuente_datos); 
        
        try{
        
            //Nuestro flujo de salida para apuntar a donde vamos a escribir
            DataOutputStream out=new DataOutputStream(new FileOutputStream(file));
 
            //Representa nuestro archivo en excel y necesita un OutputStream para saber donde va locoar los datos
            WritableWorkbook w = Workbook.createWorkbook(out);
                    
            WritableSheet s = w.createSheet(nombreTab, 0);
 
            j++;
            Label etiqueta_titulo = new Label(0, j, "SAP", celda_titulo); 
            s.addCell(etiqueta_titulo);
                       
            Label etiqueta_subtitulo = new Label(1, j, "DESCRIPCION", celda_subtitulo); 
            s.addCell(etiqueta_subtitulo);
            
            etiqueta_subtitulo = new Label(2, j, "COSTO", celda_subtitulo); 
            s.addCell(etiqueta_subtitulo);
            
            etiqueta_subtitulo = new Label(3, j, "CANT UME", celda_subtitulo); 
            s.addCell(etiqueta_subtitulo);
            
            etiqueta_subtitulo = new Label(4, j, "UME", celda_subtitulo); 
            s.addCell(etiqueta_subtitulo);

            etiqueta_subtitulo = new Label(5, j, "VALOR", celda_subtitulo); 
            s.addCell(etiqueta_subtitulo);

            etiqueta_subtitulo = new Label(6, j, "TASA MES", celda_subtitulo); 
            s.addCell(etiqueta_subtitulo);

            etiqueta_subtitulo = new Label(7, j, "FECHA", celda_subtitulo); 
            s.addCell(etiqueta_subtitulo);

            etiqueta_subtitulo = new Label(8, j, "EQUIPO", celda_subtitulo); 
            s.addCell(etiqueta_subtitulo);

            etiqueta_subtitulo = new Label(9, j, "CANT RECIB", celda_subtitulo); 
            s.addCell(etiqueta_subtitulo);

            etiqueta_subtitulo = new Label(10, j, "CANT DISP", celda_subtitulo); 
            s.addCell(etiqueta_subtitulo);

            etiqueta_subtitulo = new Label(11, j, "CANT SALIDA", celda_subtitulo); 
            s.addCell(etiqueta_subtitulo);

            etiqueta_subtitulo = new Label(12, j, "PRECIO UNITARIO", celda_subtitulo); 
            s.addCell(etiqueta_subtitulo);

            etiqueta_subtitulo = new Label(13, j, "SUBTOTAL", celda_subtitulo); 
            s.addCell(etiqueta_subtitulo);
       
            etiqueta_subtitulo = new Label(14, j, "FLETE", celda_subtitulo); 
            s.addCell(etiqueta_subtitulo);

            etiqueta_subtitulo = new Label(15, j, "MONTO TOTAL", celda_subtitulo); 
            s.addCell(etiqueta_subtitulo);

            etiqueta_subtitulo = new Label(16, j, "ESTATUS", celda_subtitulo); 
            s.addCell(etiqueta_subtitulo);

            etiqueta_subtitulo = new Label(17, j, "CENTRO COSTO", celda_subtitulo); 
            s.addCell(etiqueta_subtitulo);

             etiqueta_subtitulo = new Label(18, j, "FLETE NAC", celda_subtitulo); 
            s.addCell(etiqueta_subtitulo);
            
             etiqueta_subtitulo = new Label(19, j, "TOTAL FLETE", celda_subtitulo); 
            s.addCell(etiqueta_subtitulo);
            
             etiqueta_subtitulo = new Label(20, j, "MONTO TOTAL", celda_subtitulo); 
            s.addCell(etiqueta_subtitulo);
            
             etiqueta_subtitulo = new Label(21, j, "flete en bs", celda_subtitulo); 
            s.addCell(etiqueta_subtitulo);

            j++;
            
                       
            Label etiqueta_datos; 
            
            while(i < tablaentrada.getRowCount()){
                 etiqueta_subtitulo = new Label(0, j, tablaentrada.getValueAt(i,0).toString(), celda_datos); 
                 s.addCell(etiqueta_subtitulo);
                 etiqueta_subtitulo = new Label(1, j, tablaentrada.getValueAt(i,1).toString(), celda_datos); 
                 s.addCell(etiqueta_subtitulo);
                 etiqueta_subtitulo = new Label(2, j, tablaentrada.getValueAt(i,2).toString(), celda_datos); 
                 s.addCell(etiqueta_subtitulo);
                 etiqueta_subtitulo = new Label(3, j, tablaentrada.getValueAt(i,3).toString(), celda_datos); 
                 s.addCell(etiqueta_subtitulo);
                 etiqueta_subtitulo = new Label(4, j, tablaentrada.getValueAt(i,4).toString(), celda_datos); 
                 s.addCell(etiqueta_subtitulo);
                 etiqueta_subtitulo = new Label(5, j, tablaentrada.getValueAt(i,5).toString(), celda_datos); 
                 s.addCell(etiqueta_subtitulo);
                 etiqueta_subtitulo = new Label(6, j, tablaentrada.getValueAt(i,6).toString(), celda_datos); 
                 s.addCell(etiqueta_subtitulo);
                 etiqueta_subtitulo = new Label(7, j, tablaentrada.getValueAt(i,7).toString(), celda_datos); 
                 s.addCell(etiqueta_subtitulo);
                 etiqueta_subtitulo = new Label(8, j, tablaentrada.getValueAt(i,9).toString(), celda_datos); 
                 s.addCell(etiqueta_subtitulo);
                 etiqueta_subtitulo = new Label(9, j, tablaentrada.getValueAt(i,10).toString(), celda_datos); 
                 s.addCell(etiqueta_subtitulo);
                 etiqueta_subtitulo = new Label(10, j, tablaentrada.getValueAt(i,11).toString(), celda_datos); 
                 s.addCell(etiqueta_subtitulo);
                 etiqueta_subtitulo = new Label(11, j, tablaentrada.getValueAt(i,12).toString(), celda_datos); 
                 s.addCell(etiqueta_subtitulo);
                 etiqueta_subtitulo = new Label(12, j, tablaentrada.getValueAt(i,13).toString(), celda_datos); 
                 s.addCell(etiqueta_subtitulo);
                 etiqueta_subtitulo = new Label(13, j, tablaentrada.getValueAt(i,14).toString(), celda_datos); 
                 s.addCell(etiqueta_subtitulo);
                 etiqueta_subtitulo = new Label(14, j, tablaentrada.getValueAt(i,15).toString(), celda_datos); 
                 s.addCell(etiqueta_subtitulo);
                 etiqueta_subtitulo = new Label(15, j, tablaentrada.getValueAt(i,16).toString(), celda_datos); 
                 s.addCell(etiqueta_subtitulo);
                 etiqueta_subtitulo = new Label(16, j, tablaentrada.getValueAt(i,17).toString(), celda_datos); 
                 s.addCell(etiqueta_subtitulo);
                 etiqueta_subtitulo = new Label(17, j, tablaentrada.getValueAt(i,19).toString(), celda_datos); 
                 s.addCell(etiqueta_subtitulo);
                 etiqueta_subtitulo = new Label(18, j, tablaentrada.getValueAt(i,20).toString(), celda_datos); 
                 s.addCell(etiqueta_subtitulo);
                 etiqueta_subtitulo = new Label(19, j, tablaentrada.getValueAt(i,21).toString(), celda_datos); 
                 s.addCell(etiqueta_subtitulo);
                 etiqueta_subtitulo = new Label(20, j, tablaentrada.getValueAt(i,22).toString(), celda_datos); 
                 s.addCell(etiqueta_subtitulo);
                 etiqueta_subtitulo = new Label(21, j, tablaentrada.getValueAt(i,23).toString(), celda_datos); 
                 s.addCell(etiqueta_subtitulo);
                
            
                i++;
                j++;
            }
            
            w.write(); 
            //Cerramos el WritableWorkbook y DataOutputStream
            w.close();
            out.close();
 
 
            //si todo sale bien salimos de aqui con un true :D
            return true;
 
        }catch(IOException | WriteException ex){JOptionPane.showMessageDialog(null, "EL ARCHIVO ESTA ABIERTO. POR FAVOR CERRAR.");}
 
        //Si llegamos hasta aqui algo salio mal
        return false;
}

public Boolean excel_export_auditoria_salidarep() throws IOException, WriteException{
    
        int i=0;
        int j=0;
        WritableFont fuente_titulo = new WritableFont(WritableFont.ARIAL, 14, WritableFont.BOLD, true);
        WritableCellFormat celda_titulo = new WritableCellFormat(fuente_titulo); 
        WritableFont fuente_subtitulo = new WritableFont(WritableFont.ARIAL, 12, WritableFont.BOLD, true);
        WritableCellFormat celda_subtitulo = new WritableCellFormat(fuente_subtitulo); 
        WritableFont fuente_datos = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD, true);
        WritableCellFormat celda_datos = new WritableCellFormat(fuente_datos); 
        
        try{
        
            //Nuestro flujo de salida para apuntar a donde vamos a escribir
            DataOutputStream out=new DataOutputStream(new FileOutputStream(file));
 
            //Representa nuestro archivo en excel y necesita un OutputStream para saber donde va locoar los datos
            WritableWorkbook w = Workbook.createWorkbook(out);
                    
            WritableSheet s = w.createSheet(nombreTab, 0);
 
            j++;
            Label etiqueta_titulo = new Label(0, j, "ID BITACORA", celda_titulo); 
            s.addCell(etiqueta_titulo);
                       
            Label etiqueta_subtitulo = new Label(1, j, "TRANSACCION", celda_subtitulo); 
            s.addCell(etiqueta_subtitulo);
            
            etiqueta_subtitulo = new Label(2, j, "FECHA TRANSACCION", celda_subtitulo); 
            s.addCell(etiqueta_subtitulo);
            
            etiqueta_subtitulo = new Label(3, j, "USUARIO", celda_subtitulo); 
            s.addCell(etiqueta_subtitulo);
            
            etiqueta_subtitulo = new Label(4, j, "SAP", celda_subtitulo); 
            s.addCell(etiqueta_subtitulo);

            etiqueta_subtitulo = new Label(5, j, "CENTRO COSTO", celda_subtitulo); 
            s.addCell(etiqueta_subtitulo);

            etiqueta_subtitulo = new Label(6, j, "EQUIPO", celda_subtitulo); 
            s.addCell(etiqueta_subtitulo);

            etiqueta_subtitulo = new Label(7, j, "FECHA SALIDA", celda_subtitulo); 
            s.addCell(etiqueta_subtitulo);

            etiqueta_subtitulo = new Label(8, j, "CANTIDAD", celda_subtitulo); 
            s.addCell(etiqueta_subtitulo);

            etiqueta_subtitulo = new Label(9, j, "PRECIO UNITARIO", celda_subtitulo); 
            s.addCell(etiqueta_subtitulo);

            etiqueta_subtitulo = new Label(10, j, "MONTO EN $", celda_subtitulo); 
            s.addCell(etiqueta_subtitulo);

            etiqueta_subtitulo = new Label(11, j, "FLETE EN $", celda_subtitulo); 
            s.addCell(etiqueta_subtitulo);

            etiqueta_subtitulo = new Label(12, j, "MONTO TOTAL EN $", celda_subtitulo); 
            s.addCell(etiqueta_subtitulo);



            j++;
            
                       
            Label etiqueta_datos; 
            
            while(i < tablaentrada.getRowCount()){
                 etiqueta_subtitulo = new Label(0, j, tablaentrada.getValueAt(i,0).toString(), celda_datos); 
                 s.addCell(etiqueta_subtitulo);
                 etiqueta_subtitulo = new Label(1, j, tablaentrada.getValueAt(i,1).toString(), celda_datos); 
                 s.addCell(etiqueta_subtitulo);
                 etiqueta_subtitulo = new Label(2, j, tablaentrada.getValueAt(i,2).toString(), celda_datos); 
                 s.addCell(etiqueta_subtitulo);
                 etiqueta_subtitulo = new Label(3, j, tablaentrada.getValueAt(i,3).toString(), celda_datos); 
                 s.addCell(etiqueta_subtitulo);
                 etiqueta_subtitulo = new Label(4, j, tablaentrada.getValueAt(i,4).toString(), celda_datos); 
                 s.addCell(etiqueta_subtitulo);
                 etiqueta_subtitulo = new Label(5, j, tablaentrada.getValueAt(i,5).toString(), celda_datos); 
                 s.addCell(etiqueta_subtitulo);
                 etiqueta_subtitulo = new Label(6, j, tablaentrada.getValueAt(i,6).toString(), celda_datos); 
                 s.addCell(etiqueta_subtitulo);
                 etiqueta_subtitulo = new Label(7, j, tablaentrada.getValueAt(i,7).toString(), celda_datos); 
                 s.addCell(etiqueta_subtitulo);
                 etiqueta_subtitulo = new Label(8, j, tablaentrada.getValueAt(i,8).toString(), celda_datos); 
                 s.addCell(etiqueta_subtitulo);
                 etiqueta_subtitulo = new Label(9, j, tablaentrada.getValueAt(i,9).toString(), celda_datos); 
                 s.addCell(etiqueta_subtitulo);
                 etiqueta_subtitulo = new Label(10, j, tablaentrada.getValueAt(i,10).toString(), celda_datos); 
                 s.addCell(etiqueta_subtitulo);
                 etiqueta_subtitulo = new Label(11, j, tablaentrada.getValueAt(i,11).toString(), celda_datos); 
                 s.addCell(etiqueta_subtitulo);
                 etiqueta_subtitulo = new Label(12, j, tablaentrada.getValueAt(i,12).toString(), celda_datos); 
                 s.addCell(etiqueta_subtitulo);
            
                i++;
                j++;
            }
            
            w.write(); 
            //Cerramos el WritableWorkbook y DataOutputStream
            w.close();
            out.close();
 
 
            //si todo sale bien salimos de aqui con un true :D
            return true;
 
        }catch(IOException | WriteException ex){JOptionPane.showMessageDialog(null, "EL ARCHIVO ESTA ABIERTO. POR FAVOR CERRAR.");}
 
        //Si llegamos hasta aqui algo salio mal
        return false;
}

public Boolean excel_export_auditoria_entrada() throws IOException, WriteException{
    
        int i=0;
        int j=0;
        WritableFont fuente_titulo = new WritableFont(WritableFont.ARIAL, 14, WritableFont.BOLD, true);
        WritableCellFormat celda_titulo = new WritableCellFormat(fuente_titulo); 
        WritableFont fuente_subtitulo = new WritableFont(WritableFont.ARIAL, 12, WritableFont.BOLD, true);
        WritableCellFormat celda_subtitulo = new WritableCellFormat(fuente_subtitulo); 
        WritableFont fuente_datos = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD, true);
        WritableCellFormat celda_datos = new WritableCellFormat(fuente_datos); 
        
        try{
        
            //Nuestro flujo de salida para apuntar a donde vamos a escribir
            DataOutputStream out=new DataOutputStream(new FileOutputStream(file));
 
            //Representa nuestro archivo en excel y necesita un OutputStream para saber donde va locoar los datos
            WritableWorkbook w = Workbook.createWorkbook(out);
                    
            WritableSheet s = w.createSheet(nombreTab, 0);
 
            j++;
            Label etiqueta_titulo = new Label(0, j, "ID BITACORA", celda_titulo); 
            s.addCell(etiqueta_titulo);
                       
            Label etiqueta_subtitulo = new Label(1, j, "TRANSACCION", celda_subtitulo); 
            s.addCell(etiqueta_subtitulo);
            
            etiqueta_subtitulo = new Label(2, j, "USUARIO", celda_subtitulo); 
            s.addCell(etiqueta_subtitulo);
            
            etiqueta_subtitulo = new Label(3, j, "FECHA TRANSACCION", celda_subtitulo); 
            s.addCell(etiqueta_subtitulo);
            
            etiqueta_subtitulo = new Label(4, j, "ID STOCK", celda_subtitulo); 
            s.addCell(etiqueta_subtitulo);

            etiqueta_subtitulo = new Label(5, j, "CENTRO COSTO", celda_subtitulo); 
            s.addCell(etiqueta_subtitulo);

            etiqueta_subtitulo = new Label(6, j, "OC EXCEL", celda_subtitulo); 
            s.addCell(etiqueta_subtitulo);

            etiqueta_subtitulo = new Label(7, j, "NRO FACTURA", celda_subtitulo); 
            s.addCell(etiqueta_subtitulo);

            etiqueta_subtitulo = new Label(8, j, "NRO GUIA", celda_subtitulo); 
            s.addCell(etiqueta_subtitulo);

            etiqueta_subtitulo = new Label(9, j, "FECHA LLEGADA", celda_subtitulo); 
            s.addCell(etiqueta_subtitulo);

            etiqueta_subtitulo = new Label(10, j, "SP", celda_subtitulo); 
            s.addCell(etiqueta_subtitulo);

            etiqueta_subtitulo = new Label(11, j, "USO EQUIPO", celda_subtitulo); 
            s.addCell(etiqueta_subtitulo);

            etiqueta_subtitulo = new Label(12, j, "CODIGO SAP", celda_subtitulo); 
            s.addCell(etiqueta_subtitulo);

            etiqueta_subtitulo = new Label(13, j, "DESCRIPCION MATERIAL", celda_subtitulo); 
            s.addCell(etiqueta_subtitulo);

            etiqueta_subtitulo = new Label(14, j, "NRO PARTE", celda_subtitulo); 
            s.addCell(etiqueta_subtitulo);

            etiqueta_subtitulo = new Label(15, j, "CANTIDAD RECIBIDA", celda_subtitulo); 
            s.addCell(etiqueta_subtitulo);

            etiqueta_subtitulo = new Label(16, j, "PRECIO UNITARIO", celda_subtitulo); 
            s.addCell(etiqueta_subtitulo);

            etiqueta_subtitulo = new Label(17, j, "MONTO FACTURA", celda_subtitulo); 
            s.addCell(etiqueta_subtitulo);

            etiqueta_subtitulo = new Label(18, j, "FLETE ENVIO", celda_subtitulo); 
            s.addCell(etiqueta_subtitulo);

            etiqueta_subtitulo = new Label(19, j, "MONTO TOTAL", celda_subtitulo); 
            s.addCell(etiqueta_subtitulo);

            etiqueta_subtitulo = new Label(20, j, "VALOR DOLAR", celda_subtitulo); 
            s.addCell(etiqueta_subtitulo);

            etiqueta_subtitulo = new Label(21, j, "MONTO BS", celda_subtitulo); 
            s.addCell(etiqueta_subtitulo);

            etiqueta_subtitulo = new Label(22, j, "MONTO FLETE", celda_subtitulo); 
            s.addCell(etiqueta_subtitulo);

            etiqueta_subtitulo = new Label(23, j, "TOTAL GENERAL", celda_subtitulo); 
            s.addCell(etiqueta_subtitulo);

            etiqueta_subtitulo = new Label(24, j, "CANTIDAD USADA", celda_subtitulo); 
            s.addCell(etiqueta_subtitulo);

            etiqueta_subtitulo = new Label(25, j, "CANTIDAD DISPONIBLE", celda_subtitulo); 
            s.addCell(etiqueta_subtitulo);

            

            j++;
            
                       
            Label etiqueta_datos; 
            
            while(i < tablaentrada.getRowCount()){
                 etiqueta_subtitulo = new Label(0, j, tablaentrada.getValueAt(i,0).toString(), celda_datos); 
                 s.addCell(etiqueta_subtitulo);
                 etiqueta_subtitulo = new Label(1, j, tablaentrada.getValueAt(i,1).toString(), celda_datos); 
                 s.addCell(etiqueta_subtitulo);
                 etiqueta_subtitulo = new Label(2, j, tablaentrada.getValueAt(i,2).toString(), celda_datos); 
                 s.addCell(etiqueta_subtitulo);
                 etiqueta_subtitulo = new Label(3, j, tablaentrada.getValueAt(i,3).toString(), celda_datos); 
                 s.addCell(etiqueta_subtitulo);
                 etiqueta_subtitulo = new Label(4, j, tablaentrada.getValueAt(i,4).toString(), celda_datos); 
                 s.addCell(etiqueta_subtitulo);
                 etiqueta_subtitulo = new Label(5, j, tablaentrada.getValueAt(i,5).toString(), celda_datos); 
                 s.addCell(etiqueta_subtitulo);
                 etiqueta_subtitulo = new Label(6, j, tablaentrada.getValueAt(i,6).toString(), celda_datos); 
                 s.addCell(etiqueta_subtitulo);
                 etiqueta_subtitulo = new Label(7, j, tablaentrada.getValueAt(i,7).toString(), celda_datos); 
                 s.addCell(etiqueta_subtitulo);
                 etiqueta_subtitulo = new Label(8, j, tablaentrada.getValueAt(i,8).toString(), celda_datos); 
                 s.addCell(etiqueta_subtitulo);
                 etiqueta_subtitulo = new Label(9, j, tablaentrada.getValueAt(i,9).toString(), celda_datos); 
                 s.addCell(etiqueta_subtitulo);
                 etiqueta_subtitulo = new Label(10, j, tablaentrada.getValueAt(i,10).toString(), celda_datos); 
                 s.addCell(etiqueta_subtitulo);
                 etiqueta_subtitulo = new Label(11, j, tablaentrada.getValueAt(i,11).toString(), celda_datos); 
                 s.addCell(etiqueta_subtitulo);
                 etiqueta_subtitulo = new Label(12, j, tablaentrada.getValueAt(i,12).toString(), celda_datos); 
                 s.addCell(etiqueta_subtitulo);
                 etiqueta_subtitulo = new Label(13, j, tablaentrada.getValueAt(i,13).toString(), celda_datos); 
                 s.addCell(etiqueta_subtitulo);
                 etiqueta_subtitulo = new Label(14, j, tablaentrada.getValueAt(i,14).toString(), celda_datos); 
                 s.addCell(etiqueta_subtitulo);
                 etiqueta_subtitulo = new Label(15, j, tablaentrada.getValueAt(i,15).toString(), celda_datos); 
                 s.addCell(etiqueta_subtitulo);
                 etiqueta_subtitulo = new Label(16, j, tablaentrada.getValueAt(i,16).toString(), celda_datos); 
                 s.addCell(etiqueta_subtitulo);
                 etiqueta_subtitulo = new Label(17, j, tablaentrada.getValueAt(i,17).toString(), celda_datos); 
                 s.addCell(etiqueta_subtitulo);
                 etiqueta_subtitulo = new Label(18, j, tablaentrada.getValueAt(i,18).toString(), celda_datos); 
                 s.addCell(etiqueta_subtitulo);
                 etiqueta_subtitulo = new Label(19, j, tablaentrada.getValueAt(i,19).toString(), celda_datos); 
                 s.addCell(etiqueta_subtitulo);
                 etiqueta_subtitulo = new Label(20, j, tablaentrada.getValueAt(i,20).toString(), celda_datos); 
                 s.addCell(etiqueta_subtitulo);
                 etiqueta_subtitulo = new Label(21, j, tablaentrada.getValueAt(i,21).toString(), celda_datos); 
                 s.addCell(etiqueta_subtitulo);
                 etiqueta_subtitulo = new Label(22, j, tablaentrada.getValueAt(i,22).toString(), celda_datos); 
                 s.addCell(etiqueta_subtitulo);
                 etiqueta_subtitulo = new Label(23, j, tablaentrada.getValueAt(i,23).toString(), celda_datos); 
                 s.addCell(etiqueta_subtitulo);
                 etiqueta_subtitulo = new Label(24, j, tablaentrada.getValueAt(i,24).toString(), celda_datos); 
                 s.addCell(etiqueta_subtitulo);
                 etiqueta_subtitulo = new Label(25, j, tablaentrada.getValueAt(i,25).toString(), celda_datos); 
                 s.addCell(etiqueta_subtitulo);
           
                i++;
                j++;
            }
            
            w.write(); 
            //Cerramos el WritableWorkbook y DataOutputStream
            w.close();
            out.close();
 
 
            //si todo sale bien salimos de aqui con un true :D
            return true;
 
        }catch(IOException | WriteException ex){JOptionPane.showMessageDialog(null, "EL ARCHIVO ESTA ABIERTO. POR FAVOR CERRAR.");}
 
        //Si llegamos hasta aqui algo salio mal
        return false;
}



public Boolean excel_export_auditoria_tallerpkf() throws IOException, WriteException{
    
        int i=0;
        int j=0;
        WritableFont fuente_titulo = new WritableFont(WritableFont.ARIAL, 14, WritableFont.BOLD, true);
        WritableCellFormat celda_titulo = new WritableCellFormat(fuente_titulo); 
        WritableFont fuente_subtitulo = new WritableFont(WritableFont.ARIAL, 12, WritableFont.BOLD, true);
        WritableCellFormat celda_subtitulo = new WritableCellFormat(fuente_subtitulo); 
        WritableFont fuente_datos = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD, true);
        WritableCellFormat celda_datos = new WritableCellFormat(fuente_datos); 
        
        try{
        
            //Nuestro flujo de salida para apuntar a donde vamos a escribir
            DataOutputStream out=new DataOutputStream(new FileOutputStream(file));
 
            //Representa nuestro archivo en excel y necesita un OutputStream para saber donde va locoar los datos
            WritableWorkbook w = Workbook.createWorkbook(out);
                    
            WritableSheet s = w.createSheet(nombreTab, 0);
 
            j++;
            Label etiqueta_titulo = new Label(0, j, "ID BITACORA", celda_titulo); 
            s.addCell(etiqueta_titulo);
                       
            Label etiqueta_subtitulo = new Label(1, j, "TRANSACCION", celda_subtitulo); 
            s.addCell(etiqueta_subtitulo);
            
            etiqueta_subtitulo = new Label(2, j, "USUARIO", celda_subtitulo); 
            s.addCell(etiqueta_subtitulo);
            
            etiqueta_subtitulo = new Label(3, j, "FECHA TRANSACCION", celda_subtitulo); 
            s.addCell(etiqueta_subtitulo);
            
            etiqueta_subtitulo = new Label(4, j, "ID SOLICITUD", celda_subtitulo); 
            s.addCell(etiqueta_subtitulo);

            etiqueta_subtitulo = new Label(5, j, "CEDULA SOLICITANTE", celda_subtitulo); 
            s.addCell(etiqueta_subtitulo);

            etiqueta_subtitulo = new Label(6, j, "NOMBRES", celda_subtitulo); 
            s.addCell(etiqueta_subtitulo);

            etiqueta_subtitulo = new Label(7, j, "EQUIPO", celda_subtitulo); 
            s.addCell(etiqueta_subtitulo);

            etiqueta_subtitulo = new Label(8, j, "CENTRO COSTO", celda_subtitulo); 
            s.addCell(etiqueta_subtitulo);

            etiqueta_subtitulo = new Label(9, j, "COMPONENTE", celda_subtitulo); 
            s.addCell(etiqueta_subtitulo);

            etiqueta_subtitulo = new Label(10, j, "FALLA", celda_subtitulo); 
            s.addCell(etiqueta_subtitulo);

            etiqueta_subtitulo = new Label(11, j, "SERVICIO", celda_subtitulo); 
            s.addCell(etiqueta_subtitulo);

            etiqueta_subtitulo = new Label(12, j, "OBSERVACIONES", celda_subtitulo); 
            s.addCell(etiqueta_subtitulo);

            etiqueta_subtitulo = new Label(13, j, "FECHA SOLICITUD", celda_subtitulo); 
            s.addCell(etiqueta_subtitulo);

            etiqueta_subtitulo = new Label(14, j, "SERVICIO PKF", celda_subtitulo); 
            s.addCell(etiqueta_subtitulo);

            etiqueta_subtitulo = new Label(15, j, "REALIZADO POR", celda_subtitulo); 
            s.addCell(etiqueta_subtitulo);

            etiqueta_subtitulo = new Label(16, j, "COSTO TOTAL(Bs)", celda_subtitulo); 
            s.addCell(etiqueta_subtitulo);

            etiqueta_subtitulo = new Label(17, j, "FECHA SERVICIO", celda_subtitulo); 
            s.addCell(etiqueta_subtitulo);

            etiqueta_subtitulo = new Label(18, j, "ESTATUS", celda_subtitulo); 
            s.addCell(etiqueta_subtitulo);

            etiqueta_subtitulo = new Label(19, j, "ENTREGADO POR", celda_subtitulo); 
            s.addCell(etiqueta_subtitulo);

            etiqueta_subtitulo = new Label(20, j, "NOMBRE ENTREGADO", celda_subtitulo); 
            s.addCell(etiqueta_subtitulo);

            etiqueta_subtitulo = new Label(21, j, "OBSERVACIONES ENTREGADO", celda_subtitulo); 
            s.addCell(etiqueta_subtitulo);

            
            j++;
            
                       
            Label etiqueta_datos; 
            
            while(i < tablaentrada.getRowCount()){
                 etiqueta_subtitulo = new Label(0, j, tablaentrada.getValueAt(i,0).toString(), celda_datos); 
                 s.addCell(etiqueta_subtitulo);
                 etiqueta_subtitulo = new Label(1, j, tablaentrada.getValueAt(i,1).toString(), celda_datos); 
                 s.addCell(etiqueta_subtitulo);
                 etiqueta_subtitulo = new Label(2, j, tablaentrada.getValueAt(i,2).toString(), celda_datos); 
                 s.addCell(etiqueta_subtitulo);
                 etiqueta_subtitulo = new Label(3, j, tablaentrada.getValueAt(i,3).toString(), celda_datos); 
                 s.addCell(etiqueta_subtitulo);
                 etiqueta_subtitulo = new Label(4, j, tablaentrada.getValueAt(i,4).toString(), celda_datos); 
                 s.addCell(etiqueta_subtitulo);
                 etiqueta_subtitulo = new Label(5, j, tablaentrada.getValueAt(i,5).toString(), celda_datos); 
                 s.addCell(etiqueta_subtitulo);
                 etiqueta_subtitulo = new Label(6, j, tablaentrada.getValueAt(i,6).toString(), celda_datos); 
                 s.addCell(etiqueta_subtitulo);
                 etiqueta_subtitulo = new Label(7, j, tablaentrada.getValueAt(i,7).toString(), celda_datos); 
                 s.addCell(etiqueta_subtitulo);
                 etiqueta_subtitulo = new Label(8, j, tablaentrada.getValueAt(i,8).toString(), celda_datos); 
                 s.addCell(etiqueta_subtitulo);
                 etiqueta_subtitulo = new Label(9, j, tablaentrada.getValueAt(i,9).toString(), celda_datos); 
                 s.addCell(etiqueta_subtitulo);
                 etiqueta_subtitulo = new Label(10, j, tablaentrada.getValueAt(i,10).toString(), celda_datos); 
                 s.addCell(etiqueta_subtitulo);
                 etiqueta_subtitulo = new Label(11, j, tablaentrada.getValueAt(i,11).toString(), celda_datos); 
                 s.addCell(etiqueta_subtitulo);
                 etiqueta_subtitulo = new Label(12, j, tablaentrada.getValueAt(i,12).toString(), celda_datos); 
                 s.addCell(etiqueta_subtitulo);
                 etiqueta_subtitulo = new Label(13, j, tablaentrada.getValueAt(i,13).toString(), celda_datos); 
                 s.addCell(etiqueta_subtitulo);
                 etiqueta_subtitulo = new Label(14, j, tablaentrada.getValueAt(i,14).toString(), celda_datos); 
                 s.addCell(etiqueta_subtitulo);
                 etiqueta_subtitulo = new Label(15, j, tablaentrada.getValueAt(i,15).toString(), celda_datos); 
                 s.addCell(etiqueta_subtitulo);
                 etiqueta_subtitulo = new Label(16, j, tablaentrada.getValueAt(i,16).toString(), celda_datos); 
                 s.addCell(etiqueta_subtitulo);
                 try{
                    etiqueta_subtitulo = new Label(17, j, tablaentrada.getValueAt(i,17).toString(), celda_datos); 
                 }
                 catch(NullPointerException ex){
                    etiqueta_subtitulo = new Label(17, j, "", celda_datos);  
                 }
                 s.addCell(etiqueta_subtitulo);
                 etiqueta_subtitulo = new Label(18, j, tablaentrada.getValueAt(i,18).toString(), celda_datos); 
                 s.addCell(etiqueta_subtitulo);
                 etiqueta_subtitulo = new Label(19, j, tablaentrada.getValueAt(i,19).toString(), celda_datos); 
                 s.addCell(etiqueta_subtitulo);
                 etiqueta_subtitulo = new Label(20, j, tablaentrada.getValueAt(i,20).toString(), celda_datos); 
                 s.addCell(etiqueta_subtitulo);
                 etiqueta_subtitulo = new Label(21, j, tablaentrada.getValueAt(i,21).toString(), celda_datos); 
                 s.addCell(etiqueta_subtitulo);

                 
                i++;
                j++;
            }
            
            w.write(); 
            //Cerramos el WritableWorkbook y DataOutputStream
            w.close();
            out.close();
 
 
            //si todo sale bien salimos de aqui con un true :D
            return true;
 
        }catch(IOException | WriteException ex){JOptionPane.showMessageDialog(null, "EL ARCHIVO ESTA ABIERTO. POR FAVOR CERRAR.");}
 
        //Si llegamos hasta aqui algo salio mal
        return false;
}

    

    
public Boolean excel_export_data() throws IOException, WriteException{
    
        int i=0;
        int j=0;
        WritableFont fuente_titulo = new WritableFont(WritableFont.ARIAL, 14, WritableFont.BOLD, true);
        WritableCellFormat celda_titulo = new WritableCellFormat(fuente_titulo); 
        WritableFont fuente_subtitulo = new WritableFont(WritableFont.ARIAL, 12, WritableFont.BOLD, true);
        WritableCellFormat celda_subtitulo = new WritableCellFormat(fuente_subtitulo); 
        WritableFont fuente_datos = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD, true);
        WritableCellFormat celda_datos = new WritableCellFormat(fuente_datos); 
        
        try{
        
            //Nuestro flujo de salida para apuntar a donde vamos a escribir
            DataOutputStream out=new DataOutputStream(new FileOutputStream(file));
 
            //Representa nuestro archivo en excel y necesita un OutputStream para saber donde va locoar los datos
            WritableWorkbook w = Workbook.createWorkbook(out);
                    
            WritableSheet s = w.createSheet(nombreTab, 0);
 
            j++;
            Label etiqueta_titulo = new Label(0, j, "CODIGO", celda_titulo); 
            s.addCell(etiqueta_titulo);
                       
            Label etiqueta_subtitulo = new Label(1, j, "SAP", celda_subtitulo); 
            s.addCell(etiqueta_subtitulo);
            
            etiqueta_subtitulo = new Label(2, j, "CENTRO DE COSTO", celda_subtitulo); 
            s.addCell(etiqueta_subtitulo);
            
            etiqueta_subtitulo = new Label(3, j, "EQUIPO", celda_subtitulo); 
            s.addCell(etiqueta_subtitulo);
            
            etiqueta_subtitulo = new Label(4, j, "DESCRIPCION", celda_subtitulo); 
            s.addCell(etiqueta_subtitulo);

            etiqueta_subtitulo = new Label(5, j, "FECHA", celda_subtitulo); 
            s.addCell(etiqueta_subtitulo);

            etiqueta_subtitulo = new Label(6, j, "CANTIDAD RECIBIDA", celda_subtitulo); 
            s.addCell(etiqueta_subtitulo);

            etiqueta_subtitulo = new Label(7, j, "CANTIDAD DISPONIBLE", celda_subtitulo); 
            s.addCell(etiqueta_subtitulo);

            etiqueta_subtitulo = new Label(8, j, "CANTIDAD SALIDA", celda_subtitulo); 
            s.addCell(etiqueta_subtitulo);

            etiqueta_subtitulo = new Label(9, j, "PRECIO UNITARIO", celda_subtitulo); 
            s.addCell(etiqueta_subtitulo);

            etiqueta_subtitulo = new Label(10, j, "SUB TOTAL", celda_subtitulo); 
            s.addCell(etiqueta_subtitulo);

            etiqueta_subtitulo = new Label(11, j, "FLETE", celda_subtitulo); 
            s.addCell(etiqueta_subtitulo);

            etiqueta_subtitulo = new Label(12, j, "MONTO TOTAL", celda_subtitulo); 
            s.addCell(etiqueta_subtitulo);

            etiqueta_subtitulo = new Label(13, j, "ESTATUS", celda_subtitulo); 
            s.addCell(etiqueta_subtitulo);
       
            j++;
            
                       
            Label etiqueta_datos; 
            
            while(i < tablaentrada.getRowCount()){
                 etiqueta_subtitulo = new Label(0, j, tablaentrada.getValueAt(i,0).toString(), celda_datos); 
                 s.addCell(etiqueta_subtitulo);
                 etiqueta_subtitulo = new Label(1, j, tablaentrada.getValueAt(i,1).toString(), celda_datos); 
                 s.addCell(etiqueta_subtitulo);
                 etiqueta_subtitulo = new Label(2, j, tablaentrada.getValueAt(i,3).toString(), celda_datos); 
                 s.addCell(etiqueta_subtitulo);
                 etiqueta_subtitulo = new Label(3, j, tablaentrada.getValueAt(i,5).toString(), celda_datos); 
                 s.addCell(etiqueta_subtitulo);
                 etiqueta_subtitulo = new Label(4, j, tablaentrada.getValueAt(i,6).toString(), celda_datos); 
                 s.addCell(etiqueta_subtitulo);
                 etiqueta_subtitulo = new Label(5, j, tablaentrada.getValueAt(i,7).toString(), celda_datos); 
                 s.addCell(etiqueta_subtitulo);
                 etiqueta_subtitulo = new Label(6, j, tablaentrada.getValueAt(i,8).toString(), celda_datos); 
                 s.addCell(etiqueta_subtitulo);
                 etiqueta_subtitulo = new Label(7, j, tablaentrada.getValueAt(i,9).toString(), celda_datos); 
                 s.addCell(etiqueta_subtitulo);
                 etiqueta_subtitulo = new Label(8, j, tablaentrada.getValueAt(i,10).toString(), celda_datos); 
                 s.addCell(etiqueta_subtitulo);
                 etiqueta_subtitulo = new Label(9, j, tablaentrada.getValueAt(i,11).toString(), celda_datos); 
                 s.addCell(etiqueta_subtitulo);
                 etiqueta_subtitulo = new Label(10, j, tablaentrada.getValueAt(i,12).toString(), celda_datos); 
                 s.addCell(etiqueta_subtitulo);
                 etiqueta_subtitulo = new Label(11, j, tablaentrada.getValueAt(i,13).toString(), celda_datos); 
                 s.addCell(etiqueta_subtitulo);
                 etiqueta_subtitulo = new Label(12, j, tablaentrada.getValueAt(i,14).toString(), celda_datos); 
                 s.addCell(etiqueta_subtitulo);
                 etiqueta_subtitulo = new Label(13, j, tablaentrada.getValueAt(i,15).toString(), celda_datos); 
                 s.addCell(etiqueta_subtitulo);
            
                i++;
                j++;
            }
            
            w.write(); 
            //Cerramos el WritableWorkbook y DataOutputStream
            w.close();
            out.close();
 
 
            //si todo sale bien salimos de aqui con un true :D
            return true;
 
        }catch(IOException | WriteException ex){JOptionPane.showMessageDialog(null, "EL ARCHIVO ESTA ABIERTO. POR FAVOR CERRAR.");}
 
        //Si llegamos hasta aqui algo salio mal
        return false;
}
    
 public Boolean excel_pkf_export(){
    
        int i=0;
        int j=1;
       
        WritableFont fuente_titulo = new WritableFont(WritableFont.TAHOMA, 12, WritableFont.BOLD, false);
        WritableCellFormat celda_titulo = new WritableCellFormat(fuente_titulo); 
        
        WritableFont fuente_subtitulo = new WritableFont(WritableFont.TAHOMA, 10, WritableFont.BOLD, false);
        WritableCellFormat celda_subtitulo = new WritableCellFormat(fuente_subtitulo); 
        
        WritableFont fuente_datos = new WritableFont(WritableFont.TAHOMA, 9, WritableFont.NO_BOLD, false);
        WritableCellFormat celda_datos = new WritableCellFormat(fuente_datos); 
        
        try{
        
            //Nuestro flujo de salida para apuntar a donde vamos a escribir
            DataOutputStream out=new DataOutputStream(new FileOutputStream(file));
 
            //Representa nuestro archivo en excel y necesita un OutputStream para saber donde va locoar los datos
            WritableWorkbook w = Workbook.createWorkbook(out);
 
 
            //Como excel tiene muchas hojas esta crea o toma la hoja
            //Coloca el nombre del "tab" y el indice del tab
            WritableSheet s = w.createSheet(nombreTab, 0);
 
            Label etiqueta_subtitulo = new Label(0,j, "MATERIAL", celda_subtitulo); 
            s.addCell(etiqueta_subtitulo);
            
            etiqueta_subtitulo = new Label(1,j, "DESCRIPCION", celda_subtitulo); 
            s.addCell(etiqueta_subtitulo);
            
            etiqueta_subtitulo = new Label(2,j, "COSTO", celda_subtitulo); 
            s.addCell(etiqueta_subtitulo);
           
            etiqueta_subtitulo = new Label(3,j, "CANTIDAD", celda_subtitulo); 
            s.addCell(etiqueta_subtitulo);
            
            etiqueta_subtitulo = new Label(4,j, "UME", celda_subtitulo); 
            s.addCell(etiqueta_subtitulo);
            
            etiqueta_subtitulo = new Label(5,j, "COSTO BS", celda_subtitulo); 
            s.addCell(etiqueta_subtitulo);
            
            etiqueta_subtitulo = new Label(6,j, "TASA MES", celda_subtitulo); 
            s.addCell(etiqueta_subtitulo);
            
            etiqueta_subtitulo = new Label(7,j, "FECHA SERVICIO", celda_subtitulo); 
            s.addCell(etiqueta_subtitulo);
            
            etiqueta_subtitulo = new Label(8,j, "PUESTO DE DESCARGA", celda_subtitulo); 
            s.addCell(etiqueta_subtitulo);
                      
            etiqueta_subtitulo = new Label(9,j, "FECHA SOLICITUD", celda_subtitulo); 
            s.addCell(etiqueta_subtitulo);
            
            etiqueta_subtitulo = new Label(10,j, "CENTRO DE COSTO", celda_subtitulo); 
            s.addCell(etiqueta_subtitulo);
            
            etiqueta_subtitulo = new Label(11,j, "ESTATUS", celda_subtitulo); 
            s.addCell(etiqueta_subtitulo);
            
            etiqueta_subtitulo = new Label(12,j, "DURACION SERVICIO(DIAS)", celda_subtitulo); 
            s.addCell(etiqueta_subtitulo);

                   
            while(i < tablaentrada.getRowCount()){
                    j++;
                    etiqueta_subtitulo = new Label(0,j, tablaentrada.getValueAt(i,0).toString(), celda_datos); 
                    s.addCell(etiqueta_subtitulo);
                    
                    etiqueta_subtitulo = new Label(1,j, tablaentrada.getValueAt(i,4).toString(), celda_datos); 
                    s.addCell(etiqueta_subtitulo);
                    
                    etiqueta_subtitulo = new Label(2,j,"PKF", celda_datos); 
                    s.addCell(etiqueta_subtitulo);
                    
                     etiqueta_subtitulo = new Label(3,j, "1", celda_datos); 
                    s.addCell(etiqueta_subtitulo);
                    
                     etiqueta_subtitulo = new Label(4,j, "UN", celda_datos); 
                    s.addCell(etiqueta_subtitulo);
                    
                     etiqueta_subtitulo = new Label(5,j, tablaentrada.getValueAt(i,6).toString(), celda_datos); 
                    s.addCell(etiqueta_subtitulo);
                    
                     etiqueta_subtitulo = new Label(6,j, "", celda_datos); 
                    s.addCell(etiqueta_subtitulo);
                    
                    try{
                        etiqueta_subtitulo = new Label(7,j, tablaentrada.getValueAt(i,1).toString(), celda_datos); 
                        s.addCell(etiqueta_subtitulo);
                    }
                    catch(NullPointerException ex){
                        etiqueta_subtitulo = new Label(7,j, "", celda_datos); 
                        s.addCell(etiqueta_subtitulo);
                    }
                    etiqueta_subtitulo = new Label(8,j, tablaentrada.getValueAt(i,2).toString(), celda_datos); 
                    s.addCell(etiqueta_subtitulo);
                   
                    try{
                        etiqueta_subtitulo = new Label(9,j, tablaentrada.getValueAt(i,8).toString(), celda_datos); 
                        s.addCell(etiqueta_subtitulo);
                    }
                    catch(NullPointerException ex){
                        etiqueta_subtitulo = new Label(9,j, "", celda_datos); 
                        s.addCell(etiqueta_subtitulo);
                    }
                    etiqueta_subtitulo = new Label(10,j, tablaentrada.getValueAt(i,9).toString(), celda_datos); 
                    s.addCell(etiqueta_subtitulo);

                    etiqueta_subtitulo = new Label(11,j, tablaentrada.getValueAt(i,10).toString(), celda_datos); 
                    s.addCell(etiqueta_subtitulo);
                    
                    etiqueta_subtitulo = new Label(12,j, tablaentrada.getValueAt(i,12).toString(), celda_datos); 
                    s.addCell(etiqueta_subtitulo);
                    
                    i++;

            }
            
            w.write(); 
            //Cerramos el WritableWorkbook y DataOutputStream
            w.close();
            out.close();
 
 
            //si todo sale bien salimos de aqui con un true :D
            return true;
 
        }catch(IOException | WriteException ex){JOptionPane.showMessageDialog(null, "EL ARCHIVO ESTA ABIERTO. POR FAVOR CERRAR.");}
 
        //Si llegamos hasta aqui algo salio mal
        return false;
}

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getNombreTab() {
        return nombreTab;
    }

    public void setNombreTab(String nombreTab) {
        this.nombreTab = nombreTab;
    }

    public JTable getTablaentrada() {
        return tablaentrada;
    }

    public void setTablaentrada(JTable tablaentrada) {
        this.tablaentrada = tablaentrada;
    }

    public JTable getTablasalida() {
        return tablasalida;
    }

    public void setTablasalida(JTable tablasalida) {
        this.tablasalida = tablasalida;
    }
    
    
    
}
