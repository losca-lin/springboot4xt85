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
 * 财务支出
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2023-05-21 14:56:17
 */
@TableName("caiwuzhichu")
public class CaiwuzhichuEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public CaiwuzhichuEntity() {

	}

	public CaiwuzhichuEntity(T t) {
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

	public Date getAddtime() {
		return addtime;
	}

	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}
}
