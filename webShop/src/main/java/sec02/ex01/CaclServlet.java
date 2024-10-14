package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jdt.internal.compiler.ast.ReturnStatement;


/**
 * Servlet implementation class CaclServlet
 */
@WebServlet("/calc")
public class CaclServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final double USD_RATE = 1359.93;
	private static final double JTY_RATE = 9.08;
	private static final double CNY_RATE = 191.92;
	private static final double GBP_RATE = 1763.37;
	private static final double EUR_RATE = 1484.42;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() throws ServletException{
		System.out.println("init 메서드 호출");
	}
	/**
	 * @see Servlet#destroy()
	 */
	public void destory() {
		System.out.println("destroy 메서드 호출");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter pw = response.getWriter();
		String command = request.getParameter("command");
		String won = request.getParameter("won");
		String operator = request.getParameter("operator");
		
		if(command!=null&&command.contentEquals("calculate"))
		{
			String result = calculate(Float.parseFloat(won),operator);
			pw.print("<html><font size=10>변환결과</font><br>");
			pw.print("<html><font size=10>"+result+"</font><br>");
			pw.print("<a href='/calc'>환율 계산기</a>");
			return;
		}
		
		pw.print("<html><title>환율 계산기</title>");
		pw.print("<font size=5>환율 계산기</font><br>");
		pw.print("<form name='frmCalc' method='get' action='/calc' />");
		pw.print("원화 : <input type='text' name='won' size=10 /> ");
		pw.print("<select name='operator'>");
		pw.print("<option value='dollar'>달라</dollar>");
		pw.print("<option value='en'>엔화</en>");
		pw.print("<option value='wian'>위안</wian>");
		pw.print("<option value='pound'>파운드</pound>");
		pw.print("<option value='euro'>유로</euro>");
		pw.print("</select>");
		pw.print("<input type='hidden' name='command' value='calculate' />");
		pw.println("<input type='submit' value='변환' />");
		pw.println("</form>");
		pw.print("</html>");
		pw.close();
	}
	
	private static String calculate(float won,String operator) {
		String result=null;
		if(operator.equals("dollar")) {
			result=String.format("%.6f", won/USD_RATE);
		}else if(operator.equals("en")) {
			result=String.format("%.6f", won/JTY_RATE);
		}else if(operator.equals("wian")) {
			result=String.format("%.6f", won/CNY_RATE);
		}else if(operator.equals("pound")) {
			result=String.format("%.6f", won/GBP_RATE);
		}else if(operator.equals("euro")) {
			result=String.format("%.6f", won/EUR_RATE);
		}
		return result;
	}
}


