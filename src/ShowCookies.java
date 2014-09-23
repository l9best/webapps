import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ShowCookies extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=gb2312");
		PrintWriter out = response.getWriter();
		String title="Active Cookies";
		out.println("<html><head><title>��ȡ�ͻ���Cookies</title></head>"
				+"<body BGCOLOR=\"#FDF5E6\">\n"
				+"<H1 ALIGN=\"CENTER\">"
				+title+"</H1>\n"
				+"<TABLE border=1 align=\"center\">\n"
				+"<tr bgcolor=\"#FFADOO\">\n"
				+"<th>Cookie Name\n"
				+"<th>Cookie Value");
		Cookie[] cookies=request.getCookies();
		if (cookies!=null) {
			Cookie cookie;
			for(int i=0;i<cookies.length;i++){
				cookie=cookies[i];
				out.println("<tr>\n"
						+"<td>"+cookie.getName()+"</td>\n"
						+"<td>"+cookie.getValue()+"</td></tr>\n");
			}
		}
		out.println("</table></body></html>");
	}
}
