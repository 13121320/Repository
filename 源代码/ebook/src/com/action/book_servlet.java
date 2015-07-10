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
import com.orm.Tbook;
import com.orm.Tgonggao;
import com.orm.Tuser;
import com.service.liuService;

public class book_servlet extends HttpServlet
{
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException 
	{
        
		String type=req.getParameter("type");
		
		
		if(type.endsWith("bookAdd"))
		{
			bookAdd(req, res);
		}
		if(type.endsWith("bookMana_fufei"))
		{
			bookMana_fufei(req, res);
		}
		if(type.endsWith("bookMana_mianfei"))
		{
			bookMana_mianfei(req, res);
		}
		if(type.endsWith("bookDel"))
		{
			bookDel(req, res);
		}
		if(type.endsWith("bookDetail"))
		{
			bookDetail(req, res);
		}
		
		if(type.endsWith("bookDetailQian"))
		{
			bookDetailQian(req, res);
		}
		if(type.endsWith("book_shidu"))
		{
			book_shidu(req, res);
		}
		
		if(type.endsWith("bookByCatelog"))
		{
			bookByCatelog(req, res);
		}
		if(type.endsWith("bookAll_mianfei"))
		{
			bookAll_mianfei(req, res);
		}
		if(type.endsWith("bookSearch"))
		{
			bookSearch(req, res);
		}
	}
	
	
	public void bookAdd(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		
		int catelog_id=Integer.parseInt(req.getParameter("catelog_id"));
		String name=req.getParameter("name");
		String zuozhe=req.getParameter("zuozhe");
		String shifoumianfei=req.getParameter("shifoumianfei");
		int dianquan=(req.getParameter("shifoumianfei").equals("是")==true?0:Integer.parseInt(req.getParameter("dianquan"))); 
		String daxiao=req.getParameter("daxiao");
		String jieshao=req.getParameter("jieshao");
		String mianfeizhangjie=req.getParameter("mianfeizhangjie");
		String fujian=req.getParameter("fujian");
		String fujianYuanshiming=req.getParameter("fujianYuanshiming");
		String fabushijian=new Date().toLocaleString();
		String del="no";
		
		String sql="insert into t_book values(?,?,?,?,?,?,?,?,?,?,?,?)";
		Object[] params={catelog_id,name,zuozhe,shifoumianfei,dianquan,daxiao,jieshao,mianfeizhangjie,fujian,fujianYuanshiming,fabushijian,del};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		mydb.closed();
		
		req.setAttribute("msg", "操作成功");
		String targetURL = "/common/msg.jsp";
		dispatch(targetURL, req, res);
        
	}
	
	
	public void bookDel(HttpServletRequest req,HttpServletResponse res)
	{
		String id=req.getParameter("id");
		
		String sql="update t_book set del='yes' where id=?";
		Object[] params={id};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		mydb.closed();
		
		req.setAttribute("msg", "操作成功");
		String targetURL = "/common/msg.jsp";
		dispatch(targetURL, req, res);
		
		
	}

	public void bookMana_fufei(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		List bookList=new ArrayList();
		String sql="select * from t_book where del='no' and shifoumianfei='否' order by catelog_id";
		Object[] params={};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				Tbook book=new Tbook();
				
				book.setId(rs.getInt("id"));
				book.setCatelog_id(rs.getInt("catelog_id"));
				book.setName(rs.getString("name"));
				book.setZuozhe(rs.getString("zuozhe"));
				book.setShifoumianfei(rs.getString("shifoumianfei"));
				book.setDianquan(rs.getInt("dianquan"));
				book.setDaxiao(rs.getString("daxiao"));
				
				book.setJieshao(rs.getString("jieshao"));
				book.setMianfeizhangjie(rs.getString("mianfeizhangjie"));
				book.setFujian(rs.getString("fujian"));
				book.setFujianYuanshiming(rs.getString("fujianYuanshiming"));
				book.setFabushijian(rs.getString("fabushijian"));
				book.setDel(rs.getString("del"));
				
				book.setCatelog(liuService.getCatelog(rs.getInt("catelog_id")));
				
				bookList.add(book);
		    }
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		
		req.setAttribute("bookList", bookList);
		req.getRequestDispatcher("admin/book/bookMana_fufei.jsp").forward(req, res);
	}
	
	
	public void bookMana_mianfei(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		List bookList=new ArrayList();
		String sql="select * from t_book where del='no' and shifoumianfei='是' order by catelog_id";
		Object[] params={};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				Tbook book=new Tbook();
				
				book.setId(rs.getInt("id"));
				book.setCatelog_id(rs.getInt("catelog_id"));
				book.setName(rs.getString("name"));
				book.setZuozhe(rs.getString("zuozhe"));
				book.setShifoumianfei(rs.getString("shifoumianfei"));
				book.setDianquan(rs.getInt("dianquan"));
				book.setDaxiao(rs.getString("daxiao"));
				
				book.setJieshao(rs.getString("jieshao"));
				book.setMianfeizhangjie(rs.getString("mianfeizhangjie"));
				book.setFujian(rs.getString("fujian"));
				book.setFujianYuanshiming(rs.getString("fujianYuanshiming"));
				book.setFabushijian(rs.getString("fabushijian"));
				book.setDel(rs.getString("del"));
				
				book.setCatelog(liuService.getCatelog(rs.getInt("catelog_id")));
				
				bookList.add(book);
		    }
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		
		req.setAttribute("bookList", bookList);
		req.getRequestDispatcher("admin/book/bookMana_mianfei.jsp").forward(req, res);
	}
	
	
	public void bookDetail(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		String id=req.getParameter("id");
		Tbook book=new Tbook();
		
		String sql="select * from t_book where id=?";
		Object[] params={id};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			rs.next();
			
			book.setId(rs.getInt("id"));
			book.setCatelog_id(rs.getInt("catelog_id"));
			book.setName(rs.getString("name"));
			book.setZuozhe(rs.getString("zuozhe"));
			book.setShifoumianfei(rs.getString("shifoumianfei"));
			book.setDianquan(rs.getInt("dianquan"));
			book.setDaxiao(rs.getString("daxiao"));
			
			book.setJieshao(rs.getString("jieshao"));
			book.setMianfeizhangjie(rs.getString("mianfeizhangjie"));
			book.setFujian(rs.getString("fujian"));
			book.setFujianYuanshiming(rs.getString("fujianYuanshiming"));
			book.setFabushijian(rs.getString("fabushijian"));
			book.setDel(rs.getString("del"));
			
			book.setCatelog(liuService.getCatelog(rs.getInt("catelog_id")));
			
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		
		req.setAttribute("book", book);
		req.getRequestDispatcher("admin/book/bookDetail.jsp").forward(req, res);
	}
	
	public void bookDetailQian(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		String id=req.getParameter("id");
		Tbook book=new Tbook();
		
		String sql="select * from t_book where id=?";
		Object[] params={id};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			rs.next();
			
			book.setId(rs.getInt("id"));
			book.setCatelog_id(rs.getInt("catelog_id"));
			book.setName(rs.getString("name"));
			book.setZuozhe(rs.getString("zuozhe"));
			book.setShifoumianfei(rs.getString("shifoumianfei"));
			book.setDianquan(rs.getInt("dianquan"));
			book.setDaxiao(rs.getString("daxiao"));
			
			book.setJieshao(rs.getString("jieshao"));
			book.setMianfeizhangjie(rs.getString("mianfeizhangjie"));
			book.setFujian(rs.getString("fujian"));
			book.setFujianYuanshiming(rs.getString("fujianYuanshiming"));
			book.setFabushijian(rs.getString("fabushijian"));
			book.setDel(rs.getString("del"));
			
			book.setCatelog(liuService.getCatelog(rs.getInt("catelog_id")));
			
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		
		req.setAttribute("book", book);
		req.getRequestDispatcher("/qiantai/book/bookDetailQian.jsp").forward(req, res);
	}
	
	
	public void book_shidu(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		String id=req.getParameter("id");
		Tbook book=new Tbook();
		
		String sql="select * from t_book where id=?";
		Object[] params={id};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			rs.next();
			
			book.setId(rs.getInt("id"));
			book.setCatelog_id(rs.getInt("catelog_id"));
			book.setName(rs.getString("name"));
			book.setZuozhe(rs.getString("zuozhe"));
			book.setShifoumianfei(rs.getString("shifoumianfei"));
			book.setDianquan(rs.getInt("dianquan"));
			book.setDaxiao(rs.getString("daxiao"));
			
			book.setJieshao(rs.getString("jieshao"));
			book.setMianfeizhangjie(rs.getString("mianfeizhangjie"));
			book.setFujian(rs.getString("fujian"));
			book.setFujianYuanshiming(rs.getString("fujianYuanshiming"));
			book.setFabushijian(rs.getString("fabushijian"));
			book.setDel(rs.getString("del"));
			
			book.setCatelog(liuService.getCatelog(rs.getInt("catelog_id")));
			
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		
		req.setAttribute("book", book);
		req.getRequestDispatcher("/qiantai/book/book_shidu.jsp").forward(req, res);
	}
	
	
	
	public void bookByCatelog(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		List bookList=new ArrayList();
		String sql="select * from t_book where del='no' and shifoumianfei='否' and catelog_id=?";
		Object[] params={Integer.parseInt(req.getParameter("catelog_id"))};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				Tbook book=new Tbook();
				
				book.setId(rs.getInt("id"));
				book.setCatelog_id(rs.getInt("catelog_id"));
				book.setName(rs.getString("name"));
				book.setZuozhe(rs.getString("zuozhe"));
				book.setShifoumianfei(rs.getString("shifoumianfei"));
				book.setDianquan(rs.getInt("dianquan"));
				book.setDaxiao(rs.getString("daxiao"));
				
				book.setJieshao(rs.getString("jieshao"));
				book.setMianfeizhangjie(rs.getString("mianfeizhangjie"));
				book.setFujian(rs.getString("fujian"));
				book.setFujianYuanshiming(rs.getString("fujianYuanshiming"));
				book.setFabushijian(rs.getString("fabushijian"));
				book.setDel(rs.getString("del"));
				
				book.setCatelog(liuService.getCatelog(rs.getInt("catelog_id")));
				
				bookList.add(book);
		    }
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		
		req.setAttribute("bookList", bookList);
		req.getRequestDispatcher("qiantai/book/bookByCatelog.jsp").forward(req, res);
	}
	
	
	public void bookAll_mianfei(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		List bookList=new ArrayList();
		String sql="select * from t_book where del='no' and shifoumianfei='是'";
		Object[] params={};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				Tbook book=new Tbook();
				
				book.setId(rs.getInt("id"));
				book.setCatelog_id(rs.getInt("catelog_id"));
				book.setName(rs.getString("name"));
				book.setZuozhe(rs.getString("zuozhe"));
				book.setShifoumianfei(rs.getString("shifoumianfei"));
				book.setDianquan(rs.getInt("dianquan"));
				book.setDaxiao(rs.getString("daxiao"));
				
				book.setJieshao(rs.getString("jieshao"));
				book.setMianfeizhangjie(rs.getString("mianfeizhangjie"));
				book.setFujian(rs.getString("fujian"));
				book.setFujianYuanshiming(rs.getString("fujianYuanshiming"));
				book.setFabushijian(rs.getString("fabushijian"));
				book.setDel(rs.getString("del"));
				
				book.setCatelog(liuService.getCatelog(rs.getInt("catelog_id")));
				
				bookList.add(book);
		    }
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		
		req.setAttribute("bookList", bookList);
		req.getRequestDispatcher("qiantai/book/bookAll_mianfei.jsp").forward(req, res);
	}
	
	
	
	public void bookSearch(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		List bookList=new ArrayList();
		String sql="select * from t_book where del='no' and name like '%"+req.getParameter("name").trim()+"%'"+" and zuozhe like '%"+req.getParameter("zuozhe").trim()+"%'";
		System.out.println(sql+"^^^^^");
		Object[] params={};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				Tbook book=new Tbook();
				
				book.setId(rs.getInt("id"));
				book.setCatelog_id(rs.getInt("catelog_id"));
				book.setName(rs.getString("name"));
				book.setShifoumianfei(rs.getString("shifoumianfei"));
				book.setDianquan(rs.getInt("dianquan"));
				book.setDaxiao(rs.getString("daxiao"));
				
				book.setJieshao(rs.getString("jieshao"));
				book.setMianfeizhangjie(rs.getString("mianfeizhangjie"));
				book.setFujian(rs.getString("fujian"));
				book.setFujianYuanshiming(rs.getString("fujianYuanshiming"));
				book.setFabushijian(rs.getString("fabushijian"));
				book.setDel(rs.getString("del"));
				
				book.setCatelog(liuService.getCatelog(rs.getInt("catelog_id")));
				
				bookList.add(book);
		    }
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		
		req.setAttribute("bookList", bookList);
		req.getRequestDispatcher("qiantai/book/bookSearch.jsp").forward(req, res);
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
