package edu.mvctest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//모델에 해당하는 클래스
//DB에 접속하는 역할
public class StudentDAO {
	//데이터 베이스에 접속하기 위함
	Connection  conn = null;
	PreparedStatement pstmt = null;
	
	final String JDBC_DRIVER="com.mysql.cj.jdbc.Driver" ;
	final String JDBC_URL ="jdbc:mysql://localhost:3307/webdb?useSSL=false&serverTimezone=Asia/Seoul" ;
	
	public void open()
	{
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(
					JDBC_URL,"root", "worldcup7!");  
			//conn이 500번지에 접속된 주소
		}catch(Exception  e)
			{ e.printStackTrace();  }
	}
	public void close()
	{
		try {
			pstmt.close();
			conn.close();
		}catch(SQLException  e)
		{ e.printStackTrace();  }
	}
	
	public void insert(Student  s)
	{
		open();
		String sql = "INSERT INTO student(username, univ,birth,email) values(?,?, ?, ?);" ;
		try {
			pstmt = conn.prepareStatement(sql); 
			pstmt.setString(1, s.getUsername() ); // 첫번쨰 ? 에 넣어줌
			pstmt.setString(2, s.getUniv() );
			pstmt.setDate(3, s.getBirth() );
			pstmt.setString(4, s.getEmail() );
			
			pstmt.executeUpdate(); //** insert, delete, update 다 executeUpdate씀
			}
		
		catch(Exception  e){ 
				e.printStackTrace(); 
				}
		
		finally { 
			close();  
			}
	}
	
	public ArrayList<Student>  getAll()
	{
		open();
		ArrayList<Student>  students = 
				new ArrayList<>(); //students 를 원소로 갖는 
		
		try {
			pstmt = conn.prepareStatement(
					"select * from student;"); //** select* querry문 쓸때는 executeQuery
			ResultSet  rs = null;
			rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				Student  s = new Student() ;
				s.setId(rs.getInt("id"));
				s.setUsername(rs.getString("username"));
				s.setUniv(rs.getString("univ"));
				s.setBirth(rs.getDate("birth"));
				s.setEmail(rs.getString("email"));
				
				students.add(s);
			}
			
		}
		catch(Exception  e){
			e.printStackTrace();  
		}
		
		finally {
			close();
		}
		
		return  students;		
	}
}
