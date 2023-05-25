package com.entity.view;

import com.entity.ChanpinxiaoshouzhangmuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 产品销售账目
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-05-21 14:56:17
 */
@TableName("chanpinxiaoshouzhangmu")
public class ChanpinxiaoshouzhangmuView  extends ChanpinxiaoshouzhangmuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ChanpinxiaoshouzhangmuView(){
	}
 
 	public ChanpinxiaoshouzhangmuView(ChanpinxiaoshouzhangmuEntity chanpinxiaoshouzhangmuEntity){
 	try {
			BeanUtils.copyProperties(this, chanpinxiaoshouzhangmuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
