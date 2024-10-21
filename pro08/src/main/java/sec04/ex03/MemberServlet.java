package sec04.ex03;


import java.awt.geom.PathIterator;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.ant.AbstractCatalinaCommandTask;
import org.xml.sax.DocumentHandler;


/**
 * Servlet implementation class MemberServlet3
 */
@WebServlet("/memberServlet")
public class MemberServlet extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doHandle(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doHandle(request,response);
	}
	
	private void doHandle(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		MemberDAO dao= new MemberDAO();
		List memberList=dao.listMembers();
		request.setAttribute("memberList", memberList);
		RequestDispatcher dispatch = request.getRequestDispatcher("viewServlet");
		dispatch.forward(request, response);
	}

}
//		PrintWriter out = response.getWriter();
//		String command = request.getParameter("command");
//		
//		if(command!=null && command.equals("addMember"))
//		{
//			String _id= request.getParameter("id");
//			String _pwd= request.getParameter("pwd");
//			String _name= request.getParameter("name");
//			String _email= request.getParameter("email");
//			MemberVO vo = new MemberVO();
//			vo.setId(_id);
//			vo.setPwd(_pwd);
//			vo.setName(_name);
//			vo.setEmail(_email);
//			dao.addMember(vo);
//		} else if(command!=null&&command.contentEquals("delMember"))
//		{
//			String id= request.getParameter("id");
//			dao.delMember(id);
//		}
//		List<MemberVO> list = dao.listMembers();
//		out.print("<html><body>");
//		out.print("<table boarder=1><tr align='center' bgcolor='lightgreen'>");
//		out.print("<td>아이디</td><td>비밀번호</td><td>이름</td><td>이메일</td><td>가입일</td><td>삭제</td></tr>");
//		
//		for(int i=0;i<list.size();i++) {
//			MemberVO memberVO =(MemberVO) list.get(i);
//			String id=memberVO.getId();
//			String pwd=memberVO.getPwd();
//			String name = memberVO.getName();
//			String email=memberVO.getEmail();
//			Date joinDate = memberVO.getJoinDate();
//			out.print("<tr><td>"+ id +"</td><td>"+ pwd +"</td><td>"+name+"</td><td>"+email+"</td><td>"+joinDate+"</td><td>"
//			+ "<a href='memberServlet3?command=delMember&id="+id+ "'>삭제</a></td></tr>");
//		}
//		out.print("</table></body></html>");
//		out.print("<a href='/memberForm.html'>새 회원 등록하기</a>");
//	}

