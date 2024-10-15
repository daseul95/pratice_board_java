package sec03.ex02;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.xml.sax.DocumentHandler;

/**
 * Servlet implementation class LoginServlet4
 */
@WebServlet("/login4")
public class LoginServlet4 extends HttpServlet {
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet메서드 호출");
		doHandle(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost메서드 호출");
		doHandle(request,response);
	}

	
	private void doHandle(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		request.setCharacterEncoding("utf-8");
		String user_id = request.getParameter("user_id");
		System.out.println("doHandle 메서드 호출");
		String user_pw = request.getParameter("user_pw");
		System.out.println("아이디: "+user_id);
		System.out.println("비밀번호: "+user_pw);
	}
	
}
