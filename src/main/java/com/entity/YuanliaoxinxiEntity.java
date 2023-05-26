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
 * 原料信息
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2023-05-21 14:56:17
 */
@TableName("yuanliaoxinxi")
public class YuanliaoxinxiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public YuanliaoxinxiEntity() {

	}

	public YuanliaoxinxiEntity(T t) {
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
	 * 原料编号
	 */
					
	private String yuanliaobianhao;
	
	/**
	 * 原料名称
	 */
					
	private String yuanliaomingcheng;
	
	/**
	 * 原料图片
	 */
					
	private String yuanliaotupian;
	
	/**
	 * 原料类型
	 */
					
	private String yuanliaoleibie;
	
	/**
	 * 价格
	 */
					
	private Float jiage;
	
	/**
	 * 数量
	 */
					
	private Integer shuliang;
	
	/**
	 * 原料详情
	 */
					
	private String yuanliaoxiangqing;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getYuanliaobianhao() {
		return yuanliaobianhao;
	}

	public void setYuanliaobianhao(String yuanliaobianhao) {
		this.yuanliaobianhao = yuanliaobianhao;
	}

	public String getYuanliaomingcheng() {
		return yuanliaomingcheng;
	}

	public void setYuanliaomingcheng(String yuanliaomingcheng) {
		this.yuanliaomingcheng = yuanliaomingcheng;
	}

	public String getYuanliaotupian() {
		return yuanliaotupian;
	}

	public void setYuanliaotupian(String yuanliaotupian) {
		this.yuanliaotupian = yuanliaotupian;
	}

	public String getYuanliaoleibie() {
		return yuanliaoleibie;
	}

	public void setYuanliaoleibie(String yuanliaoleibie) {
		this.yuanliaoleibie = yuanliaoleibie;
	}

	public Float getJiage() {
		return jiage;
	}

	public void setJiage(Float jiage) {
		this.jiage = jiage;
	}

	public Integer getShuliang() {
		return shuliang;
	}

	public void setShuliang(Integer shuliang) {
		this.shuliang = shuliang;
	}

	public String getYuanliaoxiangqing() {
		return yuanliaoxiangqing;
	}

	public void setYuanliaoxiangqing(String yuanliaoxiangqing) {
		this.yuanliaoxiangqing = yuanliaoxiangqing;
	}

	public Date getAddtime() {
		return addtime;
	}

	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}
}
