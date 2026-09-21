package rental;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;

/**
 * Handles all business logic for the Rental tab.
 * Extracted from Home.java to reduce file size and improve maintainability.
 *
 * @author Narada Prabath
 */
public class RentalHelper {

    private final Home home;

    public RentalHelper(Home home) {
        this.home = home;
    }

    /**
     * Searches vehicles by category and populates jTable3.
     */
    public void searchByCategory() {
        String category = home.getComboCategory().getSelectedItem().toString();
        try {
            Connection con = DatabaseHelper.getConnection();
            String sql = "SELECT * FROM registration WHERE category=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, category);

            ResultSet rs = pst.executeQuery();

            ResultSetMetaData rd = rs.getMetaData();
            int c = rd.getColumnCount();
            DefaultTableModel df = (DefaultTableModel) home.getJTable3().getModel();
            df.setRowCount(0);

            while (rs.next()) {
                List<String> ay = new ArrayList<>();

                for (int i = 1; i <= c; i++) {
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
     * Handles table row click in rental table — loads selected vehicle details and image.
     */
    public void onRentalTableRowClicked() {
        DefaultTableModel df = (DefaultTableModel) home.getJTable3().getModel();
        int selectedindex = home.getJTable3().getSelectedRow();

        // Setting other fields from selected row
        home.getTxtMake2().setText(df.getValueAt(selectedindex, 1).toString());
        home.getTxtModel2().setText(df.getValueAt(selectedindex, 2).toString());
        home.getJComboBox3().setSelectedItem(df.getValueAt(selectedindex, 3).toString());
        home.getTxtRegnoForRental().setText(df.getValueAt(selectedindex, 0).toString());

        try {
            Connection con = DatabaseHelper.getConnection();
            String regno = df.getValueAt(selectedindex, 0).toString();

            String sql = "SELECT * FROM registration WHERE regno=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, regno);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                Blob imageBlob = rs.getBlob("image");
                InputStream binaryStream = imageBlob.getBinaryStream(1, imageBlob.length());
                BufferedImage img = ImageIO.read(binaryStream);
                ImageIcon icon = new ImageIcon(img);

                Image scaledImage = icon.getImage().getScaledInstance(
                        home.getLblImg1().getWidth(), home.getLblImg1().getHeight(), Image.SCALE_SMOOTH);
                home.getLblImg1().setIcon(new ImageIcon(scaledImage));
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(home, e);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(home, ex);
        }
    }

    /**
     * Rents a vehicle to a customer. Validates NIC, inserts into rent table,
     * and updates vehicle availability.
     */
    public void rentVehicle() {
        DefaultTableModel df = (DefaultTableModel) home.getJTable3().getModel();
        int selectedindex = home.getJTable3().getSelectedRow();
        String rentnic = home.getTxtRentnic().getText();
        int availability = home.getJComboBox3().getSelectedIndex();
        System.out.println("availability index" + availability);

        if (availability == 0) {
            try {
                Connection con = DatabaseHelper.getConnection();

                String sql = "SELECT * FROM customer WHERE nic=?";
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setString(1, rentnic);
                ResultSet rs = pst.executeQuery();

                if (rs.next()) {
                    con.close();
                    con = DatabaseHelper.getConnection();
                    System.out.println("already availble nic");
                    LocalDateTime currentDate = LocalDateTime.now();

                    String sql2 = "INSERT INTO rent( rentdate,overduedate,regno,nic) VALUES (?,?,?,?) ";
                    PreparedStatement pst2 = con.prepareStatement(sql2);

                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    pst2.setObject(1, currentDate);
                    System.out.println(currentDate);
                    String ddate = sdf.format(home.getJDateChooser1().getDate());
                    pst2.setString(2, ddate);
                    pst2.setString(3, df.getValueAt(selectedindex, 0).toString());
                    pst2.setString(4, rentnic);

                    pst2.executeUpdate();
                    home.getJComboBox3().setSelectedItem("NO");

                    con.close();
                    con = DatabaseHelper.getConnection();
                    String sql3 = "Update registration set availability =? where regno=?";
                    PreparedStatement pst3 = con.prepareStatement(sql3);

                    pst3.setString(1, "NO");
                    pst3.setString(2, home.getTxtRegnoForRental().getText());
                    pst3.executeUpdate();
                    JOptionPane.showMessageDialog(home, "Succesfully rented ");
                    con.close();
                } else {
                    System.out.println("please correctly insert or register first in the customer tab");
                    JOptionPane.showMessageDialog(home, "Invalid NIC or Not Available in our data base");
                }
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(home, ex);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(home, ex);
            }
        } else {
            JOptionPane.showMessageDialog(home, "Vehicle Already Rent (NOW NOT AVAILABLE)", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Generates the vehicle availability Jasper report.
     */
    public void generateAvailabilityReport() {
        try {
            Connection con = DatabaseHelper.getConnection();
            String reportpath = "C:\\Users\\Narada Prabath\\Documents\\NetBeansProjects\\Car_rental\\lib\\availability.jrxml";
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
