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
		setBounds(100, 100, 1067, 593);
		
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
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{147, 299, 110, 299, 0};
		gbl_contentPane.rowHeights = new int[]{65, 111, 37, 59, 59, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JButton btnViewScores = new JButton("View Scores");
		
		Image img = new ImageIcon(this.getClass().getResource("/view.png")).getImage();
		btnViewScores.setIcon(new ImageIcon(img));
		btnViewScores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ViewScore().setVisible(true);
				dispose();
			}
		});
		
		JLabel lblNewLabel = new JLabel("");
		
		Image img1 = new ImageIcon(this.getClass().getResource("/admin (2).png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img1));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridwidth = 3;
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblAdminActions = new JLabel("Admin Panel");
		lblAdminActions.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdminActions.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblAdminActions = new GridBagConstraints();
		gbc_lblAdminActions.fill = GridBagConstraints.BOTH;
		gbc_lblAdminActions.insets = new Insets(0, 0, 5, 0);
		gbc_lblAdminActions.gridwidth = 3;
		gbc_lblAdminActions.gridx = 1;
		gbc_lblAdminActions.gridy = 3;
		contentPane.add(lblAdminActions, gbc_lblAdminActions);
		
		JButton btnNewButton = new JButton("Question Entry");
		
		Image img12 = new ImageIcon(this.getClass().getResource("/enter.png")).getImage();
		btnNewButton.setIcon(new ImageIcon(img12));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new QuestionEntry().setVisible(true);
				dispose();
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 4;
		contentPane.add(btnNewButton, gbc_btnNewButton);
		btnViewScores.setFont(new Font("Tahoma", Font.PLAIN, 17));
		GridBagConstraints gbc_btnViewScores = new GridBagConstraints();
		gbc_btnViewScores.fill = GridBagConstraints.BOTH;
		gbc_btnViewScores.gridx = 3;
		gbc_btnViewScores.gridy = 4;
		contentPane.add(btnViewScores, gbc_btnViewScores);
	}
}
