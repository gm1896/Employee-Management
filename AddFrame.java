package gui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import com.Queries;

public class AddFrame extends JFrame   {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel jp1,jp2;
	JButton add,update,back;
	JLabel l1,l2,l3;
	JTextField t1,t2,t3;
	public AddFrame() {
		super("Add or Update Employee");
		setSize(500, 150);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jp1=new JPanel();
		jp2=new JPanel();
		add=new JButton("Add");
		update=new JButton("Update");
		back=new JButton("Back");
		l1=new JLabel("Id:");
		l2=new JLabel("Name:");
		l3=new JLabel("Salary:");
		t1=new JTextField(5);
		t2=new JTextField(10);
		t3=new JTextField(10);
		jp1.setLayout(new FlowLayout(FlowLayout.CENTER,10,25));
		jp2.setLayout(new FlowLayout(FlowLayout.CENTER,10,15));
		jp1.add(l1);
		jp1.add(t1);
		jp1.add(l2);
		jp1.add(t2);
		jp1.add(l3);
		jp1.add(t3);
		jp2.add(add);
		jp2.add(update);
		jp2.add(back);
		add(jp1);
		add(jp2,BorderLayout.SOUTH);
		setLocation(290, 200);
		setVisible(true);
		
		//EVENT HANDLING
		
		back.addActionListener(new ActionListener() {
			
			
			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent ae) {
				HomeFrame h1=new HomeFrame();
				dispose();
				
			}
		});
		
		add.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent ae) {
				try{
				Queries q=new Queries();
				q.insert(Integer.parseInt(t1.getText()),t2.getText(),Float.parseFloat(t3.getText()));
				t1.setText(" ");
				t2.setText(" ");
				t3.setText(" ");
				}
				catch(NumberFormatException a){
					System.out.println("Please Enter Valid Data as per the Panel");
					
				}
				
			}
		});
		
		update.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent ae) {
				try{
				Queries q=new Queries();
				q.update(Integer.parseInt(t1.getText()),t2.getText(),Float.parseFloat(t3.getText()));
				t1.setText(" ");
				t2.setText(" ");
				t3.setText(" ");
				   }
			catch(NumberFormatException e){
			          }
			
			}
			
		                          });
	}
}