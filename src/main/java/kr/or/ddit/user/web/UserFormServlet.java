package kr.or.ddit.user.web;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import kr.or.ddit.user.model.UserVO;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.user.service.UserServiceInf;
import kr.or.ddit.util.StringUtil;

/**
 * Servlet implementation class UserFormServlet
 */
@MultipartConfig(maxFileSize=1024*1024*5, maxRequestSize=1024*1024*5*5)
@WebServlet("/userForm")
public class UserFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	//get방식 한글 파라미터 인코딩 처리는 server.xml에서 connector 태그에 URIEncodin 을 변경해준다.
	//사용자 등록 화면
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//userForm.jsp로 위임
		request.getRequestDispatcher("/user/userForm.jsp").forward(request, response);
		
	}
	
	//사용자 등록
	//서버 상태가 바뀌게 되면 redirect를 사용한다.
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//post 한글 파라미터 인코딩 처리
		request.setCharacterEncoding("utf-8");
		
		
		//파라미터 받아오기
		//userId , name, pass, addr1, addr2, zipcd, email, tel
//		String userId = request.getParameter("userId");
//		System.out.println(userId);
//		String pass = request.getParameter("pass");
//		String addr1 = request.getParameter("addr1");
//		String addr2 = request.getParameter("addr2");
//		String zipcd = request.getParameter("zipcd");
//		String email = request.getParameter("email");
//		String birth = request.getParameter("birth");
//		String tel = request.getParameter("tel");
		
		Part profilePart = request.getPart("profile");
		String contentDispostition = profilePart.getHeader("Content-disposition");
		String fileName = StringUtil.getFileNameFormHeader(contentDispostition);
		
		String path = getServletContext().getRealPath("/profile");
		profilePart.write(path + File.separator + fileName );
		profilePart.delete();
		
		UserVO userVo = new UserVO();
		userVo.setUserId(request.getParameter("userId"));
		userVo.setPass(request.getParameter("pass"));
		userVo.setName(request.getParameter("name"));
		userVo.setAddr1(request.getParameter("addr1"));
		userVo.setAddr2(request.getParameter("addr2"));
		userVo.setZipcd(request.getParameter("zipcd"));
		userVo.setEmail(request.getParameter("email"));
		userVo.setTel(request.getParameter("tel"));
		String profile = "/profile/" + fileName;
		userVo.setProfile(profile);
		//yyyy-MM-dd
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			userVo.setBirth(sdf.parse(request.getParameter("birth")));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//사용자 등록 서비스 호출(미구현)
		UserServiceInf userService = new UserService();
		userService.insertUser(userVo);
		
		//파일 업로드
	
		//사용자 리스트로 이동(redirect : 서버 상태가 변경되므로 사용자가 새로고침을 통해 재 요청시 등록되는 현상을 막는다.)
		response.sendRedirect("/userPageList?page=1&pageSize=10");
	}

}
