package kr.or.ddit.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.encrypt.sha.KISA_SHA256;
import kr.or.ddit.user.model.UserVO;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.user.service.UserServiceInf;

public class LoginServlet extends HttpServlet{
//	private final String USERID= "brown";
//	private final String PASSWORD = "1234";
	//service  --> request.getMethod() : "POST", "GET" --> doGet, doPost
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
//		String newParameter = req.getParameter("newParameter");
//		System.out.println("new Parameter : " + newParameter);
		
//		Map<String, String[]> reqMap =  req.getParameterMap();
//		reqMap.put("newParameter", new String[] {"newValue"});
		
		
		
		
		//1.  사용자 아이디, 비밀번호를  request객체에서 받아온다
		//2. db에서 조회해온 아이디, 비밀번호를 체크한다.
		//3-1. 일치할 경우 main.jsp로 이동
		//3-2. 불일치할 경우 login.jsp로 이동
		
		//1. 사용자 아이디, 비밀번호를 requset 객체에서 받아온다.
		String userId = req.getParameter("userId"); 
		String password = req.getParameter("password");
		//remember-me 파라미터 받아서 sysout으로 출력
		String rememberMe = req.getParameter("remember-me");
		System.out.println(rememberMe);
		
		
		//rememberMe == null : 아이디 기억 사용안함
		if(rememberMe == null){
			//setMaxAge(시간) => 게시글 중에 하루동안 안보기 같은거라 생각해! => 기간을 정해 놓고 저장하는거
			//setMaxAge(0) => 0 값을 주게되면 무효화가 되어 쿠키에서 삭제가 된다. => 쿠키를 삭제하는 메서드가 따로 없어서 이렇게 사용해야되!!
			//cookie.setMaxAge(60*60*24);
			Cookie[] cookies = req.getCookies();
			for(Cookie cookie : cookies){
				//cookie 이름이 remember, usrId일 경우 maxage를 -1로 설정하여 쿠키를 유효하지 않도록 설정
				System.out.println(cookie.getName());
				if(cookie.getName().equals("remember") || cookie.getName().equals("userId")){
					cookie.setMaxAge(0);
					resp.addCookie(cookie);
				}
			}
			
		}
		//rememberMe != null : 아이디 기억 사용
		else{
			//response 객체에 쿠키를 저장
			Cookie cookie = new Cookie("remember", "Y");
			Cookie userIdCookie = new Cookie("userId", userId);
			
			resp.addCookie(cookie);
			resp.addCookie(userIdCookie);
		}
		
		//2. db에서 조회해온 아이디, 비밀번호를 체크한다.(db는 상수로 임시 대체) => DB로 대체
		// 2-1 사용자가 전송한 userId 파라미터로 사용자 정보 조회
		// 2-2 db에서 조회한 사용자 비밀번호가 파라미터로 전송된 비밀번호와 동일한지 비교
		// 2-3 session에 사용자 정보등록(as-is: 임의의 UserVO 등록 / to-be : db에서 조회한 userVo)
		UserServiceInf service = new UserService();
		UserVO user = service.selectUser(userId);
		System.out.println(user.getUserId());
		System.out.println(user.getPass());
		
		//이미 아이디가 검색되어 온것이기 때문에 아이디는 비교할 필요가 없고 검색된 아이디가 존재하지 않을경우 null 비교와
		// 아이디가 존재할 때의 비밀번호가 일치하는 지만 확인을 해주면 된다.
//		String encryptPass = KISA_SHA256.encrypt(password);
		if(user != null && user.getPass().equals(password)){
			//3-1. 일치할 경우 main.jsp로 이동
			//redirect
//			resp.sendRedirect("main.jsp?userId=" + userId + "&password=" + password );
			
			//1. session에 사용자 정보 설정
//			UserVO userVo = new UserVO();
//			userVo.setUserId(userId);
//			userVo.setName("브라운");
//			userVo.setAlias("곰");
//			userVo.setBirth(new Date());
			
//			HttpSession session = req.getSession();
//			session.setAttribute("userVo", userVo);
			
			// 1-1 db로 session에 사용자 정보 설정
			HttpSession session = req.getSession();
			session.setAttribute("S_USER", user);
			//2.main.jsp
			//body 영역에  이름[별명] 님 안녕하세요
			//dispatch
			RequestDispatcher rd = req.getRequestDispatcher("/main.jsp");
			rd.forward(req, resp);
		}else{
			//3-2    불일치할 경우 login.jsp로 이동
			resp.sendRedirect("/");
		}
		
		
		
		
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter pw =resp.getWriter();
		
		pw.println("<!DOCTYPE html>");
		pw.println("	<html>");
		pw.println("		<head>");
		pw.println("			<meta charset=\"UTF-8\">");
		pw.println("			<title>Insert title here</title>");
		pw.println("		</head>");
		pw.println("		<body>");
		
	
		//userId : brwon / sally
		String[] userIds = req.getParameterValues("userId");
		for(String userId : userIds)
			pw.println("		userId : " + userId + "<br>");
		pw.println("		password : " + req.getParameter("password") + "<br>");
		pw.println("		</body>");
		pw.println("	</html>");
	}
}







