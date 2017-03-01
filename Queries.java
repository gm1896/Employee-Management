package com;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

@SuppressWarnings("unused")
public class Queries {
Scanner scan;
int id;
String name;
float salary;

public Queries() {
scan = new Scanner(System.in);
Connector.getConnection();
}
public ArrayList<Integer> getId() {
ArrayList <Integer> id= new ArrayList <Integer>();

try {
	String q = "select id from employee";
	Statement st = Connector.con.createStatement();
	ResultSet rs = st.executeQuery(q);
	while (rs.next()) {
		id.add(rs.getInt(1));
	 }
	}
catch(Exception e){
	e.printStackTrace();
}
return id;
}

public String[][] selectAsArray() {
	    String data[][]=null;
	    try {
	    	String q ="select * from employee";
	    	Statement st=Connector.con.createStatement();
	    	ResultSet rs = st.executeQuery(q);
	    	int i =0;
	    	int j =1;
	    	while(rs.next())
	    		i++;
	    	data = new String[i][3];
	    	rs.beforeFirst();
	    	i=0;
	    	while(rs.next())
	    	{
	    		data[i][0]=rs. getString(1);
	    		data[i][1]=rs. getString(2);
	    		data[i][2]=rs. getString(3);
	    	i++;	    	
	    	}
	    }
	    catch(Exception e) {
	    e.printStackTrace();
}
return data;
}


public void select()
{
	try {
	String q = "select * from employee";
	Statement st = Connector.con.createStatement();
	ResultSet rs = st.executeQuery(q);
	System.out.println("Id\tname\tSalary");
	while(rs.next())
	{
		System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
	}
	}
catch(Exception e)
	{
	e.printStackTrace();
	}
	
}
 
public void delete(int id)
{
	try {
	String q = "delete from employee where id=?";
	PreparedStatement pst = Connector.con.prepareStatement(q);
	pst.setInt(1,id);
	int i =pst.executeUpdate();
	System.out.println("Rows affected:"+i);
	}
catch(Exception e)
	{
	e.printStackTrace();
	}
}

public String[] get(int id) {
    String data[]=new String[2];
    try {
    	String q ="select * from employee where id=?";
    	PreparedStatement pst=Connector.con.prepareStatement(q);
    	pst.setInt(1, id);
    	ResultSet rs = pst.executeQuery();
    	while(rs.next())
    	{
    		data[0]=rs. getString(2);
    		data[1]=rs. getString(3);	
    	}
    }
    catch(Exception e) {
    e.printStackTrace();
}
return data;
}

public void update(int id,String name,float salary)
{
	try {
	String q = "update employee set name=?,salary=? where id=?";
	PreparedStatement pst = Connector.con.prepareStatement(q);
	pst.setString(1,name);
	pst.setFloat(2, salary);
	pst.setInt(3,id);
	int i = pst.executeUpdate();
	System.out.println("Rows affected: " +i);
	}
catch(Exception e)
 {
  e.printStackTrace();
 }
}
public void insert(int id,String name,float salary)
{
	try {
		 String q="insert into employee values(?,?,?)";
		 PreparedStatement pst= Connector.con.prepareStatement(q);
		 pst.setInt(1, id);
		 pst.setString(2, name);
		 pst.setFloat(3, salary);
		 int i=pst.executeUpdate();
	}
	catch(Exception e)
			{
			e.printStackTrace();
			}
 } 
	}