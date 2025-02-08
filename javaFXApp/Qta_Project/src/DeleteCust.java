
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;

public class DeleteCust extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField V1;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteCust frame = new DeleteCust();
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
	public DeleteCust() {
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
		V1.setBounds(158, 39, 96, 19);
		contentPane.add(V1);
		V1.setColumns(10);
		
		
		JLabel lblNewLabel = new JLabel("CUSTID");
		lblNewLabel.setBounds(91, 42, 45, 13);
		contentPane.add(lblNewLabel);
	
		
		JButton btnNewButton = new JButton("Delete");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try 
				{
					Utility ut=new Utility();
					String sql="delete from customer where CustID=? ";
					ut.conn.setAutoCommit(false);
					PreparedStatement pstmt=ut.conn.prepareStatement(sql);
					pstmt.setString(1, V1.getText());
					pstmt.executeUpdate();
					
					int x=JOptionPane.showConfirmDialog(null,"Do You Wish to Delete Cust and his reservation?","Press Yes or No",JOptionPane.YES_NO_OPTION);
					if(x==JOptionPane.YES_OPTION)
					{
						ut.conn.commit();
						JOptionPane.showMessageDialog(null,"Customer deleted");
					}
					else
					{
						ut.conn.rollback();
						JOptionPane.showMessageDialog(null,"Customer Not deleted");
					}
					
					ut.terminate();
				} 
				catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(303, 38, 85, 21);
		contentPane.add(btnNewButton);
		

	}

}
