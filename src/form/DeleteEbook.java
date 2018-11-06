/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 *
 * @author kong
 */
public class DeleteEbook extends javax.swing.JInternalFrame {
static boolean pressSearchBtn = false;
    /**
     * Creates new form AddBook
     */
    public DeleteEbook() {
        initComponents();
        getContentPane().setBackground(new Color(255,255,255)); 
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel15 = new javax.swing.JLabel();
        jAddBook2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtIdBook = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        bookpic = new image.ImagePanel();
        alert = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(900, 504));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(917, 604));
        getContentPane().setLayout(null);

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(13, 67, 112));
        jLabel15.setText("ลบหนังสือ");
        getContentPane().add(jLabel15);
        jLabel15.setBounds(420, 0, 100, 40);

        jAddBook2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jAddBook2.setText("ลบหนังสือ");
        jAddBook2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAddBook2ActionPerformed(evt);
            }
        });
        getContentPane().add(jAddBook2);
        jAddBook2.setBounds(380, 410, 150, 50);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(153, 0, 0));
        jLabel7.setText("รหัสหนังสือ");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(260, 100, 90, 30);

        txtIdBook.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtIdBook.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtIdBookKeyPressed(evt);
            }
        });
        getContentPane().add(txtIdBook);
        txtIdBook.setBounds(350, 100, 210, 30);

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("ค้นหา");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(570, 100, 67, 30);

        bookpic.setVisible(true);
        getContentPane().add(bookpic);
        bookpic.setBounds(390, 190, 140, 150);

        alert.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        alert.setForeground(new java.awt.Color(255, 0, 51));
        alert.setText("ไม่พบข้อมูล");
        alert.setVisible(false);
        getContentPane().add(alert);
        alert.setBounds(390, 140, 170, 40);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    pressSearchBtn = true;
     alert.setVisible(false);
     bookpic.setVisible(true);
    boolean check =service.DeleteService.searchIsvalid(txtIdBook.getText().trim());
    int id=-1;    
    if(check){
    id= Integer.parseInt(txtIdBook.getText().trim());
      boolean checkImage = Dao.BookDao.getImgeProduc(id);
   if(checkImage){
       try{
        bookpic.setVisible(false);
        bookpic.setImage(ImageIO.read(new File(""+ FileSystems.getDefault().getPath("src/img/product.png").toAbsolutePath())));
        bookpic.setVisible(true);
       }catch(Exception ECE){
           System.out.println("error"+ECE);
       }
   }
   else{
        alert.setVisible(true);
        bookpic.setVisible(false);
        JOptionPane.showMessageDialog(DeleteEbook.this, "รหัสสินค้าไม่ถูกต้อง", "", JOptionPane.WARNING_MESSAGE);
    }
    }
    else{
        JOptionPane.showMessageDialog(DeleteEbook.this, "กรุณากรอกรหัสสินค้า", "", JOptionPane.WARNING_MESSAGE);
        alert.setVisible(true);
    }
 
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jAddBook2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAddBook2ActionPerformed
        if(txtIdBook.getText().trim().equals("")){
            JOptionPane.showMessageDialog(DeleteEbook.this, "กรุณากรอกรหัสสินค้า", "", JOptionPane.WARNING_MESSAGE);    
        }
        else if(!pressSearchBtn){
           JOptionPane.showMessageDialog(DeleteEbook.this, "ลบหนังสือไม่สำเร็จกรุณากดปุ่มค้นหาก่อน", "", JOptionPane.WARNING_MESSAGE);
       }
        else{
        boolean checkDelete = Dao.BookDao.deleteBook(Integer.parseInt(txtIdBook.getText().trim()));
        if(checkDelete){
             JOptionPane.showMessageDialog(DeleteEbook.this, "ลบช้อมูลสำเร็จ", "", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(DeleteEbook.this, "ลบช้อมูลไม่สำเร็จ", "", JOptionPane.WARNING_MESSAGE);
        }
        }
        pressSearchBtn = false;
    }//GEN-LAST:event_jAddBook2ActionPerformed

    private void txtIdBookKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdBookKeyPressed
     
    }//GEN-LAST:event_txtIdBookKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel alert;
    private image.ImagePanel bookpic;
    private javax.swing.JButton jAddBook2;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField txtIdBook;
    // End of variables declaration//GEN-END:variables
}