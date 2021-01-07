package quiz;
import quiz.SqlConnection;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.sql.*;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
 
public class Registration extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration frame = new Registration();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Registration() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 520, 679);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmBack = new JMenuItem("Back");
		mntmBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Login().setVisible(true);
				dispose();
			}
		});
		mnFile.add(mntmBack);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(100, 149, 237));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(153, 436, 156, 54);
		Image img3 = new ImageIcon(this.getClass().getResource("/login.png")).getImage();
		btnSubmit.setIcon(new ImageIcon(img3));
		btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SqlConnection c=new SqlConnection();
				String USN=textField.getText();
				
				String passwd=String.valueOf(passwordField.getPassword());
			try {
				
				PreparedStatement str= c.con.prepareStatement("insert into logindet  values (?,?)") ;
				str.setString(1,USN);
				str.setString(2,passwd);
				str.executeUpdate();
				JOptionPane.showMessageDialog(null, "Successfully Registered");
					
		}
			catch(Exception a ){
				System.out.println("Found Error : "+a);
				
			}
		
			}
				
		});
		contentPane.setLayout(null);
		
		JLabel lblRegistration = new JLabel("Registration");
		lblRegistration.setBounds(135, 10, 434, 100);
		lblRegistration.setFont(new Font("Tahoma", Font.PLAIN, 33));
		contentPane.add(lblRegistration);
		
		JLabel lblUsn = new JLabel("USN             ");
		lblUsn.setBounds(21, 178, 288, 37);
		lblUsn.setFont(new Font("Tahoma", Font.PLAIN, 30));
		contentPane.add(lblUsn);
		
		textField = new JTextField();
		textField.setBounds(21, 225, 434, 44);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblSection = new JLabel("Password               ");
		lblSection.setBounds(21, 292, 288, 37);
		lblSection.setFont(new Font("Tahoma", Font.PLAIN, 30));
		contentPane.add(lblSection);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(20, 339, 435, 44);
		contentPane.add(passwordField);
		contentPane.add(btnSubmit);
		
		JLabel lblNewLabel = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/registration.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(184, 74, 312, 113);
		contentPane.add(lblNewLabel);
	}
}
