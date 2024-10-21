package sec04.ex03;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;



import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {

	private PreparedStatement pstmt;
	private Connection con;
	private DataSource dataFactory;
	
	public MemberDAO() {
		try {
			
			Context ctx = new InitialContext();
			Context envContext = (Context)ctx.lookup("java:/comp/env");
			dataFactory = (DataSource)envContext.lookup("jdbc/oracle");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public List<MemberVO> listMembers()
	{
		List<MemberVO> list = new ArrayList<MemberVO>();
		
	try {
		con = dataFactory.getConnection();
		String query="select * from t_member";
		System.out.println("prepareStatement: "+query);
		pstmt=con.prepareStatement(query);
		ResultSet rs =pstmt.executeQuery(query);
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
		pstmt.close();
		con.close();
		
	
		}
	catch(Exception e){
		e.printStackTrace();
		}
	return list;
	}
	
	public void addMember(MemberVO memberVO) 
	{
		
		try {
			con = dataFactory.getConnection();
			String id= memberVO.getId();
			String pwd = memberVO.getPwd();
			String name= memberVO.getName();
			String email = memberVO.getEmail();
			
			String query="insert into t_member";
			query+=" (id,pwd,name,email)";
			query+=" values(?,?,?,?)";
			System.out.println("PreparedStatment: "+query);
			
			pstmt =con.prepareStatement(query);
			pstmt.setString(1,id);
			pstmt.setString(2,pwd);
			pstmt.setString(3,name);
			pstmt.setString(4,email);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public void delMember(String id) {
		// TODO Auto-generated method stub
		try {
			con = dataFactory.getConnection();
			
			String query="delete from t_member" + " where id=?";
			System.out.println("prepareStatement:"+query);
			pstmt=con.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			pstmt.close();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

//	private void connDB()
//	{try {
//		getClass().forName("oracle.jdbc.driver.OracleDriver");
//		System.out.println("Oracle 드라이버 로딩 성공");
//		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","daseul","940427");
//		System.out.println("Connection 생성 성공");
//		stmt = con.createStatement();
//		System.out.println("Statement 생성 성공");	
//		} catch (Exception e) {
//		// TODO: handle exception
//			e.printStackTrace();
//			}
//	}
	}
