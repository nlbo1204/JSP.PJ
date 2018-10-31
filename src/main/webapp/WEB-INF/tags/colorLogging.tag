
<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="length" type="java.lang.Integer" required="false"%>
<%@ attribute name="color" type="java.lang.String" required="true"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
length : ${length}
<br>
<script src="/js/jquery-3.3.1.min.js"></script>
<%-- length 속성이 없을 경우  length 기본값 20으로 표현 --%>
<c:set var="length" value="${length==null?20:length }"></c:set>

<font color="${color }"><c:forEach begin="1" end="${length}">
		<c:out value="=" />
	</c:forEach> logging <c:forEach begin="1" end="${length}">
		<c:out value="=" />
	</c:forEach> <br> <c:forEach begin="1" end="${length}" var="i">
		<c:out value="${i}" />
		<br>
	</c:forEach> </font>





<!-- 
	length : 5 
======logging=====
 -->