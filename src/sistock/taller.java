/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistock;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ruben
 */
public class taller {
    
    private Integer cedula;
    private String nombre;
    private Integer id_equipo;
    private String equipo;
    private String componente;
    private String falla;
    private Integer id_servicio;
    private String servicio;
    private String observaciones;
    private String sql;
    private String fechasolicitud;
    private String estatus;
    private Double costoservicio;
    private Integer id_centrocosto;
    private String centrocosto;
    private String realizadopor;
    private String fechaservicio;
    private String serviciopkf;
    private Integer id_solicitud;
    private String fecha_desde;
    private String fecha_hasta;
    private JTable datos;
    private String empresa;
    private String nombre_entregado;
    private String observacion_entregado;
    private Double costohoraservicio;
    

    public taller(Integer id_equipo, Integer id_centrocosto,String estatus, String fecha_desde, String fecha_hasta,JTable datos,Integer consulta) {
        this.id_equipo = id_equipo;
        this.id_centrocosto = id_centrocosto;
        this.estatus = estatus;
        this.fecha_desde = fecha_desde;
        this.fecha_hasta = fecha_hasta;
        this.datos = datos;
        this.sql = buscar_sql(consulta);
    }

    
    public taller(Integer cedula, String nombre, Integer id_equipo, String componente, String falla, Integer id_servicio, String observaciones, String fechasolicitud, Integer consulta) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.id_equipo = id_equipo;
        this.componente = componente;
        this.falla = falla;
        this.id_servicio = id_servicio;
        this.observaciones = observaciones;
        this.fechasolicitud = fechasolicitud;
        this.sql = buscar_sql(consulta);
    }
    public taller(Integer cedula, String nombre, Integer id_equipo, String componente, String falla, Integer id_servicio, String observaciones, String fechasolicitud, Integer id_solicitud, Integer consulta) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.id_equipo = id_equipo;
        this.componente = componente;
        this.falla = falla;
        this.id_servicio = id_servicio;
        this.observaciones = observaciones;
        this.fechasolicitud = fechasolicitud;
        this.id_solicitud = id_solicitud;
        this.sql = buscar_sql(consulta);
    }
    
    public taller(Integer id_solicitud){
        this.id_solicitud = id_solicitud;
    }
    
    public taller(Integer id_solicitud,Integer consulta){
        this.id_solicitud = id_solicitud;
        this.sql = buscar_sql(consulta);
    }

    public taller(Integer cedula,Integer consulta,String tmp){
        this.cedula = cedula;
        this.sql = buscar_sql(consulta);
    }
    
    public taller(Integer id_solicitud, Integer consulta,Double costoservicio,Double costohoraservicio, String realizadopor, String serviciopkf,String fechaservicio,String estatus,String empresa,String nombre_entregado,String observacion_entregado) {
        this.id_solicitud = id_solicitud;
        this.costoservicio = costoservicio;
        this.costohoraservicio = costohoraservicio;
        this.realizadopor = realizadopor;
        this.serviciopkf = serviciopkf;
        this.fechaservicio = fechaservicio;
        this.estatus = estatus;
        this.empresa = empresa;
        this.nombre_entregado = nombre_entregado;
        this.observacion_entregado = observacion_entregado;
        this.sql = buscar_sql(consulta);
        
    }

   
    
    public Boolean buscaridservicio(){
       
       conexion cnn = new conexion(sql,"buscar");
       boolean consulta = false;
      
       if (cnn.estado){
             try{
                
                    while(cnn.rs.next()){
                        consulta = true;
                        setId_servicio(cnn.rs.getInt(1));
                        setCedula(cnn.rs.getInt(2));
                        setNombre(cnn.rs.getString(3));
                        setEquipo(cnn.rs.getString(4));
                        setComponente(cnn.rs.getString(5));
                        setFalla(cnn.rs.getString(6));
                        setServicio(cnn.rs.getString(7));
                        setObservaciones(cnn.rs.getString(8));
                        try{
                            setFechasolicitud(cnn.rs.getDate(9).toString());
                        }
                        catch(NullPointerException ex){
                            setFechasolicitud("");
                        }
                        setServiciopkf(cnn.rs.getString(10));
                        setRealizadopor(cnn.rs.getString(11));
                        setCostoservicio(cnn.rs.getDouble(12));
                        setCostohoraservicio(cnn.rs.getDouble(13));
                        try{
                            setFechaservicio(cnn.rs.getDate(14).toString());
                        }
                        catch(NullPointerException ex){
                            setFechaservicio("");
                        }
                        setCentrocosto(cnn.rs.getString(15));
                        setEstatus(cnn.rs.getString(16));
                        setEmpresa(cnn.rs.getString(17));
                        setNombre_entregado(cnn.rs.getString(18));
                        setObservacion_entregado(cnn.rs.getString(19));
                    }
                                      
                    cnn.cerrar(); 
                   
                    return consulta;
             }
             catch (SQLException err) {
                JOptionPane.showMessageDialog(null, err.getMessage());
                cnn.cerrar();
                return consulta;
             }
        }  
       return consulta;
    }
    
    public Boolean actualizar_registrotaller(){
        
        conexion cnn = new conexion(sql,"");
        
        if (cnn.estado){
            JOptionPane.showMessageDialog(null, "ACTUALIZACIÓN DEL REGISTRO A TALLER SATISFACTORIA");
            cnn.cerrar();
            return true;
        }
        else{
            JOptionPane.showMessageDialog(null, "ERROR EN LA ACTUALIZACIÓN DEL REGISTRO A TALLER");
            cnn.cerrar();
            return false;
        }
    
        
    }
    public Boolean buscarnombresolicitante() throws SQLException{
        
                      
        conexion cnn = new conexion(sql,"buscar");
       
        if (cnn.estado){
            if (cnn.rs.next()){
                setNombre(cnn.rs.getString(1));
                return true;
            }
            return false;
        }      
         
        return false;
    }
    
    public Integer actualizar_registro() throws SQLException{
        
                      
        conexion cnn = new conexion(sql,"");
       
        if (cnn.estado){
            cnn.cerrar();
            cnn = new conexion(buscar_sql(2),"buscar");
            
            if (cnn.estado){
                if (cnn.rs.next()){
                    setId_solicitud(cnn.rs.getInt(1));
                }
            }
        
            cnn.cerrar();
            JOptionPane.showMessageDialog(null, "ACTUALIZACIÓN DEL REGISTRO A TALLER SATISFACTORIA");
            
            return id_solicitud;
        }
        else{
            JOptionPane.showMessageDialog(null, "ERROR EN LA ACTUALIZACIÓN DEL REGISTRO A TALLER");
            cnn.cerrar();
            return 0;
        }
       
    }
    
    
    
    
     public String buscar_sql(Integer sql) {
        String consulta="";
        
        switch (sql){
            case 1:
                 consulta = "INSERT INTO tbl_tallerpkf VALUES(DEFAULT," + cedula + ",'"  + nombre + "'," + id_equipo + ",'" + componente + "','" + falla + "'," + id_servicio + ",'" + observaciones + "','" + fechasolicitud + "','','',0,0,null,'PENDIENTE','','','','" + frm_principal.nombre + "');";
       
                break;  
            case 2:
                 consulta = "SELECT MAX(id_solicitud) as id_solicitud FROM tbl_tallerpkf;";
       
                break;   
                
            case 3:
                
                consulta = "SELECT a.id_solicitud,a.fecha_solicitud,b.equipo,a.componente,a.falla,c.descripcion,concat(d.id_centrocosto,'-',d.centrocosto) as centrocosto,a.cedula,a.nombres,a.observaciones ";                
                consulta+= "FROM tbl_tallerpkf a ";
                consulta+= "INNER JOIN tbl_equipo b ON ";
                consulta+= "a.fk_equipo = b.id_equipo ";
                consulta+= "INNER JOIN tbl_servicio c ON ";
                consulta+= "a.fk_servicio = c.id_servicio ";
                consulta+= "INNER JOIN tbl_centrocosto d ON ";
                consulta+= "b.fk_centrocosto = d.id_centrocosto ";
                consulta+= "WHERE a.id_solicitud = " + getId_solicitud() + ";";
       
                break;    
                
            case 4:
                
                consulta = "SELECT id_solicitud, fecha_solicitud,b.equipo,falla,servicio_pkf,realizadopor,costo_total,costohoras, fecha_servicio,d.centrocosto,estatus,observaciones ";
                consulta += "FROM tbl_tallerpkf a ";
                consulta += "INNER JOIN tbl_equipo b ON ";
                consulta += "a.fk_equipo = b.id_equipo ";
                consulta += "INNER JOIN tbl_servicio c ON ";
                consulta += "a.fk_servicio = c.id_servicio ";
                consulta += "INNER JOIN tbl_centrocosto d ON ";
                consulta += "b.fk_centrocosto = d.id_centrocosto ";
                consulta += "WHERE 1=1 ";

                if (!fecha_desde.equals("")){
                    consulta += " AND a.fecha_solicitud BETWEEN '" + fecha_desde + "' AND '" + fecha_hasta + "'";
                }
                if (!id_centrocosto.equals(0)){
                    consulta += " AND b.fk_centrocosto = " + id_centrocosto;
                }    
                if (!id_equipo.equals(0)){
                    consulta += " AND a.fk_equipo = " + id_equipo;        
                }
                if (!estatus.equals("Seleccione...")){
                    consulta += " AND estatus = '" + estatus + "'";        
                }
                
                consulta += " ORDER BY a.fecha_solicitud;";
                //System.out.println(consulta);
                break;    
             case 5:
                consulta = " SELECT id_solicitud, cedula, nombres, b.equipo, componente, falla, c.descripcion, observaciones, fecha_solicitud, servicio_pkf, realizadopor, costo_total, costohoras, fecha_servicio,concat(d.id_centrocosto,'-',d.centrocosto) as centrocosto, estatus,empresa_entregado,nombre_entregado,observacion_entregado ";
                consulta += " FROM tbl_tallerpkf a ";
                consulta += " INNER JOIN tbl_equipo b ON ";
                consulta += " a.fk_equipo = b.id_equipo ";
                consulta += " INNER JOIN tbl_servicio c ON ";
                consulta += " a.fk_servicio = c.id_servicio ";
                consulta += " INNER JOIN tbl_centrocosto d ON ";
                consulta += " b.fk_centrocosto = d.id_centrocosto ";
                consulta += " WHERE id_solicitud = " + id_solicitud + ";";
        
                break;
                
             case 6:
                 consulta = "UPDATE tbl_tallerpkf ";
                 consulta += " SET servicio_pkf='" + getServiciopkf() + "',realizadopor='" + getRealizadopor() + "',costo_total=" + getCostoservicio() + ",costohoras=" + getCostohoraservicio() + ",fecha_servicio='" + getFechaservicio() + "',estatus='" + getEstatus() + "',empresa_entregado='" + getEmpresa() + "',nombre_entregado='" + getNombre_entregado() + "',observacion_entregado='" + getObservacion_entregado() + "',usuario= '" + frm_principal.nombre + "'";
                 consulta += " WHERE id_solicitud = " + getId_solicitud() +";";
                  
                 break;
                 
            case 7:
                 consulta = "UPDATE tbl_tallerpkf ";
                 consulta += " SET cedula='" + getCedula() + "',nombres='" + getNombre() + "',fk_equipo=" + getId_equipo() + ",fk_servicio=" + getId_servicio() + ",componente='" + getComponente() + "',falla='" + getFalla() + "',observaciones='" + getObservaciones() + "',usuario = '" + frm_principal.nombre + "'";
                 consulta += " WHERE id_solicitud = " + getId_solicitud() +";";
                  
                 break; 
            
            case 8:
                                   
                consulta = "SELECT a.id_solicitud,a.fecha_solicitud,b.equipo,a.componente,a.falla,c.descripcion,concat(d.id_centrocosto,'-',d.centrocosto) as centrocosto ,a.cedula,a.nombres,a.observaciones,a.fecha_servicio,a.servicio_pkf,a.realizadopor,a.costo_total,a.costohoras,a.empresa_entregado,a.nombre_entregado,a.observacion_entregado "; 
                consulta += " FROM tbl_tallerpkf a ";
                consulta += " INNER JOIN tbl_equipo b ON ";
                consulta += " a.fk_equipo = b.id_equipo ";
                consulta += " INNER JOIN tbl_servicio c ON ";
                consulta += " a.fk_servicio = c.id_servicio ";
                consulta += " INNER JOIN tbl_centrocosto d ON ";
                consulta += " b.fk_centrocosto = d.id_centrocosto ";
                consulta += " WHERE a.id_solicitud= " + getId_solicitud();

                break;    
           
            case 9: consulta = "SELECT nombres FROM tbl_tallerpkf ";
                    consulta += "WHERE cedula = " + getCedula();
                    break;
    
                
        }
        return consulta;
         
    }
     
    public void generar_solicitudpkf() throws DocumentException, FileNotFoundException, BadElementException, IOException {
        String archivo;
        Document document = new Document();
        PdfPTable detalle_reporte = new PdfPTable(6);
        PdfPTable resumen_reporte = new PdfPTable(2);
        String cadena;
       
        
        document.setMargins(0, 5, 20, 5);
        
        float[] widths = new float[] { 23f, 23f, 23f, 23f, 23f, 23f};
        detalle_reporte.setWidths(widths);
        detalle_reporte.setWidthPercentage(90);
        
        float[] widths1 = new float[] { 28f, 110f};
        resumen_reporte.setWidths(widths1);
        resumen_reporte.setWidthPercentage(90);
        
        
        archivo = "serviciosataller/pkf_"+ id_solicitud + ".pdf";
        
        PdfWriter.getInstance(document,new FileOutputStream(archivo));
        document.open();
    
         
        try{
            Image encabezado = Image.getInstance("imagenes/semaca.png");
            encabezado.scaleToFit(68,36);
            encabezado.setAlignment(encabezado.ALIGN_LEFT);
            document.add(encabezado);
        
        }
        catch(FileNotFoundException e){
            
        }
        
        //ENCABEZADO
        
        cadena = "REGISTRO DE SERVICIO SOLICITADO A PKF";
      
        Paragraph texto = new Paragraph(cadena,FontFactory.getFont("Verdana", 12, Font.ITALIC));
               
        texto.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(texto);
        document.add(new Paragraph(" "));

         conexion cnn = new conexion(buscar_sql(3),"buscar");
       
            if (cnn.estado){
            
                try {
                    if(cnn.rs.next()){
        
                        cadena = "NUMERO DE SOLICITUD: " + String.valueOf(cnn.rs.getInt(1));
                        
                        texto = new Paragraph(cadena,FontFactory.getFont("Verdana", 10, Font.ITALIC));
               
                        texto.setAlignment(Paragraph.ALIGN_RIGHT);
                        document.add(texto);
                        document.add(new Paragraph(" "));    
        
                        PdfPCell dato = new PdfPCell (new Phrase("FECHA",FontFactory.getFont("Verdana",8,Font.PLAIN, BaseColor.BLACK)));
                        detalle_reporte.addCell(dato);  
        
                        dato = new PdfPCell (new Phrase("EQUIPO",FontFactory.getFont("Verdana",8,Font.PLAIN, BaseColor.BLACK)));
                        detalle_reporte.addCell(dato);  

                        dato = new PdfPCell (new Phrase("COMPONENTE",FontFactory.getFont("Verdana",8,Font.PLAIN, BaseColor.BLACK)));
                        detalle_reporte.addCell(dato);  

                        dato = new PdfPCell (new Phrase("FALLA PRESENTADA",FontFactory.getFont("Verdana",8,Font.PLAIN, BaseColor.BLACK)));
                        detalle_reporte.addCell(dato); 
        
                        dato = new PdfPCell (new Phrase("SERVICIO SOLICITADO",FontFactory.getFont("Verdana",8,Font.PLAIN, BaseColor.BLACK)));
                        detalle_reporte.addCell(dato); 
        
                        dato = new PdfPCell (new Phrase("CENTRO DE COSTO",FontFactory.getFont("Verdana",8,Font.PLAIN, BaseColor.BLACK)));
                        detalle_reporte.addCell(dato); 
                          
                        dato = new PdfPCell (new Phrase(funciones.fecha_bd_usuario(String.valueOf(cnn.rs.getDate(2)),1),FontFactory.getFont("Verdana",8,Font.PLAIN, BaseColor.BLACK)));
                        dato.setVerticalAlignment(Element.ALIGN_CENTER);

                        detalle_reporte.addCell(dato);  
  
                        dato = new PdfPCell (new Phrase(cnn.rs.getString(3),FontFactory.getFont("Verdana",8,Font.PLAIN, BaseColor.BLACK)));
                        dato.setVerticalAlignment(Element.ALIGN_CENTER);
                        
                        detalle_reporte.addCell(dato);  
                
                        dato = new PdfPCell (new Phrase(cnn.rs.getString(4),FontFactory.getFont("Verdana",8,Font.PLAIN, BaseColor.BLACK)));
                        dato.setVerticalAlignment(Element.ALIGN_CENTER);

                        detalle_reporte.addCell(dato);  
                   
                        dato = new PdfPCell (new Phrase(cnn.rs.getString(5),FontFactory.getFont("Verdana",8,Font.PLAIN, BaseColor.BLACK)));
                        dato.setVerticalAlignment(Element.ALIGN_CENTER);
                        
                        detalle_reporte.addCell(dato);  
                                                              
                        dato = new PdfPCell (new Phrase(cnn.rs.getString(6),FontFactory.getFont("Verdana",8,Font.PLAIN, BaseColor.BLACK)));
                        dato.setVerticalAlignment(Element.ALIGN_CENTER);
                        
                        detalle_reporte.addCell(dato);
                        
                        dato = new PdfPCell (new Phrase(cnn.rs.getString(7),FontFactory.getFont("Verdana",8,Font.PLAIN, BaseColor.BLACK)));
                        dato.setVerticalAlignment(Element.ALIGN_CENTER);
                        
                        detalle_reporte.addCell(dato);
                        cedula = cnn.rs.getInt(8);
                        nombre= cnn.rs.getString(9);
                        observaciones = cnn.rs.getString(10);
                    }
                    document.add(detalle_reporte);
                } 
                catch (SQLException ex) {
                    Logger.getLogger(taller.class.getName()).log(Level.SEVERE, null, ex);
                    cnn.cerrar();
                }
            }
            else{
                JOptionPane.showMessageDialog(null,"ERROR DE CONEXION","SISTOCK", JOptionPane.ERROR_MESSAGE,null);
                cnn.cerrar();
            }    
                
        texto = new Paragraph("NOMBRE DEL SOLICITANTE: " + cedula + " - " + nombre,FontFactory.getFont("Verdana",10, Font.PLAIN));
        
        texto.setAlignment(Paragraph.ALIGN_LEFT);  
        document.add(texto);
       
        texto = new Paragraph("OBSERVACIONES: " + observaciones,FontFactory.getFont("Verdana",10, Font.PLAIN));
        
        texto.setAlignment(Paragraph.ALIGN_LEFT);  
        document.add(texto);
        
        document.add(new Paragraph(" "));
        document.add(new Paragraph(" "));
        document.add(new Paragraph(" "));
        
        cadena = "SERVICIO REALIZADO";
        
      
        texto = new Paragraph(cadena,FontFactory.getFont("Verdana", 12, Font.ITALIC));
               
        texto.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(texto);
         document.add(new Paragraph(" "));
       
        PdfPCell dato2 = new PdfPCell (new Phrase("EMPRESA: ",FontFactory.getFont("Verdana",10, Font.PLAIN, BaseColor.BLACK)));
        resumen_reporte.addCell(dato2); 
        
        dato2 = new PdfPCell (new Phrase(" ",FontFactory.getFont("Verdana",10, Font.PLAIN, BaseColor.BLACK)));
        resumen_reporte.addCell(dato2); 
        
        dato2 = new PdfPCell (new Phrase("SERVICIO REALIZADO: ",FontFactory.getFont("Verdana",10, Font.PLAIN, BaseColor.BLACK)));
        resumen_reporte.addCell(dato2); 
        cadena = "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"
                +"0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"
                +"0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000";
        dato2 = new PdfPCell (new Phrase(cadena,FontFactory.getFont("Verdana",10, Font.PLAIN, BaseColor.WHITE)));
        resumen_reporte.addCell(dato2); 
        
        dato2 = new PdfPCell (new Phrase("REALIZADO POR: ",FontFactory.getFont("Verdana",10, Font.PLAIN, BaseColor.BLACK)));
        resumen_reporte.addCell(dato2); 
        
        dato2 = new PdfPCell (new Phrase(" ",FontFactory.getFont("Verdana",10, Font.PLAIN, BaseColor.BLACK)));
        resumen_reporte.addCell(dato2);
        
        dato2 = new PdfPCell (new Phrase("COSTO EN BS: ",FontFactory.getFont("Verdana",10, Font.PLAIN, BaseColor.BLACK)));
        resumen_reporte.addCell(dato2); 
        
        dato2 = new PdfPCell (new Phrase(" ",FontFactory.getFont("Verdana",10, Font.PLAIN, BaseColor.BLACK)));
        resumen_reporte.addCell(dato2);
        
        dato2 = new PdfPCell (new Phrase("COSTO HORA BS: ",FontFactory.getFont("Verdana",10, Font.PLAIN, BaseColor.BLACK)));
        resumen_reporte.addCell(dato2); 
        
        dato2 = new PdfPCell (new Phrase(" ",FontFactory.getFont("Verdana",10, Font.PLAIN, BaseColor.BLACK)));
        resumen_reporte.addCell(dato2);
        
       dato2 = new PdfPCell (new Phrase("OBSERVACIONES: ",FontFactory.getFont("Verdana",10, Font.PLAIN, BaseColor.BLACK)));
        resumen_reporte.addCell(dato2); 
        
        dato2 = new PdfPCell (new Phrase(" ",FontFactory.getFont("Verdana",10, Font.PLAIN, BaseColor.BLACK)));
        resumen_reporte.addCell(dato2);
        
        
        document.add(resumen_reporte);
        
        
        document.close();
        
         try{
             File archivo_abrir = new File(archivo);
             Desktop.getDesktop().open(archivo_abrir);
         }
         catch(Exception e){
             JOptionPane.showMessageDialog(null, "ERROR ABRIR ARCHIVO DE SOLICITUD");
         
         }     
    }
    
    public void generar_solicitudejecutadopkf() throws DocumentException, FileNotFoundException, BadElementException, IOException {
        String archivo;
        Document document = new Document();
        PdfPTable detalle_reporte = new PdfPTable(6);
        PdfPTable detalle_reporte_2 = new PdfPTable(5);
        
        String cadena;
        
        
        document.setMargins(0, 5, 20, 5);
        
        float[] widths = new float[] { 23f, 23f, 23f, 23f, 23f, 23f};
        detalle_reporte.setWidths(widths);
        detalle_reporte.setWidthPercentage(90);
        
        float[] widths2 = new float[] { 28f, 28f, 28f, 28f, 28f};
        detalle_reporte_2.setWidths(widths2);
        detalle_reporte_2.setWidthPercentage(90);
        
        
        archivo = "serviciosataller/pkf_"+ id_solicitud + ".pdf";
        
        PdfWriter.getInstance(document,new FileOutputStream(archivo));
        document.open();
    
         
        try{
            Image encabezado = Image.getInstance("imagenes/semaca.png");
            encabezado.scaleToFit(68,36);
            encabezado.setAlignment(encabezado.ALIGN_LEFT);
            document.add(encabezado);
        
        }
        catch(FileNotFoundException e){
            
        }
        
        //ENCABEZADO
        
        cadena = "REGISTRO DE SERVICIO SOLICITADO A PKF";
      
        Paragraph texto = new Paragraph(cadena,FontFactory.getFont("Verdana", 12, Font.ITALIC));
               
        texto.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(texto);
        document.add(new Paragraph(" "));

         conexion cnn = new conexion(buscar_sql(8),"buscar");
       
        if (cnn.estado){
            
           try {
               if(cnn.rs.next()){
        
                    cadena = "NUMERO DE SOLICITUD: " + String.valueOf(cnn.rs.getInt(1));
                        
                    texto = new Paragraph(cadena,FontFactory.getFont("Verdana", 10, Font.ITALIC));
               
                    texto.setAlignment(Paragraph.ALIGN_RIGHT);
                    document.add(texto);
                           
                    PdfPCell dato = new PdfPCell (new Phrase("FECHA",FontFactory.getFont("Verdana",8,Font.PLAIN, BaseColor.BLACK)));
                    detalle_reporte.addCell(dato);  
        
                    dato = new PdfPCell (new Phrase("EQUIPO",FontFactory.getFont("Verdana",8,Font.PLAIN, BaseColor.BLACK)));
                    detalle_reporte.addCell(dato);  

                    dato = new PdfPCell (new Phrase("COMPONENTE",FontFactory.getFont("Verdana",8,Font.PLAIN, BaseColor.BLACK)));
                    detalle_reporte.addCell(dato);  

                    dato = new PdfPCell (new Phrase("FALLA PRESENTADA",FontFactory.getFont("Verdana",8,Font.PLAIN, BaseColor.BLACK)));
                    detalle_reporte.addCell(dato); 
        
                    dato = new PdfPCell (new Phrase("SERVICIO SOLICITADO",FontFactory.getFont("Verdana",8,Font.PLAIN, BaseColor.BLACK)));
                    detalle_reporte.addCell(dato); 
        
                    dato = new PdfPCell (new Phrase("CENTRO DE COSTO",FontFactory.getFont("Verdana",8,Font.PLAIN, BaseColor.BLACK)));
                    detalle_reporte.addCell(dato); 

//                        document.add(new Paragraph(" "));
                          
                    dato = new PdfPCell (new Phrase(funciones.fecha_bd_usuario(String.valueOf(cnn.rs.getDate(2)),1),FontFactory.getFont("Verdana",8,Font.PLAIN, BaseColor.BLACK)));
                    dato.setVerticalAlignment(Element.ALIGN_CENTER);

                    detalle_reporte.addCell(dato);  
  
                    dato = new PdfPCell (new Phrase(cnn.rs.getString(3),FontFactory.getFont("Verdana",8,Font.PLAIN, BaseColor.BLACK)));
                    dato.setVerticalAlignment(Element.ALIGN_CENTER);
                        
                    detalle_reporte.addCell(dato);  
                
                    dato = new PdfPCell (new Phrase(cnn.rs.getString(4),FontFactory.getFont("Verdana",8,Font.PLAIN, BaseColor.BLACK)));
                    dato.setVerticalAlignment(Element.ALIGN_CENTER);

                    detalle_reporte.addCell(dato);  
                   
                    dato = new PdfPCell (new Phrase(cnn.rs.getString(5),FontFactory.getFont("Verdana",8,Font.PLAIN, BaseColor.BLACK)));
                    dato.setVerticalAlignment(Element.ALIGN_CENTER);
                        
                    detalle_reporte.addCell(dato);  
                                                              
                    dato = new PdfPCell (new Phrase(cnn.rs.getString(6),FontFactory.getFont("Verdana",8,Font.PLAIN, BaseColor.BLACK)));
                    dato.setVerticalAlignment(Element.ALIGN_CENTER);
                        
                    detalle_reporte.addCell(dato);
                        
                    dato = new PdfPCell (new Phrase(cnn.rs.getString(7),FontFactory.getFont("Verdana",8,Font.PLAIN, BaseColor.BLACK)));
                    dato.setVerticalAlignment(Element.ALIGN_CENTER);
                        
                    detalle_reporte.addCell(dato);
                    cedula = cnn.rs.getInt(8);
                    nombre= cnn.rs.getString(9);
                    observaciones = cnn.rs.getString(10);
                   
                    document.add(detalle_reporte);    
                    
                    texto = new Paragraph("NOMBRE DEL SOLICITANTE: " + cedula + " - " + nombre,FontFactory.getFont("Verdana",8, Font.PLAIN));
        
                    texto.setAlignment(Paragraph.ALIGN_LEFT);  
                    document.add(texto);
       
                    texto = new Paragraph("OBSERVACIONES: " + observaciones,FontFactory.getFont("Verdana",8, Font.PLAIN));
        
                    texto.setAlignment(Paragraph.ALIGN_LEFT);  
                    document.add(texto);
  
        
                    //SERVICIO REALIZADO EN EL TALLER
        
                    cadena = "REGISTRO DE SERVICIO REALIZADO EN EL TALLER";
      
                    texto = new Paragraph(cadena,FontFactory.getFont("Verdana", 10, Font.ITALIC));
               
                    texto.setAlignment(Paragraph.ALIGN_CENTER);
                    document.add(texto);
                    document.add(new Paragraph(" "));
        
                    dato = new PdfPCell (new Phrase("FECHA DE SERVICIO",FontFactory.getFont("Verdana",8,Font.PLAIN, BaseColor.BLACK)));
                    detalle_reporte_2.addCell(dato);  
        
                    dato = new PdfPCell (new Phrase("FALLA CORREGIDA",FontFactory.getFont("Verdana",8,Font.PLAIN, BaseColor.BLACK)));
                    detalle_reporte_2.addCell(dato);  

                    dato = new PdfPCell (new Phrase("REALIZADO POR",FontFactory.getFont("Verdana",8,Font.PLAIN, BaseColor.BLACK)));
                    detalle_reporte_2.addCell(dato); 
                        
                    dato = new PdfPCell (new Phrase("COSTO TOTAL(BS)",FontFactory.getFont("Verdana",8,Font.PLAIN, BaseColor.BLACK)));
                    detalle_reporte_2.addCell(dato);
                   
                    dato = new PdfPCell (new Phrase("COSTO HORAS(BS)",FontFactory.getFont("Verdana",8,Font.PLAIN, BaseColor.BLACK)));
                    detalle_reporte_2.addCell(dato);
                          
                    dato = new PdfPCell (new Phrase(funciones.fecha_bd_usuario(cnn.rs.getString(11),1),FontFactory.getFont("Verdana",8,Font.PLAIN, BaseColor.BLACK)));
                    dato.setVerticalAlignment(Element.ALIGN_CENTER);
                        
                    detalle_reporte_2.addCell(dato);  
                
                    dato = new PdfPCell (new Phrase(cnn.rs.getString(12),FontFactory.getFont("Verdana",8,Font.PLAIN, BaseColor.BLACK)));
                    dato.setVerticalAlignment(Element.ALIGN_CENTER);

                    detalle_reporte_2.addCell(dato);  
                   
                    dato = new PdfPCell (new Phrase(cnn.rs.getString(13),FontFactory.getFont("Verdana",8,Font.PLAIN, BaseColor.BLACK)));
                    dato.setVerticalAlignment(Element.ALIGN_CENTER);
                        
                    detalle_reporte_2.addCell(dato);  
                                                              
                    dato = new PdfPCell (new Phrase(String.valueOf(cnn.rs.getDouble(14)),FontFactory.getFont("Verdana",8,Font.PLAIN, BaseColor.BLACK)));
                    dato.setVerticalAlignment(Element.ALIGN_CENTER);
                    
                    detalle_reporte_2.addCell(dato);  
                    
                    dato = new PdfPCell (new Phrase(String.valueOf(cnn.rs.getDouble(15)),FontFactory.getFont("Verdana",8,Font.PLAIN, BaseColor.BLACK)));
                    dato.setVerticalAlignment(Element.ALIGN_CENTER);
                    
                    detalle_reporte_2.addCell(dato);
                        
                   
                    empresa = cnn.rs.getString(16);
                    nombre_entregado= cnn.rs.getString(17);
                    observacion_entregado = cnn.rs.getString(18);
                   
                    document.add(detalle_reporte_2);    
                    
                    texto = new Paragraph("ENTREGADO POR: " + empresa + " - " + nombre_entregado,FontFactory.getFont("Verdana",8, Font.PLAIN));
        
                    texto.setAlignment(Paragraph.ALIGN_LEFT);  
                    document.add(texto);
       
                    texto = new Paragraph("OBSERVACIONES DE ENTREGA: " + observacion_entregado,FontFactory.getFont("Verdana",8, Font.PLAIN));
        
                    texto.setAlignment(Paragraph.ALIGN_LEFT);  
                    document.add(texto);
                    
              }
            }   
            catch (SQLException ex) {
                Logger.getLogger(taller.class.getName()).log(Level.SEVERE, null, ex);
                cnn.cerrar();
            }
        }
        else{
            JOptionPane.showMessageDialog(null,"ERROR DE CONEXION","SISTOCK", JOptionPane.ERROR_MESSAGE,null);
            cnn.cerrar();
        }
        
        document.close();
        
         try{
             File archivo_abrir = new File(archivo);
             Desktop.getDesktop().open(archivo_abrir);
         }
         catch(Exception e){
             JOptionPane.showMessageDialog(null, "ERROR ABRIR ARCHIVO DE SOLICITUD");
         
         }     
    }
    
    public Boolean consultarestatustaller() throws ParseException{
       DefaultTableModel modelotablaentrada = (DefaultTableModel) datos.getModel();
       int i=0;
       int dias;
       SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
       Date fechaInicial;
       Date fechaFinal;
       
       modelotablaentrada.setRowCount(0);
       
       conexion cnn = new conexion(sql,"buscar");
      
       if (cnn.estado){
             try{
                
                    while(cnn.rs.next()){
                        modelotablaentrada.addRow(new Object[]{
                        cnn.rs.getInt(1),
                        cnn.rs.getDate(2),
                        cnn.rs.getString(3),
                        cnn.rs.getString(4),
                        cnn.rs.getString(5),
                        cnn.rs.getString(6),
                        cnn.rs.getDouble(7),
                        cnn.rs.getInt(8),
                        cnn.rs.getDate(9),
                        cnn.rs.getString(10),
                        cnn.rs.getString(11),
                        cnn.rs.getString(12)
                        
                        });  
                        
                        modelotablaentrada.setValueAt(funciones.fecha_bd_usuario(modelotablaentrada.getValueAt(i, 1).toString(),1), i, 1);
                        
                        try{
                            modelotablaentrada.setValueAt(funciones.fecha_bd_usuario(modelotablaentrada.getValueAt(i, 8).toString(),1), i, 8);
                            fechaInicial=dateFormat.parse(funciones.fecha_bd_usuario(modelotablaentrada.getValueAt(i, 1).toString(),2));
                            fechaFinal=dateFormat.parse(funciones.fecha_bd_usuario(modelotablaentrada.getValueAt(i, 8).toString(),2));

                            dias = (int) ((fechaFinal.getTime()-fechaInicial.getTime())/86400000);
                            
                        }
                        catch(NullPointerException ex){
                            fechaInicial=dateFormat.parse(funciones.fecha_bd_usuario(modelotablaentrada.getValueAt(i, 1).toString(),2));
                            fechaFinal = dateFormat.parse(funciones.fecha_bd_usuario(funciones.getfechacalendario(),2));
                            dias = (int) ((fechaFinal.getTime()-fechaInicial.getTime())/86400000);
                        }
                         
                        modelotablaentrada.setValueAt(dias, i, 12);
                        i++;  
                    }
                    
                    
                   cnn.cerrar(); 
                   
                    return true;
             }
             catch (SQLException err) {
                JOptionPane.showMessageDialog(null, err.getMessage());
                cnn.cerrar();
                return false;
             }
                    

        }
       return false;
    }

    public Double getCostohoraservicio() {
        return costohoraservicio;
    }

    public void setCostohoraservicio(Double costohoraservicio) {
        this.costohoraservicio = costohoraservicio;
    }

    
    
    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getNombre_entregado() {
        return nombre_entregado;
    }

    public void setNombre_entregado(String nombre_entregado) {
        this.nombre_entregado = nombre_entregado;
    }

    public String getObservacion_entregado() {
        return observacion_entregado;
    }

    public void setObservacion_entregado(String observacion_entregado) {
        this.observacion_entregado = observacion_entregado;
    }

    
    public String getFecha_desde() {
        return fecha_desde;
    }

    public void setFecha_desde(String fecha_desde) {
        this.fecha_desde = fecha_desde;
    }

    public String getFecha_hasta() {
        return fecha_hasta;
    }

    public void setFecha_hasta(String fecha_hasta) {
        this.fecha_hasta = fecha_hasta;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public Double getCostoservicio() {
        return costoservicio;
    }

    public void setCostoservicio(Double costoservicio) {
        this.costoservicio = costoservicio;
    }

    public Integer getId_centrocosto() {
        return id_centrocosto;
    }

    public void setId_centrocosto(Integer id_centrocosto) {
        this.id_centrocosto = id_centrocosto;
    }

    public String getCentrocosto() {
        return centrocosto;
    }

    public void setCentrocosto(String centrocosto) {
        this.centrocosto = centrocosto;
    }

    public String getRealizadopor() {
        return realizadopor;
    }

    public void setRealizadopor(String realizadopor) {
        this.realizadopor = realizadopor;
    }

    public String getFechaservicio() {
        return fechaservicio;
    }

    public void setFechaservicio(String fechaservicio) {
        this.fechaservicio = fechaservicio;
    }

    public String getServiciopkf() {
        return serviciopkf;
    }

    public void setServiciopkf(String serviciopkf) {
        this.serviciopkf = serviciopkf;
    }

    public Integer getId_solicitud() {
        return id_solicitud;
    }

    public void setId_solicitud(Integer id_solicitud) {
        this.id_solicitud = id_solicitud;
    }

    public String getFechasolicitud() {
        return fechasolicitud;
    }

    public void setFechasolicitud(String fechasolicitud) {
        this.fechasolicitud = fechasolicitud;
    }
    
    public Integer getCedula() {
        return cedula;
    }

    public void setCedula(Integer cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getId_equipo() {
        return id_equipo;
    }

    public void setId_equipo(Integer id_equipo) {
        this.id_equipo = id_equipo;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public String getComponente() {
        return componente;
    }

    public void setComponente(String componente) {
        this.componente = componente;
    }

    public String getFalla() {
        return falla;
    }

    public void setFalla(String falla) {
        this.falla = falla;
    }

    public Integer getId_servicio() {
        return id_servicio;
    }

    public void setId_servicio(Integer id_servicio) {
        this.id_servicio = id_servicio;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }
    
    
    
    
    
}
