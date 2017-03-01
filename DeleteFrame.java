package gui;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import com.*;

	public class DeleteFrame extends JFrame{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		JPanel jp1,jp2; 
		JLabel l1,l2,l3;
		JTextField t2,t3;
		JButton delete,cancel;
		@SuppressWarnings("rawtypes")
		JComboBox jcb1;
		int i=0;
		
		@SuppressWarnings({ "rawtypes", "unchecked" })
		public DeleteFrame()
		{
			super("Delete Frame");
			setSize(500,200);
			setResizable(false);
			setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			
			
			jp1=new JPanel();
			jp2=new JPanel();
			delete=new JButton("Delete");
			cancel=new JButton("Cancel");
			l1=new JLabel("ID:");
			l2=new JLabel("Name:");
			l3=new JLabel("Salary:");
			ArrayList id=new Queries().getId();
			jcb1=new JComboBox(id.toArray());
			t2=new JTextField(10);
		    t3=new JTextField(10);
			t2.setEditable(false);
			t3.setEditable(false);
			
		    jp1.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 25));
		    jp2.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 15));
		    
		    jp1.add(l1);
		    jp1.add(jcb1);
		    jp1.add(l2);
		    jp1.add(t2);
		    jp1.add(l3);
		    jp1.add(t3);
		    jp2.add(delete);
		    jp2.add(cancel);
		    add(jp1);
		    add(BorderLayout.SOUTH,jp2);
		    
		    setLocation(300,250);
		    setVisible(true);
		    
		   //event handling
		    
	        cancel.addActionListener(new ActionListener() {
				
			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent e) {
	               HomeFrame h=new HomeFrame();
	               dispose();
					
				}
			});
	        
	       	        jcb1.addActionListener(new ActionListener() {
				
	 		public void actionPerformed(ActionEvent e) {
	           
	 			try{
	 			Queries q=new Queries();
	                String[] rs=new String[2];
	                int i=(int) jcb1.getSelectedItem();
	                rs=q.get(i);
	                t2.setText(rs[0]);
	                t3.setText(rs[1]);
	 			}
	 		catch( NullPointerException  ae){
	 			}
	 		}
	 		
	 		});
				
		    
	        delete.addActionListener(new ActionListener()
	        {
	  		public void actionPerformed(ActionEvent e) {
	            try{     
	  			Queries q=new Queries();
	                 int i=(int) jcb1.getSelectedItem();
	                 q.delete(i);
	                 jcb1.setToolTipText("");
	                 t2.setText("");
	                 t3.setText("");
	                
	                 ArrayList id1=new Queries().getId();
	                 
	                 if(jcb1.getSelectedIndex()>-1)
	                 {
	                	 id1.remove(jcb1.getSelectedIndex());
	                	 jcb1.removeItemAt(jcb1.getSelectedIndex());
	                	 
	                 }
	                 
	                 jcb1=new JComboBox(id1.toArray());
	            }

	            catch(IndexOutOfBoundsException | NullPointerException  ae){
	          	  			   }
	         		}
	  		   	  		});   
		}	
	}