/*
 * VERSION 2.7
 * FECHA: 13/11/2014
 */
package sistock;



import java.awt.Color;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author user
 */
public class frm_login extends javax.swing.JFrame {

    /**
     * Creates new form frm_login
     */
    public frm_login() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.WHITE);
        String sql;
        this.setTitle("SISTOCK - BIENVENIDOS");
        this.setExtendedState(MAXIMIZED_BOTH);
        //sql = "select a.logo from tbl_institucion a";
        //institucion obj = new institucion("Sin Foto",sql);
       // this.setIconImage(new ImageIcon("Z:/imagen_sistema/" + institucion.buscar_logo_institucion()).getImage());
    
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_usuario = new javax.swing.JLabel();
        txt_usuario = new javax.swing.JTextField();
        lbl_password = new javax.swing.JLabel();
        txt_password = new javax.swing.JPasswordField();
        bot_aceptar = new javax.swing.JButton();
        bot_cerrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lbl_version = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(185, 206, 230));
        setMinimumSize(new java.awt.Dimension(450, 270));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_usuario.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbl_usuario.setForeground(new java.awt.Color(51, 51, 51));
        lbl_usuario.setText("USUARIO");
        getContentPane().add(lbl_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 260, -1, -1));

        txt_usuario.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        getContentPane().add(txt_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 260, 260, -1));

        lbl_password.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbl_password.setForeground(new java.awt.Color(51, 51, 51));
        lbl_password.setText("CONTRASEÑA");
        getContentPane().add(lbl_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 310, -1, -1));

        txt_password.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        txt_password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_passwordKeyPressed(evt);
            }
        });
        getContentPane().add(txt_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 310, 260, -1));

        bot_aceptar.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        bot_aceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/check.png"))); // NOI18N
        bot_aceptar.setText("ACEPTAR");
        bot_aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bot_aceptarActionPerformed(evt);
            }
        });
        getContentPane().add(bot_aceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 440, 170, 50));

        bot_cerrar.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        bot_cerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/close.png"))); // NOI18N
        bot_cerrar.setText("CERRAR");
        bot_cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bot_cerrarActionPerformed(evt);
            }
        });
        getContentPane().add(bot_cerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 440, 150, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/IMAGENLOGIN.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        lbl_version.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        lbl_version.setForeground(new java.awt.Color(51, 51, 51));
        lbl_version.setText("RAP. Version: 0.1");
        getContentPane().add(lbl_version, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 430, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bot_cerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bot_cerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_bot_cerrarActionPerformed

    private void bot_aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bot_aceptarActionPerformed
        
        String sql;
        
        String password = new String(txt_password.getPassword());
        boolean resp;
        
        sql = "select a.contrasena from tbl_usuario a where ";
        
        if (!txt_usuario.getText().trim().equals("") && !txt_password.getPassword().toString().trim().equals("")){
            usuario obj = new usuario(txt_usuario.getText().trim(),password,sql);
            
            resp = obj.verificar();
            
            if (resp){
                                             
                frm_principal frame = new frm_principal();
                frame.setVisible(true);
                   
                this.dispose();
               
            }
            else{
                                
                JOptionPane.showMessageDialog(null, "USUARIO O CONTRASEÑA NO VALIDO", "VALIDACION DE USUARIO", JOptionPane.ERROR_MESSAGE,null);
                txt_password.setText("");
                txt_password.requestFocus();
                txt_password.requestFocusInWindow();
            }
        }
        else{
               JOptionPane.showMessageDialog(null, "USUARIO O CONTRASEÑA NO VALIDO", "VALIDACION DE USUARIO", JOptionPane.ERROR_MESSAGE,null);
        }
         
    }//GEN-LAST:event_bot_aceptarActionPerformed

    private void txt_passwordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_passwordKeyPressed
        if (evt.getKeyCode()==10){
            bot_aceptar.doClick();
        }
    }//GEN-LAST:event_txt_passwordKeyPressed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
                         
    }//GEN-LAST:event_formWindowOpened

    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       // try {
            //ServerSocket SERVER_SOCKET = new ServerSocket(1334);
            try {
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(frm_login.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                Logger.getLogger(frm_login.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(frm_login.class.getName()).log(Level.SEVERE, null, ex);
            } catch (UnsupportedLookAndFeelException ex) {
                Logger.getLogger(frm_login.class.getName()).log(Level.SEVERE, null, ex);
            }
      
            
             java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_login().setVisible(true);
            }
          });
            
            
       //} catch (IOException x) {
       //     JOptionPane.showMessageDialog(null, "EL SISTEMA YA SE ENCUENTRA EN EJECUCIÓN !!!","GESTIONAC - AVISO",JOptionPane.WARNING_MESSAGE);
       // }
        
       
       
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JButton bot_aceptar;
    private static javax.swing.JButton bot_cerrar;
    private javax.swing.JLabel jLabel1;
    private static javax.swing.JLabel lbl_password;
    private static javax.swing.JLabel lbl_usuario;
    private javax.swing.JLabel lbl_version;
    private static javax.swing.JPasswordField txt_password;
    protected static javax.swing.JTextField txt_usuario;
    // End of variables declaration//GEN-END:variables
}
