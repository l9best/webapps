
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ShowRs extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		response.setContentType("text/html;charset=gb2312");
		PrintWriter out = response.getWriter();
		out.println("<table border=1>");
		out.println("<tr><td>Content:</td></tr>");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost/bbs?user=root&password=1234");
			stmt=conn.createStatement();
			rs=stmt.executeQuery("select * from article");
			while (rs.next()) {
				out.println("<tr><td>"+rs.getString("title")+"</td></tr>");
			}
			out.println("</table>");
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}finally{
			try {
				if (rs!=null) {
					rs.close();
					rs=null;
				}if (stmt!=null) {
					stmt.close();
					stmt=null;
				}if (conn!=null) {
					conn.close();
					conn=null;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
