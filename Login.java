package banking_system;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;
public class Login extends JFrame implements ActionListener{
	JLabel l1,l2,l3;
	JButton b1,b2,b3;
	JTextField t1,t2;
	public Login()
	{
		super("GRAMEEN BANK");
		setForeground(Color.WHITE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/banking_system/bank-icon.png")));
		setBackground(Color.WHITE);
		getContentPane().setForeground(Color.BLACK);
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		l1=new JLabel("25 DIN ME PAISA DOUBLE!");
		l1.setBackground(Color.WHITE);
		l1.setForeground(new Color(255, 69, 0));
		l1.setFont(new Font("Arial Black", Font.BOLD, 35));
		getContentPane().add(l1);
		l1.setBounds(130,0 ,542,80);
		l2=new JLabel("Account No : ");
		l2.setForeground(new Color(0, 0, 255));
		l2.setFont(new Font("Arial Black", Font.BOLD, 18));
		getContentPane().add(l2);
		l2.setBounds(208,173, 140, 68);
		t1=new JTextField();
		t1.setFont(new Font("Arial", Font.PLAIN, 18));
		getContentPane().add(t1);
		t1.setBounds(208,247,400,40);
		l3=new JLabel("Name : ");
		l3.setForeground(new Color(0, 0, 255));
		l3.setFont(new Font("Arial Black", Font.BOLD, 18));
		getContentPane().add(l3);
		l3.setBounds(210,68, 90, 80);
		t2=new JTextField();
		t2.setFont(new Font("Arial", Font.PLAIN, 18));
		getContentPane().add(t2);
		t2.setBounds(208,135,400,40);	
		b1=new JButton("Sign In");
		b1.setForeground(Color.WHITE);
		b1.setBackground(Color.GREEN);
		b1.setFont(new Font("Arial Black", Font.BOLD, 18));
		getContentPane().add(b1);
		b1.setBounds(207,322,111,40);
		b2=new JButton("Clear");
		b2.setForeground(Color.WHITE);
		b2.setBackground(Color.RED);
		b2.setFont(new Font("Arial Black", Font.BOLD, 18));
		getContentPane().add(b2);
		b2.setBounds(499,322,111,40);
		b3=new JButton("Create New Account");
		b3.setForeground(Color.WHITE);
		b3.setBackground(Color.CYAN);
		b3.setFont(new Font("Arial Black", Font.BOLD, 18));
		getContentPane().add(b3);
		b3.setBounds(285,383,250,40);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/banking_system/117091356-indian-money-and-banknotes-500-rupees-and-2-000-rupees-background-of-paper-indian-money-.jpg")));
		lblNewLabel.setBounds(0, 0, 784, 461);
		getContentPane().add(lblNewLabel);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		setSize(800,500);
		setLocation(500,200);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e)
	{
		try {
			
			if(e.getSource()==b1)
			{
				if(t1.getText().trim().isEmpty()||t2.getText().trim().isEmpty()) {
					JOptionPane.showMessageDialog(null,"Please Fill Necessary Details.");
				}
				else {
					long a=Long.parseLong(t1.getText());
					String b=t2.getText();
					Conn cn=new Conn();
					String q="select * from bank_details where account_no="+a+" and name='"+ b+"'";
					ResultSet rs=cn.s.executeQuery(q);
					if(rs.next())
					{
						new Transaction(a);
						setVisible(false);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "INVALID:"+"\n"+"ACCOUNT NO OR NAME");
					}
				}
			}
			else if(e.getSource()==b2)
			{
				t1.setText("");
				t2.setText("");
			}
			else
			{
			  new Application();
			  setVisible(false);
			}
		}
		 catch(Exception ex)
		 {
			 JOptionPane.showMessageDialog(null,"Error Occurred.");
		 }
	}
	public static void main(String arg[])
	{
		new Login();
	}
}
