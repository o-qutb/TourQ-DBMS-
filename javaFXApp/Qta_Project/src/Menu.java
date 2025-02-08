import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Menu extends JFrame {
    
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Menu frame = new Menu();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    
    public Menu(){
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
        
        JButton btnNewButton = new JButton("Add Customer");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) 
            {
                AddCust.main(null);
            }
        });
        btnNewButton.setBounds(109, 30, 200, 21);
        contentPane.add(btnNewButton);
        
        JButton btnNewButton_1 = new JButton("Make Reservation");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) 
            {
                MakeResv.main(null);
            }
        });
        btnNewButton_1.setBounds(109, 60, 200, 21);
        contentPane.add(btnNewButton_1);
        
        JButton btnNewButton_2 = new JButton("Add Tour Trip");
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) 
            {
                AddTrip.main(null);
            }
        });
        btnNewButton_2.setBounds(109, 90, 200, 21);
        contentPane.add(btnNewButton_2);
        
        JButton btnNewButton_3 = new JButton("Update");
        btnNewButton_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) 
            {
                Update.main(null);
            }
        });
        btnNewButton_3.setBounds(109, 120, 200, 21);
        contentPane.add(btnNewButton_3);
        
        JButton btnNewButton_4 = new JButton("Delete Customer");
        btnNewButton_4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) 
            {
                DeleteCust.main(null);
            }
        });
        btnNewButton_4.setBounds(109, 150, 200, 21);
        contentPane.add(btnNewButton_4);
        
        JButton btnNewButton_5 = new JButton("Search");
        btnNewButton_5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) 
            {
                Search.main(null);
            }
        });
        btnNewButton_5.setBounds(109, 180, 200, 21);
        contentPane.add(btnNewButton_5);
        
        
        JButton btnNewButton_6= new JButton("Views");
        btnNewButton_6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) 
            {
               Views.main(null);
            }
        });
        btnNewButton_6.setBounds(109, 210, 200, 21);
        contentPane.add(btnNewButton_6);
        

    }
}
