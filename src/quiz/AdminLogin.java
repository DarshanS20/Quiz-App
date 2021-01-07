package quiz;
import quiz.SqlConnection;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.ImageIcon;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class AdminLogin extends JFrame {

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
					AdminLogin frame = new AdminLogin();
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
	public AdminLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 630, 701);
		
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
		
		JLabel lblAdmin = new JLabel("");
		lblAdmin.setBounds(23, 46, 534, 167);
		//lblAdmin.setIcon(new ImageIcon("G:\\ENGINEERING\\SECOND YEAR ENGG\\OOPS in Java\\Programs\\QuizApplication\\images\\admin large.png"));
		Image img = new ImageIcon(this.getClass().getResource("/admin large.png")).getImage();
		contentPane.setLayout(null);
		lblAdmin.setIcon(new ImageIcon(img));
		lblAdmin.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdmin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblAdmin);
		
		JLabel label = new JLabel("Username");
		label.setBounds(21, 211, 194, 40);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.PLAIN, 33));
		contentPane.add(label);
		Image img1 = new ImageIcon(this.getClass().getResource("/login.png")).getImage();
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 28));
		textField.setBounds(42, 252, 493, 49);
		textField.setColumns(10);
		contentPane.add(textField);
		
		JLabel label_1 = new JLabel("Password");
		label_1.setBounds(10, 330, 194, 40);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 33));
		contentPane.add(label_1);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 28));
		passwordField.setBounds(42, 371, 493, 49);
		contentPane.add(passwordField);
		
		JButton button = new JButton("Login");
		button.setBounds(189, 479, 194, 41);
		button.setIcon(new ImageIcon("G:\\ENGINEERING\\SECOND YEAR ENGG\\OOPS in Java\\Programs\\QuizApplication\\images\\login.png"));
		button.setIcon(new ImageIcon(img1));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SqlConnection fg=new SqlConnection();
				String Username= textField.getText();
				String Password = String.valueOf(passwordField.getPassword());
				String d_password="";
				String d_username="";
				try {
					Statement con3=fg.con.createStatement();
					ResultSet rs=con3.executeQuery("select u_name,password from admin");
					while(rs.next())
					{
						d_password=rs.getString("password");
						d_username=rs.getString("u_name");
					}
						if(d_username.equals(Username)&& d_password.equals(Password))
						{
							new AdminActions().setVisible(true);
							dispose();
						}
					}
				catch(Exception a) {
					
				}
			}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 26));
		button.setBackground(new Color(255, 228, 196));
		contentPane.add(button);
		
		JLabel lblNewLabel = new JLabel("Admin Login");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblNewLabel.setBounds(55, 10, 502, 49);
		contentPane.add(lblNewLabel);
	}
}
