package banking_system;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;
public class Deposit extends JFrame implements ActionListener{
	JLabel l1,l2;
	JTextField t1;
	JButton b1,b2,b3;
	long acno;
	private JLabel lblNewLabel;
	public Deposit(long acno)
	{
		super("Deposit");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Deposit.class.getResource("/banking_system/bank-icon.png")));
		this.acno=acno;
		getContentPane().setLayout(null);
		l1=new JLabel("Enter Amount To Deposit");
		l1.setForeground(new Color(220, 20, 60));
		l1.setBackground(new Color(255, 255, 255));
		l1.setFont(new Font("Arial Black", Font.PLAIN, 25));
		getContentPane().add(l1);
		l1.setBounds(69,9,360,100);
		l2=new JLabel("Amount :");
		l2.setBackground(new Color(253, 245, 230));
		l2.setForeground(new Color(255, 215, 0));
		l2.setFont(new Font("Arial Black", Font.BOLD, 20));
		getContentPane().add(l2);
		l2.setBounds(104,115,100,50);
		t1=new JTextField();
		t1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		getContentPane().add(t1);
		t1.setBounds(230,125,100,32);
		b1=new JButton("Deposit");
		b1.setForeground(Color.WHITE);
		b1.setBackground(Color.GREEN);
		b1.setFont(new Font("Arial", Font.BOLD, 13));
		getContentPane().add(b1);
		b1.setBounds(104,200,87,40);
		b2=new JButton("Clear");
		b2.setFont(new Font("Arial Black", Font.BOLD, 12));
		b2.setForeground(Color.WHITE);
		b2.setBackground(Color.CYAN);
		getContentPane().add(b2);
		b2.setBounds(250,200,80,40);
		b3=new JButton("Cancel");
		b3.setFont(new Font("Arial Black", Font.BOLD, 12));
		b3.setForeground(Color.WHITE);
		b3.setBackground(Color.RED);
		getContentPane().add(b3);
		b3.setBounds(182,287,80,40);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel.setIcon(new ImageIcon(Deposit.class.getResource("/banking_system/117091356-indian-money-and-banknotes-500-rupees-and-2-000-rupees-background-of-paper-indian-money-.jpg")));
		lblNewLabel.setBounds(0, 0, 484, 361);
		getContentPane().add(lblNewLabel);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		setSize(500,400);
		setLocation(500,200);
		setResizable(false);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
	{
		try {
			if(e.getSource()==b1)
			{
				if(t1.getText().trim().isEmpty()) {
					JOptionPane.showMessageDialog(null,"Amount Field Cannot Be Empty");
				}
				else {
					long amn= Long.parseLong(t1.getText()),ab=amn;
					Conn cn=new Conn();
					ResultSet rs=cn.s.executeQuery("select * from bank_details where account_no="+acno);
					if(rs.next())
					{
						amn+=rs.getLong("balance");
						cn.s.executeUpdate("update bank_details set balance="+amn+"where account_no="+acno);
						cn.s.executeUpdate("insert into transaction_details values("+acno+",sysdate,'Deposited',"+ab+","+amn+")");
						JOptionPane.showMessageDialog(null,"Amount : "+ab+"\n"+" Deposited Successfully");
						new Login();
						setVisible(false);
					}
				}
			}
			else if(e.getSource()==b2)
			{
			  t1.setText("");
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Operation Unsuccessful");
				new Login();
				setVisible(false);
			}
		}
			catch(Exception ex) {
				JOptionPane.showMessageDialog(null,"Error Occurred.");
			}
	}
}
