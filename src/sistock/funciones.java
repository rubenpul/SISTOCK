/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistock;

import com.toedter.calendar.JDateChooser;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author ruben
 */
public class funciones {
    
    
    public static String separadordemiles(String numero,boolean convertir){
        DecimalFormatSymbols simbolo  = new DecimalFormatSymbols();
        simbolo.setDecimalSeparator(',');
        DecimalFormat formato = new DecimalFormat("###,###.##",simbolo); 
        Integer tmp;
       
        
        if ( (convertir) && (!numero.equals("")) ){
            tmp = Integer.parseInt(numero);
            
            numero = String.valueOf(formato.format(tmp));
        }
        
        return numero;
            
   }
    
    public static JComboBox cargar_combo(JComboBox combo,String sql,String pordefecto){
        String cadena;
        
        
        combo.removeAllItems();
        combo.addItem("Seleccione...");
        cadena = "";
       
        
        conexion cnn = new conexion(sql,"buscar");
        
        if (cnn.estado){
            
            try{
                while(cnn.rs.next()){
                    if(!cnn.rs.getString(2).trim().equals("Cadena")){
                        if (!cnn.rs.getString(2).trim().equals("")){
                            cadena = String.valueOf(cnn.rs.getInt(1)) + "  -  " + cnn.rs.getString(2).trim();
                        }
                        else{
                            cadena = String.valueOf(cnn.rs.getInt(1));
                        }
                        
                    }
                    else{
                        cadena = String.valueOf(cnn.rs.getString(1));
                    }
                    combo.addItem(cadena); 
                    
                    if (cnn.rs.getString(2).trim().equals(pordefecto)){
                        combo.setSelectedItem(cadena);
                    }
                }
                
                return combo;
            } 
            catch (SQLException err){
                JOptionPane.showMessageDialog(null, err.getMessage());   
                cnn.cerrar();
                return combo;
            }    
        }   
        else{
             cnn.cerrar();
             return combo;
        }
    }
    
    public static JComboBox cargar_combo_mes(JComboBox combo,String sql,String pordefecto){
        String cadena;
        
        
        combo.removeAllItems();
        combo.addItem("Seleccione...");
        cadena = "";
       
        
        conexion cnn = new conexion(sql,"buscar");
        
        if (cnn.estado){
            
            try{
                while(cnn.rs.next()){
                    cadena = String.valueOf(cnn.rs.getInt(1));
                
                    combo.addItem(funciones.descripcion_mes(cadena)); 
                }    
                         
                combo.setSelectedItem("Seleccione...");
                
                return combo;
            } 
            catch (SQLException err){
                JOptionPane.showMessageDialog(null, err.getMessage());   
                cnn.cerrar();
                return combo;
            }    
        }   
        else{
             cnn.cerrar();
             return combo;
        }
    }
    
    public static String gethoracalendario(){
        Integer hora;
        Integer minuto;
        Integer am_pm;
        Calendar cal = Calendar.getInstance();
        String cadena= "";
        
            hora = cal.get(Calendar.HOUR);
            minuto = cal.get(Calendar.MINUTE);
            
            am_pm = cal.get(Calendar.AM_PM);
            
            if ( (hora > 9) &&(minuto < 10) ) {
                cadena = String.valueOf(hora) + ":0" + String.valueOf(minuto);
            }    
            else{
                if ( (hora < 10) &&(minuto > 9) ) {
                    cadena = "0" + String.valueOf(hora) + ":" + String.valueOf(minuto);                        
                }
                else{
                    if ((hora < 10) &&(minuto < 10)){
                        cadena = "0" + String.valueOf(hora) + ":0" + String.valueOf(minuto);
                    }    
                    else{
                        cadena = String.valueOf(hora) + ":" + String.valueOf(minuto);
                    }
                }
            }
        
            if (!am_pm.equals(0)){
                cadena = cadena + " PM" ;
            }
            else{
                cadena = cadena + " AM" ;
            }
    
        return cadena;    
    
    }
    
    
    public static String getfechacalendario(){
        Integer dia;
        Integer mes;
        Integer ano;
        Calendar cal = Calendar.getInstance();
        String cadena= "";
        
            dia = cal.get(Calendar.DATE);
            mes = cal.get(Calendar.MONTH)+1;
            ano = cal.get(Calendar.YEAR);
            
           
            
            if ((dia < 10) && (mes > 9)) {
                cadena = "0" + String.valueOf(dia) + "/" + String.valueOf(mes) + "/" + String.valueOf(ano);
            }
            else{
                if ((dia > 9) && (mes < 10)) {
                    cadena = String.valueOf(dia) + "/0" + String.valueOf(mes) + "/" + String.valueOf(ano);
                }
                else{
                    if ((dia < 10) && (mes < 10)) {
                        cadena = "0" + String.valueOf(dia) + "/0" + String.valueOf(mes) + "/" + String.valueOf(ano);
                    }
                    else{
                        cadena = String.valueOf(dia) + "/" + String.valueOf(mes) + "/" + String.valueOf(ano);
                    }
                }
            }
        
        return cadena;
    }
    
    
    public static String fecha_convertir_date(JDateChooser fecha_convertir,Integer modo){
        Calendar cal = Calendar.getInstance();
        String fecha="";
        Integer ano;
        Integer mes;
        Integer dia;
        
           try{ 
                cal.setTime(fecha_convertir.getDate());
                ano = cal.get(Calendar.YEAR);
                mes = cal.get(Calendar.MONTH)+ 1;
                dia = cal.get(Calendar.DAY_OF_MONTH);
                
                if (modo.equals(1)){
                    if ((dia < 10) && (mes > 9)) {
                        fecha =  String.valueOf(ano) + "-" + String.valueOf(mes) + "-0" + String.valueOf(dia);
                    }
                    else{
                        if ((dia > 9) && (mes < 10)) {
                            fecha = String.valueOf(ano) + "-0" + String.valueOf(mes) + "-" + String.valueOf(dia);
                        }
                        else{
                            if ((dia < 10) && (mes < 10)) {
                                fecha = String.valueOf(ano) + "-0" + String.valueOf(mes) + "-0" + String.valueOf(dia);
                            }
                            else{
                                fecha = String.valueOf(ano) + "-" + String.valueOf(mes) + "-" + String.valueOf(dia);
                            }
                        }
                    }
                }
                else{
                    if ((dia < 10) && (mes > 9)) {
                        fecha = "0" + String.valueOf(dia) + "/" + String.valueOf(mes) + "/" + String.valueOf(ano);
                    }
                    else{
                        if ((dia > 9) && (mes < 10)) {
                            fecha = String.valueOf(dia) + "/0" + String.valueOf(mes) + "/" + String.valueOf(ano);
                        }
                        else{
                            if ((dia < 10) && (mes < 10)) {
                                fecha = "0" + String.valueOf(dia) + "/0" + String.valueOf(mes) + "/" + String.valueOf(ano);
                            }
                            else{
                                fecha = String.valueOf(dia) + "/" + String.valueOf(mes) + "/" + String.valueOf(ano);
                            }
                        }
                    }
                }
                
           }
           catch(NullPointerException ex){
               fecha = "";
           }
    
           return fecha;
    }
    
    
    public static String fecha_bd_usuario(String fecha_trans,Integer modo_fecha){  
          
          String ano;
          String mes;
          String dia;
          
          String fecha="1900-01-01";
          
          try{ 
          
          switch (modo_fecha){
                case 1: if (!fecha_trans.equals("")){ //MODO PARA VISUALIZACION EN EL SISTEMA
                            ano = fecha_trans.substring(0, 4);
                            mes = fecha_trans.substring(5, 7);
                            dia = fecha_trans.substring(8, 10);
                            fecha = dia + "/" + mes + "/" + ano;
                        }
                        break;
                case 2: if (!fecha_trans.equals("")){  //MODO PARA GUARDAR EN LA BD
                            ano = fecha_trans.substring(6, 10); 
                            mes = fecha_trans.substring(3, 5);
                            dia = fecha_trans.substring(0, 2);
                            fecha = ano + "-" + mes + "-" + dia;
                        }    
                        break;
        
            } 
          
          }
           catch(NullPointerException ex){
               
               fecha = "1900-01-01";
           }
      
            return fecha;
      }
    
     public static String fecha_bd_usuario_2(String fecha_trans,Integer modo_fecha){  
          
          String ano;
          String mes;
          String dia;
          
          String fecha="1900-01-01";
          
          try{ 
          
          switch (modo_fecha){
                case 1: if (!fecha_trans.equals("")){ //MODO PARA VISUALIZACION EN EL SISTEMA
                            ano = fecha_trans.substring(0, 4);
                            mes = fecha_trans.substring(5, 7);
                            dia = fecha_trans.substring(8, 10);
                            fecha = dia + "/" + mes + "/" + ano;
                        }
                        break;
                case 2: if (!fecha_trans.equals("")){  //MODO PARA GUARDAR EN LA BD
                            ano = "20" + fecha_trans.substring(6, 8); 
                            mes = fecha_trans.substring(3, 5);
                            dia = fecha_trans.substring(0, 2);
                            fecha = ano + "-" + mes + "-" + dia;
                        }    
                        break;
        
            } 
          
          }
           catch(NullPointerException ex){
               
               fecha = "1900-01-01";
           }
      
            return fecha;
      }
    
     public static String descripcion_mes(String mes){
    
        String desc_mes=null;
                 
        switch (Integer.parseInt(mes)){

            case 1: desc_mes = "ENERO";
                    break;
            case 2: desc_mes = "FEBRERO";
                    break;
            case 3: desc_mes = "MARZO";
                    break;
            case 4: desc_mes = "ABRIL";
                    break;
            case 5: desc_mes = "MAYO";
                    break;
            case 6: desc_mes = "JUNIO";
                    break;
            case 7: desc_mes = "JULIO";
                    break;
            case 8: desc_mes = "AGOSTO";
                    break;
            case 9: desc_mes = "SEPTIEMBRE";
                    break;
            case 10: desc_mes = "OCTUBRE";
                    break;
            case 11: desc_mes = "NOVIEMBRE";
                    break;
            case 12: desc_mes = "DICIEMBRE";
                                    
        }
                  
         
        return desc_mes;
    
    }
     
    public static Integer descripcion_mes_num(String mes){
    
        Integer desc_mes=0;
                 
        switch (mes){

            case "ENERO": desc_mes = 1;
                    break;
            case "FEBRERO": desc_mes = 2;
                    break;
            case "MARZO": desc_mes = 3;
                    break;
            case "ABRIL": desc_mes = 4;
                    break;
            case "MAYO": desc_mes = 5;
                    break;
            case "JUNIO": desc_mes = 6;
                    break;
            case "JULIO": desc_mes = 7;
                    break;
            case "AGOSTO": desc_mes = 8;
                    break;
            case "SEPTIEMBRE": desc_mes = 9;
                    break;
            case "OCTUBRE": desc_mes = 10;
                    break;
            case "NOVIEMBRE": desc_mes = 11;
                    break;
            case "DICIEMBRE": desc_mes = 12;
                                    
        }
                  
         
        return desc_mes;
    
    }
    
    public static void fecha_convertir_string(String fecha_convertir,JDateChooser fecha){
        
        Calendar cal = Calendar.getInstance();
        
         try {
                cal.set(Integer.parseInt(fecha_convertir.substring(0, 4)),Integer.parseInt(fecha_convertir.substring(5, 7))-1,Integer.parseInt(fecha_convertir.substring(8, 10)));
                fecha.setCalendar(cal);
         }catch(NullPointerException ex){
                fecha.setDate(null);
         }
    }
 
    public static Boolean verificar_mes_autorizacion(Integer mes,Integer ano,String fecha){
        
        Calendar fechamin = Calendar.getInstance();
        Calendar fechaconsultar = Calendar.getInstance();
        
        
        
        
        if (mes.equals(0)){
            mes = Integer.parseInt(fecha.substring(3, 5));
            ano = Integer.parseInt(fecha.substring(6, 10));
        }
       
        //System.out.println(mes);
        
        mes = mes - 1;
        
        fechamin.add(Calendar.MONTH, -1);
        fechamin.set(Calendar.DATE,1);
        
        fechaconsultar.set(Calendar.DATE, 1);
        fechaconsultar.set(Calendar.MONTH, mes);
        fechaconsultar.set(Calendar.YEAR, ano);
        
        
        /*System.out.println(fechamin.getTime());
        System.out.println(fechamin.getTimeInMillis());
        
        System.out.println(fechaconsultar.getTime());
        System.out.println(fechaconsultar.getTimeInMillis());*/
        
        if (fechaconsultar.getTimeInMillis() >= fechamin.getTimeInMillis()){
            // System.out.println("true");
            return true;
           
        }
        else{
            //System.out.println("false");
            return false;
            
        }
    }
    
}
