package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;


/**
 * 财务收入
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2023-05-21 14:56:17
 */
@TableName("caiwushouru")
public class CaiwushouruEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public CaiwushouruEntity() {

	}

	public CaiwushouruEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 收入类型
	 */
					
	private String shouruleixing;
	
	/**
	 * 收入内容
	 */
					
	private String shouruneirong;
	


	
	/**
	 * 财务收入
	 */
					
	private Float caiwushouru;

	
	/**
	 * 财务结余
	 */
					
	private Integer caiwujieyu;
	
	/**
	 * 登记日期
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date dengjiriqi;

	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getShouruleixing() {
		return shouruleixing;
	}

	public void setShouruleixing(String shouruleixing) {
		this.shouruleixing = shouruleixing;
	}

	public String getShouruneirong() {
		return shouruneirong;
	}

	public void setShouruneirong(String shouruneirong) {
		this.shouruneirong = shouruneirong;
	}

	public Float getCaiwushouru() {
		return caiwushouru;
	}

	public void setCaiwushouru(Float caiwushouru) {
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

	public Date getAddtime() {
		return addtime;
	}

	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}
}
