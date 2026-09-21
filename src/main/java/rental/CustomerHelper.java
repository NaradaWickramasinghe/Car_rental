package rental;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;

/**
 * Handles all business logic for the Customer tab.
 * Extracted from Home.java to reduce file size and improve maintainability.
 *
 * @author Narada Prabath
 */
public class CustomerHelper {

    private final Home home;

    public CustomerHelper(Home home) {
        this.home = home;
    }

    /**
     * Loads all customer data into jTable2.
     */
    public void loadTableData() {
        try {
            Connection con = DatabaseHelper.getConnection();
            Statement st = con.createStatement();
            String sql = "SELECT * FROM customer";
            ResultSet rs = st.executeQuery(sql);

            ResultSetMetaData rd = rs.getMetaData();
            int c = rd.getColumnCount();
            DefaultTableModel df = (DefaultTableModel) home.getJTable2().getModel();
            df.setRowCount(0);

            while (rs.next()) {
                List<String> ay = new ArrayList<>();

                for (int i = 1; i <= c; i++) {
                    ay.add(rs.getString(1));
                    ay.add(rs.getString(2));
                    ay.add(rs.getString(3));
                    ay.add(rs.getString(4));
                    ay.add(rs.getString(5));
                }
                df.addRow(ay.toArray());
            }
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(home, e);
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(home, e);
        }
    }

    /**
     * Adds a new customer to the database with NIC photos.
     */
    public void addCustomer() {
        if (!home.getTxtNic().getText().isBlank()
                && !home.getTxtCusname().getText().isBlank()
                && !home.getTxtCusaddress().getText().isBlank()
                && !home.getTxtTele().getText().isBlank()) {

            if (home.getTxtTele().getText().length() == 10 && home.getTxtTele().getText().length() > 0) {
                if (home.getTxtNic().getText().length() > 0 && home.getTxtNic().getText().length() == 10) {
                    if (home.getTxtNic().getText().charAt(home.getTxtNic().getText().length() - 1) == 'V') {

                        String nic = home.getTxtNic().getText();
                        String cus_name = home.getTxtCusname().getText();
                        String address = home.getTxtCusaddress().getText();
                        String tele = home.getTxtTele().getText();

                        try {
                            InputStream is_front = new FileInputStream(new File(home.getNicbpath()));
                            InputStream is_back = new FileInputStream(new File(home.getNicfpath()));
                            if (is_front != null && is_back != null) {
                                Connection con = DatabaseHelper.getConnection();
                                String sql = "INSERT INTO customer(nic,name,address,telephone,nicfront,nicback) VALUES (?, ?, ?, ?,?,?)";
                                PreparedStatement pst = con.prepareStatement(sql);
                                pst.setString(1, nic);
                                pst.setString(2, cus_name);
                                pst.setString(3, address);
                                pst.setString(4, tele);
                                pst.setBinaryStream(5, is_front);
                                pst.setBinaryStream(6, is_back);
                                pst.executeUpdate();
                                loadTableData();
                                JOptionPane.showMessageDialog(home, "Succesfully added");
                                con.close();
                            } else {
                                JOptionPane.showMessageDialog(home, "Must Upload the NIC pictures", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        } catch (SQLIntegrityConstraintViolationException ex) {
                            JOptionPane.showMessageDialog(home, "This NIC already Assigned ", "Error", JOptionPane.ERROR_MESSAGE);
                        } catch (ClassNotFoundException ex) {
                            JOptionPane.showMessageDialog(home, ex);
                        } catch (NullPointerException ex) {
                            JOptionPane.showMessageDialog(home, "Must Upload the NIC pictures", "Error", JOptionPane.ERROR_MESSAGE);
                        } catch (FileNotFoundException ex) {
                            JOptionPane.showMessageDialog(home, ex);
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(home, ex);
                        }
                    } else {
                        JOptionPane.showMessageDialog(home, "Invalid NIC , NIC number end With 'V'", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(home, "Invalid NIC , NIC number has 10 numbers", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(home, "Invalid Phone Number ", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(home, "Fill all the TextBoxes ", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Opens file chooser to browse and select a NIC front photo.
     */
    public void browseNicFront() {
        JFileChooser jf = new JFileChooser();
        jf.showOpenDialog(null);
        File f = jf.getSelectedFile();
        home.setNicfpath(f.getAbsolutePath());
        try {
            BufferedImage bi = ImageIO.read(new File(home.getNicfpath()));
            Image img = bi.getScaledInstance(104, 96, Image.SCALE_SMOOTH);
            ImageIcon li = new ImageIcon(img);
            home.getLblImg2().setIcon(li);
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(null, "null pointer exception");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error loading image.");
        }
    }

    /**
     * Opens file chooser to browse and select a NIC back photo.
     */
    public void browseNicBack() {
        JFileChooser jf = new JFileChooser();
        jf.showOpenDialog(null);
        File f = jf.getSelectedFile();
        home.setNicbpath(f.getAbsolutePath());
        try {
            BufferedImage bi = ImageIO.read(new File(home.getNicbpath()));
            Image img = bi.getScaledInstance(104, 96, Image.SCALE_SMOOTH);
            ImageIcon li = new ImageIcon(img);
            home.getLblImg3().setIcon(li);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error loading image.");
        }
    }

    /**
     * Clears the customer form fields.
     */
    public void clearForm() {
        home.getTxtNic().setText(null);
        home.getTxtCusname().setText(null);
        home.getTxtTele().setText(null);
        home.getTxtCusaddress().setText(null);
        home.getLblImg2().setIcon(null);
        home.getLblImg3().setIcon(null);
    }

    /**
     * Generates the customer details Jasper report.
     */
    public void generateCustomerReport() {
        try {
            Connection con = DatabaseHelper.getConnection();
            String reportpath = "C:\\Users\\Narada Prabath\\Documents\\NetBeansProjects\\Car_rental\\lib\\Cherry_Table_customer.jrxml";
            JasperReport jr = JasperCompileManager.compileReport(reportpath);
            JasperPrint jp = JasperFillManager.fillReport(jr, null, con);
            JasperViewer.viewReport(jp);
            con.close();
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(home, ex);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(home, "Data base not properly connect ");
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(home, "Error occur in the reporting tool ");
        }
    }
}
