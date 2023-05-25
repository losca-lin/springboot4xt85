package com.entity.vo;

import com.entity.CaiwushouzhiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 财务收支
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2023-05-21 14:56:17
 */
public class CaiwushouzhiVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 收入内容
	 */
	
	private String shouruneirong;
		
	/**
	 * 财务支出
	 */
	
	private Integer caiwuzhichu;
		
	/**
	 * 支出类型
	 */
	
	private String zhichuleixing;
		
	/**
	 * 财务收入
	 */
	
	private Integer caiwushouru;
		
	/**
	 * 支出内容
	 */
	
	private String zhichuneirong;
		
	/**
	 * 财务结余
	 */
	
	private Integer caiwujieyu;
		
	/**
	 * 登记日期
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date dengjiriqi;
		
	/**
	 * 财务账号
	 */
	
	private String caiwuzhanghao;
				
	
	/**
	 * 设置：收入内容
	 */
	 
	public void setShouruneirong(String shouruneirong) {
		this.shouruneirong = shouruneirong;
	}
	
	/**
	 * 获取：收入内容
	 */
	public String getShouruneirong() {
		return shouruneirong;
	}
				
	
	/**
	 * 设置：财务支出
	 */
	 
	public void setCaiwuzhichu(Integer caiwuzhichu) {
		this.caiwuzhichu = caiwuzhichu;
	}
	
	/**
	 * 获取：财务支出
	 */
	public Integer getCaiwuzhichu() {
		return caiwuzhichu;
	}
				
	
	/**
	 * 设置：支出类型
	 */
	 
	public void setZhichuleixing(String zhichuleixing) {
		this.zhichuleixing = zhichuleixing;
	}
	
	/**
	 * 获取：支出类型
	 */
	public String getZhichuleixing() {
		return zhichuleixing;
	}
				
	
	/**
	 * 设置：财务收入
	 */
	 
	public void setCaiwushouru(Integer caiwushouru) {
		this.caiwushouru = caiwushouru;
	}
	
	/**
	 * 获取：财务收入
	 */
	public Integer getCaiwushouru() {
		return caiwushouru;
	}
				
	
	/**
	 * 设置：支出内容
	 */
	 
	public void setZhichuneirong(String zhichuneirong) {
		this.zhichuneirong = zhichuneirong;
	}
	
	/**
	 * 获取：支出内容
	 */
	public String getZhichuneirong() {
		return zhichuneirong;
	}
				
	
	/**
	 * 设置：财务结余
	 */
	 
	public void setCaiwujieyu(Integer caiwujieyu) {
		this.caiwujieyu = caiwujieyu;
	}
	
	/**
	 * 获取：财务结余
	 */
	public Integer getCaiwujieyu() {
		return caiwujieyu;
	}
				
	
	/**
	 * 设置：登记日期
	 */
	 
	public void setDengjiriqi(Date dengjiriqi) {
		this.dengjiriqi = dengjiriqi;
	}
	
	/**
	 * 获取：登记日期
	 */
	public Date getDengjiriqi() {
		return dengjiriqi;
	}
				
	
	/**
	 * 设置：财务账号
	 */
	 
	public void setCaiwuzhanghao(String caiwuzhanghao) {
		this.caiwuzhanghao = caiwuzhanghao;
	}
	
	/**
	 * 获取：财务账号
	 */
	public String getCaiwuzhanghao() {
		return caiwuzhanghao;
	}
			
}
