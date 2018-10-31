package kr.or.ddit.file.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
@MultipartConfig(maxFileSize=1024*1024*5, maxRequestSize=1024*1024*5*5)
@WebServlet("/fileUpload")
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//fileUpload.jsp로 전달
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/fileUpload/fileUpload.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// getReader를 사용하면 stream이 닫혀버려서 밑에 수행문들이 읽혀지지않음
//		request.getReader();
		
		//일반 text 파라미터 : request.getparameter("파라미터명");
		//파일 : request.getPart("파라미터명");
		System.out.println(request.getContentType());
		System.out.println(request.getParameter("userId"));
//		System.out.println(request.getParameter("profile"));
		Part profilePart = request.getPart("profile");
		System.out.println("getContentType : " + profilePart.getContentType());
		
		//Content-disposition 헤더 정보
		//파일과 관련된 부가 정보
		
		System.out.println("Contetn-dispotision : s"+profilePart.getHeader("Content-disposition"));
		
		String contentDisposition = profilePart.getHeader("Content-disposition"); 
		String fileName="";
		String[] strArray = contentDisposition.split("; ");
		
		for(String str : strArray){
			if(str.indexOf("filename") >= 0 ){
				//filename="brown.png"
				fileName = str.substring(10, str.lastIndexOf("\""));
			}
		}
		
		//파일 쓰기
//		profilePart.write("D:\\A_TeachingMaterial\\6.JspSrpgin\\upload\\" + new String(fileName.getBytes("utf-8"), "ISO-8859-1"));
		//url 정보를 실제 파일 경로로 변경
		String path = getServletContext().getRealPath("/profile");
		profilePart.write("D:\\A_TeachingMaterial\\6.JspSrpgin\\upload\\" + fileName);
		profilePart.delete();	//파일 업로드 과정에서 사용한 디스트 임시영역을 정리
	}

}
