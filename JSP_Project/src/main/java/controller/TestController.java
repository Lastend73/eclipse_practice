package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.TestService;
import dto.TestDto;

/**
 * Servlet implementation class TestController
 */
@WebServlet({ "/mainPage", "/boardList", "/join", "/joinForm", "/loginForm" })
public class TestController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TestController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		// TODO Auto-generated method stub
		String url = request.getServletPath();
		System.out.println("url :" + url);

		String path = request.getContextPath(); // JSP.project
		System.out.println(path);
//		response.sendRedirect(path +"/resultPage.jsp");

		request.setCharacterEncoding("UTF-8"); // post로 받을때 인코딩 설정
		response.setContentType("text/html; charset=UTF-8");

		PrintWriter out;
		TestService tsvc = new TestService();

		switch (url) {
		case "/boardList":
			System.out.println("게시판 페이지 이동");
//			response.sendRedirect(path + "/boardList.jsp");
			// 1. 게시판 체이지에 출력할 데이터 조회
			ArrayList<TestDto> list = tsvc.getBoardList();
			
//			request.setAttribute("이름", "저장할 데이터");
			request.setAttribute("tList", list);
			RequestDispatcher dispatcher = request.getRequestDispatcher("boardList.jsp");//주소뿐 아닌 데이터도 같이 보낼때 사용
//			RequestDispatcher dispatcher = request.getRequestDispatcher("넘겨줄 페이지명"); <- 경로설정
			
			dispatcher.forward(request, response);
			// 실재 전송
			
			// service
			break;

		case "/joinForm":
//		회원가입페이지 이동 요청
			System.out.println("회원가입 페이지 이동요청");
			response.sendRedirect(path + "/joinForm.jsp");
			break;

		case "/loginForm":
//		로그인페이지 이동 요청
			System.out.println("로그인 페이지 이동요청");
			response.sendRedirect(path + "/loginForm.jsp");
			break;

		case "/mainPage":
			System.out.println("메인 페이지 이동요청");
			response.sendRedirect(path + "/mainPage.jsp");
			break;

		case "/join":
			System.out.println("회원 가입 요청");
			// 1. 파라메터 확인 request.getParameter(name 값 이력)
			String id = request.getParameter("joinId"); // 출력할 필요없을때는 redirect로 사용
			System.out.println("입력한 아이디 : " + id);

			String pw = request.getParameter("joinPw");
			System.out.println("입력한 비밀번호 : " + pw);

			String birth = request.getParameter("joinBirth");
			System.out.println("입력한 생일 : " + birth);

			int joinResult = 1;

			if (joinResult > 0) {
				System.out.println("회원가입 성공!");
				// 메인페이지
//				response.sendRedirect(path+"/mainPage.jsp?check=y");
//				response.sendRedirect(path+"/joinSuccess.jsp");
				out = response.getWriter();
				out.println("<script>");
				out.println("alert('가입성공');");
				out.println("location.href ='" + path + "/mainPage.jsp'");
				out.println("</script>");
			} else {
				System.out.println("회원가입 실패!");
				// 회원가입 페이지로 이동
				response.sendRedirect(path + "/joinFail.jsp");
				out = response.getWriter();
				out.println("<script>");
				out.println("alert('fail');");
				out.println("history.back();");
				out.println("</script>");
			}

			break;

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doPost() 실행");
		doGet(request, response);
	}

}
