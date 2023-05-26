package com.entity.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;


/**
 * 财务收入
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2023-05-21 14:56:17
 */
public class CaiwushouruVO implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 收入内容
	 */
	
	private String shouruneirong;
		

		

		
	/**
	 * 财务收入
	 */
	
	private Integer caiwushouru;
		

		
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

	public String getShouruneirong() {
		return shouruneirong;
	}

	public void setShouruneirong(String shouruneirong) {
		this.shouruneirong = shouruneirong;
	}

	public Integer getCaiwushouru() {
		return caiwushouru;
	}

	public void setCaiwushouru(Integer caiwushouru) {
		this.caiwushouru = caiwushouru;
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
}
