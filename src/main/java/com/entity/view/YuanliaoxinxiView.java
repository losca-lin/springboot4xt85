package com.entity.view;

import com.baomidou.mybatisplus.annotations.TableName;
import com.entity.ChanpinxinxiEntity;
import com.entity.YuanliaoxinxiEntity;
import org.apache.commons.beanutils.BeanUtils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;


/**
 * 原料信息
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-05-21 14:56:17
 */
@TableName("yuanliaoxinxi")
public class YuanliaoxinxiView extends YuanliaoxinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public YuanliaoxinxiView(){
	}

 	public YuanliaoxinxiView(ChanpinxinxiEntity chanpinxinxiEntity){
 	try {
			BeanUtils.copyProperties(this, chanpinxinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
