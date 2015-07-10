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
		    function chongzhiQueren(id,user_id,jine)
		    {
		        var url="<%=path %>/chongzhi?type=chongzhiQueren&id="+id+"&user_id="+user_id+"&jine="+jine;
		        var pop=new Popup({ contentType:1,isReloadOnClose:false,width:200,height:120});
	            pop.setContent("contentUrl",url);
	            pop.setContent("title","提示窗口");
	            pop.build();
	            pop.show();
		    }	
		    
		    function userDetail(id)
		    {
		        var url="<%=path %>/user?type=userDetail&id="+id;
		        var pop=new Popup({ contentType:1,isReloadOnClose:false,width:700,height:200});
	            pop.setContent("contentUrl",url);
	            pop.setContent("title","提示窗口");
	            pop.build();
	            pop.show();
		    }	
       </script>
	</head>

	<body leftmargin="2" topmargin="2" background='<%=path %>/img/allbg.gif'>
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr bgcolor="#E7E7E7">
					<td height="14" colspan="43" background="<%=path %>/img/tbg.gif">&nbsp;点券充值管理&nbsp;</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
					<td width="16%">会员</td>
					<td width="16%">充值金额</td>
					<td width="16%">付款方式</td>
					<td width="16%">充值时间</td>
					<td width="16%">状态</td>
					<td width="16%">操作</td>
		        </tr>	
				<c:forEach items="${requestScope.chongzhiList}" var="chongzhi">
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td bgcolor="#FFFFFF" align="center">
						 <a style="color: red" class="pn-loperator" href="#" onclick="userDetail(${chongzhi.user_id})">查看会员信息</a>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						 ${chongzhi.jine}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						 ${chongzhi.fukuanfangshi}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						 ${chongzhi.shijian}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						 <c:if test="${chongzhi.zhuangtai=='a'}">
						        待审核
						        &nbsp;&nbsp;&nbsp;
						       <a style="color: red" class="pn-loperator" href="#" onclick="chongzhiQueren(${chongzhi.id},${chongzhi.user_id},${chongzhi.jine})">确认</a>
						 </c:if>
						 <c:if test="${chongzhi.zhuangtai=='b'}">已审核</c:if>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						 <a class="pn-loperator" href="<%=path %>/chongzhi?type=chongzhiDel&id=${chongzhi.id}">删除</a>
					</td>
				</tr>
				</c:forEach>
			</table>
	</body>
</html>
