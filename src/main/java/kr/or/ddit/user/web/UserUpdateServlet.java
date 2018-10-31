package kr.or.ddit.user.web;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

@MultipartConfig(maxFileSize=1024*1024*5, maxRequestSize=1024*1024*5*5)
@WebServlet("/userUpdateServlet")
public class UserUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		UserServiceInf userService = new UserService();
		UserVO userVo = userService.selectUser(userId);

		request.setAttribute("userVo", userVo);

		request.getRequestDispatcher("/user/userUpdate.jsp").forward(request, response);


	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//post 한글 파라미터 인코딩 처리 => 맨처음에 시작되어야한다. 
		request.setCharacterEncoding("utf-8");
		UserServiceInf service = new UserService();
		UserVO userVo = new UserVO();
		userVo.setUserId(request.getParameter("userId"));
		userVo.setPass(request.getParameter("pass"));
		userVo.setName(request.getParameter("name"));
		userVo.setAddr1(request.getParameter("addr1"));
		userVo.setAddr2(request.getParameter("addr2"));
		userVo.setZipcd(request.getParameter("zipcd"));
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			userVo.setBirth(sdf.parse(request.getParameter("birth")));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		userVo.setTel(request.getParameter("tel"));
		userVo.setEmail(request.getParameter("email"));

		//파일 받아올 때 맨위에 @MultipartConfig(maxFileSize=1024*1024*5, maxRequestSize=1024*1024*5*5) 있는 지 확인
		// 그리고 받아올 jsp 에서 enctype="multipart/form-data" 가 있는지 확인
		Part profilePart = request.getPart("profile");
		String contentDispostition = profilePart.getHeader("Content-disposition");
		String fileName = StringUtil.getFileNameFormHeader(contentDispostition);
		System.out.println(fileName);
		String profile;
		if(fileName.equals("")){
			profile = null;
		}else{
			String path = getServletContext().getRealPath("/profile");
			//File.separator : 파일경로 설정시 OS에 따라서 대렉토리 사이 표시하는 구분자가 다르다
			// 그 구분자들을 각각 써주는 것 보다  File.separator를 이용하여 구분자를 사용한다 생각해
			profilePart.write(path + File.separator + fileName );
			profile = "/profile/" + fileName;
			userVo.setProfile(profile);
			profilePart.delete();
			
		}



		service.updateUser(userVo);

		response.sendRedirect("/userPageList?page=1&pageSize=10");

	}

}
