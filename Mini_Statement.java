package banking_system;
import javax.swing.*;
import javax.swing.table.*;
import java.sql.*;
import java.awt.event.*;
import java.awt.Toolkit;
public class Mini_Statement extends JFrame {
    public Mini_Statement(long acno)
    {
    	super("MINI-STATEMENTS");
    	setIconImage(Toolkit.getDefaultToolkit().getImage(Mini_Statement.class.getResource("/banking_system/bank-icon.png")));
    	try {
        	String date,type,am,ab;
        	getContentPane().setLayout(null);
        	JTable t1=new JTable();
        	DefaultTableModel dm=new DefaultTableModel();
        	dm.setColumnIdentifiers(new Object[] {"Date","Time","Type","Amount","Available Bal"});
        	Conn cn=new Conn();
        	ResultSet rs=cn.s.executeQuery("select * from transaction_details where account_no="+acno+"order by transaction_date");
        	while(rs.next())
        	{
        		date=rs.getString("transaction_date");
        		String info[]=date.split("\\s+");
        		type=rs.getString("type");
        		am=rs.getString("amount");
        		ab=rs.getString("available_bal");
        		dm.addRow(new Object[] {info[0],info[1],type,am,ab});
        	}
        	t1.setModel(dm);
        	t1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        	JScrollPane sp= new JScrollPane(t1);
        	sp.setBounds(0, 0, 600, 400);
        	getContentPane().add(sp);
        	setSize(600,400);
    		setLocation(500,200);
    		setVisible(true);
    		setResizable(false);
    		addWindowListener(new WindowAdapter(){
    			public void windowClosing(WindowEvent w)
    	    	{
    	           new Login();
    	           setVisible(false);
    	    	}
    		});
    	}
    	catch(Exception e)
    	{
    		JOptionPane.showMessageDialog(null,"Error Occurred.");
    	}
    }
}
