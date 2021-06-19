package banking_system;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.Font;
import java.awt.Color;
public class Transaction extends JFrame implements ActionListener{
	JLabel l1;
	JButton b1,b2,b3,b4,b5;
	long acno;
	private JLabel lblNewLabel;
	public Transaction(long acno)
	{
		super("Transaction");
		this.acno=acno;
		getContentPane().setLayout(null);
		l1=new JLabel("Select Operation ");
		l1.setForeground(new Color(255, 105, 180));
		l1.setFont(new Font("Arial Black", Font.BOLD, 30));
		getContentPane().add(l1);
		l1.setBounds(82,26,313,40);
		b1=new JButton("Withdraw");
		b1.setFont(new Font("Arial", Font.BOLD, 18));
		b1.setBackground(new Color(124, 252, 0));
		getContentPane().add(b1);
		b1.setBounds(71,100,140,40);
		b2=new JButton("Deposit");
		b2.setBackground(new Color(173, 255, 47));
		b2.setFont(new Font("Arial", Font.BOLD, 18));
		getContentPane().add(b2);
		b2.setBounds(300,100,140,40);
		b3=new JButton("Balance Enquiry");
		b3.setFont(new Font("Arial", Font.BOLD, 13));
		b3.setForeground(new Color(255, 255, 255));
		b3.setBackground(new Color(0, 255, 255));
		getContentPane().add(b3);
		b3.setBounds(71,200,140,40);
		b4=new JButton("Mini-Statements");
		b4.setBackground(new Color(135, 206, 250));
		b4.setForeground(new Color(255, 255, 255));
		b4.setFont(new Font("Arial", Font.BOLD, 13));
		getContentPane().add(b4);
		b4.setBounds(300,200,140,40);
		b5=new JButton("Back");
		b5.setFont(new Font("Arial", Font.PLAIN, 18));
		b5.setBackground(Color.RED);
		b5.setForeground(Color.WHITE);
		getContentPane().add(b5);
		b5.setBounds(219,296,80,40);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Transaction.class.getResource("/banking_system/117091356-indian-money-and-banknotes-500-rupees-and-2-000-rupees-background-of-paper-indian-money-.jpg")));
		lblNewLabel.setBounds(0, 0, 484, 361);
		getContentPane().add(lblNewLabel);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		setSize(500,400);
		setLocation(500,200);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b1)
		{
			new Withdraw(acno);
			setVisible(false);
		}
		else if(e.getSource()==b2)
		{
			new Deposit(acno);
			setVisible(false);
		}
		else if(e.getSource()==b3)
		{
			try {
				long bal=0;
				Conn cn = new Conn();
				ResultSet rs=cn.s.executeQuery("select * from bank_details where account_no="+acno);
				if(rs.next())
					bal=rs.getLong("balance");
				JOptionPane.showMessageDialog(null,"Available Bal : "+bal);
			}
			catch(Exception ex) {
				JOptionPane.showMessageDialog(null,"Error Occurred.");
			}
		}
		else if(e.getSource()==b4)
		{
			new Mini_Statement(acno);
			setVisible(false);
		}
		else
		{
			new Login();
			setVisible(false);
		}
	}
}
