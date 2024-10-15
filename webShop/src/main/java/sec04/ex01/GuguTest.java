package sec04.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

/**
 * Servlet implementation class GuguTest
 */
@WebServlet("/test01/guguTest")
public class GuguTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		int dan = Integer.parseInt(request.getParameter("dan"));
		out.print("<table border=1 width=800 align=center>");
		out.print("<tr align = center bgcolor='#FFFFF6'>");
		out.print("<td colspan=2>" + dan +"단 출력 </td>");
		out.print("</tr>");
		for(int i =1;i<10;i++) {
			out.print("<tr align=center>");
			out.print("<td width=400>");
			out.print(dan+"* " + i);
			out.print("</td>");
			out.print("<td width=400>");
			out.print(i*dan);
			out.print("</td>");
			out.print("</tr>");
		}
		out.print("</table>");
	}

}
