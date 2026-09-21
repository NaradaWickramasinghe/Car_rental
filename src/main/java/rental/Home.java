/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package rental;

import java.sql.*;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.*;
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.util.List;
import java.util.ArrayList;
import java.io.*;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.OutputStream;
import com.toedter.calendar.JDateChooser;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.sql.SQLIntegrityConstraintViolationException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import java.sql.Connection;


import net.sf.jasperreports.engine.JasperFillManager;  // For filling reports
import net.sf.jasperreports.engine.JasperPrint;         // For the JasperPrint object
import net.sf.jasperreports.engine.JasperReport;       // For the JasperReport object
import net.sf.jasperreports.engine.JRException;         // For handling exceptions
import net.sf.jasperreports.view.JasperViewer;         // For displaying reports
//import net.sf.jasperreports.engine.data.JRDataSource;   // For handling data sources
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;


/**
 *
 * @author Narada Prabath
 */
public class Home extends javax.swing.JFrame {

    String url = "jdbc:mysql://localhost:3306/vehiclerentdata"; 
    Connection con ;
    String picpath ;
    String nicbpath ;
    String nicfpath ;
    public void table_data()
    {
        try 
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url,"root","Narada123");
            Statement st = con.createStatement();
            String sql = "SELECT * FROM registration";
            ResultSet rs = st.executeQuery(sql);
            
            ResultSetMetaData rd = rs.getMetaData();
            int c = rd.getColumnCount();
            DefaultTableModel df = (DefaultTableModel)jTable1.getModel();
            df.setRowCount(0);
            
            while(rs.next())
            {
                List<String> ay = new ArrayList<>();
                
                for(int i = 1 ; i<= c; i++)
                {
                    ay.add(rs.getString(2));
                    ay.add(rs.getString(3));
                    ay.add(rs.getString(4));
                    ay.add(rs.getString(5));
                    ay.add(rs.getString(6));
                    
                  
                            
                }
                  df.addRow(ay.toArray());
            }
            
        
                    
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(this,e);
        }
        catch(ClassNotFoundException e)
        {
            JOptionPane.showMessageDialog(this,e);
        }
            
            
            
            
    }
     public void cus_table_data()
    {
        try 
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url,"root","Narada123");
            Statement st = con.createStatement();
            String sql = "SELECT * FROM customer";
            ResultSet rs = st.executeQuery(sql);
            
            ResultSetMetaData rd = rs.getMetaData();
            int c = rd.getColumnCount();
            DefaultTableModel df = (DefaultTableModel)jTable2.getModel();
            df.setRowCount(0);
            
            while(rs.next())
            {
                List<String> ay = new ArrayList<>();
                
                for(int i = 1 ; i<= c; i++)
                {
                    ay.add(rs.getString(1));
                    ay.add(rs.getString(2));
                    ay.add(rs.getString(3));
                    ay.add(rs.getString(4));
                    ay.add(rs.getString(5));
                    
                  
                            
                }
                  df.addRow(ay.toArray());
            }
            
        
                    
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(this,e);
        }
        catch(ClassNotFoundException e)
        {
            JOptionPane.showMessageDialog(this,e);
        }
            
            
            
            
    }
    
    

    
    

    /**
     * Creates new form Home
     */
    public Home() {
        
        initComponents();
//        btn_add.setEnabled(false);
   this.setResizable(false);
        btn_returned_main.setVisible(false);
        cus_table_data();
        autoGenarateID();
        table_data();
         
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_regno = new javax.swing.JTextField();
        txt_make = new javax.swing.JTextField();
        txt_model = new javax.swing.JTextField();
        btn_add = new javax.swing.JButton();
        btn_edit = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        btn_clear = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txt_telno = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        lbl_img = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btn_Browse = new javax.swing.JButton();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txt_nic = new javax.swing.JTextField();
        txt_cusname = new javax.swing.JTextField();
        btn_add_customer = new javax.swing.JButton();
        btn_clear1 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        txt_tele = new javax.swing.JTextField();
        lbl_img3 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        btn_nicfrontbrowse = new javax.swing.JButton();
        lbl_img2 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        btn_nicbackbrowse = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        txt_cusaddress = new javax.swing.JTextArea();
        cus_report = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txt_make2 = new javax.swing.JTextField();
        txt_model2 = new javax.swing.JTextField();
        jComboBox3 = new javax.swing.JComboBox<>();
        lbl_img1 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txt_regno_for_rental = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        txt_rentnic = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel20 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jPanel11 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        combo_category = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        txt_returnnic = new javax.swing.JTextField();
        btn_returnsearch = new javax.swing.JButton();
        lbl_return_back_nic = new javax.swing.JLabel();
        lbl_return_vehicle = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jComboBoxreturn = new javax.swing.JComboBox<>();
        jLabel26 = new javax.swing.JLabel();
        txt_model_return = new javax.swing.JTextField();
        txt_returncus_name = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        txt_renteddate = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        txt_overduedate_return = new javax.swing.JTextField();
        txt_regno_for_rented = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        txt_rentedId = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        txt_lateDates = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        txt_latedatefee = new javax.swing.JTextField();
        txt_finalamount = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        txt_over_rent = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel39 = new javax.swing.JLabel();
        btn_returned_main = new javax.swing.JButton();
        btn_jasper = new javax.swing.JButton();
        lbl_return_nicfront = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Reg No");

        jLabel2.setText("Manufacture Com");

        jLabel3.setText("Model");

        jLabel4.setText("Availability");

        txt_regno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_regnoActionPerformed(evt);
            }
        });

        txt_model.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_modelActionPerformed(evt);
            }
        });

        btn_add.setText("Add");
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });

        btn_edit.setText("Edit");
        btn_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editActionPerformed(evt);
            }
        });

        btn_delete.setText("Delete");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        btn_clear.setText("Clear");
        btn_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearActionPerformed(evt);
            }
        });

        jLabel5.setText("Owner TelNo");

        txt_telno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_telnoActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "YES", "NO" }));

        lbl_img.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel10.setText("(optional)");

        btn_Browse.setText("Browse");
        btn_Browse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_BrowseActionPerformed(evt);
            }
        });

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Car", "Luxarycar", "SUV", "Van", "MiniVan", "ThreeWeel", "Scooter", "Bike", "Caterpiller" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jLabel6.setText("Vehicle Type ");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_edit))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(btn_Browse))
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_clear)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(40, 40, 40)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(lbl_img, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_model, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBox2, 0, 150, Short.MAX_VALUE)))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_make, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                                    .addComponent(txt_regno))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_telno, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.TRAILING, 0, 150, Short.MAX_VALUE))))
                        .addContainerGap())))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_regno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_make, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_model, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(17, 17, 17)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_telno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_Browse)
                        .addGap(36, 36, 36))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_img, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_delete)
                    .addComponent(btn_edit))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_clear)
                    .addComponent(btn_add))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Reg No", "Manufacture", "Model", "Availablity", "Owner TelNo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 934, Short.MAX_VALUE)
                .addGap(27, 27, 27))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Registration", jPanel1);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jLabel9.setText("NIC");

        jLabel11.setText("Name");

        jLabel12.setText("Address");

        txt_nic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nicActionPerformed(evt);
            }
        });

        btn_add_customer.setText("Add");
        btn_add_customer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_add_customerActionPerformed(evt);
            }
        });

        btn_clear1.setText("Clear");
        btn_clear1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clear1ActionPerformed(evt);
            }
        });

        jLabel14.setText("Telephone");

        txt_tele.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_teleActionPerformed(evt);
            }
        });

        lbl_img3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel15.setText("NIC Photo(front)");

        btn_nicfrontbrowse.setText("Browse");
        btn_nicfrontbrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nicfrontbrowseActionPerformed(evt);
            }
        });

        lbl_img2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel16.setText("NIC Photo(back)");

        btn_nicbackbrowse.setText("Browse");
        btn_nicbackbrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nicbackbrowseActionPerformed(evt);
            }
        });

        txt_cusaddress.setColumns(20);
        txt_cusaddress.setRows(5);
        jScrollPane3.setViewportView(txt_cusaddress);

        cus_report.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cus_report.setText("Customer details report");
        cus_report.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        cus_report.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cus_reportActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btn_nicfrontbrowse)
                                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel7Layout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addComponent(btn_nicbackbrowse)))))
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lbl_img3, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbl_img2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addGap(4, 4, 4)
                                        .addComponent(txt_nic, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(25, 25, 25)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_cusname, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_tele, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_add_customer, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                            .addComponent(btn_clear1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(122, 122, 122))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cus_report)
                .addGap(104, 104, 104))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txt_nic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txt_cusname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel12)
                        .addGap(43, 43, 43))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel14)
                    .addComponent(txt_tele, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                        .addComponent(lbl_img2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbl_img3, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_nicfrontbrowse)
                        .addGap(6, 6, 6)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(81, 81, 81)
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_nicbackbrowse))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                .addComponent(btn_add_customer)
                                .addGap(18, 18, 18)
                                .addComponent(btn_clear1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(cus_report))
        );

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "NIC", "Name", "Address", "Telephone"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 561, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(254, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(38, 38, 38))
        );

        jTabbedPane1.addTab("Customer", jPanel2);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        jLabel8.setText("Manufacture Com");

        jLabel13.setText("Model");

        txt_make2.setEnabled(false);

        txt_model2.setEnabled(false);
        txt_model2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_model2ActionPerformed(evt);
            }
        });

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "YES", "NO" }));
        jComboBox3.setEnabled(false);

        lbl_img1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel17.setText("Availability");

        txt_regno_for_rental.setEnabled(false);

        jLabel38.setText("Reg No");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lbl_img1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(txt_model2, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(42, 42, 42)))
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_make2)
                            .addComponent(jComboBox3, 0, 136, Short.MAX_VALUE)
                            .addComponent(txt_regno_for_rental))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_make2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_model2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_regno_for_rental, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel38))
                .addGap(25, 25, 25)
                .addComponent(lbl_img1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel18.setText("Customer NIC");

        jLabel19.setForeground(new java.awt.Color(255, 0, 102));
        jLabel19.setText("(Register the customer before renting a vehicle)");

        jButton1.setText("Rent");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jDateChooser1.setDateFormatString("yyyy-MM-dd");

        jLabel20.setText("Overdue Date ");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txt_rentnic, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jLabel19)
                .addGap(21, 21, 21)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_rentnic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jButton1))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel20)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Reg No", "Make", "Model", "Availability"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable3MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTable3);

        jPanel11.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel7.setText("Category");

        combo_category.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Car", "Luxarycar", "SUV", "Van", "MiniVan", "ThreeWeel", "Scooter", "Bike", "Caterpiller" }));

        jButton2.setText("Search");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton4.setText("Get Availability Report");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(combo_category, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)))
                .addGap(24, 24, 24))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(combo_category, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton4))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 801, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(115, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Rental", jPanel3);

        jPanel12.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel13.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel21.setText("NIC");

        btn_returnsearch.setText("Search");
        btn_returnsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_returnsearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_returnsearch)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(txt_returnnic, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(txt_returnnic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btn_returnsearch)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        lbl_return_back_nic.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbl_return_vehicle.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel14.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel25.setText("Vehicle Catergory");

        jComboBoxreturn.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Car", "Luxarycar", "SUV", "Van", "MiniVan", "ThreeWeel", "Scooter", "Bike", "Caterpiller" }));
        jComboBoxreturn.setEnabled(false);
        jComboBoxreturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxreturnActionPerformed(evt);
            }
        });

        jLabel26.setText("Vehicle Model");

        txt_model_return.setEnabled(false);

        txt_returncus_name.setEnabled(false);

        jLabel27.setText("Name");

        txt_renteddate.setEnabled(false);

        jLabel31.setText("Rented Date");

        jLabel32.setText("OverdueDate");

        txt_overduedate_return.setEnabled(false);

        txt_regno_for_rented.setEnabled(false);

        jLabel36.setText("Vehicle RegNo");

        txt_rentedId.setEnabled(false);

        jLabel37.setText("RentedID");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(14, 14, 14)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_renteddate)
                    .addComponent(txt_model_return, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jComboBoxreturn, javax.swing.GroupLayout.Alignment.TRAILING, 0, 130, Short.MAX_VALUE)
                    .addComponent(txt_returncus_name, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_overduedate_return))
                .addGap(39, 39, 39)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel36)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(31, 31, 31)))
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_rentedId, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                    .addComponent(txt_regno_for_rented))
                .addGap(14, 14, 14))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxreturn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_regno_for_rented, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36)
                    .addComponent(jLabel25))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_model_return, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_rentedId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26)
                    .addComponent(jLabel37))
                .addGap(12, 12, 12)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_returncus_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_renteddate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_overduedate_return, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel22.setText("NIC Front Photo");

        jLabel23.setText("NIC Back Photo");

        jLabel24.setText("Rented Vehicle");

        jPanel15.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButton3.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jButton3.setText("Calculate ");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        txt_lateDates.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txt_lateDates.setEnabled(false);
        txt_lateDates.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_lateDatesActionPerformed(evt);
            }
        });

        jLabel28.setText("Late Dates ");

        jLabel29.setText("Fee for Late Dates");

        txt_latedatefee.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txt_latedatefee.setEnabled(false);

        txt_finalamount.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txt_finalamount.setEnabled(false);

        jLabel30.setText("Final Amount");

        jLabel33.setText("Rental Duration");

        txt_over_rent.setEnabled(false);

        jPanel8.setBackground(new java.awt.Color(204, 255, 255));

        jLabel34.setText("Enter return date ");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel34)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel34))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jLabel39.setText("(Without late dates)");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel33)
                                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(35, 35, 35))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel39))
                            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txt_latedatefee, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                                    .addComponent(txt_finalamount)
                                    .addComponent(txt_lateDates))
                                .addComponent(txt_over_rent, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel33, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_over_rent, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(jLabel39)
                .addGap(18, 18, 18)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_lateDates, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_latedatefee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addComponent(txt_finalamount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel30, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        btn_returned_main.setBackground(new java.awt.Color(255, 0, 102));
        btn_returned_main.setFont(new java.awt.Font("Sans Serif Collection", 0, 24)); // NOI18N
        btn_returned_main.setForeground(new java.awt.Color(255, 255, 255));
        btn_returned_main.setText("Returned");
        btn_returned_main.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_returned_main.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_returned_mainActionPerformed(evt);
            }
        });

        btn_jasper.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_jasper.setText("BILL Report");
        btn_jasper.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_jasperActionPerformed(evt);
            }
        });

        lbl_return_nicfront.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_return_back_nic, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(lbl_return_nicfront, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23)
                                .addComponent(lbl_return_vehicle, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(193, 193, 193)
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(160, 160, 160)
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_returned_main, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(84, 84, 84))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGap(177, 177, 177)
                                .addComponent(btn_jasper))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(25, Short.MAX_VALUE))))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbl_return_back_nic, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_return_vehicle, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_return_nicfront, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22)
                    .addComponent(jLabel23)
                    .addComponent(jLabel24))
                .addGap(35, 35, 35))
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(394, 394, 394)
                .addComponent(btn_returned_main, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_jasper)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Return", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // calculate button
        btn_returned_main.setVisible(true);
        String regno =null;
        Date rdate = null;
        Date odate = null;
        String nic = txt_returnnic.getText();
        final int car = 3500;
        final int luxarycar = 20000;
        final int van = 5000;
        final int minivan = 3500;
        final int threeweel = 1000;
        final int Scooter = 500;
        final int bike = 500;
        final int catapiller = 25000;

        final int overdcar = 4000;
        final int overdluxarycar = 25000;
        final int overdvan = 5500;
        final int overdminivan = 4000;
        final int overdthreeweel = 1500;
        final int overdScooter = 1000;
        final int overdbike = 1000;
        final int overdcatapiller = 30000;

        int inDays =0 ;
        double finalprice =0;
        double latefee = 0;
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url,"root","Narada123");

            String sql = "SELECT rentdate,overduedate,regno  FROM rent WHERE nic=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,nic);

            ResultSet rs = pst.executeQuery();

            if(rs.next())
            {
                rdate = rs.getDate("rentdate");
                odate = rs.getDate("overduedate");
                regno = rs.getString("regno");
                System.out.println(rdate);
                System.out.println(odate);
                System.out.println(regno);
            }

            // Date date2 = odate - rdate ;
            // Calculate the difference in milliseconds
            long diffInMillis = odate.getTime() - rdate.getTime();

            // Convert milliseconds to days and cast to int
            inDays = (int)(diffInMillis / (1000 * 60 * 60 * 24));

            System.out.println("Difference in days (int): " + inDays);

            txt_over_rent.setText(Integer.toString(inDays));
            Date returndate = jDateChooser2.getDate();
            long milisecond2 = returndate.getTime() - odate.getTime();
            int dayformat = (int)(milisecond2/(1000*60*60*24));

            if(dayformat == 0 )
            {

                txt_lateDates.setText("0");
            }

            else
            {
                txt_lateDates.setText(Integer.toString(dayformat));
            }

        }
        catch(ClassNotFoundException ex )
        {
               JOptionPane.showMessageDialog(this,ex);
        }
        catch (SQLException ex )
        {
           JOptionPane.showMessageDialog(this,ex);
        }
        catch(NullPointerException ex)
        {
            JOptionPane.showMessageDialog(this,"NO data to complete Calculation","Error",JOptionPane.ERROR_MESSAGE);  
        }
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url,"root","Narada123");
            String sql2 = "SELECT category FROM registration WHERE regno=?";
            PreparedStatement pst2 = con.prepareStatement(sql2);
            pst2.setString(1, regno);
            
            ResultSet rs2 = pst2.executeQuery();
             rs2.next();
            String category = rs2.getString("category");
            System.out.println(category);

            if(category.equals("Car"))
            {
                latefee = overdcar*inDays;
                finalprice = car+(latefee) ;

            }
            else if(category.equals("SUV"))
            {
                latefee =overdluxarycar*inDays;
                finalprice = luxarycar+(latefee) ;
            }
            else if(category.equals("Van"))
            {
                System.out.println("ggggggggg");
                latefee =overdvan*inDays;
                finalprice = van+latefee ;
            }
            else if(category.equals("MiniVan"))
            {
                latefee =overdminivan*inDays;
                finalprice =minivan+(latefee) ;
            }
            else if(category.equals("ThreeWeel"))
            {
                latefee =overdthreeweel*inDays;
                finalprice =threeweel+(latefee) ;
            }
            else if(category.equals("Scooter"))
            {
                latefee =overdScooter*inDays;
                finalprice =Scooter+(latefee) ;
            }
            else if(category.equals("Bike"))
            {
                latefee =overdbike *inDays;
                finalprice =bike +(latefee) ;
            }
            else if(category.equals("Caterpiller"))
            {
                latefee= overdcatapiller*inDays;
                finalprice =catapiller+(latefee) ;
            }
            txt_finalamount.setText(Double.toString(finalprice));
            txt_latedatefee.setText(Double.toString(latefee));

            //Car, Luxarycar, SUV, Van, MiniVan, ThreeWeel, Scooter, Bike, Caterpiller

        }
        catch(SQLException ex )
        {
             JOptionPane.showMessageDialog(this,ex);
        }
        catch(ClassNotFoundException ex)
        {
            JOptionPane.showMessageDialog(this,ex);
        }
        catch (NullPointerException ex)
        {
             JOptionPane.showMessageDialog(this,"NO data to complete Calculation","Error",JOptionPane.ERROR_MESSAGE);  
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jComboBoxreturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxreturnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxreturnActionPerformed

    private void btn_returnsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_returnsearchActionPerformed
        String searchnic = txt_returnnic.getText();
        String regno = null;
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url,"root","Narada123");

            String sql = "SELECT name,nicfront,nicback FROM customer WHERE nic=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,searchnic);

            ResultSet rs = pst.executeQuery();

            if(rs.next())
            {
                String name = rs.getString("name");
                System.out.println(name);
                txt_returncus_name.setText(name);

                Blob imageBlob = rs.getBlob("nicfront");

                InputStream binaryStream = imageBlob.getBinaryStream(1, imageBlob.length());
                BufferedImage img = ImageIO.read(binaryStream);
                ImageIcon icon = new ImageIcon(img);

                Image scaledImage = icon.getImage().getScaledInstance(lbl_return_nicfront.getWidth(), lbl_return_nicfront.getHeight(), Image.SCALE_SMOOTH);
                lbl_return_nicfront.setIcon(new ImageIcon(scaledImage));

                Blob imageBlob2 = rs.getBlob("nicback");

                InputStream binaryStream2 = imageBlob2.getBinaryStream(1, imageBlob2.length());
                BufferedImage img2 = ImageIO.read(binaryStream2);
                ImageIcon icon2 = new ImageIcon(img2);

                Image scaledImage2 = icon2.getImage().getScaledInstance(lbl_return_back_nic.getWidth(), lbl_return_back_nic.getHeight(), Image.SCALE_SMOOTH);
                lbl_return_back_nic.setIcon(new ImageIcon(scaledImage2));

                con.close();

            }

        }
        catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch(ClassNotFoundException e)
        {
            JOptionPane.showMessageDialog(this,e);

        }
        catch (IOException ex)
        {
            JOptionPane.showMessageDialog(this,ex);
        }
        catch(NullPointerException ex)
        {
            JOptionPane.showMessageDialog(this,"this data doesn' t has image ");
        }

        try{
            //for get the dat afrom rent table and registration table
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url,"root","Narada123");

            String sql2 = "SELECT rentid,rentdate,overduedate,regno FROM rent WHERE nic=?";
            PreparedStatement pst2 = con.prepareStatement(sql2);
            pst2.setString(1,searchnic);

            ResultSet rs2 = pst2.executeQuery();

            if(rs2.next())
            {
                String rentid = rs2.getString("rentid");
                String rentdate = rs2.getString("rentdate");
                System.out.println(rentdate);
                String overduedate = rs2.getString("overduedate");
                regno = rs2.getString("regno");

                //                SimpleDateFormat formatter =new SimpleDateFormat("yyyy-MM-dd");// method of date convert to string
                //                String OverddateString = formatter.format(overduedate);
                //
                //                String rentdateString = formatter.format(rentdate);

                txt_overduedate_return.setText(overduedate);
                txt_renteddate.setText(rentdate);
                txt_regno_for_rented.setText(regno);
                txt_rentedId.setText(rentid);
                System.out.println(regno);
            }
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(this,ex);
        }

        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url,"root","Narada123");

            String sql3 = "SELECT  model,category,image FROM registration WHERE regno=?";
            PreparedStatement pst3 = con.prepareStatement(sql3);
            pst3.setString(1,regno);

            ResultSet rs3 = pst3.executeQuery();
            if(rs3.next())
            {
                txt_model_return.setText(rs3.getString("model"));
                jComboBoxreturn.setSelectedItem(rs3.getString("category"));

                Blob imageBlob3 = rs3.getBlob("image");

                InputStream binaryStream3 = imageBlob3.getBinaryStream(1, imageBlob3.length());
                BufferedImage img3 = ImageIO.read(binaryStream3);
                ImageIcon icon3 = new ImageIcon(img3);

                Image scaledImage3 = icon3.getImage().getScaledInstance(lbl_return_vehicle.getWidth(), lbl_return_vehicle.getHeight(), Image.SCALE_SMOOTH);
                lbl_return_vehicle.setIcon(new ImageIcon(scaledImage3));
            }
        }
        catch(ClassNotFoundException ex)
        {

        }
        catch(SQLException ex)
        {

        }
        catch(IOException ex )
        {

        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_returnsearchActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // Search rental
        String category = combo_category.getSelectedItem().toString();
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url,"root","Narada123");
            String sql = "SELECT * FROM registration WHERE category=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, category);

            ResultSet rs = pst.executeQuery();

            ResultSetMetaData rd = rs.getMetaData();
            int c = rd.getColumnCount();
            DefaultTableModel df = (DefaultTableModel)jTable3.getModel();
            df.setRowCount(0);

            while(rs.next())
            {
                List<String> ay = new ArrayList<>();

                for(int i = 1 ; i<= c; i++)
                {
                    ay.add(rs.getString(2));
                    ay.add(rs.getString(3));
                    ay.add(rs.getString(4));
                    ay.add(rs.getString(5));

                }
                df.addRow(ay.toArray());
            }

        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(this,e);
        }
        catch(ClassNotFoundException e)
        {
            JOptionPane.showMessageDialog(this,e);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseClicked
        //        DefaultTableModel df = (DefaultTableModel)jTable3.getModel();
        //
        //        int selectedindex = jTable3.getSelectedRow();
        //
        //        txt_make2.setText(df.getValueAt(selectedindex, 1).toString());
        //        txt_model2.setText(df.getValueAt(selectedindex,2).toString());
        //        jComboBox3.setSelectedItem(df.getValueAt(selectedindex, 3).toString());
        //
        //        String sql = "SELECT * FROM registration WHERE regno=?";
        //        try
        //        {
            //            PreparedStatement pst = con.prepareStatement(sql);
            //            Resultset rs = pst.executeQuery();
            //            if(rs.next())
            //            {
                //                Blob image = rs.getBlob(7);
                //
                //            }
            //        }
        //        catch(SQLException ex)
        //        {
            //
            //        }
        //        catch (ClassNotFoundException ex )
        //        {
            //
            //        }

        DefaultTableModel df = (DefaultTableModel) jTable3.getModel();
        int selectedindex = jTable3.getSelectedRow();

        // Setting other fields from selected row
        txt_make2.setText(df.getValueAt(selectedindex, 1).toString());
        txt_model2.setText(df.getValueAt(selectedindex, 2).toString());
        jComboBox3.setSelectedItem(df.getValueAt(selectedindex, 3).toString()); // availibility
        txt_regno_for_rental.setText(df.getValueAt(selectedindex,0).toString());

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Get the registration number from the selected row
            String regno = df.getValueAt(selectedindex, 0).toString();

            // SQL query to retrieve all data for the selected regno
            String sql = "SELECT * FROM registration WHERE regno=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, regno); // Set the regno parameter
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                // Retrieve the image as a Blob
                Blob imageBlob = rs.getBlob("image"); // Replace "image_column_name" with your actual column name

                // Convert the Blob into an ImageIcon
                InputStream binaryStream = imageBlob.getBinaryStream(1, imageBlob.length());
                BufferedImage img = ImageIO.read(binaryStream);
                ImageIcon icon = new ImageIcon(img);

                // Resize the icon if necessary
                Image scaledImage = icon.getImage().getScaledInstance(lbl_img1.getWidth(), lbl_img1.getHeight(), Image.SCALE_SMOOTH);
                lbl_img1.setIcon(new ImageIcon(scaledImage)); // Display the image in the label
            }

        }
        catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch(ClassNotFoundException e)
        {
            JOptionPane.showMessageDialog(this,e);

        }
        catch(IOException ex )

        {
            JOptionPane.showMessageDialog(this,ex);
        }
    }//GEN-LAST:event_jTable3MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        DefaultTableModel df = (DefaultTableModel) jTable3.getModel();
        int selectedindex = jTable3.getSelectedRow();
        String rentnic = txt_rentnic.getText();
        int availability = jComboBox3.getSelectedIndex();
        System.out.println("availability index"+availability);
        
        if(availability == 0 )
        {
            try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url,"root","Narada123");

            String sql = "SELECT * FROM customer WHERE nic=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,rentnic);
            ResultSet rs = pst.executeQuery();
            
            if(rs.next())
            {
//                 String sql2 = "SELECT * FROM customer WHERE nic=?";
//                 PreparedStatement pst2 = con.prepareStatement(sql2);
//                 pst2.setString(1,rentnic);
//                 ResultSet rs2 = pst.executeQuery();
                    
                
                con.close();
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection(url,"root","Narada123");
                System.out.println("already availble nic");
                LocalDateTime currentDate = LocalDateTime.now();
                //               ZoneId zoneid =ZoneId.of("Asia/Colombo");
                //               Date tdate = Date.from(currentDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
                //                java.sql.Date sqlDate = new java.sql.Date(tdate.getDate());
                //               Date date = new Date();  // Current date and time
                //               java.sql.Date sqlDate = new java.sql.Date(date.getDate());

                String sql2 = "INSERT INTO rent( rentdate,overduedate,regno,nic) VALUES (?,?,?,?) ";

                PreparedStatement pst2 = con.prepareStatement(sql2);

                //              pst2.setDate(1,sqlDate);

                //              pst2.setString(2,((JTextField)jDateChooser1.getDateEditor().getUiComponent()).getText());
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                //String currentDate = sdf.format(currentDate);
                pst2.setObject(1,currentDate);
                System.out.println(currentDate);
                String ddate = sdf.format(jDateChooser1.getDate());
                pst2.setString(2,ddate);
                pst2.setString(3, df.getValueAt(selectedindex, 0).toString());

                pst2.setString(4, rentnic);

                pst2.executeUpdate();
                jComboBox3.setSelectedItem("NO");// availibility combo box in rent form
                
                con.close();
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection(url,"root","Narada123");
                String sql3 = "Update registration set availability =? where regno=?";
                PreparedStatement pst3 = con.prepareStatement(sql3);

                pst3.setString(1, "NO");
                pst3.setString(2,txt_regno_for_rental.getText());
                pst3.executeUpdate();
                JOptionPane.showMessageDialog(this,"Succesfully rented ");

            }
            else
            {
                System.out.println("please correctly insert or register first in the customer tab");
                JOptionPane.showMessageDialog(this,"Invalid NIC or Not Available in our data base");
            }

        }
        catch(ClassNotFoundException ex)
        {
            JOptionPane.showMessageDialog(this,ex);
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(this,ex);
        } 
        }
        else
        {
            JOptionPane.showMessageDialog(this,"Vehicle Already Rent (NOW NOT AVAILABLE)","Error",JOptionPane.ERROR_MESSAGE);  
        }
        
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txt_model2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_model2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_model2ActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked

        // TODO add your handling code here:
    }//GEN-LAST:event_jTable2MouseClicked

    private void btn_nicbackbrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nicbackbrowseActionPerformed

        JFileChooser jf = new JFileChooser();
        jf.showOpenDialog(null);
        File f = jf.getSelectedFile();
        nicbpath = f.getAbsolutePath();
        try
        {
            BufferedImage bi = ImageIO.read(new File(nicbpath));
            Image img = bi.getScaledInstance(104, 96, Image.SCALE_SMOOTH);
            ImageIcon li = new ImageIcon(img);
            lbl_img3.setIcon(li);
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, "Error loading image.");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_nicbackbrowseActionPerformed

    private void btn_nicfrontbrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nicfrontbrowseActionPerformed

        JFileChooser jf = new JFileChooser();
        jf.showOpenDialog(null);
        File f = jf.getSelectedFile();
        nicfpath = f.getAbsolutePath();
        try
        {
            BufferedImage bi = ImageIO.read(new File(nicfpath));
            Image img = bi.getScaledInstance(104, 96, Image.SCALE_SMOOTH);
            ImageIcon li = new ImageIcon(img);
            lbl_img2.setIcon(li);
        }
        catch(NullPointerException ex )
        {
            JOptionPane.showMessageDialog(null, "null pointer exception");
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, "Error loading image.");
        }
        
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_nicfrontbrowseActionPerformed

    private void txt_teleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_teleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_teleActionPerformed

    private void btn_add_customerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_add_customerActionPerformed
if(txt_nic.getText().isBlank() != true && txt_cusname.getText().isBlank() != true && txt_cusaddress.getText().isBlank() != true && txt_tele.getText().isBlank() != true )
{
   if(txt_tele.getText().length() == 10 && txt_tele.getText().length() > 0 ) 
   {
        if(txt_nic.getText().length() >0 && txt_nic.getText().length() == 10 )
   {
       if(txt_nic.getText().charAt(txt_nic.getText().length()-1 ) == 'V')
           
       {
        String nic = txt_nic.getText();
        String cus_name = txt_cusname.getText();
        String address = txt_cusaddress.getText();
        String tele = txt_tele.getText();

        try
        {
             InputStream  is_front  = new FileInputStream(new File (nicbpath));
             InputStream is_back  = new FileInputStream(new File (nicfpath));
             if(is_front != null && is_back != null)
             {
                Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url,"root","Narada123");
            String sql = "INSERT INTO customer(nic,name,address,telephone,nicfront,nicback) VALUES (?, ?, ?, ?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,nic);
            pst.setString(2,cus_name);
            pst.setString(3, address);
            pst.setString(4,tele);
            pst.setBinaryStream(5, is_front);
            pst.setBinaryStream(6, is_back);
            pst.executeUpdate();
            cus_table_data();
            JOptionPane.showMessageDialog(this,"Succesfully added");
             }
            
           else
    {
        JOptionPane.showMessageDialog(this,"Must Upload the NIC pictures","Error",JOptionPane.ERROR_MESSAGE);
    }   
    
          
        }
         catch(SQLIntegrityConstraintViolationException ex)
        {
          JOptionPane.showMessageDialog(this,"This NIC already Assigned ","Error",JOptionPane.ERROR_MESSAGE);  
        }
        
        catch(ClassNotFoundException ex )
        {
            JOptionPane.showMessageDialog(this,ex);
        }
        
        catch(NullPointerException ex )
        {
          JOptionPane.showMessageDialog(this,"Must Upload the NIC pictures","Error",JOptionPane.ERROR_MESSAGE);
        }
        catch(FileNotFoundException ex)
        {
        JOptionPane.showMessageDialog(this,ex);
        }
        
        catch (Exception ex)
        {
            JOptionPane.showMessageDialog(this,ex);
        } 
       
    
    
       }
       else
       {
           JOptionPane.showMessageDialog(this,"Invalid NIC , NIC number end With 'V'","Error",JOptionPane.ERROR_MESSAGE);
       }  
   }
    else
       {
           JOptionPane.showMessageDialog(this,"Invalid NIC , NIC number has 10 numbers","Error",JOptionPane.ERROR_MESSAGE);
       }  
   
   }
   else
       {
           JOptionPane.showMessageDialog(this,"Invalid Phone Number ","Error",JOptionPane.ERROR_MESSAGE);
       }  
    
  
        
         
        
       
}
else 
{
     JOptionPane.showMessageDialog(this,"Fill all the TextBoxes ","Error",JOptionPane.ERROR_MESSAGE);
}
       
    }//GEN-LAST:event_btn_add_customerActionPerformed

    private void txt_nicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nicActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nicActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

        DefaultTableModel df = (DefaultTableModel)jTable1.getModel();

        int selectedindex = jTable1.getSelectedRow();

        txt_regno.setText(df.getValueAt(selectedindex, 0).toString());
        txt_make.setText(df.getValueAt(selectedindex,1).toString());
        txt_model.setText(df.getValueAt(selectedindex, 2).toString());
        jComboBox1.setSelectedItem(df.getValueAt(selectedindex, 3).toString());
        txt_telno.setText(df.getValueAt(selectedindex, 4).toString());
         try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Get the registration number from the selected row
            String regno = df.getValueAt(selectedindex, 0).toString();

            // SQL query to retrieve all data for the selected regno
            String sql = "SELECT * FROM registration WHERE regno=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, regno); // Set the regno parameter
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                // Retrieve the image as a Blob
                Blob imageBlob = rs.getBlob("image"); // Replace "image_column_name" with your actual column name

                // Convert the Blob into an ImageIcon
                InputStream binaryStream = imageBlob.getBinaryStream(1, imageBlob.length());
                BufferedImage img = ImageIO.read(binaryStream);
                ImageIcon icon = new ImageIcon(img);

                // Resize the icon if necessary
                Image scaledImage = icon.getImage().getScaledInstance(lbl_img.getWidth(), lbl_img.getHeight(), Image.SCALE_SMOOTH);
               lbl_img.setIcon(new ImageIcon(scaledImage)); // Display the image in the label
            }

        }
        catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch(ClassNotFoundException e)
        {
            JOptionPane.showMessageDialog(this,e);

        }
        catch(IOException ex )

        {
            JOptionPane.showMessageDialog(this,ex);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseClicked

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void btn_BrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_BrowseActionPerformed

        JFileChooser jf = new JFileChooser();
        jf.showOpenDialog(null);
        File f = jf.getSelectedFile();
        picpath = f.getAbsolutePath();
        try
        {
            BufferedImage bi = ImageIO.read(new File(picpath));
            Image img = bi.getScaledInstance(104, 96, Image.SCALE_SMOOTH);
            ImageIcon li = new ImageIcon(img);
            lbl_img.setIcon(li);
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, "Error loading image.");
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_btn_BrowseActionPerformed

    private void txt_telnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_telnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_telnoActionPerformed

    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
//        dispose();
//          txt_regno.setText(null);
           txt_make.setText(null);
          
           txt_model.setText(null);
            txt_telno.setText(null);
            lbl_img.setIcon(null);
            jComboBox2.setSelectedIndex(0);

        // TODO add your handling code here:
    }//GEN-LAST:event_btn_clearActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed

        DefaultTableModel df = (DefaultTableModel)jTable1.getModel();

        int selectedindex = jTable1.getSelectedRow();

        String id  = df.getValueAt(selectedindex, 0).toString();
        int dialogResult = JOptionPane.showConfirmDialog(this,"Do you want to Delete the record ","Waring",JOptionPane.YES_NO_OPTION);

        if(dialogResult == JOptionPane.YES_OPTION)
        {
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection(url,"root","Narada123");
                String sql = "Delete from registration where regno=?";
                PreparedStatement pst = con.prepareStatement(sql);

                pst.setString(1, id);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(this,"Successfuly Deleted");
                table_data();
                autoGenarateID();

            }
            catch(ClassNotFoundException | SQLException ex)
            {
                JOptionPane.showMessageDialog(this, ex);
            }
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed
        //        DefaultTableModel df = (DefaultTableModel)jTable1.getModel();
        //
        //        int selectedindex = jTable1.getSelectedRow();
        //
        //        txt_regno.setText(df.getValueAt(selectedindex, 0).toString());
        //
        //        try
        //        {
            //            String regno = df.getValueAt(selectedindex, 0).toString();
            //            String make = txt_make.getText();
            //            String model = txt_model.getText();
            //            String availability = jComboBox1.getSelectedItem().toString();
            //            String ownertel =txt_telno.getText();
            //
            //            Class.forName("com.mysql.cj.jdbc.Driver");
            //            con = DriverManager.getConnection(url,"root","Narada123");
            //
            //            String sql = "UPDATE registration SET make=?, model=?, availability=?, ownertel=? WHERE regno=? ";
            //            PreparedStatement pst = con.prepareStatement(sql);
            //
            //            Class.forName("com.mysql.cj.jdbc.Driver");
            //            con = DriverManager.getConnection(url,"root","Narada123");
            //            String sql2="SELECT category FROM registration WHERE regno=? ";
            //            Statement st= con.createStatement();
            //            ResultSet rs = st.executeQuery(sql2);
            //
            //            String category_value = rs.getString(1);
            //
            //            if(category_value != jComboBox2.getSelectedItem().toString() )
            //            {
                //                JOptionPane.showMessageDialog(this,"You can't change Category");
                //            }
            //            else
            //            {
                //                pst.setString(1, make);
                //                pst.setString(2, model);
                //                pst.setString(3, availability);
                //                pst.setString(4, ownertel);
                //                pst.setString(5, regno);
                //
                //                pst.executeUpdate();
                //
                //                JOptionPane.showMessageDialog(this,"Successfully Updated");
                //                autoGenarateID();
                //                table_data();
                //            }
            //
            //
            //        }
        //
        //        catch(ClassNotFoundException e)
        //        {
            //            JOptionPane.showMessageDialog(this, e);
            //
            //        }
        //        catch(SQLException e )
        //        {
            //            JOptionPane.showMessageDialog(this,e);
            //        }
        //
        //        // TODO add your handling code here:

        DefaultTableModel df = (DefaultTableModel) jTable1.getModel();
        int selectedindex = jTable1.getSelectedRow();

        // Get selected registration number
        txt_regno.setText(df.getValueAt(selectedindex, 0).toString());
        String regno = df.getValueAt(selectedindex, 0).toString();

        // Retrieve data from text fields and combo box
        String make = txt_make.getText();
        String model = txt_model.getText();
        String availability = jComboBox1.getSelectedItem().toString();
        String ownertel = txt_telno.getText();

        Connection con = null;
        PreparedStatement pst = null;
        PreparedStatement pst2 = null;
        ResultSet rs = null;

        try {
            // Load MySQL driver and establish a connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, "root", "Narada123");

            // Query to retrieve the category for the given regno
            String sql2 = "SELECT category FROM registration WHERE regno=?";
            pst2 = con.prepareStatement(sql2);
            pst2.setString(1, regno);  // Set regno in the query
            rs = pst2.executeQuery();

            String category_value = "";
            if (rs.next()) {
                category_value = rs.getString("category");  // Retrieve the category value
            }

            // Check if category change is attempted
            if (!category_value.equals(jComboBox2.getSelectedItem().toString())) {
                JOptionPane.showMessageDialog(this, "You can't change Category");
            } else {
                // Prepare update statement
                String sql = "UPDATE registration SET make=?, model=?, availability=?, ownertel=? WHERE regno=?";
                pst = con.prepareStatement(sql);
                pst.setString(1, make);
                pst.setString(2, model);
                pst.setString(3, availability);
                pst.setString(4, ownertel);
                pst.setString(5, regno);

                // Execute the update and show success message
                int rowsAffected = pst.executeUpdate();
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(this, "Successfully Updated");

                    table_data();
                } else {
                    JOptionPane.showMessageDialog(this, "Update Failed");
                }
            }
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(this, e);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e);
        } finally {
            // Close resources
            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
                if (pst2 != null) pst2.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btn_editActionPerformed

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed

        try
        {

            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url,"root","Narada123");
     if(txt_regno.getText().isBlank() != true && txt_make.getText().isBlank()  != true && txt_model.getText().isBlank()!= true  )
     {
         if (txt_regno.getText().charAt(0)== 'V')
         {
             if (txt_telno.getText().length()>0 && txt_telno.getText().length() ==10)
             {
                   String regno = txt_regno.getText();
            String manufacture = txt_make.getText();
            String model = txt_model.getText();
            String ownertel = txt_telno.getText();
            InputStream is  = new FileInputStream(new File (picpath));

            String availability  = jComboBox1.getSelectedItem().toString();
            String category = jComboBox2.getSelectedItem().toString(); 
            
            btn_add.setEnabled(true);
                String sql = "INSERT INTO registration (regno, make, model, availability, ownertel,image,category) VALUES (?, ?, ?, ?, ?,?,?)";
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setString(1,regno);
                pst.setString(2,manufacture);
                pst.setString(3, model);
                pst.setString(4,availability);
                pst.setString(5,ownertel);
                pst.setBinaryStream(6, is);
                pst.setString(7,category);

                pst.executeUpdate();
                pst.close();
                con.close();
                JOptionPane.showMessageDialog(this,"Sucessfully added ");
             }
             else 
             {
                 JOptionPane.showMessageDialog(this,"Invalid phone number ","Error",JOptionPane.ERROR_MESSAGE); 
             }
           
         }
         
         else
         {
             JOptionPane.showMessageDialog(this,"Register number must be Start from 'V'","Error",JOptionPane.ERROR_MESSAGE);
         }
          
     }
     else 
     {
         JOptionPane.showMessageDialog(this,"Fill the first 3 textBox ","Error",JOptionPane.ERROR_MESSAGE);
     }
          


            table_data();
            autoGenarateID();

        }
        catch(ClassNotFoundException e )
        {
            JOptionPane.showMessageDialog(this,e);
        }
        catch(SQLException e )
        {
            JOptionPane.showMessageDialog(this,e);
        }
        catch (FileNotFoundException ex)
        {
            JOptionPane.showMessageDialog(this,ex);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_addActionPerformed

    private void txt_modelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_modelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_modelActionPerformed

    private void txt_regnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_regnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_regnoActionPerformed

    private void btn_returned_mainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_returned_mainActionPerformed
     String regno =  txt_regno_for_rented.getText();
     int rentid = Integer.parseInt(txt_rentedId.getText());
     String rentdate = txt_renteddate.getText();
     String overdate = txt_overduedate_return.getText();
     String model =txt_model_return.getText();
     Date  returndate = jDateChooser2.getDate();
     String latedates = txt_lateDates.getText();
     String latefee = txt_latedatefee.getText();
     String finalamount = txt_finalamount.getText();
     
        try
        {
                 Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection(url,"root","Narada123");
                String sql = "Update registration set availability =? where regno=?";
                PreparedStatement pst = con.prepareStatement(sql);

                pst.setString(1, "YES");
                pst.setString(2,regno);
                pst.executeUpdate();
                con.close();
                JOptionPane.showMessageDialog(this,"Successfully Rentered");
        }
        catch(ClassNotFoundException e )
        {
            JOptionPane.showMessageDialog(this,e);
        }
        catch(SQLException e )
        {
            JOptionPane.showMessageDialog(this,e);
        }
        
          try 
          {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection(url,"root","Narada123");
                String sql2 = "INSERT INTO bill(rentid,rentdate,overduedate,regno,model,returndate,latedates,latefee,finalamount) VALUES(?,?,?,?,?,?,?,?,?)";
                PreparedStatement pst2 = con.prepareStatement(sql2);

                pst2.setInt(1, rentid);
                pst2.setString(2,rentdate);
                pst2.setString(3,overdate);
                pst2.setString(4,regno);
                pst2.setString(5,model);
                
                pst2.setObject(6,returndate);
                pst2.setString(7,latedates );
                pst2.setString(8,latefee);
                pst2.setString(9, finalamount);
                pst2.executeUpdate();  
          }
           catch(ClassNotFoundException e )
        {
            JOptionPane.showMessageDialog(this,e);
        }
        catch(SQLException e )
        {
            JOptionPane.showMessageDialog(this,e);
        }
        


        // TODO add your handling code here:
    }//GEN-LAST:event_btn_returned_mainActionPerformed

    private void btn_jasperActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_jasperActionPerformed
      try
      {
          Class.forName("com.mysql.jdbc.Driver");
          con = DriverManager.getConnection(url,"root","Narada123");
          String reportpath = "C:\\Users\\Narada Prabath\\Documents\\NetBeansProjects\\Car_rental\\lib\\billdata.jrxml";
          JasperReport jr = JasperCompileManager.compileReport(reportpath);
          JasperPrint jp = JasperFillManager.fillReport(jr,null,con);
          JasperViewer.viewReport(jp);
          con.close();
      }
      
      catch(ClassNotFoundException ex )
      {
           JOptionPane.showMessageDialog(this,ex);
      }   
      catch(SQLException ex )
      {
           JOptionPane.showMessageDialog(this,"Data base not properly connect ");
      }
      catch(JRException ex)
      {
          JOptionPane.showMessageDialog(this,"Error occur in the reporting tool "); 
      }
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_jasperActionPerformed

    private void cus_reportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cus_reportActionPerformed
  try
      {
          Class.forName("com.mysql.jdbc.Driver");
          con = DriverManager.getConnection(url,"root","Narada123");
          String reportpath = "C:\\Users\\Narada Prabath\\Documents\\NetBeansProjects\\Car_rental\\lib\\Cherry_Table_customer.jrxml";
          JasperReport jr = JasperCompileManager.compileReport(reportpath);
          JasperPrint jp = JasperFillManager.fillReport(jr,null,con);
          JasperViewer.viewReport(jp);
          con.close();
      }
      
      catch(ClassNotFoundException ex )
      {
           JOptionPane.showMessageDialog(this,ex);
      }   
      catch(SQLException ex )
      {
           JOptionPane.showMessageDialog(this,"Data base not properly connect ");
      }
      catch(JRException ex)
      {
          JOptionPane.showMessageDialog(this,"Error occur in the reporting tool "); 
      }        // TODO add your handling code here:
    }//GEN-LAST:event_cus_reportActionPerformed

    private void btn_clear1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clear1ActionPerformed
             txt_nic.setText(null);
             txt_cusname.setText(null);
          
          txt_tele.setText(null);
            txt_cusaddress.setText(null);
           lbl_img2.setIcon(null);
           lbl_img3.setIcon(null);
          


        // TODO add your handling code here:
    }//GEN-LAST:event_btn_clear1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
    // vehicle availability report 
     try
      {
          Class.forName("com.mysql.jdbc.Driver");
          con = DriverManager.getConnection(url,"root","Narada123");
          String reportpath = "C:\\Users\\Narada Prabath\\Documents\\NetBeansProjects\\Car_rental\\lib\\availability.jrxml";
          JasperReport jr = JasperCompileManager.compileReport(reportpath);
          JasperPrint jp = JasperFillManager.fillReport(jr,null,con);
          JasperViewer.viewReport(jp);
          con.close();
      }
      
      catch(ClassNotFoundException ex )
      {
           JOptionPane.showMessageDialog(this,ex);
      }   
      catch(SQLException ex )
      {
           JOptionPane.showMessageDialog(this,"Data base not properly connect ");
      }
      catch(JRException ex)
      {
          JOptionPane.showMessageDialog(this,"Error occur in the reporting tool "); 
      }

// TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void txt_lateDatesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_lateDatesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_lateDatesActionPerformed

    /**
     * @param args the command line arguments
     */
    public void autoGenarateID() 
    {
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url,"root","Narada123");
            
            String sql = "SELECT MAX(id) FROM registration";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            rs.next();
             int c1 = rs.getInt(1);
             c1++;
            this.txt_regno.setText("V"+c1);
        }
         catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this,ex);
        }

    }
    
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Browse;
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_add_customer;
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton btn_clear1;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_edit;
    private javax.swing.JButton btn_jasper;
    private javax.swing.JButton btn_nicbackbrowse;
    private javax.swing.JButton btn_nicfrontbrowse;
    private javax.swing.JButton btn_returned_main;
    private javax.swing.JButton btn_returnsearch;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> combo_category;
    private javax.swing.JButton cus_report;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBoxreturn;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JLabel lbl_img;
    private javax.swing.JLabel lbl_img1;
    private javax.swing.JLabel lbl_img2;
    private javax.swing.JLabel lbl_img3;
    private javax.swing.JLabel lbl_return_back_nic;
    private javax.swing.JLabel lbl_return_nicfront;
    private javax.swing.JLabel lbl_return_vehicle;
    private javax.swing.JTextArea txt_cusaddress;
    private javax.swing.JTextField txt_cusname;
    private javax.swing.JTextField txt_finalamount;
    private javax.swing.JTextField txt_lateDates;
    private javax.swing.JTextField txt_latedatefee;
    private javax.swing.JTextField txt_make;
    private javax.swing.JTextField txt_make2;
    private javax.swing.JTextField txt_model;
    private javax.swing.JTextField txt_model2;
    private javax.swing.JTextField txt_model_return;
    private javax.swing.JTextField txt_nic;
    private javax.swing.JTextField txt_over_rent;
    private javax.swing.JTextField txt_overduedate_return;
    private javax.swing.JTextField txt_regno;
    private javax.swing.JTextField txt_regno_for_rental;
    private javax.swing.JTextField txt_regno_for_rented;
    private javax.swing.JTextField txt_rentedId;
    private javax.swing.JTextField txt_renteddate;
    private javax.swing.JTextField txt_rentnic;
    private javax.swing.JTextField txt_returncus_name;
    private javax.swing.JTextField txt_returnnic;
    private javax.swing.JTextField txt_tele;
    private javax.swing.JTextField txt_telno;
    // End of variables declaration//GEN-END:variables
}
