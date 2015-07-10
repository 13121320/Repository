package com.action;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.DB;
import com.orm.TAdmin;
import com.orm.Tuser;

public class user_servlet extends HttpServlet
{
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException 
	{
        String type=req.getParameter("type");
		
		
		if(type.endsWith("userReg"))
		{
			userReg(req, res);
		}
		if(type.endsWith("userLogout"))
		{
			userLogout(req, res);
		}
		if(type.endsWith("userEdit"))
		{
			userEdit(req, res);
		}
		if(type.endsWith("userMana"))
		{
			userMana(req, res);
		}
		if(type.endsWith("userDel"))
		{
			userDel(req, res);
		}
		if(type.endsWith("userDetail"))
		{
			userDetail(req, res);
		}
	}
	
	
	public void userReg(HttpServletRequest req,HttpServletResponse res)
	{
		String id=String.valueOf(new Date().getTime());
		String loginname=req.getParameter("loginname");
		String loginpw=req.getParameter("loginpw");
		String name=req.getParameter("name");
		String sex=req.getParameter("sex");
		String age=req.getParameter("age");
		String address=req.getParameter("address");
		String tel=req.getParameter("tel");
		String email=req.getParameter("email");
		String qq=req.getParameter("qq");
		int dianquan=0;
		String del="no";
		
		String sql="insert into t_user values(?,?,?,?,?,?,?,?,?,?,?,?)";
		Object[] params={id,loginname,loginpw,name,sex,age,address,tel,email,qq,dianquan,del};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		mydb.closed();
		
        String targetURL = "/common/add_success.jsp";
		dispatch(targetURL, req, res);
	}
	
	
	
	public void userLogout(HttpServletRequest req,HttpServletResponse res)
	{
		req.getSession().setAttribute("user", null);
		String targetURL = "/qiantai/default.jsp";
		dispatch(targetURL, req, res);		
	}
	
	public void userEdit(HttpServletRequest req,HttpServletResponse res)
	{
		String id=req.getParameter("id");
		String loginname=req.getParameter("loginname");
		String loginpw=req.getParameter("loginpw");
		String name=req.getParameter("name");
		String sex=req.getParameter("sex");
		String age=req.getParameter("age");
		String address=req.getParameter("address");
		String tel=req.getParameter("tel");
		String email=req.getParameter("email");
		String qq=req.getParameter("qq");
		
		String sql="update t_user set loginpw=?,name=?,sex=?,age=?,address=?,tel=?,email=?,qq=? where id=?";
		Object[] params={loginpw,name,sex,age,address,tel,email,qq,id};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		mydb.closed();
		
		String targetURL = "/common/add_success.jsp";
		dispatch(targetURL, req, res);
	}
	
	
	public void userDel(HttpServletRequest req,HttpServletResponse res)
	{
		String id=req.getParameter("id");
		
		String sql="update t_user set del='yes' where id=?";
		Object[] params={id};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		mydb.closed();
		
		req.setAttribute("message", "²Ù×÷³É¹¦");
		req.setAttribute("path", "user?type=userMana");
		
        String targetURL = "/common/success.jsp";
		dispatch(targetURL, req, res);
	}

	public void userMana(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		List userList=new ArrayList();
		String sql="select * from t_user where del='no'";
		Object[] params={};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				Tuser user=new Tuser();
				
				user.setId(rs.getString("id"));
				user.setLoginname(rs.getString("loginname"));
				user.setLoginpw(rs.getString("loginpw"));
				user.setLoginpw(rs.getString("loginpw"));
				user.setName(rs.getString("name"));
				user.setSex(rs.getString("sex"));
				user.setAge(rs.getString("age"));
				user.setAddress(rs.getString("address"));
				user.setTel(rs.getString("tel"));
				user.setEmail(rs.getString("email"));
				user.setQq(rs.getString("qq"));
				user.setDianquan(rs.getInt("dianquan"));
				
				userList.add(user);
		    }
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		
		req.setAttribute("userList", userList);
		req.getRequestDispatcher("admin/user/userMana.jsp").forward(req, res);
	}
	
	
	
	public void userDetail(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		List userList=new ArrayList();
		String sql="select * from t_user where id=?";
		Object[] params={req.getParameter("id")};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				Tuser user=new Tuser();
				
				user.setId(rs.getString("id"));
				user.setLoginname(rs.getString("loginname"));
				user.setLoginpw(rs.getString("loginpw"));
				user.setLoginpw(rs.getString("loginpw"));
				user.setName(rs.getString("name"));
				user.setSex(rs.getString("sex"));
				user.setAge(rs.getString("age"));
				user.setAddress(rs.getString("address"));
				user.setTel(rs.getString("tel"));
				user.setEmail(rs.getString("email"));
				user.setQq(rs.getString("qq"));
				user.setDianquan(rs.getInt("dianquan"));
				
				userList.add(user);
		    }
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		
		req.setAttribute("userList", userList);
		req.getRequestDispatcher("admin/user/userDetail.jsp").forward(req, res);
	}
	
	public void dispatch(String targetURI,HttpServletRequest request,HttpServletResponse response) 
	{
		RequestDispatcher dispatch = getServletContext().getRequestDispatcher(targetURI);
		try 
		{
		    dispatch.forward(request, response);
		    return;
		} 
		catch (ServletException e) 
		{
                    e.printStackTrace();
		} 
		catch (IOException e) 
		{
			
		    e.printStackTrace();
		}
	}
	public void init(ServletConfig config) throws ServletException 
	{
		super.init(config);
	}
	
	public void destroy() 
	{
		
	}
}
