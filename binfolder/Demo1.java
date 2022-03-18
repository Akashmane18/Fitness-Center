import java.lang.*;
import java.sql.*;
class Demo1
{
public static void main(String ar[])throws Exception
{
try
{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection con=DriverManager.getConnection("jdbc:odbc:Surashree");
System.out.println("Connection Established");
Statement stmt=con.createStatement();
ResultSet rs=stmt.executeQuery("select * from Demo");
while(rs.next())
{
System.out.println("ID=" + rs.getInt(1) + "Name=" + rs.getString(2));
}
con.close();
}
catch(ClassNotFoundException e)
{
e.printStackTrace();
System.out.println(e.toString());
}


}

}