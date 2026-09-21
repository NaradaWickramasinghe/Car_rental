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

/**
 * Handles all Registration tab logic (Vehicle CRUD).
 * Extracted from Home.java to reduce class size.
 *
 * @author Narada Prabath
 */
public class RegistrationHelper {

    private final Home home;

    public RegistrationHelper(Home home) {
        this.home = home;
    }

    /**
     * Loads registration table data from database.
     */
    public void tableData() {
        try {
            Connection con = DatabaseHelper.getConnection();
            Statement st = con.createStatement();
            String sql = "SELECT * FROM registration";
            ResultSet rs = st.executeQuery(sql);

            ResultSetMetaData rd = rs.getMetaData();
            int c = rd.getColumnCount();
            DefaultTableModel df = (DefaultTableModel) home.getJTable1().getModel();
            df.setRowCount(0);

            while (rs.next()) {
                List<String> ay = new ArrayList<>();
                for (int i = 1; i <= c; i++) {
                    ay.add(rs.getString(2));
                    ay.add(rs.getString(3));
                    ay.add(rs.getString(4));
                    ay.add(rs.getString(5));
                    ay.add(rs.getString(6));
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
     * Auto-generates the next vehicle registration ID.
     */
    public void autoGenerateID() {
        try {
            Connection con = DatabaseHelper.getConnection();
            String sql = "SELECT MAX(id) FROM registration";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            rs.next();
            int c1 = rs.getInt(1);
            c1++;
            home.getTxtRegno().setText("V" + c1);
            con.close();
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(home, ex);
        }
    }

    /**
     * Handles the Add Vehicle button click.
     */
    public void addVehicle() {
        try {
            Connection con = DatabaseHelper.getConnection();
            if (!home.getTxtRegno().getText().isBlank()
                    && !home.getTxtMake().getText().isBlank()
                    && !home.getTxtModel().getText().isBlank()) {
                if (home.getTxtRegno().getText().charAt(0) == 'V') {
                    if (home.getTxtTelno().getText().length() > 0 && home.getTxtTelno().getText().length() == 10) {
                        String regno = home.getTxtRegno().getText();
                        String manufacture = home.getTxtMake().getText();
                        String model = home.getTxtModel().getText();
                        String ownertel = home.getTxtTelno().getText();
                        InputStream is = new FileInputStream(new File(home.getPicpath()));

                        String availability = home.getJComboBox1().getSelectedItem().toString();
                        String category = home.getJComboBox2().getSelectedItem().toString();

                        home.getBtnAdd().setEnabled(true);
                        String sql = "INSERT INTO registration (regno, make, model, availability, ownertel,image,category) VALUES (?, ?, ?, ?, ?,?,?)";
                        PreparedStatement pst = con.prepareStatement(sql);
                        pst.setString(1, regno);
                        pst.setString(2, manufacture);
                        pst.setString(3, model);
                        pst.setString(4, availability);
                        pst.setString(5, ownertel);
                        pst.setBinaryStream(6, is);
                        pst.setString(7, category);

                        pst.executeUpdate();
                        pst.close();
                        con.close();
                        JOptionPane.showMessageDialog(home, "Sucessfully added ");
                    } else {
                        JOptionPane.showMessageDialog(home, "Invalid phone number ", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(home, "Register number must be Start from 'V'", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(home, "Fill the first 3 textBox ", "Error", JOptionPane.ERROR_MESSAGE);
            }

            tableData();
            autoGenerateID();

        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(home, e);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(home, e);
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(home, ex);
        }
    }

    /**
     * Handles the Edit Vehicle button click.
     */
    public void editVehicle() {
        DefaultTableModel df = (DefaultTableModel) home.getJTable1().getModel();
        int selectedindex = home.getJTable1().getSelectedRow();

        home.getTxtRegno().setText(df.getValueAt(selectedindex, 0).toString());
        String regno = df.getValueAt(selectedindex, 0).toString();

        String make = home.getTxtMake().getText();
        String model = home.getTxtModel().getText();
        String availability = home.getJComboBox1().getSelectedItem().toString();
        String ownertel = home.getTxtTelno().getText();

        Connection con = null;
        PreparedStatement pst = null;
        PreparedStatement pst2 = null;
        ResultSet rs = null;

        try {
            con = DatabaseHelper.getConnection();

            String sql2 = "SELECT category FROM registration WHERE regno=?";
            pst2 = con.prepareStatement(sql2);
            pst2.setString(1, regno);
            rs = pst2.executeQuery();

            String category_value = "";
            if (rs.next()) {
                category_value = rs.getString("category");
            }

            if (!category_value.equals(home.getJComboBox2().getSelectedItem().toString())) {
                JOptionPane.showMessageDialog(home, "You can't change Category");
            } else {
                String sql = "UPDATE registration SET make=?, model=?, availability=?, ownertel=? WHERE regno=?";
                pst = con.prepareStatement(sql);
                pst.setString(1, make);
                pst.setString(2, model);
                pst.setString(3, availability);
                pst.setString(4, ownertel);
                pst.setString(5, regno);

                int rowsAffected = pst.executeUpdate();
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(home, "Successfully Updated");
                    tableData();
                } else {
                    JOptionPane.showMessageDialog(home, "Update Failed");
                }
            }
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(home, e);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(home, e);
        } finally {
            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
                if (pst2 != null) pst2.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Handles the Delete Vehicle button click.
     */
    public void deleteVehicle() {
        DefaultTableModel df = (DefaultTableModel) home.getJTable1().getModel();
        int selectedindex = home.getJTable1().getSelectedRow();

        String id = df.getValueAt(selectedindex, 0).toString();
        int dialogResult = JOptionPane.showConfirmDialog(home, "Do you want to Delete the record ", "Waring", JOptionPane.YES_NO_OPTION);

        if (dialogResult == JOptionPane.YES_OPTION) {
            try {
                Connection con = DatabaseHelper.getConnection();
                String sql = "Delete from registration where regno=?";
                PreparedStatement pst = con.prepareStatement(sql);

                pst.setString(1, id);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(home, "Successfuly Deleted");
                tableData();
                autoGenerateID();
                con.close();
            } catch (ClassNotFoundException | SQLException ex) {
                JOptionPane.showMessageDialog(home, ex);
            }
        }
    }

    /**
     * Clears the registration form fields.
     */
    public void clearForm() {
        home.getTxtMake().setText(null);
        home.getTxtModel().setText(null);
        home.getTxtTelno().setText(null);
        home.getLblImg().setIcon(null);
        home.getJComboBox2().setSelectedIndex(0);
    }

    /**
     * Opens a file chooser to browse for a vehicle image.
     */
    public void browseImage() {
        JFileChooser jf = new JFileChooser();
        jf.showOpenDialog(null);
        File f = jf.getSelectedFile();
        home.setPicpath(f.getAbsolutePath());
        try {
            BufferedImage bi = ImageIO.read(new File(home.getPicpath()));
            Image img = bi.getScaledInstance(104, 96, Image.SCALE_SMOOTH);
            ImageIcon li = new ImageIcon(img);
            home.getLblImg().setIcon(li);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error loading image.");
        }
    }

    /**
     * Handles table row click — loads vehicle data and image into form.
     */
    public void onTableRowClicked() {
        DefaultTableModel df = (DefaultTableModel) home.getJTable1().getModel();
        int selectedindex = home.getJTable1().getSelectedRow();

        home.getTxtRegno().setText(df.getValueAt(selectedindex, 0).toString());
        home.getTxtMake().setText(df.getValueAt(selectedindex, 1).toString());
        home.getTxtModel().setText(df.getValueAt(selectedindex, 2).toString());
        home.getJComboBox1().setSelectedItem(df.getValueAt(selectedindex, 3).toString());
        home.getTxtTelno().setText(df.getValueAt(selectedindex, 4).toString());
        try {
            String regno = df.getValueAt(selectedindex, 0).toString();

            Connection con = DatabaseHelper.getConnection();
            String sql = "SELECT * FROM registration WHERE regno=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, regno);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                Blob imageBlob = rs.getBlob("image");
                InputStream binaryStream = imageBlob.getBinaryStream(1, imageBlob.length());
                BufferedImage img = ImageIO.read(binaryStream);
                ImageIcon icon = new ImageIcon(img);

                Image scaledImage = icon.getImage().getScaledInstance(home.getLblImg().getWidth(), home.getLblImg().getHeight(), Image.SCALE_SMOOTH);
                home.getLblImg().setIcon(new ImageIcon(scaledImage));
            }
            con.close();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(home, e);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(home, ex);
        }
    }
}
