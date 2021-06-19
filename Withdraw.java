package banking_system;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
public class Withdraw extends JFrame implements ActionListener{
	JLabel l1,l2;
	JTextField t1;
	JButton b1,b2,b3;
	long acno;
	private JLabel lblNewLabel;
	public Withdraw(long acno)
	{
		super("Withdraw");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Withdraw.class.getResource("/banking_system/bank-icon.png")));
		this.acno=acno;
		getContentPane().setLayout(null);
		l1=new JLabel("Enter Amount To Withdraw");
		l1.setFont(new Font("Arial Black", Font.BOLD, 25));
		l1.setForeground(new Color(220, 20, 60));
		getContentPane().add(l1);
		l1.setBounds(42,14,420,100);
		l2=new JLabel("Amount :");
		l2.setFont(new Font("Arial Black", Font.BOLD, 20));
		l2.setForeground(new Color(255, 215, 0));
		getContentPane().add(l2);
		l2.setBounds(101,125,100,50);
		t1=new JTextField();
		t1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		getContentPane().add(t1);
		t1.setBounds(228,131,127,40);
		b1=new JButton("Withdraw");
		b1.setBackground(Color.GREEN);
		b1.setForeground(new Color(255, 255, 255));
		b1.setFont(new Font("Arial", Font.BOLD, 13));
		getContentPane().add(b1);
		b1.setBounds(101,212,100,40);
		b2=new JButton("Clear");
		b2.setForeground(Color.WHITE);
		b2.setFont(new Font("Arial", Font.BOLD, 13));
		b2.setBackground(Color.CYAN);
		getContentPane().add(b2);
		b2.setBounds(255,212,100,40);
		b3=new JButton("Cancel");
		b3.setBackground(Color.RED);
		b3.setFont(new Font("Arial", Font.BOLD, 13));
		b3.setForeground(Color.WHITE);
		getContentPane().add(b3);
		b3.setBounds(189,284,80,40);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Withdraw.class.getResource("/banking_system/117091356-indian-money-and-banknotes-500-rupees-and-2-000-rupees-background-of-paper-indian-money-.jpg")));
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
					long amn= Long.parseLong(t1.getText()),k=0;
					Conn cn=new Conn();
					ResultSet rs=cn.s.executeQuery("select * from bank_details where account_no="+acno);
					if(rs.next())
						k=rs.getLong("balance");
						
					if(k>=amn)
					{
						k-=amn;
						cn.s.executeUpdate("update bank_details set balance="+k+"where account_no="+acno);
						cn.s.executeUpdate("insert into transaction_details values("+acno+",sysdate,'Withdrawal',"+amn+","+k+")");
						JOptionPane.showMessageDialog(null,"Amount : "+amn+"\n"+"Withdrawal Successfully");
						new Login();
						setVisible(false);
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Insufficient Balance");
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
