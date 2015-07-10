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

		<link rel="stylesheet" type="text/css" href="<%=path %>/css/base.css" />
		<script language="JavaScript" src="<%=path %>/js/public.js" type="text/javascript"></script>
		<script type="text/javascript" src="<%=path %>/js/popup_shuaxin.js"></script>
        <script language="javascript">
           function bookDel(id)
           {
               if(confirm('您确定删除吗？'))
               {
                    var url="<%=path %>/book?type=bookDel&id="+id;
                    var pop=new Popup({ contentType:1,isReloadOnClose:false,width:200,height:120});
		            pop.setContent("contentUrl",url);
		            pop.setContent("title","操作窗口");
		            pop.build();
		            pop.show();
               }
           }
           
           function bookAdd()
           {
                 var url="<%=path %>/admin/book/bookAdd.jsp";
                 //var n="";
                 //var w="480px";
                 //var h="500px";
                 //var s="resizable:no;help:no;status:no;scroll:yes";
				 //openWin(url,n,w,h,s);
				 window.location.href=url;
           }
           function down1(fujianPath,fujianYuashiMing)
           {
               var url="<%=path %>/updown/updown.jsp?fujianPath="+fujianPath+"&fujianYuashiMing="+fujianYuashiMing;
		       url=encodeURI(url); 
               url=encodeURI(url); 
               window.open(url,"_self");
           }
           
           function bookDetail(id)
           {
                 var url="<%=path %>/book?type=bookDetail&id="+id;
                 var n="";
                 var w="600px";
                 var h="500px";
                 var s="resizable:no;help:no;status:no;scroll:yes";
				 openWin(url,n,w,h,s);
           }
       </script>
	</head>

	<body leftmargin="2" topmargin="2" background='<%=path %>/img/allbg.gif'>
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr bgcolor="#E7E7E7">
					<td height="14" colspan="14" background="<%=path %>/img/tbg.gif">&nbsp;电子书管理&nbsp;</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
					<td width="10%">类别</td>
					<td width="10%">名称</td>
					<td width="10%">作者</td>
					<td width="10%">是否免费</td>
					<td width="10%">大小(KB)</td>
					<td width="10%">下载点券</td>
					<td width="10%">介绍及免费阅读内容</td>
					<td width="10%">操作</td>
		        </tr>	
				<c:forEach items="${requestScope.bookList}" var="book">
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td bgcolor="#FFFFFF" align="center">
						${book.catelog.name}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${book.name}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${book.zuozhe}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${book.shifoumianfei}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${book.daxiao}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${book.dianquan}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<a href="#" onclick="bookDetail(${book.id})" class="pn-loperator">介绍及阅读内容</a>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<a href="#" onclick="bookDel(${book.id})">删除</a>
						&nbsp;&nbsp;
						<a href="#" onclick="down1('${book.fujian}','${book.fujianYuanshiming}')" style="font-size: 10px;color: red">附件下载</a>
					</td>
				</tr>
				</c:forEach>
			</table>
			
			<table width='98%'  border='0'style="margin-top:8px;margin-left: 5px;">
			  <tr>
			    <td>
			      <input type="button" value="添加" style="width: 80px;" onclick="bookAdd()" />
			    </td>
			  </tr>
		    </table>
	</body>
</html>
