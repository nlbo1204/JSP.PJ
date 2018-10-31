package kr.or.ddit.file.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.user.model.UserVO;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.user.service.UserServiceInf;

@WebServlet("/fileDownload")
public class FileDownlodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String userId = request.getParameter("userId");
		
		UserServiceInf userService = new UserService();
		UserVO userVo = userService.selectUser(userId);
		
		System.out.println("userVo =" + userVo);
		File f = new File(userVo.getProfile());
		
		FileInputStream fis = new FileInputStream(f);
		byte[] buffer = new byte[512];
		int len = 0;
		
		ServletOutputStream sos = response.getOutputStream();
		
		// 파일읽기
		while ((len = fis.read(buffer)) != -1) { // len이라는 변수를 넣어서 읽을게있을때까지 반복
			// 파일 쓰기
			sos.write(buffer, 0 , len); //  0 , len = 0부터 len 읽을것만큼
		}  
		sos.close();
		fis.close();
	}


}
