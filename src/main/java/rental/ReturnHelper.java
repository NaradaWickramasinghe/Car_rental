package rental;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.*;
import java.sql.*;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;

/**
 * Handles all business logic for the Return & Billing tab.
 * Extracted from Home.java to reduce file size and improve maintainability.
 *
 * @author Narada Prabath
 */
public class ReturnHelper {

    private final Home home;

    public ReturnHelper(Home home) {
        this.home = home;
    }

    /**
     * Searches for a rented vehicle by customer NIC.
     * Loads customer NIC photos, rental details, and vehicle image.
     */
    public void searchByNic() {
        String searchnic = home.getTxtReturnnic().getText();
        String regno = null;

        // --- Part 1: Get customer name and NIC photos ---
        try {
            Connection con = DatabaseHelper.getConnection();

            String sql = "SELECT name,nicfront,nicback FROM customer WHERE nic=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, searchnic);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                String name = rs.getString("name");
                System.out.println(name);
                home.getTxtReturncusName().setText(name);

                Blob imageBlob = rs.getBlob("nicfront");
                InputStream binaryStream = imageBlob.getBinaryStream(1, imageBlob.length());
                BufferedImage img = ImageIO.read(binaryStream);
                ImageIcon icon = new ImageIcon(img);
                Image scaledImage = icon.getImage().getScaledInstance(
                        home.getLblReturnNicfront().getWidth(), home.getLblReturnNicfront().getHeight(), Image.SCALE_SMOOTH);
                home.getLblReturnNicfront().setIcon(new ImageIcon(scaledImage));

                Blob imageBlob2 = rs.getBlob("nicback");
                InputStream binaryStream2 = imageBlob2.getBinaryStream(1, imageBlob2.length());
                BufferedImage img2 = ImageIO.read(binaryStream2);
                ImageIcon icon2 = new ImageIcon(img2);
                Image scaledImage2 = icon2.getImage().getScaledInstance(
                        home.getLblReturnBackNic().getWidth(), home.getLblReturnBackNic().getHeight(), Image.SCALE_SMOOTH);
                home.getLblReturnBackNic().setIcon(new ImageIcon(scaledImage2));

                con.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(home, e);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(home, ex);
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(home, "this data doesn' t has image ");
        }

        // --- Part 2: Get rental details from rent table ---
        try {
            Connection con = DatabaseHelper.getConnection();

            String sql2 = "SELECT rentid,rentdate,overduedate,regno FROM rent WHERE nic=?";
            PreparedStatement pst2 = con.prepareStatement(sql2);
            pst2.setString(1, searchnic);

            ResultSet rs2 = pst2.executeQuery();

            if (rs2.next()) {
                String rentid = rs2.getString("rentid");
                String rentdate = rs2.getString("rentdate");
                System.out.println(rentdate);
                String overduedate = rs2.getString("overduedate");
                regno = rs2.getString("regno");

                home.getTxtOverduedateReturn().setText(overduedate);
                home.getTxtRenteddate().setText(rentdate);
                home.getTxtRegnoForRented().setText(regno);
                home.getTxtRentedId().setText(rentid);
                System.out.println(regno);
            }
            con.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(home, ex);
        }

        // --- Part 3: Get vehicle details and image ---
        try {
            Connection con = DatabaseHelper.getConnection();

            String sql3 = "SELECT model,category,image FROM registration WHERE regno=?";
            PreparedStatement pst3 = con.prepareStatement(sql3);
            pst3.setString(1, regno);

            ResultSet rs3 = pst3.executeQuery();
            if (rs3.next()) {
                home.getTxtModelReturn().setText(rs3.getString("model"));
                home.getJComboBoxreturn().setSelectedItem(rs3.getString("category"));

                Blob imageBlob3 = rs3.getBlob("image");
                InputStream binaryStream3 = imageBlob3.getBinaryStream(1, imageBlob3.length());
                BufferedImage img3 = ImageIO.read(binaryStream3);
                ImageIcon icon3 = new ImageIcon(img3);
                Image scaledImage3 = icon3.getImage().getScaledInstance(
                        home.getLblReturnVehicle().getWidth(), home.getLblReturnVehicle().getHeight(), Image.SCALE_SMOOTH);
                home.getLblReturnVehicle().setIcon(new ImageIcon(scaledImage3));
            }
            con.close();
        } catch (ClassNotFoundException ex) {
            // silently handle
        } catch (SQLException ex) {
            // silently handle
        } catch (IOException ex) {
            // silently handle
        }
    }

    /**
     * Calculates rental fees, late charges, and final amount.
     */
    public void calculateFees() {
        home.getBtnReturnedMain().setVisible(true);
        String regno = null;
        Date rdate = null;
        Date odate = null;
        String nic = home.getTxtReturnnic().getText();

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

        int inDays = 0;
        double finalprice = 0;
        double latefee = 0;

        // --- Part 1: Calculate rental duration and late days ---
        try {
            Connection con = DatabaseHelper.getConnection();

            String sql = "SELECT rentdate,overduedate,regno FROM rent WHERE nic=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, nic);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                rdate = rs.getDate("rentdate");
                odate = rs.getDate("overduedate");
                regno = rs.getString("regno");
                System.out.println(rdate);
                System.out.println(odate);
                System.out.println(regno);
            }

            long diffInMillis = odate.getTime() - rdate.getTime();
            inDays = (int) (diffInMillis / (1000 * 60 * 60 * 24));
            System.out.println("Difference in days (int): " + inDays);

            home.getTxtOverRent().setText(Integer.toString(inDays));
            Date returndate = home.getJDateChooser2().getDate();
            long milisecond2 = returndate.getTime() - odate.getTime();
            int dayformat = (int) (milisecond2 / (1000 * 60 * 60 * 24));

            if (dayformat == 0) {
                home.getTxtLateDates().setText("0");
            } else {
                home.getTxtLateDates().setText(Integer.toString(dayformat));
            }
            con.close();
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(home, ex);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(home, ex);
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(home, "NO data to complete Calculation", "Error", JOptionPane.ERROR_MESSAGE);
        }

        // --- Part 2: Calculate fees based on vehicle category ---
        try {
            Connection con = DatabaseHelper.getConnection();
            String sql2 = "SELECT category FROM registration WHERE regno=?";
            PreparedStatement pst2 = con.prepareStatement(sql2);
            pst2.setString(1, regno);

            ResultSet rs2 = pst2.executeQuery();
            rs2.next();
            String category = rs2.getString("category");
            System.out.println(category);

            if (category.equals("Car")) {
                latefee = overdcar * inDays;
                finalprice = car + (latefee);
            } else if (category.equals("SUV")) {
                latefee = overdluxarycar * inDays;
                finalprice = luxarycar + (latefee);
            } else if (category.equals("Van")) {
                System.out.println("ggggggggg");
                latefee = overdvan * inDays;
                finalprice = van + latefee;
            } else if (category.equals("MiniVan")) {
                latefee = overdminivan * inDays;
                finalprice = minivan + (latefee);
            } else if (category.equals("ThreeWeel")) {
                latefee = overdthreeweel * inDays;
                finalprice = threeweel + (latefee);
            } else if (category.equals("Scooter")) {
                latefee = overdScooter * inDays;
                finalprice = Scooter + (latefee);
            } else if (category.equals("Bike")) {
                latefee = overdbike * inDays;
                finalprice = bike + (latefee);
            } else if (category.equals("Caterpiller")) {
                latefee = overdcatapiller * inDays;
                finalprice = catapiller + (latefee);
            }
            home.getTxtFinalamount().setText(Double.toString(finalprice));
            home.getTxtLatedatefee().setText(Double.toString(latefee));
            con.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(home, ex);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(home, ex);
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(home, "NO data to complete Calculation", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Processes the vehicle return — updates availability and inserts a bill record.
     */
    public void processReturn() {
        String regno = home.getTxtRegnoForRented().getText();
        int rentid = Integer.parseInt(home.getTxtRentedId().getText());
        String rentdate = home.getTxtRenteddate().getText();
        String overdate = home.getTxtOverduedateReturn().getText();
        String model = home.getTxtModelReturn().getText();
        Date returndate = home.getJDateChooser2().getDate();
        String latedates = home.getTxtLateDates().getText();
        String latefeeStr = home.getTxtLatedatefee().getText();
        String finalamount = home.getTxtFinalamount().getText();

        // --- Part 1: Update vehicle availability back to YES ---
        try {
            Connection con = DatabaseHelper.getConnection();
            String sql = "Update registration set availability =? where regno=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, "YES");
            pst.setString(2, regno);
            pst.executeUpdate();
            con.close();
            JOptionPane.showMessageDialog(home, "Successfully Rentered");
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(home, e);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(home, e);
        }

        // --- Part 2: Insert bill record ---
        try {
            Connection con = DatabaseHelper.getConnection();
            String sql2 = "INSERT INTO bill(rentid,rentdate,overduedate,regno,model,returndate,latedates,latefee,finalamount) VALUES(?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst2 = con.prepareStatement(sql2);
            pst2.setInt(1, rentid);
            pst2.setString(2, rentdate);
            pst2.setString(3, overdate);
            pst2.setString(4, regno);
            pst2.setString(5, model);
            pst2.setObject(6, returndate);
            pst2.setString(7, latedates);
            pst2.setString(8, latefeeStr);
            pst2.setString(9, finalamount);
            pst2.executeUpdate();
            con.close();
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(home, e);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(home, e);
        }
    }

    /**
     * Generates the bill Jasper report.
     */
    public void generateBillReport() {
        try {
            Connection con = DatabaseHelper.getConnection();
            String reportpath = "C:\\Users\\Narada Prabath\\Documents\\NetBeansProjects\\Car_rental\\lib\\billdata.jrxml";
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
