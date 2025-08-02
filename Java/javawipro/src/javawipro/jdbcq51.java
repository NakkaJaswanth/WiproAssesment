package javawipro;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class jdbcq51 {
	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		try
		{
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root","J@sh8367");
			st=con.createStatement();
			rs=st.executeQuery("select * from student_list");
			 while (rs.next()) {
	                int id = rs.getInt("id");
	                String name = rs.getString("name");
	                int age = rs.getInt("age");
	                String course = rs.getString("course");
	                float marks = rs.getFloat("marks");

	                System.out.println("ID: " + id +
	                                   ", Name: " + name +
	                                   ", Age: " + age +
	                                   ", Course: " + course +
	                                   ", Marks: " + marks);
	            }

	        } catch (Exception e) {
	            System.out.println("MySQL JDBC Driver not found.");
	            e.printStackTrace();
	        } finally
		{
				try
				{
					if(rs!=null) 
						rs.close();
					if(st!=null)
						st.close();
					if(con!=null)
						con.close();
				}
				catch(Exception e)
				{
					System.out.println("Finally Block::"+e);
				}
			
			}




		}

	}

		

