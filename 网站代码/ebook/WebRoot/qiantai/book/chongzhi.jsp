<%@ page language="java" pageEncoding="UTF-8"%>
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
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="<%=path %>/css/base.css" />
  </head>
  
  <body>
      <form action="<%=path %>/chongzhi?type=chongzhiAdd" name="f" method="post">
	         <table width="98%" align="center" border="0" cellpadding="9" cellspacing="9">
					<tr align='center'>
					    <td width="30%" bgcolor="#FFFFFF" align="left">
					          充值金额(1元=10点券)：
					    </td>
					    <td width="70%" bgcolor="#FFFFFF" align="left">
					          <input type="text" name="jine" value="1" onpropertychange="onchange1(this.value)" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')">
					    </td>
					</tr>
					<tr align='center'>
					    <td width="30%" bgcolor="#FFFFFF" align="left">
					          付款方式：
					    </td>
					    <td width="70%" bgcolor="#FFFFFF" align="left">
					          <table>
					             <tr>
					                <td>
					                    <input type="radio" name="fukuanfangshi" value="网上银行" border="0" checked="checked">网上银行(中行：6013 8210 0063 2131 453)
					                </td>
					             </tr>
					             <tr>
					                <td>
					                    <input type="radio" name="fukuanfangshi" value="支付宝" border="0">支付宝(banzheng888@yahoo.cn 户名：陈发举)
					                </td>
					             </tr>
					          </table>
					    </td>
					</tr>
					<tr align='center'>
					    <td width="30%" bgcolor="#FFFFFF" align="right">
					        &nbsp;
					    </td>
					    <td width="70%" bgcolor="#FFFFFF" align="left">
					       <input type="hidden" name="user_id" value="${sessionScope.user.id }">
					       <input type="submit" value="提交" onclick="check()"/>&nbsp; 
					       <input type="reset" value="重置"/>&nbsp;
					    </td>
					</tr>
			  </table>
	     </form>
  </body>
</html>
