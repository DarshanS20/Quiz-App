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

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.sql.*;
import java.awt.GridBagLayout;
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
		setBounds(100, 100, 885, 565);
		
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
		contentPane.setBackground(new Color(30, 144, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{292, 434, 0};
		gbl_contentPane.rowHeights = new int[]{105, 69, 49, 36, 41, 73, 54, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JButton btnSubmit = new JButton("Submit");
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
		
		JLabel lblRegistration = new JLabel("Registration");
		lblRegistration.setFont(new Font("Tahoma", Font.PLAIN, 33));
		GridBagConstraints gbc_lblRegistration = new GridBagConstraints();
		gbc_lblRegistration.fill = GridBagConstraints.BOTH;
		gbc_lblRegistration.insets = new Insets(0, 0, 5, 0);
		gbc_lblRegistration.gridx = 1;
		gbc_lblRegistration.gridy = 0;
		contentPane.add(lblRegistration, gbc_lblRegistration);
		
		JLabel lblUsn = new JLabel("USN                       :");
		lblUsn.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblUsn = new GridBagConstraints();
		gbc_lblUsn.anchor = GridBagConstraints.NORTH;
		gbc_lblUsn.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblUsn.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsn.gridx = 0;
		gbc_lblUsn.gridy = 2;
		contentPane.add(lblUsn, gbc_lblUsn);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.BOTH;
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 2;
		contentPane.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblSection = new JLabel("Password               :");
		lblSection.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblSection = new GridBagConstraints();
		gbc_lblSection.fill = GridBagConstraints.BOTH;
		gbc_lblSection.insets = new Insets(0, 0, 5, 5);
		gbc_lblSection.gridx = 0;
		gbc_lblSection.gridy = 4;
		contentPane.add(lblSection, gbc_lblSection);
		
		passwordField = new JPasswordField();
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.fill = GridBagConstraints.BOTH;
		gbc_passwordField.insets = new Insets(0, 0, 5, 0);
		gbc_passwordField.gridx = 1;
		gbc_passwordField.gridy = 4;
		contentPane.add(passwordField, gbc_passwordField);
		GridBagConstraints gbc_btnSubmit = new GridBagConstraints();
		gbc_btnSubmit.fill = GridBagConstraints.VERTICAL;
		gbc_btnSubmit.gridx = 1;
		gbc_btnSubmit.gridy = 6;
		contentPane.add(btnSubmit, gbc_btnSubmit);
	}
}
