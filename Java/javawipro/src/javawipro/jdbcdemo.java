package javawipro;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;



public class jdbcdemo {

	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		try
		{
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/WIPROBATCH1","root","J@sh8367");
			
			
			st=con.createStatement();
			rs=st.executeQuery("select * from wipro_emps");
			while(rs.next())
			{
				
				int a=rs.getInt("eno");
				String b=rs.getString(2);
				float c=rs.getFloat("salary");
				String d=rs.getString("dept");

				System.out.println(a+ " "+b + " "+c + " "+d );
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		finally
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
