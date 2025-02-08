import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Views extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Views frame = new Views();
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
	public Views() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 400);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("MENU");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("LOGOUT");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try {
					Utility ut=new Utility();
					String sql="TRUNCATE TABLE agent_session";
					ut.pstmt=ut.conn.prepareStatement(sql);
					ut.pstmt.executeUpdate();
					
					Login.main(null);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("ADD A CUSTOMER");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				AddCust.main(null);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Make Reservation");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				MakeResv.main(null);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Add Trip");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				AddTrip.main(null);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("UPDATE");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Update.main(null);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("DELETE A CUSTOMER");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				DeleteCust.main(null);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("SEARCH");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Search.main(null);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_6);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Views");
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Views.main(null);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_7);
		
		JSeparator separator = new JSeparator();
		mnNewMenu.add(separator);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("EXIT SYSTEM");
		mntmNewMenuItem_8.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) 
				{
					try {
						Utility ut=new Utility();
						String sql="TRUNCATE TABLE agent_session";
						ut.pstmt=ut.conn.prepareStatement(sql);
						ut.pstmt.executeUpdate();
						
						System.exit(DO_NOTHING_ON_CLOSE);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
		});
		mnNewMenu.add(mntmNewMenuItem_8);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("DISPLAY RESERVATIONS");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try {
					Utility ut=new Utility();
					ut.stmt = ut.conn.createStatement(); 
					String sql="select * from VIEW_RES";
					ut.rs=ut.stmt.executeQuery(sql);
					table_1.setModel(DbUtils.resultSetToTableModel(ut.rs));
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(160, 10, 302, 32);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("DISPLAY TOURS");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try {
					Utility ut1 = new Utility();
					ut1.stmt = ut1.conn.createStatement(); 
					String sql1 = "SELECT * FROM VIEW_TOUR";
					ut1.rs = ut1.stmt.executeQuery(sql1);
					table_1.setModel(DbUtils.resultSetToTableModel(ut1.rs));
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBounds(160, 40, 302, 32);
		contentPane.add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(70, 100, 505, 190);
		contentPane.add(scrollPane);
		

		
		table_1 = new JTable();
		scrollPane.setViewportView(table_1);
	}

}
