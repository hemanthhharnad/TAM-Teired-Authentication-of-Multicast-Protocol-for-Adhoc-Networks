/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * r1intchek.java
 *
 * Created on Aug 9, 2012, 5:17:59 AM
 */

package tam;
import java .io.*;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JOptionPane;
/**
 *
 * @author Administrator
 */
public class r1intchek extends javax.swing.JFrame {
    public static String fp=receiver1.fp2;
    public String macinfile,mackey;
    /** Creates new form r1intchek */
    public r1intchek() {
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

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(600, 600));
        getContentPane().setLayout(null);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/find.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(290, 200, 100, 30);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/find.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(290, 330, 100, 30);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/integritychecking.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(290, 480, 145, 30);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("MAC in file:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(120, 140, 77, 17);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("MAC key is:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(120, 270, 78, 17);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("File is:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(130, 410, 42, 17);
        getContentPane().add(jTextField1);
        jTextField1.setBounds(218, 140, 250, 20);
        getContentPane().add(jTextField2);
        jTextField2.setBounds(218, 270, 260, 20);
        getContentPane().add(jTextField3);
        jTextField3.setBounds(218, 410, 260, 20);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/dataintegrity.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, -20, 600, 640);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try{
            String fp1,str;
            FileReader f1=new FileReader(fp1=fp);
            BufferedReader br=new BufferedReader(f1);
            while((str=br.readLine())!=null){
                macinfile=str;
            }
            RandomAccessFile raf=new RandomAccessFile(fp1, "rw");
            jTextField1.setText(macinfile);
            int a=macinfile.length();
            long l=Long.parseLong(String.valueOf(a));
            long l1=raf.length()-l-2;
            raf.setLength(l1);
            f1.close();
            br.close();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        try{
            String fp1,str;
            FileReader f1=new FileReader(fp1=fp);
            BufferedReader br=new BufferedReader(f1);
            while((str=br.readLine())!=null){
                mackey=str;
            }
            RandomAccessFile raf=new RandomAccessFile(fp1, "rw");
            jTextField2.setText(mackey);
            int a=mackey.length();
            long l=Long.parseLong(String.valueOf(a));
            long l1=raf.length()-l-2;
            raf.setLength(l1);
            f1.close();
            br.close();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        try{
            SecretKeySpec key=new SecretKeySpec(mackey.getBytes("UTF-8"), "HmacMD5");
            String s,s1;
            Mac mac = Mac.getInstance(key.getAlgorithm());
            mac.init(key);
            FileInputStream fis = new FileInputStream(fp);
            FileOutputStream fos = new FileOutputStream("c:\\data1.txt");
            PrintStream ps = new PrintStream(fos);
            DataInputStream dis = new DataInputStream(fis);
            BufferedReader br = new BufferedReader(new InputStreamReader(dis));
            while((s = dis.readLine())!=null){
                ps.print(s);
            }
            FileInputStream fis1 = new FileInputStream("c:\\data1.txt");
            DataInputStream dis1 = new DataInputStream(fis1);
            BufferedReader br1 = new BufferedReader(new InputStreamReader(dis1));
            s1 = dis1.readLine();
            byte[] utf8 = s1.getBytes("UTF8");
            byte[] digest = mac.doFinal(utf8);
            String digestB641 = new sun.misc.BASE64Encoder().encode(digest);            
            if(digestB641.equals(macinfile)){
                jTextField3.setText("Not changed");
                JOptionPane.showMessageDialog(null, "File is not changed");
                this.dispose();
            }
            else{
                jTextField3.setText("Changed");
                JOptionPane.showMessageDialog(null, "File is changed");
                this.dispose();
            }
         }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new r1intchek().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables

}