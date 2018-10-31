package kr.or.ddit.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** * BasicServlet.java *  
 * @author 1003yd * @version 1.0 * @see *  * <pre> * << 개정이력(Modification Information) >> *    
 * 수정자 수정내용 * 
 * ------ -----------------------
 
 * 1003yd 최초 생성 * * </pre> */
public class BasicServlet extends HttpServlet {
	//	요청 http 메서드에 따라 실행되는 메서드가 달라진다.
	//	get : doGet
	//	post : doPost
	
	@Override
	public void init() throws ServletException {
		System.out.println("init");
	}
	
	@Override
	public void destroy() {
		System.out.println("destory");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
//		HttpServletRequest  : 요청에 관한 정보 
//		HttpServletResponse  : 응답에 관한 정보 
		resp.setContentType("text/html; charset=utf-8");
		
		PrintWriter pw = resp.getWriter();	// => consle 창이 아닌 web browser에 띄울때  사용한다.
		
		//date format을 이용하여 
		//년-월-일 만 화면에 출력 
		//simpleDateFormat
		Date date = new Date();
		
		SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		pw.print(simpleDate.format(date));
		pw.println();
		pw.print("hello, world");
		pw.println();
		pw.print(date);
		
		pw.print("<!DOCTYPE html>");
		pw.print("	<html>");
		pw.print("		<head>");
		pw.print("			<meta charset= \"UTF-8\">");
		pw.print("			<title> insert title here </title>");
		pw.print("		<head>");
		pw.print("		<body>");
		pw.print("			hello world");
		pw.print("			<br>" + simpleDate.format(date));
		pw.print("		</body>");
		pw.print("	</html>");
		
		pw.flush();
		pw.close();
		
		
	}

	
// 정적자료: index.html => url
// 동적자료: servlet => url mapping 구성 필요 : web.xml
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
	}
}
