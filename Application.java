package banking_system;
import javax.swing.*;
import java.awt.event.*;
import java.util.Random;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.Color;
public class Application extends JFrame implements ActionListener{

	  JLabel l1,l2,l3,l4,l5,l6,l7,l8;
	  JTextField t1,t2,t3,t4,t5,t6;
	  JRadioButton r1,r2,r3;
	  JButton b1,b2,b3;
	  ButtonGroup g1;
	  public Application()
	  {
		  super("Application Form");
		  getContentPane().setBackground(Color.WHITE);
		  getContentPane().setForeground(Color.WHITE);
		  setIconImage(Toolkit.getDefaultToolkit().getImage(Application.class.getResource("/banking_system/Apps-Google-Drive-Forms-icon.png")));
		  getContentPane().setLayout(null);
		  l1=new JLabel("Enter The Details");
		  l1.setForeground(new Color(255, 0, 255));
		  l1.setFont(new Font("Arial Black", Font.BOLD, 30));
		  getContentPane().add(l1);
		  l1.setBounds(198, 24, 320, 73);
		  l2=new JLabel("Name :");
		  l2.setForeground(new Color(255, 215, 0));
		  l2.setFont(new Font("Tahoma", Font.BOLD, 18));
		  getContentPane().add(l2);
		  l2.setBounds(86,100,84,40);
		  t1=new JTextField();
		  t1.setFont(new Font("Arial", Font.PLAIN, 18));
		  getContentPane().add(t1);
		  t1.setBounds(200,108,400,30);
		  l3=new JLabel("Father's Name :");
		  l3.setForeground(new Color(255, 215, 0));
		  l3.setFont(new Font("Tahoma", Font.BOLD, 18));
		  getContentPane().add(l3);
		  l3.setBounds(10,135,180,53);
		  t2=new JTextField();
		  t2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		  getContentPane().add(t2);
		  t2.setBounds(200,149,400,30);
		  l4=new JLabel("DOB :");
		  l4.setForeground(new Color(255, 215, 0));
		  l4.setFont(new Font("Tahoma", Font.BOLD, 18));
		  getContentPane().add(l4);
		  l4.setBounds(100,182,70,40);
		  t3=new JTextField();
		  t3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		  getContentPane().add(t3);
		  t3.setBounds(200,190,400,30);
		  l5=new JLabel("Address :");
		  l5.setForeground(new Color(255, 215, 0));
		  l5.setFont(new Font("Tahoma", Font.BOLD, 18));
		  getContentPane().add(l5);
		  l5.setBounds(71,223,114,40);
		  t4=new JTextField();
		  t4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		  getContentPane().add(t4);
		  t4.setBounds(200,231,400,30);
		  l6=new JLabel("Aadhaar No :");
		  l6.setForeground(new Color(255, 215, 0));
		  l6.setFont(new Font("Tahoma", Font.BOLD, 18));
		  getContentPane().add(l6);
		  l6.setBounds(36,260,154,40);
		  t5=new JTextField();
		  t5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		  getContentPane().add(t5);
		  t5.setBounds(200,268,400,30);
		  l7=new JLabel("Phn No :");
		  l7.setForeground(new Color(255, 215, 0));
		  l7.setFont(new Font("Tahoma", Font.BOLD, 18));
		  getContentPane().add(l7);
		  l7.setBounds(76,301,93,40);
		  t6=new JTextField();
		  t6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		  getContentPane().add(t6);
		  t6.setBounds(200,309,400,30);
		  l8=new JLabel("Account Type :");
		  l8.setForeground(new Color(255, 215, 0));
		  l8.setFont(new Font("Tahoma", Font.BOLD, 18));
		  getContentPane().add(l8);
		  l8.setBounds(20,340,180,40);
		  r1=new JRadioButton("Saving's");
		  r1.setForeground(Color.WHITE);
		  r1.setFont(new Font("Tahoma", Font.BOLD, 18));
		  r1.setBackground(new Color(100, 149, 237));
		  getContentPane().add(r1);
		  r1.setBounds(200,346,108,40);
		  r2=new JRadioButton("Current");
		  r2.setForeground(Color.WHITE);
		  r2.setFont(new Font("Tahoma", Font.BOLD, 18));
		  r2.setBackground(new Color(100, 149, 237));
		  getContentPane().add(r2);
		  r2.setBounds(363,346,114,40);
		  r3 = new JRadioButton();
		  g1 = new ButtonGroup();
		  g1.add(r1);
		  g1.add(r2);
		  g1.add(r3);
		  b1=new JButton("Next");
		  b1.setForeground(new Color(255, 255, 255));
		  b1.setBackground(Color.GREEN);
		  b1.setFont(new Font("Tahoma", Font.BOLD, 18));
		  getContentPane().add(b1);
		  b1.setBounds(198,406,108,43);
		  b2=new JButton("Clear");
		  b2.setForeground(Color.WHITE);
		  b2.setFont(new Font("Arial", Font.BOLD, 18));
		  b2.setBackground(Color.CYAN);
		  getContentPane().add(b2);
		  b2.setBounds(356,408,100,42);
		  b3=new JButton("Cancel");
		  b3.setBackground(Color.RED);
		  b3.setFont(new Font("Arial", Font.BOLD, 18));
		  b3.setForeground(Color.WHITE);
		  getContentPane().add(b3);
		  b3.setBounds(500,406,100,43);
		  JLabel lblNewLabel = new JLabel("New label");
		  lblNewLabel.setIcon(new ImageIcon(Application.class.getResource("/banking_system/1.jpg")));
		  lblNewLabel.setBounds(0, 0, 684, 472);
		  getContentPane().add(lblNewLabel);
		  b1.addActionListener(this);
		  b2.addActionListener(this);
		  b3.addActionListener(this);
		  setSize(700,500);
		  setLocation(500,200);
		  setVisible(true);
		  setResizable(false);
		  setDefaultCloseOperation(EXIT_ON_CLOSE);
	  }
	  public void actionPerformed(ActionEvent e)
	  {
		  if(e.getSource()==b3) {
			  new Login();
			  setVisible(false);
		  }
		  else if(e.getSource()==b2) {
			  t1.setText("");
			  t2.setText("");
			  t3.setText("");
			  t4.setText("");
			  t5.setText("");
			  t6.setText("");
			  r3.setSelected(true);
		  }
		  else if(t1.getText().trim().isEmpty()||t2.getText().trim().isEmpty()||t3.getText().trim().isEmpty()||t4.getText().trim().isEmpty()||t5.getText().trim().isEmpty()||t6.getText().trim().isEmpty()||( !r1.isSelected() && !r2.isSelected())) {
			  JOptionPane.showMessageDialog(null,"Please Fill All Details.");  
		  }
		  else {
				  try {
					  Random r=new Random();
					  long acno=(r.nextLong()%90000000000L)+91320000000L;
					  acno=Math.abs(acno);
					  String a=t1.getText();
					  String b=t2.getText();
					  long c=Long.parseLong(t6.getText());
					  String g=t3.getText();
					  String d=t4.getText();
					  long an =Long.parseLong(t5.getText());
					  String f=null;
					  if(r1.isSelected())
					  {
						  f="Savings";
					  }
					  else
						  f="current";
					  JOptionPane.showMessageDialog(null, "Note Down"+" \n"+ " Account No : " + acno);
					  Conn cn=new Conn();
					  String q="insert into bank_details values("+acno+",'"+a+"','"+b+"',"+c+",'"+g+"','"+d+"',"+an+",'"
							     +f+"',"+0+")";
					  cn.s.executeUpdate(q);
					  new Deposit(acno);
					  setVisible(false);  
				  }
				  catch(Exception ex)
				  {
					  JOptionPane.showMessageDialog(null,"Error Occurred.");
				  }
		    }  
	  }
}
