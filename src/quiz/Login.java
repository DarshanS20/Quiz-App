package quiz;
import quiz.SqlConnection;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import java.sql.*;

public class Login extends JFrame {
	public String username;
	private JPanel contentPane;
	private JTextField txtUsernamr;
	private JPasswordField passwordField;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		
	
		setBackground(new Color(100, 149, 237));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1041, 626);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(100, 149, 237));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtUsernamr = new JTextField();
		txtUsernamr.setBounds(278, 213, 493, 44);
		contentPane.add(txtUsernamr);
		txtUsernamr.setColumns(10);
		
		JButton btnNewButton = new JButton("Login");
	//	btnNewButton.setIcon(new ImageIcon("G:\\ENGINEERING\\SECOND YEAR ENGG\\OOPS in Java\\Programs\\QuizApplication\\images\\login.png"));
		Image img13 = new ImageIcon(this.getClass().getResource("/login.png")).getImage();
		 btnNewButton.setIcon(new ImageIcon(img13));
		btnNewButton.setBackground(new Color(255, 228, 196));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 26));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SqlConnection c=new SqlConnection();
				 username= txtUsernamr.getText();
		       
		        String password=String.valueOf(passwordField.getPassword());
		        String db_password="";
		        String db_username= "";
		        try
		        {
		            Statement con1=c.con.createStatement();
		            ResultSet rs=con1.executeQuery("select u_Name,Password from logindet");
		            while(rs.next())
		            {
		                db_password=rs.getString("Password");
		                db_username=rs.getString("U_Name");
		                
		            
		            if(db_password.equals(password) && db_username.equals(username)  )
		            {     
		            	
		            	new QuizStart(username).setVisible(true);
		            	//QuizStart q1 = new QuizStart(username);
		            	//q1.setVisible(true);
		                dispose();
		            }
		           // else
		          //  {
		           //      JOptionPane.showMessageDialog(null, "Wrong Username/Password Please Enter Again"); 
		          //  }
		            }
		        }
		        catch(Exception a)
		        {
		            System.out.println("Found Error : "+a);
		        }
			}
		});
		btnNewButton.setBounds(274, 380, 218, 44);
		contentPane.add(btnNewButton);
		
		JButton btnRegister = new JButton("Register");
		//btnRegister.setIcon(new ImageIcon("G:\\ENGINEERING\\SECOND YEAR ENGG\\OOPS in Java\\Programs\\QuizApplication\\images\\login.png"));
		Image img12 = new ImageIcon(this.getClass().getResource("/login.png")).getImage();
		btnRegister.setIcon(new ImageIcon(img12));
		btnRegister.setFont(new Font("Tahoma", Font.PLAIN, 26));
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Registration().setVisible(true);
				dispose();
				
			}
		});
		btnRegister.setBounds(553, 379, 218, 45);
		contentPane.add(btnRegister);
		
		JLabel lblUsernam = new JLabel("Username :");
		lblUsernam.setFont(new Font("Tahoma", Font.PLAIN, 33));
		lblUsernam.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsernam.setBounds(10, 213, 244, 44);
		contentPane.add(lblUsernam);
		
		JLabel lblUpassword = new JLabel("Password :");
		lblUpassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpassword.setFont(new Font("Tahoma", Font.PLAIN, 33));
		lblUpassword.setBounds(30, 292, 209, 44);
		contentPane.add(lblUpassword);
		
		JButton btnNewButton_1 = new JButton("Admin ");
		//btnNewButton_1.setIcon(new ImageIcon("G:\\ENGINEERING\\SECOND YEAR ENGG\\OOPS in Java\\Programs\\QuizApplication\\images\\admin.png"));
		Image img11 = new ImageIcon(this.getClass().getResource("/admin.png")).getImage();
		btnNewButton_1.setIcon(new ImageIcon(img11));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 26));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				new AdminLogin().setVisible(true);
				dispose();
				
			}
		});
		btnNewButton_1.setBounds(794, 535, 223, 44);
		contentPane.add(btnNewButton_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(278, 292, 493, 44);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel = new JLabel("");
		//lblNewLabel.setIcon(new ImageIcon("G:\\ENGINEERING\\SECOND YEAR ENGG\\OOPS in Java\\Programs\\QuizApplication\\images\\loginlabel.png"));
		Image img = new ImageIcon(this.getClass().getResource("/loginlabel.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(415, 33, 498, 140);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("");
		//label.setIcon(new ImageIcon("G:\\ENGINEERING\\SECOND YEAR ENGG\\OOPS in Java\\Programs\\QuizApplication\\images\\username.png"));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		Image img1 = new ImageIcon(this.getClass().getResource("/username.png")).getImage();
		label.setIcon(new ImageIcon(img1));
		label.setFont(new Font("Tahoma", Font.PLAIN, 33));
		label.setBounds(706, 213, 244, 44);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
	//	label_1.setIcon(new ImageIcon("G:\\ENGINEERING\\SECOND YEAR ENGG\\OOPS in Java\\Programs\\QuizApplication\\images\\padlock.png"));
		Image img2 = new ImageIcon(this.getClass().getResource("/padlock.png")).getImage();
		label_1.setIcon(new ImageIcon(img2));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 33));
		label_1.setBounds(706, 292, 244, 44);
		contentPane.add(label_1);
		}
    //}
}
