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
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{169, 14, 338, 219, 0};
		gbl_contentPane.rowHeights = new int[]{124, 87, 56, 2, 30, 30, 41, 41, 41, 42, 56, 51, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel_1 = new JLabel("                         Enter Question");
		//lblNewLabel_1.setIcon(new ImageIcon("G:\\ENGINEERING\\SECOND YEAR ENGG\\OOPS in Java\\Programs\\QuizApplication\\images\\faq.png"));
		Image img1 = new ImageIcon(this.getClass().getResource("/faq.png")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(img1));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_1.gridwidth = 4;
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 0;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Question :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.SOUTHEAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.BOTH;
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.gridheight = 3;
		gbc_textField.gridwidth = 3;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 1;
		contentPane.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblOption = new JLabel("Option 1 :");
		lblOption.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GridBagConstraints gbc_lblOption = new GridBagConstraints();
		gbc_lblOption.anchor = GridBagConstraints.EAST;
		gbc_lblOption.fill = GridBagConstraints.VERTICAL;
		gbc_lblOption.insets = new Insets(0, 0, 5, 5);
		gbc_lblOption.gridheight = 2;
		gbc_lblOption.gridwidth = 2;
		gbc_lblOption.gridx = 0;
		gbc_lblOption.gridy = 3;
		contentPane.add(lblOption, gbc_lblOption);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.fill = GridBagConstraints.BOTH;
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.gridwidth = 3;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 4;
		contentPane.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		JLabel lblOption_1 = new JLabel("Option 2 :");
		lblOption_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GridBagConstraints gbc_lblOption_1 = new GridBagConstraints();
		gbc_lblOption_1.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblOption_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblOption_1.gridheight = 2;
		gbc_lblOption_1.gridwidth = 2;
		gbc_lblOption_1.gridx = 0;
		gbc_lblOption_1.gridy = 5;
		contentPane.add(lblOption_1, gbc_lblOption_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.fill = GridBagConstraints.BOTH;
		gbc_textField_2.insets = new Insets(0, 0, 5, 0);
		gbc_textField_2.gridwidth = 3;
		gbc_textField_2.gridx = 1;
		gbc_textField_2.gridy = 5;
		contentPane.add(textField_2, gbc_textField_2);
		
		JLabel lblOption_2 = new JLabel("Option 3 :");
		lblOption_2.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GridBagConstraints gbc_lblOption_2 = new GridBagConstraints();
		gbc_lblOption_2.anchor = GridBagConstraints.EAST;
		gbc_lblOption_2.fill = GridBagConstraints.VERTICAL;
		gbc_lblOption_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblOption_2.gridwidth = 2;
		gbc_lblOption_2.gridx = 0;
		gbc_lblOption_2.gridy = 6;
		contentPane.add(lblOption_2, gbc_lblOption_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.fill = GridBagConstraints.BOTH;
		gbc_textField_3.insets = new Insets(0, 0, 5, 0);
		gbc_textField_3.gridwidth = 3;
		gbc_textField_3.gridx = 1;
		gbc_textField_3.gridy = 6;
		contentPane.add(textField_3, gbc_textField_3);
		
		JLabel lblOption_3 = new JLabel("Option 4 :");
		lblOption_3.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GridBagConstraints gbc_lblOption_3 = new GridBagConstraints();
		gbc_lblOption_3.anchor = GridBagConstraints.EAST;
		gbc_lblOption_3.fill = GridBagConstraints.VERTICAL;
		gbc_lblOption_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblOption_3.gridwidth = 2;
		gbc_lblOption_3.gridx = 0;
		gbc_lblOption_3.gridy = 7;
		contentPane.add(lblOption_3, gbc_lblOption_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.fill = GridBagConstraints.BOTH;
		gbc_textField_4.insets = new Insets(0, 0, 5, 0);
		gbc_textField_4.gridwidth = 3;
		gbc_textField_4.gridx = 1;
		gbc_textField_4.gridy = 7;
		contentPane.add(textField_4, gbc_textField_4);
		
		JButton btnSubmit = new JButton("Submit");
		//btnSubmit.setIcon(new ImageIcon("G:\\ENGINEERING\\SECOND YEAR ENGG\\OOPS in Java\\Programs\\QuizApplication\\images\\enter.png"));
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
		lblCore.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GridBagConstraints gbc_lblCore = new GridBagConstraints();
		gbc_lblCore.fill = GridBagConstraints.BOTH;
		gbc_lblCore.insets = new Insets(0, 0, 5, 5);
		gbc_lblCore.gridwidth = 2;
		gbc_lblCore.gridx = 0;
		gbc_lblCore.gridy = 8;
		contentPane.add(lblCore, gbc_lblCore);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		GridBagConstraints gbc_textField_5 = new GridBagConstraints();
		gbc_textField_5.fill = GridBagConstraints.BOTH;
		gbc_textField_5.insets = new Insets(0, 0, 5, 0);
		gbc_textField_5.gridwidth = 3;
		gbc_textField_5.gridx = 1;
		gbc_textField_5.gridy = 8;
		contentPane.add(textField_5, gbc_textField_5);
		
		JLabel lblMarks = new JLabel("        Marks :");
		lblMarks.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GridBagConstraints gbc_lblMarks = new GridBagConstraints();
		gbc_lblMarks.anchor = GridBagConstraints.EAST;
		gbc_lblMarks.fill = GridBagConstraints.VERTICAL;
		gbc_lblMarks.insets = new Insets(0, 0, 5, 5);
		gbc_lblMarks.gridx = 0;
		gbc_lblMarks.gridy = 9;
		contentPane.add(lblMarks, gbc_lblMarks);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		GridBagConstraints gbc_textField_6 = new GridBagConstraints();
		gbc_textField_6.anchor = GridBagConstraints.SOUTH;
		gbc_textField_6.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_6.insets = new Insets(0, 0, 5, 0);
		gbc_textField_6.gridwidth = 3;
		gbc_textField_6.gridx = 1;
		gbc_textField_6.gridy = 9;
		contentPane.add(textField_6, gbc_textField_6);
		btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_btnSubmit = new GridBagConstraints();
		gbc_btnSubmit.fill = GridBagConstraints.BOTH;
		gbc_btnSubmit.gridx = 3;
		gbc_btnSubmit.gridy = 11;
		contentPane.add(btnSubmit, gbc_btnSubmit);
	}
}
