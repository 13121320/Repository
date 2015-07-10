<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <style type="text/css">
        .Header {background: url(<%=path %>/img/banner.jpg) #d10e00 repeat-x left top; height: 70px;width: 966px;}
        .HeaderTop {margin: 0px auto;}
    </style>
     <script type="text/javascript" src="<%=path %>/js/popup.js"></script>
     <script type="text/javascript">
         function admin()
         {
            var url="<%=path %>/login.jsp";
            window.open(url,"_blank");
         } 
         function myXinxi()
         {
            <c:if test="${sessionScope.user==null}">
                  alert("请先登录");
            </c:if>
            
            <c:if test="${sessionScope.user!=null}">
                var url="<%=path %>/qiantai/userinfo/userXinxi.jsp";
                var n="";
                var w="480px";
                var h="500px";
                var s="resizable:no;help:no;status:no;scroll:yes";
			    openWin(url,n,w,h,s);
            </c:if>
         } 
         
         function liuyanAll()
         {
            <c:if test="${sessionScope.user==null}">
                  alert("请先登录");
            </c:if>
            
            <c:if test="${sessionScope.user!=null}">
                var url="<%=path %>/liuyan?type=liuyanAll";
				var targetWinName="newWin";
				var features="width="+screen.width-200+" ,height="+screen.height-150+" ,toolbar=no, top=0, left=0, menubar=no, scrollbars=yes, resizable=no,location=no, status=no"
				var new_win=window.open(url,targetWinName,features);
            </c:if>
         } 
         
         function reg()
         {
                var url="<%=path %>/qiantai/userinfo/userReg.jsp";
                var n="";
                var w="480px";
                var h="500px";
                var s="resizable:no;help:no;status:no;scroll:yes";
			    openWin(url,n,w,h,s);
         }
         
         function dianquanchongzhi()
         {
            <c:if test="${sessionScope.user==null}">
                  alert("请先登录");
            </c:if>
            
            <c:if test="${sessionScope.user!=null}">
                var url="<%=path %>/qiantai/book/chongzhi.jsp";
                var pop=new Popup({ contentType:1,isReloadOnClose:false,width:600,height:300});
	            pop.setContent("contentUrl",url);
	            pop.setContent("title","操作窗口");
	            pop.build();
	            pop.show();
            </c:if>
         } 
     </script>
  </head>
  
  <body>
        <div class="Header HeaderTop">
			<br/>
			<font style="font-size: 40px;color: white;font-weight: bolder;display: block;text-align: center;">基于JSP的电子书下载系统的设计实现</font>
		</div>
		<div class="topmenu cbody1">
			<ul>
				<li class="thisclass"><A href="<%=path %>/qiantai/default.jsp">网站首页</A></li>
				<c:forEach items="${sessionScope.catelogList}" var="catelog">
			    <li class="thisclass"><A href="<%=path %>/book?type=bookByCatelog&catelog_id=${catelog.id}">${catelog.name}</A></li>  
			    </c:forEach>
			    <li class="thisclass"><A href="<%=path %>/book?type=bookAll_mianfei" style="color: yellow">免费电子书</A></li>
			    <li class="thisclass"><a href="#" onclick="reg()">用户注册</A></li>
			    <li class="thisclass"><a href="#" onclick="myXinxi()">我的信息</A></li>
			    <li class="thisclass"><a href="#" onclick="dianquanchongzhi()">点券充值</A></li>
			    <li class="thisclass"><a href="#" onclick="liuyanAll()">留言板</A></li>
			</ul>
		</div>
		<form id="searchForm" action="<%=path %>/book?type=bookSearch" method="post">
			<div class="topsearch">
				<div class="title"></div>
				<div id="page_search_left" style="width: 300px;">
					名称：<input onfocus="this.value=''" class="inputText" id="" size="11" name="name" type="text"/>
					&nbsp;&nbsp;&nbsp;
					作者：<input onfocus="this.value=''" class="inputText" id="" size="11" name="zuozhe" type="text"/>
				</div>
				<div id="page_search_btn">
					<input type="submit" value="搜索">
				</div>
				<div id="page_search_right">
					<script>
						<!--var day="";
						var month="";
						var ampm="";
						var ampmhour="";
						var myweekday="";
						var year="";
						mydate=new Date();
						myweekday=mydate.getDay();
						mymonth=mydate.getMonth()+1;
						myday= mydate.getDate();
						year= mydate.getFullYear();
						if(myweekday == 0)
						weekday=" 星期日 ";
						else if(myweekday == 1)
						weekday=" 星期一 ";
						else if(myweekday == 2)
						weekday=" 星期二 ";
						else if(myweekday == 3)
						weekday=" 星期三 ";
						else if(myweekday == 4)
						weekday=" 星期四 ";
						else if(myweekday == 5)
						weekday=" 星期五 ";
						else if(myweekday == 6)
						weekday=" 星期六 ";
						document.write(year+"年"+mymonth+"月"+myday+"日 "+weekday);
						//-->
					</script>
				</div>
				<div style="clear: both"></div>
			</div>
		</form>
  </body>
</html>
