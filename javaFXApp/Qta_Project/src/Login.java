import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField V1;
	private JTextField V2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		V1 = new JTextField();
		V1.setBounds(167, 36, 96, 19);
		contentPane.add(V1);
		V1.setColumns(10);
		
		V2 = new JTextField();
		V2.setBounds(167, 65, 96, 19);
		contentPane.add(V2);
		V2.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("USERNAME");
		lblNewLabel.setBounds(90, 39, 70, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("PASSWORD");
		lblNewLabel_1.setBounds(90, 68, 70, 13);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try {
					Utility ut=new Utility();
					String sql="SELECT USERNAME,PASSWORD,AGENTID FROM LOGIN WHERE USERNAME=? AND PASSWORD=?";
					PreparedStatement pstmt=ut.conn.prepareStatement(sql);
					String un=V1.getText();
					String ps=V2.getText();
					pstmt.setString(1, un);
					pstmt.setString(2, ps);
					ResultSet rs=pstmt.executeQuery();
					if(rs.next())
					{
			            String agentId = rs.getString("AGENTID");
			            String username = rs.getString("USERNAME");
			            
	
			            Utility ut_1 = new Utility();
			            String sql_1 = "INSERT INTO agent_session (AGENT_ID, USERNAME) VALUES (?, ?)";
			            ut_1.pstmt = ut_1.conn.prepareStatement(sql_1);
			            ut_1.pstmt.setString(1, agentId);
			            ut_1.pstmt.setString(2, username);
			            ut_1.pstmt.executeUpdate();
						Menu.main(null);
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Incorrect Credentilas");
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBounds(167, 108, 85, 21);
		contentPane.add(btnNewButton);
	}

}
