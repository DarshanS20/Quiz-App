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
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class QuestionEntry extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuestionEntry frame = new QuestionEntry();
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
	public QuestionEntry() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 859, 757);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmBack = new JMenuItem("Back");
		mntmBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AdminActions().setVisible(true);
				dispose();
			}
		});
		mnFile.add(mntmBack);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(100, 149, 237));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel_1 = new JLabel("                         Enter Question");
		lblNewLabel_1.setBounds(5, 0, 756, 128);
		
		Image img1 = new ImageIcon(this.getClass().getResource("/faq.png")).getImage();
		contentPane.setLayout(null);
		lblNewLabel_1.setIcon(new ImageIcon(img1));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Question :");
		lblNewLabel.setBounds(43, 152, 110, 29);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField.setBounds(174, 103, 587, 168);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblOption = new JLabel("Option 1 :");
		lblOption.setBounds(43, 272, 106, 55);
		lblOption.setFont(new Font("Tahoma", Font.PLAIN, 24));
		contentPane.add(lblOption);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_1.setBounds(174, 281, 587, 37);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblOption_1 = new JLabel("Option 2 :");
		lblOption_1.setBounds(47, 333, 106, 29);
		lblOption_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		contentPane.add(lblOption_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_2.setBounds(174, 325, 587, 37);
		textField_2.setColumns(10);
		contentPane.add(textField_2);
		
		JLabel lblOption_2 = new JLabel("Option 3 :");
		lblOption_2.setBounds(47, 370, 106, 36);
		lblOption_2.setFont(new Font("Tahoma", Font.PLAIN, 24));
		contentPane.add(lblOption_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_3.setBounds(174, 370, 587, 36);
		textField_3.setColumns(10);
		contentPane.add(textField_3);
		
		JLabel lblOption_3 = new JLabel("Option 4 :");
		lblOption_3.setBounds(47, 409, 106, 36);
		lblOption_3.setFont(new Font("Tahoma", Font.PLAIN, 24));
		contentPane.add(lblOption_3);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_4.setBounds(174, 416, 587, 36);
		textField_4.setColumns(10);
		contentPane.add(textField_4);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(542, 574, 219, 137);
		
		Image img = new ImageIcon(this.getClass().getResource("/enter.png")).getImage();
		btnSubmit.setIcon(new ImageIcon(img1));
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SqlConnection c=new SqlConnection();
				String Question=textField.getText();
				String Option1=textField_1.getText();
				String Option2=textField_2.getText();
				String Option3=textField_3.getText();
				String Option4=textField_4.getText();
				String CorrectOption=textField_5.getText();
				String Marks=textField_6.getText();
				int mark=Integer.parseInt(Marks);
				//int id=1;
				
			try {
				
				PreparedStatement str= c.con.prepareStatement("insert into question(Question,Option1,Option2,Option3,Option4,CorrectOption,Marks) values (?,?,?,?,?,?,?)") ;
				//str.setInt(1,id);
				str.setString(1,Question);
				str.setString(2,Option1);
				str.setString(3,Option2);
				str.setString(4,Option3);
				str.setString(5,Option4);
				str.setString(6,CorrectOption);
				str.setInt(7,mark);
				
				str.executeUpdate();
				JOptionPane.showMessageDialog(null, "Successfully Entered");
					
		}
			catch(Exception d){
				System.out.println("Found Error : "+d);
				
			}
			}
		});
		
		JLabel lblCore = new JLabel("Correct Option :");
		lblCore.setBounds(0, 481, 194, 36);
		lblCore.setFont(new Font("Tahoma", Font.PLAIN, 24));
		contentPane.add(lblCore);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_5.setBounds(174, 481, 587, 36);
		textField_5.setColumns(10);
		contentPane.add(textField_5);
		
		JLabel lblMarks = new JLabel("        Marks :");
		lblMarks.setBounds(31, 527, 136, 37);
		lblMarks.setFont(new Font("Tahoma", Font.PLAIN, 24));
		contentPane.add(lblMarks);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_6.setBounds(177, 527, 460, 37);
		textField_6.setColumns(10);
		contentPane.add(textField_6);
		btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(btnSubmit);
	}
}
