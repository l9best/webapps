import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ShowRsUseBean extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charaset=gb2312");
		PrintWriter out=response.getWriter();
		
		out.println("<table border=1>");
		out.println("<tr><td>Content:</td></tr>");
		
		Connection conn=DB.getConn();
		Statement stmt=DB.getStatement(conn);
		String sql="select * from article";
		ResultSet rs=DB.getResultSet(stmt, sql);
		try {
			while (rs.next()) {
				out.println("<tr><td>"+rs.getString("title")+"</td></tr>");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DB.close(rs);
			DB.close(stmt);
			DB.close(conn);
		}
	}

}
