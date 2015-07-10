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
import com.orm.Tchongzhi;
import com.orm.Tgonggao;
import com.orm.Tuser;
import com.service.liuService;

public class chongzhi_servlet extends HttpServlet
{
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException 
	{
        String type=req.getParameter("type");
		
		
		if(type.endsWith("chongzhiAdd"))
		{
			chongzhiAdd(req, res);
		}
		if(type.endsWith("chongzhiMana"))
		{
			chongzhiMana(req, res);
		}
		if(type.endsWith("chongzhiDel"))
		{
			chongzhiDel(req, res);
		}
		if(type.endsWith("chongzhiQueren"))
		{
			chongzhiQueren(req, res);
		}
	}
	
	
	public void chongzhiAdd(HttpServletRequest req,HttpServletResponse res)
	{
		
		String user_id=req.getParameter("user_id");
		int jine=Integer.parseInt(req.getParameter("jine"));
		String fukuanfangshi=req.getParameter("fukuanfangshi");
		String shijian=new Date().toLocaleString();
		String zhuangtai="a";
		
		String sql="insert into t_chongzhi values(?,?,?,?,?)";
		Object[] params={user_id,jine,fukuanfangshi,shijian,zhuangtai};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		mydb.closed();
		
		req.setAttribute("msg", "申请成功。等待管理员审核");
		String targetURL = "/common/msg.jsp";
		dispatch(targetURL, req, res);
        
	}
	
	
	public void chongzhiMana(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		List chongzhiList=new ArrayList();
		String sql="select * from t_chongzhi order by zhuangtai";
		Object[] params={};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				Tchongzhi chongzhi=new Tchongzhi();
				
				chongzhi.setId(rs.getInt("id"));
				chongzhi.setUser_id(rs.getString("user_id"));
				chongzhi.setJine(rs.getInt("jine"));
				chongzhi.setFukuanfangshi(rs.getString("fukuanfangshi"));
				chongzhi.setShijian(rs.getString("shijian"));
				chongzhi.setZhuangtai(rs.getString("zhuangtai"));
				
				chongzhiList.add(chongzhi);
		    }
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		
		req.setAttribute("chongzhiList", chongzhiList);
		req.getRequestDispatcher("admin/chongzhi/chongzhiMana.jsp").forward(req, res);
	}
	
	
	
	public void chongzhiDel(HttpServletRequest req,HttpServletResponse res)
	{
		String id=req.getParameter("id");
		
		String sql="delete from t_chongzhi where id=?";
		Object[] params={id};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		mydb.closed();
		
		req.setAttribute("message", "操作成功");
		req.setAttribute("path", "chongzhi?type=chongzhiMana");
		
        String targetURL = "/common/success.jsp";
		dispatch(targetURL, req, res);
	}

	
	public void chongzhiQueren(HttpServletRequest req,HttpServletResponse res)
	{
        int id=Integer.parseInt(req.getParameter("id"));
        int jine=Integer.parseInt(req.getParameter("jine"));
        String user_id=req.getParameter("user_id");
		
		String sql="update t_chongzhi set zhuangtai='b' where id=?";//a:待审核，b审核通过
		Object[] params={id};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		mydb.closed();
		
		
		liuService.geiyonghuchongzhi(user_id, jine);
		
		req.setAttribute("msg", "确认完毕");
		String targetURL = "/common/msg.jsp";
		dispatch(targetURL, req, res);
		
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
