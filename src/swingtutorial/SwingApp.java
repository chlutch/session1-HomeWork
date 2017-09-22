/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swingtutorial;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author ADMIN-PC
 */
public class SwingApp extends JFrame {
    
    private JLabel lblId, lblName, lblEmail, lblPhone, lblClass, lblRollNum, lblDob, lblHeader;
    private JButton button;
    private JFormattedTextField txtId, txtPhone;
    private JSpinner txtDob;
    private JTextField txtName, txtEmail, txtClass, txtRollNum;
    JFrame fr;
    
    public SwingApp() {
        //chinh Frame
        fr = new JFrame();
        this.fr.setSize(650, 650);
        this.fr.setLocationRelativeTo(null);
        this.fr.setLayout(new GridBagLayout());
        this.fr.setTitle("Chờ Đồng Hồ khởi động...");
        //khoi tao cac component
        lblId = new JLabel("ID:");
        lblName = new JLabel("Name:");
        lblEmail = new JLabel("Email:");
        lblPhone = new JLabel("Phone:");
        lblDob = new JLabel("Date of Birth:");
        lblClass = new JLabel("Class:");
        lblRollNum = new JLabel("RollNum:");
        button = new JButton("Nhập Vào");
        lblHeader = new JLabel("BẢNG NHẬP THÔNG TIN SINH VIÊN");
        //       MaskFormatter cua ID chap nhan kieu 3 ky tu hoa va 4 so (HHH-####).
        MaskFormatter mskId = null;
        try {
            
            mskId = new MaskFormatter("UUU-####");
            mskId.setPlaceholderCharacter('_');
        } catch (ParseException ex) {
            System.out.println("MaskFormatter cua ID bi loi");
        }
        
        txtId = new JFormattedTextField(mskId);
        
        txtName = new JTextField();
        txtEmail = new JTextField();
//       Buoc Validate Phone bang MaskFormatter
        MaskFormatter mskPhone = null;
        try {
            mskPhone = new MaskFormatter("###-####-####");
            mskPhone.setPlaceholderCharacter('_');
        } catch (ParseException ex) {
            System.out.println("Loi MaskFormatter Phone");
        }
        txtPhone = new JFormattedTextField(mskPhone);

//        txtDob = new JFormattedTextField(DateFormat.getDateInstance(DateFormat.SHORT,Locale.FRENCH));
        SpinnerDateModel spinModel = new SpinnerDateModel();
        txtDob = new JSpinner(spinModel);
        txtDob.setEditor(new JSpinner.DateEditor(txtDob, "dd/MM/yyyy"));
        
        txtClass = new JTextField();
        txtRollNum = new JTextField();

//Định kích thuoc Component, 
        this.lblId.setPreferredSize(new Dimension(200, 50));
        this.lblName.setPreferredSize(new Dimension(200, 50));
        this.lblEmail.setPreferredSize(new Dimension(200, 50));
        this.lblPhone.setPreferredSize(new Dimension(200, 50));
        this.lblDob.setPreferredSize(new Dimension(200, 50));
        this.lblRollNum.setPreferredSize(new Dimension(200, 50));
        this.lblClass.setPreferredSize(new Dimension(200, 50));
        this.txtId.setPreferredSize(new Dimension(300, 50));
        this.txtName.setPreferredSize(new Dimension(300, 50));
        this.txtEmail.setPreferredSize(new Dimension(300, 50));
        this.txtPhone.setPreferredSize(new Dimension(300, 50));
        this.txtDob.setPreferredSize(new Dimension(300, 50));
        this.txtRollNum.setPreferredSize(new Dimension(300, 50));
        this.txtClass.setPreferredSize(new Dimension(300, 50));
        button.setPreferredSize(new Dimension(500, 80));
        //Them component vao Frame
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 2;
//        lblId.setBorder(BorderFactory.createLineBorder(Color.yellow, 5));
        lblId.setVerticalAlignment(SwingConstants.CENTER);
        lblId.setHorizontalAlignment(SwingConstants.LEFT);
        this.fr.add(this.lblId, c);
        
        c.gridx = 1;
        c.gridy = 2;
        this.fr.add(this.txtId, c);
        
        c.gridx = 0;
        c.gridy = 3;
        lblName.setVerticalAlignment(SwingConstants.CENTER);
        lblName.setHorizontalAlignment(SwingConstants.LEFT);
//        lblName.setBorder(BorderFactory.createLineBorder(Color.yellow, 1));
        this.fr.add(this.lblName, c);
        
        c.gridx = 1;
        c.gridy = 3;
        this.fr.add(this.txtName, c);
        
        c.gridx = 0;
        c.gridy = 4;
        lblEmail.setVerticalAlignment(SwingConstants.CENTER);
        lblEmail.setHorizontalAlignment(SwingConstants.LEFT);
        this.fr.add(this.lblEmail, c);
        
        c.gridx = 1;
        c.gridy = 4;
        this.fr.add(this.txtEmail, c);
        
        c.gridx = 0;
        c.gridy = 5;
        lblPhone.setVerticalAlignment(SwingConstants.CENTER);
        lblPhone.setHorizontalAlignment(SwingConstants.LEFT);
        
        this.fr.add(this.lblPhone, c);
        c.gridx = 1;
        c.gridy = 5;
        this.fr.add(this.txtPhone, c);
        
        c.gridx = 0;
        c.gridy = 6;
        lblClass.setVerticalAlignment(SwingConstants.CENTER);
        lblClass.setHorizontalAlignment(SwingConstants.LEFT);
        this.fr.add(this.lblClass, c);
        
        c.gridx = 1;
        c.gridy = 6;
        this.fr.add(this.txtClass, c);
        
        c.gridx = 0;
        c.gridy = 7;
        lblRollNum.setVerticalAlignment(SwingConstants.CENTER);
        lblRollNum.setHorizontalAlignment(SwingConstants.LEFT);
        this.fr.add(this.lblRollNum, c);
        
        c.gridx = 1;
        c.gridy = 7;
        this.fr.add(this.txtRollNum, c);
        
        c.gridx = 0;
        c.gridy = 8;
        lblDob.setVerticalAlignment(SwingConstants.CENTER);
        lblDob.setHorizontalAlignment(SwingConstants.LEFT);
        this.fr.add(this.lblDob, c);
        
        c.gridy = 8;
        c.gridx = 1;
        this.fr.add(this.txtDob, c);
        this.button.addActionListener(new ResetHandle());
        this.button.addActionListener(new LoginHandle());
        c.gridx = 0;
        c.gridy = 11;
        c.gridwidth = 2;
        c.gridheight = 1;
        this.fr.add(this.button, c);
        
        lblHeader.setPreferredSize(new Dimension(500, 60));
        lblHeader.setVerticalAlignment(SwingConstants.TOP);
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        c.gridheight = 2;
        
        lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
        this.fr.add(this.lblHeader, c);

        //Tạo và thêm đồng hồ
        Timer timer = new Timer(1000, new Clock());
        timer.start();

        //Xu ly khi tat
        this.fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    class LoginHandle implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, "Dang nhap thanh cong!" + "\nTai Khoan: " + txtName.getText() + "\nEmail: " + txtEmail.getText() + "\nThông tin của bạn đã được lưu.");
        }
        
    }
    
    class ResetHandle implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            txtName.setText("");
            txtEmail.setText("");
        }
        
    }

//Xu Ly Dong Ho: 
    class Clock implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Date date = new Date();
            fr.setTitle("Thời gian: " + dateFormat.format(date));
            
        }
        
    }
    
}
