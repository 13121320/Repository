package com.orm;

public class Tbook
{
	private int id;
	private int catelog_id;
	private String name;
	private String zuozhe;
	private String shifoumianfei;
	private int dianquan;
	private String daxiao;
	
	private String jieshao;
	private String mianfeizhangjie;
	private String fujian;
	private String fujianYuanshiming;
	private String fabushijian;
	private String del;
	
	private Tcatelog catelog;
	
	public int getCatelog_id()
	{
		return catelog_id;
	}
	public void setCatelog_id(int catelog_id)
	{
		this.catelog_id = catelog_id;
	}
	public String getDaxiao()
	{
		return daxiao;
	}
	public void setDaxiao(String daxiao)
	{
		this.daxiao = daxiao;
	}
	
	public String getDel()
	{
		return del;
	}
	
	public String getZuozhe()
	{
		return zuozhe;
	}
	public void setZuozhe(String zuozhe)
	{
		this.zuozhe = zuozhe;
	}
	public String getFabushijian()
	{
		return fabushijian;
	}
	public void setFabushijian(String fabushijian)
	{
		this.fabushijian = fabushijian;
	}
	public void setDel(String del)
	{
		this.del = del;
	}
	public int getId()
	{
		return id;
	}
	
	public String getShifoumianfei()
	{
		return shifoumianfei;
	}
	public void setShifoumianfei(String shifoumianfei)
	{
		this.shifoumianfei = shifoumianfei;
	}
	public int getDianquan()
	{
		return dianquan;
	}
	public void setDianquan(int dianquan)
	{
		this.dianquan = dianquan;
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
	
	public Tcatelog getCatelog()
	{
		return catelog;
	}
	public void setCatelog(Tcatelog catelog)
	{
		this.catelog = catelog;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getFujian()
	{
		return fujian;
	}
	public void setFujian(String fujian)
	{
		this.fujian = fujian;
	}
	public String getFujianYuanshiming()
	{
		return fujianYuanshiming;
	}
	public void setFujianYuanshiming(String fujianYuanshiming)
	{
		this.fujianYuanshiming = fujianYuanshiming;
	}
	public String getMianfeizhangjie()
	{
		return mianfeizhangjie;
	}
	public void setMianfeizhangjie(String mianfeizhangjie)
	{
		this.mianfeizhangjie = mianfeizhangjie;
	}
	
	

}
