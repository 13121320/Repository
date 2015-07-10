package com.orm;

import java.util.List;

public class Tcatelog
{
	private int id;
	private String name;
	private String jieshao;
	private String del;
	
	private List tuxiangList;
	
	public String getDel()
	{
		return del;
	}
	public void setDel(String del)
	{
		this.del = del;
	}
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getJieshao()
	{
		return jieshao;
	}
	public void setJieshao(String jieshao)
	{
		this.jieshao = jieshao;
	}
	
	public List getTuxiangList()
	{
		return tuxiangList;
	}
	public void setTuxiangList(List tuxiangList)
	{
		this.tuxiangList = tuxiangList;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}

}
