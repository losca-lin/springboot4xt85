package com.entity.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;


/**
 * 财务支出
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2023-05-21 14:56:17
 */
public class CaiwuzhichuVO implements Serializable {
	private static final long serialVersionUID = 1L;

	 			

		
	/**
	 * 财务支出
	 */
	
	private Integer caiwuzhichu;
		
	/**
	 * 支出类型
	 */
	
	private String zhichuleixing;
		

		
	/**
	 * 支出内容
	 */
	
	private String zhichuneirong;
		
	/**
	 * 财务结余
	 */
	
	private Integer caiwujieyu;

	public Integer getCaiwuzhichu() {
		return caiwuzhichu;
	}

	public void setCaiwuzhichu(Integer caiwuzhichu) {
		this.caiwuzhichu = caiwuzhichu;
	}

	public String getZhichuleixing() {
		return zhichuleixing;
	}

	public void setZhichuleixing(String zhichuleixing) {
		this.zhichuleixing = zhichuleixing;
	}

	public String getZhichuneirong() {
		return zhichuneirong;
	}

	public void setZhichuneirong(String zhichuneirong) {
		this.zhichuneirong = zhichuneirong;
	}

	public Integer getCaiwujieyu() {
		return caiwujieyu;
	}

	public void setCaiwujieyu(Integer caiwujieyu) {
		this.caiwujieyu = caiwujieyu;
	}

	public Date getDengjiriqi() {
		return dengjiriqi;
	}

	public void setDengjiriqi(Date dengjiriqi) {
		this.dengjiriqi = dengjiriqi;
	}

	/**
	 * 登记日期
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date dengjiriqi;
		


			
}
