package sec01.ex01;

import java.net.URL;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.jasper.compiler.NewlineReductionServletWriter;
import org.apache.jasper.tagplugins.jstl.core.Catch;
import org.eclipse.jdt.internal.compiler.ast.ReturnStatement;

public class MemberDAO {

	private Statement stmt;
	private Connection con;
	
	public List<MemberVO> listMembers()
	{
		List<MemberVO> list = new ArrayList<MemberVO>();
		
	try {
		connDB();
		String query="select * from t_member";
		System.out.println(query);
		ResultSet rs =stmt.executeQuery(query);
		while(rs.next())
		{
			String id = rs.getString("id");
			String pwd = rs.getString("pwd");
			String name = rs.getString("name");
			String email = rs.getString("email");
			String joinData = rs.getString("joinDate");
			MemberVO vo = new MemberVO();
			vo.setId(id);
			vo.setPwd(pwd);
			vo.setName(name);
			vo.setEmail(email);
			vo.setJoinDate(joinData);
			list.add(vo);
					
		}
		rs.close();
		stmt.close();
		con.close();
		}
	catch(Exception e){
		e.printStackTrace();
		}
	return list;
	}

	private void connDB()
	{try {
		getClass().forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("Oracle 드라이버 로딩 성공");
		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","daseul","940427");
		System.out.println("Connection 생성 성공");
		stmt = con.createStatement();
		System.out.println("Statement 생성 성공");	
		} catch (Exception e) {
		// TODO: handle exception
			e.printStackTrace();
			}
	}
	}
