package edu.mvctest;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

/**
 * Servlet implementation class StudentController
 */
public class StudentController extends HttpServlet {
	//컨트롤러 서블릿으로 만듬
	// DAO 클래스 안에 있던 inser, list를 호출하는것을 컨트롤러가함
	private static final long serialVersionUID = 1L;
       
	StudentDAO   dao ;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentController() { //기본 생성자
        super();
        dao = new StudentDAO() ;
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
    //서비스 함수 -> @Override 있어야함/ 부모클래스에 있는 HttpServletRequest를 자식이 오버라이드 한것
    //서비스 함수 통째로 주석
    @Override
	protected void service(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
    	
    	request.setCharacterEncoding("UTF-8");
    	System.out.println("service()inner face"); //서비스 메소드가 호출된다는게 콘솔창에 나올것임 이클립스가 한국어는 지원안하는것 같음
    	
    	String action = request.getParameter("action");
    	
		String  view = null ;
		
		if(action == null)
		{
			getServletContext().
			getRequestDispatcher("/StudentController?action=list").
			//action 매게변수에 list가 저장됌
			forward(request, response);
		}
		else
		{
			switch(action)
			{
			case "list":
				view = list(request, response);
				break;
			case "insert":
				view = insert(request, response);
				break;
			}//end of switch()
			
			getServletContext().
			getRequestDispatcher("/" + view).// "/" 는 루트 밑에 라는 뜻임 루트 밑에 뷰
			forward(request , response);
			//서블릿의 환경을 표현하는 ServletContext 객체
			//서블릿의 환경 정보를 가져오는 방법
			//서블릿 클래스나 JSP 페이지의 환경에 관련된 정보는 javax.servlet 패키지의 ServletContext 인터페이스 타입의 객체를 이용해서 얻을 수 있다.
			//서블릿 클래스에서 이 타입의 객체를 구하기 위해서는 getServletContext라는 메서드를 호출하면 된다.

			
		}//end of else		
	}//end of service()
    
	
	public String insert(HttpServletRequest request,
			HttpServletResponse response)
	{
		Student  s = new Student();
		try {
			String username = 
				request.getParameter("username");
			String univ = 
				request.getParameter("univ");
			Date  birth = 
	Date.valueOf(request.getParameter("birth")); //Date타입을 바꾸겠다.
			String  email = 
				request.getParameter("email");
			
			s.setUsername(username); //멤버변수
			s.setUniv(univ);
			s.setBirth(birth);
			s.setEmail(email);
			
		}catch(Exception e) {e.printStackTrace(); }
		
		dao.insert(s);
		return list(request , response);
		
	}
	
	public String  list(HttpServletRequest  request,
			HttpServletResponse  response)
	{
		request.setAttribute("students", 
					dao.getAll()); // getAll 메소드 호출 students - 속성변수
		return  "studentsInfo.jsp" ;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	//doGet이 제일 먼저 호출됌 <a href>가 get방식임
	//새로 고침 누르면 doGet이 제일 먼저 실행
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		//served at: 이 화면에 찍히는데 표에 가려져서 안보이는것
		// doGet 서비스 메소드 호출함
	}
	//getContextPath가 가리키는것은 studentinfo, 서비스 함수가 주석처리되서 served at: 만 호출하고 끝남
	//doGet 메소드가 jsp컨테이너에서 자동적으로 서비스메소드가 호출됌
	// 서비스메소드@@
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response); //doGet 메소드 호출
	}

}