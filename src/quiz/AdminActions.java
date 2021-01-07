package quiz;
import quiz.SqlConnection;

import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class AdminActions extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminActions frame = new AdminActions();
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
	public AdminActions() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 588, 592);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmBack = new JMenuItem("Back");
		mntmBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AdminLogin().setVisible(true);
				dispose();
			}
		});
		mnFile.add(mntmBack);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(100, 149, 237));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnViewScores = new JButton("View Scores");
		btnViewScores.setBounds(111, 371, 299, 59);
		//btnViewScores.setIcon(new ImageIcon("G:\\ENGINEERING\\SECOND YEAR ENGG\\OOPS in Java\\Programs\\QuizApplication\\images\\view.png"));
		Image img = new ImageIcon(this.getClass().getResource("/view.png")).getImage();
		btnViewScores.setIcon(new ImageIcon(img));
		btnViewScores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ViewScore().setVisible(true);
				dispose();
			}
		});
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(194, 98, 128, 128);
		//lblNewLabel.setIcon(new ImageIcon("G:\\ENGINEERING\\SECOND YEAR ENGG\\OOPS in Java\\Programs\\QuizApplication\\images\\admin (2).png"));
		Image img1 = new ImageIcon(this.getClass().getResource("/admin (2).png")).getImage();
		contentPane.setLayout(null);
		lblNewLabel.setIcon(new ImageIcon(img1));
		contentPane.add(lblNewLabel);
		
		JLabel lblAdminActions = new JLabel("Admin Panel");
		lblAdminActions.setBounds(-103, 34, 708, 54);
		lblAdminActions.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdminActions.setFont(new Font("Tahoma", Font.PLAIN, 30));
		contentPane.add(lblAdminActions);
		
		JButton btnNewButton = new JButton("Question Entry");
		btnNewButton.setBounds(111, 289, 294, 59);
		//btnNewButton.setIcon(new ImageIcon("G:\\ENGINEERING\\SECOND YEAR ENGG\\OOPS in Java\\Programs\\QuizApplication\\images\\enter.png"));
		Image img12 = new ImageIcon(this.getClass().getResource("/enter.png")).getImage();
		btnNewButton.setIcon(new ImageIcon(img12));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new QuestionEntry().setVisible(true);
				dispose();
			}
		});
		contentPane.add(btnNewButton);
		btnViewScores.setFont(new Font("Tahoma", Font.PLAIN, 17));
		contentPane.add(btnViewScores);
	}
}
