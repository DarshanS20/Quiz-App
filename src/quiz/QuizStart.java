package quiz;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JRadioButton;
import javax.swing.Timer;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import quiz.SqlConnection;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ButtonGroup; 
public class QuizStart extends JFrame {
	SqlConnection c1= new SqlConnection();
	int tmarks=0;
	 int db_marks;
	String studentAnswer="";
	String db_ans="";
	static String username="";
	String usern;
	int count=0;
	public int sec=0;
	public int min=0;
	private JPanel contentPane;
	private  ButtonGroup buttonGroup = new ButtonGroup();
	
	
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuizStart frame = new QuizStart(username);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param username2 
	 * @param username 
	 */
	
	public QuizStart(String username) {
			//initComponents();
			usern=username;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 631);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmBack = new JMenuItem("Back");
		mntmBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Login().setVisible(true);
			}
		});
		mnFile.add(mntmBack);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(30, 144, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBackground(new Color(30, 144, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(99, 96, 715, 99);
		contentPane.add(lblNewLabel);
		
		JRadioButton radioButton = new JRadioButton("New radio button");
		radioButton.setBackground(new Color(30, 144, 255));
		buttonGroup.add(radioButton);
		radioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		radioButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		radioButton.setBounds(124, 201, 255, 71);
		contentPane.add(radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("New radio button");
		radioButton_1.setBackground(new Color(30, 144, 255));
		buttonGroup.add(radioButton_1);
		radioButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		radioButton_1.setBounds(125, 289, 254, 71);
		contentPane.add(radioButton_1);
		
		JRadioButton radioButton_2 = new JRadioButton("New radio button");
		radioButton_2.setBackground(new Color(30, 144, 255));
		buttonGroup.add(radioButton_2);
		radioButton_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		radioButton_2.setBounds(418, 201, 254, 71);
		contentPane.add(radioButton_2);
		
		JRadioButton radioButton_3 = new JRadioButton("New radio button");
		radioButton_3.setBackground(new Color(30, 144, 255));
		buttonGroup.add(radioButton_3);
		radioButton_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		radioButton_3.setBounds(418, 289, 262, 71);
		contentPane.add(radioButton_3);
		
		
		
		JButton btnSubmit = new JButton("Submit");
		
		Image img = new ImageIcon(this.getClass().getResource("/enter.png")).getImage();
		btnSubmit.setIcon(new ImageIcon(img));
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(db_ans.equals(studentAnswer))
				{
					
					tmarks=tmarks+db_marks;
					System.out.println("correct-second");
				}
				
				if(radioButton.isSelected())
				{
					studentAnswer=radioButton.getText();
					System.out.println(studentAnswer);
					radioButton_1.setSelected(false);
					radioButton_2.setSelected(false);
					radioButton_3.setSelected(false);
					
				}
				else if(radioButton_1.isSelected())
				{
					studentAnswer=radioButton_1.getText();
					System.out.println(studentAnswer);
					radioButton.setSelected(false);
					radioButton_2.setSelected(false);
					radioButton_3.setSelected(false);
					
				}
				else if(radioButton_2.isSelected())
				{ System.out.println("Button 3 fisrt");
				System.out.println(studentAnswer);
					radioButton.setSelected(false);
					radioButton_1.setSelected(false);
				 radioButton_3.setSelected(false);
				}
				else if(radioButton_3.isSelected())  {
					System.out.println("Button 4 first");
					System.out.println(studentAnswer);
					radioButton.setSelected(false);
					radioButton_1.setSelected(false);
					radioButton_2.setSelected(false);
				}
				if(db_ans.equals(studentAnswer))
				{
					//tmarks=tmarks+db_marks;
				//	System.out.println("correct");
					tmarks=tmarks+db_marks;
					System.out.println(tmarks);
					System.out.println("correct-first");
				}
				
				new QuizResult(usern,tmarks).setVisible(true);
			}
		});
		btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSubmit.setBounds(706, 524, 159, 60);
		contentPane.add(btnSubmit);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblNewLabel_1.setBounds(48, 10, 243, 60);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setText(username);
		
		JLabel label = new JLabel("15:00");
		label.setFont(new Font("Tahoma", Font.PLAIN, 21));
		label.setBounds(690, 32, 62, 60);
		contentPane.add(label);
		
		//t.start();
		try {
			
			System.out.println("connection first");
			Statement str1= c1.con.createStatement();
			ResultSet rs=str1.executeQuery("select distinct Question,Option1,Option2,Option3,Option4,CorrectOption,Marks from question order by rand() limit 10");
			while(rs.next())
			{	
				//qhist.push(rs.getInt("QID"));
				String v1=rs.getString("Question");
				String v2=rs.getString("Option1");
				String v3=rs.getString("Option2");
				String v4=rs.getString("Option3");
				String v5=rs.getString("Option4");
				db_ans=rs.getString("CorrectOption");
				db_marks=rs.getInt("Marks"); 
				lblNewLabel.setText(v1);
				radioButton.setText(v2);
				radioButton_1.setText(v3);
				radioButton_2.setText(v4);
				radioButton_3.setText(v5);
				System.out.print("first");
			}
			if(radioButton.isSelected())
			{
				studentAnswer=radioButton.getText();
				System.out.println(studentAnswer);
				radioButton_1.setSelected(false);
				radioButton_2.setSelected(false);
				radioButton_3.setSelected(false);
				
			}
			else if(radioButton_1.isSelected())
			{
				studentAnswer=radioButton_1.getText();
				System.out.println(studentAnswer);
				radioButton.setSelected(false);
				radioButton_2.setSelected(false);
				radioButton_3.setSelected(false);
				
			}
			else if(radioButton_2.isSelected())
			{ System.out.println("Button 3 fisrt");
			System.out.println(studentAnswer);
				radioButton.setSelected(false);
				radioButton_1.setSelected(false);
			 radioButton_3.setSelected(false);
			}
			else if(radioButton_3.isSelected())  {
				System.out.println("Button 4 first");
				System.out.println(studentAnswer);
				radioButton.setSelected(false);
				radioButton_1.setSelected(false);
				radioButton_2.setSelected(false);
			}
			if(db_ans.equals(studentAnswer))
			{
				//tmarks=tmarks+db_marks;
			//	System.out.println("correct");
				tmarks=tmarks+db_marks;
				System.out.println(tmarks);
				System.out.println("correct-first");
			}
			
			count++;
			//System.out.println("first");
			//System.out.println(count);
			//System.out.println("one");
			
			
		}
		catch(Exception a) {
			System.out.println("Error due to :"+a);
		}
		
		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(radioButton.isSelected())
				{
					studentAnswer=radioButton.getText();
					System.out.println(studentAnswer);
					radioButton_1.setSelected(false);
					radioButton_2.setSelected(false);
					radioButton_3.setSelected(false);
					
					
				}
				else if(radioButton_1.isSelected())
				{
					studentAnswer=radioButton_1.getText();
					System.out.println(studentAnswer);
					radioButton.setSelected(false);
					radioButton_2.setSelected(false);
					radioButton_3.setSelected(false);
					
				}
				else if(radioButton_2.isSelected())
				{
					studentAnswer=radioButton_2.getText();
					System.out.println(studentAnswer);
					radioButton.setSelected(false);
					radioButton_1.setSelected(false);
					radioButton_3.setSelected(false);
				}
				else if(radioButton_3.isSelected()){
					studentAnswer=radioButton_3.getText();
					System.out.println(studentAnswer);
					radioButton.setSelected(false);
					radioButton_1.setSelected(false);
					radioButton_2.setSelected(false);
				}
				if(db_ans.equals(studentAnswer))
				{
					
					tmarks=tmarks+db_marks;
					System.out.println("correct-second");
				}
				try {
					
					Statement str= c1.con.createStatement();
					ResultSet rs=str.executeQuery("select distinct Question,Option1,Option2,Option3,Option4,CorrectOption,Marks from question order by rand() limit 10");
					while(rs.next())
					{	
						
						String v1=rs.getString("Question");
						String v2=rs.getString("Option1");
						String v3=rs.getString("Option2");
						String v4=rs.getString("Option3");
						String v5=rs.getString("Option4");
						db_ans=rs.getString("CorrectOption");
						db_marks=rs.getInt("Marks");
						 
						lblNewLabel.setText(v1);
						radioButton.setText(v2);
						radioButton_1.setText(v3);
						radioButton_2.setText(v4);
						radioButton_3.setText(v5);
						//System.out.print("second");
					}
					if(radioButton.isSelected())
					{
						studentAnswer=radioButton.getText();
						System.out.println(studentAnswer);
						radioButton_1.setSelected(false);
						radioButton_2.setSelected(false);
						radioButton_3.setSelected(false);
						
					}
					else if(radioButton_1.isSelected())
					{
						studentAnswer=radioButton_1.getText();
						System.out.println(studentAnswer);
						radioButton.setSelected(false);
						radioButton_2.setSelected(false);
						radioButton_3.setSelected(false);
						
					}
					else if(radioButton_2.isSelected())
					{
						studentAnswer=radioButton_2.getText();
						System.out.println(studentAnswer);
						radioButton.setSelected(false);
						radioButton_1.setSelected(false);
						radioButton_3.setSelected(false);
					}
					else if(radioButton_3.isSelected()) {
						studentAnswer=radioButton_3.getText();
						System.out.println(studentAnswer);
						radioButton.setSelected(false);
						radioButton_1.setSelected(false);
						radioButton_2.setSelected(false);
					}
					
					count++;
					//System.out.println(count);
					//System.out.println("two");
					System.out.println(tmarks);
					if(count == 9)
					{
						btnNext.setEnabled(false);
					}
					
				}
				catch(Exception s) {
					System.out.println("Error due to :"+s);
				}
			}
		});
		btnNext.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNext.setBounds(338, 440, 159, 60);
		contentPane.add(btnNext);
		buttonGroup.add(radioButton);
		buttonGroup.add(radioButton_1);
		buttonGroup.add(radioButton_2);
		buttonGroup.add(radioButton_3);
		
		JLabel label_1 = new JLabel("15:00");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 21));
		label_1.setBounds(749, 32, 77, 60);
		contentPane.add(label_1);
		 final Timer timer = new Timer(1000,null); 
		timer.addActionListener(new ActionListener() {
			//@Override
			public void actionPerformed(ActionEvent e) {
			
				label.setText(String.valueOf(min));
				label_1.setText(String.valueOf(sec));	
				if(sec == 60)
				{
					sec=0;
					min++;
					if(min==2)
					{
						timer.stop();
						btnNext.setEnabled(false);
					}
				}
				sec++;
			}
		});
		timer.start();
	}
}

