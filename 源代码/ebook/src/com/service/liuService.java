package com.service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dao.DB;
import com.orm.Tbook;
import com.orm.Tcatelog;

public class liuService
{
	public static String getUserName(String id)
	{
		String name="";
		
		String sql="select * from t_user where id=?";
		Object[] params={id};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			rs.next();
			name=rs.getString("loginname");
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		return name;
	}
	
	public static void geiyonghuchongzhi(String id,int jine)
	{
		String sql="update t_user set dianquan=dianquan+? where id=?";
		Object[] params={jine * 10,id};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		mydb.closed();
	}
	
	
	public static Tcatelog getCatelog(int id)
	{
        Tcatelog catelog=new Tcatelog();
		
        String sql="select * from t_catelog where id=?";
		Object[] params={id};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			rs.next();
			catelog.setId(rs.getInt("id"));
			catelog.setName(rs.getString("name"));
			catelog.setJieshao(rs.getString("jieshao"));
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		return catelog;
	}
	

	public static List getCatelogList()
	{
		List catelogList=new ArrayList();
		String sql="select * from t_catelog where del='no'";
		Object[] params={};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				Tcatelog catelog=new Tcatelog();
				catelog.setId(rs.getInt("id"));
				catelog.setName(rs.getString("name"));
				catelog.setJieshao(rs.getString("jieshao"));
				catelogList.add(catelog);
		    }
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		return catelogList;
	}
	
	
	
	public static List getBookList()
	{
		List bookList=new ArrayList();
		String sql="select * from t_book where del='no' and shifoumianfei='·ñ' order by catelog_id";
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
			
		return bookList;
	}
	
}
