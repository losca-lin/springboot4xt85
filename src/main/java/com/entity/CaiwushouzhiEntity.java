package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 财务收支
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2023-05-21 14:56:17
 */
@TableName("caiwushouzhi")
public class CaiwushouzhiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public CaiwushouzhiEntity() {
		
	}
	
	public CaiwushouzhiEntity(T t) {
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
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date dengjiriqi;
	
	/**
	 * 财务账号
	 */
					
	private String caiwuzhanghao;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：收入类型
	 */
	public void setShouruleixing(String shouruleixing) {
		this.shouruleixing = shouruleixing;
	}
	/**
	 * 获取：收入类型
	 */
	public String getShouruleixing() {
		return shouruleixing;
	}
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
