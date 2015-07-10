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
        <div class="left_row">
		    <div class="list">
		        <div class="list_bar">用户登录</div>
		        <div class="list_content">
		            <div id="div"> 
						<jsp:include flush="true" page="/qiantai/userlogin/userlogin.jsp"></jsp:include> 
			        </div>
			    </div>
		    </div>
		</div>
        <div class="left_row">
		    <div class="list">
		        <div class="list_bar">网站公告</div>
		        <div class="list_content">
		            <div id="div"> 
						<table width="100%" cellpadding="5" cellspacing="5">
						     <c:forEach items="${sessionScope.gonggaoList}" var="gonggao">
						          <tr>
						             <td align="left">
						                 <img src="<%=path %>/img/head-mark3.gif" align="middle" class="img-vm" border="0"/>
						                 <a href="<%=path %>/gonggao?type=gonggaoDetailQian&id=${gonggao.id}" title="">${gonggao.title}</a>
						             </td>
						          </tr>
						     </c:forEach>
					   </table> 
			        </div>
			    </div>
		    </div>
		</div>
		<div class="left_row">
		    <div class="list">
		        <div class="list_bar">网站日历</div>
		        <div class="list_content">
		            <div id="div"> 
						<jsp:include flush="true" page="/qiantai/rili/rili.jsp"></jsp:include> 
			        </div>
			    </div>
		    </div>
		</div>
  </body>
</html>
