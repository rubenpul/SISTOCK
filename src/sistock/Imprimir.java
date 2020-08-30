
package sistock;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;

import javax.swing.JOptionPane;


public class Imprimir {
    
    private static String archivo;
    
    public Imprimir(String id_boleta){
        Imprimir.archivo = "pkf/pkf_"+ id_boleta + ".txt";
    }
    
    public void imprimir_pkf_archivo() throws IOException{
        
        Desktop desktop = Desktop.getDesktop();
        String nombreImpresora=null;
        String hostname = null;
        File fichero = new File(archivo);
        String impresora_defecto=null;
        
        PrintService printservice = PrintServiceLookup.lookupDefaultPrintService(); 
        
                
        impresora_defecto = printservice.toString().replace("Win32 Printer :","").trim();
        
          
        try {

            InetAddress addr = InetAddress.getLocalHost();

            hostname = addr.getHostName();
            
        } catch (Exception e) {
            
            e.printStackTrace();
        }
        
       
        
        
        
               
        if (desktop.isSupported(Desktop.Action.PRINT)){
            try {
                
                /*if (!hostname.equals("SERVIDOR-ISB")){
                    
                    nombreImpresora = "\\\\PCSeguri01\\EPSON LX Series 1 (80)";
        
                    nombreImpresora = "Rundll32 printui.dll,PrintUIEntry /y /n \""+nombreImpresora+"\"";
                    
                    try{
                                              
                        Process pr = Runtime.getRuntime().exec(nombreImpresora);
                        
                    }catch(Exception ex){
                        JOptionPane.showMessageDialog(null,"ERROR AL SELECCIONAR LA IMPRESORA " + nombreImpresora);
                    }
                }*/
                
                
                desktop.print(fichero);
                                        
                              
                
            } catch (Exception e){
                JOptionPane.showMessageDialog(null,"ERROR EN LA IMPRESION","SISTOCK", JOptionPane.ERROR_MESSAGE,null);
                e.printStackTrace();
        }
        }else{
            JOptionPane.showMessageDialog(null,"ERROR EN LA IMPRESION","SISTOCK", JOptionPane.ERROR_MESSAGE,null);    
        } 
        
        //fichero.exists();
        
        fichero.deleteOnExit();
        
    
    }
    
}
