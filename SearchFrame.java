package gui;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import com.Queries;

public class SearchFrame extends JFrame
{ /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
 Container c;
JPanel jp1,jp2,jp3;
 JButton ok;
JButton back;
JLabel l1,l2,l3;
JTextField t1;
JTextField t2;
JTextField t3;

public SearchFrame()
{
super("Search Employees");
	
    setSize(500,500);
	setResizable(false);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	jp1 = new JPanel();
    jp2 = new JPanel();
    jp3 = new JPanel();
    ok = new JButton("OK");
    back = new JButton("Back");
    //set the layout of jp1 and jp2
    jp1=new JPanel(new FlowLayout(FlowLayout.CENTER));
    l1=new JLabel("ID");
    t1=new JTextField(20);
    jp1.add(l1);
    jp1.add(t1);
    
    jp2=new JPanel(new FlowLayout(FlowLayout.CENTER));
    l2=new JLabel("NAME");
    t2=new JTextField(20);
    t2.setEditable(false);
    jp2.add(l2);
    jp2.add(t2);
    
    jp3=new JPanel(new FlowLayout(FlowLayout.CENTER));
    l3=new JLabel("SALARY");
    t3=new JTextField(20);
    t3.setEditable(false);
    jp3.add(l3);
    jp3.add(t3);
    
    jp3.add(ok);
    jp3.add(back);
    
    c=getContentPane();
    c.setLayout(new BoxLayout(c,BoxLayout.Y_AXIS));
    c.add(jp1);
    c.add(jp2);
    c.add(jp3);
    ok.addActionListener(new L1());

    setLocation(300,300);
    setVisible(true);
    
    //EVENT HANDLING
    
   /* ok.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent ae)
    	{
    		Queries q = new Queries();
    		String row[]=q.get(Integer.parseInt(t1.getText()));
    		t2.setText(row[0]);
    		t3.setText(row[1]);
    	 	}
    }); 
    */
    back.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent ae){
    		dispose();
    		new gui.HomeFrame();
    	}
    });
} 


class L1 implements ActionListener{
public void actionPerformed(ActionEvent ae)
{
if(t1.getText().equals("")){
JOptionPane.showMessageDialog(c,"ID should NOT be Blank");
t1.requestFocus();
}
else{
try{
double id = Double.parseDouble(t1.getText());
if(id<=0)
{
JOptionPane.showMessageDialog(c,"ID should BE > 0");
t1.setText("");
t1.requestFocus();
}

else
{
	ok.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent ae)
    	{
    		Queries q = new Queries();
    		String row[]=q.get(Integer.parseInt(t1.getText()));
    		t2.setText(row[0]);
    		t3.setText(row[1]);
    	 	}
    }); 	
}
}
catch(NumberFormatException e){
JOptionPane.showMessageDialog(c,"Enter Proper ID:");
t1.setText("");
t1.requestFocus();
}}}
}


public static void main(String[] args){
	
	SearchFrame s= new SearchFrame();
	s.setSize(400,400);
	s.setResizable(false);
	s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	s.jp1 = new JPanel();
    s.jp2 = new JPanel();
    s.jp3 = new JPanel(); 
    s.ok = new JButton("OK");
    s.back = new JButton("Back");
    s.setLocation(300,300);
    s.setVisible(true);
}
}