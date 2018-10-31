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

@WebServlet("/fileDownloadName")
public class FileDownlodeNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// 파일에 대한 정보 (파일명 등..) : header
		// 응답에 대한 정보 (html이 아니라 바이너리 파일인걸 알려줘야함) : contentType 
		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposithon", "attachment; filename=ㅇㅇㅇ.txt");
		
		File f = new File("D:\\W\\A_TeachingMaterial\\6.JspSrpgin\\upload\\ㅇㅇㅇ.txt");
		
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
