/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coen.pkg280.parse.and.populate;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeSet;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import javax.swing.table.DefaultTableModel;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


/**
 *
 * @author Qi
 */
public class hw3 extends javax.swing.JFrame {
    Connection con = null;
    ResultSet re = null;
    PreparedStatement pst =null;
    
    
    LinkedList<JCheckBox> All_main_category = new LinkedList<>();
    LinkedList<JCheckBox> All_sub_category = new LinkedList<>();
    ArrayList<String> main_categories_list = new ArrayList<>();
    //TreeSet<String> fix_main_categories_list = new TreeSet();
    TreeSet<String> sub_categories_list = new TreeSet();
    /**
     * Creates new form hw3
     */
    public hw3() {
        initComponents();
        index_main_category();
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = jTable1.rowAtPoint(evt.getPoint());
                int col = jTable1.columnAtPoint(evt.getPoint());
                if (row >= 0 && col >= 0) {
                       System.out.println(row);
                       if(getColumnByName(jTable1, "B_ID") == 0){
                           System.out.println(jTable1.getValueAt(row,0));
                           get_review_Bus(jTable1.getValueAt(row,0));
                       } 
                       if(getColumnByName(jTable1, "ID") == 3){
                           get_review_User(jTable1.getValueAt(row,3));
                       }
                       
                }
            }
        });
    }
    private void get_review_Bus(Object s) {
        DefaultTableModel model;
            model = new DefaultTableModel();
            jTable1.setModel(model);
            model.addColumn("VOTES");
            model.addColumn("USER_ID");
            model.addColumn("REVIEW_ID");
            model.addColumn("STARS");
            model.addColumn("CREATE_DATE");
            model.addColumn("BUSINESS_ID");
            String id = (String) s;
            try {
                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:orcl", "hr",
					"hr");
                    
                    StringBuilder sb = new StringBuilder("SELECT VOTES as VOTES,"
                            + " USER_ID AS USER_ID," + " REVIEW_ID AS REVIEW_ID,"
                            + " STARS AS STARS," + " CREATE_DATE AS CREATE_DATE,"
                            + " BUSINESS_ID AS BUSINESS_ID"
                            + " FROM YELP_REVIEW  WHERE BUSINESS_ID = '"+id + "'");
                    System.out.println(sb.toString());
                    PreparedStatement sta = con.prepareStatement(sb.toString()); 
                        java.sql.ResultSet rs = sta.executeQuery(sb.toString());
                        while (rs.next()) {
                            model.addRow(new Object[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)});
                        }
                        con.close();
                        rs.close();
                        sta.close();
                } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Exception: " + e.getMessage());
                    }
    }
    private void get_review_User(Object s) {
        DefaultTableModel model;
            model = new DefaultTableModel();
            jTable1.setModel(model);
            model.addColumn("VOTES");
            model.addColumn("USER_ID");
            model.addColumn("REVIEW_ID");
            model.addColumn("STARS");
            model.addColumn("CREATE_DATE");
            model.addColumn("BUSINESS_ID");
            String id = (String) s;
            try {
                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:orcl", "hr",
					"hr");
                    
                    StringBuilder sb = new StringBuilder("SELECT VOTES as VOTES,"
                            + " USER_ID AS USER_ID," + " REVIEW_ID AS REVIEW_ID,"
                            + " STARS AS STARS," + " CREATE_DATE AS CREATE_DATE,"
                            + " BUSINESS_ID AS BUSINESS_ID"
                            + " FROM YELP_REVIEW  WHERE USER_ID = '"+id + "'");
                    System.out.println(sb.toString());
                    PreparedStatement sta = con.prepareStatement(sb.toString()); 
                        java.sql.ResultSet rs = sta.executeQuery(sb.toString());
                        while (rs.next()) {
                            model.addRow(new Object[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)});
                        }
                        con.close();
                        rs.close();
                        sta.close();
                } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Exception: " + e.getMessage());
                    }
    }
    private int getColumnByName(JTable table, String name) {
        for (int i = 0; i < table.getColumnCount(); ++i)
            if (table.getColumnName(i).equals(name))
                return i;
        return -1;
    }
    private void index_main_category() {
        
        All_main_category.add(jCheckBox1);
        All_main_category.add(jCheckBox2);
        All_main_category.add(jCheckBox3);
        All_main_category.add(jCheckBox4);
        All_main_category.add(jCheckBox5);
        All_main_category.add(jCheckBox6);
        All_main_category.add(jCheckBox7);
        All_main_category.add(jCheckBox8);
        All_main_category.add(jCheckBox9);
        All_main_category.add(jCheckBox10);
        All_main_category.add(jCheckBox11);
        All_main_category.add(jCheckBox12);
        All_main_category.add(jCheckBox13);
        All_main_category.add(jCheckBox14);
        All_main_category.add(jCheckBox15);
        All_main_category.add(jCheckBox16);
        All_main_category.add(jCheckBox17);
        All_main_category.add(jCheckBox18);
        All_main_category.add(jCheckBox19);
        All_main_category.add(jCheckBox20);
        All_main_category.add(jCheckBox21);
        All_main_category.add(jCheckBox22);
        All_main_category.add(jCheckBox23);
        All_main_category.add(jCheckBox24);
        All_main_category.add(jCheckBox25);
        All_main_category.add(jCheckBox26);
        All_main_category.add(jCheckBox27);
        All_main_category.add(jCheckBox28);

        /*Iterator<JCheckBox> it = All_main_category.iterator();
        while (it.hasNext()) {
            fix_main_categories_list.add(it.next().getText());

        }*/
    }
    private ArrayList<String> buildCategoriesList() {
        Iterator<JCheckBox> it = All_main_category.iterator();
        JCheckBox temp;
        //System.out.println("11111");
        while (it.hasNext()) {
            temp = it.next();
            if (temp.isSelected()) {
                main_categories_list.add(temp.getText());
                System.out.println(temp.getText());
            }
        }
        return main_categories_list;
    }
    ;
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        jCheckBox6 = new javax.swing.JCheckBox();
        jCheckBox7 = new javax.swing.JCheckBox();
        jCheckBox8 = new javax.swing.JCheckBox();
        jCheckBox9 = new javax.swing.JCheckBox();
        jCheckBox10 = new javax.swing.JCheckBox();
        jCheckBox11 = new javax.swing.JCheckBox();
        jCheckBox12 = new javax.swing.JCheckBox();
        jCheckBox13 = new javax.swing.JCheckBox();
        jCheckBox14 = new javax.swing.JCheckBox();
        jCheckBox15 = new javax.swing.JCheckBox();
        jCheckBox16 = new javax.swing.JCheckBox();
        jCheckBox17 = new javax.swing.JCheckBox();
        jCheckBox18 = new javax.swing.JCheckBox();
        jCheckBox19 = new javax.swing.JCheckBox();
        jCheckBox20 = new javax.swing.JCheckBox();
        jCheckBox21 = new javax.swing.JCheckBox();
        jCheckBox22 = new javax.swing.JCheckBox();
        jCheckBox23 = new javax.swing.JCheckBox();
        jCheckBox24 = new javax.swing.JCheckBox();
        jCheckBox25 = new javax.swing.JCheckBox();
        jCheckBox26 = new javax.swing.JCheckBox();
        jCheckBox27 = new javax.swing.JCheckBox();
        jCheckBox28 = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        jComboBox2 = new javax.swing.JComboBox<>();
        jTextField2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jComboBox5 = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jComboBox6 = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        jComboBox7 = new javax.swing.JComboBox<>();
        jLabel20 = new javax.swing.JLabel();
        jComboBox8 = new javax.swing.JComboBox<>();
        jTextField9 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jComboBox9 = new javax.swing.JComboBox<>();
        jButton5 = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jCheckBox1.setText("Active Life");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jCheckBox2.setText("Arts & Entertainment");

        jCheckBox3.setText("Automotive");

        jCheckBox4.setText("Car Rental");
        jCheckBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox4ActionPerformed(evt);
            }
        });

        jCheckBox5.setText("Cafes");

        jCheckBox6.setText("Beauty & Spas");

        jCheckBox7.setText("Convenience Stores");
        jCheckBox7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox7ActionPerformed(evt);
            }
        });

        jCheckBox8.setText("Dentists");

        jCheckBox9.setText("Doctors");

        jCheckBox10.setText("Drugstores");

        jCheckBox11.setText("Department Stores");

        jCheckBox12.setText("Education");

        jCheckBox13.setText("Event Planning & Services");

        jCheckBox14.setText("Flowers & Gifts");

        jCheckBox15.setText("Food");

        jCheckBox16.setText("Health & Medical");

        jCheckBox17.setText("Home Services");

        jCheckBox18.setText("Home & Garden");

        jCheckBox19.setText("Hospitals");

        jCheckBox20.setText("Hotels & Travel");

        jCheckBox21.setText("Hardware Stores");

        jCheckBox22.setText("Grocery");

        jCheckBox23.setText("Medical Centers");

        jCheckBox24.setText("Nurseries & Gardening");

        jCheckBox25.setText("Nightlife");

        jCheckBox26.setText("Restaurants");

        jCheckBox27.setText("Shopping");

        jCheckBox28.setText("Transportation");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox22)
                            .addComponent(jCheckBox23)
                            .addComponent(jCheckBox24)
                            .addComponent(jCheckBox26)
                            .addComponent(jCheckBox25)
                            .addComponent(jCheckBox28)
                            .addComponent(jCheckBox27))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox21)
                            .addComponent(jCheckBox19)
                            .addComponent(jCheckBox1)
                            .addComponent(jCheckBox3)
                            .addComponent(jCheckBox4)
                            .addComponent(jCheckBox5)
                            .addComponent(jCheckBox6)
                            .addComponent(jCheckBox8)
                            .addComponent(jCheckBox7)
                            .addComponent(jCheckBox10)
                            .addComponent(jCheckBox9)
                            .addComponent(jCheckBox2)
                            .addComponent(jCheckBox11)
                            .addComponent(jCheckBox12)
                            .addComponent(jCheckBox13)
                            .addComponent(jCheckBox14)
                            .addComponent(jCheckBox15)
                            .addComponent(jCheckBox16)
                            .addComponent(jCheckBox17)
                            .addComponent(jCheckBox18)
                            .addComponent(jCheckBox20))
                        .addContainerGap(93, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jCheckBox1)
                .addGap(6, 6, 6)
                .addComponent(jCheckBox2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBox4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBox5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBox6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox8)
                .addGap(6, 6, 6)
                .addComponent(jCheckBox9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBox11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBox12)
                .addGap(3, 3, 3)
                .addComponent(jCheckBox13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox14)
                .addGap(6, 6, 6)
                .addComponent(jCheckBox15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox16)
                .addGap(3, 3, 3)
                .addComponent(jCheckBox17)
                .addGap(3, 3, 3)
                .addComponent(jCheckBox18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBox19)
                .addGap(7, 7, 7)
                .addComponent(jCheckBox20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox21)
                .addGap(16, 16, 16)
                .addComponent(jCheckBox22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBox24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBox27)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox28)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel1);

        jLabel1.setText("Main Category");

        jLabel2.setText("                                                       Business");

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jTextField1.setText("Hour");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jTextField2.setText("Hour");

        jLabel5.setText("From");

        jLabel6.setText("To");

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "=, >, <", "=", ">", "<" }));

        jLabel7.setText("No. of Checkins");

        jLabel8.setText("Value");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField2))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(jTextField3)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel3.setText("Checkin");

        jLabel4.setText("Sub-Category");

        jButton1.setText("Seaerch Business");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Apply sub-category");

        jLabel9.setText("Reviews");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel10.setText("From");

        jLabel11.setText("To");

        jTextField4.setText("YYYY-MM-DD");

        jTextField5.setText("YYYY-MM-DD");

        jLabel12.setText("Stars");

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "=, >, <", "=", ">", "<" }));

        jLabel13.setText("Value");

        jLabel14.setText("Votes");

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "=, >, <", "=", ">", "<" }));

        jLabel15.setText("Value");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField4))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(30, 30, 30)
                        .addComponent(jTextField5))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 8, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        jLabel16.setText("Users");

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel17.setText("Member since");

        jTextField8.setText("YYYY-MM");

        jLabel18.setText("Review count");

        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "=, >, <", "=", ">", "<" }));

        jLabel19.setText("No. firends");

        jComboBox7.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "=, >, <", "=", ">", "<" }));

        jLabel20.setText("Stars");

        jComboBox8.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "=, >, <", "=", ">", "<" }));

        jLabel21.setText("Select");

        jComboBox9.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AND, OR between attributes", "AND", "Stars", "Friends", "Review", "Date" }));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField10))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField9))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jComboBox8, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField11))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox9, 0, 208, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jComboBox8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jComboBox9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(62, Short.MAX_VALUE))
        );

        jButton5.setText("Search users");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel22.setText("Result");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addGap(345, 345, 345)
                                .addComponent(jLabel22))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(123, 123, 123)
                                        .addComponent(jLabel9))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(91, 91, 91)
                                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(jButton1)
                        .addGap(62, 62, 62)
                        .addComponent(jButton2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(116, 116, 116))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
                        .addComponent(jScrollPane2)
                        .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton5))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCheckBox7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox7ActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jCheckBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox4ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        main_categories_list.removeAll(main_categories_list);
        main_categories_list = buildCategoriesList();
        try {
            //String query = "select CITY, STATE FROM YELP_BUSINESS";
            
            DefaultTableModel model;
            model = new DefaultTableModel();
            jTable1.setModel(model);
            model.addColumn("B_ID");
            model.addColumn("Address");
            model.addColumn("Category");
            model.addColumn("City");
            model.addColumn("Review_Count");
            model.addColumn("Name");
            model.addColumn("State");
            model.addColumn("Stars");
            try {
                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:orcl", "hr",
					"hr");
                    
                    StringBuilder sb = new StringBuilder("SELECT B.BUSINESS_ID as B_ID,"
                            + " B.FULL_ADDRESS AS address," + " B.CATEGORIES AS Category,"
                            + " B.CITY AS City," + " B.REVIEWS_COUNT AS Review_Count,"
                            + " B.FULL_NAME AS Name,"+ " B.STATE AS State,"
                            + " B.STARS AS Stars"
                            + " FROM YELP_BUSINESS B JOIN YELP_REVIEW R ON (R.BUSINESS_ID = B.BUSINESS_ID)"
                            + "WHERE R.CREATE_DATE > '2000-03-01' AND R.CREATE_DATE < '2100-03-01' AND R.STARS >= 0 AND R.VOTES >=0");
                    System.out.println(sb.toString());
                    if (main_categories_list.size() == 0){
                        JOptionPane.showMessageDialog(null, "List contained 0 elements!", "Error",
                                    JOptionPane.ERROR_MESSAGE);
                    }else {
                        if (main_categories_list.size() == 1){
                            
                            sb = sb.append(" AND (REGEXP_LIKE(CATEGORIES,'"+ main_categories_list.get(0) +"')");
                            sb = sb.append(")");
                        }else {
                            sb = sb.append(" AND (REGEXP_LIKE(CATEGORIES,'"+ main_categories_list.get(0) +"')");
                            for (String mc : main_categories_list) {
                                sb = sb.append(" OR REGEXP_LIKE(CATEGORIES,'"+ mc +"')");
                            }
                            sb = sb.append(")");
                            System.out.println(sb.toString());
                        }
                        String sbs = sb.toString();
                        System.out.println(sbs);
                        String from = jTextField4.getText();
                        //System.out.println(time);
                        if (!from.equals("YYYY-MM-DD") ){
                            sbs = sbs.replace("2000-03-01",from);
                        }
                        String to = jTextField5.getText();
                        //System.out.println(time);
                        if (!to.equals("YYYY-MM-DD") ){
                            sbs = sbs.replace("2100-03-01",to);
                        }
                        
                        String stars_text = jTextField6.getText();
                        String stars_compare = jComboBox4.getSelectedItem().toString();
                        if (!stars_compare.equals("=, >, <") ){
                            if(stars_compare.equals("=")){
                                sbs = sbs.replace("R.STARS >= 0","R.STARS ="+ stars_text);
                                //System.out.println(sbs);
                            } else if (stars_compare.equals(">")) {
                                sbs = sbs.replace("R.STARS >= 0","R.STARS >"+ stars_text);
                            }else {
                                sbs = sbs.replace("R.STARS >= 0","R.STARS <"+ stars_text);
                            }
                        }
                        String votes_text = jTextField7.getText();
                        String votes_compare = jComboBox5.getSelectedItem().toString();
                        if (!votes_compare.equals("=, >, <") ){
                            if(votes_compare.equals("=")){
                                sbs = sbs.replace("R.VOTES >=0","R.VOTES ="+ votes_text);
                                //System.out.println(sbs);
                            } else if (votes_compare.equals(">")) {
                                sbs = sbs.replace("R.VOTES >=0","R.VOTES >"+ votes_text);
                            }else {
                                sbs = sbs.replace("R.VOTES >=0","R.VOTES <"+ votes_text);
                            }
                        }
                        
                        PreparedStatement sta = con.prepareStatement(sbs); 
                        java.sql.ResultSet rs = sta.executeQuery(sbs);

                        while (rs.next()) {
                            model.addRow(new Object[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8)});
                        }

                        sta.close();
                    }
                    int rows = jTable1.getRowCount();
                        System.out.println(rows);
                    con.close();
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Exception: " + e.getMessage());
                    }
            
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        try {
            //String query = "select CITY, STATE FROM YELP_BUSINESS";
            DefaultTableModel model;
            model = new DefaultTableModel();
            jTable1.setModel(model);
            model.addColumn("Yelping_since");
            model.addColumn("Review_Count");
            model.addColumn("Name");
            model.addColumn("ID");
            model.addColumn("Friends");
            model.addColumn("Stars");
            try {
                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:orcl", "hr",
					"hr");
                    
                    StringBuilder sb = new StringBuilder("SELECT YELPING_SINCE as Yelping_since,"
                            + " REVIEW_COUNT AS Review_Count," + " USER_NAME AS Name,"
                            + " USER_ID AS ID," + " FRIENDS AS Friends,"
                            + " AVERAGE_STARS AS Stars"
                            + " FROM YELP_USER  WHERE FRIENDS >= 0  AND REVIEW_COUNT >= 0 AND AVERAGE_STARS >= 0 AND YELPING_SINCE >= '2000-03' ");/**/
                    //System.out.println(sb.toString());
                    String sbs = sb.toString();
                    String time = jTextField8.getText();
                    //System.out.println(time);
                    if (!time.equals("YYYY-MM") ){
                        sbs = sbs.replace("2000-03",time);
                    }
                    System.out.println(sbs);
                    String review_text = jTextField9.getText();
        
                    String review_compare = jComboBox6.getSelectedItem().toString();
                    if (!review_compare.equals("=, >, <") ){
                        if(review_compare.equals("=")){
                            sbs = sbs.replace("REVIEW_COUNT >= 0","REVIEW_COUNT ="+ review_text);
                            //System.out.println(sbs);
                        } else if (review_compare.equals(">")) {
                            sbs = sbs.replace("REVIEW_COUNT >= 0","REVIEW_COUNT >"+ review_text);
                        }else {
                            sbs = sbs.replace("REVIEW_COUNT >= 0","REVIEW_COUNT <"+ review_text);
                        }
                    }
                    String friends_text = jTextField10.getText();
                    String friends_compare = jComboBox7.getSelectedItem().toString();
                    if (!friends_compare.equals("=, >, <") ){
                        if(friends_compare.equals("=")){
                            sbs = sbs.replace("FRIENDS >= 0","FRIENDS ="+ friends_text);
                            //System.out.println(sbs);
                        } else if (friends_compare.equals(">")) {
                            sbs = sbs.replace("FRIENDS >= 0","FRIENDS >"+ friends_text);
                        }else {
                            sbs = sbs.replace("FRIENDS >= 0","FRIENDS <"+ friends_text);
                        }
                    }
                    
                    String star_text = jTextField11.getText();
                    String star_compare = jComboBox8.getSelectedItem().toString();
                    if (!star_compare.equals("=, >, <") ){
                        if(star_compare.equals("=")){
                            sbs = sbs.replace("AVERAGE_STARS >= 0","AVERAGE_STARS ="+ star_text);
                            //System.out.println(sbs);
                        } else if (star_compare.equals(">")) {
                            sbs = sbs.replace("AVERAGE_STARS >= 0","AVERAGE_STARS >"+ star_text);
                        }else {
                            sbs = sbs.replace("AVERAGE_STARS >= 0","AVERAGE_STARS <"+ star_text);
                        }
                    }
                    
                    String combo_value = jComboBox9.getSelectedItem().toString();
                    if (!combo_value.equals("AND, OR between attributes") ){
                        if(combo_value.equals("Stars")){
                            sbs = sb.toString().replace("AVERAGE_STARS >= 0","AVERAGE_STARS "+ star_compare +star_text);
                            //System.out.println(sbs);
                        } else if (combo_value.equals("Friends")) {
                            sbs = sb.toString().replace("FRIENDS >= 0","FRIENDS "+ friends_compare + friends_text);
                        }else if (combo_value.equals("Review")){
                            sbs = sb.toString().replace("REVIEW_COUNT >= 0","REVIEW_COUNT "+ review_compare +  review_text);
                        }else if (combo_value.equals("Date")){
                            sbs = sb.toString().replace("2000-03",time);
                        }
                    }
                    
                   
                        /*if (main_categories_list.size() == 1){
                            
                            sb.append(" WHERE REGEXP_LIKE(CATEGORIES,'"+ main_categories_list.get(0) +"')");
                            
                        }else {
                            sb.append(" WHERE REGEXP_LIKE(CATEGORIES,'"+ main_categories_list.get(0) +"')");
                            for (String mc : main_categories_list) {
                                sb.append(" OR REGEXP_LIKE(CATEGORIES,'"+ mc +"')");
                            }
                            System.out.println(sb.toString());
                        }*/
                        
                        PreparedStatement sta = con.prepareStatement(sbs); 
                        java.sql.ResultSet rs = sta.executeQuery(sbs);

                        while (rs.next()) {
                            model.addRow(new Object[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)});
                        }
                        int rows = jTable1.getRowCount();
                        System.out.println(rows);

                        sta.close();
                    
                    
                    con.close();
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Exception: " + e.getMessage());
                    }
            
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(hw3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(hw3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(hw3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(hw3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new hw3().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox10;
    private javax.swing.JCheckBox jCheckBox11;
    private javax.swing.JCheckBox jCheckBox12;
    private javax.swing.JCheckBox jCheckBox13;
    private javax.swing.JCheckBox jCheckBox14;
    private javax.swing.JCheckBox jCheckBox15;
    private javax.swing.JCheckBox jCheckBox16;
    private javax.swing.JCheckBox jCheckBox17;
    private javax.swing.JCheckBox jCheckBox18;
    private javax.swing.JCheckBox jCheckBox19;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox20;
    private javax.swing.JCheckBox jCheckBox21;
    private javax.swing.JCheckBox jCheckBox22;
    private javax.swing.JCheckBox jCheckBox23;
    private javax.swing.JCheckBox jCheckBox24;
    private javax.swing.JCheckBox jCheckBox25;
    private javax.swing.JCheckBox jCheckBox26;
    private javax.swing.JCheckBox jCheckBox27;
    private javax.swing.JCheckBox jCheckBox28;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JCheckBox jCheckBox7;
    private javax.swing.JCheckBox jCheckBox8;
    private javax.swing.JCheckBox jCheckBox9;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JComboBox<String> jComboBox6;
    private javax.swing.JComboBox<String> jComboBox7;
    private javax.swing.JComboBox<String> jComboBox8;
    private javax.swing.JComboBox<String> jComboBox9;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
