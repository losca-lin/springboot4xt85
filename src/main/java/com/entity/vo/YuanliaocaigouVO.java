package com.entity.vo;

import com.entity.YuanliaocaigouEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 原料采购
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2023-05-21 14:56:17
 */
public class YuanliaocaigouVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 原料编号
	 */
	
	private String yuanliaobianhao;
		
	/**
	 * 原料类别
	 */
	
	private String yuanliaoleibie;
		
	/**
	 * 原料名称
	 */
	
	private String yuanliaomingcheng;
		
	/**
	 * 原料规格
	 */
	
	private String yuanliaoguige;
		
	/**
	 * 供应厂商
	 */
	
	private String gongyingchangshang;
		
	/**
	 * 采购价格
	 */
	
	private String caigoujiage;
		
	/**
	 * 采购人员
	 */
	
	private String caigourenyuan;
		
	/**
	 * 采购时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date caigoushijian;
		
	/**
	 * 是否支付
	 */
	
	private String ispay;
				
	
	/**
	 * 设置：原料编号
	 */
	 
	public void setYuanliaobianhao(String yuanliaobianhao) {
		this.yuanliaobianhao = yuanliaobianhao;
	}
	
	/**
	 * 获取：原料编号
	 */
	public String getYuanliaobianhao() {
		return yuanliaobianhao;
	}
				
	
	/**
	 * 设置：原料类别
	 */
	 
	public void setYuanliaoleibie(String yuanliaoleibie) {
		this.yuanliaoleibie = yuanliaoleibie;
	}
	
	/**
	 * 获取：原料类别
	 */
	public String getYuanliaoleibie() {
		return yuanliaoleibie;
	}
				
	
	/**
	 * 设置：原料名称
	 */
	 
	public void setYuanliaomingcheng(String yuanliaomingcheng) {
		this.yuanliaomingcheng = yuanliaomingcheng;
	}
	
	/**
	 * 获取：原料名称
	 */
	public String getYuanliaomingcheng() {
		return yuanliaomingcheng;
	}
				
	
	/**
	 * 设置：原料规格
	 */
	 
	public void setYuanliaoguige(String yuanliaoguige) {
		this.yuanliaoguige = yuanliaoguige;
	}
	
	/**
	 * 获取：原料规格
	 */
	public String getYuanliaoguige() {
		return yuanliaoguige;
	}
				
	
	/**
	 * 设置：供应厂商
	 */
	 
	public void setGongyingchangshang(String gongyingchangshang) {
		this.gongyingchangshang = gongyingchangshang;
	}
	
	/**
	 * 获取：供应厂商
	 */
	public String getGongyingchangshang() {
		return gongyingchangshang;
	}
				
	
	/**
	 * 设置：采购价格
	 */
	 
	public void setCaigoujiage(String caigoujiage) {
		this.caigoujiage = caigoujiage;
	}
	
	/**
	 * 获取：采购价格
	 */
	public String getCaigoujiage() {
		return caigoujiage;
	}
				
	
	/**
	 * 设置：采购人员
	 */
	 
	public void setCaigourenyuan(String caigourenyuan) {
		this.caigourenyuan = caigourenyuan;
	}
	
	/**
	 * 获取：采购人员
	 */
	public String getCaigourenyuan() {
		return caigourenyuan;
	}
				
	
	/**
	 * 设置：采购时间
	 */
	 
	public void setCaigoushijian(Date caigoushijian) {
		this.caigoushijian = caigoushijian;
	}
	
	/**
	 * 获取：采购时间
	 */
	public Date getCaigoushijian() {
		return caigoushijian;
	}
				
	
	/**
	 * 设置：是否支付
	 */
	 
	public void setIspay(String ispay) {
		this.ispay = ispay;
	}
	
	/**
	 * 获取：是否支付
	 */
	public String getIspay() {
		return ispay;
	}
			
}
