package com.entity.view;

import com.entity.YuanliaoleibieEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 原料类别
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-05-21 14:56:17
 */
@TableName("yuanliaoleibie")
public class YuanliaoleibieView  extends YuanliaoleibieEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public YuanliaoleibieView(){
	}
 
 	public YuanliaoleibieView(YuanliaoleibieEntity yuanliaoleibieEntity){
 	try {
			BeanUtils.copyProperties(this, yuanliaoleibieEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
