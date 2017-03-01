package gui;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class HomeFrame extends JFrame  {
	JPanel jp;
 JButton add,delete,view,search;
 
public HomeFrame() {
	super("Employee Records Management");
	setSize(400,100);
	setResizable(false);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	jp = new JPanel();
	add = new JButton("ADD");
	delete = new JButton("DELETE");
	view = new JButton("VIEW ALL");
	search = new JButton("SEARCH");
	jp.setLayout(new FlowLayout(FlowLayout.CENTER,10,25));
	jp.add(add);
	jp.add(delete);
	jp.add(view);
	jp.add(search);
	add(jp);
	setLocation(290,200);
	setVisible(true);
	
	//EVENT HANDLING
	
	
	add.addActionListener(new ActionListener ()    {
		public void actionPerformed(ActionEvent ae) {
			AddFrame a= new AddFrame();
			dispose();
		}
	});
	
		
	delete.addActionListener(new ActionListener ()    {
		public void actionPerformed(ActionEvent ae) {
			DeleteFrame d= new DeleteFrame();
			dispose();
		}
	});
	
	
	
	view.addActionListener(new ActionListener ()    {
		public void actionPerformed(ActionEvent ae) {
			ViewFrame v= new ViewFrame();
			dispose();
		}
	});


	search.addActionListener(new ActionListener ()    {
		public void actionPerformed(ActionEvent ae) {
			SearchFrame s= new SearchFrame();
			dispose();
		}
	});
}
public static void main(String args[])
{ 
	HomeFrame h1= new HomeFrame();
	h1.setSize(400,100);
	h1.setResizable(false);
	h1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	h1.jp = new JPanel();
	h1.add = new JButton("ADD");
	h1.delete = new JButton("DELETE");
	h1.view = new JButton("VIEW ALL");
	h1.search = new JButton("SEARCH");
	h1.jp.setLayout(new FlowLayout(FlowLayout.CENTER,10,25));
    h1.setLocation(290,200);
	h1.setVisible(true);
}
} 


