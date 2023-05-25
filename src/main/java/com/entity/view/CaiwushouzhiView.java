package com.entity.view;

import com.entity.CaiwushouzhiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 财务收支
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-05-21 14:56:17
 */
@TableName("caiwushouzhi")
public class CaiwushouzhiView  extends CaiwushouzhiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public CaiwushouzhiView(){
	}
 
 	public CaiwushouzhiView(CaiwushouzhiEntity caiwushouzhiEntity){
 	try {
			BeanUtils.copyProperties(this, caiwushouzhiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
