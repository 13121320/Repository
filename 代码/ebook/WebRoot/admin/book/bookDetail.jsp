<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %> 
<%
String path = request.getContextPath();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  
  <body>
        <table align="center">
           <tr>
             <td>
                 介绍：
             </td>
          </tr>
          <tr>
             <td>
                  <c:out value="${requestScope.book.jieshao}" escapeXml="false"></c:out>
             </td>
          </tr>
      </table>
      <br/><br/>
      <table align="center">
           <tr>
             <td>
                 免费阅读章节：
             </td>
          </tr>
          <tr>
             <td>
                  <c:out value="${requestScope.book.mianfeizhangjie}" escapeXml="false"></c:out>
             </td>
          </tr>
  </body>
</html>
