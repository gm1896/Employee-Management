package gui;
import java.awt.event.*;
import javax.swing.*;
import com.Queries;

public class ViewFrame extends JFrame {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
JScrollPane jsc;
JTable table;
String heading[]={"Id","Name","Salary"};
Object data[][]=null;

public ViewFrame()
{
super("View All Employees");
	setSize(500,250);
	setResizable(false);
	Queries q = new Queries();
	data = q.selectAsArray();
	table = new JTable(data,heading);
	jsc = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	for(int i=0;i<data.length;i++)
		for(int j=0;j<data[0].length;j++)
			table.setValueAt(data[i][j],i,j);
	add(jsc);
	setLocation(290,200);
	setVisible(true);
	
	//EVENT HANDLING
	
	addWindowListener(new WindowAdapter() {
		@SuppressWarnings("unused")
		public void windowClosing(WindowEvent we)
		{
			HomeFrame hf = new HomeFrame();
			dispose();
		}
	});
}
		
}
	

