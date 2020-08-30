
package sistock;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class conexion {
    
    public String url; // Ip_de_la_maquina/nombre_de_la_base_de_datos
    public String login;
    public  String password;
    public Connection cnn;
    public Statement st;
    public ResultSet rs;
    public boolean estado;

       
    public conexion(String sql,String modo){
        
        //url = "jdbc:mysql://localhost:3306/sistock?autoReconnect=true&useSSL=false";
        url = "jdbc:mysql://WsAFor:3306/sistock?autoReconnect=true&useSSL=false";
        login = "usr_sistock";
        password = "sistock2017";
        cnn = null;
        st = null;
        rs = null;
        
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cnn = DriverManager.getConnection(url,login,password);
            
            if (cnn != null){
                //System.out.println("Conexión a base de datos "+url+" ... Ok");
            
                st = cnn.createStatement();
           
                if (modo.equals("buscar")){
               //JOptionPane.showMessageDialog(null,sql);
                    rs = st.executeQuery(sql);
                }
                else{
                //JOptionPane.showMessageDialog(null,sql);
                    st.execute(sql);
                }
                
                estado = true;
            }
                    
        }
        catch(SQLException ex) {
            //System.out.println("Hubo un problema al intentar conectarse con la base de datos "+url);
            System.out.println(ex);
            estado = false;
        }
        catch(ClassNotFoundException ex) {
            //System.out.println ("La clase no fue encontrada");
            System.out.println(ex);
            estado = false;
        }
               
    }
    
    public void cerrar(){
        
        try {
            st.close();
        } catch (SQLException ex) {
            estado = false;
        }
        
        try {
            cnn.close();
        } catch (SQLException ex) {
           estado = false;
        }
    }
    
  
    
}
