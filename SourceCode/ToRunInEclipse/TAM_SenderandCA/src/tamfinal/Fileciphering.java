/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Fileciphering.java
 *
 * Created on Aug 3, 2012, 12:41:28 PM
 */

package tamfinal;

import java.io.*;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JOptionPane;
import java.net.*;
/**
 *
 * @author egc10
 */
public class Fileciphering extends javax.swing.JFrame {
    public static String filepath1=MACYielding.filepath;
    public static String keyaes,ip1,ip2;
    /** Creates new form Fileciphering */
    public Fileciphering() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(600, 600));
        getContentPane().setLayout(null);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Enter the (16) byte key:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(61, 143, 148, 17);
        getContentPane().add(jTextField1);
        jTextField1.setBounds(230, 140, 200, 20);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cipher.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(480, 130, 100, 30);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/send.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(276, 436, 100, 30);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Enter the IP of receiver 1:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(61, 250, 162, 17);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Enter the IP of receiver 2:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(60, 360, 162, 17);
        getContentPane().add(jTextField2);
        jTextField2.setBounds(230, 250, 200, 20);
        getContentPane().add(jTextField3);
        jTextField3.setBounds(230, 360, 203, 20);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/save.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(482, 239, 100, 30);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/save.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(480, 360, 100, 30);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fileciphering.png"))); // NOI18N
        jLabel5.setText("jLabel5");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(0, 0, 600, 600);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try{
            String s="d:\\aesenc.txt";
            File desFile= new File(s);
            FileInputStream fis = null;
            FileOutputStream fos;
            CipherInputStream cis;
            byte key[] = (jTextField1.getText()).getBytes();
            SecretKeySpec secretKey = new SecretKeySpec(key,"AES");
            Cipher encrypt =   Cipher.getInstance("AES");
            encrypt.init(Cipher.ENCRYPT_MODE, secretKey);
            try {
                fis = new FileInputStream(filepath1);
            } catch(IOException err) {
                System.out.println("Cannot open file!");
                System.exit(-1);
            }
            cis = new CipherInputStream(fis, encrypt);
            fos = new FileOutputStream(desFile);
            byte[] b = new byte[8];
            int i = cis.read(b);
            while (i != -1) {
                fos.write(b, 0, i);
                i = cis.read(b);
            }
            fos.flush();
            fos.close();
            cis.close();
            fis.close();
            JOptionPane.showMessageDialog(null,"File is Encrypted");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        try{
            Socket clientSocket = new Socket("localhost",1234);
            PrintStream sout=new PrintStream(clientSocket.getOutputStream());
            sout.println(ip1);
            sout.println(ip2);
            sout.close();
            clientSocket.close();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        try{
            File file = new File("d:\\aesenc.txt");
            FileInputStream fis = new FileInputStream(file);
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
            Socket clientSocket = new Socket("localhost",5678);
            BufferedOutputStream out = new BufferedOutputStream(clientSocket.getOutputStream());            
            byte[] bytes = new byte[8192];
            int count=0;            
            while ((count = bis.read(bytes))!=-1 ) {
                out.write(bytes,0,count);
            }                      
            bis.close();
            out.close();            
            fis.close();
            clientSocket.close();
            JOptionPane.showMessageDialog(null,"File is sent to central Authority");
            this.dispose();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        try{
            ip1=jTextField2.getText();

        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        try{
            ip2=jTextField3.getText();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Fileciphering().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables

}