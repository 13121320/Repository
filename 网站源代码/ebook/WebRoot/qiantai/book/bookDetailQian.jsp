<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %> 
<%
	String path = request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />
		
		<link href="<%=path %>/css/layout.css" type="text/css" rel="stylesheet" />
		
	    <script type="text/javascript" src="<%=path %>/js/popup.js"></script>
    
	    <script type='text/javascript' src='<%=path %>/dwr/interface/loginService.js'></script>
	    <script type='text/javascript' src='<%=path %>/dwr/engine.js'></script>
	    <script type='text/javascript' src='<%=path %>/dwr/util.js'></script>
    
    <script type="text/javascript">
        
        
        var fujianPath="";
        var fujianYuashiMing="";
        var dianquan="";
        
        function book_shidu(id)
        {
            var url="<%=path %>/book?type=book_shidu&id="+id;
            var pop=new Popup({ contentType:1,isReloadOnClose:false,width:600,height:400});
            pop.setContent("contentUrl",url);
            pop.setContent("title","操作窗口");
            pop.build();
            pop.show();
        }
        
        function book_xiazai(fujianPath1,fujianYuashiMing1,dianquan1)
        {
            fujianPath=fujianPath1;
            fujianYuashiMing=fujianYuashiMing1;
            dianquan=dianquan1;
            
            <c:if test="${sessionScope.user==null}">
                  alert("请先登录");
            </c:if>
            
            <c:if test="${sessionScope.user!=null}">
                if(confirm("您确定要下载吗？需要"+dianquan+"点券"))
                {
                    loginService.getdianquan("${sessionScope.user.id}",callback1111);
                }
            </c:if>
        }
        
        function down1()
        {
            var url="<%=path %>/updown/updown.jsp?fujianPath="+fujianPath+"&fujianYuashiMing="+fujianYuashiMing;
            url=encodeURI(url); 
            url=encodeURI(url); 
            window.open(url,"_self");
            
            loginService.jianqudianquan("${sessionScope.user.id}",dianquan);
            
        }
        
        function callback1111(data)
		{
		    if(data>=dianquan)
		    {   
		        down1()
		    }
		    if(data<dianquan)
		    { 
		        alert("目前你拥有的点券是"+data+"，请充值后重新下载");
		    }
		}
    </script>
	</head>

	<body>
		<jsp:include flush="true" page="/qiantai/inc/incTop.jsp"></jsp:include>
		<div class="page_row">
			<div class="page_main_msg left">
			     <div class="left_row">
		              <div class="list pic_news">
		  	                <div class="list_bar">&nbsp;电子书详细信息</div>
						  	<div class="ctitle ctitle1">名称：${requestScope.book.name }</div>
							<div class="ctitleinfo">发布时间：${requestScope.book.fabushijian }</div>
							<div class="pbox">类别：${requestScope.book.catelog.name }</div>
							<div class="pbox">作者：${requestScope.book.zuozhe }</div>
							<div class="pbox">大小(KB)：${requestScope.book.daxiao }</div>
							<div class="pbox">下载所需点券：${requestScope.book.dianquan }</div>
							<div class="pbox">内容简介：<c:out value="${requestScope.book.jieshao }" escapeXml="false"></c:out></div>
							<div class="pbox">
							    <img src="<%=path %>/img/shidu.jpg" onclick="book_shidu('${requestScope.book.id }')"/>
								<a href="#" onclick="book_xiazai('${book.fujian}','${book.fujianYuanshiming}',${book.dianquan})"><img src="<%=path %>/img/down.jpg"/></a>
                            </div>
		              </div>
				      <div style="clear:both;"></div>
			     </div>
			</div>
			
			<div class="page_other_msg right">
				<jsp:include flush="true" page="/qiantai/inc/incRight.jsp"></jsp:include>
			</div>
		</div>
		
		<div class="foot">
		   <jsp:include flush="true" page="/qiantai/inc/incFoot.jsp"></jsp:include>
	    </div>
	</body>
</html>
