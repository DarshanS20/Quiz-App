package quiz;

import quiz.SqlConnection;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.awt.Color;


public class QuizResult extends JFrame {
static String usern="";
static int tmarks;
	private JPanel contentPane;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuizResult frame = new QuizResult(usern,tmarks);
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
	public QuizResult(String usern, int tmarks) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 675, 414);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(100, 149, 237));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(192, 172, 240, 97);
		contentPane.add(lblNewLabel);
		//lblNewLabel.setText(usern);
		lblNewLabel.setText(Integer.toString(tmarks));
		
		JLabel label = new JLabel("Otherlbl");
		label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label.setBounds(192, 38, 331, 124);
		contentPane.add(label);
		label.setText(usern);
		
		JButton btnFinish = new JButton("Finish");
		btnFinish.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnFinish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SqlConnection cc=new SqlConnection();
				try{PreparedStatement str1 = cc.con.prepareStatement("insert into final_marks values(?,?)");
					str1.setString(1,usern);
					str1.setInt(2,tmarks);
					str1.executeUpdate();
			}
				catch(Exception k) {
					System.out.println("Found Error" +k);
				}
					
				}
		});
		btnFinish.setBounds(215, 293, 171, 44);
		contentPane.add(btnFinish);
		
		JLabel lblUsn = new JLabel("USN : ");
		lblUsn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUsn.setBounds(29, 72, 153, 68);
		contentPane.add(lblUsn);
		
		JLabel lblYourScore = new JLabel("Your Score");
		lblYourScore.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblYourScore.setBounds(10, 193, 159, 52);
		contentPane.add(lblYourScore);
		System.out.println(usern);
		System.out.println(tmarks);
	}
}
