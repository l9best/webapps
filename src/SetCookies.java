import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.concurrent.ForkJoinPool.ForkJoinWorkerThreadFactory;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class SetCookies extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		for(int i=0;i<3;i++){
			Cookie cookie=new Cookie("Session-Cookie-"+i, "Cookie-Value-S"+i);
			response.addCookie(cookie);
			cookie = new Cookie("Presistent-Cookie-"+i, "Cookie-Value-P"+i);
			cookie.setMaxAge(3600);
			response.addCookie(cookie);
		}
		
		response.setContentType("text/html;charset=gb2312");
		PrintWriter out=response.getWriter();
		String title="Setting Cookies";
		out.println("<html><head><title>…Ë÷√Cookie</title></head>"
				+"<body BGCOLOR=\"#FDF5E6\">\n"
				+"<H1 ALIGN=\"CENTER\">"
				+title+"</H1>\n"
				+"There are six cookies associated with this page.\n"
				+"To see them, visit the\n"+"<A HREF=\"ShowCookies\">\n"
				+"<CODE>ShowCookies</CODE>servlet</A>.\n"+"<P>\n"
				+"Three of the cookies are associated only with the\n"
				+"current session,while three are persistent.\n"
				+"°≠°≠°≠°≠°≠°≠°≠°≠°≠°≠°≠°≠°≠°≠°≠°≠°≠°≠°≠°≠°≠°≠°≠°≠°≠°≠°≠°≠\n"
				+"<CODE>ShowCookies</CODE>servlet to verify that\n"
				+"</body></html>");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
