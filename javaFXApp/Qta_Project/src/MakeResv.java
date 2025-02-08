
import javax.swing.JFrame;
import java.awt.EventQueue;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class MakeResv extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField V1;
	private JTextField V2;
	private JTextField V3;
	private JTextField V4;
	private JTextField V5;
	private JTextField V6;
	private JTextField V7;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MakeResv frame = new MakeResv();
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
	public MakeResv() {
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

		V1 = new JTextField();
		V1.setBounds(180, 34, 96, 19);
		contentPane.add(V1);
		V1.setColumns(10);

		V2 = new JTextField();
		V2.setBounds(180, 65, 96, 19);
		contentPane.add(V2);
		V2.setColumns(10);

		V3 = new JTextField();
		V3.setBounds(180, 94, 96, 19);
		contentPane.add(V3);
		V3.setColumns(10);

		V4 = new JTextField();
		V4.setBounds(180, 124, 96, 19);
		contentPane.add(V4);
		V4.setColumns(10);

		V5 = new JTextField();
		V5.setBounds(180, 154, 96, 19);
		contentPane.add(V5);
		V5.setColumns(10);

		V6 = new JTextField();
		V6.setBounds(180, 184, 96, 19);
		contentPane.add(V6);
		V6.setColumns(10);

		V7 = new JTextField();
		V7.setBounds(180, 214, 96, 19);
		contentPane.add(V7);
		V7.setColumns(10);


		JLabel lblNewLabe_0 = new JLabel("Reserv Num");
		lblNewLabe_0.setBounds(109, 37, 70, 13);
		contentPane.add(lblNewLabe_0);
		
		JLabel lblNewLabel_1 = new JLabel("Reserv Date");
		lblNewLabel_1.setBounds(109, 65, 70, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Status");
		lblNewLabel_2.setBounds(109, 94, 70, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabe_3 = new JLabel("CUST ID");
		lblNewLabe_3.setBounds(109, 124, 70, 13);
		contentPane.add(lblNewLabe_3);
		
		JLabel lblNewLabe_4 = new JLabel("Agent ID");
		lblNewLabe_4.setBounds(109, 154, 70, 13);
		contentPane.add(lblNewLabe_4);
		
		JLabel lblNewLabe_5 = new JLabel("Tour Num");
		lblNewLabe_5.setBounds(109, 184, 70, 13);
		contentPane.add(lblNewLabe_5);
		
		JLabel lblNewLabel_6 = new JLabel("Trip Date");
		lblNewLabel_6.setBounds(109, 214, 70, 13);
		contentPane.add(lblNewLabel_6);

		JButton btnNewButton = new JButton("EXIT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Utility ut = new Utility();
					dispose();
					ut.terminate();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}
		});
		btnNewButton.setBounds(109, 274, 85, 21);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Add");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Utility ut = new Utility();
					String sql = "insert into reservation values(?,?,?,?,?,?,?)";
					ut.conn.setAutoCommit(false);
					ut.pstmt = ut.conn.prepareStatement(sql);
//					ut.stmt = ut.conn.createStatement(); 
					ut.pstmt.setString(1, V1.getText());
					ut.pstmt.setDate(2, java.sql.Date.valueOf(V2.getText())); 
					ut.pstmt.setString(3, V3.getText());
					ut.pstmt.setString(4, V4.getText());
					ut.pstmt.setString(5, V5.getText());
					ut.pstmt.setString(6, V6.getText());
					ut.pstmt.setDate(7, java.sql.Date.valueOf(V7.getText()));
					
					ut.pstmt.executeUpdate();
					int x = JOptionPane.showConfirmDialog(null, "Do You Wish to Save?", "Press Yes or No",
							JOptionPane.YES_NO_OPTION);
					if (x == JOptionPane.YES_OPTION) {
						ut.conn.commit();
						JOptionPane.showMessageDialog(null, "Reservation Saved");
					} else {
						ut.conn.rollback();
						JOptionPane.showMessageDialog(null, "Reservation Not Saved");
					}

					ut.terminate();

				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(204, 274, 85, 21);
		contentPane.add(btnNewButton_1);
	}

}
