<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="kr.or.ddit.util.model.PageVO"%>
<%@page import="kr.or.ddit.user.service.UserService"%>
<%@page import="kr.or.ddit.user.service.UserServiceInf"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- core tag prefix : c  --%>
	<%-- jstl 태그 사용법 : <prefix : 태그명 > --%>
	<h2>core set</h2>
	<%-- pageContext.setAttribute("attribute", "cSetValue"); 와 같은 의미 --%>
	<c:set var="attribute" value="cSetValue" />

	el: ${attribute}
	<br> pageContext :
	<%= pageContext.getAttribute("attribute") %>
	<br> request:
	<%= request.getAttribute("attribute") %>
	<br>

	<h2>core remove</h2>
	<%-- pageContext.removeAttribute("attribute"); --%>
	<c:remove var="attribute" />
	el: ${attribute}
	<br>


	<h2>core if => 단일 비교</h2>
	<%-- if(){
			}else if(){
			} 
		core의 if는 단순한 하나의 조건만을 비교하는 단일비교  if 이다.		
	--%>
	<c:set var="code" value="01" />

	<%-- code가 "01"이면 if 안쪽 코드가 실행 --%>
	<%-- 
		el 조건 주의 사항 
			1. el의 조건식은 {}안에 해야한다
			2. 조건 이외의 공백 및 다른 것이 들어가면 인식하지 못한다.
			3. {}안의 문자열 처리는 '' 아니면 \"\" 이런 식으로 사용한다.
	 --%>
	<c:if test="${code == '01'}">
	 	if 안쪽
	</c:if>

	<h2>core choose : 실질적인 if 구문</h2>
	<c:choose>
		<c:when test="${code == '00'}"> 공공</c:when>
		<c:when test="${code == '01'}"> 공일</c:when>
		<c:when test="${code == '02'}"> 공이</c:when>
		<c:when test="${code == '03'}"> 공삼</c:when>
		<c:otherwise>else</c:otherwise>
	</c:choose>

	<h2>core foreach : 반복문</h2>
	<%-- 사용자 리스트 1페이지 조회 --%>
	<%
		UserServiceInf userService = new UserService();
	
		PageVO pageVo = new PageVO();
		pageVo.setPage(1);
		pageVo.setPageSize(10);
		Map<String, Object> resultMap = userService.selectUserPageList(pageVo);
		request.setAttribute("userList",resultMap.get("userList"));
	%>

	<%-- 
		<c:set var="user" value="usrList"/> 의 값	
		foreach => items: loop를 돌 대상 
	 --%>
	<table>
		<tr>
			<th>번호</th>
			<th>사용자 아이디</th>
			<th>사용자 이름</th>
			<th>생일</th>
		</tr>
		<c:forEach items="${userList}"  var="user">
			<tr class="userClick">
				<td>${user.rnum}</td>
				<td>${user.userId}</td>
				<td>${user.name}</td>
				<td>${user.birth}</td>
			</tr>
		</c:forEach>
	</table>
	
	<h2>core foreach index loop</h2>
	<%-- 일반 for문 처럼 사용 속성 -> begin 시작값 end-> 끝 값 va=> 변수 설정 --% step =>i의 인텍스 증가/감소 규칙> --%>
	<c:forEach begin="0" end="10"  var="i" step="3">
	${i} &nbsp;&nbsp;&nbsp;
	</c:forEach>
	
	<h2>core foreach : map</h2>
	<%
		Map<String, String> strMap = new HashMap<String, String>();
		strMap.put("ranger1", "brown");
		strMap.put("ranger2", "sally");
		strMap.put("ranger3", "cony");
		strMap.put("ranger4", "moon");
		
		request.setAttribute("strMap", strMap);
	%>
	<c:forEach items="${strMap}" var="map">
		${map.key} / ${map.value} <br>
	
	</c:forEach>

</body>
</html>