package com.entity.vo;

import java.io.Serializable;


/**
 * 原料信息
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2023-05-21 14:56:17
 */
public class YuanliaoxinxiVO implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
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
}
